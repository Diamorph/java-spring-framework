create table BankAccount(
	accountNumber int,
	firstName varchar(25),
	lastName varchar(25),
	balance double
);

insert into BankAccount values (1, 'Scrooge', 'McDuck', 15000.50);
insert into BankAccount values (2, 'Tom', 'Cat', 200.50);
insert into BankAccount values (3, 'Jerry', 'Mouse', 12000.20);

select * from BankAccount;