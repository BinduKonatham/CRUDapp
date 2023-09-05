create database crudjdbcdb;
create table login(username varchar(255),password varchar(255));
insert into login(username,password) values ('admin','Admin@123');
select * from login;
drop table product;
create table product(prodId varchar(255),prodName varchar(255),sellingQuantity int,prodCost int,stock int);
select * from product;
insert into login(username,password) values ('agent','Agent@123');
select * from  login;