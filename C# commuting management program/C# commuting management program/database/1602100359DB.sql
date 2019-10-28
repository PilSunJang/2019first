/*
SQLyog Community v13.1.2 (64 bit)
MySQL - 5.5.62 : Database - login
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`login` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;

USE `login`;

/*Table structure for table `login` */

DROP TABLE IF EXISTS `login`;

CREATE TABLE `login` (
  `name` varchar(16) COLLATE utf8_bin NOT NULL,
  `position` varchar(16) COLLATE utf8_bin NOT NULL,
  `department` varchar(16) COLLATE utf8_bin NOT NULL,
  `userid` varchar(16) COLLATE utf8_bin NOT NULL,
  `passwd` varchar(16) COLLATE utf8_bin NOT NULL,
  `hustart` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `huend` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `homein` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `homeout` varchar(50) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `login` */

insert  into `login`(`name`,`position`,`department`,`userid`,`passwd`,`hustart`,`huend`,`homein`,`homeout`) values 
('장필순','과장','기획부','vlftns','1234','2019-06-24','2019-06-29','2019-06-24 오후 2:36:10','2019-06-24 오후 2:36:15');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
