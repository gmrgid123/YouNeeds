-- 파이널용 계정 생성------------------------------------------
CREATE USER YOUNEEDS IDENTIFIED BY 1234;
-- 아이디 : YOUNEEDS / 비번 : 1234
--권한 부여-------------------------------------------------
GRANT CONNECT, RESOURCE, CREATE VIEW TO YOUNEEDS;
-----------------------------------------------------------


DROP TABLE VideoChat;
DROP TABLE "Order";
DROP TABLE OrderPay;

DROP TABLE Project_Notice_Img;
DROP TABLE Project_Notice;
DROP TABLE Project_title_img;
DROP TABLE Project_Fund_Guide;
DROP TABLE Project_Intro_Img;
DROP TABLE Project_Intro;
DROP TABLE Project;

DROP TABLE QnA_Reply;
DROP TABLE QnA_Img;
DROP TABLE QnA;

DROP TABLE Notice_Img;
DROP TABLE Notice;

DROP TABLE Creator;
DROP TABLE Member;

DROP SEQUENCE VideoChat_SEQ;
DROP SEQUENCE Project_Notice_Img_SEQ;
DROP SEQUENCE QnA_Reply_SEQ;
DROP SEQUENCE QnA_Img_SEQ;
DROP SEQUENCE QnA_SEQ;
DROP SEQUENCE Notice_Img_SEQ;
DROP SEQUENCE Notice_SEQ;
DROP SEQUENCE Order_SEQ;
DROP SEQUENCE OrderPay_SEQ;
DROP SEQUENCE Project_Intro_Img_SEQ;
DROP SEQUENCE Project_SEQ;
DROP SEQUENCE Member_SEQ;








CREATE TABLE Member (
	m_uid	NUMBER		NOT NULL,
	m_email	VARCHAR2(1000)		NOT NULL,
	m_pw	VARCHAR2(1000)		NOT NULL,
	m_nickname	VARCHAR2(1000)		NOT NULL,
	m_addr	VARCHAR2(1000)		NOT NULL,
    m_addr_detail	VARCHAR2(1000)		NOT NULL,
	m_type VARCHAR2(10)		NOT NULL,
	m_regdate	DATE		NOT NULL,
	m_enabled	VARCHAR2(10)		NOT NULL,
	m_deldate	DATE	DEFAULT NULL	NULL,
    CONSTRAINT m_type_check CHECK(m_type IN('일반','창작','관리')),
    CONSTRAINT m_enabled_check CHECK(m_enabled IN('Y','N'))
);


CREATE SEQUENCE Member_SEQ NOCACHE;
--SELECT Member_SEQ.CURRVAL FROM DUAL;
--SELECT * FROM USER_SEQUENCES;
--DROP SEQUENCE Member_SEQ;



CREATE TABLE Creator (
	m_uid	NUMBER		NOT NULL,
	create_name	VARCHAR2(1000)		NOT NULL,
	create_intro	VARCHAR2(1000)		NOT NULL
);



CREATE TABLE Project (
	p_id	NUMBER		NOT NULL,
	p_title	VARCHAR2(1000)		NOT NULL,
	p_category	VARCHAR2(1000)		NOT NULL,
	target_amount	NUMBER		NOT NULL,
	p_regdate	DATE		NOT NULL,
	start_date	DATE		NOT NULL,
	end_date	DATE		NOT NULL,
	creator_uid	NUMBER		NOT NULL,
     CONSTRAINT p_category_chk CHECK(p_category IN('출판','공예','예술','공연','푸드','패션'))
);


CREATE SEQUENCE Project_SEQ NOCACHE;
--SELECT Project_SEQ.CURRVAL FROM DUAL;
--SELECT * FROM USER_SEQUENCES;
--DROP SEQUENCE Project_SEQ;


CREATE TABLE Project_title_img (
	p_id	NUMBER		NOT NULL,
	title_origin_name	VARCHAR2(1000)		NOT NULL,
	title_stored_name	VARCHAR2(1000)		NOT NULL,
	title_stored_path	VARCHAR2(1000)		NOT NULL,
	title_file_size	NUMBER		NOT NULL
);



CREATE TABLE Project_Intro (
	p_id	NUMBER		NOT NULL,
	p_intro	VARCHAR2(4000)		NOT NULL
);


CREATE TABLE OrderPay (
	Order_Id	NUMBER		NOT NULL,
	order_name	VARCHAR2(1000)		NOT NULL,
	order_pay	NUMBER		NOT NULL,
	order_date	DATE		NOT NULL,
	order_phone	VARCHAR2(1000)		NOT NULL,
	order_email	VARCHAR2(1000)		NOT NULL,
	order_addr	VARCHAR2(1000)		NOT NULL,
    imp_uid VARCHAR2(1000) NOT NULL,
	p_id	NUMBER		NOT NULL,
	m_uid	NUMBER		NOT NULL
);

CREATE SEQUENCE OrderPAY_SEQ NOCACHE;
--SELECT OrderPAY_SEQ.CURRVAL FROM DUAL;
--SELECT * FROM USER_SEQUENCES;
--DROP SEQUENCE OrderPAY_SEQ;


CREATE TABLE Notice (
	notice_id	NUMBER		NOT NULL,
	notice_title	VARCHAR2(1000)		NOT NULL,
	notice_content	VARCHAR2(4000)		NOT NULL,
	notice_regdate	DATE		NOT NULL,
	m_uid	NUMBER		NOT NULL
);

CREATE SEQUENCE Notice_SEQ NOCACHE;
--SELECT Notice_SEQ.CURRVAL FROM DUAL;
--SELECT * FROM USER_SEQUENCES;
--DROP SEQUENCE Notice_SEQ;


CREATE TABLE QnA (
	qna_id	NUMBER		NOT NULL,
	qna_title	VARCHAR2(1000)		NOT NULL,
	qna_content	VARCHAR2(4000)		NOT NULL,
	qna_regdate	DATE		NOT NULL,
	qna_hit	NUMBER	DEFAULT 0	NOT NULL,
	m_uid	NUMBER		NOT NULL
);

CREATE SEQUENCE QnA_SEQ NOCACHE;
--SELECT QnA_SEQ.CURRVAL FROM DUAL;
--SELECT * FROM USER_SEQUENCES;
--DROP SEQUENCE QnA_SEQ;


CREATE TABLE QnA_Reply (
	qna_reply_id	NUMBER		NOT NULL,
	reply_content	VARCHAR2(4000)		NOT NULL,
	reply_regdate	DATE		NOT NULL,
	qna_id	NUMBER		NOT NULL,
	m_uid	NUMBER		NOT NULL
);

CREATE SEQUENCE QnA_Reply_SEQ NOCACHE;
--SELECT * FROM USER_SEQUENCES;
--DROP SEQUENCE QnA_Reply_SEQ;


CREATE TABLE Project_Fund_Guide (
	p_id	NUMBER		NOT NULL,
	fund_guide_content	VARCHAR2(4000)		NOT NULL
);


CREATE TABLE Project_Notice (
	p_notice_no	NUMBER		NOT NULL,
	p_id	NUMBER		NOT NULL,
	p_notice_title	VARCHAR2(1000)		NOT NULL,
	p_notice_content	VARCHAR2(4000)		NOT NULL,
	p_notice_regdate	DATE		NOT NULL
);






ALTER TABLE Member ADD CONSTRAINT PK_MEMBER PRIMARY KEY (
	m_uid
);

ALTER TABLE Creator ADD CONSTRAINT PK_CREATOR PRIMARY KEY (
	m_uid
);

ALTER TABLE Project ADD CONSTRAINT PK_PROJECT PRIMARY KEY (
	p_id
);

ALTER TABLE Project_title_img ADD CONSTRAINT PK_PROJECT_TITLE_IMG PRIMARY KEY (
	p_id
);

ALTER TABLE Project_Intro ADD CONSTRAINT PK_PROJECT_INTRO PRIMARY KEY (
	p_id
);


ALTER TABLE OrderPay ADD CONSTRAINT PK_ORDER PRIMARY KEY (
	Order_Id
);

ALTER TABLE Notice ADD CONSTRAINT PK_NOTICE PRIMARY KEY (
	notice_id
);

ALTER TABLE QnA ADD CONSTRAINT PK_QNA PRIMARY KEY (
	qna_id
);



ALTER TABLE QnA_Reply ADD CONSTRAINT PK_QNA_REPLY PRIMARY KEY (
	qna_reply_id
);

ALTER TABLE Project_Fund_Guide ADD CONSTRAINT PK_PROJECT_FUND_GUIDE PRIMARY KEY (
	p_id
);

ALTER TABLE Project_Notice ADD CONSTRAINT PK_PROJECT_NOTICE PRIMARY KEY (
	p_notice_no,
	p_id
);



ALTER TABLE Creator ADD CONSTRAINT FK_Member_TO_Creator_1 FOREIGN KEY (
	m_uid
)
REFERENCES Member (
	m_uid
);

ALTER TABLE Project ADD CONSTRAINT FK_Creator_TO_Project_1 FOREIGN KEY (
	creator_uid
)
REFERENCES Creator (
	m_uid
);

ALTER TABLE Project_title_img ADD CONSTRAINT FK_P_t_img_1 FOREIGN KEY (
	p_id
)
REFERENCES Project (
	p_id
);

ALTER TABLE Project_Intro ADD CONSTRAINT FK_Project_TO_Project_Intro_1 FOREIGN KEY (
	p_id
)
REFERENCES Project (
	p_id
);


ALTER TABLE OrderPay ADD CONSTRAINT FK_Project_TO_Order_1 FOREIGN KEY (
	p_id
)
REFERENCES Project (
	p_id
);

ALTER TABLE OrderPay ADD CONSTRAINT FK_Member_TO_Order_1 FOREIGN KEY (
	m_uid
)
REFERENCES Member (
	m_uid
);

ALTER TABLE Notice ADD CONSTRAINT FK_Member_TO_Notice_1 FOREIGN KEY (
	m_uid
)
REFERENCES Member (
	m_uid
);


ALTER TABLE QnA ADD CONSTRAINT FK_Member_TO_QnA_1 FOREIGN KEY (
	m_uid
)
REFERENCES Member (
	m_uid
);

ALTER TABLE QnA_Reply ADD CONSTRAINT FK_QnA_TO_QnA_Reply_1 FOREIGN KEY (
	qna_id
)
REFERENCES QnA (
	qna_id
);

ALTER TABLE QnA_Reply ADD CONSTRAINT FK_Member_TO_QnA_Reply_1 FOREIGN KEY (
	m_uid
)
REFERENCES Member (
	m_uid
);

ALTER TABLE Project_Fund_Guide ADD CONSTRAINT FK_Fund_Guide_1 FOREIGN KEY (
	p_id
)
REFERENCES Project (
	p_id
);

ALTER TABLE Project_Notice ADD CONSTRAINT FK_P_P_Notice_1 FOREIGN KEY (
	p_id
)
REFERENCES Project (
	p_id
);



