CREATE TABLE user_table (
    user_id       varchar(250) PRIMARY KEY,
    user_username varchar(250),
    user_name     varchar(250),
    user_surname  varchar(250)
) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

INSERT INTO user_table (user_id, user_username, user_name, user_surname)
VALUES
    ('example-user-1', 'user-1', 'User-1', 'Userenko-1'),
    ('example-user-2', 'user-2', 'User-2', 'Userenko-2'),
    ('example-user-3', 'user-3', 'User-3', 'Userenko-3'),
    ('example-user-4', 'user-4', 'User-4', 'Userenko-4'),
    ('example-user-5', 'user-5', 'User-5', 'Userenko-5'),
    ('example-user-6', 'user-6', 'User-6', 'Userenko-6'),
    ('example-user-7', 'user-7', 'User-7', 'Userenko-7'),
    ('example-user-8', 'user-8', 'User-8', 'Userenko-8');