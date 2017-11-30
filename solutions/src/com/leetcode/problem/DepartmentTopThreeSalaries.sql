
-- NOT COMPLETE
SELECT d.name, e.name, e.salary
FROM Employee e, Department d
WHERE e.department = d.id;
ORDER BY e.salary;

