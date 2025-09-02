-- V2: Migration to add RANK column to register table

ALTER TABLE TB_REGISTER
ADD COLUMN rank VARCHAR(255);
