-- [VII] DDL, DCL, DML
-- SQL = DDL (테이블 생성, 테이블 삭제, 테이블 구조 변경, 테이블 모든 데이터 제거 : 취소불가) + 
--       DML (SELECT, INSERT, UPDATE, DELETE : 취소가능) + 
--       DCL (사용자계정생성, 사용자에게 권한부여, 권한박탈, 사용자계정 삭제, 트랜잭션명령어)
-- ★★★ DDL ★★★ --
-- 1. 테이블 생성(CREATE TABLE 테이블명 ....) : 테이블 구조를 정의
DROP TABLE BOOK; -- 테이블 삭제
CREATE TABLE BOOK (
    --필드명 필드타입
    BOOKID     NUMBER(4),      --BOOKID 필드의 타입은 숫자 4자리.
    BOOKNAME   VARCHAR2(20),   -- BOOKNAME 필드의 타입은 문자 20byte. 
    PUBLISHER  VARCHAR2(30),   -- PUBLISHER 필드의 타입은 문자 30byte.
    RDATE      DATE,           -- RDATE필드의 타입은 DATE
    PRICE      NUMBER(8, 2),   -- PRICE필드의 타입은 숫자 전체 8자리 중 소숫점 2자리
    PRIMARY KEY(BOOKID)        -- 제약조건 : BOOKID필드가 주키(PRIMARY KEY : NOT NULL, UNIQUE)
);
SELECT *
    FROM BOOK;
DESC BOOK;

DROP TABLE BOOK; -- 테이블 삭제
CREATE TABLE BOOK (
    --필드명 필드타입
    BOOKID     NUMBER(4) PRIMARY KEY,     
    BOOKNAME   VARCHAR2(20),   
    PUBLISHER  VARCHAR2(30),   
    RDATE      DATE,           
    PRICE      NUMBER(8, 2)   
);
SELECT *
    FROM BOOK;
    
    -- DEPT01테이블 : DEPTNO(숫자2:PK), DNAEM(문자14), LOC(문자13)
    CREATE TABLE DEPT01(
        DEPTNO NUMBER(2),
        DNAME VARCHAR2(14),
        LOC VARCHAR2(13),
        PRIMARY KEY(DEPTNO)
    );
    --EX. EMP와 유사한 EMP01테이블 : EMPNO(숫자4:PK), ENAME(문자10), SAL(숫자7,2), DEPTNO(숫자2, DEPT01테이블의 DEPTNO와 연동 : 외래키 FK)
    CREATE TABLE EMP01(
        EMPNO NUMBER(4) PRIMARY KEY,
        ENAME VARCHAR2(10),
        SAL NUMBER(7,2),
        DEPTNO NUMBER(2) REFERENCES DEPT01(DEPTNO) -- REFERENCES 참조테이블 연결 FK
    );
SELECT *  
    FROM EMP01;
-- 외래키로 연결할 경우 : 참조테이블(DEPT01)에 데이터를 INSERT 해야 함
INSERT INTO DEPT01 VALUES (10,'신림','IT');
INSERT INTO EMP01 VALUES (1000,'홍',9000,10);
DROP TABLE DEPT01; -- 참조하는 테이블이 있을경우 테이블 삭제 불가
COMMIT; -- DML 명령어들을 트랜잭션 (데이텅베이스에 적용)

-- 서브쿼리를 이용한 테이블 생성
CREATE TABLE EMP02
    AS
    SELECT *
        FROM EMP; -- 서브쿼리 결과로 EMP02 테이블 생성 후, 데이터 들어감 (제약조건 미포함)
SELECT *
    FROM EMP02;
DESC EMP02;

CREATE TABLE EMP03
    AS 
    SELECT EMPNO, ENAME, DEPTNO FROM EMP;
SELECT *
    FROM EMP03; -- AS 복사할때 사용