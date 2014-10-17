create database messageBoard;
use messageBoard;

create table user_t(
	 id int primary key auto_increment,
	name varchar(20) ,
	password varchar(20)
);
create table catagory(
	id int primary key auto_increment,
	dsc varchar(100)
);
create table message(
	id int primary key auto_increment,
	catagoryId int,
	from_ varchar(20),
	to_ varchar(20),
	content varchar(256),
	time_ datetime
);


