# Test task for Java candidate

### How start this application by docker-compose
1. Download this project to local machine
2. Actualize `src/main/resources/application.yml` file for database connections 
3. Actualize `docker-compose.yml` file (actual database information)
4. Use `gradle build` or `gradle build -x test` for compile this project
5. Use `docker-compose build` for building.
6. Use `docker-compose up` for starting application
7. Check application by bellow links

### Description
1. OpenApi Specification is contained in `comparus-test.yaml` file
2. File `src/main/resources/application.yml` contains different connections to databases
3. Unavailable connections is ignored
4. For localhost database connections have to use `host.docker.internal` like host value 
5. This project has been tested with PostgreSQL, MySQl and OracleSQL databases.
6. Application starts on 8080 port.

### Use these links for testing application
 - http://localhost:8080/users
 - http://localhost:8080/users?filter=username-us
 - http://localhost:8080/users?order=-name
 - http://localhost:8080/users?propagation=0-10
 - http://localhost:8080/users?filter=username-us&order=-name&propagation=0-10
### These links should return 400 error
 - http://localhost:8080/users?filter=username-
 - http://localhost:8080/users?order=username-
 - http://localhost:8080/users?propagation=-0

### If you want to add new database to project
1. Add db information to `src/main/resources/application.yml` file
2. Add db information to `docker-compose.yml` file
