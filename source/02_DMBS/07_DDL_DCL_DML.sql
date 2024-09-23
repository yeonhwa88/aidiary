-- [VII] DDL, DCL, DML
-- SQL = DDL (테이블 생성, 테이블 삭제, 테이블 구조 변경, 테이블 모든 데이터 제거 : 취소불가) + 
--       DML (SELECT, INSERT, UPDATE, DELETE : 취소가능) + 
--       DCL (사용자계정생성, 사용자에게 권한부여, 권한박탈, 사용자계정 삭제, 트랜잭션명령어)
-- ★★★ DDL ★★★ --
-- 1. 테이블 생성(CREATE TABLE 테이블명 ....) : 테이블 구조를 정의
CREATE TABLE BOOK (
    --필드명 필드타입
    BOOKID    NUMBER(4),     --BOOKID 필드의 타입은 숫자 4자리.
    BOOKNAME  VARCHAR2(20),  -- BOOKNAME 필드의 타입은 문자 20byte. 
    PUBLISHER VARCHAR2(30)   -- PUBLISHER 필드의 타입은 문자 30byte.
);
SELECT *
    FROM BOOK;