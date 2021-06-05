create table engines(
	id serial primary key,
    name varchar(255)
);

create table car_bodies(
	id serial primary key,
    name varchar(255)
);

create table transmissions(
	id serial primary key,
    name varchar(255)
);

create table cars(
	id serial primary key,
    name varchar(255),
	engines_id int references engines(id),
	car_bodies_id int references car_bodies(id),
	transmissions_id int references transmissions(id)	
);