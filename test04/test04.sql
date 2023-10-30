Grant All PRIVILEGES on test1.* to 'test1'@%;

select CURRENT_TIMESTAMP();

create database edumon;

use edumon;

create table test1(no int primary key  auto_increment, id varchar(20), com VARCHAR(2000));

INSERT INTO test1 VALUES(DEFAULT, 'sirious920', '오늘 처음 스프링부트');
INSERT INTO test1 VALUES(DEFAULT, 'admin', '스프링부트 더미 테스트');

COMMIT;

SELECT * FROM test1;

-- ================================================================================================

create table test2(no int primary key  auto_increment, id varchar(20), com VARCHAR(2000));

INSERT INTO test2 VALUES(DEFAULT, 'sirious920', '오늘 처음 스프링부트');
INSERT INTO test2 VALUES(DEFAULT, 'admin', '스프링부트 더미 테스트');

COMMIT;

SELECT * FROM test2;

-- ===================================================================================================

create table test3(no int primary key  auto_increment, id varchar(20), com VARCHAR(2000));

INSERT INTO test3 VALUES(DEFAULT, 'sirious920', '오늘 처음 스프링부트');
INSERT INTO test3 VALUES(DEFAULT, 'admin', '스프링부트 더미 테스트');

COMMIT;

SELECT * FROM test3;

create table user(
                         no int primary key  AUTO_INCREMENT,
                             id varchar(20) NOT NULL,
                         pw VARCHAR(100) NOT NULL,
                         NAME VARCHAR(50) NOT NULL,
                         email VARCHAR(100) NOT NULL,
                         tel VARCHAR(50) NOT NULL,
                         regdate DATETIME DEFAULT CURRENT_TIME,
                         POINT INT default 0,
                         act VARCHAR(100),
                         lev INT defalut 0,
);


COMMIT;

SELECT * FROM userinfo;

create table userinfo(
                         userid varchar(20) NOT NULL,
                         username VARCHAR(50) NOT NULL,
                         password VARCHAR(100) NOT NULL,
                         email VARCHAR(100) NOT NULL,
                         tel VARCHAR(50) NOT NULL,
                         regdate DATETIME DEFAULT CURRENT_TIME,
                         POINT INT default 0,
                         using varchar(100),
                         authorities varchar(100),
                         authority varchar(50),
                         authorityNm varchar(100),
                         auth varchar(50),
);


COMMIT;

SELECT * FROM userinfo;








