/*
Navicat MySQL Data Transfer

Source Server         : Test
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : NetworkHomeWork

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2019-01-04 11:19:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userId` bigint(255) NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) NOT NULL,
  `userPass` varchar(255) NOT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '123', '1234');
INSERT INTO `user` VALUES ('2', '1234', '1234');
INSERT INTO `user` VALUES ('3', '1000', '1000');
INSERT INTO `user` VALUES ('4', '2000', '2000');
INSERT INTO `user` VALUES ('5', 'zjy', '1234');
INSERT INTO `user` VALUES ('6', 'zjp', '123');
INSERT INTO `user` VALUES ('7', 'thrift', '123');
INSERT INTO `user` VALUES ('8', 'thrift', '123');
INSERT INTO `user` VALUES ('9', 'thrift', '123');
INSERT INTO `user` VALUES ('10', '123456', '123456');
