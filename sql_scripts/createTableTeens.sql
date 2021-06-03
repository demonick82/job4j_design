create table teens (
	id serial primary key,
	    name varchar(255),
		gender VARCHAR(1) check (gender in ('F', 'M'))
);