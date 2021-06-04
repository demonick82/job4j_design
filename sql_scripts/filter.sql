--1. Написать запрос получение всех продуктов с типом "СЫР"
select p.name as Наименование,
t.name as Категория from product as p join type t on p.type_id=t.id
where t.name='сыр';

--2. Написать запрос получения всех продуктов, у кого в имени есть слово "мороженное"
select p.name as Наименование,
t.name as Категория from product as p join type t on p.type_id=t.id
where p.name like '%мороженное%'

--3. Написать запрос, который выводит все продукты, срок годности которых уже истек
select p.name as Наименование, p.expired_date as Срок_годности,
t.name as Категория from product as p join type t on p.type_id=t.id
where current_date>p.expired_date

--4. Написать запрос, который выводит самый дорогой продукт.
select name, price from product
	where price=(
	select max (price)
		from product
);

--5. Написать запрос, который выводит для каждого типа количество продуктов к нему принадлежащих. В виде имя_типа, количество
select t.name as Категория, 
count(t.name) as количество from product as p join type t on p.type_id=t.id
group by (t.name);

--6. Написать запрос получение всех продуктов с типом "СЫР" и "МОЛОКО"
select p.name as Наименование, p.price as Цена, p.expired_date as Срок_годности,
t.name as Категория from product as p join type t on p.type_id=t.id
where t.name='сыр' or t.name='молоко';

--7. Написать запрос, который выводит тип продуктов, которых осталось меньше 10 штук.  
select t.name as Категория, 
count(t.name) as количество from product as p join type t on p.type_id=t.id
group by (t.name)
having count (t.name)<10;

--8. Вывести все продукты и их тип.
select p.name as Наименование, p.price as Цена, p.expired_date as Срок_годности,
t.name as Категория from product as p join type t on p.type_id=t.id
