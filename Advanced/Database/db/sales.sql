-- sqlcmd -S .\SQLEXPRESS -E -i sales.sql --

create database sales
go

use sales
go

create table customers(
cust_id varchar(8) primary key,
pwd varchar(8) check(len(pwd) >= 4),
email varchar(24) not null,
credit numeric(8,2) check(credit >= 0))

create table products(
pno int primary key,
price numeric(8,2) not null,
stock int check(stock >= 0))

create table orders(
ord_no int primary key,
ord_date datetime,
cust_id varchar(8) references customers(cust_id),
pno int references products(pno),
qty int check(qty > 0))

create table ord_ctl(
cust_id int,
pno int,
ord_no int)


insert into customers values ('CU101', 'PW101', 'john@doe.com', 5000)
insert into customers values ('CU102', 'PW102', 'jill@smith.net', 6000)
insert into customers values ('CU103', 'PW103', 'jack@smith.net', 7000)
insert into customers values ('CU104', 'PW104', 'jane@doe.com', 8000)

insert into products values (101, 350, 10)
insert into products values (102, 975, 20)
insert into products values (103, 845,30)
insert into products values (104, 1025, 40)
insert into products values (105, 700, 50)

insert into orders values(1001, '2001-01-12', 'CU102', 101, 5)
insert into orders values(1002, '2001-01-25', 'CU103', 102, 10)
insert into orders values(1003, '2001-02-08', 'CU102', 102, 12)
insert into orders values(1004, '2001-03-21', 'CU101', 103, 3)
insert into orders values(1005, '2001-03-19', 'CU103', 104, 15)
insert into orders values(1006, '2001-04-11', 'CU104', 105, 12)

insert into ord_ctl values(104, 105, 1006)

go


create view ord_view as
select ord_no, ord_date, cust_id, orders.pno, qty, price*qty as amt
from orders, products
where orders.pno = products.pno

go


create procedure place_order(
@customer varchar(8),
@product integer,
@quantity integer,
@ordid integer output) as
begin tran
update ord_ctl set ord_no=ord_no+1
select @ordid = ord_no from ord_ctl
insert into orders values(@ordid, getdate(), @customer, @product, @quantity)
if @@error = 0 commit tran
else
begin
rollback tran
set @ordid = 0
end

go

create procedure check_customer(@customer varchar(8), @password varchar(8))
as
select count(*) as result from customers where cust_id=@customer and pwd=@password

go
