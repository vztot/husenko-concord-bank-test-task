DROP TABLE IF EXISTS users;

CREATE TABLE users (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  fio VARCHAR(250) NOT NULL
);

INSERT INTO users(fio) VALUES
  ('Test Testov'),
  ('Akira Kurosawa'),
  ('Oda Nobunaga'),
  ('Hideo Kojima'),
  ('Hayao Miyazaki');
