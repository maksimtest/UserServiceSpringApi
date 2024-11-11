# Description of _mysql-users-container_ image on docker-hub

## Internal content
- Mysql:5.7.34
- 8 items of users

## Details of image
 - database: userservice
 - table: user_table
 - user: myuser
 - password: my123pass
 - fields: user_id, user_username, user_name, user_surname

## How create this image
 - `docker build -t maksim2025/users-mysql:1 .`
 - `docker push maksim2025/users-mysql:1`

## How can use it
 - `docker run --name mysql-users-container -d -p 3307:3306 maksim2025/users-mysql:1`

## Log information
 - `docker logs mysql-users-container`