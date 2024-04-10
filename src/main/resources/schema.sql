CREATE TABLE IF NOT EXISTS USERDETAIL(
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(50) NOT NULL,
    `age` INT NOT NULL ,
    `address` VARCHAR(50) NOT NULL
    );

insert into USERDETAIL (`name`, `age`, `address`) values
('sree', 27, 'KKD'),('elvie', 25, 'palawan');