--DROP TABLE users CASCADE CONSTRAINTS;

--CREATE TABLE users(
		--id                            		NUMBER(10)		 NULL 		 PRIMARY KEY,
		--name                          		VARCHAR2(100)		 NULL ,
		--email                         		VARCHAR2(100)		 NULL ,
		--created_at                    		DATE		 NULL ,
		--updated_at                    		DATE		 NULL 
--);

DROP SEQUENCE users_id_SEQ;

CREATE SEQUENCE users_id_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;




