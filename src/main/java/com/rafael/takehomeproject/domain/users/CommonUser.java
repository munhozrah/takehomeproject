package com.rafael.takehomeproject.domain.users;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CommonUser implements User{
    String username;
    char[] password;
    
    @Override
    public boolean passwordIsValid() {
        return this.password != null && this.password.length >= 16;
    }
}
