/*
Navicat MySQL Data Transfer

Source Server         : LOCAL
Source Server Version : 50730
Source Host           : localhost:3306
Source Database       : rab3tech_db

Target Server Type    : MYSQL
Target Server Version : 50730
File Encoding         : 65001

Date: 2020-11-04 06:48:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `signup_tbl`
-- ----------------------------
DROP TABLE IF EXISTS `signup_tbl`;
CREATE TABLE `signup_tbl` (
  `sid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) DEFAULT NULL,
  `email` varchar(200) DEFAULT NULL,
  `gender` varchar(7) DEFAULT NULL,
  `role` varchar(30) DEFAULT NULL,
  `photo` varchar(1000) DEFAULT NULL,
  `doe` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of signup_tbl
-- ----------------------------
INSERT INTO `signup_tbl` VALUES ('1', 'jack', 'jill', 'jill@gmail.com', 'Male', 'Admin', 'https://cdn1.vectorstock.com/i/1000x1000/18/55/apple-fruit-design-vector-23321855.jpg', '2020-11-04 06:34:28');
INSERT INTO `signup_tbl` VALUES ('2', 'jackajala', 'test', 'javahunk100@gmail.com', 'Female', 'Admin', 'https://static.independent.co.uk/s3fs-public/thumbnails/image/2017/06/27/15/tom-sodoge-59546-0.jpg?width=668', '2020-11-04 06:40:49');
INSERT INTO `signup_tbl` VALUES ('3', 'technohunk100', 'testata', 'technohunk100@gmail.com', 'Male', 'Employee', 'https://techcrunch.com/wp-content/uploads/2015/09/11667534_10102203860243201_2713296330820668368_n.jpg?w=528', '2020-11-04 06:47:25');
