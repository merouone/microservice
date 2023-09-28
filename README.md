# Introduction
Welcome.
This document describes a microservice application, that exposes a Restfull API.

This Rest API can add users to the database.

Accepted users must have a French residence. They must also be adults.

The API can also perform the CRUD operations.

The url of the api is the following.

```shell

localhost:8080/api/v1/user/

```
Additionally, this microservice has a special logging mechanism that can log details of every request and its response also the execution time.


## running the program

To run the program, just execute the MainApp class.
First navigate to the project directory.
```bash
cd microservice
```
Run the following gradle command.
```java
./gradlew bootRun
```
Make sure the http port 8080 is free.

Normally, logs console will be displayed as below, if not error was encountered.  

![Swagger UI](./assets/img/console-log.png)


# Swagger
This microservice comes with a Swagger UI. Thus, it can be easily tested.

When the application is running, the Swagger UI can be accessed via the [link](http://localhost:8080/swagger-ui/index.html).

![Swagger UI](./assets/img/Swagger-UI.png)

# Documentation
The javadoc can be found in the folder ./docs. It describes the different APIs exposed by this application.
It can be rebuilt with using the following commandline.

![javadocs](./assets/img/javadocs.png)

```shell
 javadoc -d "./docs" --source-path "src/main/java" -subpackages com.app.microservice
```
# Unit-Test

Functional and Integration tests can be found in the folder ./src/test




# Postman testing


This microservice was also tested using postman, below is an example of the tested requests.

![Postman tests](./assets/img/postman-screenshot.png)


