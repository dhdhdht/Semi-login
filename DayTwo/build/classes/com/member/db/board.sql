SELECT * FROM MEMBER;


ALTER TABLE MEMBER ADD(MEMBER_PROFILE VARCHAR2(500));

ALTER TABLE MEMBER MODIFY (MEMBER_PROFILE DEFAULT 'defaultprofile.png');

ALTER TABLE MEMBER MODIFY MEMBER_PROFILE VARCHAR2(500) NOT NULL; 
SELECT * FROM MEMBER;