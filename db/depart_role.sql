/*
Navicat MySQL Data Transfer

Source Server         : rr
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : renren

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2022-04-23 23:04:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `depart_role`
-- ----------------------------
DROP TABLE IF EXISTS `depart_role`;
CREATE TABLE `depart_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `depart_id` bigint(20) DEFAULT NULL,
  `role_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of depart_role
-- ----------------------------
INSERT INTO `depart_role` VALUES ('1', '1', '1');
INSERT INTO `depart_role` VALUES ('2', '2', '2');
INSERT INTO `depart_role` VALUES ('11', '229257111889789385', '1');
