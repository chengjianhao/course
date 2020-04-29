/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Host           : localhost:3306
 Source Schema         : mybatis

 Target Server Type    : MySQL
 Target Server Version : 80016
 File Encoding         : 65001

 Date: 29/04/2020 09:33:30
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for engineer
-- ----------------------------
DROP TABLE IF EXISTS `engineer`;
CREATE TABLE `engineer` (
  `engineer_id` int(11) NOT NULL AUTO_INCREMENT,
  `engineer_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `engineer_sex` int(1) DEFAULT NULL,
  `engineer_address` varchar(255) DEFAULT NULL,
  `engineer_telephone` varchar(255) DEFAULT NULL,
  `engineer_birthday` date DEFAULT NULL,
  `engineer_native` varchar(20) DEFAULT NULL,
  `engineer_seniority` int(2) DEFAULT NULL,
  `engineer_salary` decimal(10,2) DEFAULT NULL,
  `engineer_education` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`engineer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of engineer
-- ----------------------------
BEGIN;
INSERT INTO `engineer` VALUES (1, '程建皓2', 1, '123', '123', '2020-04-25', '123', 2, 12121.00, '212');
INSERT INTO `engineer` VALUES (2, 'Sanka Rea', 0, '123', '123', '2020-04-22', '123', 1, 1.00, '1');
INSERT INTO `engineer` VALUES (6, '程建皓3', 1, '123', '123', '2020-04-09', '123', 1, 1.00, '1');
COMMIT;

-- ----------------------------
-- Table structure for user1
-- ----------------------------
DROP TABLE IF EXISTS `user1`;
CREATE TABLE `user1` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of user1
-- ----------------------------
BEGIN;
INSERT INTO `user1` VALUES (1, 'root', '123456');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
