CREATE DATABASE tsherpa;

USE tsherpa;

CREATE TABLE ROLE (
                      role_id INT PRIMARY KEY AUTO_INCREMENT,
                      ROLE VARCHAR(255) DEFAULT NULL
);

CREATE TABLE USER (
                      user_id INT PRIMARY KEY AUTO_INCREMENT,
                      active INT DEFAULT 0,
                      login_id VARCHAR(255) NOT NULL,
                      user_name VARCHAR(255) NOT NULL
);

CREATE TABLE user_role (
                           user_id INT NOT NULL,
                           role_id INT NOT NULL,
                           PRIMARY KEY (user_id, role_id)
);