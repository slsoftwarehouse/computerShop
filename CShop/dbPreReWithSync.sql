/*
SQLyog Ultimate v8.55 
MySQL - 5.5.49-cll-lve : Database - test_db1234
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`test_db1234` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `test_db1234`;

/*Table structure for table `branch` */

DROP TABLE IF EXISTS `branch`;

CREATE TABLE `branch` (
  `id` int(11) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `code` varchar(3) DEFAULT NULL,
  `sys_branch` int(11) DEFAULT NULL,
  `issync` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `branch` */

insert  into `branch`(`id`,`name`,`code`,`sys_branch`,`issync`) values (1,'galle branch',NULL,NULL,NULL);

/*Table structure for table `branch_sequnce` */

DROP TABLE IF EXISTS `branch_sequnce`;

CREATE TABLE `branch_sequnce` (
  `id` int(11) NOT NULL,
  `name` varchar(20) NOT NULL,
  `seq` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `time` time DEFAULT NULL,
  `sys_branch` int(11) DEFAULT NULL,
  `issync` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`,`name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `branch_sequnce` */

insert  into `branch_sequnce`(`id`,`name`,`seq`,`date`,`time`,`sys_branch`,`issync`) values (1,'customers',0,NULL,NULL,NULL,NULL),(1,'customer_accounts',0,NULL,NULL,NULL,NULL),(1,'customer_cheques',0,NULL,NULL,NULL,NULL),(1,'customer_profiles',0,NULL,NULL,NULL,NULL),(1,'grn',0,NULL,NULL,NULL,NULL),(1,'grn_lines',0,NULL,NULL,NULL,NULL),(1,'invoice',0,NULL,NULL,NULL,NULL),(1,'invoice_lines',0,NULL,NULL,NULL,NULL),(1,'issue_cheques',0,NULL,NULL,NULL,NULL),(1,'product',0,NULL,NULL,NULL,NULL),(1,'product_bin_card',0,NULL,NULL,NULL,NULL),(1,'product_catagory',0,NULL,NULL,NULL,NULL),(1,'product_serials',0,NULL,NULL,NULL,NULL),(1,'roles',0,NULL,NULL,NULL,NULL),(1,'supplier',0,NULL,NULL,NULL,NULL),(1,'supplier_account_det',0,NULL,NULL,NULL,NULL),(1,'supplier_cheques',0,NULL,NULL,NULL,NULL),(1,'users',0,NULL,NULL,NULL,NULL);

/*Table structure for table `branch_stock` */

DROP TABLE IF EXISTS `branch_stock`;

CREATE TABLE `branch_stock` (
  `id` int(11) DEFAULT NULL,
  `serial` int(11) NOT NULL,
  `pcode` int(11) DEFAULT NULL,
  `buying_prince` double DEFAULT NULL,
  `actual_buying_price` double DEFAULT NULL,
  `delear_price` double DEFAULT NULL,
  `end_user_price` double DEFAULT NULL,
  `user` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `time` time DEFAULT NULL,
  `sys_branch` int(11) DEFAULT NULL,
  `isSync` int(11) DEFAULT NULL,
  PRIMARY KEY (`serial`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `branch_stock` */

/*Table structure for table `branch_transfer` */

DROP TABLE IF EXISTS `branch_transfer`;

CREATE TABLE `branch_transfer` (
  `id` int(11) NOT NULL,
  `serial` int(11) DEFAULT NULL,
  `new_branch` int(11) DEFAULT NULL,
  `old_branch` int(11) DEFAULT NULL,
  `date` int(11) DEFAULT NULL,
  `time` int(11) DEFAULT NULL,
  `updated_to_server` int(11) DEFAULT NULL,
  `sys_branch` int(11) DEFAULT NULL,
  `user` int(11) DEFAULT NULL,
  `accepted_user` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `branch_transfer` */

/*Table structure for table `branch_transfer_batch` */

DROP TABLE IF EXISTS `branch_transfer_batch`;

CREATE TABLE `branch_transfer_batch` (
  `id` int(11) NOT NULL,
  `date` date DEFAULT NULL,
  `time` time DEFAULT NULL,
  `total_items` int(11) DEFAULT NULL,
  `sys_branch` int(11) DEFAULT NULL,
  `issync` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `branch_transfer_batch` */

/*Table structure for table `cash_book` */

DROP TABLE IF EXISTS `cash_book`;

CREATE TABLE `cash_book` (
  `id` int(11) NOT NULL,
  `credit` double DEFAULT NULL,
  `debit` double DEFAULT NULL,
  `date` date DEFAULT NULL,
  `time` time DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `user` int(11) DEFAULT NULL,
  `sys_branch` int(11) DEFAULT NULL,
  `issync` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `cash_book` */

/*Table structure for table `cheques` */

DROP TABLE IF EXISTS `cheques`;

CREATE TABLE `cheques` (
  `id` int(11) NOT NULL,
  `number` varchar(100) DEFAULT NULL,
  `bank_code` varchar(100) DEFAULT NULL,
  `branch_code` varchar(100) DEFAULT NULL,
  `amount` double DEFAULT NULL,
  `cheque_date` date DEFAULT NULL,
  `cheque_status` int(11) DEFAULT NULL,
  `user` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `time` time DEFAULT NULL,
  `deposit_date` date DEFAULT NULL,
  `return_date` time DEFAULT NULL,
  `entity_type` int(11) DEFAULT NULL,
  `entity` int(11) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `status_code` int(11) DEFAULT NULL,
  `sys_branch` int(11) NOT NULL,
  `issync` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`,`sys_branch`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `cheques` */

/*Table structure for table `customer_accounts` */

DROP TABLE IF EXISTS `customer_accounts`;

CREATE TABLE `customer_accounts` (
  `id` int(11) NOT NULL,
  `Credit` double DEFAULT NULL,
  `Debit` double DEFAULT NULL,
  `user` varchar(20) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `time` time DEFAULT NULL,
  `transaction_date` date DEFAULT NULL,
  `transaction_time` time DEFAULT NULL,
  `Description` varchar(200) DEFAULT NULL,
  `sys_branch` int(11) NOT NULL,
  `issync` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`,`sys_branch`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `customer_accounts` */

/*Table structure for table `customer_credit_note` */

DROP TABLE IF EXISTS `customer_credit_note`;

CREATE TABLE `customer_credit_note` (
  `id` int(11) NOT NULL,
  `customer` varchar(20) DEFAULT NULL,
  `item_total` double DEFAULT NULL,
  `total` double DEFAULT NULL,
  `user` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `time` time DEFAULT NULL,
  `sys_branch` int(11) DEFAULT NULL,
  `issync` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `customer_credit_note` */

/*Table structure for table `customer_credit_note_lines` */

DROP TABLE IF EXISTS `customer_credit_note_lines`;

CREATE TABLE `customer_credit_note_lines` (
  `id` int(11) NOT NULL,
  `customer_credit_note` int(11) DEFAULT NULL,
  `product` int(11) DEFAULT NULL,
  `serial` int(11) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `user` int(11) DEFAULT NULL,
  `sys_branch` int(11) DEFAULT NULL,
  `issync` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `customer_credit_note_lines` */

/*Table structure for table `customers` */

DROP TABLE IF EXISTS `customers`;

CREATE TABLE `customers` (
  `id` int(11) NOT NULL,
  `titile` varchar(20) DEFAULT NULL,
  `name` varchar(200) DEFAULT NULL,
  `active` tinyint(1) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `time` time DEFAULT NULL,
  `user` int(11) DEFAULT NULL,
  `contact_number` varchar(15) DEFAULT NULL,
  `land_line` varchar(15) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `NIC` varchar(12) DEFAULT NULL,
  `credit_limit` double DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `sys_branch` int(11) NOT NULL,
  `issync` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`,`sys_branch`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `customers` */

/*Table structure for table `damage_stock` */

DROP TABLE IF EXISTS `damage_stock`;

CREATE TABLE `damage_stock` (
  `serial` int(11) NOT NULL,
  `product` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `user` int(11) DEFAULT NULL,
  `sys_branch` int(11) DEFAULT NULL,
  `issync` int(11) DEFAULT NULL,
  PRIMARY KEY (`serial`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `damage_stock` */

/*Table structure for table `grn` */

DROP TABLE IF EXISTS `grn`;

CREATE TABLE `grn` (
  `id` int(11) NOT NULL,
  `supplier` varchar(20) DEFAULT NULL,
  `total` double DEFAULT NULL,
  `disscount_total` double DEFAULT NULL,
  `user` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `time` time DEFAULT NULL,
  `return_total` double DEFAULT NULL,
  `sys_branch` int(11) NOT NULL,
  `issync` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`,`sys_branch`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `grn` */

/*Table structure for table `grn__return_lines` */

DROP TABLE IF EXISTS `grn__return_lines`;

CREATE TABLE `grn__return_lines` (
  `id` int(11) NOT NULL,
  `return` int(11) DEFAULT NULL,
  `product` int(11) DEFAULT NULL,
  `qty` int(11) DEFAULT NULL,
  `per_cost` double DEFAULT NULL,
  `total` double DEFAULT NULL,
  `userid` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `time` time DEFAULT NULL,
  `sys_branch` int(11) NOT NULL,
  `issync` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`,`sys_branch`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `grn__return_lines` */

/*Table structure for table `grn_lines` */

DROP TABLE IF EXISTS `grn_lines`;

CREATE TABLE `grn_lines` (
  `id` int(11) NOT NULL,
  `grn` int(11) DEFAULT NULL,
  `product` int(11) DEFAULT NULL,
  `qty` int(11) DEFAULT NULL,
  `freeqty` int(11) DEFAULT NULL,
  `disscount` double DEFAULT NULL,
  `actual_cost` double DEFAULT NULL,
  `per_cost` double DEFAULT NULL,
  `selling_price` double DEFAULT NULL,
  `total` double DEFAULT NULL,
  `user` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `time` time DEFAULT NULL,
  `sys_branch` int(11) NOT NULL,
  `issync` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`,`sys_branch`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `grn_lines` */

/*Table structure for table `grn_product_serials` */

DROP TABLE IF EXISTS `grn_product_serials`;

CREATE TABLE `grn_product_serials` (
  `id` int(11) NOT NULL,
  `line` int(11) DEFAULT NULL,
  `serial` int(11) DEFAULT NULL,
  `cost_price` double DEFAULT NULL,
  `date` date DEFAULT NULL,
  `time` time DEFAULT NULL,
  `user` int(11) DEFAULT NULL,
  `sys_branch` int(11) NOT NULL,
  `issync` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`,`sys_branch`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `grn_product_serials` */

/*Table structure for table `grn_return_product_serials` */

DROP TABLE IF EXISTS `grn_return_product_serials`;

CREATE TABLE `grn_return_product_serials` (
  `id` int(11) NOT NULL,
  `return_line` int(11) DEFAULT NULL,
  `serial` int(11) DEFAULT NULL,
  `cost_price` double DEFAULT NULL,
  `date` date DEFAULT NULL,
  `time` time DEFAULT NULL,
  `user` int(11) DEFAULT NULL,
  `sys_branch` int(11) NOT NULL,
  `issync` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`,`sys_branch`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `grn_return_product_serials` */

/*Table structure for table `grn_returns` */

DROP TABLE IF EXISTS `grn_returns`;

CREATE TABLE `grn_returns` (
  `id` int(11) NOT NULL,
  `supplier` varchar(20) DEFAULT NULL,
  `return_total` double DEFAULT NULL,
  `disscount_total` double DEFAULT NULL,
  `user` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `time` time DEFAULT NULL,
  `credit_note_total` double DEFAULT NULL,
  `sys_branch` int(11) NOT NULL,
  `issync` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`,`sys_branch`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `grn_returns` */

/*Table structure for table `invoice` */

DROP TABLE IF EXISTS `invoice`;

CREATE TABLE `invoice` (
  `id` int(11) NOT NULL,
  `total_billable` double DEFAULT NULL,
  `total_disscount` double DEFAULT NULL,
  `total_without_disscount` double DEFAULT NULL,
  `customer` int(11) DEFAULT NULL,
  `payment_method` int(11) DEFAULT NULL,
  `show_price` int(11) DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `time` time DEFAULT NULL,
  `admin_hide` tinyint(1) DEFAULT NULL,
  `approved_user` int(11) DEFAULT NULL,
  `recomended_user` int(11) DEFAULT NULL,
  `user` int(11) DEFAULT NULL,
  `sys_branch` int(11) DEFAULT NULL,
  `issync` int(11) NOT NULL,
  PRIMARY KEY (`id`,`issync`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `invoice` */

/*Table structure for table `invoice_lines` */

DROP TABLE IF EXISTS `invoice_lines`;

CREATE TABLE `invoice_lines` (
  `id` int(11) NOT NULL,
  `invoice` int(11) DEFAULT NULL,
  `product` int(11) DEFAULT NULL,
  `isserial` tinyint(1) DEFAULT NULL,
  `serial` int(11) DEFAULT NULL,
  `warranty_end_date` date DEFAULT NULL,
  `Product_price` double DEFAULT NULL,
  `Product_buying_price` double DEFAULT NULL,
  `product_actual_buying_price` double DEFAULT NULL,
  `disscount` double DEFAULT NULL,
  `isreturn` tinyint(1) DEFAULT NULL,
  `return_date` date DEFAULT NULL,
  `sys_branch` int(11) NOT NULL,
  `issync` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`,`sys_branch`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `invoice_lines` */

/*Table structure for table `jobs` */

DROP TABLE IF EXISTS `jobs`;

CREATE TABLE `jobs` (
  `id` int(11) NOT NULL,
  `customer` int(11) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `service_charge` double DEFAULT NULL,
  `total_item_bill` double DEFAULT NULL,
  `total_bill` double DEFAULT NULL,
  `disscount` double DEFAULT NULL,
  `job_status` int(11) DEFAULT NULL,
  `user` int(11) DEFAULT NULL,
  `sys_branch` int(11) DEFAULT NULL,
  `issync` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `time` time DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `jobs` */

/*Table structure for table `jobs_lines` */

DROP TABLE IF EXISTS `jobs_lines`;

CREATE TABLE `jobs_lines` (
  `id` int(11) NOT NULL,
  `job` int(11) DEFAULT NULL,
  `product` int(11) DEFAULT NULL,
  `serial` int(11) DEFAULT NULL,
  `our_item` tinyint(1) DEFAULT NULL,
  `item_bill` int(11) DEFAULT NULL,
  `iswarranty` tinyint(1) DEFAULT NULL,
  `isNew` tinyint(1) DEFAULT NULL,
  `user` int(11) DEFAULT NULL,
  `sys_branch` int(11) DEFAULT NULL,
  `issync` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `jobs_lines` */

/*Table structure for table `payment_methods` */

DROP TABLE IF EXISTS `payment_methods`;

CREATE TABLE `payment_methods` (
  `id` int(11) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `sys_branch` int(11) DEFAULT NULL,
  `issync` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `payment_methods` */

/*Table structure for table `product` */

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `id` int(11) NOT NULL,
  `catagory` int(11) DEFAULT NULL,
  `name` varchar(200) DEFAULT NULL,
  `user` int(11) DEFAULT NULL,
  `dealer_price` double DEFAULT '0',
  `enduser_price` double DEFAULT '0',
  `sys_branch` int(11) NOT NULL,
  `issync` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`,`sys_branch`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `product` */

/*Table structure for table `product_bin_card` */

DROP TABLE IF EXISTS `product_bin_card`;

CREATE TABLE `product_bin_card` (
  `id` int(11) NOT NULL,
  `product` int(11) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `in` int(11) DEFAULT NULL,
  `out` int(11) DEFAULT NULL,
  `user` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `time` time DEFAULT NULL,
  `serial` int(11) DEFAULT NULL,
  `sys_branch` int(11) NOT NULL,
  `issync` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`,`sys_branch`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `product_bin_card` */

/*Table structure for table `product_catagory` */

DROP TABLE IF EXISTS `product_catagory`;

CREATE TABLE `product_catagory` (
  `id` int(11) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `sys_branch` int(11) NOT NULL,
  `issync` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`,`sys_branch`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `product_catagory` */

/*Table structure for table `product_serials` */

DROP TABLE IF EXISTS `product_serials`;

CREATE TABLE `product_serials` (
  `id` int(11) NOT NULL,
  `serial` int(11) DEFAULT NULL,
  `cost_price` double DEFAULT NULL,
  `disscounted_price` double DEFAULT NULL,
  `selling_price` double DEFAULT NULL,
  `date` date DEFAULT NULL,
  `time` time DEFAULT NULL,
  `user` int(11) DEFAULT NULL,
  `user_sales` int(11) DEFAULT NULL,
  `sys_branch` int(11) NOT NULL,
  `updated_to_server` int(11) DEFAULT NULL,
  `warranty_period` int(11) DEFAULT NULL,
  `Warranty_end_date` date DEFAULT NULL,
  PRIMARY KEY (`id`,`sys_branch`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `product_serials` */

/*Table structure for table `roles` */

DROP TABLE IF EXISTS `roles`;

CREATE TABLE `roles` (
  `id` int(11) NOT NULL,
  `name` varchar(200) DEFAULT NULL,
  `sys_branch` int(11) NOT NULL,
  `issync` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`,`sys_branch`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `roles` */

/*Table structure for table `sample` */

DROP TABLE IF EXISTS `sample`;

CREATE TABLE `sample` (
  `id` int(11) NOT NULL,
  `customer` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `user` int(11) DEFAULT NULL,
  `sys_branch` int(11) DEFAULT NULL,
  `issync` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `sample` */

/*Table structure for table `sample_lines` */

DROP TABLE IF EXISTS `sample_lines`;

CREATE TABLE `sample_lines` (
  `id` int(11) NOT NULL,
  `sample` int(11) DEFAULT NULL,
  `serial` int(11) DEFAULT NULL,
  `product` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `user` int(11) DEFAULT NULL,
  `sys_branch` int(11) DEFAULT NULL,
  `issync` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `sample_lines` */

/*Table structure for table `supplier` */

DROP TABLE IF EXISTS `supplier`;

CREATE TABLE `supplier` (
  `id` int(11) NOT NULL,
  `name` varchar(200) DEFAULT NULL,
  `address` varchar(300) DEFAULT NULL,
  `mobile` varchar(15) DEFAULT NULL,
  `phone1` varchar(15) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `user` int(11) DEFAULT NULL,
  `sys_branch` int(11) NOT NULL,
  `issync` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`,`sys_branch`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `supplier` */

insert  into `supplier`(`id`,`name`,`address`,`mobile`,`phone1`,`email`,`user`,`sys_branch`,`issync`) values (1,'LaptopLK','1st floor, Unity Plaza, Colombo 4','0777876543','01234986986','info@laptop.lk',NULL,1,NULL),(441172737,'Tech Zone','Ground floor, Unity plaza, Colombo 4','0778923484','0112938749','info@techzone.lk',NULL,1,NULL),(441241957,'1','1','1','1','1',NULL,1,NULL);

/*Table structure for table `supplier_accout_details` */

DROP TABLE IF EXISTS `supplier_accout_details`;

CREATE TABLE `supplier_accout_details` (
  `id` int(11) NOT NULL,
  `supplier` int(11) DEFAULT NULL,
  `credit` double DEFAULT NULL,
  `debit` double DEFAULT NULL,
  `remarks` varchar(200) DEFAULT NULL,
  `user` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `time` time DEFAULT NULL,
  `sys_branch` int(11) NOT NULL,
  `issync` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`,`sys_branch`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `supplier_accout_details` */

/*Table structure for table `supplier_credit_note` */

DROP TABLE IF EXISTS `supplier_credit_note`;

CREATE TABLE `supplier_credit_note` (
  `id` int(11) NOT NULL,
  `supplier` varchar(20) DEFAULT NULL,
  `grn_return` varchar(20) DEFAULT NULL,
  `total` double DEFAULT NULL,
  `user` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `time` time DEFAULT NULL,
  `grn_return_total` double DEFAULT NULL,
  `sys_branch` int(11) NOT NULL,
  `issync` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`,`sys_branch`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `supplier_credit_note` */

/*Table structure for table `supplier_product` */

DROP TABLE IF EXISTS `supplier_product`;

CREATE TABLE `supplier_product` (
  `id` int(11) NOT NULL,
  `supplier` int(11) DEFAULT NULL,
  `product` int(11) DEFAULT NULL,
  `sys_branch` int(11) DEFAULT NULL,
  `issync` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_supplier_product` (`supplier`),
  KEY `FK_supplier_product1` (`product`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `supplier_product` */

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `name` varchar(200) DEFAULT NULL,
  `password` varchar(200) DEFAULT NULL,
  `active` tinyint(1) DEFAULT NULL,
  `role` int(11) DEFAULT NULL,
  `sys_branch` int(11) NOT NULL,
  `isSync` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`,`sys_branch`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `users` */

/*Table structure for table `warrranty` */

DROP TABLE IF EXISTS `warrranty`;

CREATE TABLE `warrranty` (
  `id` int(11) NOT NULL,
  `product` int(11) DEFAULT NULL,
  `serial` int(11) DEFAULT NULL,
  `backup_serial` int(11) DEFAULT NULL,
  `backup_status` int(11) DEFAULT NULL,
  `received_date` date DEFAULT NULL,
  `warranty_end_date` date DEFAULT NULL,
  `Status` int(11) DEFAULT NULL,
  `sent_to_supplier_date` date DEFAULT NULL,
  `received_from_supplier_date` date DEFAULT NULL,
  `sent_to_customer_date` date DEFAULT NULL,
  `user` int(11) DEFAULT NULL,
  `sys_branch` int(11) DEFAULT NULL,
  `isSync` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `warrranty` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
