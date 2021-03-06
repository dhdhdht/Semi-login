DROP SEQUENCE MEMBERSEQ;
DROP TABLE MEMBER;

CREATE SEQUENCE MEMBERSEQ;

CREATE TABLE MEMBER(
-- 번호, 아이디, 비밀번호, 이름, 주소, 전화번호, 이메일, 가입여부(Y/N), 등급(ADMIN, USER, ...)
	MEMBER_NO NUMBER NOT NULL,
	MEMBER_ID VARCHAR2(500) NOT NULL,
	MEMBER_PW VARCHAR2(500) NOT NULL,
	MEMBER_NAME VARCHAR2(100) NOT NULL,
	MEMBER_ADDR VARCHAR2(2000) NOT NULL,
	MEMBER_PHONE VARCHAR2(18) NOT NULL,
	MEMBER_EMAIL VARCHAR2(100) NOT NULL,
	MEMBER_ENABLED VARCHAR2(2) NOT NULL,
	MEMBER_ROLE VARCHAR2(100) NOT NULL,
	CONSTRAINT MEMBER_MEMBER_NO_PK PRIMARY KEY (MEMBER_NO),
	CONSTRAINT MEMBER_MEMBER_ID_UQ UNIQUE(MEMBER_ID),
	CONSTRAINT MEMBER_MEMBER_PHONE_UQ UNIQUE(MEMBER_PHONE),
	CONSTRAINT MEMBER_MEMBER_EMAIL_UQ UNIQUE(MEMBER_EMAIL),
	CONSTRAINT MEMBER_MEMBER_ENABLED_CHK CHECK(MEMBER_ENABLED IN ('Y', 'N'))
);

INSERT INTO MEMBER
VALUES(MEMBERSEQ.NEXTVAL, 'admin1', 'admin', '관리자', '서울', '011-0000-0000', 'admin1@admin.com', 'Y', 'ADMIN');

SELECT *
FROM MEMBER;

DELETE MEMBER
WHERE MEMBER_ID = 'admin1';