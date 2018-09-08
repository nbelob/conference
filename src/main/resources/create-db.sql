CREATE TABLE account (
  username VARCHAR(16) UNIQUE NOT NULL,
  password VARCHAR(25) NOT NULL,
);

CREATE TABLE message (
  username VARCHAR(16) NOT NULL,
  text VARCHAR(140) NOT NULL,
  time TIMESTAMP NOT NULL,
);