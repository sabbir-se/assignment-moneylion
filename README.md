# Spring Boot REST-API Service

Create a simple Rest API which provides a service for storing, updating & retrieving user feature entities

## Requirements

For building and running the application you need:

- [JDK 11](https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html)
- [Maven 3](https://maven.apache.org)
- [Mysql](https://www.mysql.com/downloads/)

## Running the application locally

First, run this command on your Mysql database for creating database:

```
CREATE DATABASE assignment CHARACTER SET utf8 COLLATE utf8_general_ci;
```

Then, change the `application.properties` file :

```
spring.datasource.username=your_db_user_name
spring.datasource.password=your_db_user_password

logging.file = /your_desired_file_location/assignment.log
```

There are several ways to run a Spring Boot application on your local machine.
One way is to execute the `main` method in the `assignment.AssignmentApplication` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```

## Some Endpoints

Here are some endpoints you can call:

#### User feature resource

```
POST: /api/v1/feature
Accept: application/json
Content-Type: application/json

Reqeust Body:
{
    "featureName": "purchase",
    "email": "sabbir@gmail.com",
    "enable": true
}

Response:
{}
```

```
GET: /api/v1/feature?email=sabbir@gmail.com&featureName=purchase
Accept: application/json
Content-Type: application/json

Response:
{
    "canAccess": true
}
```

## Copyright

Released under the Apache License 2.0. See the [LICENSE](https://github.com/codecentric/springboot-sample-app/blob/master/LICENSE) file.
