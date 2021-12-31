CREATE DATABASE IF NOT EXISTS `casters`;

CREATE USER 'niall'@'localhost' IDENTIFIED BY 'local';
GRANT ALL ON *.* TO 'niall'@'%';
