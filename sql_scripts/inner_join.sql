select pp.name, pp.age, p.name from students as pp join faculty as p on pp.faculty_id=p.id;
select pp.name, pp.age,pp.faculty_id, p.name  from students as pp join faculty as p on pp.faculty_id=p.id;
select pp.name as Имя, pp.age as Возраст, p.name as Факультет from students as pp join faculty as p on pp.faculty_id=p.id;
