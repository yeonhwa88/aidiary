-- DAO에 쓸 QUERY
-- 1번기능과 2번 기능에서 입력가능한 직업명들을 출력 (jnameList)
SELECT JNAME
    FROM JOB;
SELECT *
    FROM PERSON;
-- 1번 기능 : PNAME, JNAME, KOR, ENG, MAT를 입력받아 PERSON테이블 INSERT  (insertPerson)
INSERT INTO PERSON (PNO, PNAME, JNO, KOR, ENG, MAT)
    VALUES (PERSON_PNO_SQ.NEXTVAL, '홍길동', (SELECT JNO
                                FROM JOB
                                WHERE JNAME = '배우'), 80, 80, 80);
-- 2번 기능 : JNAME을 입력받아 RANK, PNAME(PNO), JNAME, KOR, ENG, MAT, SUM 출력 (getPerson)
                -- RANK는 SUM내림차순으로 순위를 정함. (HINT : LOWNUM과 INLINE 이용
SELECT PNAME||'('||PNO||'번'||')', JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM
                FROM PERSON P, JOB J
                WHERE P.JNO = J.JNO 
                 AND JNAME = '배우'
                 ORDER BY SUM DESC;
SELECT ROWNUM RANK , A.*
    FROM (SELECT PNAME||'('||PNO||'번'||')' PNAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM
                                FROM PERSON P, JOB J
                                WHERE P.JNO = J.JNO 
                                AND JNAME = '배우'
                                ORDER BY SUM DESC) A ;
-- 3번 기능 : RANK, PNAME(PNO), JNAME, KOR, ENG, MAT, SUM 출력 (getPersonAll)
SELECT PNAME||'('||PNO||'번'||')', JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM
                FROM PERSON P, JOB J
                WHERE P.JNO = J.JNO 
                 ORDER BY SUM DESC;
SELECT ROWNUM RANK, A.*
    FROM (SELECT PNAME||'('||PNO||'번'||')' PNAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM
                FROM PERSON P, JOB J
                WHERE P.JNO = J.JNO 
                 ORDER BY SUM DESC) A;