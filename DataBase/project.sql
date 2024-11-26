/*
Navicat MySQL Data Transfer

Source Server         : ycf
Source Server Version : 80030
Source Host           : localhost:3306
Source Database       : project

Target Server Type    : MYSQL
Target Server Version : 80030
File Encoding         : 65001

Date: 2024-10-19 15:49:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `feedback`
-- ----------------------------
DROP TABLE IF EXISTS `feedback`;
CREATE TABLE `feedback` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `content` text,
  `score` int DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of feedback
-- ----------------------------
INSERT INTO `feedback` VALUES ('1', '12348jia', '如果你是初学者，可能会觉得这些概念有些复杂。别担心！理解教程和指南的内容只需要具备基础的 HTML 和 JavaScript 知识。即使你不是这些方面的专家，也能够跟得上。\r\n\r\n如果你是有经验的开发者，希望了解如何以最合适的方式在项目中引入 Vue，或者是对上述的这些概念感到好奇，我们在使用 Vue 的多种方式中讨论了有关它们的更多细节。\r\n\r\n无论再怎么灵活，Vue 的核心知识在所有这些用例中都是通用的。即使你现在只是一个初学者，随着你的不断成长，到未来有能力实现更复杂的项目时，这一路上获得的知识依然会适用。如果你已经是一个老手，你可以根据实际场景来选择使用 Vue 的最佳方式，在各种场景下都可以保持同样的开发效率。这就是为什么我们将 Vue 称为“渐进式框架”：它是一个可以与你共同成长、适应你不同需求的框架。', '5', '111111', '2024-07-13');
INSERT INTO `feedback` VALUES ('3', 'jaoi', 'Perfect!', '4', '452200176', '2024-07-13');
INSERT INTO `feedback` VALUES ('4', 'jaoi', '通过组合式 API，我们可以使用导入的 API 函数来描述组件逻辑。在单文件组件中，组合式 API 通常会与 <script setup> 搭配使用。这个 setup attribute 是一个标识，告诉 Vue 需要在编译时进行一些处理，让我们可以更简洁地使用组合式 API。比如，<script setup> 中的导入和顶层变量/函数都能够在模板中直接使用。', '4', '452200176', '2024-07-13');

-- ----------------------------
-- Table structure for `guiders`
-- ----------------------------
DROP TABLE IF EXISTS `guiders`;
CREATE TABLE `guiders` (
  `id` int NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `age` int DEFAULT NULL,
  `sex` varchar(50) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `work_exp` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of guiders
-- ----------------------------
INSERT INTO `guiders` VALUES ('10001', 'Qyt', '20', '男', '17882058082', '10');
INSERT INTO `guiders` VALUES ('10011', 'QQQ', '100', '男', '123456', '100');
INSERT INTO `guiders` VALUES ('10012', 'qqq', '100', '女', '1564', '20');
INSERT INTO `guiders` VALUES ('10013', 'eaa', '24', '女', '444', '12');
INSERT INTO `guiders` VALUES ('11111', 'TTTT', '50', '男', '156484727', '15');

-- ----------------------------
-- Table structure for `hotel`
-- ----------------------------
DROP TABLE IF EXISTS `hotel`;
CREATE TABLE `hotel` (
  `id` int NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `capacity` int DEFAULT NULL,
  `level` int DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of hotel
-- ----------------------------
INSERT INTO `hotel` VALUES ('105', '如家酒店', '600', '2', '6599446454', 'rujia@rujia.com');
INSERT INTO `hotel` VALUES ('121', '万家酒店', '500', '3', '123456789', '46659@hotmail.com');
INSERT INTO `hotel` VALUES ('222', '华尔道夫酒店', '700', '5', '123556894', '123@Gmail.com');

-- ----------------------------
-- Table structure for `login`
-- ----------------------------
DROP TABLE IF EXISTS `login`;
CREATE TABLE `login` (
  `username` varchar(50) NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of login
-- ----------------------------
INSERT INTO `login` VALUES ('admin', '123456');
INSERT INTO `login` VALUES ('jgy', '111111');
INSERT INTO `login` VALUES ('qyt', '152466');
INSERT INTO `login` VALUES ('ycf', '123');

-- ----------------------------
-- Table structure for `parking`
-- ----------------------------
DROP TABLE IF EXISTS `parking`;
CREATE TABLE `parking` (
  `id` int NOT NULL AUTO_INCREMENT,
  `parking_time` datetime DEFAULT NULL,
  `car_num` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `leave_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of parking
-- ----------------------------
INSERT INTO `parking` VALUES ('2', '2024-07-13 10:59:03', '32WF3', '2024-07-13 11:02:31');
INSERT INTO `parking` VALUES ('4', '2024-07-13 11:02:07', '55T1R', '2024-07-13 11:02:18');
INSERT INTO `parking` VALUES ('5', '2024-07-13 16:16:20', '77122', '2024-07-13 16:17:47');
INSERT INTO `parking` VALUES ('7', '2024-07-13 16:21:33', '82HJQ', '2024-07-13 16:22:00');

-- ----------------------------
-- Table structure for `tourist_attraction`
-- ----------------------------
DROP TABLE IF EXISTS `tourist_attraction`;
CREATE TABLE `tourist_attraction` (
  `id` int NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `maxParking` int DEFAULT NULL,
  `maxPeople` int DEFAULT NULL,
  `manager` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `managerPhone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tourist_attraction
-- ----------------------------
INSERT INTO `tourist_attraction` VALUES ('2', 'Choi Sze Kwan', '9 3-803 Kusunokiajima, Kita Ward', '968', '174', 'Xiaoming', '124768464');
INSERT INTO `tourist_attraction` VALUES ('3', 'Kondo Ayano', '779 Cyril St, Braunstone Town', '718', '395', 'Daming', '265583526');
INSERT INTO `tourist_attraction` VALUES ('4', 'He Jiehong', '402 NO.6, YuShuang Road, ChengHua Distric', '639', '86', 'Jack', '742547347');
INSERT INTO `tourist_attraction` VALUES ('5', 'Zhu Lan', '587 Yueliu Rd, Fangshan District', '800', '474', 'Mark', '214343246');
INSERT INTO `tourist_attraction` VALUES ('6', 'Feng Shihan', '5-2-10 Higashi Gotanda, Shinagawa-ku ', '304', '850', 'Amy', '742656542');
INSERT INTO `tourist_attraction` VALUES ('7', 'Xia Yunxi', '18 1-1 Honjocho, Yamatokoriyama', '703', '75', 'Lisi', '362867855');
INSERT INTO `tourist_attraction` VALUES ('8', 'Yuen Wing Suen', '286 Canal Street', '372', '306', 'Zhangsan', '995252589');
INSERT INTO `tourist_attraction` VALUES ('9', 'Harada Kaito', '7 1-1715 Sekohigashi, Moriyama Ward', '255', '808', 'Trump', '426141085');
INSERT INTO `tourist_attraction` VALUES ('10', 'Shibata Sakura', '367 Riverview Road', '800', '800', 'Marry', '192253679');

-- ----------------------------
-- Table structure for `travel_agency`
-- ----------------------------
DROP TABLE IF EXISTS `travel_agency`;
CREATE TABLE `travel_agency` (
  `id` int NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `phone` int DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of travel_agency
-- ----------------------------
INSERT INTO `travel_agency` VALUES ('3', 'Valerie Castillo', '73023454', 'valeriecastillo@outlook.com', '510 Abingdon Rd, Cumnor', '2012-08-09 18:00:00');
INSERT INTO `travel_agency` VALUES ('4', 'Ethel Ferguson', '14634263', 'ethelf@hotmail.com', '624 Wall Street', '2010-12-06 05:00:00');
INSERT INTO `travel_agency` VALUES ('5', 'Takada Ikki', '92342765', 'ikkt@gmail.com', '616 Hongqiao Rd., Xu Hui District', '2011-04-23 20:00:00');
INSERT INTO `travel_agency` VALUES ('6', 'Ueda Daichi', '38425253', 'daichi6@icloud.com', '6-1-9, Miyanomori 4 Jō, Chuo Ward', '2017-04-27 12:00:00');
INSERT INTO `travel_agency` VALUES ('7', 'Jonathan Bennett', '13275477', 'bennett7@gmail.com', '1-6-8, Marunouchi, Chiyoda-ku', '2012-02-27 13:00:00');
INSERT INTO `travel_agency` VALUES ('8', 'Liu Lan', '27524238', 'liula5@icloud.com', '882 Rush Street', '2017-08-24 17:00:00');
INSERT INTO `travel_agency` VALUES ('9', 'Tang Yuning', '26724278', 'yunitang@icloud.com', '50 Tremont Road', '2007-10-20 09:00:00');
INSERT INTO `travel_agency` VALUES ('10', 'Harada Sara', '89624235', 'sara1014@yahoo.com', '725 West Houston Street', '2009-04-16 09:00:00');
