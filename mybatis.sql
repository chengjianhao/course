/*
 Navicat Premium Data Transfer

 Source Server         : 1
 Source Server Type    : MySQL
 Source Server Version : 80015
 Source Host           : localhost:3306
 Source Schema         : mybatis

 Target Server Type    : MySQL
 Target Server Version : 80015
 File Encoding         : 65001

 Date: 09/05/2020 15:24:51
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for engineer
-- ----------------------------
DROP TABLE IF EXISTS `engineer`;
CREATE TABLE `engineer`  (
  `engineer_id` int(11) NOT NULL AUTO_INCREMENT,
  `engineer_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `engineer_sex` int(1) NULL DEFAULT NULL,
  `engineer_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `engineer_telephone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `engineer_birthday` date NULL DEFAULT NULL,
  `engineer_native` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `engineer_seniority` int(2) NULL DEFAULT NULL,
  `engineer_salary` decimal(10, 2) NULL DEFAULT NULL,
  `engineer_education` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`engineer_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of engineer
-- ----------------------------
INSERT INTO `engineer` VALUES (1, '程建皓2', 1, '123', '123', '2020-04-20', '123', 2, 12121.00, '212');
INSERT INTO `engineer` VALUES (2, '程建皓3', 1, '123', '123', '2020-04-20', '123', 2, 12121.00, '212');
INSERT INTO `engineer` VALUES (4, '李娜', 2, '123', '123', '2020-04-20', '123', 2, 12121.00, '212');
INSERT INTO `engineer` VALUES (5, '李娜', 1, '123', '123', '2020-04-20', '123', 2, 12121.00, '212');
INSERT INTO `engineer` VALUES (6, '程建皓4', 1, '123', '123', '2020-04-15', '123', 2, 12121.00, '2126');
INSERT INTO `engineer` VALUES (7, '潘歆韵', 2, '123', '123', '2020-04-20', '123', 2, 12346.00, '212');

-- ----------------------------
-- Table structure for salary
-- ----------------------------
DROP TABLE IF EXISTS `salary`;
CREATE TABLE `salary`  (
  `engineer_id` int(11) NOT NULL,
  `engineer_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `engineer_salary` decimal(10, 2) NULL DEFAULT NULL,
  `engineer_workday` int(2) NULL DEFAULT NULL,
  `engineer_kpi` decimal(3, 0) NULL DEFAULT NULL,
  `engineer_seniority` int(2) NULL DEFAULT NULL,
  `engineer_insurance` decimal(6, 0) NULL DEFAULT NULL,
  `engineer_finalsalary` decimal(10, 2) NULL DEFAULT NULL,
  PRIMARY KEY (`engineer_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of salary
-- ----------------------------
INSERT INTO `salary` VALUES (7, '潘歆韵', 12346.00, NULL, NULL, 2, NULL, NULL);

-- ----------------------------
-- Table structure for user1
-- ----------------------------
DROP TABLE IF EXISTS `user1`;
CREATE TABLE `user1`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `identity` int(1) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user1
-- ----------------------------
INSERT INTO `user1` VALUES (1, 'root', '123456', 0);
INSERT INTO `user1` VALUES (2, 'cjh', '123456', 1);

-- ----------------------------
-- Triggers structure for table engineer
-- ----------------------------
DROP TRIGGER IF EXISTS `trigger1`;
delimiter ;;
CREATE TRIGGER `trigger1` AFTER INSERT ON `engineer` FOR EACH ROW BEGIN

INSERT INTO `salary`(`engineer_id`,`engineer_name`,`engineer_salary`,`engineer_seniority`) VALUES (new.`engineer_id`,new.`engineer_name`,new.`engineer_salary`,new.`engineer_seniority`);
END
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table engineer
-- ----------------------------
DROP TRIGGER IF EXISTS `trigger2`;
delimiter ;;
CREATE TRIGGER `trigger2` AFTER DELETE ON `engineer` FOR EACH ROW BEGIN
DELETE FROM `salary` WHERE `engineer_id`=old.`engineer_id`;
END
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table engineer
-- ----------------------------
DROP TRIGGER IF EXISTS `trigger3`;
delimiter ;;
CREATE TRIGGER `trigger3` AFTER UPDATE ON `engineer` FOR EACH ROW BEGIN
IF @disable_trigger IS NULL THEN
SET @disable_trigger = 1;
UPDATE `salary` 
SET  `engineer_id`=new.`engineer_id`,`engineer_name`=new.`engineer_name`,`engineer_salary`=new.`engineer_salary`,`engineer_seniority`=new.`engineer_seniority`
WHERE `engineer_id`=new.`engineer_id`;
SET @disable_trigger = NULL;
END IF;
END
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table salary
-- ----------------------------
DROP TRIGGER IF EXISTS `trigger4`;
delimiter ;;
CREATE TRIGGER `trigger4` AFTER UPDATE ON `salary` FOR EACH ROW BEGIN
IF @disable_trigger IS NULL THEN
SET @disable_trigger = 1;
UPDATE `engineer` 
SET  `engineer_id`=new.`engineer_id`,`engineer_name`=new.`engineer_name`,`engineer_salary`=new.`engineer_salary`,`engineer_seniority`=new.`engineer_seniority`
WHERE `engineer_id`=new.`engineer_id`;
SET @disable_trigger = NULL;
END IF;
END
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
