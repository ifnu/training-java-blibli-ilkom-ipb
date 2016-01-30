
--DDL : Data Definition Language
--create database, create table, alter table, 
--alter column in table, create index, create constraint

--create table customer
--field : id, name, email, address, birth_date
create table CUSTOMER (
    ID INT NOT NULL PRIMARY KEY,
    NAME VARCHAR(255),
    EMAIL VARCHAR(100),
    ADDRESS VARCHAR(255),
    BIRTH_DATE TIMESTAMP
);
DROP TABLE CUSTOMER;

--DML : Data Manipulation Language
--CRUD : Create Read Update Delete
--Create : insert, Read : select, Update : update
--         Delete : delete
INSERT INTO CUSTOMER(ID, NAME, EMAIL, ADDRESS, BIRTH_DATE) VALUES(1,'Fulan','fulan@email.com','kampus ibp','1991-01-03');
INSERT INTO CUSTOMER VALUES
    (1,'Fulan','fulan@email.com','kampus ibp','1991-01-03');
INSERT INTO CUSTOMER VALUES
    (1,'Fulan','fulan@email.com','kampus ibp','1991-01-03'),
    (2,'Rijen','rijen@email.com','kampus ibp','1981-01-03'),
    (3,'Rizki','rizki@email.com','kampus ibp','1971-01-03'),
    (4,'Ammar','ammar@email.com','kampus ibp','1970-01-03');

SELECT * FROM CUSTOMER;
SELECT * FROM CUSTOMER 
    WHERE ID=1;
SELECT * FROM CUSTOMER 
    WHERE ADDRESS LIKE '%ipb%';

UPDATE CUSTOMER SET ADDRESS = 'kampus dramaga' 
    WHERE ID=1;

DELETE FROM CUSTOMER 
    WHERE ID=1;
