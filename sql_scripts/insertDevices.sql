insert into people(name) values ('Дмитрий');
insert into people(name) values ('Сергей');
insert into people(name) values ('Борис');
insert into people(name) values ('Ольга');
insert into people(name) values ('Катя');

insert into devices(name,price) values ('Смартфон xiaomi Mi10', 25500);
insert into devices(name,price) values ('Смартфон Apple Iphone', 85000);
insert into devices(name,price) values ('Смартфон Samsung galaxy s21', 63000);
insert into devices(name,price) values ('Ноутбук ASUS ZenBook 13', 63300);
insert into devices(name,price) values ('Смартфон HTC Wildfire E', 6685);
insert into devices(name,price) values ('Ноутбук ASUS', 24600);


insert into devices_people (device_id,people_id) values (3,1);
insert into devices_people (device_id,people_id) values (4,1);
insert into devices_people (device_id,people_id) values (2,2);
insert into devices_people (device_id,people_id) values (4,2);
insert into devices_people (device_id,people_id) values (1,3);
insert into devices_people (device_id,people_id) values (4,2);
insert into devices_people (device_id,people_id) values (5,4);
insert into devices_people (device_id,people_id) values (5,5);