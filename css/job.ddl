/**********************************/
/* Table Name: ���� */
/**********************************/
CREATE TABLE job(
		job_id                        		NUMBER(10)		 NULL ,
		job_name                      		VARCHAR2(20)		 NULL 
);

COMMENT ON TABLE job is '����';
COMMENT ON COLUMN job.job_id is '���� ������';
COMMENT ON COLUMN job.job_name is '����';


/**********************************/
/* Table Name: ���� */
/**********************************/
CREATE TABLE job_group(
		job_group_id                  		NUMBER(10)		 NULL ,
		job_group_name                		VARCHAR2(20)		 NULL ,
		job_id                        		NUMBER(10)		 NULL 
);

COMMENT ON TABLE job_group is '����';
COMMENT ON COLUMN job_group.job_group_id is '�������̵�';
COMMENT ON COLUMN job_group.job_group_name is '������';
COMMENT ON COLUMN job_group.job_id is '���� ������';


/**********************************/
/* Table Name: ȸ�� */
/**********************************/
CREATE TABLE userinfo(
		user_email                    		VARCHAR2(50)		 NOT NULL,
		user_password                 		VARCHAR2(300)		 NULL ,
		user_name                     		VARCHAR2(10)		 NULL ,
		user_phone                    		NUMBER(20)		 NOT NULL,
		user_sex                      		VARCHAR2(10)		 NULL ,
		user_address                  		VARCHAR2(50)		 NOT NULL,
		user_career                   		NUMBER(10)		 NOT NULL,
		user_age                      		NUMBER(10)		 NOT NULL,
		user_education                		VARCHAR2(10)		 NOT NULL,
		user_language                 		VARCHAR2(10)		 NULL ,
		user_skills                   		VARCHAR2(100)		 NULL ,
		user_description              		VARCHAR2(500)		 NULL ,
		job_group_id                  		NUMBER(10)		 NULL 
);

COMMENT ON TABLE userinfo is 'ȸ��';
COMMENT ON COLUMN userinfo.user_email is '���̵�/�̸���';
COMMENT ON COLUMN userinfo.user_password is '�н�����';
COMMENT ON COLUMN userinfo.user_name is '�̸�';
COMMENT ON COLUMN userinfo.user_phone is '��ȭ��ȣ';
COMMENT ON COLUMN userinfo.user_sex is '����';
COMMENT ON COLUMN userinfo.user_address is '�ּ�';
COMMENT ON COLUMN userinfo.user_career is '��±Ⱓ';
COMMENT ON COLUMN userinfo.user_age is '����';
COMMENT ON COLUMN userinfo.user_education is '�����з�';
COMMENT ON COLUMN userinfo.user_language is '�ܱ���';
COMMENT ON COLUMN userinfo.user_skills is 'skills';
COMMENT ON COLUMN userinfo.user_description is '�ڱ�Ұ�';
COMMENT ON COLUMN userinfo.job_group_id is '�������̵�';


/**********************************/
/* Table Name: �̷¼� */
/**********************************/
CREATE TABLE CV(
		cv_seq                        		NUMBER(1000)		 NOT NULL,
		cv_name                       		VARCHAR2(20)		 DEFAULT 'my CV'		 NULL ,
		cv_description                		INTEGER(10)		 NULL ,
		cv_attachment                 		VARCHAR2(20)		 NULL ,
		user_email                    		VARCHAR2(50)		 NULL 
);

CREATE SEQUENCE CV_cv_seq_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

CREATE TRIGGER CV_cv_seq_TRG
BEFORE INSERT ON CV
FOR EACH ROW
BEGIN
IF :NEW.cv_seq IS NOT NULL THEN
  SELECT CV_cv_seq_SEQ.NEXTVAL INTO :NEW.cv_seq FROM DUAL;
END IF;
END;

COMMENT ON TABLE CV is '�̷¼�';
COMMENT ON COLUMN CV.cv_seq is 'cv_seq';
COMMENT ON COLUMN CV.cv_name is '�̷¼� �̸�';
COMMENT ON COLUMN CV.cv_description is 'resume';
COMMENT ON COLUMN CV.cv_attachment is '��Ʈ������/�̹��� ÷��';
COMMENT ON COLUMN CV.user_email is 'user_email';


/**********************************/
/* Table Name: �з� */
/**********************************/
CREATE TABLE education(
		education_seq                 		NUMBER(1000)		 NOT NULL,
		education_major               		VARCHAR2(20)		 NOT NULL,
		education_name                		INTEGER(10)		 NOT NULL,
		education_start_date          		DATE		 NOT NULL,
		education_end_date            		DATE		 NULL ,
		education_content             		VARCHAR2(50)		 NULL ,
		cv_seq                        		NUMBER(1000)		 NOT NULL
);

CREATE SEQUENCE education_education_seq_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

CREATE TRIGGER education_education_seq_TRG
BEFORE INSERT ON education
FOR EACH ROW
BEGIN
IF :NEW.education_seq IS NOT NULL THEN
  SELECT education_education_seq_SEQ.NEXTVAL INTO :NEW.education_seq FROM DUAL;
END IF;
END;

COMMENT ON TABLE education is '�з�';
COMMENT ON COLUMN education.education_seq is 'education_seq';
COMMENT ON COLUMN education.education_major is '����';
COMMENT ON COLUMN education.education_name is '�б���';
COMMENT ON COLUMN education.education_start_date is '������';
COMMENT ON COLUMN education.education_end_date is '������';
COMMENT ON COLUMN education.education_content is '����';
COMMENT ON COLUMN education.cv_seq is 'cv_seq';


/**********************************/
/* Table Name: ��� */
/**********************************/
CREATE TABLE experience(
		experience_seq                		NUMBER(1000)		 NOT NULL,
		experience_position           		VARCHAR2(30)		 NOT NULL,
		experience_corp_name          		VARCHAR2(30)		 NOT NULL,
		experience_start_date         		DATE		 NOT NULL,
		experience_end_date           		DATE		 NOT NULL,
		experience_content            		VARCHAR2(100)		 NULL ,
		cv_seq                        		NUMBER(1000)		 NOT NULL
);

CREATE SEQUENCE experience_experience_seq_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

CREATE TRIGGER experience_experience_seq_TRG
BEFORE INSERT ON experience
FOR EACH ROW
BEGIN
IF :NEW.experience_seq IS NOT NULL THEN
  SELECT experience_experience_seq_SEQ.NEXTVAL INTO :NEW.experience_seq FROM DUAL;
END IF;
END;

COMMENT ON TABLE experience is '���';
COMMENT ON COLUMN experience.experience_seq is 'experience_seq';
COMMENT ON COLUMN experience.experience_position is '��å';
COMMENT ON COLUMN experience.experience_corp_name is 'ȸ���';
COMMENT ON COLUMN experience.experience_start_date is '�Ի���';
COMMENT ON COLUMN experience.experience_end_date is '�����';
COMMENT ON COLUMN experience.experience_content is '����';
COMMENT ON COLUMN experience.cv_seq is 'cv_seq';


/**********************************/
/* Table Name: ���󳻿�/ �ڰ� */
/**********************************/
CREATE TABLE awards(
		awards_seq                    		NUMBER(1000)		 NOT NULL,
		awards_name                   		VARCHAR2(30)		 NOT NULL,
		awards_date                   		DATE		 NOT NULL,
		awards_content                		VARCHAR2(100)		 NULL ,
		cv_seq                        		NUMBER(1000)		 NOT NULL
);

COMMENT ON TABLE awards is '���󳻿�/ �ڰ�';
COMMENT ON COLUMN awards.awards_seq is 'awards_seq';
COMMENT ON COLUMN awards.awards_name is '����/�ڰ��� �̸�';
COMMENT ON COLUMN awards.awards_date is '����/�ڰ��� �����';
COMMENT ON COLUMN awards.awards_content is '����';
COMMENT ON COLUMN awards.cv_seq is 'cv_seq';


/**********************************/
/* Table Name: ���� */
/**********************************/
CREATE TABLE location(
		location_id                   		NUMBER(10)		 NULL ,
		location_name                 		VARCHAR2(20)		 NULL 
);

COMMENT ON TABLE location is '����';
COMMENT ON COLUMN location.location_id is '����id';
COMMENT ON COLUMN location.location_name is '������';


/**********************************/
/* Table Name: ��� */
/**********************************/
CREATE TABLE company(
		company_id                    		VARCHAR2(30)		 NOT NULL,
		company_password              		VARCHAR2(300)		 NOT NULL,
		company_name                  		VARCHAR2(30)		 NOT NULL,
		company_phone                 		NUMBER(10)		 NULL ,
		company_website               		VARCHAR2(50)		 NULL ,
		company_est                   		DATE		 NULL ,
		company_size                  		NUMBER(10)		 NULL ,
		company_status                		CHAR(1)		 NULL ,
		company_coment                		VARCHAR2(200)		 NULL ,
		job_group_id                  		NUMBER(10)		 NULL ,
		location                      		VARCHAR2(10)		 NULL ,
		company_address               		VARCHAR2(10)		 NULL ,
		review_seq                    		NUMBER(100)		 NULL 
);

COMMENT ON TABLE company is '���';
COMMENT ON COLUMN company.company_id is '���̵�';
COMMENT ON COLUMN company.company_password is '��й�ȣ';
COMMENT ON COLUMN company.company_name is 'ȸ���';
COMMENT ON COLUMN company.company_phone is 'ȸ���ȣ';
COMMENT ON COLUMN company.company_website is '����Ʈ';
COMMENT ON COLUMN company.company_est is '������';
COMMENT ON COLUMN company.company_size is '������';
COMMENT ON COLUMN company.company_status is '�������';
COMMENT ON COLUMN company.company_coment is 'ȸ��Ұ�';
COMMENT ON COLUMN company.job_group_id is '�������̵�';
COMMENT ON COLUMN company.location is '����';
COMMENT ON COLUMN company.company_address is '���ּ�';
COMMENT ON COLUMN company.review_seq is '����seq';


/**********************************/
/* Table Name: ȸ�� ������ */
/**********************************/
CREATE TABLE manager(
		manager_email                 		VARCHAR2(30)		 NOT NULL,
		manager_position              		VARCHAR2(10)		 NOT NULL,
		manager_phone                 		NUMBER(20)		 NOT NULL,
		manager_email                 		VARCHAR2(40)		 NOT NULL,
		company_id                    		VARCHAR2(30)		 NULL 
);

COMMENT ON TABLE manager is 'ȸ�� ������';
COMMENT ON COLUMN manager.manager_email is '�̸�';
COMMENT ON COLUMN manager.manager_position is '��å';
COMMENT ON COLUMN manager.manager_phone is '��ȭ��ȣ';
COMMENT ON COLUMN manager.manager_email is '�̸���';
COMMENT ON COLUMN manager.company_id is '���̵�';


/**********************************/
/* Table Name: ���� */
/**********************************/
CREATE TABLE recruit(
		recruit_seq                   		NUMBER(1000)		 NOT NULL,
		recruit_title                 		INTEGER(10)		 NULL ,
		recruit_specialisms           		VARCHAR2(30)		 NULL ,
		recruit_content               		VARCHAR2(200)		 NULL ,
		recruit_career_level          		VARCHAR2(20)		 NULL ,
		recruit_exprience             		VARCHAR2(10)		 NULL ,
		recruit_qualification         		VARCHAR2(50)		 NULL ,
		recruit_salary                		NUMBER(20)		 NULL ,
		recruit_deadline              		DATE		 NULL ,
		recruit_experience            		VARCHAR2(20)		 NULL ,
		company_id                    		VARCHAR2(30)		 NULL 
);

CREATE SEQUENCE recruit_recruit_seq_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

CREATE TRIGGER recruit_recruit_seq_TRG
BEFORE INSERT ON recruit
FOR EACH ROW
BEGIN
IF :NEW.recruit_seq IS NOT NULL THEN
  SELECT recruit_recruit_seq_SEQ.NEXTVAL INTO :NEW.recruit_seq FROM DUAL;
END IF;
END;

COMMENT ON TABLE recruit is '����';
COMMENT ON COLUMN recruit.recruit_seq is '���������';
COMMENT ON COLUMN recruit.recruit_title is '����';
COMMENT ON COLUMN recruit.recruit_specialisms is '����';
COMMENT ON COLUMN recruit.recruit_content is '����';
COMMENT ON COLUMN recruit.recruit_career_level is '����';
COMMENT ON COLUMN recruit.recruit_exprience is '���';
COMMENT ON COLUMN recruit.recruit_qualification is '�ڰ�����';
COMMENT ON COLUMN recruit.recruit_salary is '����';
COMMENT ON COLUMN recruit.recruit_deadline is '������';
COMMENT ON COLUMN recruit.recruit_experience is '�������';
COMMENT ON COLUMN recruit.company_id is '���̵�';


/**********************************/
/* Table Name: �±� */
/**********************************/
CREATE TABLE tag(
		tag_id                        		INTEGER(10)		 NULL ,
		tag_name                      		VARCHAR2(10)		 NULL 
);

COMMENT ON TABLE tag is '�±�';
COMMENT ON COLUMN tag.tag_id is '�±׾��̵�';
COMMENT ON COLUMN tag.tag_name is '�±׸�';


/**********************************/
/* Table Name: ���� */
/**********************************/
CREATE TABLE application(
		application_seq               		NUMBER(1000)		 NOT NULL,
		recruit_seq                   		NUMBER(1000)		 NOT NULL,
		cv_seq                        		NUMBER(1000)		 NOT NULL,
		application_status            		CHAR(1)		 NULL 
);

CREATE SEQUENCE application_application_seq_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

CREATE TRIGGER application_application_seq_TRG
BEFORE INSERT ON application
FOR EACH ROW
BEGIN
IF :NEW.application_seq IS NOT NULL THEN
  SELECT application_application_seq_SEQ.NEXTVAL INTO :NEW.application_seq FROM DUAL;
END IF;
END;

COMMENT ON TABLE application is '����';
COMMENT ON COLUMN application.application_seq is '����seq';
COMMENT ON COLUMN application.recruit_seq is '���������';
COMMENT ON COLUMN application.cv_seq is 'cv_seq';
COMMENT ON COLUMN application.application_status is 'application_status';


/**********************************/
/* Table Name: ���� ��ũ�� */
/**********************************/
CREATE TABLE recruit_scrap(
		recruit_scrap_seq             		NUMBER(1000)		 NOT NULL,
		recruit_seq                   		NUMBER(1000)		 NULL ,
		user_email                    		VARCHAR2(50)		 NULL 
);

CREATE SEQUENCE recruit_scrap_recruit_scrap_seq_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

CREATE TRIGGER recruit_scrap_recruit_scrap_seq_TRG
BEFORE INSERT ON recruit_scrap
FOR EACH ROW
BEGIN
IF :NEW.recruit_scrap_seq IS NOT NULL THEN
  SELECT recruit_scrap_recruit_scrap_seq_SEQ.NEXTVAL INTO :NEW.recruit_scrap_seq FROM DUAL;
END IF;
END;

COMMENT ON TABLE recruit_scrap is '���� ��ũ��';
COMMENT ON COLUMN recruit_scrap.recruit_scrap_seq is '����ũ��seq';
COMMENT ON COLUMN recruit_scrap.recruit_seq is '���������';
COMMENT ON COLUMN recruit_scrap.user_email is '���̵�/�̸���';


/**********************************/
/* Table Name: �ϸ�ũ */
/**********************************/
CREATE TABLE bookmark(
		user_email                    		VARCHAR2(50)		 NULL ,
		company_id                    		VARCHAR2(30)		 NULL 
);

COMMENT ON TABLE bookmark is '�ϸ�ũ';
COMMENT ON COLUMN bookmark.user_email is '���̵�/�̸���';
COMMENT ON COLUMN bookmark.company_id is '���̵�';


/**********************************/
/* Table Name: ����±� */
/**********************************/
CREATE TABLE company_tag(
		company_id                    		VARCHAR2(30)		 NULL ,
		tag_id                        		INTEGER(10)		 NULL 
);

COMMENT ON TABLE company_tag is '����±�';
COMMENT ON COLUMN company_tag.company_id is '���̵�';
COMMENT ON COLUMN company_tag.tag_id is '�±׾��̵�';


/**********************************/
/* Table Name: ���� �±� */
/**********************************/
CREATE TABLE recruit_tag(
		tag_id                        		INTEGER(10)		 NULL ,
		recruit_seq                   		NUMBER(1000)		 NULL 
);

COMMENT ON TABLE recruit_tag is '���� �±�';
COMMENT ON COLUMN recruit_tag.tag_id is '�±׾��̵�';
COMMENT ON COLUMN recruit_tag.recruit_seq is '���������';


/**********************************/
/* Table Name: ���� */
/**********************************/
CREATE TABLE review(
		review_seq                    		NUMBER(100)		 NULL ,
		review_grade                  		CHAR(1)		 NULL ,
		review_title                  		VARCHAR2(10)		 NULL ,
		review_content                		VARCHAR2(50)		 NULL ,
		user_email                    		VARCHAR2(50)		 NULL ,
		company_id                    		VARCHAR2(30)		 NULL 
);

COMMENT ON TABLE review is '����';
COMMENT ON COLUMN review.review_seq is '����seq';
COMMENT ON COLUMN review.review_grade is '����';
COMMENT ON COLUMN review.review_title is 'Ÿ��Ʋ';
COMMENT ON COLUMN review.review_content is '����';
COMMENT ON COLUMN review.user_email is '���̵�/�̸���';
COMMENT ON COLUMN review.company_id is '���̵�';


/**********************************/
/* Table Name: ��ǰ */
/**********************************/
CREATE TABLE product(
		product_no                    		NUMBER(100)		 NULL ,
		product_name                  		VARCHAR2(50)		 NULL ,
		product_price                 		NUMBER(10)		 NULL ,
		product_date                  		DATE		 NULL 
);

COMMENT ON TABLE product is '��ǰ';
COMMENT ON COLUMN product.product_no is '��ǰ��ȣ';
COMMENT ON COLUMN product.product_name is '��ǰ�̸�';
COMMENT ON COLUMN product.product_price is '��ǰ�ݾ�';
COMMENT ON COLUMN product.product_date is '��ǰ������';


/**********************************/
/* Table Name: �ֹ� */
/**********************************/
CREATE TABLE order(
		order_no                      		NUMBER(100)		 NULL ,
		product_no                    		NUMBER(100)		 NULL ,
		company_id                    		VARCHAR2(30)		 NULL ,
		user_email                    		VARCHAR2(50)		 NULL 
);

COMMENT ON TABLE order is '�ֹ�';
COMMENT ON COLUMN order.order_no is '�ֹ���ȣ';
COMMENT ON COLUMN order.product_no is '��ǰ��ȣ';
COMMENT ON COLUMN order.company_id is '���̵�';
COMMENT ON COLUMN order.user_email is '���̵�/�̸���';


/**********************************/
/* Table Name: ���� */
/**********************************/
CREATE TABLE payment(
		payment_seq                   		NUMBER(10)		 NULL ,
		order_no                      		NUMBER(1000)		 NULL ,
		payment_price                 		NUMBER(20)		 NULL ,
		payment_method                		VARCHAR2(50)		 NULL ,
		payment_date                  		DATE		 NULL 
);

COMMENT ON TABLE payment is '����';
COMMENT ON COLUMN payment.payment_seq is '�����ڵ�';
COMMENT ON COLUMN payment.order_no is '�ֹ���ȣ';
COMMENT ON COLUMN payment.payment_price is '���� �ݾ�';
COMMENT ON COLUMN payment.payment_method is '���� ���';
COMMENT ON COLUMN payment.payment_date is '������';



ALTER TABLE job ADD CONSTRAINT IDX_job_PK PRIMARY KEY (job_id);

ALTER TABLE job_group ADD CONSTRAINT IDX_job_group_PK PRIMARY KEY (job_group_id);
ALTER TABLE job_group ADD CONSTRAINT IDX_job_group_FK0 FOREIGN KEY (job_id) REFERENCES job (job_id);

ALTER TABLE userinfo ADD CONSTRAINT IDX_userinfo_PK PRIMARY KEY (user_email);
ALTER TABLE userinfo ADD CONSTRAINT IDX_userinfo_FK0 FOREIGN KEY (job_group_id) REFERENCES job_group (job_group_id);

ALTER TABLE CV ADD CONSTRAINT IDX_CV_PK PRIMARY KEY (cv_seq);
ALTER TABLE CV ADD CONSTRAINT IDX_CV_FK0 FOREIGN KEY (user_email) REFERENCES userinfo (user_email);

ALTER TABLE education ADD CONSTRAINT IDX_education_PK PRIMARY KEY (education_seq);
ALTER TABLE education ADD CONSTRAINT IDX_education_FK0 FOREIGN KEY (cv_seq) REFERENCES CV (cv_seq);

ALTER TABLE experience ADD CONSTRAINT IDX_experience_PK PRIMARY KEY (experience_seq);
ALTER TABLE experience ADD CONSTRAINT IDX_experience_FK0 FOREIGN KEY (cv_seq) REFERENCES CV (cv_seq);

ALTER TABLE awards ADD CONSTRAINT IDX_awards_PK PRIMARY KEY (awards_seq);
ALTER TABLE awards ADD CONSTRAINT IDX_awards_FK0 FOREIGN KEY (cv_seq) REFERENCES CV (cv_seq);

ALTER TABLE location ADD CONSTRAINT IDX_location_PK PRIMARY KEY (location_id);

ALTER TABLE company ADD CONSTRAINT IDX_company_PK PRIMARY KEY (company_id);
ALTER TABLE company ADD CONSTRAINT IDX_company_FK0 FOREIGN KEY (job_group_id) REFERENCES job_group (job_group_id);

ALTER TABLE manager ADD CONSTRAINT IDX_manager_PK PRIMARY KEY (manager_email);
ALTER TABLE manager ADD CONSTRAINT IDX_manager_FK0 FOREIGN KEY (company_id) REFERENCES company (company_id);

ALTER TABLE recruit ADD CONSTRAINT IDX_recruit_PK PRIMARY KEY (recruit_seq);
ALTER TABLE recruit ADD CONSTRAINT IDX_recruit_FK0 FOREIGN KEY (company_id) REFERENCES company (company_id);

ALTER TABLE tag ADD CONSTRAINT IDX_tag_PK PRIMARY KEY (tag_id);

ALTER TABLE application ADD CONSTRAINT IDX_application_PK PRIMARY KEY (application_seq);
ALTER TABLE application ADD CONSTRAINT IDX_application_FK0 FOREIGN KEY (recruit_seq) REFERENCES recruit (recruit_seq);
ALTER TABLE application ADD CONSTRAINT IDX_application_FK1 FOREIGN KEY (cv_seq) REFERENCES CV (cv_seq);

ALTER TABLE recruit_scrap ADD CONSTRAINT IDX_recruit_scrap_PK PRIMARY KEY (recruit_scrap_seq);
ALTER TABLE recruit_scrap ADD CONSTRAINT IDX_recruit_scrap_FK0 FOREIGN KEY (recruit_seq) REFERENCES recruit (recruit_seq);
ALTER TABLE recruit_scrap ADD CONSTRAINT IDX_recruit_scrap_FK1 FOREIGN KEY (user_email) REFERENCES userinfo (user_email);

ALTER TABLE bookmark ADD CONSTRAINT IDX_bookmark_FK0 FOREIGN KEY (user_email) REFERENCES userinfo (user_email);
ALTER TABLE bookmark ADD CONSTRAINT IDX_bookmark_FK1 FOREIGN KEY (company_id) REFERENCES company (company_id);

ALTER TABLE company_tag ADD CONSTRAINT IDX_company_tag_FK0 FOREIGN KEY (company_id) REFERENCES company (company_id);
ALTER TABLE company_tag ADD CONSTRAINT IDX_company_tag_FK1 FOREIGN KEY (tag_id) REFERENCES tag (tag_id);

ALTER TABLE recruit_tag ADD CONSTRAINT IDX_recruit_tag_FK0 FOREIGN KEY (tag_id) REFERENCES tag (tag_id);
ALTER TABLE recruit_tag ADD CONSTRAINT IDX_recruit_tag_FK1 FOREIGN KEY (recruit_seq) REFERENCES recruit (recruit_seq);

ALTER TABLE review ADD CONSTRAINT IDX_review_PK PRIMARY KEY (review_seq);
ALTER TABLE review ADD CONSTRAINT IDX_review_FK0 FOREIGN KEY (company_id) REFERENCES company (company_id);
ALTER TABLE review ADD CONSTRAINT IDX_review_FK1 FOREIGN KEY (user_email) REFERENCES userinfo (user_email);

ALTER TABLE product ADD CONSTRAINT IDX_product_PK PRIMARY KEY (product_no);

ALTER TABLE order ADD CONSTRAINT IDX_order_PK PRIMARY KEY (order_no);
ALTER TABLE order ADD CONSTRAINT IDX_order_FK0 FOREIGN KEY (product_no) REFERENCES product (product_no);
ALTER TABLE order ADD CONSTRAINT IDX_order_FK1 FOREIGN KEY (company_id) REFERENCES company (company_id);
ALTER TABLE order ADD CONSTRAINT IDX_order_FK2 FOREIGN KEY (user_email) REFERENCES userinfo (user_email);

ALTER TABLE payment ADD CONSTRAINT IDX_payment_PK PRIMARY KEY (payment_seq);
ALTER TABLE payment ADD CONSTRAINT IDX_payment_FK0 FOREIGN KEY (order_no) REFERENCES order (order_no);

