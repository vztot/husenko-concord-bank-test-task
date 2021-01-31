# huseno-concord-bank-test-task 
[![Build Status](https://travis-ci.com/vztot/husenko-concord-bank-test-task.svg?branch=master)](https://travis-ci.com/vztot/husenko-concord-bank-test-task)

## Project purpose
This is my solution for Concord Bank [test task](TASK.md) – a simple REST service with AES-256 encryption part and two endpoints:

* JSON POST-request to `/encode`

  REQUEST BODY EXAMPLE:
  ```
  {
      "id": 1
  }
  ```

  RESPONSE BODY EXAMPLE:
  ```
  {
    "fio_encr": "edAuIOGu9ibwrHvtZ/+fYw=="
  }
  ```

* JSON POST-request to `/decode`

  REQUEST BODY EXAMPLE:
  ```
  {
      "fio_encr": "edAuIOGu9ibwrHvtZ/+fYw=="
  }
  ```

  RESPONSE BODY EXAMPLE:
  ```
  {
    "fio": "Test Testov"
  }
  ```
  
## Project Structure
* Java 11.
* Maven.
* H2  (in memory database).
* Spring Boot.
* Lombok.
* Log4j2.
* Travis CI.

## For developer

1. Open the project in your IDE.

2. Use Java SDK 11 or above.

3. Build `rest-service.war` with maven.

4. Add the artifact to Tomcat.

5. For testing download Postman or analogue.

You can find log file in `$TOMCAT_HOME\logs\husenko-rest-service.log`.

## Author

[Oleksandr Husenko](https://www.linkedin.com/in/oleksandr-husenko-6a63a2b3/)
