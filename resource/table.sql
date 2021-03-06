CREATE TABLE USERLIST (
	USER_ID	VARCHAR2(20) CONSTRAINT PK_USER_ID PRIMARY KEY, -- ȸ�� ���̵�
	USER_NAME	VARCHAR2(20)	NOT NULL, -- ȸ�� �̸�
	USER_PW	VARCHAR2(20)	NOT NULL, -- ȸ�� ��й�ȣ
	USER_HP	VARCHAR2(20)	NOT NULL, -- ȸ�� ��ȭ��ȣ
	USER_ZIPCODE	VARCHAR2(7)	NULL, -- ȸ�� �����ȣ
	USER_ADDR	VARCHAR2(50)	NULL, -- ȸ�� �ּ�
	USER_ADDRDETAIL	VARCHAR2(80)	NULL, -- ȸ�� ���ּ�
	USER_EMAIL	VARCHAR2(40)	NOT NULL, -- ȸ�� �̸���
	USER_BIRTH	VARCHAR2(12)	NOT NULL, -- ȸ�� ����
	USER_GENDER	VARCHAR2(6)	NOT NULL, -- ȸ�� ����
	USER_STATE	NUMBER(1)	NOT NULL, -- ȸ�� ���� (0 : Ż��, 1 : �Ϲ�ȸ��, 2 : ������) 
	USER_REGDATE	DATE	NOT NULL, -- ȸ�� �����(������)
	USER_BUYCOUNT	NUMBER	NULL -- ȸ�� ���� ���ż�
);

SELECT * FROM USERLIST; 
SELECT * FROM PRODUCT; 
CREATE TABLE PRODUCT (
	PROD_ID	NUMBER(6)	CONSTRAINT PK_PRODUCT_ID PRIMARY KEY, -- ��ǰ ���̵�
	PROD_NAME	VARCHAR2(60)	NOT NULL, -- ��ǰ��
	PROD_NAME_EN	VARCHAR2(60)	NOT NULL, -- ��ǰ�� ����
	PROD_WINERY	VARCHAR2(60)	NOT NULL, -- ������
	PROD_WINERY_EN	VARCHAR2(60)	NOT NULL, -- ������ ����
	PROD_VINTAGE	VARCHAR2(26)	NOT NULL, -- �����⵵
	PROD_TYPE	VARCHAR2(11)	NOT NULL, -- ���� Ÿ��
	PROD_NATION	VARCHAR2(60)	NOT NULL, -- ��������
	PROD_ALCOHOL	VARCHAR2(5)	NOT NULL, -- ����
	PROD_SWEET	VARCHAR2(30)	NOT NULL, -- �絵
	PROD_IMG_URL	VARCHAR2(30)	NOT NULL, -- �̹���
	PROD_PRICE	NUMBER(10)	NOT NULL, -- ����
	PROD_MACH	VARCHAR2(4000)	NULL, -- Ǫ���Ī
	PROD_TASTE	VARCHAR2(4000)	NULL, -- ��
	PROD_DETAIL	VARCHAR2(4000)	NULL, -- �󼼼���
	PROD_QTY	NUMBER(3)	NOT NULL, -- ��ǰ ���
	PROD_REGDATE	DATE	NOT NULL, -- �����
	PROD_STATE	NUMBER(1)	NOT NULL -- ���� ���º���
);

create sequence PROD_ID_SEQ start with 60000 nocache; -- ��ǰ ���̵� ������
SELECT PROD_ID_SEQ.nextval FROM DUAL;
drop sequence PROD_ID_SEQ;

ALTER TABLE PRODUCT ADD CONSTRAINT PK_PRODUCT_ID PRIMARY KEY (PROD_ID);

CREATE TABLE WISH (
	WISH_ID	NUMBER(6)	CONSTRAINT PK_WISH_ID PRIMARY KEY, -- ���� ���̵�
	USER_ID	VARCHAR2(20)	CONSTRAINT FK_USER_ID REFERENCES USERLIST(USER_ID), -- ȸ�� ���̵�
	PROD_ID	NUMBER(38)	CONSTRAINT FK_PROD_ID REFERENCES PRODUCT(PROD_ID) -- ��ǰ ���̵�
);

create sequence WISH_ID_SEQ nocache; -- �� ��� ������
SELECT WISH_ID_SEQ.currval FROM DUAL;
drop sequence WISH_ID_SEQ;

CREATE TABLE CART (
	CART_ID	NUMBER(6)	CONSTRAINT PK_CART_ID PRIMARY KEY, -- īƮ ���̵�
	CART_QTY	NUMBER(5)	NOT NULL, -- ���ż���
	USER_ID	VARCHAR2(20)	CONSTRAINT CART_FK_USER_ID REFERENCES USERLIST(USER_ID), -- ȸ�� ���̵�
	PROD_ID	NUMBER(38)	CONSTRAINT CART_FK_PROD_ID REFERENCES PRODUCT(PROD_ID) -- ��ǰ ���̵�
);

create sequence CART_ID_SEQ nocache; -- īƮ ��� ������
SELECT CART_ID_SEQ.currval FROM DUAL;
drop sequence CART_ID_SEQ;

CREATE TABLE COUPON (
	CPON_NUM	Number(5)	CONSTRAINT PK_CPON_NUM PRIMARY KEY, -- ���� ���̵�
	CPON_NAME	VARCHAR2(200)	NOT NULL, -- ������
	CPON_DC_PERCENT	NUMBER(5)	NOT NULL, -- ���η�
	CPON_DC_PRICE	NUMBER(10)	NULL, -- ���αݾ�
	CPON_NEW_QTY	NUMBER(10)	NOT NULL, -- ������������ 
	CPON_REM_QTY	NUMBER(10)	NOT NULL -- �����ܿ�����
);

create sequence CPON_NUM_SEQ nocache; -- ���� ��� ������
SELECT CPON_NUM_SEQ.currval FROM DUAL;
drop sequence CPON_NUM_SEQ;

CREATE TABLE COUPONLINE (
	CPON_USE_NUM	NUMBER(5)	CONSTRAINT PK_COUPONLINE PRIMARY KEY, -- ���� �߱��Ϸù�ȣ
	CPON_NUM	NUMBER(5)	CONSTRAINT COUPONLINE_FK_CPON_NUM REFERENCES COUPON(CPON_NUM), -- ���� ���̵�
	USER_ID	VARCHAR2(20)	CONSTRAINT COUPONLINE_FK_USER_ID REFERENCES USERLIST(USER_ID), -- ȸ�� ���̵�
	CPON_USE_STAE	NUMBER(1)	NOT NULL, -- ���� ��뿩��(0 : ���, 1 : �̻��)
	CPON_REGDATE	DATE	NULL, -- ���� �߱���
	CPON_ENDDATE	DATE	NULL -- ���� ��ȿ�Ⱓ ������
);

create sequence CPON_USE_NUM_SEQ nocache; -- ���� �߱� �Ϸù�ȣ ������
SELECT CPON_USE_NUM_SEQ.currval FROM DUAL;
drop sequence CPON_USE_NUM_SEQ;

CREATE TABLE CANCEL (
	CANC_PG_TID	VARCHAR2(50) CONSTRAINT PK_CANCEL_CANC_PG_TID PRIMARY KEY, -- PG�� ���� ��ҹ�ȣ
	PAY_NO	VARCHAR2(50)	NULL, -- �ŷ�������ȣ
	CANC_AMOUNT	NUMBER	NULL, -- (�κ�)��� ��û�ݾ�
	CANC_REASON	VARCHAR2(100)	NULL, -- ��� ����
	CANC_DATE	DATE NULL -- ���� ��ҵ� �ð�
);

CREATE TABLE ORDERT (
	O_NO	NUMBER(5)	CONSTRAINT PK_ORDERT_O_NO PRIMARY KEY, -- �ֹ���ȣ
	USER_ID	VARCHAR2(20) CONSTRAINT ORDERT_FK_USER_ID REFERENCES USERLIST(USER_ID), -- ȸ�� ���̵�
	O_DATE	DATE	NOT NULL, -- �ֹ�����
	O_PRICE	NUMBER(10)	NOT NULL, -- �ֹ��Ѿ�
	O_ADDR	VARCHAR2(20)	NOT NULL, -- ����ּ�
	O_ZIPCODE	VARCHAR2(7)	NOT NULL, -- �����ȣ
	O_SHIP_NO	VARCHAR2(20)	NULL, -- ������ȣ
	O_RECIPIENT_NAME	VARCHAR2(10)	NOT NULL, -- ������ �̸�
	O_DELIVERY_CHARGE	NUMBER(5)	NULL, -- ��ۺ�
	O_STATUS	NUMBER(1)	NOT NULL -- �ֹ�����
);
SELECT * FROM ORDERT; 
create sequence O_NO_SEQ nocache; -- �ֹ���ȣ ������
SELECT O_NO_SEQ.currval FROM DUAL;
drop sequence O_NO_SEQ;

CREATE TABLE ORDERLINE (
	OLINE_ID	NUMBER(5)	CONSTRAINT PK_ORDERLINE PRIMARY KEY, -- �ֹ��� ���̵�
	PROD_ID	NUMBER(38)	CONSTRAINT ORDERLINE_FK_PROD_ID REFERENCES PRODUCT(PROD_ID), -- ��ǰ ���̵�
	O_NO	NUMBER(5)	CONSTRAINT ORDERLINEFK_O_NO REFERENCES ORDERT(O_NO), -- �ֹ���ȣ
	CPON_USE_NUM	NUMBER(5)	CONSTRAINT ORDERLINE_FK_CPON_USE_NUM REFERENCES COUPONLINE(CPON_USE_NUM), -- ��������Ϸù�ȣ
	OLINE_QTY	NUMBER(3)	NOT NULL, -- �ֹ�����
	OLINE_PRICE	NUMBER(10)	NOT NULL, -- �ֹ��ݾ�
	OLINE_DCPRICE	NUMBER(10)	NULL -- �ֹ����αݾ�
);

create sequence OLINE_ID_SEQ nocache; -- �ֹ��󼼹�ȣ ������
SELECT OLINE_ID_SEQ.currval FROM DUAL;
drop sequence OLINE_ID_SEQ;

CREATE TABLE PAYMENT (
	PAY_NO	VARCHAR2(50)	CONSTRAINT PK_PAY_NO PRIMARY KEY, -- �ŷ�������ȣ
	O_NO	NUMBER(5)	CONSTRAINT PAYMENT_FK_O_NO REFERENCES ORDERT(O_NO), -- �ֹ���ȣ
	PAY_STATUS	VARCHAR2(10)	NULL, -- �������� 
	PAY_CARD_NO	VARCHAR2(30)	NULL, -- ī���ȣ
	PAY_CARD_NAME	VARCHAR2(20)	NULL, -- ī����
	PAY_INSTALLMANT_MONTH	NUMBER	NULL -- �Һΰ�����
);

CREATE TABLE QUESTION (
	Q_NUM	NUMBER(6)	CONSTRAINT PK_Q_NUM PRIMARY KEY, -- ���Ǳ� ��ȣ
	USER_ID	VARCHAR2(20)	CONSTRAINT QUESTION_FK_USER_ID REFERENCES USERLIST(USER_ID), -- ȸ�� ���̵�
	PROD_ID	NUMBER(38)	CONSTRAINT QUESTION_FK_PROD_ID REFERENCES PRODUCT(PROD_ID), -- ��ǰ ���̵�
	Q_FIELD	VARCHAR2(10)	NOT NULL, -- ī�װ�
	Q_TITLE	VARCHAR2(60)	NOT NULL, -- �� ����
	Q_CONTENT	VARCHAR2(4000)	NOT NULL, -- �� ����
	Q_FILES	VARCHAR2(30)	NULL, -- ÷������
	Q_REGDATE	DATE	NOT NULL, -- �����
	Q_SHOWSTATUS	NUMBER(1)	NOT NULL -- ���� ���º���(0 : �����, 1 : ����)
);

create sequence Q_NUM_SEQ nocache; -- ���Ǳ� ��ȣ ������
SELECT Q_NUM_SEQ.currval FROM DUAL;
drop sequence Q_NUM_SEQ;


CREATE TABLE ANSWER (
	A_NUM	NUMBER(6)	CONSTRAINT PK_A PRIMARY KEY, -- �亯 �� ��ȣ
	Q_NUM	NUMBER(6)	CONSTRAINT ANSWER_FK_Q_NUM REFERENCES QUESTION(Q_NUM), -- ���� �� ��ȣ
	A_CONTENT	VARCHAR2(4000)	NOT NULL, -- �亯 ����
	A_ANSID	VARCHAR2(20)	NOT NULL, -- �亯 �ۼ���(������) ���̵�
	A_REGDATE	DATE	NOT NULL -- �亯 �����
);

create sequence A_NUM_SEQ nocache; -- �亯�� ��ȣ ������
SELECT A_NUM_SEQ.currval FROM DUAL;
drop sequence A_NUM_SEQ;


SELECT * FROM REVIEW;
CREATE TABLE REVIEW (
	REVIEW_ID	NUMBER(6)	CONSTRAINT PK_REVIEW_ PRIMARY KEY, -- �ı� �� ��ȣ
	PROD_ID	NUMBER(38)	CONSTRAINT REVIEW_FK_PROD_ID REFERENCES PRODUCT(PROD_ID), -- ��ǰ ���̵�
	USER_ID	VARCHAR2(20)	CONSTRAINT REVIEW_FK_USER_ID REFERENCES USERLIST(USER_ID), -- ȸ�� ���̵�
	O_NO	NUMBER(5)	CONSTRAINT REVIEW_FK_O_NO REFERENCES ORDERT(O_NO), -- �ֹ���ȣ
	REVIEW_TITLE	VARCHAR2(50)	NOT NULL, -- �ı� ����
	REVIEW_CONTENT	VARCHAR2(4000)	NOT NULL, -- �ı� ����
	REVIEW_STAR_SCOPE	NUMBER(1)	NOT NULL, -- ����
	REVIEW_REGDATE	DATE	NOT NULL, -- �����
	REVIEW_IMG_URL	VARCHAR2(200)	NULL, -- �̹���
	REVIEW_VCOUNT	NUMBER(4)	NOT NULL -- ��ȸ��
);

create sequence REVIEW_ID_SEQ nocache; -- �ı� �� ��ȣ ������
SELECT REVIEW_ID_SEQ.currval FROM DUAL;
drop sequence REVIEW_ID_SEQ;

--review 
select * from review;









CREATE TABLE NOTICE (
	N_NUM	NUMBER(6)	CONSTRAINT PK_NOTICE PRIMARY KEY, -- ������ ��ȣ
	N_TITLE	VARCHAR2(50)	NOT NULL, -- ������ ����
	N_CONTENT	VARCHAR2(1000)	NOT NULL, -- ������ ����
	N_IMAGE	VARCHAR2(200)	NULL, -- ������ �̹���
	N_REGDATE	DATE	NULL, -- ������ �����
	N_VIEWCOUNT	NUMBER	NULL, -- ������ ��ȸ��
	N_FIELD	NUMBER(1)	NULL -- ������ ī�װ�(0 : ����, 1 : �̺�Ʈ, 2 : ���ֹ�������)
);

delete from notice where n_num between 10 and 145;
select * from notice;
select * from review;
commit;

create sequence N_NUM_SEQ nocache; -- ���� �� ��ȣ ������
SELECT N_NUM_SEQ.currval FROM DUAL;
drop sequence N_NUM_SEQ;

INSERT INTO NOTICE VALUES(N_NUM_SEQ.NEXTVAL, '2016 ���� ���� ������Ʈ', '���μ�����Ʈ�� ������ ������ ����������','http://img.wine21.com/W0101/20120620120000118331I01b.jpg', SYSDATE,0,1);
INSERT INTO NOTICE VALUES(N_NUM_SEQ.NEXTVAL, '�������� �̺�Ʈ', '������������!', 'http://img.wine21.com/WINE_MST/TITLE/0157000/W0157121.jpg', SYSDATE,0,1);
INSERT INTO NOTICE VALUES(N_NUM_SEQ.NEXTVAL, '���������̺�Ʈ', '�������Ž� ��������!', 'https://img.wine21.com/WINE_MST/TITLE/0159000/W0159873.jpg', SYSDATE,0,1);
INSERT INTO NOTICE VALUES(N_NUM_SEQ.NEXTVAL, '����Ŭ���̺�Ʈ', '5���� �����̺�Ʈ', 'https://m.emart24.co.kr/assets/images/wineclub/img_event_bannner_2104_01.jpg?cacheParam=423', SYSDATE,0,1);
INSERT INTO NOTICE VALUES(N_NUM_SEQ.NEXTVAL, '�������̺�Ʈ', '���� ������ �̺�Ʈ', 'http://diodia.co.kr/wp-content/uploads/2018/02/%EC%B4%88%EC%BD%94%ED%9E%90-%EC%99%80%EC%9D%B82.jpg', SYSDATE,0,1);
INSERT INTO NOTICE VALUES(N_NUM_SEQ.NEXTVAL, 'ĳ�ù��̺�Ʈ', 'ĳ�ù� �̺�Ʈ', 'https://lh3.googleusercontent.com/proxy/mCr1W2jUunwdkWbhNmPiSQV0hEatyu6JrtzkIUPvrpyeiHJqMiGhQxWlz3AQtEgse4gq7RSyFVWHIokoxQ-R54hW0HQUNILfCzciuQNrEdFqkfuUTVnLwhLVMA', SYSDATE,0,1);
INSERT INTO NOTICE VALUES(N_NUM_SEQ.NEXTVAL, '����5�� ����', 'QR���� �����̺�Ʈ', 'https://cools.kr/wp-content/uploads/2021/04/ieis-ieieyeei-ioeioe-iioei-ae-4i-ioe-ee-ieu-320x205.png', SYSDATE,0,1);

update notice set n_image = 'http://menu.mt.co.kr/moneyweek/thumb/2019/10/13/06/2019101317138063561_1.jpg' where n_num=9;
https://cools.kr/wp-content/uploads/2021/04/ieis-ieieyeei-ioeioe-iioei-ae-4i-ioe-ee-ieu-320x205.png
https://lh3.googleusercontent.com/proxy/mCr1W2jUunwdkWbhNmPiSQV0hEatyu6JrtzkIUPvrpyeiHJqMiGhQxWlz3AQtEgse4gq7RSyFVWHIokoxQ-R54hW0HQUNILfCzciuQNrEdFqkfuUTVnLwhLVMA
http://diodia.co.kr/wp-content/uploads/2018/02/%EC%B4%88%EC%BD%94%ED%9E%90-%EC%99%80%EC%9D%B82.jpg
ALTER TABLE NOTICE MODIFY N_IMAGE VARCHAR2(4000);
SELECT * FROM NOTICE;
commit;
select * from NOTICE order by N_REGDATE desc;
select * from PRODUCT;
UPDATE NOTICE SET N_IMAGE = 'https://m.emart24.co.kr/assets/images/wineclub/img_event_bannner_2104_01.jpg?cacheParam=423' WHERE N_NUM=1;
UPDATE NOTICE SET N_FIELD = 0 WHERE N_NUM = 2;


--PAGINGó��
SELECT ROWNUM AS RNUM,A.N_NUM, A.N_TITLE,A.N_CONTENT,A.N_IMAGE,A.N_REGDATE,A.N_VIEWCOUNT,A.N_FIELD 
FROM 
    ( select N_NUM, N_TITLE,N_CONTENT,N_IMAGE,N_REGDATE,N_VIEWCOUNT,N_FIELD from NOTICE 
    order by N_REGDATE desc) A;
-----------------------------------------------------------------
SELECT ROWNUM AS RNUM,A.N_NUM, A.N_TITLE,A.N_CONTENT,A.N_IMAGE,A.N_REGDATE,A.N_VIEWCOUNT,A.N_FIELD 
FROM 
    ( select N_NUM, N_TITLE,N_CONTENT,N_IMAGE,N_REGDATE,N_VIEWCOUNT,N_FIELD from NOTICE 
    order by N_REGDATE desc) A
    WHERE ROWNUM BETWEEN 1 AND 6;
----------------------------------------------------------------------   
SELECT B.RNUM, B.N_NUM,B.N_TITLE,B.N_CONTENT,B.N_IMAGE,B.N_REGDATE,B.N_VIEWCOUNT,B.N_FIELD
FROM(
SELECT ROWNUM AS RNUM,A.N_NUM, A.N_TITLE,A.N_CONTENT,A.N_IMAGE,A.N_REGDATE,A.N_VIEWCOUNT,A.N_FIELD 
FROM (
    select N_NUM, N_TITLE,N_CONTENT,N_IMAGE,N_REGDATE,N_VIEWCOUNT,N_FIELD from NOTICE 
    order by N_REGDATE desc) A
    WHERE ROWNUM <= 6) B
WHERE B.RNUM >=1;

-------------------------------------------------
ALTER TABLE NOTICE MODIFY N_CONTENT VARCHAR2(4000);
delete from notice where n_num = 8;
commit;







--product
SELECT
    *
FROM review;
where PROD_ID=45732;

SELECT
    *
FROM  review join ordert
using(O_NO);


SELECT
    *
FROM  payment join ordert
using(O_NO) join userlist
using(user_id) join ORDERLINE
using(o_no);

select * from question
delete question where q_num between 14 and 21;
delete review where PROD_ID=37197;
commit

SELECT
    *
FROM product where PROD_ID=37198;

select count(*) from review where PROD_ID = 37198;