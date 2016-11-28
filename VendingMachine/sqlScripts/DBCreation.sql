drop database if exists VendingMachine;
create database VendingMachine;

use VendingMachine;

create table Machine (
	id int not null auto_increment,
    `name` varchar(50) not null,
    cost decimal(4,2) not null,
    numberInInventory int not null,
    primary key(id)
);