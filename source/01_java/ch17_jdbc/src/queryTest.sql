-- com.lec.ex1selectAll
SELECT * 
    FROM EMP;

-- com.lec.ex2selectWhere
-- Ex1. 부서번호를 받아 부서정보를 출력
SELECT *
    FROM DEPT
    WHERE DEPTNO = 10;
INSERT INTO DEPT VALUES (50,  'IT',  '서울');
COMMIT;
-- Ex2.  부서번호 입력 받아 부서 정보와 사원 정보 출력
SELECT *
    FROM DEPT
    WHERE DEPTNO = 10;
SELECT W.EMPNO, W.ENAME, W.SAL, M.ENAME MANAGER
    FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO
    AND W.DEPTNO = 10;
-- Ex3. 부서이름으로 부서정보 출력
SELECT *
    FROM DEPT
    WHERE UPPER(DNAME) = UPPER('sales');
-- ★ ★ ★ com.lec.ex3insert ★ ★ ★
SELECT COUNT(*) CNT
    FROM DEPT WHERE DEPTNO = 60;
INSERT INTO DEPT 
    VALUES (60, UPPER('CS'), UPPER('PUSAN'));
rollback;

-- ★ ★ ★ com.lec.ex4update ★ ★ ★
SELECT *
    FROM DEPT
    WHERE DEPTNO = 80;
UPDATE DEPT 
    SET DNAME = UPPER('marketing'),
          LOC = UPPER('seoul')
    WHERE DEPTNO = 80;
SELECT *
    FROM DEPT;
    
--★ ★ ★ com.lec.ex5delete ★ ★ ★
SELECT *
    FROM DEPT
    WHERE DEPTNO = 60;
DELETE FROM DEPT
    WHERE DEPTNO = 99;
    
 --★ ★ ★ com.lec.ex6prepareStatement ★ ★ ★   
SELECT *
    FROM DEPT
    WHERE DNAME = UPPER('sales');
SELECT EMPNO, ENAME, SAL
    FROM EMP E, DEPT D
    WHERE DNAME = UPPER('SALES')
     AND E.DEPTNO = D.DEPTNOS
    ORDER BY SAL;
