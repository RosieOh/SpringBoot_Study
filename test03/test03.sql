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



