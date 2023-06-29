# Web Lab - Spring Boot
In this lab, we will explore how to develop and test a web service using the Spring Boot framework. We will create a user registration API, where users can register by providing their username and email. We will cover the development of the service using a separate controller and application class.


## Hello Service
Complete the code in `HelloController` to return a greeting message using the provided name. For example Example: If the name is "John" (request to http://localhost:8080/hello/John), the response should be "Hello John".

- add @GetMapping annotation to the method with proper path 
- use @PathVariable annotation to get the name from the URL
- return a string with the greeting message

## User Registration Service
Your task is to develop a user registration API using Spring Boot. In this exercise, you need to complete the code by implementing the missing parts. The API should allow users to register by providing their username and email. Once you complete the code, the API should be able to handle registration requests and store the registered users.


### User Model
Complete the code in `User` class to define the user model. The user model should have the following properties:
- username: unique identifier of the user
- email: email address of the user

### User Repository
Use HashMap to store the registered users. Define a static HashMap in `UserController` class to store the registered users. The key of the HashMap should be the username and the value should be the user object. Complete the code in `UserController` class to implement the following methods:

### Web Service
Complete the code in `UserController` class to implement the following methods:
- `registerUser`: This method should register a new user by adding the user to the HashMap. The method should return the registered user.
- `getUser`: This method should return the user with the given username. If the user does not exist, the method should return null.
- `list`: This method should return a list of all registered users.

### Test the service
You can run the Spring boot application with App class.
test these services using Postman. You can use the following requests to test the service:
- Register a new user: Send a POST request to http://localhost:8080/users/register with the following JSON body:

```json
{
    "username": "john",
    "email": "john@email.com
}
```

- Get a user: Send a GET request to http://localhost:8080/users/{username} where {username} is the username of the user you want to get.

- List all users: Send a GET request to http://localhost:8080/users

## Unit Test
Run the unit tests in `HelloControllerTest` and `UserControllerTest` class to test the service. You can run the tests using the following command:
```
mvn test
```
