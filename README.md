# Test task for Java candidate

### How start this application by docker-compose
+ Use `gradle build` or `gradle build -x test` for compile this project
+ Use `docker-compose build` for building.
+ Use `docker-compose up` for start application

### Use one of this command for building jar file
* gradle build 
* gradle build -x test
  (exclude test compiling process)

### Use these commands for docker-compose images
* docker-compose build
* docker-compose up

### Use these links for testing application
http://localhost:8080/users


### Description
1. application.yml file contains different connections to databases
2. Unavailable connections is ignored
3. For localhost database connection have to use 'host.docker.internal' like host value 