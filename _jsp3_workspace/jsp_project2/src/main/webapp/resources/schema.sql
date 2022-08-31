create database jspdb;
--2022-08-26 작업
-- user 같은 유저로 사용 => 새로만든 DB권한

create table board(
bno int not null auto_increment,
title varchar(100) not null,
writer varchar(100) not null,
content text,
reg_date datetime default current_timestamp,
primary key(bno));

create table member(
email varchar(100) not null,
pwd varchar(100) not null,
nick_name varchar(100) not null,
reg_at datetime default current_timestamp,
last_login datetime,
primary key(email));