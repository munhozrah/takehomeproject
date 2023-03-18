package com.rafael.takehomeproject.usecases.usercreation;

import java.math.BigInteger;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;

import com.rafael.takehomeproject.domain.users.UserFactory;
import com.rafael.takehomeproject.usecases.usercreation.boundaries.UserDsRequestModel;
import com.rafael.takehomeproject.usecases.usercreation.boundaries.UserInputBoundary;
import com.rafael.takehomeproject.usecases.usercreation.boundaries.UserRegistrationDsGateway;
import com.rafael.takehomeproject.usecases.usercreation.boundaries.UserRequestDTO;
import com.rafael.takehomeproject.usecases.usercreation.boundaries.UserResponseDTO;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Slf4j
@Service
public class UserRegistrationInteractor implements UserInputBoundary{
    private final UserRegistrationDsGateway userDsGateway;
    private final UserFactory userFactory;

    @Override
    public UserResponseDTO create(UserRequestDTO requestModel) throws UserRegistrationException {
        if (userDsGateway.existsByUsername(requestModel.getUsername()))
            throw new UserRegistrationException("User already exists.");
        var user = userFactory.create(requestModel.getUsername(), requestModel.getPassword());
        if (!user.passwordIsValid())
            throw new UserRegistrationException("User password must have more than 16 characters.");
        var now = LocalDateTime.now();
        var userDsModel = new UserDsRequestModel(user.getUsername(), blurStuff(user.getPassword()), now);

        userDsGateway.save(userDsModel);

        return new UserResponseDTO(user.getUsername(), now.format(DateTimeFormatter.ISO_LOCAL_DATE));
    }

    //OK I KNOW IT'S NOT THE BEST PLACE FOR THAT... 
    private String blurStuff(char[] passwd) {
        try {
            var md = MessageDigest.getInstance("SHA-256");
            var passwdBytes = Charset.forName("UTF-8").encode(CharBuffer.wrap(passwd)).array();
            return toHexString(md.digest(passwdBytes));
        } catch(NoSuchAlgorithmException e) {
            log.error("Use something different than SHA-56", e);
            return "Demonstration handling purposes";
        }
    }

    public static String toHexString(byte[] hash) {  
        var number = new BigInteger(1, hash);  
        var hexString = new StringBuilder(number.toString(16));  
        while (hexString.length() < 32)
            hexString.insert(0, '0');  
        return hexString.toString();  
    }
}