select p.id, p.name, c.name from person p left join company c on p.company_id = c.id and c.id != 5;
select  c.name, count(c.id)
from company c join person p on c.id = p.company_id
group by c.name, c.id
order by count(c.id) desc limit 1;
