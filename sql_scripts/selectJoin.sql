select * from emploees e left join departments d on e.departments_id = d.id;
select * from emploees e right join departments d on e.departments_id = d.id;
select * from emploees e full join departments d on e.departments_id = d.id;
select * from departments d left join emploees e on e.departments_id = d.id where e.id is null;
select * from emploees e left join departments d on e.departments_id = d.id;
select * from departments d right join emploees e on e.departments_id = d.id;

