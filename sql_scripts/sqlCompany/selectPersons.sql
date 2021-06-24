select p.name from person p where company_id is null AND id=5;
select p.name, c.name from person p join company c on p.company_id = c.id;

select  c.name, count(c.id)
from company c join person p on c.id = p.company_id
group by c.name, c.id
order by count(c.id) desc limit 1;
