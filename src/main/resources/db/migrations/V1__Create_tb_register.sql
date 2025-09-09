-- V1: Create tb_register table

CREATE TABLE tb_register (
id BIGINT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(255),
email VARCHAR(255) UNIQUE,
age INT,
rank VARCHAR(255),
img_url VARCHAR(255),
missions_id BIGINT
);