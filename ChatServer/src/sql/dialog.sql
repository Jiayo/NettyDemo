/*
Navicat MySQL Data Transfer

Source Server         : Test
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : NetworkHomeWork

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2019-01-04 11:20:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for dialog
-- ----------------------------
DROP TABLE IF EXISTS `dialog`;
CREATE TABLE `dialog` (
  `userName` varchar(255) NOT NULL,
  PRIMARY KEY (`userName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dialog
-- ----------------------------
