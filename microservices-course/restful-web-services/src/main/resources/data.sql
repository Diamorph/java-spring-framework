insert into user_details(id, birth_date, name)
values (10001, current_date(), 'Vlad');

insert into user_details(id, birth_date, name)
values (10002, current_date(), 'Jack');

insert into user_details(id, birth_date, name)
values (10003, current_date(), 'John');

insert into post(id, description, user_id)
values(20001, 'Learn Java Spring', 10001);

insert into post(id, description, user_id)
values(20002, 'Learn AWS', 10002);

insert into post(id, description, user_id)
values(20003, 'Learn Java Spring Boot', 10001);

insert into post(id, description, user_id)
values(20004, 'Learn Angular', 10003);