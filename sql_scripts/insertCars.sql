insert into engines (name) values ('Бензиновый двигатель 1.4');
insert into engines (name) values ('Бензиновый двигатель 1.6');
insert into engines (name) values ('Бензиновый двигатель 1.8');
insert into engines (name) values ('Бензиновый двигатель 2.0');
insert into engines (name) values ('Бензиновый двигатель 2.4');
insert into engines (name) values ('Дизельный двигатель 2.0');

insert into car_bodies (name) values ('Седан');
insert into car_bodies (name) values ('Универсал');
insert into car_bodies (name) values ('Хэтчбэк');
insert into car_bodies (name) values ('Пикап');

insert into transmissions (name) values ('Механическая 4 ступ');
insert into transmissions (name) values ('Механическая 5 ступ');
insert into transmissions (name) values ('Механическая 6 ступ');
insert into transmissions (name) values ('Автоматическая 4 ступ');
insert into transmissions (name) values ('Автоматическая 5 ступ');
insert into transmissions (name) values ('Автоматическая 6 ступ');

insert into cars (name,engines_id,car_bodies_id,transmissions_id) values ('Ford Focus', 2,1,5);
insert into cars (name,engines_id,car_bodies_id,transmissions_id) values ('Toyota camry',5,1,6);
insert into cars (name,engines_id,car_bodies_id,transmissions_id) values ('Kia rio',1,3,2);
insert into cars (name,engines_id,car_bodies_id,transmissions_id) values ('Лада гранта',1,2,2);

