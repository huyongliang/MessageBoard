create database MessageBoard;
use MessageBoard;

create table user_t(
	name varchar(20) primary key,
	password varchar(20)
);
create table catagory(
	id int primary key auto_increment,
	dsc varchar(100)
);
drop table message;
create table message(
	id int primary key auto_increment,
	catagoryId int,
	from_ varchar(20),
	content varchar(256),
	time_ datetime,
	foreign  key(catagoryId) references  catagory(id)
);


