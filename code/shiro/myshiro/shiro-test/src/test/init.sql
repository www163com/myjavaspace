/*
Navicat MySQL Data Transfer

Source Server         : mywork
Source Server Version : 50722
Source Host           : localhost:3306
Source Database       : myshiro

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2018-12-26 14:51:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `roles_permissions`
-- ----------------------------
DROP TABLE IF EXISTS `roles_permissions`;
CREATE TABLE `roles_permissions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(30) DEFAULT NULL,
  `permission` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of roles_permissions
-- ----------------------------
INSERT INTO `roles_permissions` VALUES ('1', 'admin', 'user:delete');

-- ----------------------------
-- Table structure for `test_user`
-- ----------------------------
DROP TABLE IF EXISTS `test_user`;
CREATE TABLE `test_user` (
  `id` int(11) NOT NULL,
  `name` varchar(30) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of test_user
-- ----------------------------
INSERT INTO `test_user` VALUES ('1', 'xiaoming', '111111');

-- ----------------------------
-- Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', 'billyang', '123456');

-- ----------------------------
-- Table structure for `user_roles`
-- ----------------------------
DROP TABLE IF EXISTS `user_roles`;
CREATE TABLE `user_roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) NOT NULL,
  `role_name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_roles
-- ----------------------------
INSERT INTO `user_roles` VALUES ('1', 'billyang', 'admin');
