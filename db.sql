/*
SQLyog Ultimate v8.55 
MySQL - 5.7.13-log : Database - whole_sale
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`whole_sale` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `whole_sale`;

/*Table structure for table `customer_accounts` */

DROP TABLE IF EXISTS `customer_accounts`;

CREATE TABLE `customer_accounts` (
  `customer_account_id` int(11) NOT NULL AUTO_INCREMENT,
  `Credit` double DEFAULT NULL,
  `Debit` double DEFAULT NULL,
  `last_updated_user` int(11) DEFAULT NULL,
  `last_updated_date` date DEFAULT NULL,
  `last_updated_time` time DEFAULT NULL,
  `transaction_date` date DEFAULT NULL,
  `transaction_time` time DEFAULT NULL,
  `Description` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`customer_account_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `customer_accounts` */

/*Table structure for table `customer_cheques` */

DROP TABLE IF EXISTS `customer_cheques`;

CREATE TABLE `customer_cheques` (
  `customer_cheque_id` int(11) NOT NULL AUTO_INCREMENT,
  `cheque_number` varchar(100) DEFAULT NULL,
  `bank_code` varchar(100) DEFAULT NULL,
  `branch_code` varchar(100) DEFAULT NULL,
  `amount` double DEFAULT NULL,
  `cheque_date` date DEFAULT NULL,
  `cheque_status` int(11) DEFAULT NULL,
  `last_updated_user` int(11) DEFAULT NULL,
  `last_update_date` date DEFAULT NULL,
  `last_update_time` time DEFAULT NULL,
  `deposit_date` date DEFAULT NULL,
  `return_date` time DEFAULT NULL,
  `customer_id` int(11) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `status_code` int(11) DEFAULT NULL,
  PRIMARY KEY (`customer_cheque_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `customer_cheques` */

/*Table structure for table `customer_profiles` */

DROP TABLE IF EXISTS `customer_profiles`;

CREATE TABLE `customer_profiles` (
  `profile_id` int(11) NOT NULL AUTO_INCREMENT,
  `total_credit_limit` double DEFAULT NULL,
  `total_disscount_limit` double DEFAULT NULL,
  `credit_limit` double DEFAULT NULL,
  `disscount_limit` double DEFAULT NULL,
  `disscount_factor` double DEFAULT NULL,
  `last_update_user` int(11) DEFAULT NULL,
  `last_update_date` date DEFAULT NULL,
  `last_update_time` time DEFAULT NULL,
  `active` tinyint(1) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`profile_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `customer_profiles` */

/*Table structure for table `customers` */

DROP TABLE IF EXISTS `customers`;

CREATE TABLE `customers` (
  `customer_id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_name` varchar(200) DEFAULT NULL,
  `active` tinyint(1) DEFAULT NULL,
  `last_update_date` date DEFAULT NULL,
  `last_update_time` time DEFAULT NULL,
  `last_update_user` int(11) DEFAULT NULL,
  `profile_id` int(11) DEFAULT NULL,
  `contact_number` varchar(15) DEFAULT NULL,
  `land_line` varchar(15) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `customers` */

/*Table structure for table `grn` */

DROP TABLE IF EXISTS `grn`;

CREATE TABLE `grn` (
  `grn_id` int(11) NOT NULL AUTO_INCREMENT,
  `supplier_id` int(11) DEFAULT NULL,
  `grn_total` double DEFAULT NULL,
  `grn_disscount_total` double DEFAULT NULL,
  `user` int(11) DEFAULT NULL,
  `grn_date` date DEFAULT NULL,
  `grn_time` time DEFAULT NULL,
  `grn_return_total` double DEFAULT NULL,
  PRIMARY KEY (`grn_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `grn` */

/*Table structure for table `invoice` */

DROP TABLE IF EXISTS `invoice`;

CREATE TABLE `invoice` (
  `invoice_id` int(11) NOT NULL AUTO_INCREMENT,
  `total_billable` double DEFAULT NULL,
  `total_disscount` double DEFAULT NULL,
  `total_without_disscount` double DEFAULT NULL,
  `customer_id` int(11) DEFAULT NULL,
  `payment_method` int(11) DEFAULT NULL,
  `bus_date` date DEFAULT NULL,
  `sys_date` date DEFAULT NULL,
  `sys_time` time DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`invoice_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `invoice` */

/*Table structure for table `invoice_lines` */

DROP TABLE IF EXISTS `invoice_lines`;

CREATE TABLE `invoice_lines` (
  `invoice_line_id` int(11) NOT NULL AUTO_INCREMENT,
  `invoice_id` int(11) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `Product_price` double DEFAULT NULL,
  `Product_buying_price` double DEFAULT NULL,
  `qty` int(11) DEFAULT NULL,
  `product_disscount` double DEFAULT NULL,
  `total_disscount` double DEFAULT NULL,
  `total_without_disscount` double DEFAULT NULL,
  `billable_total` double DEFAULT NULL,
  `product_virtual_price` double DEFAULT NULL,
  PRIMARY KEY (`invoice_line_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `invoice_lines` */

/*Table structure for table `product` */

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `product_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(200) DEFAULT NULL,
  `qty` int(11) DEFAULT NULL,
  `bprice` double DEFAULT NULL,
  `sprice` double DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `take_stock_price` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `product` */

/*Table structure for table `product_bin_card` */

DROP TABLE IF EXISTS `product_bin_card`;

CREATE TABLE `product_bin_card` (
  `product_bin_card_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) DEFAULT NULL,
  `in` int(11) DEFAULT NULL,
  `out` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `time` time DEFAULT NULL,
  PRIMARY KEY (`product_bin_card_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `product_bin_card` */

/*Table structure for table `roles` */

DROP TABLE IF EXISTS `roles`;

CREATE TABLE `roles` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `roles` */

/*Table structure for table `supplier` */

DROP TABLE IF EXISTS `supplier`;

CREATE TABLE `supplier` (
  `supplier_id` int(11) NOT NULL AUTO_INCREMENT,
  `supplier_name` varchar(200) DEFAULT NULL,
  `supplier_address` varchar(300) DEFAULT NULL,
  `supplier_mobile` varchar(15) DEFAULT NULL,
  `supplier_phone1` varchar(15) DEFAULT NULL,
  `supplier_phone2` varchar(15) DEFAULT NULL,
  `supplier_email` varchar(100) DEFAULT NULL,
  `supplier_account_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`supplier_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `supplier` */

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(200) DEFAULT NULL,
  `password` varchar(200) DEFAULT NULL,
  `active` tinyint(1) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `users` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
