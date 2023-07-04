/*
SQLyog Community v13.1.7 (64 bit)
MySQL - 10.4.28-MariaDB : Database - rent_a_car
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`rent_a_car` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;

USE `rent_a_car`;

/*Table structure for table `administrator` */

DROP TABLE IF EXISTS `administrator`;

CREATE TABLE `administrator` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(10) NOT NULL,
  `password` varchar(10) NOT NULL,
  `email` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `administrator` */

insert  into `administrator`(`id`,`username`,`password`,`email`) values 
(1,'admin','admin','admin@gmail'),
(2,'somika','somika','somika@gmail');

/*Table structure for table `client` */

DROP TABLE IF EXISTS `client`;

CREATE TABLE `client` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(15) NOT NULL,
  `lastname` varchar(15) NOT NULL,
  `telNumber` varchar(15) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `client` */

insert  into `client`(`id`,`firstname`,`lastname`,`telNumber`) values 
(1,'Milos','Zarkovic','0638195893'),
(2,'Marko','Ilic','0657855361'),
(3,'Anja','Markovic','0669149860'),
(4,'Marko','Trisic','0692477866'),
(5,'Filip','Stojanovic','0665122865'),
(6,'Marta','Petrovic','0642775486'),
(7,'Sara','Ilic','0695568121'),
(8,'Vuk','Jovanovic','0645778421'),
(9,'Marta','Petric','0655256564');

/*Table structure for table `pdv` */

DROP TABLE IF EXISTS `pdv`;

CREATE TABLE `pdv` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `percent` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `pdv` */

insert  into `pdv`(`id`,`percent`) values 
(1,0.18),
(2,0.2),
(3,0.32);

/*Table structure for table `pricelist` */

DROP TABLE IF EXISTS `pricelist`;

CREATE TABLE `pricelist` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dateFrom` date NOT NULL,
  `dateTo` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `pricelist` */

insert  into `pricelist`(`id`,`dateFrom`,`dateTo`) values 
(3,'2023-06-01','2023-07-01'),
(4,'2023-07-01','2023-09-01'),
(5,'2023-09-01','2023-12-01'),
(6,'2023-12-01','2023-12-31'),
(7,'2023-08-01','2023-08-31');

/*Table structure for table `pricelistitem` */

DROP TABLE IF EXISTS `pricelistitem`;

CREATE TABLE `pricelistitem` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `price` double NOT NULL,
  `typeOfPriceListItem` varchar(10) NOT NULL,
  `currency` varchar(3) NOT NULL,
  `pdv_fk` bigint(20) NOT NULL,
  `typeOfVehicle_fk` bigint(20) NOT NULL,
  `priceList_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `pdv_fk` (`pdv_fk`),
  KEY `typeOfVehicle_fk` (`typeOfVehicle_fk`),
  KEY `pricelistitem_ibfk_5` (`priceList_id`),
  CONSTRAINT `pricelistitem_ibfk_5` FOREIGN KEY (`priceList_id`) REFERENCES `pricelist` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `pricelistitem_ibfk_6` FOREIGN KEY (`pdv_fk`) REFERENCES `pdv` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `pricelistitem_ibfk_7` FOREIGN KEY (`typeOfVehicle_fk`) REFERENCES `typeofvehicle` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `pricelistitem` */

insert  into `pricelistitem`(`id`,`price`,`typeOfPriceListItem`,`currency`,`pdv_fk`,`typeOfVehicle_fk`,`priceList_id`) values 
(5,15000,'PERDAY','RSD',2,1,3),
(6,126,'PERDAY','EUR',2,1,3),
(7,59,'PERHOUR','USD',1,2,3),
(8,17700,'PERDAY','RSD',1,2,3),
(9,23760,'PERDAY','RSD',3,3,3),
(10,15930,'PERDAY','RSD',1,1,4),
(11,48,'PERHOUR','EUR',2,2,4),
(12,13200,'PERDAY','RSD',3,3,4),
(13,177,'PERDAY','EUR',1,1,4),
(14,5940,'PERDAY','RSD',3,2,5),
(15,14400,'PERDAY','RSD',2,1,6),
(16,106.8,'PERDAY','EUR',2,3,6),
(17,33,'PERHOUR','USD',3,2,6),
(18,7800,'PERDAY','RSD',2,1,7),
(19,47.52,'PERDAY','USD',3,2,7),
(20,118.8,'PERDAY','EUR',2,3,7);

/*Table structure for table `renting` */

DROP TABLE IF EXISTS `renting`;

CREATE TABLE `renting` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dateFrom` date NOT NULL,
  `dateTo` date NOT NULL,
  `totalAmount` double NOT NULL,
  `currency` varchar(3) NOT NULL,
  `vehicle_fk` bigint(20) NOT NULL,
  `client_fk` bigint(20) NOT NULL,
  `priceListItem_fk` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `vehicle_fk` (`vehicle_fk`),
  KEY `client_fk` (`client_fk`),
  KEY `priceListItem_fk` (`priceListItem_fk`),
  CONSTRAINT `renting_ibfk_1` FOREIGN KEY (`vehicle_fk`) REFERENCES `vehicle` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `renting_ibfk_2` FOREIGN KEY (`client_fk`) REFERENCES `client` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `renting_ibfk_3` FOREIGN KEY (`priceListItem_fk`) REFERENCES `pricelistitem` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `renting` */

insert  into `renting`(`id`,`dateFrom`,`dateTo`,`totalAmount`,`currency`,`vehicle_fk`,`client_fk`,`priceListItem_fk`) values 
(2,'2023-06-12','2023-06-14',1559,'EUR',1,1,6),
(3,'2023-06-11','2023-06-13',72550,'RSD',4,1,9),
(7,'2023-07-01','2023-07-06',599,'EUR',3,4,11);

/*Table structure for table `typeofvehicle` */

DROP TABLE IF EXISTS `typeofvehicle`;

CREATE TABLE `typeofvehicle` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(15) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `typeofvehicle` */

insert  into `typeofvehicle`(`id`,`name`) values 
(1,'car'),
(2,'motorcycle'),
(3,'truck');

/*Table structure for table `vehicle` */

DROP TABLE IF EXISTS `vehicle`;

CREATE TABLE `vehicle` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `brand` varchar(15) NOT NULL,
  `model` varchar(15) NOT NULL,
  `mileage` int(11) NOT NULL,
  `availability` tinyint(1) NOT NULL,
  `typeOfVehicle_fk` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `typeOfVehicle_fk` (`typeOfVehicle_fk`),
  CONSTRAINT `vehicle_ibfk_1` FOREIGN KEY (`typeOfVehicle_fk`) REFERENCES `typeofvehicle` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `vehicle` */

insert  into `vehicle`(`id`,`brand`,`model`,`mileage`,`availability`,`typeOfVehicle_fk`) values 
(1,'Mercedes-Benz','Maybach',88000,0,1),
(3,'Suzuki','Hayabusa',17000,1,2),
(4,'Honda','Ridgeline',112000,1,3),
(5,'Toyota','Tundra',9000,0,3),
(8,'Audi','A5',88000,0,1),
(11,'Nisan','Qashqai',89500,1,1),
(12,'Nissan','X-Trail',66000,0,3);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
