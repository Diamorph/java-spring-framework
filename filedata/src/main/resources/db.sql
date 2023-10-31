create table image(
	id bigint primary key auto_increment,
	name varchar(100) not null,
	data BLOB not null
);

select * from image;

drop table image;