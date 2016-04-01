DROP TABLE reports IF EXISTS;

CREATE TABLE reports (
  id         		VARCHAR(30) PRIMARY KEY,
  category_id       int,
  name 				VARCHAR(30)
);
