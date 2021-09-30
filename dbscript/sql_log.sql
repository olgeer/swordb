/*
 Navicat Premium Data Transfer

 Source Server         : home
 Source Server Type    : MySQL
 Source Server Version : 50729
 Source Host           : olgeer.3322.org:3306
 Source Schema         : company1009

 Target Server Type    : MySQL
 Target Server Version : 50729
 File Encoding         : 65001

 Date: 30/09/2021 11:51:18
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for glob_sql_log
-- ----------------------------
DROP TABLE IF EXISTS `glob_sql_log`;
CREATE TABLE `glob_sql_log` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '编号',
  `account` varchar(30) NOT NULL COMMENT '操作账号',
  `tablename` varchar(50) NOT NULL COMMENT '相关表名',
  `action` varchar(10) NOT NULL COMMENT '操作类型，insert、update、delete',
  `sqlstring` varchar(512) NOT NULL COMMENT '执行语句',
  `value` varchar(512) DEFAULT NULL COMMENT '数值',
  `logtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '日志记录时间',
  `errormsg` varchar(128) DEFAULT NULL COMMENT '错误信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
