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

create table userinfo(
                         no int primary key  AUTO_INCREMENT \
                             id varchar(20) NOT NULL,
                         pw VARCHAR(100) NOT NULL,
                         NAME VARCHAR(50) NOT NULL,
                         email VARCHAR(100) NOT NULL,
                         tel VARCHAR(50) NOT NULL,
                         regdate DATETIME DEFAULT CURRENT_TIME,
                         POINT INT default 0,
                         USING VARCHAR(20),
                         authority VARCHAR(20),
                         authorityNm VARCHAR(20),
                         auth VARCHAR(20),
                         authorities VARCHAR(20)
);


COMMIT;

SELECT * FROM userinfo;

-- =====================================================================================

USE edumon;

CREATE TABLE euser(
                      id INT PRIMARY KEY AUTO_INCREMENT,
                      name VARCHAR(20) NOT NULL,
                      PASSWORD VARCHAR(300) NOT NULL,
                      username VARCHAR(50) NOT NULL,
                      email VARCHAR(100) NOT NULL,
                      address VARCHAR(300),
                      tel VARCHAR(20),
                      regdate DATETIME DEFAULT CURRENT_TIMESTAMP,
                      lev VARCHAR(20) DEFAULT 'USER',
                      act VARCHAR(20) DEFAULT 'JOIN',
                      CONSTRAINT key_name UNIQUE(NAME)
);

DROP TABLE euser;

DESC euser;

-- 더미데이터
INSERT INTO euser VALUES (DEFAULT, 'kim', '1234', '김', 'kim@gmail.com', '가산동', '010-7329-7484', DEFAULT, DEFAULT, DEFAULT);
INSERT INTO euser VALUES (DEFAULT, 'lee', '1234', '이', 'kim@gmail.com', '가산동', '010-7329-7484', DEFAULT, DEFAULT, DEFAULT);
INSERT INTO euser VALUES (DEFAULT, 'admin', '1234', '오태훈', 'kim@gmail.com', '가산동', '010-7329-7484', DEFAULT, DEFAULT, DEFAULT);

UPDATE euser SET lev='ADMIN' WHERE NAME ='admin';
UPDATE euser SET lev='EMP' WHERE NAME ='lee';

SELECT * FROM euser;

COMMIT;