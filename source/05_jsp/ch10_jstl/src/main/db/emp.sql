-- public ArrayList<Emp> getEmpList
SELECT *
    FROM EMP;
-- quiz에 쓸 public ArrayList<Emp> getEmpList(String schName, String schJob)
SELECT *
    FROM EMP
    WHERE ENAME LIKE '% || UPPER(TRIM('')) || %'
    	AND JOB LIKE '% || UPPER(TRIM('')|| %'; 