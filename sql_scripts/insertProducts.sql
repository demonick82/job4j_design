insert into type (name) values ('колбаса');
insert into type (name) values ('сыр');
insert into type (name) values ('молоко');
insert into type (name) values ('мороженнное');

insert into product (name, type_id,expired_date,price) values ('колбаса вареная',1,date '2021-05-29',350);
insert into product (name, type_id,expired_date,price) values ('колбаса сервелат',1,date '2021-06-10',450);
insert into product (name, type_id,expired_date,price) values ('колбаса кремлевская',1,date '2021-06-13',1200);
insert into product (name, type_id,expired_date,price) values ('Сыр колбасный',2,date '2021-06-11',250);
insert into product (name, type_id,expired_date,price) values ('Сыр ламбер',2,date '2021-06-20',800);
insert into product (name, type_id,expired_date,price) values ('Сыр российский',2,date '2021-05-23',400);
insert into product (name, type_id,expired_date,price) values ('молоко простоквашино',3,date '2021-05-23',80);
insert into product (name, type_id,expired_date,price) values ('Молоко valio',3,date '2021-06-12',120);
insert into product (name, type_id,expired_date,price) values ('мороженное чистая линия кактус',4,date '2021-05-31',80);
insert into product (name, type_id,expired_date,price) values ('мороженное пломбир стаканчик ',4,date '2021-06-15',40);