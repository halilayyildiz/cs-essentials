SELECT 
  ids.new_id AS id, (SELECT student FROM seat WHERE id = ids.old_id) AS student
FROM 
  (SELECT id as old_id, IF(id % 2 <> 0, IF(id = (SELECT MAX(id) FROM seat), id, id+1), id-1) AS new_id FROM seat) ids
ORDER BY
  ids.new_id