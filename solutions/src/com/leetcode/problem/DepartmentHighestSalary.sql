SELECT 
  d.Name AS Department, e.Name AS EMPLOYEE, e.Salary AS SALARY 
FROM 
  Employee e, 
  Department d,
  (SELECT e.DepartmentId AS DID, MAX(Salary) as MSALARY FROM Employee e GROUP BY DepartmentId) m
WHERE 
  e.Salary = m.MSALARY AND e.DepartmentId = m.DID AND d.Id= m.DID;