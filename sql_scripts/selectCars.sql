select c.name as Наименование, e.name as Двигатель,cb.name as Кузов, t.name as коробка
from cars as c join engines e on e.id=c.engines_id
join car_bodies as cb on  cb.id=c.car_bodies_id
join transmissions as t on t.id=c.transmissions_id;

select e.name from engines e left join cars c on c.engines_id=e.id where c.id is null;
select cb.name from car_bodies cb left join cars c on c.car_bodies_id=cb.id where c.id is null;
select t.name from transmissions t left join cars c on c.transmissions_id=t.id where c.id is null;
