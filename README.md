# takehome project

Takehome project for Rafael applying for full-stack engineer. It expose a REST API using spring-MVC and uses H2 database accessing it using Spring-data.

## Requirements

For building and running the application you need:

- [JDK 11+](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://openjdk.org/projects/jdk/11/)

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `de.codecentric.springbootsample.Application` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```

## Architecture

This application uses an Clean Arc inspired structure.

From centric layer:

* Domain: Pojos representing the core domain
* Usecases: Interactors representing use cases. It also contains DTO, requests and response model classes representing it's boundaries
* Adapters: Here we have basically controllers and the data layer (JPA mapping and repositories)
* This project uses a single exception handler class
* Tests are divided according to the layers, domain, usecases, data, controllers
* The application uses Spring-Security to protect the endpoints using basic authentication (it will check the credentials in the database)

## Still pending
* Increase coverage adding tests to the entire domain and usecases
* Add integration tests
* Integrate it with vault and cloud
* Consider changing the security model to integrate with Auth0 or Keycloak
* Consider add auditing using Hibernate Envers
* Add logs and use ELK stack or similar

GOOD LUCK!