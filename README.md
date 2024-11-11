# Test task for Java candidate

### How start this application by docker-compose
+ Use `gradle build` or `gradle build -x test` for compile this project
+ Use `docker-compose build` for building.
+ Use `docker-compose up` for starting application

### Description
1. OpenApi Specification is contained in `comparus-test.yaml` file
2. File `src/main/resources/application.yml` contains different connections to databases
3. Unavailable connections is ignored
4. For localhost database connections have to use `host.docker.internal` like host value 

### Use these links for testing application
 - http://localhost:8080/users
 - http://localhost:8080/users?filter=username-us
 - http://localhost:8080/users?order=-name
 - http://localhost:8080/users?propagation=0-10
 - http://localhost:8080/users?
### These links should return 400 error
 - http://localhost:8080/users?filter=username-
 - http://localhost:8080/users?order=username-
 - http://localhost:8080/users?propagation=-0


