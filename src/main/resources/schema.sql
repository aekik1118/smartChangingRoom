DROP TABLE IF EXISTS USER_TBL;
DROP SEQUENCE IF EXISTS seq_user;

CREATE SEQUENCE seq_user START 1;

CREATE TABLE USER_TBL(
  id integer not null DEFAULT nextval('seq_user'),
  name varchar(100) not null,
  constraint pk_user primary key (id)
);