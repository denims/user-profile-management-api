DROP TABLE IF EXISTS users;

CREATE TABLE users (
  id INT PRIMARY KEY,
  user_name VARCHAR(250) NOT NULL,
  first_name VARCHAR(250),
  last_name VARCHAR(250),
  password VARCHAR(250) NOT NULL
);