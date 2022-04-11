/*
Navicat MySQL Data Transfer

Source Server         : main
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : srhousing

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2022-04-11 07:38:06
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
INSERT INTO `employees` VALUES ('rajiv', '6cb75f652a9b52798eb6cf2201057c73', 'security', 'no');
INSERT INTO `employees` VALUES ('sean', '6cb75f652a9b52798eb6cf2201057c73', 'security', 'yes');

-- ----------------------------
-- Table structure for `login_logs`
-- ----------------------------
DROP TABLE IF EXISTS `login_logs`;
CREATE TABLE `login_logs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(20) NOT NULL,
  `date` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of login_logs
-- ----------------------------
INSERT INTO `login_logs` VALUES ('1', 'rajiv', '04/02/2001');
INSERT INTO `login_logs` VALUES ('2', 'sean', '04/20/2001');
INSERT INTO `login_logs` VALUES ('3', 'rajiv', '04/20/2001');
INSERT INTO `login_logs` VALUES ('4', 'sean', '04/02/2001');
INSERT INTO `login_logs` VALUES ('5', 'rajiv', '04/11/2022');
INSERT INTO `login_logs` VALUES ('6', 'rajiv', '04/11/2022');
INSERT INTO `login_logs` VALUES ('7', 'rajiv', '04/11/2022');
INSERT INTO `login_logs` VALUES ('8', 'rajiv', '04/11/2022');
INSERT INTO `login_logs` VALUES ('9', 'rajiv', '04/11/2022');
INSERT INTO `login_logs` VALUES ('10', 'rajiv', '04/11/2022');
INSERT INTO `login_logs` VALUES ('11', 'rajiv', '04/11/2022');
INSERT INTO `login_logs` VALUES ('12', 'rajiv', '04/11/2022');
INSERT INTO `login_logs` VALUES ('13', 'sean', '04/11/2022');

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
