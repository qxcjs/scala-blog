drop table book if exists;
create table book (
  id int generated by default as identity(start with 1) not null primary key,
  title varchar not null,
  price int not null,
  author varchar not null
);
