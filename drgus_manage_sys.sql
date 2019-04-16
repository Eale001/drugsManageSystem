/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50540
Source Host           : localhost:3306
Source Database       : drgus_manage_sys

Target Server Type    : MYSQL
Target Server Version : 50540
File Encoding         : 65001

Date: 2019-04-16 20:18:44
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for drugs_manage_drugs
-- ----------------------------
DROP TABLE IF EXISTS `drugs_manage_drugs`;
CREATE TABLE `drugs_manage_drugs` (
  `drugs_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cate_id` bigint(20) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `create_userid` bigint(20) DEFAULT NULL,
  `drugs_name` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `drugs_picture` varchar(255) DEFAULT NULL,
  `drugs_price` double DEFAULT NULL,
  `drugs_remark` varchar(255) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `update_userid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`drugs_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of drugs_manage_drugs
-- ----------------------------
INSERT INTO `drugs_manage_drugs` VALUES ('1', '3', '2019-04-16 20:06:20', '1', '阿莫西林', '2', '12', '22', null, null);
INSERT INTO `drugs_manage_drugs` VALUES ('2', '3', '2019-04-16 19:47:59', '1', '消炎药', '1', '12', '1', null, null);

-- ----------------------------
-- Table structure for drugs_manage_drug_cate
-- ----------------------------
DROP TABLE IF EXISTS `drugs_manage_drug_cate`;
CREATE TABLE `drugs_manage_drug_cate` (
  `cate_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cate_name` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `create_userid` bigint(20) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `update_userid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`cate_id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of drugs_manage_drug_cate
-- ----------------------------
INSERT INTO `drugs_manage_drug_cate` VALUES ('3', '消炎', '2019-04-16 20:01:49', '1', null, null);
INSERT INTO `drugs_manage_drug_cate` VALUES ('6', '下火', '2019-04-16 20:06:00', '1', null, null);
INSERT INTO `drugs_manage_drug_cate` VALUES ('7', '口服', '2019-04-16 19:57:55', '1', null, null);

-- ----------------------------
-- Table structure for drugs_manage_drug_delivery_info
-- ----------------------------
DROP TABLE IF EXISTS `drugs_manage_drug_delivery_info`;
CREATE TABLE `drugs_manage_drug_delivery_info` (
  `deliveryinfo_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_date` datetime DEFAULT NULL,
  `create_userid` bigint(20) DEFAULT NULL,
  `deliveryinfo_number` bigint(20) DEFAULT NULL,
  `deliveryinfo_price` double DEFAULT NULL,
  `deliveryinfo_remark` varchar(255) DEFAULT NULL,
  `drugs_id` bigint(20) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `update_userid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`deliveryinfo_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of drugs_manage_drug_delivery_info
-- ----------------------------
INSERT INTO `drugs_manage_drug_delivery_info` VALUES ('1', '2019-04-16 20:08:03', '1', '10', '12', '111', '1', null, null);
INSERT INTO `drugs_manage_drug_delivery_info` VALUES ('2', '2019-04-16 20:10:00', '1', '10', '15', null, '1', null, null);

-- ----------------------------
-- Table structure for drugs_manage_drug_incoming_info
-- ----------------------------
DROP TABLE IF EXISTS `drugs_manage_drug_incoming_info`;
CREATE TABLE `drugs_manage_drug_incoming_info` (
  `incominginfo_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_date` datetime DEFAULT NULL,
  `create_userid` bigint(20) DEFAULT NULL,
  `drugs_id` bigint(20) DEFAULT NULL,
  `incominginfo_number` bigint(20) DEFAULT NULL,
  `incominginfo_price` double DEFAULT NULL,
  `incominginfo_remark` varchar(255) DEFAULT NULL,
  `supplier_id` bigint(20) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `update_userid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`incominginfo_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of drugs_manage_drug_incoming_info
-- ----------------------------
INSERT INTO `drugs_manage_drug_incoming_info` VALUES ('1', '2019-04-16 19:42:49', '1', '1', '111', '11', '1', '1', null, null);
INSERT INTO `drugs_manage_drug_incoming_info` VALUES ('2', '2019-04-16 20:08:34', '1', '2', '110', '3.2', '11', null, null, null);

-- ----------------------------
-- Table structure for drugs_manage_drug_inventory_info
-- ----------------------------
DROP TABLE IF EXISTS `drugs_manage_drug_inventory_info`;
CREATE TABLE `drugs_manage_drug_inventory_info` (
  `inventoryinfo_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_date` datetime DEFAULT NULL,
  `create_userid` bigint(20) DEFAULT NULL,
  `drugs_id` bigint(20) DEFAULT NULL,
  `inventoryinfo_number` bigint(20) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `update_userid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`inventoryinfo_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of drugs_manage_drug_inventory_info
-- ----------------------------
INSERT INTO `drugs_manage_drug_inventory_info` VALUES ('1', '2019-04-16 19:42:49', '1', '1', '91', null, null);
INSERT INTO `drugs_manage_drug_inventory_info` VALUES ('2', '2019-04-16 20:08:34', '1', '2', '220', null, null);

-- ----------------------------
-- Table structure for drugs_manage_drug_profit_info
-- ----------------------------
DROP TABLE IF EXISTS `drugs_manage_drug_profit_info`;
CREATE TABLE `drugs_manage_drug_profit_info` (
  `profitinfo_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_date` datetime DEFAULT NULL,
  `create_userid` bigint(20) DEFAULT NULL,
  `drugs_id` bigint(20) DEFAULT NULL,
  `profitinfo_month` varchar(255) DEFAULT NULL,
  `profitinfo_purchase` double DEFAULT NULL,
  `profitinfo_return` double DEFAULT NULL,
  `profitinfo_sell` double DEFAULT NULL,
  `saleinfo_number` bigint(20) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `update_userid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`profitinfo_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of drugs_manage_drug_profit_info
-- ----------------------------

-- ----------------------------
-- Table structure for drugs_manage_drug_sale_info
-- ----------------------------
DROP TABLE IF EXISTS `drugs_manage_drug_sale_info`;
CREATE TABLE `drugs_manage_drug_sale_info` (
  `saleinfo_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `drugs_id` bigint(20) DEFAULT NULL,
  `sale_date` datetime DEFAULT NULL,
  `sale_userid` bigint(20) DEFAULT NULL,
  `saleinfo_number` bigint(20) DEFAULT NULL,
  `saleinfo_price` double DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `update_userid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`saleinfo_id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of drugs_manage_drug_sale_info
-- ----------------------------
INSERT INTO `drugs_manage_drug_sale_info` VALUES ('1', '1', '2019-04-16 20:10:00', '1', '10', '15', null, null);

-- ----------------------------
-- Table structure for drugs_manage_drug_supplier
-- ----------------------------
DROP TABLE IF EXISTS `drugs_manage_drug_supplier`;
CREATE TABLE `drugs_manage_drug_supplier` (
  `supplier_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_date` datetime DEFAULT NULL,
  `create_userid` bigint(20) DEFAULT NULL,
  `supplier_address` varchar(255) DEFAULT NULL,
  `supplier_name` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `supplier_phone` varchar(255) DEFAULT NULL,
  `supplier_remark` varchar(255) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `update_userid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`supplier_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of drugs_manage_drug_supplier
-- ----------------------------
INSERT INTO `drugs_manage_drug_supplier` VALUES ('1', '2019-04-16 20:15:47', '1', '111', '天河制药', '120', '111', null, null);

-- ----------------------------
-- Table structure for drugs_manage_menu
-- ----------------------------
DROP TABLE IF EXISTS `drugs_manage_menu`;
CREATE TABLE `drugs_manage_menu` (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `menu_grade` int(11) DEFAULT NULL,
  `menu_icon` varchar(255) DEFAULT NULL,
  `menu_name` varchar(255) CHARACTER SET utf8 NOT NULL,
  `menu_url` varchar(255) NOT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `is_show` bit(1) DEFAULT NULL,
  `sort_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`menu_id`)
) ENGINE=MyISAM AUTO_INCREMENT=28 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of drugs_manage_menu
-- ----------------------------
INSERT INTO `drugs_manage_menu` VALUES ('1', null, 'glyphicon-cog', '药品类别管理', '#', '0', '', '1');
INSERT INTO `drugs_manage_menu` VALUES ('2', null, 'glyphicon-user', '药品管理', '#', '0', '', '2');
INSERT INTO `drugs_manage_menu` VALUES ('3', null, 'glyphicon-calendar', '库存管理', '#', '0', '', '3');
INSERT INTO `drugs_manage_menu` VALUES ('4', null, 'glyphicon-plane', '销售管理', '#', '0', '', '4');
INSERT INTO `drugs_manage_menu` VALUES ('5', null, 'glyphicon-comment', '供应商管理', '#', '0', '', '6');
INSERT INTO `drugs_manage_menu` VALUES ('27', null, 'glyphicon-comment', '利润管理', '#', '0', '', '1');
INSERT INTO `drugs_manage_menu` VALUES ('6', null, 'glyphicon-comment', '用户管理', '#', '0', '', '7');
INSERT INTO `drugs_manage_menu` VALUES ('7', null, 'glyphicon-cog', '系统管理', '#', '0', '', '8');
INSERT INTO `drugs_manage_menu` VALUES ('8', null, 'glyphicon-flag', '类别列表', '/findDrugCateAll', '1', '', '1');
INSERT INTO `drugs_manage_menu` VALUES ('9', null, 'glyphicon-comment', '药品列表', '/findDrgusAll', '2', '', '1');
INSERT INTO `drugs_manage_menu` VALUES ('10', null, 'glyphicon-cog', '入库列表', '/findDrugIncomingInfoAll', '3', '', '1');
INSERT INTO `drugs_manage_menu` VALUES ('11', null, 'glyphicon-comment', '增加类别', '/findDrugCateById', '1', '', '2');
INSERT INTO `drugs_manage_menu` VALUES ('12', null, 'glyphicon-comment', '增加药品', '/findDrugsById', '2', '', '2');
INSERT INTO `drugs_manage_menu` VALUES ('13', null, 'glyphicon-comment', '出库列表', '/findDrugDeliveryInfoAll', '3', '', '2');
INSERT INTO `drugs_manage_menu` VALUES ('14', null, 'glyphicon-comment', '增加出库', '/findDrugDeliveryInfoById', '3', '', '3');
INSERT INTO `drugs_manage_menu` VALUES ('15', null, 'glyphicon-comment', '增加入库', '/findDrugIncomingInfoById', '3', '', '4');
INSERT INTO `drugs_manage_menu` VALUES ('26', null, 'glyphicon-comment', '利润查看', '#', '27', '', '5');
INSERT INTO `drugs_manage_menu` VALUES ('25', null, 'glyphicon-comment', '销售列表', '/findDrugSaleInfoAll', '4', '', '2');
INSERT INTO `drugs_manage_menu` VALUES ('16', null, 'glyphicon-comment', '增加供应商', '/findDrugSupplierById', '5', '', '1');
INSERT INTO `drugs_manage_menu` VALUES ('17', null, 'glyphicon-comment', '供应商列表', '/findDrugSupplierAll', '5', '', '2');
INSERT INTO `drugs_manage_menu` VALUES ('18', null, 'glyphicon-comment', '增加用户', '/useredit', '6', '', '1');
INSERT INTO `drugs_manage_menu` VALUES ('19', null, 'glyphicon-comment', '用户列表', '/usermanage', '6', '', '2');
INSERT INTO `drugs_manage_menu` VALUES ('20', null, 'glyphicon-comment', '菜单管理', '/testsysmenu', '7', '', '1');
INSERT INTO `drugs_manage_menu` VALUES ('21', null, 'glyphicon-comment', '角色管理', '/rolemanage', '7', '', '2');
INSERT INTO `drugs_manage_menu` VALUES ('22', null, 'glyphicon-comment', '权限管理', '#', '7', '\0', '3');
INSERT INTO `drugs_manage_menu` VALUES ('23', null, 'glyphicon-comment', '库存信息', '/findDrugInventoryInfoAll', '3', '', '5');
INSERT INTO `drugs_manage_menu` VALUES ('24', null, 'glyphicon-comment', '增加销售', '/findDrugSaleInfoById', '4', '', '1');

-- ----------------------------
-- Table structure for drugs_manage_role
-- ----------------------------
DROP TABLE IF EXISTS `drugs_manage_role`;
CREATE TABLE `drugs_manage_role` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) DEFAULT NULL,
  `role_value` int(11) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of drugs_manage_role
-- ----------------------------
INSERT INTO `drugs_manage_role` VALUES ('1', 'superAdmin', null);
INSERT INTO `drugs_manage_role` VALUES ('2', 'admin', null);
INSERT INTO `drugs_manage_role` VALUES ('3', 'user', null);

-- ----------------------------
-- Table structure for drugs_manage_role_power_list
-- ----------------------------
DROP TABLE IF EXISTS `drugs_manage_role_power_list`;
CREATE TABLE `drugs_manage_role_power_list` (
  `pk_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `is_show` bit(1) DEFAULT NULL,
  `menu_id` bigint(20) DEFAULT NULL,
  `role_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`pk_id`),
  KEY `FK3f7huc681tfl9wsuel73lod2p` (`menu_id`),
  KEY `FKdq0b9h6draiivnrcnttdjwos1` (`role_id`)
) ENGINE=MyISAM AUTO_INCREMENT=28 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of drugs_manage_role_power_list
-- ----------------------------
INSERT INTO `drugs_manage_role_power_list` VALUES ('24', '', '24', '1');
INSERT INTO `drugs_manage_role_power_list` VALUES ('23', '', '23', '1');
INSERT INTO `drugs_manage_role_power_list` VALUES ('22', '\0', '22', '1');
INSERT INTO `drugs_manage_role_power_list` VALUES ('21', '', '21', '1');
INSERT INTO `drugs_manage_role_power_list` VALUES ('20', '', '20', '1');
INSERT INTO `drugs_manage_role_power_list` VALUES ('19', '', '19', '1');
INSERT INTO `drugs_manage_role_power_list` VALUES ('18', '', '18', '1');
INSERT INTO `drugs_manage_role_power_list` VALUES ('17', '', '17', '1');
INSERT INTO `drugs_manage_role_power_list` VALUES ('16', '', '16', '1');
INSERT INTO `drugs_manage_role_power_list` VALUES ('15', '', '15', '1');
INSERT INTO `drugs_manage_role_power_list` VALUES ('14', '', '14', '1');
INSERT INTO `drugs_manage_role_power_list` VALUES ('13', '', '13', '1');
INSERT INTO `drugs_manage_role_power_list` VALUES ('12', '', '12', '1');
INSERT INTO `drugs_manage_role_power_list` VALUES ('11', '', '11', '1');
INSERT INTO `drugs_manage_role_power_list` VALUES ('10', '', '10', '1');
INSERT INTO `drugs_manage_role_power_list` VALUES ('9', '', '9', '1');
INSERT INTO `drugs_manage_role_power_list` VALUES ('8', '', '8', '1');
INSERT INTO `drugs_manage_role_power_list` VALUES ('7', '', '7', '1');
INSERT INTO `drugs_manage_role_power_list` VALUES ('6', '', '6', '1');
INSERT INTO `drugs_manage_role_power_list` VALUES ('5', '', '5', '1');
INSERT INTO `drugs_manage_role_power_list` VALUES ('4', '', '4', '1');
INSERT INTO `drugs_manage_role_power_list` VALUES ('3', '', '3', '1');
INSERT INTO `drugs_manage_role_power_list` VALUES ('2', '', '2', '1');
INSERT INTO `drugs_manage_role_power_list` VALUES ('1', '', '1', '1');
INSERT INTO `drugs_manage_role_power_list` VALUES ('25', '', '25', '1');
INSERT INTO `drugs_manage_role_power_list` VALUES ('26', '', '26', '1');
INSERT INTO `drugs_manage_role_power_list` VALUES ('27', '', '27', '1');

-- ----------------------------
-- Table structure for drugs_manage_user
-- ----------------------------
DROP TABLE IF EXISTS `drugs_manage_user`;
CREATE TABLE `drugs_manage_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `bank` varchar(255) DEFAULT NULL,
  `birth` datetime DEFAULT NULL,
  `eamil` varchar(255) DEFAULT NULL,
  `father_id` bigint(20) DEFAULT NULL,
  `hire_time` datetime DEFAULT NULL,
  `user_idcard` varchar(255) DEFAULT NULL,
  `img_path` varchar(255) DEFAULT NULL,
  `is_lock` int(11) DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  `modify_user_id` bigint(20) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `real_name` varchar(255) DEFAULT NULL,
  `salary` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `superman` bit(1) DEFAULT NULL,
  `theme_skin` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `user_tel` varchar(255) DEFAULT NULL,
  `role_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  KEY `FKkrjp24dvouh8t3unbhqgwcakf` (`role_id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of drugs_manage_user
-- ----------------------------
INSERT INTO `drugs_manage_user` VALUES ('1', '大同', 'ICBC', '2019-04-03 09:23:05', '88888888@qq.com', null, '2019-04-03 09:23:45', '456821', null, '0', null, null, '123456', null, null, null, null, null, '1', null, '1');
