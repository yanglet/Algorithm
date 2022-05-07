select i.animal_id, i.animal_type, i.name
from animal_ins as i
left join animal_outs as o
on i.animal_id = o.animal_id
where i.sex_upon_intake like 'intact%' and (o.sex_upon_outcome like 'spayed%' or o.sex_upon_outcome like 'neutered%')
-- like 보다 같지않다고 하는게 나았을듯
