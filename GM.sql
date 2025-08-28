drop table users;
--유저 테이블 틀 만들기
create table users(
user_id VARCHAR2(20) primary key NOT NULL,
username VARCHAR2(50) NOT NULL,
user_nick_name VARCHAR2(30) NOT NULL,
email VARCHAR2(100) NOT NULL,
password VARCHAR2(50) NOT NULL,
reg_date VARCHAR2(30) NOT NULL
);

--유저 채우기 
INSERT INTO users (user_id, username, user_nick_name, email, password, reg_date)
VALUES ('calmbreeze', '이도철', '하자르', 'calmbreeze@test.com', 'pass01', '2025/07/08');

INSERT INTO users (user_id, username, user_nick_name, email, password, reg_date)
VALUES ('softmoon', '김민수', '유다', 'softmoon@test.com', 'pass02', '2025/07/11');

INSERT INTO users (user_id, username, user_nick_name, email, password, reg_date)
VALUES ('gentlewave', '이지현', '소보루', 'gentlewave@test.com', 'pass03', '2025/06/26');

INSERT INTO users (user_id, username, user_nick_name, email, password, reg_date)
VALUES ('quietforest', '박나리', '잔다', 'quietforest@test.com', 'pass04', '2025/07/23');

INSERT INTO users (user_id, username, user_nick_name, email, password, reg_date)
VALUES ('mellowstone', '김도현', '하다스', 'mellowstone@test.com', 'pass05', '2025/07/16');

INSERT INTO users (user_id, username, user_nick_name, email, password, reg_date)
VALUES ('silentriver', '이수진', '강철', 'silentriver@test.com', 'pass06', '2025/06/15');

--테이블 확인
select * from users;
--확정
commit; 

--캐릭터 시퀀스 번호 만들기
CREATE SEQUENCE char_seq; 
drop sequence char_seq;
d
--캐릭터 테이블 틀 만들기
drop table characters ;
CREATE table characters (
char_id NUMBER PRIMARY KEY,
user_id VARCHAR2(20) NOT NULL, 
char_name VARCHAR2(50)NOT NULL,
char_class VARCHAR2(50)NOT NULL,
char_level NUMBER NOT NULL,
hp NUMBER NOT NULL,
mp NUMBER NOT NULL,
created_at VARCHAR2(30) NOT NULL
);

--캐릭터 채우기 
INSERT INTO characters (char_id, user_id, char_name, char_class, char_level, hp, mp, created_at)
VALUES (char_seq.NEXTVAL, 'calmbreeze', '하자르', '전사', 5, 350, 50, '2025/07/08');


INSERT INTO characters (char_id, user_id, char_name, char_class, char_level, hp, mp, created_at)
VALUES (char_seq.NEXTVAL, 'softmoon', '유다', '궁수', 3, 200, 80, '2025/07/11');


INSERT INTO characters (char_id, user_id, char_name, char_class, char_level, hp, mp, created_at)
VALUES (char_seq.NEXTVAL, 'gentlewave', '소보루', '마법사', 7, 180, 300, '2025/06/26');


INSERT INTO characters (char_id, user_id, char_name, char_class, char_level, hp, mp, created_at)
VALUES (char_seq.NEXTVAL, 'quietforest', '잔다', '힐러', 1, 120, 150, '2025/07/23');


INSERT INTO characters (char_id, user_id, char_name, char_class, char_level, hp, mp, created_at)
VALUES (char_seq.NEXTVAL, 'mellowstone', '하다스', '도적', 2, 170, 60, '2025/07/16');


INSERT INTO characters (char_id, user_id, char_name, char_class, char_level, hp, mp, created_at)
VALUES (char_seq.NEXTVAL, 'silentriver', '강철', '팔라딘', 10, 500, 100, '2025/06/15');

--확인
select * from characters;

--확정
commit;

--아이템 고유 번호 시퀀스로 생성
CREATE SEQUENCE items_seq; 
drop sequence items_seq;
--아이템 테이블 틀 만들기
drop table items;
CREATE TABLE items (
item_id NUMBER PRIMARY KEY, 
char_id NUMBER NOT NULL,
name VARCHAR2(50) NOT NULL,
type VARCHAR2(20) NOT NULL,
power NUMBER NOT NULL,
price NUMBER NOT NULL
);


-- 아이템 채우기
INSERT INTO items (item_id, char_id, name, type, power, price)
VALUES (items_seq.NEXTVAL, 1, '강철검', '무기', 50, 1000);

INSERT INTO items (item_id, char_id, name, type, power, price)
VALUES (items_seq.NEXTVAL, 2, '사냥활', '무기', 35, 800);

INSERT INTO items (item_id, char_id, name, type, power, price)
VALUES (items_seq.NEXTVAL, 3, '마법봉', '무기', 20, 1200);

INSERT INTO items (item_id, char_id, name, type, power, price)
VALUES (items_seq.NEXTVAL, 3, '마나로브', '방어구', 10, 900);

INSERT INTO items (item_id, char_id, name, type, power, price)
VALUES (items_seq.NEXTVAL, 4, '치유의 지팡이', '무기', 15, 700);

INSERT INTO items (item_id, char_id, name, type, power, price)
VALUES (items_seq.NEXTVAL, 4, '힐링 로브', '방어구', 8, 600);

INSERT INTO items (item_id, char_id, name, type, power, price)
VALUES (items_seq.NEXTVAL, 5, '단검', '무기', 25, 500);

INSERT INTO items (item_id, char_id, name, type, power, price)
VALUES (items_seq.NEXTVAL, 5, '가죽 방어구', '방어구', 12, 700);

INSERT INTO items (item_id, char_id, name, type, power, price)
VALUES (items_seq.NEXTVAL, 6, '성기사의 검', '무기', 60, 2000);

INSERT INTO items (item_id, char_id, name, type, power, price)
VALUES (items_seq.NEXTVAL, 6, '빛의 방패', '방어구', 40, 1800);

--확인
select * from items;
rollback;

--확정
commit;

drop table items ;




