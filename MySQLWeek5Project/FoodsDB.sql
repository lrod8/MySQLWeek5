CREATE database if not exists foods;

use foods;

drop table if exists foods;

create table foods (
id int(10) not null auto_increment,
food varchar(25) not null,
primary key(id)
);