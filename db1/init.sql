\c usersdb1;

CREATE TABLE users1 (
                               ldap_id       varchar NOT NULL PRIMARY KEY,
                               ldap_username varchar,
                               ldap_name     varchar,
                               ldap_surname  varchar
);

ALTER TABLE users1 OWNER TO user1;

INSERT INTO users1 (ldap_id, ldap_username, ldap_name, ldap_surname)
VALUES
    ('ldap_id1', 'ldap_username1', 'ldap_name1', 'ldap_surname1'),
    ('ldap_id2', 'ldap_username2', 'ldap_name2', 'ldap_surname2'),
    ('ldap_id3', 'ldap_username3', 'ldap_name3', 'ldap_surname3'),
    ('ldap_id4', 'ldap_username4', 'ldap_name4', 'ldap_surname4');