# Description of _postgres-users-comparus_ image on docker-hub

## Internal content
- PostgreSQl: 16-alpine
- 4 items of users

## Details of image
 - database: usersdb1
 - user=user1
 - password=root1
 - table: users1
 - fields: ldap_id, ldap_username, ldap_name, ldap_surname

## How create this image
 - `docker build -t maksim2025/postgres-users-comparus:2 .`
 - `docker push maksim2025/postgres-users-comparus:2`

## How can use it
 - `docker run --name postgres-users-container -d -p 5433:5432 maksim2025/postgres-users-comparus:2`

## Log information
 - `docker logs postgres-users-container`