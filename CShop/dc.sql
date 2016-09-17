/*
SQLyog Ultimate v8.55 
MySQL - 5.7.13-log : Database - pchouse
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`pchouse` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `pchouse`;

/*Table structure for table `accounts` */

DROP TABLE IF EXISTS `accounts`;

CREATE TABLE `accounts` (
  `id` varchar(11) NOT NULL,
  `entity_type` int(11) DEFAULT NULL COMMENT '0 = customer 1 = supplier',
  `entity` varchar(11) DEFAULT NULL,
  `Credit` double DEFAULT NULL,
  `Debit` double DEFAULT NULL,
  `user` int(11) DEFAULT NULL,
  `Description` varchar(200) DEFAULT NULL,
  `org_branch` varchar(11) DEFAULT NULL COMMENT 'originating branch',
  `datetime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `prefix` varchar(3) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_accounts` (`entity`),
  KEY `FK_accounts_user` (`user`),
  CONSTRAINT `FK_accounts` FOREIGN KEY (`entity`) REFERENCES `entity` (`id`),
  CONSTRAINT `FK_accounts_user` FOREIGN KEY (`user`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `accounts` */

/*Table structure for table `application_constants` */

DROP TABLE IF EXISTS `application_constants`;

CREATE TABLE `application_constants` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `field_name` varchar(50) DEFAULT NULL,
  `value` int(11) DEFAULT NULL,
  `text` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

/*Data for the table `application_constants` */

insert  into `application_constants`(`id`,`field_name`,`value`,`text`) values (1,'job_status',0,'new'),(2,'job_status',1,'working'),(3,'job_status',2,'ready'),(4,'job_status',3,'deliverd'),(5,'payment_method',0,'cash'),(6,'payment_method',1,'credit'),(7,'payment_method',3,'easy_payment'),(8,'cheque_status',0,'pending'),(9,'cheque_status',1,'confirmed'),(10,'cheque_status',2,'returned'),(11,'cheque_status',3,'cancel'),(12,'credit_note_status',0,'pending'),(13,'credit_note_status',1,'complete');

/*Table structure for table `branch` */

DROP TABLE IF EXISTS `branch`;

CREATE TABLE `branch` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `user` int(11) DEFAULT NULL,
  `datetime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `FK_branch` (`user`),
  CONSTRAINT `FK_branch` FOREIGN KEY (`user`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `branch` */

/*Table structure for table `branch_transfer` */

DROP TABLE IF EXISTS `branch_transfer`;

CREATE TABLE `branch_transfer` (
  `id` varchar(11) NOT NULL,
  `total_items` int(11) DEFAULT NULL,
  `user` int(11) DEFAULT NULL,
  `transfered_branch` int(11) DEFAULT NULL,
  `accepted_branch` int(11) DEFAULT NULL,
  `datetime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `prefix` varchar(3) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_branch_transfer_user` (`user`),
  KEY `FK_branch_transfer_branch_transfered` (`transfered_branch`),
  KEY `FK_branch_transfer_accepted` (`accepted_branch`),
  CONSTRAINT `FK_branch_transfer_accepted` FOREIGN KEY (`accepted_branch`) REFERENCES `branch` (`id`),
  CONSTRAINT `FK_branch_transfer_branch_transfered` FOREIGN KEY (`transfered_branch`) REFERENCES `branch` (`id`),
  CONSTRAINT `FK_branch_transfer_user` FOREIGN KEY (`user`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `branch_transfer` */

/*Table structure for table `branch_transfer_lines` */

DROP TABLE IF EXISTS `branch_transfer_lines`;

CREATE TABLE `branch_transfer_lines` (
  `id` varchar(11) NOT NULL,
  `serial` varchar(11) NOT NULL,
  `pcode` varchar(11) NOT NULL,
  `qty` int(11) DEFAULT NULL,
  `transfered_user` int(11) DEFAULT NULL,
  `accepted_user` int(11) DEFAULT NULL,
  `datetime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `prefix` varchar(3) DEFAULT NULL,
  PRIMARY KEY (`id`,`serial`,`pcode`),
  KEY `FK_branch_transfer_lines_user_accepted` (`accepted_user`),
  KEY `FK_branch_transfer_lines_transfered` (`transfered_user`),
  KEY `FK_branch_transfer_lines_product` (`pcode`),
  KEY `FK_branch_transfer_lines_serial` (`serial`),
  CONSTRAINT `FK_branch_transfer_lines_product` FOREIGN KEY (`pcode`) REFERENCES `product` (`id`),
  CONSTRAINT `FK_branch_transfer_lines_serial` FOREIGN KEY (`serial`) REFERENCES `grn_lines` (`serial`),
  CONSTRAINT `FK_branch_transfer_lines_transfered` FOREIGN KEY (`transfered_user`) REFERENCES `users` (`id`),
  CONSTRAINT `FK_branch_transfer_lines_user_accepted` FOREIGN KEY (`accepted_user`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `branch_transfer_lines` */

/*Table structure for table `cash_book` */

DROP TABLE IF EXISTS `cash_book`;

CREATE TABLE `cash_book` (
  `id` varchar(11) NOT NULL,
  `org_branch` int(11) DEFAULT NULL,
  `credit` double DEFAULT NULL,
  `debit` double DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `user` int(11) DEFAULT NULL,
  `datetime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `prefix` varchar(3) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_cash_book_user` (`user`),
  KEY `FK_cash_book_branch` (`org_branch`),
  CONSTRAINT `FK_cash_book_branch` FOREIGN KEY (`org_branch`) REFERENCES `branch` (`id`),
  CONSTRAINT `FK_cash_book_user` FOREIGN KEY (`user`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `cash_book` */

/*Table structure for table `cheques` */

DROP TABLE IF EXISTS `cheques`;

CREATE TABLE `cheques` (
  `id` varchar(11) NOT NULL,
  `org_branch` int(11) DEFAULT NULL,
  `number` varchar(100) DEFAULT NULL,
  `bank_code` varchar(100) DEFAULT NULL,
  `branch_code` varchar(100) DEFAULT NULL,
  `amount` double DEFAULT NULL,
  `cheque_date` date DEFAULT NULL,
  `cheque_status` int(11) DEFAULT NULL,
  `user` int(11) DEFAULT NULL,
  `deposit_date` date DEFAULT NULL,
  `return_date` time DEFAULT NULL,
  `entity_type` int(11) DEFAULT NULL,
  `entity` varchar(11) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `status_code` int(11) DEFAULT NULL,
  `datetime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `prefix` varchar(3) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_cheques` (`entity`),
  KEY `FK_cheques_user` (`user`),
  KEY `FK_cheques_branch` (`org_branch`),
  KEY `FK_cheques_status` (`status_code`),
  CONSTRAINT `FK_cheques` FOREIGN KEY (`entity`) REFERENCES `entity` (`id`),
  CONSTRAINT `FK_cheques_branch` FOREIGN KEY (`org_branch`) REFERENCES `branch` (`id`),
  CONSTRAINT `FK_cheques_status` FOREIGN KEY (`status_code`) REFERENCES `application_constants` (`id`),
  CONSTRAINT `FK_cheques_user` FOREIGN KEY (`user`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `cheques` */

/*Table structure for table `credit_note` */

DROP TABLE IF EXISTS `credit_note`;

CREATE TABLE `credit_note` (
  `id` varchar(11) NOT NULL,
  `entity` varchar(20) NOT NULL COMMENT 'customer or supplier id',
  `entity_type` int(11) NOT NULL COMMENT '0= customer 1 = supplier',
  `entity_referance` varchar(11) NOT NULL COMMENT 'grn return or invoice return',
  `total` double DEFAULT NULL,
  `user` int(11) DEFAULT NULL,
  `org_branch` int(11) DEFAULT NULL,
  `credit_note_status` int(11) DEFAULT NULL,
  `datetime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `prefix` varchar(3) DEFAULT NULL,
  PRIMARY KEY (`id`,`entity`,`entity_type`,`entity_referance`),
  KEY `FK_credit_note` (`entity`),
  KEY `FK_credit_note_user` (`user`),
  KEY `FK_credit_note_branch` (`org_branch`),
  KEY `FK_credit_note_status` (`credit_note_status`),
  CONSTRAINT `FK_credit_note` FOREIGN KEY (`entity`) REFERENCES `entity` (`id`),
  CONSTRAINT `FK_credit_note_branch` FOREIGN KEY (`org_branch`) REFERENCES `branch` (`id`),
  CONSTRAINT `FK_credit_note_status` FOREIGN KEY (`credit_note_status`) REFERENCES `application_constants` (`id`),
  CONSTRAINT `FK_credit_note_user` FOREIGN KEY (`user`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `credit_note` */

/*Table structure for table `entity` */

DROP TABLE IF EXISTS `entity`;

CREATE TABLE `entity` (
  `id` varchar(11) NOT NULL,
  `entity_type` int(11) NOT NULL COMMENT '0=customer 1=supplier',
  `titile` varchar(20) DEFAULT NULL,
  `name` varchar(200) DEFAULT NULL,
  `active` tinyint(1) DEFAULT NULL,
  `user` int(11) DEFAULT NULL,
  `contact_number` varchar(15) DEFAULT NULL,
  `land_line` varchar(15) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `NIC/BRN` varchar(12) NOT NULL,
  `credit_limit` double DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `org_branch` int(11) DEFAULT NULL,
  `datetime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `prefix` varchar(3) DEFAULT NULL,
  PRIMARY KEY (`id`,`entity_type`,`NIC/BRN`),
  KEY `FK_entity_user` (`user`),
  KEY `FK_entity_branch` (`org_branch`),
  CONSTRAINT `FK_entity_branch` FOREIGN KEY (`org_branch`) REFERENCES `branch` (`id`),
  CONSTRAINT `FK_entity_user` FOREIGN KEY (`user`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `entity` */

/*Table structure for table `grn` */

DROP TABLE IF EXISTS `grn`;

CREATE TABLE `grn` (
  `id` varchar(11) NOT NULL,
  `supplier` varchar(20) DEFAULT NULL COMMENT 'refferance to entity table',
  `total` double DEFAULT NULL,
  `disscount_total` double DEFAULT NULL,
  `user` int(11) DEFAULT NULL,
  `datetime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `org_branch` int(11) DEFAULT NULL,
  `credit_note` varchar(11) DEFAULT NULL COMMENT 'refferance to credit note table',
  `prefix` varchar(3) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_grn_supplier` (`supplier`),
  KEY `FK_grn_user` (`user`),
  KEY `FK_grn_branch` (`org_branch`),
  KEY `FK_grn_credit_note` (`credit_note`),
  CONSTRAINT `FK_grn_branch` FOREIGN KEY (`org_branch`) REFERENCES `branch` (`id`),
  CONSTRAINT `FK_grn_credit_note` FOREIGN KEY (`credit_note`) REFERENCES `credit_note` (`id`),
  CONSTRAINT `FK_grn_supplier` FOREIGN KEY (`supplier`) REFERENCES `entity` (`id`),
  CONSTRAINT `FK_grn_user` FOREIGN KEY (`user`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `grn` */

/*Table structure for table `grn_lines` */

DROP TABLE IF EXISTS `grn_lines`;

CREATE TABLE `grn_lines` (
  `id` varchar(11) NOT NULL,
  `grn` varchar(11) NOT NULL,
  `pcode` varchar(11) NOT NULL,
  `serial` varchar(11) NOT NULL,
  `branch` int(11) DEFAULT NULL,
  `qty` int(11) DEFAULT NULL,
  `cost_price` double DEFAULT NULL,
  `actual_cost_price` double DEFAULT NULL,
  `end_user_price` double DEFAULT NULL,
  `dealer_price` double DEFAULT NULL,
  `user` int(11) DEFAULT NULL,
  `user_sales` int(11) DEFAULT NULL,
  `warranty_in_months` int(11) DEFAULT NULL,
  `Warranty_end_date` date DEFAULT NULL,
  `isDamage` tinyint(1) DEFAULT NULL,
  `damage_updated_user` varchar(11) DEFAULT NULL,
  `datetime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `prefix` varchar(3) DEFAULT NULL,
  PRIMARY KEY (`id`,`grn`,`pcode`,`serial`),
  KEY `serial` (`serial`),
  KEY `FK_grn_lines` (`pcode`),
  KEY `FK_grn_lines_user` (`user`),
  KEY `FK_grn_lines_user_sales` (`user_sales`),
  KEY `FK_grn_lines_branch` (`branch`),
  KEY `FK_grn_lines_grn` (`grn`),
  CONSTRAINT `FK_grn_lines` FOREIGN KEY (`pcode`) REFERENCES `product` (`id`),
  CONSTRAINT `FK_grn_lines_branch` FOREIGN KEY (`branch`) REFERENCES `branch` (`id`),
  CONSTRAINT `FK_grn_lines_grn` FOREIGN KEY (`grn`) REFERENCES `grn` (`id`),
  CONSTRAINT `FK_grn_lines_user` FOREIGN KEY (`user`) REFERENCES `users` (`id`),
  CONSTRAINT `FK_grn_lines_user_sales` FOREIGN KEY (`user_sales`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `grn_lines` */

/*Table structure for table `grn_return` */

DROP TABLE IF EXISTS `grn_return`;

CREATE TABLE `grn_return` (
  `id` varchar(11) NOT NULL,
  `supplier` varchar(20) DEFAULT NULL,
  `return_total` double DEFAULT NULL,
  `user` int(11) DEFAULT NULL,
  `credit_note` varchar(11) DEFAULT NULL,
  `datetime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `org_branch` int(11) DEFAULT NULL,
  `prefix` varchar(3) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_grn_return_supplier` (`supplier`),
  KEY `FK_grn_return_credit_note` (`credit_note`),
  KEY `FK_grn_return_user` (`user`),
  KEY `FK_grn_return_branch` (`org_branch`),
  CONSTRAINT `FK_grn_return_branch` FOREIGN KEY (`org_branch`) REFERENCES `branch` (`id`),
  CONSTRAINT `FK_grn_return_credit_note` FOREIGN KEY (`credit_note`) REFERENCES `credit_note` (`id`),
  CONSTRAINT `FK_grn_return_supplier` FOREIGN KEY (`supplier`) REFERENCES `entity` (`id`),
  CONSTRAINT `FK_grn_return_user` FOREIGN KEY (`user`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `grn_return` */

/*Table structure for table `grn_return_lines` */

DROP TABLE IF EXISTS `grn_return_lines`;

CREATE TABLE `grn_return_lines` (
  `id` varchar(11) NOT NULL,
  `return` varchar(11) NOT NULL,
  `product` varchar(11) NOT NULL,
  `serial` varchar(11) NOT NULL,
  `qty` int(11) DEFAULT NULL,
  `cost_price` double DEFAULT NULL,
  `user` int(11) DEFAULT NULL,
  `datetime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `prefix` varchar(3) DEFAULT NULL,
  PRIMARY KEY (`id`,`return`,`product`,`serial`),
  KEY `FK_grn_return_lines_user` (`user`),
  KEY `FK_grn_return_lines_return` (`return`),
  KEY `FK_grn_return_lines_product` (`product`),
  KEY `FK_grn_return_lines_serial` (`serial`),
  CONSTRAINT `FK_grn_return_lines_product` FOREIGN KEY (`product`) REFERENCES `product` (`id`),
  CONSTRAINT `FK_grn_return_lines_return` FOREIGN KEY (`return`) REFERENCES `grn_return` (`id`),
  CONSTRAINT `FK_grn_return_lines_serial` FOREIGN KEY (`serial`) REFERENCES `grn_lines` (`serial`),
  CONSTRAINT `FK_grn_return_lines_user` FOREIGN KEY (`user`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `grn_return_lines` */

/*Table structure for table `invoice` */

DROP TABLE IF EXISTS `invoice`;

CREATE TABLE `invoice` (
  `id` varchar(11) NOT NULL,
  `total_billable` double DEFAULT NULL,
  `total_disscount` double DEFAULT NULL,
  `total_without_disscount` double DEFAULT NULL,
  `customer` varchar(11) DEFAULT NULL,
  `payment_method` int(11) DEFAULT NULL,
  `show_price` int(11) DEFAULT NULL,
  `invoice_status` int(1) DEFAULT NULL,
  `admin_hide` tinyint(1) DEFAULT NULL,
  `approved_user` int(11) DEFAULT NULL,
  `recomended_user` int(11) DEFAULT NULL,
  `user` int(11) DEFAULT NULL,
  `org_branch` int(11) DEFAULT NULL,
  `datetime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `prefix` varchar(3) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_invoice_branch` (`org_branch`),
  KEY `FK_invoice_user` (`user`),
  KEY `FK_invoice_rec_user` (`recomended_user`),
  KEY `FK_invoice_app_user` (`approved_user`),
  KEY `FK_invoice_payment` (`payment_method`),
  KEY `FK_invoice_status` (`invoice_status`),
  KEY `FK_invoice_customer` (`customer`),
  CONSTRAINT `FK_invoice_app_user` FOREIGN KEY (`approved_user`) REFERENCES `users` (`id`),
  CONSTRAINT `FK_invoice_branch` FOREIGN KEY (`org_branch`) REFERENCES `branch` (`id`),
  CONSTRAINT `FK_invoice_customer` FOREIGN KEY (`customer`) REFERENCES `entity` (`id`),
  CONSTRAINT `FK_invoice_payment` FOREIGN KEY (`payment_method`) REFERENCES `application_constants` (`id`),
  CONSTRAINT `FK_invoice_rec_user` FOREIGN KEY (`recomended_user`) REFERENCES `users` (`id`),
  CONSTRAINT `FK_invoice_status` FOREIGN KEY (`invoice_status`) REFERENCES `application_constants` (`id`),
  CONSTRAINT `FK_invoice_user` FOREIGN KEY (`user`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `invoice` */

/*Table structure for table `invoice_lines` */

DROP TABLE IF EXISTS `invoice_lines`;

CREATE TABLE `invoice_lines` (
  `id` varchar(11) NOT NULL,
  `invoice` varchar(11) NOT NULL,
  `product` varchar(11) NOT NULL,
  `serial` varchar(11) NOT NULL DEFAULT 'NA',
  `qty` int(11) DEFAULT NULL,
  `warranty_end_date` date DEFAULT NULL,
  `cost_price` double DEFAULT NULL,
  `actual_cost_price` double DEFAULT NULL,
  `end_user_price` double DEFAULT NULL,
  `dealer_price` double DEFAULT NULL,
  `selling_price` double DEFAULT NULL,
  `disscount` double DEFAULT NULL,
  `total` double DEFAULT NULL,
  `isreturn` tinyint(1) DEFAULT NULL,
  `return_date` date DEFAULT NULL,
  `user` int(11) DEFAULT NULL,
  `datetime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `prefix` varchar(3) DEFAULT NULL,
  PRIMARY KEY (`id`,`invoice`,`product`,`serial`),
  KEY `FK_invoice_lines_invoice` (`invoice`),
  KEY `FK_invoice_lines_user` (`user`),
  KEY `FK_invoice_lines_product` (`product`),
  KEY `FK_invoice_lines_serial` (`serial`),
  CONSTRAINT `FK_invoice_lines_invoice` FOREIGN KEY (`invoice`) REFERENCES `invoice` (`id`),
  CONSTRAINT `FK_invoice_lines_product` FOREIGN KEY (`product`) REFERENCES `product` (`id`),
  CONSTRAINT `FK_invoice_lines_serial` FOREIGN KEY (`serial`) REFERENCES `grn_lines` (`serial`),
  CONSTRAINT `FK_invoice_lines_user` FOREIGN KEY (`user`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `invoice_lines` */

/*Table structure for table `jobs` */

DROP TABLE IF EXISTS `jobs`;

CREATE TABLE `jobs` (
  `id` varchar(11) NOT NULL,
  `customer` varchar(11) NOT NULL,
  `description` varchar(500) DEFAULT NULL,
  `service_charge` double DEFAULT NULL,
  `total_item_bill` double DEFAULT NULL,
  `total_bill` double DEFAULT NULL,
  `disscount` double DEFAULT NULL,
  `job_status` int(11) DEFAULT NULL,
  `user` int(11) DEFAULT NULL,
  `org_branch` int(11) DEFAULT NULL,
  `datetime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `prefix` varchar(3) DEFAULT NULL,
  PRIMARY KEY (`id`,`customer`),
  KEY `FK_jobs_user` (`user`),
  KEY `FK_jobs_branch` (`org_branch`),
  KEY `FK_jobs_status` (`job_status`),
  KEY `FK_jobs_customer` (`customer`),
  CONSTRAINT `FK_jobs_branch` FOREIGN KEY (`org_branch`) REFERENCES `branch` (`id`),
  CONSTRAINT `FK_jobs_customer` FOREIGN KEY (`customer`) REFERENCES `entity` (`id`),
  CONSTRAINT `FK_jobs_status` FOREIGN KEY (`job_status`) REFERENCES `application_constants` (`id`),
  CONSTRAINT `FK_jobs_user` FOREIGN KEY (`user`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `jobs` */

/*Table structure for table `jobs_lines` */

DROP TABLE IF EXISTS `jobs_lines`;

CREATE TABLE `jobs_lines` (
  `id` varchar(11) NOT NULL,
  `job` varchar(11) NOT NULL,
  `product` varchar(11) NOT NULL,
  `serial` varchar(11) NOT NULL DEFAULT 'NA',
  `our_item` tinyint(1) DEFAULT NULL,
  `item_bill` int(11) DEFAULT NULL,
  `iswarranty` tinyint(1) DEFAULT NULL,
  `isNew` tinyint(1) DEFAULT NULL,
  `user` int(11) DEFAULT NULL,
  `datetime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `prefix` varchar(3) DEFAULT NULL,
  PRIMARY KEY (`id`,`job`,`product`,`serial`),
  KEY `FK_jobs_lines_user` (`user`),
  KEY `FK_jobs_lines_product` (`product`),
  KEY `FK_jobs_lines_serial` (`serial`),
  KEY `FK_jobs_lines_job` (`job`),
  CONSTRAINT `FK_jobs_lines_job` FOREIGN KEY (`job`) REFERENCES `jobs` (`id`),
  CONSTRAINT `FK_jobs_lines_product` FOREIGN KEY (`product`) REFERENCES `product` (`id`),
  CONSTRAINT `FK_jobs_lines_serial` FOREIGN KEY (`serial`) REFERENCES `grn_lines` (`serial`),
  CONSTRAINT `FK_jobs_lines_user` FOREIGN KEY (`user`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `jobs_lines` */

/*Table structure for table `product` */

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `id` varchar(11) NOT NULL,
  `name` varchar(1000) NOT NULL,
  `org_branch` int(11) NOT NULL,
  `user` int(11) DEFAULT NULL,
  `manage_price_globaly` tinyint(1) DEFAULT '0',
  `global_dealer_price` double DEFAULT '0',
  `global_enduser_price` double DEFAULT '0',
  `globsl_cost_price` double DEFAULT NULL,
  `global_actual_cost_price` double DEFAULT NULL,
  `qih` int(11) DEFAULT NULL,
  `dqih` int(11) DEFAULT NULL,
  `datetime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `prefix` varchar(3) DEFAULT NULL,
  PRIMARY KEY (`id`,`name`,`org_branch`),
  KEY `FK_product_branch` (`org_branch`),
  KEY `FK_product_user` (`user`),
  CONSTRAINT `FK_product_branch` FOREIGN KEY (`org_branch`) REFERENCES `branch` (`id`),
  CONSTRAINT `FK_product_user` FOREIGN KEY (`user`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `product` */

/*Table structure for table `product_bin_card` */

DROP TABLE IF EXISTS `product_bin_card`;

CREATE TABLE `product_bin_card` (
  `id` varchar(11) NOT NULL,
  `product` varchar(11) DEFAULT NULL,
  `org_branch` int(11) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `in` int(11) DEFAULT NULL,
  `out` int(11) DEFAULT NULL,
  `user` int(11) DEFAULT NULL,
  `serial` varchar(11) DEFAULT NULL,
  `datetime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `prefix` varchar(3) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_product_bin_card_product` (`product`),
  KEY `FK_product_bin_card_branch` (`org_branch`),
  KEY `FK_product_bin_card_user` (`user`),
  KEY `FK_product_bin_card_serial` (`serial`),
  CONSTRAINT `FK_product_bin_card_branch` FOREIGN KEY (`org_branch`) REFERENCES `branch` (`id`),
  CONSTRAINT `FK_product_bin_card_product` FOREIGN KEY (`product`) REFERENCES `product` (`id`),
  CONSTRAINT `FK_product_bin_card_serial` FOREIGN KEY (`serial`) REFERENCES `grn_lines` (`serial`),
  CONSTRAINT `FK_product_bin_card_user` FOREIGN KEY (`user`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `product_bin_card` */

/*Table structure for table `roles` */

DROP TABLE IF EXISTS `roles`;

CREATE TABLE `roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL,
  `user` int(11) DEFAULT NULL,
  `datetime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `FK_roles_user` (`user`),
  CONSTRAINT `FK_roles_user` FOREIGN KEY (`user`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `roles` */

/*Table structure for table `sample` */

DROP TABLE IF EXISTS `sample`;

CREATE TABLE `sample` (
  `id` varchar(11) NOT NULL,
  `customer` varchar(11) NOT NULL,
  `status` int(11) DEFAULT NULL,
  `user` int(11) DEFAULT NULL,
  `org_branch` int(11) DEFAULT NULL,
  `datetime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `prefix` varchar(3) DEFAULT NULL,
  PRIMARY KEY (`id`,`customer`),
  KEY `FK_sample_branch` (`org_branch`),
  KEY `FK_sample_user` (`user`),
  KEY `FK_sample_customer` (`customer`),
  KEY `FK_sample` (`status`),
  CONSTRAINT `FK_sample` FOREIGN KEY (`status`) REFERENCES `application_constants` (`id`),
  CONSTRAINT `FK_sample_branch` FOREIGN KEY (`org_branch`) REFERENCES `branch` (`id`),
  CONSTRAINT `FK_sample_customer` FOREIGN KEY (`customer`) REFERENCES `entity` (`id`),
  CONSTRAINT `FK_sample_user` FOREIGN KEY (`user`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sample` */

/*Table structure for table `sample_lines` */

DROP TABLE IF EXISTS `sample_lines`;

CREATE TABLE `sample_lines` (
  `id` varchar(11) NOT NULL,
  `sample` varchar(11) NOT NULL,
  `serial` varchar(11) NOT NULL DEFAULT 'NA',
  `product` varchar(11) NOT NULL,
  `status` int(11) DEFAULT NULL,
  `qty` int(11) DEFAULT NULL,
  `user` int(11) DEFAULT NULL,
  `datetime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `prefix` varchar(3) DEFAULT NULL,
  PRIMARY KEY (`id`,`sample`,`serial`,`product`),
  KEY `FK_sample_lines_user` (`user`),
  KEY `FK_sample_lines_sample` (`sample`),
  KEY `FK_sample_lines_grn` (`serial`),
  KEY `FK_sample_lines_product` (`product`),
  KEY `FK_sample_lines` (`status`),
  CONSTRAINT `FK_sample_lines` FOREIGN KEY (`status`) REFERENCES `application_constants` (`id`),
  CONSTRAINT `FK_sample_lines_grn` FOREIGN KEY (`serial`) REFERENCES `grn_lines` (`id`),
  CONSTRAINT `FK_sample_lines_product` FOREIGN KEY (`product`) REFERENCES `product` (`id`),
  CONSTRAINT `FK_sample_lines_sample` FOREIGN KEY (`sample`) REFERENCES `sample` (`id`),
  CONSTRAINT `FK_sample_lines_user` FOREIGN KEY (`user`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sample_lines` */

/*Table structure for table `supplier_product` */

DROP TABLE IF EXISTS `supplier_product`;

CREATE TABLE `supplier_product` (
  `supplier` varchar(11) NOT NULL,
  `product` varchar(11) NOT NULL,
  `user` int(11) DEFAULT NULL,
  `org_branch` int(11) DEFAULT NULL,
  `datetime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `prefix` varchar(3) DEFAULT NULL,
  PRIMARY KEY (`supplier`,`product`),
  KEY `FK_supplier_product1` (`product`),
  KEY `FK_supplier_product_branch` (`org_branch`),
  KEY `FK_supplier_product_user` (`user`),
  CONSTRAINT `FK_supplier_product_branch` FOREIGN KEY (`org_branch`) REFERENCES `branch` (`id`),
  CONSTRAINT `FK_supplier_product_product` FOREIGN KEY (`product`) REFERENCES `product` (`id`),
  CONSTRAINT `FK_supplier_product_supplier` FOREIGN KEY (`supplier`) REFERENCES `entity` (`id`),
  CONSTRAINT `FK_supplier_product_user` FOREIGN KEY (`user`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `supplier_product` */

/*Table structure for table `table_seq` */

DROP TABLE IF EXISTS `table_seq`;

CREATE TABLE `table_seq` (
  `table_name` varchar(20) NOT NULL,
  `seq` int(11) DEFAULT NULL,
  `prefix` varchar(3) NOT NULL,
  PRIMARY KEY (`table_name`,`prefix`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `table_seq` */

insert  into `table_seq`(`table_name`,`seq`,`prefix`) values ('accounts',0,'H'),('branch',0,'H'),('branch_transfer',0,'H'),('branch_transfer_line',0,'H'),('cash_book',0,'H'),('cheques',0,'H'),('credit_note',0,'H'),('entity',0,'H'),('grn',0,'H'),('grn_lines',0,'H'),('grn_return',0,'H'),('grn_return_lines',0,'H'),('invoice',0,'H'),('invoice_lines',0,'H'),('jobs',0,'H'),('jobs_lines',0,'H'),('payment_methods',0,'H'),('product',0,'H'),('product_bin_card',0,'H'),('roles',0,'H'),('sample',0,'H'),('sample_lines',0,'H'),('status',0,'H'),('supplier_product',0,'H'),('users',0,'H'),('warrranty',0,'H');

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL,
  `password` varchar(200) DEFAULT NULL,
  `active` tinyint(1) DEFAULT NULL,
  `role` varchar(11) DEFAULT NULL,
  `datetime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `org_branch` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_users_branch` (`org_branch`),
  CONSTRAINT `FK_users_branch` FOREIGN KEY (`org_branch`) REFERENCES `branch` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `users` */

/*Table structure for table `warrranty` */

DROP TABLE IF EXISTS `warrranty`;

CREATE TABLE `warrranty` (
  `id` varchar(11) NOT NULL,
  `product` varchar(11) NOT NULL,
  `serial` varchar(11) NOT NULL,
  `backup_serial` varchar(11) DEFAULT NULL,
  `backup_status` int(11) DEFAULT NULL,
  `received_date` date DEFAULT NULL,
  `warranty_end_date` date DEFAULT NULL,
  `warranty_status` int(11) DEFAULT NULL,
  `sent_to_supplier_date` date DEFAULT NULL,
  `received_from_supplier_date` date DEFAULT NULL,
  `sent_to_customer_date` date DEFAULT NULL,
  `org_branch` int(11) DEFAULT NULL,
  `user` int(11) DEFAULT NULL,
  `datetime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `prefix` varchar(3) DEFAULT NULL,
  PRIMARY KEY (`id`,`product`,`serial`),
  KEY `FK_warrranty_branch` (`org_branch`),
  KEY `FK_warrranty_user` (`user`),
  KEY `FK_warrranty_product` (`product`),
  KEY `FK_warrranty_serial` (`serial`),
  KEY `FK_warrranty_backup_serial` (`backup_serial`),
  CONSTRAINT `FK_warrranty_backup_serial` FOREIGN KEY (`backup_serial`) REFERENCES `grn_lines` (`serial`),
  CONSTRAINT `FK_warrranty_branch` FOREIGN KEY (`org_branch`) REFERENCES `branch` (`id`),
  CONSTRAINT `FK_warrranty_product` FOREIGN KEY (`product`) REFERENCES `product` (`id`),
  CONSTRAINT `FK_warrranty_serial` FOREIGN KEY (`serial`) REFERENCES `grn_lines` (`serial`),
  CONSTRAINT `FK_warrranty_user` FOREIGN KEY (`user`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `warrranty` */

/* Trigger structure for table `accounts` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `accounts_insert` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'testusr1234'@'%' */ /*!50003 TRIGGER `accounts_insert` BEFORE INSERT ON `accounts` FOR EACH ROW BEGIN
  DECLARE X INT;
  SET X = (SELECT seq FROM table_seq WHERE table_name = 'accounts' and prefix = NEW.prefix); 
  UPDATE table_seq SET seq=X+1 WHERE table_name='accounts' and prefix = NEW.prefix;  
  
  SET NEW.id = CONCAT(NEW.prefix , X+1);
END */$$


DELIMITER ;

/* Trigger structure for table `branch_transfer` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `branch_transfer_insert` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'testusr1234'@'%' */ /*!50003 TRIGGER `branch_transfer_insert` BEFORE INSERT ON `branch_transfer` FOR EACH ROW BEGIN
  DECLARE X INT;
  SET X = (SELECT seq FROM table_seq WHERE table_name = 'branch_transfer' and prefix = NEW.prefix); 
  UPDATE table_seq SET seq=X+1 WHERE table_name='branch_transfer' and prefix = NEW.prefix;  
  
  SET NEW.id = CONCAT(NEW.prefix , X+1);
END */$$


DELIMITER ;

/* Trigger structure for table `cash_book` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `cash_book_insert` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'testusr1234'@'%' */ /*!50003 TRIGGER `cash_book_insert` BEFORE INSERT ON `cash_book` FOR EACH ROW BEGIN
  DECLARE X INT;
  SET X = (SELECT seq FROM table_seq WHERE table_name = 'cash_book' and prefix = NEW.prefix);  
  UPDATE table_seq SET seq=X+1 WHERE table_name='cash_book' and prefix = NEW.prefix;  
  
  SET NEW.id = CONCAT(NEW.prefix , X+1);
END */$$


DELIMITER ;

/* Trigger structure for table `cheques` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `cheques_insert` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'testusr1234'@'%' */ /*!50003 TRIGGER `cheques_insert` BEFORE INSERT ON `cheques` FOR EACH ROW BEGIN
  DECLARE X INT;
  SET X = (SELECT seq FROM table_seq WHERE table_name = 'cheques' and prefix = NEW.prefix);  
  UPDATE table_seq SET seq=X+1 WHERE table_name='cheques' and prefix = NEW.prefix;  
  
  SET NEW.id = CONCAT(NEW.prefix , X+1);
END */$$


DELIMITER ;

/* Trigger structure for table `credit_note` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `credit_note_insert` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'testusr1234'@'%' */ /*!50003 TRIGGER `credit_note_insert` BEFORE INSERT ON `credit_note` FOR EACH ROW BEGIN
  DECLARE X INT;
  SET X = (SELECT seq FROM table_seq WHERE table_name = 'credit_note' and prefix = NEW.prefix);  
  UPDATE table_seq SET seq=X+1 WHERE table_name='credit_note' and prefix = NEW.prefix;  
  
  SET NEW.id = CONCAT(NEW.prefix , X+1);
END */$$


DELIMITER ;

/* Trigger structure for table `entity` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `entity_insert` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'testusr1234'@'%' */ /*!50003 TRIGGER `entity_insert` BEFORE INSERT ON `entity` FOR EACH ROW BEGIN
  DECLARE X INT;
  SET X = (SELECT seq FROM table_seq WHERE table_name = 'entity' and prefix = NEW.prefix);  
  UPDATE table_seq SET seq=X+1 WHERE table_name='entity' and prefix = NEW.prefix;  
  
  SET NEW.id = CONCAT(NEW.prefix , X+1);
END */$$


DELIMITER ;

/* Trigger structure for table `grn` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `grn_insert` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'testusr1234'@'%' */ /*!50003 TRIGGER `grn_insert` BEFORE INSERT ON `grn` FOR EACH ROW BEGIN
  DECLARE X INT;
  SET X = (SELECT seq FROM table_seq WHERE table_name = 'grn' and prefix = NEW.prefix);  
  UPDATE table_seq SET seq=X+1 WHERE table_name='grn' and prefix = NEW.prefix;  
  
  SET NEW.id = CONCAT(NEW.prefix , X+1);
END */$$


DELIMITER ;

/* Trigger structure for table `grn_lines` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `grn_lines_insert` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'testusr1234'@'%' */ /*!50003 TRIGGER `grn_lines_insert` BEFORE INSERT ON `grn_lines` FOR EACH ROW BEGIN
  DECLARE X INT;
  SET X = (SELECT seq FROM table_seq WHERE table_name = 'grn_lines' and prefix = NEW.prefix);  
  UPDATE table_seq SET seq=X+1 WHERE table_name='grn_lines' and prefix = NEW.prefix;  
  
  SET NEW.id = CONCAT(NEW.prefix , X+1);
END */$$


DELIMITER ;

/* Trigger structure for table `grn_return` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `grn_return_insert` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'testusr1234'@'%' */ /*!50003 TRIGGER `grn_return_insert` BEFORE INSERT ON `grn_return` FOR EACH ROW BEGIN
  DECLARE X INT;
  SET X = (SELECT seq FROM table_seq WHERE table_name = 'grn_return' and prefix = NEW.prefix);  
  UPDATE table_seq SET seq=X+1 WHERE table_name='grn_return' and prefix = NEW.prefix;  
  
  SET NEW.id = CONCAT(NEW.prefix , X+1);
END */$$


DELIMITER ;

/* Trigger structure for table `grn_return_lines` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `grn_return_lines_insert` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'testusr1234'@'%' */ /*!50003 TRIGGER `grn_return_lines_insert` BEFORE INSERT ON `grn_return_lines` FOR EACH ROW BEGIN
  DECLARE X INT;
  SET X = (SELECT seq FROM table_seq WHERE table_name = 'grn_return_lines' and prefix = NEW.prefix);  
  UPDATE table_seq SET seq=X+1 WHERE table_name='grn_return_lines' and prefix = NEW.prefix;  
  
  SET NEW.id = CONCAT(NEW.prefix , X+1);
END */$$


DELIMITER ;

/* Trigger structure for table `invoice` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `invoice_insert` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'testusr1234'@'%' */ /*!50003 TRIGGER `invoice_insert` BEFORE INSERT ON `invoice` FOR EACH ROW BEGIN
  DECLARE X INT;
  SET X = (SELECT seq FROM table_seq WHERE table_name = 'invoice' and prefix = NEW.prefix);  
  UPDATE table_seq SET seq=X+1 WHERE table_name='invoice' and prefix = NEW.prefix;  
  
  SET NEW.id = CONCAT(NEW.prefix , X+1);
END */$$


DELIMITER ;

/* Trigger structure for table `invoice_lines` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `invoice_lines_insert` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'testusr1234'@'%' */ /*!50003 TRIGGER `invoice_lines_insert` BEFORE INSERT ON `invoice_lines` FOR EACH ROW BEGIN
  DECLARE X INT;
  SET X = (SELECT seq FROM table_seq WHERE table_name = 'invoice_lines' and prefix = NEW.prefix);  
  UPDATE table_seq SET seq=X+1 WHERE table_name='invoice_lines' and prefix = NEW.prefix;  
  
  SET NEW.id = CONCAT(NEW.prefix , X+1);
END */$$


DELIMITER ;

/* Trigger structure for table `jobs` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `jobs_insert` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'testusr1234'@'%' */ /*!50003 TRIGGER `jobs_insert` BEFORE INSERT ON `jobs` FOR EACH ROW BEGIN
  DECLARE X INT;
  SET X = (SELECT seq FROM table_seq WHERE table_name = 'jobs' and prefix = NEW.prefix);  
  UPDATE table_seq SET seq=X+1 WHERE table_name='jobs' and prefix = NEW.prefix;  
  
  SET NEW.id = CONCAT(NEW.prefix , X+1);
END */$$


DELIMITER ;

/* Trigger structure for table `jobs_lines` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `jobs_lines_insert` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'testusr1234'@'%' */ /*!50003 TRIGGER `jobs_lines_insert` BEFORE INSERT ON `jobs_lines` FOR EACH ROW BEGIN
  DECLARE X INT;
  SET X = (SELECT seq FROM table_seq WHERE table_name = 'jobs_lines' and prefix = NEW.prefix);  
  UPDATE table_seq SET seq=X+1 WHERE table_name='jobs_lines' and prefix = NEW.prefix;  
  
  SET NEW.id = CONCAT(NEW.prefix , X+1);
END */$$


DELIMITER ;

/* Trigger structure for table `product` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `product_insert` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'testusr1234'@'%' */ /*!50003 TRIGGER `product_insert` BEFORE INSERT ON `product` FOR EACH ROW BEGIN
  DECLARE X INT;
  SET X = (SELECT seq FROM table_seq WHERE table_name = 'product' and prefix = NEW.prefix);  
  UPDATE table_seq SET seq=X+1 WHERE table_name='product' and prefix = NEW.prefix; 
  
  SET NEW.id = CONCAT(NEW.prefix , X+1);
END */$$


DELIMITER ;

/* Trigger structure for table `product_bin_card` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `product_bin_card_insert` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'testusr1234'@'%' */ /*!50003 TRIGGER `product_bin_card_insert` BEFORE INSERT ON `product_bin_card` FOR EACH ROW BEGIN
  DECLARE X INT;
  SET X = (SELECT seq FROM table_seq WHERE table_name = 'product_bin_card' and prefix = NEW.prefix);  
  UPDATE table_seq SET seq=X+1 WHERE table_name='product_bin_card' and prefix = NEW.prefix;  
  
  SET NEW.id = CONCAT(NEW.prefix , X+1);
END */$$


DELIMITER ;

/* Trigger structure for table `warrranty` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `warrranty_insert` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'testusr1234'@'%' */ /*!50003 TRIGGER `warrranty_insert` BEFORE INSERT ON `warrranty` FOR EACH ROW BEGIN
  DECLARE X INT;
  SET X = (SELECT seq FROM table_seq WHERE table_name = 'warrranty' and prefix = NEW.prefix);  
  UPDATE table_seq SET seq=X+1 WHERE table_name='warrranty' and prefix = NEW.prefix;  
  
  SET NEW.id = CONCAT(NEW.prefix , X+1);
END */$$


DELIMITER ;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
