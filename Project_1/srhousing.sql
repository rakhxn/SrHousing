/*
Navicat MySQL Data Transfer

Source Server         : main
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : srhousing

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2022-04-07 12:58:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `employees`
-- ----------------------------
DROP TABLE IF EXISTS `employees`;
CREATE TABLE `employees` (
  `firstname` varchar(20) NOT NULL,
  `password` varchar(50) DEFAULT NULL,
  `department` varchar(20) DEFAULT NULL,
  `admin` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`firstname`),
  UNIQUE KEY `firstname` (`firstname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of employees
-- ----------------------------
INSERT INTO `employees` VALUES ('dummy', 'dummy', 'dummy', 'no');
INSERT INTO `employees` VALUES ('rajiv', 'password', 'security', 'yes');
INSERT INTO `employees` VALUES ('sean', 'password', 'security', 'yes');

-- ----------------------------
-- Table structure for `residents`
-- ----------------------------
DROP TABLE IF EXISTS `residents`;
CREATE TABLE `residents` (
  `resident_id` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(25) NOT NULL,
  `lastName` varchar(25) NOT NULL,
  `unit` varchar(3) NOT NULL,
  `emergencyContact` varchar(30) NOT NULL,
  PRIMARY KEY (`resident_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of residents
-- ----------------------------
INSERT INTO `residents` VALUES ('1', 'Rajiv', 'Khan', '001', '9178426467');
INSERT INTO `residents` VALUES ('2', 'Sean', 'White', '002', '9178426467');
