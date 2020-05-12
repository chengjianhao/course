/*
 Navicat Premium Data Transfer

 Source Server         : pxy
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : localhost:3306
 Source Schema         : mybatis

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 10/05/2020 22:32:10
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
  `engineer_education` int(1) NULL DEFAULT NULL,
  `engineer_finalsalary` decimal(10, 2) NULL DEFAULT NULL,
  PRIMARY KEY (`engineer_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of engineer
-- ----------------------------
INSERT INTO `engineer` VALUES (15, '张三', 1, '浙江', 'xxxxxxxxxx', '2020-05-14', '台州', 2, 2345.00, '2', 2110.50);
INSERT INTO `engineer` VALUES (16, '李四', 1, '浙江台州', '123123', '2020-05-21', '浙江', 3, 3246.00, '2', 2921.40);
INSERT INTO `engineer` VALUES (17, '王五', 1, '浙江', '123123123', '2020-05-13', '台州', 1, 1268.00, '2', 1386.70);
INSERT INTO `engineer` VALUES (18, '小明', 1, '浙江', 'xxxxxxxxxx', '2020-05-22', '台州', 3, 2367.00, '2', 2130.30);
INSERT INTO `engineer` VALUES (19, '123', 1, '浙江', '123123', '2020-05-14', '台州', 2, 40.00, '3', 36.00);

-- ----------------------------
-- Table structure for record
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `operation` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `time` timestamp(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of record
-- ----------------------------
INSERT INTO `record` VALUES (6, 'root', '添加用户张三', '2020-05-10 21:23:16');
INSERT INTO `record` VALUES (7, 'root', '添加用户李四', '2020-05-10 21:24:52');
INSERT INTO `record` VALUES (8, 'root', '添加用户王五', '2020-05-10 21:25:36');
INSERT INTO `record` VALUES (9, 'root', '添加用户Sanka Rea', '2020-05-10 21:26:02');
INSERT INTO `record` VALUES (10, 'root', '修改用户Sanka Rea', '2020-05-10 21:26:21');
INSERT INTO `record` VALUES (11, 'root', '添加用户张三', '2020-05-10 21:30:49');
INSERT INTO `record` VALUES (12, 'root', '添加用户李四', '2020-05-10 21:31:07');
INSERT INTO `record` VALUES (13, 'root', '添加用户王五', '2020-05-10 21:31:28');
INSERT INTO `record` VALUES (14, 'root', '添加用户张三', '2020-05-10 21:45:11');
INSERT INTO `record` VALUES (15, 'root', '添加用户李四', '2020-05-10 21:46:01');
INSERT INTO `record` VALUES (16, 'root', '添加用户王五', '2020-05-10 21:46:23');
INSERT INTO `record` VALUES (17, 'root', '修改用户王五', '2020-05-10 21:51:04');
INSERT INTO `record` VALUES (18, 'root', '添加用户张三', '2020-05-10 21:53:46');
INSERT INTO `record` VALUES (19, 'root', '添加用户0', '2020-05-10 22:19:38');
INSERT INTO `record` VALUES (20, 'root', '添加用户0', '2020-05-10 22:20:09');
INSERT INTO `record` VALUES (21, 'root', '添加用户111', '2020-05-10 22:23:26');
INSERT INTO `record` VALUES (22, 'root', '修改用户111', '2020-05-10 22:24:17');

-- ----------------------------
-- Table structure for salary
-- ----------------------------
DROP TABLE IF EXISTS `salary`;
CREATE TABLE `salary`  (
  `engineer_id` int(11) NOT NULL,
  `engineer_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `engineer_salary` decimal(10, 2) NULL DEFAULT NULL,
  `engineer_workday` int(2) NULL DEFAULT NULL,
  `engineer_kpi` decimal(10, 0) NULL DEFAULT NULL,
  `engineer_seniority` int(2) NULL DEFAULT NULL,
  `engineer_insurance` decimal(10, 0) NULL DEFAULT NULL,
  `engineer_finalsalary` decimal(10, 2) NULL DEFAULT NULL,
  PRIMARY KEY (`engineer_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of salary
-- ----------------------------
INSERT INTO `salary` VALUES (15, '张三', 2345.00, NULL, NULL, 2, NULL, 2110.50);
INSERT INTO `salary` VALUES (16, '李四', 3246.00, NULL, NULL, 3, NULL, 2921.40);
INSERT INTO `salary` VALUES (17, '王五', 1268.00, 28, 1500, 1, 20, 1386.70);
INSERT INTO `salary` VALUES (18, '小明', 2367.00, NULL, NULL, 3, NULL, 2130.30);
INSERT INTO `salary` VALUES (19, '123', 40.00, NULL, NULL, 2, NULL, 36.00);

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
INSERT INTO `user1` VALUES (3, '潘歆韵', '123456', 1);
INSERT INTO `user1` VALUES (4, '程建皓', '123456', 1);
INSERT INTO `user1` VALUES (5, '李娜', '123456', 1);
INSERT INTO `user1` VALUES (6, '左心如', '123456', 1);
INSERT INTO `user1` VALUES (8, '翟思明', '123456', 1);

-- ----------------------------
-- Triggers structure for table engineer
-- ----------------------------
DROP TRIGGER IF EXISTS `trigger3`;
delimiter ;;
CREATE TRIGGER `trigger3` AFTER UPDATE ON `engineer` FOR EACH ROW BEGIN
IF @disable_trigger IS NULL THEN
SET @disable_trigger = 1;
UPDATE `salary` 
SET  `engineer_id`=new.`engineer_id`,`engineer_name`=new.`engineer_name`,`engineer_salary`=new.`engineer_salary`,`engineer_seniority`=new.`engineer_seniority`,`engineer_finalsalary`=new.`engineer_finalsalary`
WHERE `engineer_id`=new.`engineer_id`;
SET @disable_trigger = NULL;
END IF;
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
DROP TRIGGER IF EXISTS `trigger1`;
delimiter ;;
CREATE TRIGGER `trigger1` AFTER INSERT ON `engineer` FOR EACH ROW BEGIN

INSERT INTO `salary`(`engineer_id`,`engineer_name`,`engineer_salary`,`engineer_seniority`,`engineer_finalsalary`) VALUES (new.`engineer_id`,new.`engineer_name`,new.`engineer_salary`,new.`engineer_seniority`,new.`engineer_finalsalary`);
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
SET  `engineer_id`=new.`engineer_id`,`engineer_name`=new.`engineer_name`,`engineer_salary`=new.`engineer_salary`,`engineer_seniority`=new.`engineer_seniority`,`engineer_finalsalary`=new.`engineer_finalsalary`
WHERE `engineer_id`=new.`engineer_id`;
SET @disable_trigger = NULL;
END IF;
END
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
