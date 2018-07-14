DROP SCHEMA IF EXISTS eshop;
CREATE SCHEMA eshop;
USE eshop;
GRANT ALL PRIVILEGES ON eshop.* TO 'root'@'%' IDENTIFIED BY 'pass';
GRANT ALL PRIVILEGES ON eshop.* TO 'root'@'localhost' IDENTIFIED BY 'pass';