/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : localhost

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2016-07-20 10:22:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tb_bear_per`
-- ----------------------------
DROP TABLE IF EXISTS `tb_bear_per`;
CREATE TABLE `tb_bear_per` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `roleId` int(11) DEFAULT NULL,
  `permissinId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_bear_per
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_bill`
-- ----------------------------
DROP TABLE IF EXISTS `tb_bill`;
CREATE TABLE `tb_bill` (
  `id` int(11) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `createDate` date DEFAULT NULL,
  `payDate` varchar(20) DEFAULT NULL,
  `goodsName` varchar(50) DEFAULT NULL,
  `payType` int(11) DEFAULT NULL,
  `money` double(11,2) DEFAULT NULL,
  `number` int(8) DEFAULT NULL,
  `goodsTpye` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_bill
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_paytype`
-- ----------------------------
DROP TABLE IF EXISTS `tb_paytype`;
CREATE TABLE `tb_paytype` (
  `id` int(11) DEFAULT NULL,
  `typeName` varchar(20) DEFAULT NULL,
  `typeCode` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_paytype
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_persmission`
-- ----------------------------
DROP TABLE IF EXISTS `tb_persmission`;
CREATE TABLE `tb_persmission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `perName` varchar(50) DEFAULT NULL,
  `perUrl` varchar(50) DEFAULT NULL,
  `fatherId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_persmission
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_role`
-- ----------------------------
DROP TABLE IF EXISTS `tb_role`;
CREATE TABLE `tb_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `roleName` varchar(50) DEFAULT NULL,
  `bearingId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_role
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_security`
-- ----------------------------
DROP TABLE IF EXISTS `tb_security`;
CREATE TABLE `tb_security` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `question` varchar(200) DEFAULT NULL,
  `answer` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_security
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_user`
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(30) DEFAULT NULL,
  `loginName` varchar(30) DEFAULT NULL,
  `passWord` varchar(20) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `sex` int(8) DEFAULT NULL,
  `roleId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1', '吴启承', 'wuqicheng', 'wqc920810', '湖北省武汉市江汉区', '1', '1');
