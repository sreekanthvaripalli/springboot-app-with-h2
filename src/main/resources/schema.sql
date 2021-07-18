-- noinspection SqlNoDataSourceInspectionForFile

CREATE TABLE USERDETAIL(
    id INT(10) NOT NULL AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    age INT(10) NOT NULL ,
    address VARCHAR(50) NOT NULL,

    PRIMARY KEY(id)
    );

insert into USERDETAIL (name, age, address) values
('sree', 27, 'KKD'),('elvie', 25, 'palawan');