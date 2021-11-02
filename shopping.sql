/*
Navicat MySQL Data Transfer

Source Server         : qingbao
Source Server Version : 50528
Source Host           : 127.0.0.1:3306
Source Database       : shopping

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2021-11-02 18:14:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `goodsId` int(11) NOT NULL,
  `goodsName` varchar(255) DEFAULT NULL,
  `goodsIntro` varchar(255) DEFAULT NULL,
  `goodsPrice` float(10,2) DEFAULT NULL,
  `goodsNum` int(11) DEFAULT NULL,
  `publisher` varchar(255) DEFAULT NULL,
  `photo` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('1', '1', 'nice1', '1.00', '1', '江苏', '01.jpg', '1');
INSERT INTO `goods` VALUES ('2', '2', 'nice2', '2.00', '2', '2', '02.jpg', '2');
INSERT INTO `goods` VALUES ('3', '3', 'nice3', '3.00', '3', '3', '03.jpg', '3');
INSERT INTO `goods` VALUES ('4', '4', 'nice4', '4.00', '4', '4', '04.jpg', '4');
INSERT INTO `goods` VALUES ('5', '5', 'good1', '5.00', '5', '5', '05.jpg', '5');
INSERT INTO `goods` VALUES ('6', '6', 'good2', '6.00', '6', '6', '01.jpg', '6');
INSERT INTO `goods` VALUES ('7', '7', 'good3', '7.00', '7', '7', '02.jpg', '7');
INSERT INTO `goods` VALUES ('8', '8', 'good4', '8.00', '8', '8', '01.jpg', '8');
INSERT INTO `goods` VALUES ('9', '9', 'well1', '9.00', '9', '9', '02.jpg', '9');
INSERT INTO `goods` VALUES ('10', '10', 'well2', '10.00', '10', '10', '03.jpg', '10');
INSERT INTO `goods` VALUES ('11', '11', 'well3', '11.00', '11', '11', '01.jpg', '11');
INSERT INTO `goods` VALUES ('12', '12', 'well4', '12.00', '12', '12', '02.jpg', '12');
INSERT INTO `goods` VALUES ('13', '13', 'happy1', '13.00', '13', '13', '05.jpg', '13');
INSERT INTO `goods` VALUES ('14', '14', 'happy2', '14.00', '14', '14', '01.jpg', '14');
INSERT INTO `goods` VALUES ('15', '15', 'happy3', '15.00', '15', '15', '03.jpg', '15');
INSERT INTO `goods` VALUES ('16', '16', 'happy4', '16.00', '16', '16', '04.jpg', '16');

-- ----------------------------
-- Table structure for orderdetail
-- ----------------------------
DROP TABLE IF EXISTS `orderdetail`;
CREATE TABLE `orderdetail` (
  `ordersId` int(11) DEFAULT NULL,
  `goodsId` int(11) DEFAULT NULL,
  `nums` int(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orderdetail
-- ----------------------------
INSERT INTO `orderdetail` VALUES ('5', '1', '1');
INSERT INTO `orderdetail` VALUES ('5', '2', '1');
INSERT INTO `orderdetail` VALUES ('8', '4', '1');
INSERT INTO `orderdetail` VALUES ('8', '1', '1');
INSERT INTO `orderdetail` VALUES ('11', '4', '1');
INSERT INTO `orderdetail` VALUES ('16', '4', '1');
INSERT INTO `orderdetail` VALUES ('16', '4', '1');
INSERT INTO `orderdetail` VALUES ('16', '1', '1');
INSERT INTO `orderdetail` VALUES ('16', '4', '1');
INSERT INTO `orderdetail` VALUES ('16', '5', '1');
INSERT INTO `orderdetail` VALUES ('13', '4', '1');
INSERT INTO `orderdetail` VALUES ('13', '7', '1');
INSERT INTO `orderdetail` VALUES ('15', '1', '1');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `ordersId` int(11) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `orderData` varchar(255) DEFAULT NULL,
  `payMode` varchar(255) DEFAULT NULL,
  `isPayed` int(11) DEFAULT NULL,
  `totalPrice` float(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('1', '1', '2021-10-29', '1', '1', '100.00');
INSERT INTO `orders` VALUES ('2', '2', '2021-10-28', '2', '1', '100.00');
INSERT INTO `orders` VALUES ('3', '3', '2021-10-27', '3', '1', '100.00');
INSERT INTO `orders` VALUES ('4', '4', '2021-10-26', '4', '1', '100.00');
INSERT INTO `orders` VALUES ('5', '2', '2021-10-25', '4', '1', '100.00');
INSERT INTO `orders` VALUES ('6', '2', '2021-11-01', '9', '0', '3.00');
INSERT INTO `orders` VALUES ('7', '2', null, null, '0', '4.00');
INSERT INTO `orders` VALUES ('8', '2', null, null, '0', '1.00');
INSERT INTO `orders` VALUES ('9', '2', null, null, '0', '4.00');
INSERT INTO `orders` VALUES ('10', '2', null, null, '0', '4.00');
INSERT INTO `orders` VALUES ('11', '2', null, null, '0', '4.00');
INSERT INTO `orders` VALUES ('12', '2', null, null, '0', '1.00');
INSERT INTO `orders` VALUES ('13', '2', '02-11-2021 16:32:59', '0', '0', '9.00');
INSERT INTO `orders` VALUES ('14', '2', '02-11-2021 16:39:29', '0', '0', '11.00');
INSERT INTO `orders` VALUES ('15', '2', '02-11-2021 16:47:48', '0', '0', '1.00');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `userid` int(11) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `truename` varchar(255) DEFAULT NULL,
  `passwd` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `postcode` varchar(255) DEFAULT NULL,
  `grade` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', '1', '成功', '1', '1741484908@qq.com', '188801269103', '天上', '1', '1');
INSERT INTO `users` VALUES ('2', '2', '努力', '2', '2', '2', '地下', '2', '2');
INSERT INTO `users` VALUES ('3', '3', '奋斗', '3', '3', '3', '皇宫', '3', '3');
INSERT INTO `users` VALUES ('4', '4', '上进', '4', '4', '4', '殿堂', '4', '4');
INSERT INTO `users` VALUES ('5', '5', '耐心', '5', '5', '5', '宿舍', '5', '5');
