CREATE DATABASE `maps`;

CREATE TABLE `register` (
  `fname` varchar(20) DEFAULT NULL,
  `lname` varchar(20) DEFAULT NULL,
  `email` varchar(200) NOT NULL DEFAULT '',
  `password` varchar(20) DEFAULT NULL,
  `purpose` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `rider` (
  `routeid` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(200) DEFAULT NULL,
  `sourcelocation` varchar(200) DEFAULT NULL,
  `wp1` varchar(200) DEFAULT NULL,
  `wp2` varchar(200) DEFAULT NULL,
  `wp3` varchar(200) DEFAULT NULL,
  `wp4` varchar(200) DEFAULT NULL,
  `wp5` varchar(200) DEFAULT NULL,
  `wp6` varchar(200) DEFAULT NULL,
  `wp7` varchar(200) DEFAULT NULL,
  `wp8` varchar(200) DEFAULT NULL,
  `destinationloc` varchar(200) DEFAULT NULL,
  `ridedate` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`routeid`),
  KEY `fk_email` (`email`),
  CONSTRAINT `fk_email` FOREIGN KEY (`email`) REFERENCES `register` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;


CREATE TABLE `customer` (
  `custrouteid` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(20) DEFAULT NULL,
  `routeid` int(11) DEFAULT NULL,
  `sourcelocation` varchar(200) DEFAULT NULL,
  `destinationloc` varchar(200) DEFAULT NULL,
  `ridedate` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`custrouteid`),
  KEY `fk_email2` (`email`),
  KEY `fk_routeid` (`routeid`),
  CONSTRAINT `fk_email2` FOREIGN KEY (`email`) REFERENCES `register` (`email`),
  CONSTRAINT `fk_routeid` FOREIGN KEY (`routeid`) REFERENCES `rider` (`routeid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


ALTER TABLE `maps`.`rider` 
ADD COLUMN `seatlimit` INT NULL DEFAULT NULL AFTER `ridedate`;

ALTER TABLE `maps`.`customer` 
CHANGE COLUMN `sourcelocation` `sourcelocation` VARCHAR(200) NULL DEFAULT NULL ,
CHANGE COLUMN `destinationloc` `destinationloc` VARCHAR(200) NULL DEFAULT NULL ;

CREATE TABLE `advancedbooking` (
  `bookid` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(20) DEFAULT NULL,
  `routeid` int(11) DEFAULT NULL,
  `sourcelocation` varchar(200) DEFAULT NULL,
  `destinationloc` varchar(200) DEFAULT NULL,
  `ridedate` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`bookid`),
  KEY `fk_email2` (`email`),
  KEY `fk_routeid2` (`routeid`),
  CONSTRAINT `fk_email3` FOREIGN KEY (`email`) REFERENCES `register` (`email`),
  CONSTRAINT `fk_routeid2` FOREIGN KEY (`routeid`) REFERENCES `rider` (`routeid`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

ALTER TABLE `maps`.`advancedbooking` 
DROP FOREIGN KEY `fk_routeid2`;

ALTER TABLE `maps`.`advancedbooking` 
DROP FOREIGN KEY `fk_email3`;
ALTER TABLE `maps`.`advancedbooking` 
CHANGE COLUMN `email` `email` VARCHAR(200) NULL DEFAULT NULL ;
ALTER TABLE `maps`.`advancedbooking` 
ADD CONSTRAINT `fk_email3`
  FOREIGN KEY (`email`)
  REFERENCES `maps`.`register` (`email`);

ALTER TABLE `maps`.`customer` 
DROP FOREIGN KEY `fk_routeid`;
ALTER TABLE `maps`.`customer` 
ADD CONSTRAINT `fk_routeid`
  FOREIGN KEY (`routeid`)
  REFERENCES `maps`.`rider` (`routeid`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;

ALTER TABLE `maps`.`customer` 
DROP FOREIGN KEY `fk_email2`;
ALTER TABLE `maps`.`customer` 
CHANGE COLUMN `email` `email` VARCHAR(200) NULL DEFAULT NULL ;
ALTER TABLE `maps`.`customer` 
ADD CONSTRAINT `fk_email2`
  FOREIGN KEY (`email`)
  REFERENCES `maps`.`register` (`email`);

ALTER TABLE `maps`.`rider` 
ADD COLUMN `sourcestr` VARCHAR(200) NULL DEFAULT NULL AFTER `seatlimit`,
ADD COLUMN `deststr` VARCHAR(200) NULL DEFAULT NULL AFTER `sourcestr`;
