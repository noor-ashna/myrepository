/*
Navicat MySQL Data Transfer

Source Server         : LOCAL
Source Server Version : 50730
Source Host           : localhost:3306
Source Database       : cubictech_db

Target Server Type    : MYSQL
Target Server Version : 50730
File Encoding         : 65001

Date: 2020-12-01 07:24:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `computer_tbl`
-- ----------------------------
DROP TABLE IF EXISTS `computer_tbl`;
CREATE TABLE `computer_tbl` (
  `serialno` int(11) NOT NULL AUTO_INCREMENT,
  `make` varchar(100) DEFAULT NULL,
  `model` varchar(200) DEFAULT NULL,
  `processor` varchar(100) DEFAULT NULL,
  `manufacturingdate` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`serialno`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of computer_tbl
-- ----------------------------

-- ----------------------------
-- Table structure for `fruits_tbl`
-- ----------------------------
DROP TABLE IF EXISTS `fruits_tbl`;
CREATE TABLE `fruits_tbl` (
  `mid` int(11) NOT NULL AUTO_INCREMENT,
  `color` varchar(12) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `dob` datetime DEFAULT NULL,
  `price` float NOT NULL,
  `taste` varchar(20) DEFAULT NULL,
  `url` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`mid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of fruits_tbl
-- ----------------------------
INSERT INTO `fruits_tbl` VALUES ('2', 'red', 'Do not eat mango daily!@!!', '2020-11-11 07:07:25', '900', 'sour', 'http://localhost:43');

-- ----------------------------
-- Table structure for `jockers_tbl`
-- ----------------------------
DROP TABLE IF EXISTS `jockers_tbl`;
CREATE TABLE `jockers_tbl` (
  `jid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `email` varchar(200) DEFAULT NULL,
  `doe` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`jid`)
) ENGINE=InnoDB AUTO_INCREMENT=104 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of jockers_tbl
-- ----------------------------
INSERT INTO `jockers_tbl` VALUES ('100', 'Mocha', '12', '23', 'joeiei@gmail.com', '2020-10-24 00:17:16');
INSERT INTO `jockers_tbl` VALUES ('101', 'O928383', '1', '0', 'jsdh83y3@gmail.com', '2020-10-24 00:47:34');
INSERT INTO `jockers_tbl` VALUES ('103', 'Oeiie', '23', '0.388464', 'eoiweiei@gmail.com', '2020-10-24 00:57:55');

-- ----------------------------
-- Table structure for `mobile_tbl`
-- ----------------------------
DROP TABLE IF EXISTS `mobile_tbl`;
CREATE TABLE `mobile_tbl` (
  `mid` int(11) NOT NULL AUTO_INCREMENT,
  `brand` varchar(255) DEFAULT NULL,
  `color` varchar(255) DEFAULT NULL,
  `price` int(11) NOT NULL,
  `personid` int(11) NOT NULL,
  PRIMARY KEY (`mid`),
  KEY `FK_aaflx3lv25b4snmqg7o1b1km7` (`personid`),
  CONSTRAINT `FK_aaflx3lv25b4snmqg7o1b1km7` FOREIGN KEY (`personid`) REFERENCES `person_tbl` (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of mobile_tbl
-- ----------------------------
INSERT INTO `mobile_tbl` VALUES ('1', 'iPhone', 'pink', '122', '2');
INSERT INTO `mobile_tbl` VALUES ('2', 'iPhone', 'pink', '122', '3');
INSERT INTO `mobile_tbl` VALUES ('3', 'iPhone', 'pink', '122', '3');
INSERT INTO `mobile_tbl` VALUES ('4', 'Samsung', 'white', '342', '3');

-- ----------------------------
-- Table structure for `passport_tbl`
-- ----------------------------
DROP TABLE IF EXISTS `passport_tbl`;
CREATE TABLE `passport_tbl` (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `dob` varchar(100) DEFAULT NULL,
  `number` varchar(40) DEFAULT NULL,
  `personid` int(11) DEFAULT NULL,
  `ppid` int(11) DEFAULT NULL,
  PRIMARY KEY (`pid`),
  UNIQUE KEY `UK_85ksfvoqocd1f1uxvcqvunglx` (`personid`),
  UNIQUE KEY `UK_l8jgmu8dbeu3rhbh0jellkrpw` (`ppid`),
  CONSTRAINT `FK_85ksfvoqocd1f1uxvcqvunglx` FOREIGN KEY (`personid`) REFERENCES `person_tbl` (`pid`),
  CONSTRAINT `FK_l8jgmu8dbeu3rhbh0jellkrpw` FOREIGN KEY (`ppid`) REFERENCES `person_tbl` (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of passport_tbl
-- ----------------------------
INSERT INTO `passport_tbl` VALUES ('1', '12-8-1213', 'P9338GA63', '1', null);

-- ----------------------------
-- Table structure for `person_roles`
-- ----------------------------
DROP TABLE IF EXISTS `person_roles`;
CREATE TABLE `person_roles` (
  `rid` int(11) NOT NULL,
  `pid` int(11) NOT NULL,
  KEY `FK_t04jg68368pg5mpmje3w9vqd1` (`pid`),
  KEY `FK_9ytg66cfoxawfh94qpovro2o3` (`rid`),
  CONSTRAINT `FK_9ytg66cfoxawfh94qpovro2o3` FOREIGN KEY (`rid`) REFERENCES `role_tbl` (`rid`),
  CONSTRAINT `FK_t04jg68368pg5mpmje3w9vqd1` FOREIGN KEY (`pid`) REFERENCES `person_tbl` (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of person_roles
-- ----------------------------
INSERT INTO `person_roles` VALUES ('2', '2');
INSERT INTO `person_roles` VALUES ('3', '3');
INSERT INTO `person_roles` VALUES ('1', '2');

-- ----------------------------
-- Table structure for `person_tbl`
-- ----------------------------
DROP TABLE IF EXISTS `person_tbl`;
CREATE TABLE `person_tbl` (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(200) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of person_tbl
-- ----------------------------
INSERT INTO `person_tbl` VALUES ('1', 'nagendra@gmail.com', 'Nagendra Kumar');
INSERT INTO `person_tbl` VALUES ('2', 'omdudh@gmail.com', 'Nagenda');
INSERT INTO `person_tbl` VALUES ('3', 'omdudh@gmail.com', 'Nagenda');

-- ----------------------------
-- Table structure for `profiles_tbl`
-- ----------------------------
DROP TABLE IF EXISTS `profiles_tbl`;
CREATE TABLE `profiles_tbl` (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `doe` datetime DEFAULT NULL,
  `education` varchar(255) DEFAULT NULL,
  `ssn` varchar(255) DEFAULT NULL,
  `fsid` int(11) NOT NULL,
  PRIMARY KEY (`pid`),
  UNIQUE KEY `UK_pirhvgu9jg52rtwy1egwetwgj` (`fsid`),
  CONSTRAINT `FKfuq6vy53a5ntu7a7g8ebp951q` FOREIGN KEY (`fsid`) REFERENCES `user_profiles_tbl` (`lid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of profiles_tbl
-- ----------------------------
INSERT INTO `profiles_tbl` VALUES ('1', 'Coming soon!', '2020-11-12 01:32:38', 'MS', '133244', '6');
INSERT INTO `profiles_tbl` VALUES ('2', 'Coming soon!', '2020-11-25 01:49:21', 'MS', '133244', '7');

-- ----------------------------
-- Table structure for `roles_tbl`
-- ----------------------------
DROP TABLE IF EXISTS `roles_tbl`;
CREATE TABLE `roles_tbl` (
  `rid` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`rid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of roles_tbl
-- ----------------------------
INSERT INTO `roles_tbl` VALUES ('1', 'ADMIN', 'ADMIN');
INSERT INTO `roles_tbl` VALUES ('2', 'CUSTOMER', 'CUSTOMER');
INSERT INTO `roles_tbl` VALUES ('3', 'EMPLOYEE', 'EMPLOYEE');
INSERT INTO `roles_tbl` VALUES ('4', 'MANAGER', 'MANAGER');
INSERT INTO `roles_tbl` VALUES ('5', 'STUDENT', 'STUDENT');

-- ----------------------------
-- Table structure for `role_tbl`
-- ----------------------------
DROP TABLE IF EXISTS `role_tbl`;
CREATE TABLE `role_tbl` (
  `rid` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`rid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of role_tbl
-- ----------------------------
INSERT INTO `role_tbl` VALUES ('1', 'Employee', 'Employee');
INSERT INTO `role_tbl` VALUES ('2', 'Admin', 'Admin');
INSERT INTO `role_tbl` VALUES ('3', 'Customer', 'Customer');

-- ----------------------------
-- Table structure for `signup_history_tbl`
-- ----------------------------
DROP TABLE IF EXISTS `signup_history_tbl`;
CREATE TABLE `signup_history_tbl` (
  `shid` int(11) NOT NULL AUTO_INCREMENT,
  `intime` datetime DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `outtime` datetime DEFAULT NULL,
  `fsid` int(11) NOT NULL,
  PRIMARY KEY (`shid`),
  KEY `FK5ydflixcyt3ko6xwj5jgixr67` (`fsid`),
  CONSTRAINT `FK5ydflixcyt3ko6xwj5jgixr67` FOREIGN KEY (`fsid`) REFERENCES `user_profiles_tbl` (`lid`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of signup_history_tbl
-- ----------------------------

-- ----------------------------
-- Table structure for `signup_roles_tbl`
-- ----------------------------
DROP TABLE IF EXISTS `signup_roles_tbl`;
CREATE TABLE `signup_roles_tbl` (
  `lid` int(11) NOT NULL,
  `rid` int(11) NOT NULL,
  KEY `FKi8mef9plp24u3k41p204eturl` (`rid`),
  KEY `FKas39bvmo0ybh18jhe3g605388` (`lid`),
  CONSTRAINT `FKas39bvmo0ybh18jhe3g605388` FOREIGN KEY (`lid`) REFERENCES `user_profiles_tbl` (`lid`),
  CONSTRAINT `FKi8mef9plp24u3k41p204eturl` FOREIGN KEY (`rid`) REFERENCES `roles_tbl` (`rid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of signup_roles_tbl
-- ----------------------------
INSERT INTO `signup_roles_tbl` VALUES ('7', '1');
INSERT INTO `signup_roles_tbl` VALUES ('6', '5');

-- ----------------------------
-- Table structure for `user_profiles_tbl`
-- ----------------------------
DROP TABLE IF EXISTS `user_profiles_tbl`;
CREATE TABLE `user_profiles_tbl` (
  `lid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) DEFAULT NULL,
  `password` varchar(500) DEFAULT NULL,
  `role` varchar(30) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `email` varchar(400) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `photo` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`lid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of user_profiles_tbl
-- ----------------------------
INSERT INTO `user_profiles_tbl` VALUES ('6', 'javatech1000@gmail.com', '$2a$12$juGjgUWn7y6DrHHb917UaeL8LhxwaElIf/pQlIhHXaCpXdd3g3mqi', 'Employee', 'YADAV', 'javahunk100@gmail.com', 'Other', 'https://techcrunch.com/wp-content/uploads/2015/09/11667534_10102203860243201_2713296330820668368_n.jpg?w=528');
INSERT INTO `user_profiles_tbl` VALUES ('7', 'yadna01', '$2a$12$juGjgUWn7y6DrHHb917UaeL8LhxwaElIf/pQlIhHXaCpXdd3g3mqi', 'Employee', 'NAGENDRA KUMAR', 'technohunk100@gmail.com', 'Male', 'https://5.imimg.com/data5/LM/DU/MY-22954806/apple-fruit-500x500.jpg');

-- ----------------------------
-- Table structure for `vehicle_tbl`
-- ----------------------------
DROP TABLE IF EXISTS `vehicle_tbl`;
CREATE TABLE `vehicle_tbl` (
  `vid` int(11) NOT NULL AUTO_INCREMENT,
  `brand` varchar(255) DEFAULT NULL,
  `color` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`vid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of vehicle_tbl
-- ----------------------------
INSERT INTO `vehicle_tbl` VALUES ('1', 'Audi', 'red');
INSERT INTO `vehicle_tbl` VALUES ('5', 'Mew', 'pink');
