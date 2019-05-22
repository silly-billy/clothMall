/*
Navicat MySQL Data Transfer

Source Server         : xm
Source Server Version : 50106
Source Host           : localhost:3306
Source Database       : clothshop

Target Server Type    : MYSQL
Target Server Version : 50106
File Encoding         : 65001

Date: 2019-05-23 00:33:22
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `cart`
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart` (
  `id` int(11) NOT NULL auto_increment,
  `cart_smallpicurl` varchar(255) NOT NULL default '' COMMENT '品商小图',
  `cart_clothname` varchar(255) NOT NULL default '' COMMENT '装服名称',
  `cart_clothbrand` varchar(255) NOT NULL default '' COMMENT '装服品牌',
  `cart_clothprice` double NOT NULL default '0' COMMENT '品商价格',
  `cart_subprice` double NOT NULL default '0' COMMENT '装服总价',
  `is_delete` tinyint(4) NOT NULL default '0' COMMENT '辑逻删除位',
  `cart_userid` int(11) NOT NULL default '0' COMMENT '用户id',
  `cart_clothnum` int(11) NOT NULL default '0' COMMENT '物车购服装数',
  `cart_clothid` int(11) NOT NULL default '0' COMMENT '装服id',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cart
-- ----------------------------
INSERT INTO `cart` VALUES ('71', 'smallhot1.png', '长袖修身衣', '海澜之家', '120', '240', '1', '1', '2', '1');
INSERT INTO `cart` VALUES ('72', 'smallmale2.png', '连帽运动衫', '恒源祥', '720', '2160', '1', '1', '3', '5');
INSERT INTO `cart` VALUES ('73', 'smallhot2.png', '长袖连衣裙', '茂华', '100', '300', '1', '2', '3', '2');
INSERT INTO `cart` VALUES ('74', 'smallmale3.png', '短袖T袖', '圣醒', '78', '78', '1', '2', '1', '6');
INSERT INTO `cart` VALUES ('75', 'smallhot2.png', '长袖连衣裙', '茂华', '100', '200', '1', '1', '2', '2');
INSERT INTO `cart` VALUES ('76', 'smallhot1.png', '长袖修身衣', '海澜之家', '120', '360', '1', '1', '3', '1');
INSERT INTO `cart` VALUES ('77', 'smallhot2.png', '长袖连衣裙', '茂华', '100', '300', '1', '1', '3', '2');
INSERT INTO `cart` VALUES ('78', 'smallhot2.png', '长袖连衣裙', '茂华', '100', '300', '1', '1', '3', '2');
INSERT INTO `cart` VALUES ('79', 'smallhot3.png', '印花百褶裙', '圣醒', '200', '400', '1', '1', '2', '3');
INSERT INTO `cart` VALUES ('80', 'smallhot2.png', '长袖连衣裙', '茂华', '100', '200', '1', '1', '2', '2');
INSERT INTO `cart` VALUES ('81', 'smallhot1.png', '长袖修身衣', '海澜之家', '120', '120', '1', '1', '1', '1');
INSERT INTO `cart` VALUES ('82', 'smallhot3.png', '印花百褶裙', '圣醒', '200', '200', '1', '1', '1', '3');
INSERT INTO `cart` VALUES ('83', 'smallmale2.png', '连帽运动衫', '恒源祥', '720', '1440', '1', '1', '2', '5');
INSERT INTO `cart` VALUES ('84', 'smallmale2.png', '连帽运动衫', '恒源祥', '720', '1440', '1', '1', '2', '5');
INSERT INTO `cart` VALUES ('85', 'smallmale2.png', '连帽运动衫', '恒源祥', '720', '1440', '1', '1', '2', '5');
INSERT INTO `cart` VALUES ('86', 'smallmale2.png', '连帽运动衫', '恒源祥', '720', '4320', '1', '1', '6', '5');
INSERT INTO `cart` VALUES ('87', 'smallmale2.png', '连帽运动衫', '恒源祥', '720', '64080', '1', '1', '89', '5');
INSERT INTO `cart` VALUES ('88', 'smallmale2.png', '连帽运动衫', '恒源祥', '720', '720', '1', '2', '1', '5');
INSERT INTO `cart` VALUES ('89', 'smallmale2.png', '连帽运动衫', '恒源祥', '720', '71280', '1', '1', '99', '5');
INSERT INTO `cart` VALUES ('90', 'smallmale2.png', '连帽运动衫', '恒源祥', '720', '13680', '1', '1', '19', '5');
INSERT INTO `cart` VALUES ('91', 'smallhot1.png', '长袖修身衣', '海澜之家', '120', '120', '1', '1', '1', '1');
INSERT INTO `cart` VALUES ('92', 'smallmale2.png', '连帽运动衫', '恒源祥', '720', '720', '1', '1', '1', '5');
INSERT INTO `cart` VALUES ('93', 'smallmale2.png', '连帽运动衫', '恒源祥', '720', '720', '1', '1', '1', '5');
INSERT INTO `cart` VALUES ('94', 'smallmale2.png', '连帽运动衫', '恒源祥', '720', '720', '1', '2', '1', '5');
INSERT INTO `cart` VALUES ('95', 'smallmale2.png', '连帽运动衫', '恒源祥', '720', '720', '1', '1', '1', '5');
INSERT INTO `cart` VALUES ('96', 'smallmale2.png', '连帽运动衫', '恒源祥', '720', '3600', '1', '1', '5', '5');
INSERT INTO `cart` VALUES ('97', 'smallmale2.png', '连帽运动衫', '恒源祥', '720', '720', '1', '1', '1', '5');
INSERT INTO `cart` VALUES ('98', 'smallmale2.png', '连帽运动衫', '恒源祥', '720', '5040', '1', '1', '7', '5');
INSERT INTO `cart` VALUES ('99', 'smallmale2.png', '连帽运动衫', '恒源祥', '720', '46080', '1', '1', '64', '5');
INSERT INTO `cart` VALUES ('100', 'smallhot3.png', '印花百褶裙', '圣醒', '200', '200', '1', '1', '1', '3');
INSERT INTO `cart` VALUES ('101', 'smallhot2.png', '长袖连衣裙', '茂华', '100', '200', '1', '2', '2', '2');
INSERT INTO `cart` VALUES ('102', 'smallhot1.png', '长袖修身衣', '海澜之家', '120', '480', '1', '1', '4', '1');
INSERT INTO `cart` VALUES ('103', 'smallhot1.png', '长袖修身衣', '海澜之家', '120', '240', '1', '1', '2', '1');
INSERT INTO `cart` VALUES ('104', 'smallhot3.png', '印花百褶裙', '圣醒', '200', '2000', '1', '1', '10', '3');
INSERT INTO `cart` VALUES ('105', 'smallhot3.png', '印花百褶裙', '圣醒', '200', '59600', '1', '1', '298', '3');
INSERT INTO `cart` VALUES ('106', 'smallhot2.png', '长袖连衣裙', '茂华', '100', '300', '1', '1', '3', '2');
INSERT INTO `cart` VALUES ('107', 'smallhot3.png', '印花百褶裙', '圣醒', '200', '4000', '0', '2', '20', '3');
INSERT INTO `cart` VALUES ('108', 'smallmale2.png', '连帽运动衫', '恒源祥', '720', '1440', '0', '2', '2', '5');
INSERT INTO `cart` VALUES ('109', 'smallmale1.png', 'T袖衫', '何遇', '860', '2580', '0', '2', '3', '4');
INSERT INTO `cart` VALUES ('110', 'smallmale6.png', '棉质混纺夹克', '巴宝莉', '3408', '20448', '0', '2', '6', '9');
INSERT INTO `cart` VALUES ('111', 'smallhot3.png', '印花百褶裙', '圣醒', '200', '400', '1', '3', '2', '3');
INSERT INTO `cart` VALUES ('112', 'smallmale6.png', '棉质混纺夹克', '巴宝莉', '3408', '68160', '1', '5', '20', '9');
INSERT INTO `cart` VALUES ('113', 'smallmale3.png', '短袖T袖', '圣醒', '78', '156', '1', '5', '2', '6');
INSERT INTO `cart` VALUES ('114', 'smallchild6.png', '针织长裤', 'BULLBEAN', '171', '513', '1', '1', '3', '18');

-- ----------------------------
-- Table structure for `cloth`
-- ----------------------------
DROP TABLE IF EXISTS `cloth`;
CREATE TABLE `cloth` (
  `id` int(11) NOT NULL auto_increment,
  `cloth_sex` tinyint(4) NOT NULL default '0' COMMENT '男士-0\r\n女士-1\r\n儿童-2',
  `cloth_brand` varchar(255) NOT NULL default '' COMMENT '衣服品牌',
  `cloth_size` varchar(255) NOT NULL default '' COMMENT '衣服尺码：XXL XL L ',
  `cloth_color` varchar(255) NOT NULL default '' COMMENT '衣服颜色',
  `cloth_price` double(255,0) NOT NULL default '0' COMMENT '衣服价格',
  `cloth_picurl` varchar(255) NOT NULL default '' COMMENT '衣服图片url地址',
  `cloth_name` varchar(255) NOT NULL default '' COMMENT '衣服名称',
  `cloth_stock` int(11) NOT NULL default '0' COMMENT '库存',
  `cloth_sellamount` int(11) NOT NULL default '0' COMMENT '已售量',
  `cloth_ishotsell` tinyint(4) NOT NULL default '0' COMMENT '判断是否热卖 0不是 1是',
  `is_delete` varchar(255) NOT NULL default '0' COMMENT '逻辑删除标志',
  `cloth_bigpicurl` varchar(255) NOT NULL default '' COMMENT '大图地址',
  `cloth_smallpicurl` varchar(255) NOT NULL default '' COMMENT '小图',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cloth
-- ----------------------------
INSERT INTO `cloth` VALUES ('1', '1', '海澜之家', '0', '蓝色', '120', 'hot1.png', '长袖修身衣', '991', '7', '1', '0', 'bighot1.png', 'smallhot1.png');
INSERT INTO `cloth` VALUES ('2', '1', '茂华', '1', '红色', '100', 'hot2.png', '长袖连衣裙', '882', '2', '1', '0', 'bighot2.png', 'smallhot2.png');
INSERT INTO `cloth` VALUES ('3', '1', '圣醒', '2', '紫色', '200', 'hot3.png', '印花百褶裙', '667', '314', '1', '0', 'bighot3.png', 'smallhot3.png');
INSERT INTO `cloth` VALUES ('4', '0', '何遇', '0', '白色', '860', 'male1.png', 'T袖衫', '117', '0', '1', '0', 'bigmale1.png', 'smallmale1.png');
INSERT INTO `cloth` VALUES ('5', '0', '恒源祥', '1', '黑色', '720', 'male2.png', '连帽运动衫', '98', '299', '1', '0', 'bigmale2.png', 'smallmale2.png');
INSERT INTO `cloth` VALUES ('6', '0', '圣醒', '1', '灰色', '78', 'male3.png', '短袖T袖', '137', '2', '1', '0', 'bigmale3.png', 'smallmale3.png');
INSERT INTO `cloth` VALUES ('7', '0', '圣醒', '2', '蓝色', '88', 'male4.png', '圆领T袖', '200', '0', '1', '0', 'bigmale4.png', 'smallmale4.png');
INSERT INTO `cloth` VALUES ('8', '0', '冠军', '0', '黄色', '318', 'male5.png', 'LifeT袖系列', '340', '0', '1', '0', 'bigmale5.png', 'smallmale5.png');
INSERT INTO `cloth` VALUES ('9', '0', '巴宝莉', '1', '黑色', '3408', 'male6.png', '棉质混纺夹克', '640', '20', '1', '0', 'bigmale6.png', 'smallmale6.png');
INSERT INTO `cloth` VALUES ('10', '1', '茂华', '1', '印花彩色', '268', 'female1.png', '仿麻连衣裙', '888', '0', '1', '0', 'bigfemale1.png', 'smallfemale1.png');
INSERT INTO `cloth` VALUES ('11', '1', '圣醒', '2', '白色', '158', 'female2.jpg', '碎花仙女裙', '776', '0', '1', '0', 'bigfemale2.jpg', 'smallfemale2.jpg');
INSERT INTO `cloth` VALUES ('12', '1', '轩品媛', '2', '深蓝', '288', 'female3.jpg', '长袖长裙', '4646', '0', '1', '0', 'bigfemale3.jpg', 'smallfemale3.jpg');
INSERT INTO `cloth` VALUES ('13', '2', '潘纳托妮', '2', '迷你彩色', '169', 'child1.png', '迷你休闲衣', '221', '0', '1', '0', 'bigchild1.png', 'smallchild1.png');
INSERT INTO `cloth` VALUES ('14', '2', '潘纳托妮', '2', '深蓝', '169', 'child2.png', '牛仔套装童装', '324', '0', '1', '0', 'bigchild2.png', 'smallchild2.png');
INSERT INTO `cloth` VALUES ('15', '2', 'KEEDZ', '2', '绿色', '60', 'child3.png', '童装基本款长袖T袖', '245', '0', '1', '0', 'bigchild3.png', 'smallchild3.png');
INSERT INTO `cloth` VALUES ('16', '2', 'KEEDZ', '2', '蓝绿色', '148', 'child4.png', '蝴蝶结背心女童连衣裙', '354', '0', '1', '0', 'bigchild4.png', 'smallchild4.png');
INSERT INTO `cloth` VALUES ('17', '2', 'BULLBEAN', '2', '卡其色', '331', 'child5.png', '长裤', '343', '0', '1', '0', 'bigchild5.png', 'smallchild5.png');
INSERT INTO `cloth` VALUES ('18', '2', 'BULLBEAN', '2', '深麻灰', '171', 'child6.png', '针织长裤', '2432', '0', '1', '0', 'bigchild6.png', 'smallchild6.png');
INSERT INTO `cloth` VALUES ('19', '0', '阿迪达斯', '3', '黑色', '638', 'male7.png', '跑步鞋', '3435', '0', '1', '0', 'bigmale7.png', 'smallmale7.png');
INSERT INTO `cloth` VALUES ('20', '0', '伦敦保罗', '4', '黄色', '99', 'male8.png', '休闲时尚男鞋', '875', '0', '1', '0', 'bigmale8.png', 'smallmale8.png');
INSERT INTO `cloth` VALUES ('21', '0', '康龙男鞋', '5', '黑/黄色', '359', 'male9.png', '运动板鞋', '243', '0', '1', '0', 'bigmale9.png', 'smallmale9.png');
INSERT INTO `cloth` VALUES ('22', '1', '圣醒', '1', '黑色', '148', 'female4.png', '休闲皮鞋', '246', '0', '1', '0', 'bigfemale4.png', 'smallfemale4.png');
INSERT INTO `cloth` VALUES ('23', '1', '圣醒', '0', '白色', '78', 'female5.png', '皮面小白鞋', '701', '0', '1', '0', 'bigfemale5.png', 'smallfemale5.png');
INSERT INTO `cloth` VALUES ('24', '1', '阿迪达斯', '1', '白色', '368', 'female6.png', 'RUNFALCON 跑步鞋', '356', '0', '1', '0', 'bigfemale6.png', 'smallfemale6.png');

-- ----------------------------
-- Table structure for `orderitem`
-- ----------------------------
DROP TABLE IF EXISTS `orderitem`;
CREATE TABLE `orderitem` (
  `id` int(11) NOT NULL auto_increment,
  `order_id` int(11) NOT NULL default '0' COMMENT '订单id',
  `orderitem_status` varchar(255) NOT NULL default '' COMMENT '订单运输状态',
  `is_delete` varchar(255) NOT NULL default '0' COMMENT '逻辑删除',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orderitem
-- ----------------------------

-- ----------------------------
-- Table structure for `orders`
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `id` int(11) NOT NULL auto_increment,
  `order_itemstatus` tinyint(4) NOT NULL default '0' COMMENT '单订状态 0-已付款  1-已发货 2-待确认 3-已完成 4-已取消',
  `order_userid` int(11) NOT NULL default '0' COMMENT '用户id',
  `order_clothid` int(11) NOT NULL default '0' COMMENT '装服id',
  `order_num` varchar(20) NOT NULL default '0' COMMENT '订单编号',
  `order_cartid` int(11) NOT NULL default '0' COMMENT '购物车id',
  `is_delete` tinyint(4) NOT NULL default '0' COMMENT '逻辑删除位',
  `order_curtime` varchar(255) NOT NULL default '' COMMENT '下单时间',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('1', '2', '1', '3', '1558334694399', '79', '0', '2019-05-20 14:44:54');
INSERT INTO `orders` VALUES ('2', '4', '1', '3', '1558334710903', '82', '0', '2019-05-20 14:45:10');
INSERT INTO `orders` VALUES ('3', '3', '1', '5', '1558334798990', '83', '0', '2019-05-20 14:46:38');
INSERT INTO `orders` VALUES ('4', '1', '1', '5', '1558334831537', '84', '0', '2019-05-20 14:47:11');
INSERT INTO `orders` VALUES ('5', '1', '1', '5', '1558334896758', '85', '0', '2019-05-20 14:48:16');
INSERT INTO `orders` VALUES ('6', '0', '1', '5', '1558334913478', '86', '0', '2019-05-20 14:48:33');
INSERT INTO `orders` VALUES ('7', '0', '1', '5', '1558335115219', '87', '0', '2019-05-20 14:51:55');
INSERT INTO `orders` VALUES ('8', '1', '2', '5', '1558335138545', '88', '0', '2019-05-20 14:52:18');
INSERT INTO `orders` VALUES ('9', '0', '2', '5', '1558340947286', '94', '0', '2019-05-20 16:29:07');
INSERT INTO `orders` VALUES ('10', '0', '2', '2', '1558340956946', '101', '0', '2019-05-20 16:29:16');
INSERT INTO `orders` VALUES ('11', '1', '1', '1', '1558363589417', '103', '0', '2019-05-20 22:46:29');
INSERT INTO `orders` VALUES ('12', '0', '1', '3', '1558363669529', '104', '0', '2019-05-20 22:47:49');
INSERT INTO `orders` VALUES ('13', '0', '1', '3', '1558363839439', '105', '0', '2019-05-20 22:50:39');
INSERT INTO `orders` VALUES ('14', '0', '1', '3', '1558450665123', '100', '0', '2019-05-21 22:57:45');
INSERT INTO `orders` VALUES ('15', '1', '3', '3', '1558506799540', '111', '0', '2019-05-22 14:33:19');
INSERT INTO `orders` VALUES ('16', '1', '5', '9', '1558507549999', '112', '0', '2019-05-22 14:45:49');
INSERT INTO `orders` VALUES ('17', '0', '5', '6', '1558509719948', '113', '0', '2019-05-22 15:21:59');

-- ----------------------------
-- Table structure for `superuser`
-- ----------------------------
DROP TABLE IF EXISTS `superuser`;
CREATE TABLE `superuser` (
  `id` int(11) NOT NULL auto_increment,
  `super_name` varchar(255) NOT NULL default '' COMMENT '级超管理员姓名',
  `super_password` varchar(255) NOT NULL default '' COMMENT '级超管理员密码',
  `is_delete` tinyint(4) NOT NULL default '0' COMMENT '逻辑删除位 0-未删除 1-已删除',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of superuser
-- ----------------------------
INSERT INTO `superuser` VALUES ('1', 'admin', 'admin', '0');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL auto_increment,
  `user_name` varchar(255) NOT NULL default '' COMMENT '用户姓名',
  `user_password` varchar(255) NOT NULL default '' COMMENT '用户密码',
  `user_sex` varchar(255) NOT NULL default '' COMMENT '用户性别',
  `user_balance` double(255,0) NOT NULL default '0' COMMENT '用户余额',
  `user_address` varchar(255) NOT NULL default '' COMMENT '用户收货地址',
  `is_delete` varchar(255) NOT NULL default '0' COMMENT '逻辑删除',
  `user_phone` varchar(255) NOT NULL default '' COMMENT '用户号码',
  `user_invest` double NOT NULL default '0' COMMENT '用户历史充值金额',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'xm', '123', '0', '58583', '江苏武进区常州大学', '0', '18262997081', '3523456');
INSERT INTO `user` VALUES ('2', 'test', '123', '1', '2982', '陕西王益区111', '0', '18262997081', '63636');
INSERT INTO `user` VALUES ('3', 'test2', '123', '0', '2663', '广西永福县123', '0', '18262997081', '45747');
INSERT INTO `user` VALUES ('4', 'test3', '123', '1', '0', '', '0', '18262887651', '0');
INSERT INTO `user` VALUES ('5', 'test4', '123', '0', '1787', '湖南湘潭县134', '0', '18765443765', '70103');
