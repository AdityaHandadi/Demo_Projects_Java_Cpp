create database splitw;

use splitw;

CREATE TABLE `register` (
  `groupid` int(11) NOT NULL AUTO_INCREMENT,
  `groupname` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`groupid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

CREATE TABLE `expense` (
  `idexpense` int(11) NOT NULL AUTO_INCREMENT,
  `groupname` varchar(45) DEFAULT NULL,
  `paidby` varchar(45) DEFAULT NULL,
  `amount` double DEFAULT NULL,
  `owedby` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idexpense`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `members` (
  `idmembers` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `groupname` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idmembers`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

