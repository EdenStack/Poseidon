/*
 Navicat Premium Data Transfer

 Source Server         : LocalMySQL
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : localhost
 Source Database       : luoo

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : utf-8

 Date: 03/25/2017 17:41:46 PM
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `journal`
-- ----------------------------
DROP TABLE IF EXISTS `journal`;
CREATE TABLE `journal` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) NOT NULL COMMENT '期刊标题',
  `vol_desc` text COMMENT '期刊描述',
  `journal_id` int(11) NOT NULL COMMENT '期刊ID',
  `key_words` tinytext COMMENT '期刊关键字',
  `vol_cover_img` varchar(255) DEFAULT NULL COMMENT '期刊封面',
  `tracks` varchar(20) NOT NULL COMMENT '曲目ID列表',
  `relative_vols` varchar(255) DEFAULT NULL COMMENT '相似期刊列表',
  `vol_date` varchar(10) DEFAULT NULL COMMENT '期刊创建日期',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `journal_id_index` (`journal_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `track`
-- ----------------------------
DROP TABLE IF EXISTS `track`;
CREATE TABLE `track` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `track_id` int(11) NOT NULL COMMENT '曲目ID',
  `name` varchar(100) DEFAULT NULL COMMENT '曲目名称',
  `artist` varchar(50) DEFAULT NULL COMMENT '艺术家',
  `cover_img` varchar(255) DEFAULT NULL COMMENT '专辑封面url',
  `album` varchar(255) DEFAULT NULL COMMENT '曲目所属专辑名',
  `mp3_url_suffix` varchar(255) DEFAULT NULL COMMENT '曲目下载url',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `track_id_index` (`track_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
