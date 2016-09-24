
CREATE DATABASE IF NOT EXISTS `PCDBHO` ;
USE `PCDBHO`;
DROP TABLE IF EXISTS `accounts`;

CREATE TABLE `accounts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `entity_type` int(11) DEFAULT NULL COMMENT '0 = customer 1 = supplier',
  `entity` int(11) DEFAULT NULL,
  `Credit` double DEFAULT NULL,
  `Debit` double DEFAULT NULL,
  `user` int(11) DEFAULT NULL,
  `Description` varchar(200) DEFAULT NULL,
  `org_branch` int(11) DEFAULT NULL COMMENT 'originating branch',
  `datetime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `FK_accounts` (`entity`),
  KEY `FK_accounts_user` (`user`),
  KEY `FK_accounts_branch` (`org_branch`),
  CONSTRAINT `FK_accounts_branch` FOREIGN KEY (`org_branch`) REFERENCES `branch` (`id`),
  CONSTRAINT `FK_accounts` FOREIGN KEY (`entity`) REFERENCES `entity` (`id`),
  CONSTRAINT `FK_accounts_user` FOREIGN KEY (`user`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `application_constants`;

CREATE TABLE `application_constants` (
  `id` int(11) NOT NULL AUTO_INCREMENT ,
  `field_name` varchar(50) DEFAULT NULL,
  `value` int(11) DEFAULT NULL,
  `text` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;


insert  into `application_constants`(`id`,`field_name`,`value`,`text`) values (1,'job_status',0,'new'),(2,'job_status',1,'working'),(3,'job_status',2,'ready'),(4,'job_status',3,'deliverd'),(5,'payment_method',0,'cash'),(6,'payment_method',1,'credit'),(7,'payment_method',3,'easy_payment'),(8,'cheque_status',0,'pending'),(9,'cheque_status',1,'confirmed'),(10,'cheque_status',2,'returned'),(11,'cheque_status',3,'cancel'),(12,'credit_note_status',0,'pending'),(13,'credit_note_status',1,'complete');


DROP TABLE IF EXISTS `branch`;

CREATE TABLE `branch` (
  `id` int(11) NOT NULL AUTO_INCREMENT ,
  `name` varchar(100) DEFAULT NULL,
  `user` int(11) DEFAULT NULL,
  `datetime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `FK_branch` (`user`),
  CONSTRAINT `FK_branch` FOREIGN KEY (`user`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;


insert  into `branch`(`id`,`name`,`user`,`datetime`) values (1,'head office',1,'2016-09-17 12:57:56');


DROP TABLE IF EXISTS `branch_transfer`;

CREATE TABLE `branch_transfer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `total_items` int(11) DEFAULT NULL,
  `user` int(11) DEFAULT NULL,
  `transfered_branch` int(11) DEFAULT NULL,
  `accepted_branch` int(11) DEFAULT NULL,
  `datetime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
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
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `serial` varchar(50) DEFAULT NULL,
  `pcode` int(11) DEFAULT NULL,
  `qty` int(11) DEFAULT NULL,
  `transfered_user` int(11) DEFAULT NULL,
  `accepted_user` int(11) DEFAULT NULL,
  `datetime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `FK_branch_transfer_lines_user_accepted` (`accepted_user`),
  KEY `FK_branch_transfer_lines_transfered` (`transfered_user`),
  KEY `FK_branch_transfer_lines_product` (`pcode`),
  KEY `FK_branch_transfer_lines_serial` (`serial`),
  CONSTRAINT `FK_branch_transfer_lines_product` FOREIGN KEY (`pcode`) REFERENCES `product` (`id`),
  CONSTRAINT `FK_branch_transfer_lines_serial` FOREIGN KEY (`serial`) REFERENCES `grn_lines` (`serial`),
  CONSTRAINT `FK_branch_transfer_lines_transfered` FOREIGN KEY (`transfered_user`) REFERENCES `users` (`id`),
  CONSTRAINT `FK_branch_transfer_lines_user_accepted` FOREIGN KEY (`accepted_user`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `cash_book`;

CREATE TABLE `cash_book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `org_branch` int(11) DEFAULT NULL,
  `credit` double DEFAULT NULL,
  `debit` double DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `user` int(11) DEFAULT NULL,
  `datetime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `FK_cash_book_user` (`user`),
  KEY `FK_cash_book_branch` (`org_branch`),
  CONSTRAINT `FK_cash_book_branch` FOREIGN KEY (`org_branch`) REFERENCES `branch` (`id`),
  CONSTRAINT `FK_cash_book_user` FOREIGN KEY (`user`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `cheques`;

CREATE TABLE `cheques` (
 `id` int(11) NOT NULL AUTO_INCREMENT,
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
  `entity` int(11) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `status_code` int(11) DEFAULT NULL,
  `datetime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
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


DROP TABLE IF EXISTS `credit_note`;

CREATE TABLE `credit_note` (
`id` int(11) NOT NULL AUTO_INCREMENT,
  `entity` int(20) DEFAULT NULL COMMENT 'customer or supplier id',
  `entity_type` int(11) DEFAULT NULL COMMENT '0= customer 1 = supplier',
  `entity_referance` int(11) DEFAULT NULL COMMENT 'grn return or invoice return',
  `total` double DEFAULT NULL,
  `user` int(11) DEFAULT NULL,
  `org_branch` int(11) DEFAULT NULL,
  `credit_note_status` int(11) DEFAULT NULL,
  `datetime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `FK_credit_note` (`entity`),
  KEY `FK_credit_note_user` (`user`),
  KEY `FK_credit_note_branch` (`org_branch`),
  KEY `FK_credit_note_status` (`credit_note_status`),
  CONSTRAINT `FK_credit_note` FOREIGN KEY (`entity`) REFERENCES `entity` (`id`),
  CONSTRAINT `FK_credit_note_branch` FOREIGN KEY (`org_branch`) REFERENCES `branch` (`id`),
  CONSTRAINT `FK_credit_note_status` FOREIGN KEY (`credit_note_status`) REFERENCES `application_constants` (`id`),
  CONSTRAINT `FK_credit_note_user` FOREIGN KEY (`user`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `entity`;

CREATE TABLE `entity` (
`id` int(11) NOT NULL AUTO_INCREMENT,
  `entity_type` int(11) DEFAULT NULL COMMENT '0=customer 1=supplier',
  `titile` varchar(20) DEFAULT NULL,
  `name` varchar(200) DEFAULT NULL,
  `active` tinyint(1) DEFAULT NULL,
  `user` int(11) DEFAULT NULL,
  `contact_number` varchar(15) DEFAULT NULL,
  `land_line` varchar(15) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `BRN` varchar(12) DEFAULT NULL,
  `credit_limit` double DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `org_branch` int(11) DEFAULT NULL,
  `datetime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `FK_entity_user` (`user`),
  KEY `FK_entity_branch` (`org_branch`),
  CONSTRAINT `FK_entity_branch` FOREIGN KEY (`org_branch`) REFERENCES `branch` (`id`),
  CONSTRAINT `FK_entity_user` FOREIGN KEY (`user`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `grn`;

CREATE TABLE `grn` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `supplier` int(20) DEFAULT NULL COMMENT 'refferance to entity table',
  `total` double DEFAULT NULL,
  `disscount_total` double DEFAULT NULL,
  `payment_method` int(11) DEFAULT NULL,
  `user` int(11) DEFAULT NULL,
  `datetime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `org_branch` int(11) DEFAULT NULL,
  `credit_note` int(11) DEFAULT NULL COMMENT 'refferance to credit note table',
  PRIMARY KEY (`id`),
  KEY `FK_grn_supplier` (`supplier`),
  KEY `FK_grn_user` (`user`),
  KEY `FK_grn_branch` (`org_branch`),
  KEY `FK_grn_credit_note` (`credit_note`),
  KEY `FK_grn` (`payment_method`),
  CONSTRAINT `FK_grn` FOREIGN KEY (`payment_method`) REFERENCES `application_constants` (`id`),
  CONSTRAINT `FK_grn_branch` FOREIGN KEY (`org_branch`) REFERENCES `branch` (`id`),
  CONSTRAINT `FK_grn_credit_note` FOREIGN KEY (`credit_note`) REFERENCES `credit_note` (`id`),
  CONSTRAINT `FK_grn_supplier` FOREIGN KEY (`supplier`) REFERENCES `entity` (`id`),
  CONSTRAINT `FK_grn_user` FOREIGN KEY (`user`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `grn_lines`;

CREATE TABLE `grn_lines` (
`id` int(11) NOT NULL AUTO_INCREMENT,
  `grn` int(11) DEFAULT NULL,
  `pcode` int(11) DEFAULT NULL,
  `serial` varchar(50) DEFAULT NULL,
  `branch` int(11) DEFAULT NULL,
  `qty` int(11) DEFAULT NULL,
  `cost_price` double DEFAULT NULL,
  `actual_cost_price` double DEFAULT NULL,
  `end_user_price` double DEFAULT NULL,
  `dealer_price` double DEFAULT NULL,
  `user` int(11) DEFAULT NULL,
  `user_sales` int(11) DEFAULT NULL,
  `warranty_in_days` int(11) DEFAULT NULL,
  `Warranty_end_date` date DEFAULT NULL,
  `isDamage` tinyint(1) DEFAULT NULL,
  `damage_updated_user` int(11) DEFAULT NULL,
  `datetime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
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

DROP TABLE IF EXISTS `grn_return`;

CREATE TABLE `grn_return` (
`id` int(11) NOT NULL AUTO_INCREMENT,
  `supplier` int(20) DEFAULT NULL,
  `return_total` double DEFAULT NULL,
  `user` int(11) DEFAULT NULL,
  `credit_note` int(11) DEFAULT NULL,
  `datetime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `org_branch` int(11) DEFAULT NULL,
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


DROP TABLE IF EXISTS `grn_return_lines`;

CREATE TABLE `grn_return_lines` (
`id` int(11) NOT NULL AUTO_INCREMENT,
  `return` int(11) DEFAULT NULL,
  `product` int(11) DEFAULT NULL,
  `serial` varchar(50) DEFAULT NULL,
  `qty` int(11) DEFAULT NULL,
  `cost_price` double DEFAULT NULL,
  `user` int(11) DEFAULT NULL,
  `datetime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `FK_grn_return_lines_user` (`user`),
  KEY `FK_grn_return_lines_return` (`return`),
  KEY `FK_grn_return_lines_product` (`product`),
  KEY `FK_grn_return_lines_serial` (`serial`),
  CONSTRAINT `FK_grn_return_lines_product` FOREIGN KEY (`product`) REFERENCES `product` (`id`),
  CONSTRAINT `FK_grn_return_lines_return` FOREIGN KEY (`return`) REFERENCES `grn_return` (`id`),
  CONSTRAINT `FK_grn_return_lines_serial` FOREIGN KEY (`serial`) REFERENCES `grn_lines` (`serial`),
  CONSTRAINT `FK_grn_return_lines_user` FOREIGN KEY (`user`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `invoice`;

CREATE TABLE `invoice` (
`id` int(11) NOT NULL AUTO_INCREMENT,
  `showinbill` tinyint(1) DEFAULT NULL,
  `total_billable` double DEFAULT NULL,
  `total_disscount` double DEFAULT NULL,
  `total_without_disscount` double DEFAULT NULL,
  `customer` int(11) DEFAULT NULL,
  `payment_method` int(11) DEFAULT NULL,
  `show_price` int(11) DEFAULT NULL,
  `invoice_status` int(1) DEFAULT NULL,
  `admin_hide` tinyint(1) DEFAULT NULL,
  `approved_user` int(11) DEFAULT NULL,
  `recomended_user` int(11) DEFAULT NULL,
  `user` int(11) DEFAULT NULL,
  `org_branch` int(11) DEFAULT NULL,
  `datetime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
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

DROP TABLE IF EXISTS `invoice_lines`;

CREATE TABLE `invoice_lines` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `invoice` int(11) DEFAULT NULL,
  `product` int(11) DEFAULT NULL,
  `serial` varchar(50) DEFAULT 'NA',
  `qty` int(11) DEFAULT NULL,
  `warranty_in_days` int(11) DEFAULT NULL,
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
  PRIMARY KEY (`id`),
  KEY `FK_invoice_lines_invoice` (`invoice`),
  KEY `FK_invoice_lines_user` (`user`),
  KEY `FK_invoice_lines_product` (`product`),
  KEY `FK_invoice_lines_serial` (`serial`),
  CONSTRAINT `FK_invoice_lines_invoice` FOREIGN KEY (`invoice`) REFERENCES `invoice` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_invoice_lines_product` FOREIGN KEY (`product`) REFERENCES `product` (`id`),
  CONSTRAINT `FK_invoice_lines_serial` FOREIGN KEY (`serial`) REFERENCES `grn_lines` (`serial`),
  CONSTRAINT `FK_invoice_lines_user` FOREIGN KEY (`user`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `jobs`;

CREATE TABLE `jobs` (
`id` int(11) NOT NULL AUTO_INCREMENT,
  `customer` int(11) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `service_charge` double DEFAULT NULL,
  `total_item_bill` double DEFAULT NULL,
  `total_bill` double DEFAULT NULL,
  `disscount` double DEFAULT NULL,
  `job_status` int(11) DEFAULT NULL,
  `user` int(11) DEFAULT NULL,
  `org_branch` int(11) DEFAULT NULL,
  `datetime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `FK_jobs_user` (`user`),
  KEY `FK_jobs_branch` (`org_branch`),
  KEY `FK_jobs_status` (`job_status`),
  KEY `FK_jobs_customer` (`customer`),
  CONSTRAINT `FK_jobs_branch` FOREIGN KEY (`org_branch`) REFERENCES `branch` (`id`),
  CONSTRAINT `FK_jobs_customer` FOREIGN KEY (`customer`) REFERENCES `entity` (`id`),
  CONSTRAINT `FK_jobs_status` FOREIGN KEY (`job_status`) REFERENCES `application_constants` (`id`),
  CONSTRAINT `FK_jobs_user` FOREIGN KEY (`user`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `jobs_lines`;

CREATE TABLE `jobs_lines` (
`id` int(11) NOT NULL AUTO_INCREMENT,
  `job` int(11) DEFAULT NULL,
  `product` int(11) DEFAULT NULL,
  `serial` varchar(50) DEFAULT 'NA',
  `our_item` tinyint(1) DEFAULT NULL,
  `item_bill` int(11) DEFAULT NULL,
  `iswarranty` tinyint(1) DEFAULT NULL,
  `isNew` tinyint(1) DEFAULT NULL,
  `user` int(11) DEFAULT NULL,
  `datetime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `FK_jobs_lines_user` (`user`),
  KEY `FK_jobs_lines_product` (`product`),
  KEY `FK_jobs_lines_serial` (`serial`),
  KEY `FK_jobs_lines_job` (`job`),
  CONSTRAINT `FK_jobs_lines_job` FOREIGN KEY (`job`) REFERENCES `jobs` (`id`),
  CONSTRAINT `FK_jobs_lines_product` FOREIGN KEY (`product`) REFERENCES `product` (`id`),
  CONSTRAINT `FK_jobs_lines_serial` FOREIGN KEY (`serial`) REFERENCES `grn_lines` (`serial`),
  CONSTRAINT `FK_jobs_lines_user` FOREIGN KEY (`user`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL,
  `org_branch` int(11) DEFAULT NULL,
  `user` int(11) DEFAULT NULL,
  `manage_price_globaly` tinyint(1) DEFAULT '0',
  `global_dealer_price` double DEFAULT '0',
  `global_enduser_price` double DEFAULT '0',
  `globsl_cost_price` double DEFAULT NULL,
  `global_actual_cost_price` double DEFAULT NULL,
  `qih` int(11) DEFAULT NULL,
  `dqih` int(11) DEFAULT NULL,
  `datetime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `FK_product_branch` (`org_branch`),
  KEY `FK_product_user` (`user`),
  CONSTRAINT `FK_product_branch` FOREIGN KEY (`org_branch`) REFERENCES `branch` (`id`),
  CONSTRAINT `FK_product_user` FOREIGN KEY (`user`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `product_bin_card`;

CREATE TABLE `product_bin_card` (
`id` int(11) NOT NULL AUTO_INCREMENT,
  `product` int(11) DEFAULT NULL,
  `org_branch` int(11) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `in` int(11) DEFAULT NULL,
  `out` int(11) DEFAULT NULL,
  `user` int(11) DEFAULT NULL,
  `serial` varchar(50) DEFAULT NULL,
  `datetime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
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

DROP TABLE IF EXISTS `roles`;

CREATE TABLE `roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL,
  `user` int(11) DEFAULT NULL,
  `datetime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `FK_roles_user` (`user`),
  CONSTRAINT `FK_roles_user` FOREIGN KEY (`user`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `sample`;

CREATE TABLE `sample` (
 `id` int(11) NOT NULL AUTO_INCREMENT,
  `customer` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `user` int(11) DEFAULT NULL,
  `org_branch` int(11) DEFAULT NULL,
  `datetime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `FK_sample_branch` (`org_branch`),
  KEY `FK_sample_user` (`user`),
  KEY `FK_sample_customer` (`customer`),
  KEY `FK_sample` (`status`),
  CONSTRAINT `FK_sample_customer` FOREIGN KEY (`customer`) REFERENCES `entity` (`id`),
  CONSTRAINT `FK_sample` FOREIGN KEY (`status`) REFERENCES `application_constants` (`id`),
  CONSTRAINT `FK_sample_branch` FOREIGN KEY (`org_branch`) REFERENCES `branch` (`id`),
  CONSTRAINT `FK_sample_user` FOREIGN KEY (`user`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `sample_lines`;

CREATE TABLE `sample_lines` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sample` int(11) DEFAULT NULL,
  `serial` varchar(50) DEFAULT 'NA',
  `product` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `qty` int(11) DEFAULT NULL,
  `user` int(11) DEFAULT NULL,
  `datetime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `FK_sample_lines_user` (`user`),
  KEY `FK_sample_lines_sample` (`sample`),
  KEY `FK_sample_lines_grn` (`serial`),
  KEY `FK_sample_lines_product` (`product`),
  KEY `FK_sample_lines` (`status`),
  CONSTRAINT `FK_sample_lines` FOREIGN KEY (`status`) REFERENCES `application_constants` (`id`),
  CONSTRAINT `FK_sample_lines_grn` FOREIGN KEY (`serial`) REFERENCES `grn_lines` (`serial`),
  CONSTRAINT `FK_sample_lines_product` FOREIGN KEY (`product`) REFERENCES `product` (`id`),
  CONSTRAINT `FK_sample_lines_sample` FOREIGN KEY (`sample`) REFERENCES `sample` (`id`),
  CONSTRAINT `FK_sample_lines_user` FOREIGN KEY (`user`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `supplier_product`;

CREATE TABLE `supplier_product` (
  `supplier` int(11) NOT NULL,
  `product` int(11) NOT NULL,
  `user` int(11) DEFAULT NULL,
  `org_branch` int(11) DEFAULT NULL,
  `datetime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  KEY `FK_supplier_product_branch` (`org_branch`),
  KEY `FK_supplier_product_user` (`user`),
  KEY `FK_supplier_product_supplier` (`supplier`),
  KEY `FK_supplier_product` (`product`),
  CONSTRAINT `FK_supplier_product` FOREIGN KEY (`product`) REFERENCES `product` (`id`),
  CONSTRAINT `FK_supplier_product_branch` FOREIGN KEY (`org_branch`) REFERENCES `branch` (`id`),
  CONSTRAINT `FK_supplier_product_supplier` FOREIGN KEY (`supplier`) REFERENCES `entity` (`id`),
  CONSTRAINT `FK_supplier_product_user` FOREIGN KEY (`user`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT ,
  `name` varchar(200) DEFAULT NULL,
  `password` varchar(200) DEFAULT NULL,
  `active` tinyint(1) DEFAULT NULL,
  `role` int(11) DEFAULT NULL,
  `datetime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `org_branch` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_users_branch` (`org_branch`),
  CONSTRAINT `FK_users_branch` FOREIGN KEY (`org_branch`) REFERENCES `branch` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;


insert  into `users`(`id`,`name`,`password`,`active`,`role`,`datetime`,`org_branch`) values (1,'admin','admin',1,'1','2016-09-17 12:58:21',1);

DROP TABLE IF EXISTS `warrranty`;

CREATE TABLE `warrranty` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product` int(11) DEFAULT NULL,
  `serial` varchar(50) DEFAULT NULL,
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
  PRIMARY KEY (`id`),
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;ALTER TABLE accounts  AUTO_INCREMENT=1000000000;ALTER TABLE application_constants AUTO_INCREMENT=1000000000;ALTER TABLE branch AUTO_INCREMENT=1000000000;ALTER TABLE branch_transfer AUTO_INCREMENT=1000000000;ALTER TABLE branch_transfer_lines AUTO_INCREMENT=1000000000;ALTER TABLE cash_book AUTO_INCREMENT=1000000000;ALTER TABLE cheques AUTO_INCREMENT=1000000000;ALTER TABLE credit_note AUTO_INCREMENT=1000000000;ALTER TABLE entity AUTO_INCREMENT=1000000000;ALTER TABLE grn AUTO_INCREMENT=1000000000;ALTER TABLE grn_lines AUTO_INCREMENT=1000000000;ALTER TABLE grn_return AUTO_INCREMENT=1000000000;ALTER TABLE grn_return_lines AUTO_INCREMENT=1000000000;ALTER TABLE invoice AUTO_INCREMENT=1000000000;ALTER TABLE invoice_lines AUTO_INCREMENT=1000000000;ALTER TABLE jobs AUTO_INCREMENT=1000000000;ALTER TABLE jobs_lines AUTO_INCREMENT=1000000000;ALTER TABLE product AUTO_INCREMENT=1000000000;ALTER TABLE product_bin_card AUTO_INCREMENT=1000000000;ALTER TABLE roles AUTO_INCREMENT=1000000000;ALTER TABLE sample AUTO_INCREMENT=1000000000;ALTER TABLE sample_lines AUTO_INCREMENT=1000000000;ALTER TABLE supplier_product AUTO_INCREMENT=1000000000;ALTER TABLE users AUTO_INCREMENT=1000000000;ALTER TABLE warrranty AUTO_INCREMENT=1000000000;