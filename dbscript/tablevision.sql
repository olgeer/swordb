/*
 Navicat Premium Data Transfer

 Source Server         : 178
 Source Server Type    : MySQL
 Source Server Version : 50647
 Source Host           : 172.17.21.178:3306
 Source Schema         : companymag

 Target Server Type    : MySQL
 Target Server Version : 50647
 File Encoding         : 65001

 Date: 29/09/2021 17:35:11
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tablevision
-- ----------------------------
DROP TABLE IF EXISTS `tablevision`;
CREATE TABLE `tablevision` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `tablename` varchar(50) NOT NULL COMMENT '表名',
  `columnname` varchar(50) NOT NULL COMMENT '列名',
  `autofill` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '是否自动填充，0：否；1：是',
  `showname` varchar(1024) DEFAULT NULL COMMENT '显示名',
  `describes` varchar(1024) DEFAULT NULL COMMENT '字段描述',
  `defaultvalue` varchar(128) DEFAULT NULL,
  `autoformula` varchar(100) DEFAULT NULL COMMENT '自动公式',
  `dictionaryname` varchar(80) DEFAULT NULL COMMENT '字典名',
  `format` varchar(50) DEFAULT NULL COMMENT '格式化的正则',
  `formcontrol` varchar(50) DEFAULT NULL COMMENT '表单控件',
  `in_use` tinyint(1) DEFAULT '1',
  `ui_sort_order` int(11) DEFAULT '20' COMMENT '控件排序',
  `ui_sort_length` varchar(1) DEFAULT '0' COMMENT '控件宽度',
  PRIMARY KEY (`id`),
  UNIQUE KEY `table_column_unique` (`tablename`,`columnname`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
