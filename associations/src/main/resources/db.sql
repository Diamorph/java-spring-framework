create table customer(
    id int PRIMARY KEY AUTO_INCREMENT,
    name varchar(20)
);

create table phone_number(
    id int PRIMARY KEY AUTO_INCREMENT,
    customer_id int,
    number varchar(20),
    type varchar(20),
    FOREIGN KEY (customer_id) REFERENCES customer(id)
);

select * from customer;

select * from phone_number;



create table programmer(
    id int PRIMARY KEY AUTO_INCREMENT,
    name varchar(20),
    salary int
);

create table project(
    id int PRIMARY KEY AUTO_INCREMENT,
    name varchar(20)
);

create table programmers_projects(
    programmer_id int,
    project_id int,
    FOREIGN KEY (programmer_id) REFERENCES programmer(id),
    FOREIGN KEY (project_id) REFERENCES project(id)
);

select * from programmer;

select * from project;

select * from programmers_projects;

create table person(
    id int PRIMARY KEY AUTO_INCREMENT,
    first_name varchar(20),
    last_name varchar(20),
    age int
);

create table license(
    id int PRIMARY KEY AUTO_INCREMENT,
    type varchar(20),
    valid_from date,
    valid_to date,
    person_id int,
    FOREIGN KEY (person_id) REFERENCES person(id)
);

select * from person;

select * from license;
