# InterviewScheduler
InterviewScheduler
#Run these sql.
/*
Created: 8/13/2015
Modified: 10/8/2015
Model: MySQL 5.5
Database: MySQL 5.6
*/

drop database vendor_consultant;
create database vendor_consultant;
use vendor_consultant;



-- Create tables section -------------------------------------------------

-- Table consultant

CREATE TABLE `consultant`
(
  `consultant_id` Int NOT NULL AUTO_INCREMENT,
  `consultant_name` Varchar(30) NOT NULL,
  `dob` Date,
  `ssn` Varchar(12),
  `email` Varchar(50) NOT NULL,
  `phone` Varchar(20) NOT NULL,
  `current_client_id` Int,
  `yrs_exp` Double NOT NULL,
  `sales_rep_id` Int NOT NULL,
  PRIMARY KEY (`consultant_id`)
) ENGINE = InnoDB
 ROW_FORMAT = Compact
;

CREATE INDEX `IX_Relationship34` USING BTREE ON `consultant` (`current_client_id`)
;

CREATE INDEX `IX_Relationship53` USING BTREE ON `consultant` (`sales_rep_id`)
;

-- Table vendor

CREATE TABLE `vendor`
(
  `vendor_id` Int NOT NULL AUTO_INCREMENT,
  `vendor_name` Varchar(30) NOT NULL,
  `location` Varchar(40) NOT NULL,
  PRIMARY KEY (`vendor_id`),
 UNIQUE INDEX `vendor_id` USING BTREE (`vendor_id`)
) ENGINE = InnoDB
 ROW_FORMAT = Compact
;

-- Table vendor_contact

CREATE TABLE `vendor_contact`
(
  `vendor_contact_id` Int NOT NULL AUTO_INCREMENT,
  `vendor_contact_name` Varchar(30) NOT NULL,
  `email` Varchar(50),
  `phone` Varchar(20) NOT NULL,
  `vendor_id` Int NOT NULL,
  PRIMARY KEY (`vendor_contact_id`,`vendor_id`),
 UNIQUE INDEX `vendor_contact_id` USING BTREE (`vendor_contact_id`)
) ENGINE = InnoDB
 ROW_FORMAT = Compact
;

CREATE INDEX `Relationship3` USING BTREE ON `vendor_contact` (`vendor_id`)
;

-- Table education_detail

CREATE TABLE `education_detail`
(
  `institution_name` Varchar(40) NOT NULL,
  `location` Varchar(40) NOT NULL,
  `graduated_year` Int NOT NULL,
  `consultant_id` Int NOT NULL
) ENGINE = InnoDB
 ROW_FORMAT = Compact
;

CREATE UNIQUE INDEX `education_detail_id` USING BTREE ON `education_detail` (`consultant_id`)
;

CREATE INDEX `Relationship51` USING BTREE ON `education_detail` (`consultant_id`)
;

ALTER TABLE `education_detail` ADD  PRIMARY KEY (`consultant_id`)
;

-- Table Client

CREATE TABLE `Client`
(
  `client_id` Int NOT NULL AUTO_INCREMENT,
  `client_name` Varchar(30) NOT NULL,
  `location` Varchar(40) NOT NULL,
  PRIMARY KEY (`client_id`)
) ENGINE = InnoDB
 ROW_FORMAT = Compact
;

-- Table consultant_client

CREATE TABLE `consultant_client`
(
  `consultant_id` Int NOT NULL,
  `client_id` Int NOT NULL,
  `start_date` Date NOT NULL,
  `end_date` Date NOT NULL,
  `consultant_client_id` Int NOT NULL AUTO_INCREMENT,
 UNIQUE INDEX `consultant_client_id` USING BTREE (`consultant_client_id`)
) ENGINE = InnoDB
 ROW_FORMAT = Compact
;

CREATE INDEX `Relationship31` USING BTREE ON `consultant_client` (`client_id`)
;

ALTER TABLE `consultant_client` ADD  PRIMARY KEY (`consultant_id`,`client_id`,`consultant_client_id`)
;

-- Table consultant_vendor

CREATE TABLE `consultant_vendor`
(
  `vendor_id` Int NOT NULL,
  `consultant_id` Int NOT NULL
) ENGINE = InnoDB
 ROW_FORMAT = Compact
;

CREATE INDEX `Relationship33` USING BTREE ON `consultant_vendor` (`consultant_id`)
;

ALTER TABLE `consultant_vendor` ADD  PRIMARY KEY (`vendor_id`,`consultant_id`)
;

-- Table interview

CREATE TABLE `interview`
(
  `interview_id` Int NOT NULL AUTO_INCREMENT,
  `date_time` Datetime,
  `interview_type` Varchar(50),
  `consultant_id` Int NOT NULL,
  `client_id` Int NOT NULL,
  `vendor_id` Int NOT NULL,
  PRIMARY KEY (`interview_id`),
 UNIQUE INDEX `interview_id` USING BTREE (`interview_id`)
) ENGINE = InnoDB
 ROW_FORMAT = Compact
;

CREATE INDEX `Relationship45` USING BTREE ON `interview` (`consultant_id`)
;

CREATE INDEX `Relationship46` USING BTREE ON `interview` (`client_id`)
;

CREATE INDEX `Relationship48` USING BTREE ON `interview` (`vendor_id`)
;

CREATE INDEX `IX_Relationship45` ON `interview` (`consultant_id`)
;

CREATE INDEX `IX_Relationship48` ON `interview` (`vendor_id`)
;

CREATE INDEX `IX_Relationship46` ON `interview` (`client_id`)
;

-- Table sales_representative

CREATE TABLE `sales_representative`
(
  `sales_rep_id` Int NOT NULL AUTO_INCREMENT,
  `name` Varchar(50),
  `phone` Varchar(20) NOT NULL,
  `email` Varchar(50) NOT NULL,
  PRIMARY KEY (`sales_rep_id`),
 UNIQUE INDEX `sales_rep_id` USING BTREE (`sales_rep_id`)
) ENGINE = InnoDB
 ROW_FORMAT = Compact
;

CREATE UNIQUE INDEX `phone` USING BTREE ON `sales_representative` (`phone`)
;

CREATE UNIQUE INDEX `email` USING BTREE ON `sales_representative` (`email`)
;

-- Table user

CREATE TABLE `user`
(
  `user_id` Int NOT NULL,
  `user_name` Varchar(50) NOT NULL,
  `password` Varchar(50) NOT NULL,
  `role` Varchar(50) NOT NULL
) ENGINE = InnoDB
 ROW_FORMAT = Compact
;

CREATE UNIQUE INDEX `user_id` USING BTREE ON `user` (`user_id`)
;

CREATE UNIQUE INDEX `user_name` USING BTREE ON `user` (`user_name`)
;

CREATE UNIQUE INDEX `password` USING BTREE ON `user` (`password`)
;

CREATE UNIQUE INDEX `role` USING BTREE ON `user` (`role`)
;

ALTER TABLE `user` ADD  PRIMARY KEY (`user_id`)
;

-- Create relationships section ------------------------------------------------- 

ALTER TABLE `vendor_contact` ADD CONSTRAINT `Relationship3` FOREIGN KEY (`vendor_id`) REFERENCES `vendor` (`vendor_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
;

ALTER TABLE `consultant_client` ADD CONSTRAINT `Relationship30` FOREIGN KEY (`consultant_id`) REFERENCES `consultant` (`consultant_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
;

ALTER TABLE `consultant_client` ADD CONSTRAINT `Relationship31` FOREIGN KEY (`client_id`) REFERENCES `Client` (`client_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
;

ALTER TABLE `consultant_vendor` ADD CONSTRAINT `Relationship32` FOREIGN KEY (`vendor_id`) REFERENCES `vendor` (`vendor_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
;

ALTER TABLE `consultant_vendor` ADD CONSTRAINT `Relationship33` FOREIGN KEY (`consultant_id`) REFERENCES `consultant` (`consultant_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
;

ALTER TABLE `consultant` ADD CONSTRAINT `Relationship34` FOREIGN KEY (`current_client_id`) REFERENCES `Client` (`client_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE `consultant` ADD CONSTRAINT `Relationship53` FOREIGN KEY (`sales_rep_id`) REFERENCES `sales_representative` (`sales_rep_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
;

ALTER TABLE `education_detail` ADD CONSTRAINT `Relationship51` FOREIGN KEY (`consultant_id`) REFERENCES `consultant` (`consultant_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
;

ALTER TABLE `interview` ADD CONSTRAINT `Relationship45` FOREIGN KEY (`consultant_id`) REFERENCES `consultant` (`consultant_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
;

ALTER TABLE `interview` ADD CONSTRAINT `Relationship46` FOREIGN KEY (`client_id`) REFERENCES `Client` (`client_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
;

ALTER TABLE `interview` ADD CONSTRAINT `Relationship48` FOREIGN KEY (`vendor_id`) REFERENCES `vendor` (`vendor_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
;

