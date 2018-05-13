SELECT 
  DISTINCT Num as ConsecutiveNums
FROM 
  Logs logs1
WHERE 
  (SELECT Num as num1 FROM Logs logs2 WHERE logs1.Id = (logs2.Id)+1) = logs1.Num 
  AND
  (SELECT Num as num1 FROM Logs logs3 WHERE logs1.Id = (logs3.Id)+2) = logs1.Num;