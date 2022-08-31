create database testdb;

--2022-08-30 생성

CREATE TABLE `product` (
  `pno` int NOT NULL AUTO_INCREMENT,
  `pname` varchar(100) NOT NULL,
  `price` int NOT NULL,
  `reg_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `made_by` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`pno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci