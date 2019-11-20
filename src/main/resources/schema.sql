DROP TABLE IF EXISTS CLOTHES_TBL;
DROP SEQUENCE IF EXISTS seq_clothes;

DROP TABLE IF EXISTS USER_TBL;
DROP SEQUENCE IF EXISTS seq_user;

CREATE SEQUENCE seq_user START 1;

CREATE SEQUENCE seq_clothes START 1;

CREATE TABLE USER_TBL(
  id integer not null DEFAULT nextval('seq_user'),
  name varchar(100) not null,
  constraint pk_user primary key (id)
);

CREATE TABLE CLOTHES_TBL(
  id integer not null default nextval('seq_clothes'),
  user_id integer REFERENCES USER_TBL(id) ON DELETE CASCADE,
  name varchar(100) not null,
  image_path varchar(400),
  status varchar(100) not null,
  using_count integer not null default 0,
  register_at TIMESTAMP default now(),
  recent_usage_at TIMESTAMP default now(),
  constraint pk_clothes primary key (id)
)

