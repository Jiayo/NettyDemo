/*
Navicat MySQL Data Transfer

Source Server         : Test
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : NetworkHomeWork

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2019-01-04 11:20:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for friend
-- ----------------------------
DROP TABLE IF EXISTS `friend`;
CREATE TABLE `friend` (
  `I_count` varchar(255) NOT NULL,
  `Y_count` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of friend
-- ----------------------------
INSERT INTO `friend` VALUES ('123', '123');
INSERT INTO `friend` VALUES ('11', '11');
INSERT INTO `friend` VALUES ('123', 'zjp');
INSERT INTO `friend` VALUES ('123', '1245');
INSERT INTO `friend` VALUES ('1234', '123');
INSERT INTO `friend` VALUES ('1234', 'zjp');
INSERT INTO `friend` VALUES ('1234', 'zjy');
