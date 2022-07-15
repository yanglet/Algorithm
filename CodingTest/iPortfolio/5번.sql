select e.model as MODEL, ifnull(sum(s.price), 0) as PRICE
from electric_cars as e
left join sellings as s
on e.id = s.car_id
group by e.model
order by e.id
