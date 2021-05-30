create table faculty(
	id serial primary key,
		name varchar(255)	
);

create table students(
	id serial primary key,
	name varchar(255),
	age int,
	faculty_id int references faculty(id)
);