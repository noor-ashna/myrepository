/*
Navicat MySQL Data Transfer

Source Server         : LOCAL
Source Server Version : 50730
Source Host           : localhost:3306
Source Database       : cubictech_db

Target Server Type    : MYSQL
Target Server Version : 50730
File Encoding         : 65001

Date: 2020-10-24 01:00:11
*/

SET FOREIGN_KEY_CHECKS=0;

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
