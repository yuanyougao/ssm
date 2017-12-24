/*
Navicat MySQL Data Transfer

Source Server         : ceshi
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : ssm

Target Server Type    : MYSQL
Target Server Version : 40099
File Encoding         : 65001

Date: 2017-12-24 21:45:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
`id`  int(11) NOT NULL AUTO_INCREMENT ,
`username`  varchar(64) NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
TYPE=InnoDB

;

-- ----------------------------
-- Records of role
-- ----------------------------
BEGIN;
INSERT INTO `role` VALUES ('3', 'hello2l'), ('4', 'hello2l');
COMMIT;

-- ----------------------------
-- Table structure for `t_class`
-- ----------------------------
DROP TABLE IF EXISTS `t_class`;
CREATE TABLE `t_class` (
`c_id`  int(11) NOT NULL AUTO_INCREMENT ,
`c_name`  varchar(64) NOT NULL ,
`c_no`  varchar(64) NOT NULL ,
PRIMARY KEY (`c_id`)
)
TYPE=InnoDB

;

-- ----------------------------
-- Records of t_class
-- ----------------------------
BEGIN;
INSERT INTO `t_class` VALUES ('1', '高三一班', 'f98bb39f124d46a5b4480a9bd8a5e1a6'), ('2', '高三二班', '531e9941b0224d9b8b7be2b73c615ee3'), ('3', '高三三班', '29c175619a784784bdaabb271d81f8f3');
COMMIT;

-- ----------------------------
-- Table structure for `t_score`
-- ----------------------------
DROP TABLE IF EXISTS `t_score`;
CREATE TABLE `t_score` (
`sc_id`  int(11) NOT NULL AUTO_INCREMENT ,
`sc_score`  double NULL DEFAULT NULL ,
`sc_subject`  varchar(64) NULL DEFAULT NULL ,
`s_no`  varchar(255) NULL DEFAULT NULL ,
PRIMARY KEY (`sc_id`)
)
TYPE=InnoDB

;

-- ----------------------------
-- Records of t_score
-- ----------------------------
BEGIN;
INSERT INTO `t_score` VALUES ('1', '70', '语文', '74e9efd9c8824d808ce400de119d1533'), ('2', '75', '数学', '74e9efd9c8824d808ce400de119d1533'), ('3', '80', '英语', '74e9efd9c8824d808ce400de119d1533'), ('4', '30', '语文', 'acf0b80b2cbf4ed7a5f621a9b5983e24'), ('5', '45', '数学', 'acf0b80b2cbf4ed7a5f621a9b5983e24'), ('6', '27', '英语', 'acf0b80b2cbf4ed7a5f621a9b5983e24'), ('7', '90', '语文', 'bf9434ce06b94421a3bb71c17ae2b1b9'), ('8', '95', '数学', 'bf9434ce06b94421a3bb71c17ae2b1b9'), ('9', '97', '英语', 'bf9434ce06b94421a3bb71c17ae2b1b9');
COMMIT;

-- ----------------------------
-- Table structure for `t_student`
-- ----------------------------
DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student` (
`s_id`  int(64) NOT NULL AUTO_INCREMENT ,
`s_no`  varchar(64) NULL DEFAULT NULL ,
`s_name`  varchar(64) NULL DEFAULT NULL ,
`c_no`  varchar(64) NULL DEFAULT NULL ,
PRIMARY KEY (`s_id`)
)
TYPE=InnoDB

;

-- ----------------------------
-- Records of t_student
-- ----------------------------
BEGIN;
INSERT INTO `t_student` VALUES ('1', '74e9efd9c8824d808ce400de119d1533', '张三', 'f98bb39f124d46a5b4480a9bd8a5e1a6'), ('2', 'acf0b80b2cbf4ed7a5f621a9b5983e24', '李四', '531e9941b0224d9b8b7be2b73c615ee3'), ('3', 'bf9434ce06b94421a3bb71c17ae2b1b9', '王五', '29c175619a784784bdaabb271d81f8f3');
COMMIT;

-- ----------------------------
-- Auto increment value for `role`
-- ----------------------------
ALTER TABLE `role` AUTO_INCREMENT=5;

-- ----------------------------
-- Auto increment value for `t_class`
-- ----------------------------
ALTER TABLE `t_class` AUTO_INCREMENT=4;

-- ----------------------------
-- Auto increment value for `t_score`
-- ----------------------------
ALTER TABLE `t_score` AUTO_INCREMENT=10;

-- ----------------------------
-- Auto increment value for `t_student`
-- ----------------------------
ALTER TABLE `t_student` AUTO_INCREMENT=5;
