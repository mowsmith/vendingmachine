drop database if exists VendingMachineTest;
create database VendingMachineTest;

use VendingMachineTest;

create table Machine (
	id int not null auto_increment,
    `name` varchar(50) not null,
    cost decimal(4,2) not null,
    numberInInventory int not null,
    primary key(id)
);