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

 Date: 09/05/2020 16:47:06
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
  `engineer_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `engineer_telephone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `engineer_birthday` date DEFAULT NULL,
  `engineer_native` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `engineer_seniority` int(2) DEFAULT NULL,
  `engineer_salary` decimal(10,2) DEFAULT NULL,
  `engineer_education` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`engineer_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of engineer
-- ----------------------------
BEGIN;
INSERT INTO `engineer` VALUES (1, '程建皓2', 1, '123', '123', '2020-04-20', '123', 2, 12121.00, '212');
INSERT INTO `engineer` VALUES (2, '程建皓3', 1, '123', '123', '2020-04-20', '123', 2, 12121.00, '212');
INSERT INTO `engineer` VALUES (4, '李娜', 2, '123', '123', '2020-04-20', '123', 2, 12121.00, '212');
INSERT INTO `engineer` VALUES (5, '李娜', 1, '123', '123', '2020-04-20', '123', 2, 12121.00, '212');
INSERT INTO `engineer` VALUES (6, '程建皓4', 1, '123', '123', '2020-04-15', '123', 2, 12121.00, '2126');
INSERT INTO `engineer` VALUES (7, '潘歆韵', 2, '123', '123', '2020-04-20', '123', 2, 12346.00, '212');
COMMIT;

-- ----------------------------
-- Table structure for record
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `operation` varchar(255) DEFAULT NULL,
  `time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for salary
-- ----------------------------
DROP TABLE IF EXISTS `salary`;
CREATE TABLE `salary` (
  `engineer_id` int(11) NOT NULL,
  `engineer_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `engineer_salary` decimal(10,2) DEFAULT NULL,
  `engineer_workday` int(2) DEFAULT NULL,
  `engineer_kpi` decimal(3,0) DEFAULT NULL,
  `engineer_seniority` int(2) DEFAULT NULL,
  `engineer_insurance` decimal(6,0) DEFAULT NULL,
  `engineer_finalsalary` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`engineer_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of salary
-- ----------------------------
BEGIN;
INSERT INTO `salary` VALUES (7, '潘歆韵', 12346.00, NULL, NULL, 2, NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for user1
-- ----------------------------
DROP TABLE IF EXISTS `user1`;
CREATE TABLE `user1` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `identity` int(1) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of user1
-- ----------------------------
BEGIN;
INSERT INTO `user1` VALUES (1, 'root', '123456', 0);
INSERT INTO `user1` VALUES (2, 'cjh', '123456', 1);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
