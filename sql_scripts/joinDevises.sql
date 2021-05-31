select avg(price) from devices;

select p.name, avg(dev.price) from people as p join devices_people dp on p.id=dp.people_id
join devices as dev on dp.device_id=dev.id
group by p.name

having avg(dev.price)>10000;
