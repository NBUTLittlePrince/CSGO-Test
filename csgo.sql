/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50734
Source Host           : localhost:3306
Source Database       : 

Target Server Type    : MYSQL
Target Server Version : 50734
File Encoding         : 65001

Date: 2021-06-04 12:35:44
*/
USE csgo;
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(40) DEFAULT NULL,
  `password` varchar(40) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', '洪凯儿子', '123', '0');
INSERT INTO `admin` VALUES ('4', '周灿', '123', '1');

-- ----------------------------
-- Table structure for dagger
-- ----------------------------
DROP TABLE IF EXISTS `dagger`;
CREATE TABLE `dagger` (
  `daggerid` int(11) NOT NULL,
  `daggername` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`daggerid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dagger
-- ----------------------------
INSERT INTO `dagger` VALUES ('1', '折叠刀');
INSERT INTO `dagger` VALUES ('2', '蝴蝶刀');
INSERT INTO `dagger` VALUES ('3', '刺刀');
INSERT INTO `dagger` VALUES ('4', '爪子刀');

-- ----------------------------
-- Table structure for deal
-- ----------------------------
DROP TABLE IF EXISTS `deal`;
CREATE TABLE `deal` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `weaponid` int(20) DEFAULT NULL,
  `total` float DEFAULT NULL,
  `userid` int(11) DEFAULT NULL,
  `createdate` datetime DEFAULT NULL,
  `ispay` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `weapon` (`weaponid`),
  KEY `user` (`userid`),
  CONSTRAINT `user` FOREIGN KEY (`userid`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `weapon` FOREIGN KEY (`weaponid`) REFERENCES `weapon` (`WeaponId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of deal
-- ----------------------------
INSERT INTO `deal` VALUES ('1', '1', '66200', '1', '2021-06-01 16:48:16', '1');
INSERT INTO `deal` VALUES ('2', '1', '66200', '12', '2021-06-03 13:18:27', '1');
INSERT INTO `deal` VALUES ('3', '1', '200', '12', '2021-06-03 13:18:40', '1');
INSERT INTO `deal` VALUES ('4', '1', '66200', '12', '2021-06-03 13:20:27', '1');

-- ----------------------------
-- Table structure for heavyweapon
-- ----------------------------
DROP TABLE IF EXISTS `heavyweapon`;
CREATE TABLE `heavyweapon` (
  `heavyweaponid` int(11) NOT NULL,
  `heavyweaponname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`heavyweaponid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of heavyweapon
-- ----------------------------
INSERT INTO `heavyweapon` VALUES ('1', '内格夫');
INSERT INTO `heavyweapon` VALUES ('2', '新星');
INSERT INTO `heavyweapon` VALUES ('3', 'MAG-7');
INSERT INTO `heavyweapon` VALUES ('4', 'XM1014');
INSERT INTO `heavyweapon` VALUES ('5', 'M249');

-- ----------------------------
-- Table structure for moenycharge
-- ----------------------------
DROP TABLE IF EXISTS `moenycharge`;
CREATE TABLE `moenycharge` (
  `chargeid` varchar(255) NOT NULL,
  `money` int(11) DEFAULT NULL,
  `ischecked` int(11) DEFAULT NULL,
  PRIMARY KEY (`chargeid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of moenycharge
-- ----------------------------
INSERT INTO `moenycharge` VALUES ('1234', '1000', '1');

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `createDate` datetime DEFAULT NULL,
  `author` int(11) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of notice
-- ----------------------------
INSERT INTO `notice` VALUES ('1', '2021-05-23 12:01:45', '1', '洪凯是我儿');
INSERT INTO `notice` VALUES ('5', '2021-05-23 04:18:05', '1', '阿达');
INSERT INTO `notice` VALUES ('6', '2021-05-25 12:50:07', '1', '大虎是我儿');
INSERT INTO `notice` VALUES ('7', '2021-05-25 14:48:07', '1', '傅煜是我儿');

-- ----------------------------
-- Table structure for pistol
-- ----------------------------
DROP TABLE IF EXISTS `pistol`;
CREATE TABLE `pistol` (
  `pistolid` int(11) NOT NULL,
  `pistolname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`pistolid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pistol
-- ----------------------------
INSERT INTO `pistol` VALUES ('1', '格洛克');
INSERT INTO `pistol` VALUES ('2', 'P2000');
INSERT INTO `pistol` VALUES ('3', 'USP');
INSERT INTO `pistol` VALUES ('4', 'P250');
INSERT INTO `pistol` VALUES ('5', '沙漠之鹰');

-- ----------------------------
-- Table structure for rifle
-- ----------------------------
DROP TABLE IF EXISTS `rifle`;
CREATE TABLE `rifle` (
  `rifleid` int(11) NOT NULL,
  `riflename` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`rifleid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rifle
-- ----------------------------
INSERT INTO `rifle` VALUES ('1', 'AK-47');
INSERT INTO `rifle` VALUES ('2', 'M4A1');
INSERT INTO `rifle` VALUES ('3', '加索尔AR');
INSERT INTO `rifle` VALUES ('4', 'AUG');
INSERT INTO `rifle` VALUES ('5', 'AWP');
INSERT INTO `rifle` VALUES ('6', 'SCAR-20');
INSERT INTO `rifle` VALUES ('7', 'SG-553');

-- ----------------------------
-- Table structure for subgun
-- ----------------------------
DROP TABLE IF EXISTS `subgun`;
CREATE TABLE `subgun` (
  `subgunid` int(11) NOT NULL,
  `subgunname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`subgunid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of subgun
-- ----------------------------
INSERT INTO `subgun` VALUES ('1', 'MAC-10');
INSERT INTO `subgun` VALUES ('2', 'MP7');
INSERT INTO `subgun` VALUES ('3', 'PP-野牛');
INSERT INTO `subgun` VALUES ('4', 'P90');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `account` float DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '洪凯小儿', '1', '1@qq.com', '123');
INSERT INTO `user` VALUES ('2', '垃圾傅煜', '123', '2@qq.com', '2');
INSERT INTO `user` VALUES ('3', '鸟人黄宇洋', '213', '3@qq.com', '3');
INSERT INTO `user` VALUES ('12', 'dhj', '123', '123', '1000');

-- ----------------------------
-- Table structure for weapon
-- ----------------------------
DROP TABLE IF EXISTS `weapon`;
CREATE TABLE `weapon` (
  `WeaponId` int(20) NOT NULL AUTO_INCREMENT,
  `WeaponName` varchar(60) NOT NULL,
  `WeaponPrice` double(10,2) NOT NULL,
  `WeaponStore` int(11) unsigned zerofill DEFAULT NULL,
  `WeaponFeatureId` int(11) NOT NULL,
  `WeaponQualityId` int(11) NOT NULL,
  `WeaponTypeId` int(11) NOT NULL,
  PRIMARY KEY (`WeaponId`),
  KEY `Type` (`WeaponTypeId`) USING BTREE,
  KEY `Feature` (`WeaponFeatureId`),
  KEY `Quality` (`WeaponQualityId`),
  CONSTRAINT `Feature` FOREIGN KEY (`WeaponFeatureId`) REFERENCES `weaponfeature` (`WeaponFeatureId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `Quality` FOREIGN KEY (`WeaponQualityId`) REFERENCES `weaponquality` (`WeaponQualityId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `Type` FOREIGN KEY (`WeaponTypeId`) REFERENCES `weapontype` (`WeaponTypeId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of weapon
-- ----------------------------
INSERT INTO `weapon` VALUES ('1', 'AWP', '66200.00', '00000000005', '5', '1', '4');
INSERT INTO `weapon` VALUES ('2', 'AK-47', '200.00', '00000000009', '3', '2', '2');
INSERT INTO `weapon` VALUES ('4', 'M4A1', '256.00', '00000000012', '7', '8', '4');

-- ----------------------------
-- Table structure for weaponfeature
-- ----------------------------
DROP TABLE IF EXISTS `weaponfeature`;
CREATE TABLE `weaponfeature` (
  `WeaponFeatureId` int(11) NOT NULL AUTO_INCREMENT,
  `WeaponFeatureName` varchar(40) NOT NULL,
  PRIMARY KEY (`WeaponFeatureId`),
  KEY `WeaponFeatureId` (`WeaponFeatureId`),
  KEY `WeaponFeatureName` (`WeaponFeatureName`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of weaponfeature
-- ----------------------------
INSERT INTO `weaponfeature` VALUES ('1', '二西莫夫');
INSERT INTO `weaponfeature` VALUES ('3', '异星世界');
INSERT INTO `weaponfeature` VALUES ('4', '机械工业');
INSERT INTO `weaponfeature` VALUES ('2', '浮生如梦');
INSERT INTO `weaponfeature` VALUES ('6', '渐变之色');
INSERT INTO `weaponfeature` VALUES ('7', '菠萝菠萝蜜');
INSERT INTO `weaponfeature` VALUES ('5', '血腥运动');
INSERT INTO `weaponfeature` VALUES ('8', '霓虹革命');

-- ----------------------------
-- Table structure for weaponquality
-- ----------------------------
DROP TABLE IF EXISTS `weaponquality`;
CREATE TABLE `weaponquality` (
  `WeaponQualityId` int(11) NOT NULL AUTO_INCREMENT,
  `WeaponQualityName` varchar(40) NOT NULL,
  PRIMARY KEY (`WeaponQualityId`),
  KEY `WeaponQualityId` (`WeaponQualityId`),
  KEY `WeaponQualityName` (`WeaponQualityName`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of weaponquality
-- ----------------------------
INSERT INTO `weaponquality` VALUES ('7', '保密');
INSERT INTO `weaponquality` VALUES ('2', '军规级');
INSERT INTO `weaponquality` VALUES ('1', '卓越');
INSERT INTO `weaponquality` VALUES ('4', '受限');
INSERT INTO `weaponquality` VALUES ('9', '工业级');
INSERT INTO `weaponquality` VALUES ('10', '普通');
INSERT INTO `weaponquality` VALUES ('3', '消费级');
INSERT INTO `weaponquality` VALUES ('6', '隐秘');
INSERT INTO `weaponquality` VALUES ('8', '非凡');
INSERT INTO `weaponquality` VALUES ('5', '高级');

-- ----------------------------
-- Table structure for weapontype
-- ----------------------------
DROP TABLE IF EXISTS `weapontype`;
CREATE TABLE `weapontype` (
  `WeaponTypeId` int(11) NOT NULL AUTO_INCREMENT,
  `WeaponTypeName` varchar(40) NOT NULL,
  PRIMARY KEY (`WeaponTypeId`),
  KEY `WeaponTypeName` (`WeaponTypeName`),
  KEY `WeaponTypeId` (`WeaponTypeId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of weapontype
-- ----------------------------
INSERT INTO `weapontype` VALUES ('5', '匕首');
INSERT INTO `weapontype` VALUES ('3', '微型冲锋枪');
INSERT INTO `weapontype` VALUES ('6', '手套');
INSERT INTO `weapontype` VALUES ('1', '手枪');
INSERT INTO `weapontype` VALUES ('4', '步枪');
INSERT INTO `weapontype` VALUES ('2', '重型武器');
