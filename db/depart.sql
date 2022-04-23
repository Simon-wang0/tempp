/*
Navicat MySQL Data Transfer

Source Server         : rr
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : renren

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2022-04-23 23:03:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `depart`
-- ----------------------------
DROP TABLE IF EXISTS `depart`;
CREATE TABLE `depart` (
  `depart_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `depart_name` varchar(50) NOT NULL,
  `status` int(2) DEFAULT '0' COMMENT '0 正常  1 停用',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `distinguishing` varchar(20) DEFAULT NULL COMMENT '区分号',
  PRIMARY KEY (`depart_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of depart
-- ----------------------------
INSERT INTO `depart` VALUES ('1', 'jixiao', '1', '2022-04-22 14:42:30', '2022-04-22 14:42:30', null, '100');
INSERT INTO `depart` VALUES ('2', 'yanfa', '0', '2022-04-22 14:42:36', '2022-04-22 14:42:36', null, '200');
INSERT INTO `depart` VALUES ('4', 'baoan', '0', '2022-04-22 22:51:29', '2022-04-22 22:51:29', 'test11111', '1000');
INSERT INTO `depart` VALUES ('5', 'paizhang', '0', '2022-04-23 15:41:19', '2022-04-23 15:41:19', 'test', '1000');
INSERT INTO `depart` VALUES ('6', 'qiantai', '0', '2022-04-23 23:01:54', '2022-04-23 23:01:54', 'test', '1000');
