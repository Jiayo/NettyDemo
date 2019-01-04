/*
Navicat MySQL Data Transfer

Source Server         : Test
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : NetworkHomeWork

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2019-01-04 11:20:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for group
-- ----------------------------
DROP TABLE IF EXISTS `group`;
CREATE TABLE `group` (
  `dataId` bigint(20) NOT NULL AUTO_INCREMENT,
  `groupId` bigint(20) NOT NULL,
  `userName` varchar(255) NOT NULL,
  PRIMARY KEY (`dataId`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of group
-- ----------------------------
INSERT INTO `group` VALUES ('2', '1', 'zjy');
INSERT INTO `group` VALUES ('3', '3', 'zjy');
INSERT INTO `group` VALUES ('5', '2', '123');
INSERT INTO `group` VALUES ('6', '3', '123');
INSERT INTO `group` VALUES ('7', '5', '123');
INSERT INTO `group` VALUES ('9', '4', '123');
INSERT INTO `group` VALUES ('10', '1', '1234');
INSERT INTO `group` VALUES ('11', '2', '1234');
