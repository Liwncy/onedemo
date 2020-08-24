/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50037
 Source Host           : localhost:3306
 Source Schema         : warehouse

 Target Server Type    : MySQL
 Target Server Version : 50037
 File Encoding         : 65001

 Date: 10/12/2019 14:14:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pid` int(11) NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `open` int(11) NULL DEFAULT NULL COMMENT '是否展开，0不展开，1展开',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `available` int(11) NULL DEFAULT NULL COMMENT '是否可用，0不可用，1可用',
  `ordernum` int(11) NULL DEFAULT NULL COMMENT '排序码',
  `createtime` datetime NULL DEFAULT NULL,
  PRIMARY KEY USING BTREE (`id`)
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_dept
-- ----------------------------
INSERT INTO `sys_dept` VALUES (1, 0, '总经办', 1, '大BOSS', '深圳', 1, 1, '2019-04-10 14:06:32');
INSERT INTO `sys_dept` VALUES (2, 1, '销售部', 0, '程序员屌丝', '武汉', 1, 2, '2019-04-10 14:06:32');
INSERT INTO `sys_dept` VALUES (3, 1, '运营部', 0, '无', '武汉', 1, 3, '2019-04-10 14:06:32');
INSERT INTO `sys_dept` VALUES (4, 1, '生产部', 0, '无', '武汉', 1, 4, '2019-04-10 14:06:32');
INSERT INTO `sys_dept` VALUES (5, 2, '销售一部', 0, '销售一部', '武汉', 1, 5, '2019-04-10 14:06:32');
INSERT INTO `sys_dept` VALUES (6, 2, '销售二部', 0, '销售二部', '武汉', 1, 6, '2019-04-10 14:06:32');
INSERT INTO `sys_dept` VALUES (7, 3, '运营一部', 0, '运营一部', '武汉', 1, 7, '2019-04-10 14:06:32');
INSERT INTO `sys_dept` VALUES (8, 2, '销售三部', 0, '销售三部', '11', 1, 8, '2019-04-10 14:06:32');
INSERT INTO `sys_dept` VALUES (9, 2, '销售四部', 0, '销售四部', '222', 1, 9, '2019-04-10 14:06:32');
INSERT INTO `sys_dept` VALUES (10, 2, '销售五部', 0, '销售五部', '33', 1, 10, '2019-04-10 14:06:32');
INSERT INTO `sys_dept` VALUES (18, 4, '生产一部', 0, '生产食品', '武汉', 1, 11, '2019-04-13 09:49:38');

-- ----------------------------
-- Table structure for sys_loginfo
-- ----------------------------
DROP TABLE IF EXISTS `sys_loginfo`;
CREATE TABLE `sys_loginfo`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `loginname` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `loginip` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `logintime` datetime NULL DEFAULT NULL,
  PRIMARY KEY USING BTREE (`id`)
) ENGINE = InnoDB AUTO_INCREMENT = 181 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_loginfo
-- ----------------------------
INSERT INTO `sys_loginfo` VALUES (11, '落亦--luoyi', '0:0:0:0:0:0:0:1', '2019-11-25 14:23:26');
INSERT INTO `sys_loginfo` VALUES (12, '落亦--luoyi', '0:0:0:0:0:0:0:1', '2019-11-25 14:27:20');
INSERT INTO `sys_loginfo` VALUES (13, '落亦--luoyi', '0:0:0:0:0:0:0:1', '2019-11-25 14:38:38');
INSERT INTO `sys_loginfo` VALUES (14, '落亦--luoyi', '0:0:0:0:0:0:0:1', '2019-11-25 14:45:25');
INSERT INTO `sys_loginfo` VALUES (15, '落亦--luoyi', '0:0:0:0:0:0:0:1', '2019-11-25 15:21:52');
INSERT INTO `sys_loginfo` VALUES (16, '落亦--luoyi', '0:0:0:0:0:0:0:1', '2019-11-25 15:23:39');
INSERT INTO `sys_loginfo` VALUES (17, '落亦--luoyi', '0:0:0:0:0:0:0:1', '2019-11-25 15:26:10');
INSERT INTO `sys_loginfo` VALUES (18, '落亦--luoyi', '127.0.0.1', '2019-11-25 15:53:00');
INSERT INTO `sys_loginfo` VALUES (19, '落亦--luoyi', '0:0:0:0:0:0:0:1', '2019-11-26 08:32:41');
INSERT INTO `sys_loginfo` VALUES (20, '落亦--luoyi', '0:0:0:0:0:0:0:1', '2019-11-26 09:18:06');
INSERT INTO `sys_loginfo` VALUES (21, '超级管理员-system', '0:0:0:0:0:0:0:1', '2019-11-26 09:59:19');

-- ----------------------------
-- Table structure for sys_notice
-- ----------------------------
DROP TABLE IF EXISTS `sys_notice`;
CREATE TABLE `sys_notice`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `content` text CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL,
  `createtime` datetime NULL DEFAULT NULL,
  `opername` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY USING BTREE (`id`)
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_notice
-- ----------------------------
INSERT INTO `sys_notice` VALUES (1, '关于系统V1.3更新公告', '2', '2018-08-07 00:00:00', '管理员');
INSERT INTO `sys_notice` VALUES (15, '111111', NULL, '2019-11-25 15:30:06', '落亦-');
INSERT INTO `sys_notice` VALUES (16, '试一下', NULL, '2019-11-25 15:32:44', '落亦-');
INSERT INTO `sys_notice` VALUES (17, '忘记写name属性了', '这回应该可以了', '2019-11-25 15:34:51', '落亦-');
INSERT INTO `sys_notice` VALUES (18, '数据表格的bug', '删除一页数据表格的所有数据，显示无数据', '2019-11-26 09:24:09', '落亦-');
INSERT INTO `sys_notice` VALUES (19, '数据表格', '当返回的数据为0时，只需将当前页减一即可', '2019-11-26 09:24:59', '落亦-');
INSERT INTO `sys_notice` VALUES (20, '还差一条', '在来一条', '2019-11-26 09:25:14', '落亦-');
INSERT INTO `sys_notice` VALUES (21, '再来一条', '来一条', '2019-11-26 09:25:30', '落亦-');
INSERT INTO `sys_notice` VALUES (22, '还有18天四级', '18天', '2019-11-26 09:25:51', '落亦-');
INSERT INTO `sys_notice` VALUES (23, 'bug搞定', 'OK了', '2019-11-26 09:26:19', '落亦-');

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pid` int(11) NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `percode` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '权限编码[只有type=permission才有 user:view]',
  `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `href` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `target` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `open` int(11) NULL DEFAULT NULL,
  `ordernum` int(11) NULL DEFAULT NULL,
  `available` int(11) NULL DEFAULT NULL COMMENT '是否可用[0不可用，1可用]',
  PRIMARY KEY USING BTREE (`id`)
) ENGINE = InnoDB AUTO_INCREMENT = 121 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES (1, 0, 'menu', '仓库管理系统', NULL, '&#xe68e;', '', '', 1, 1, 1);
INSERT INTO `sys_permission` VALUES (2, 1, 'menu', '基础管理', NULL, '&#xe857;', '', '', 0, 2, 1);
INSERT INTO `sys_permission` VALUES (3, 1, 'menu', '进货管理', NULL, '&#xe645;', '', NULL, 0, 3, 1);
INSERT INTO `sys_permission` VALUES (4, 1, 'menu', '销售管理', NULL, '&#xe611;', '', '', 0, 4, 1);
INSERT INTO `sys_permission` VALUES (5, 1, 'menu', '系统管理', NULL, '&#xe614;', '', '', 1, 5, 1);
INSERT INTO `sys_permission` VALUES (6, 1, 'menu', '其它管理', NULL, '&#xe628;', '', '', 0, 6, 1);
INSERT INTO `sys_permission` VALUES (7, 2, 'menu', '客户管理', NULL, '&#xe651;', '/bus/toCustomerManager', '', 0, 7, 1);
INSERT INTO `sys_permission` VALUES (8, 2, 'menu', '供应商管理', NULL, '&#xe658;', '/bus/toProviderManager', '', 0, 8, 1);
INSERT INTO `sys_permission` VALUES (9, 2, 'menu', '商品管理', NULL, '&#xe657;', '/bus/toGoodsManager', '', 0, 9, 1);
INSERT INTO `sys_permission` VALUES (10, 3, 'menu', '商品进货', NULL, '&#xe756;', '/bus/toInportManager', '', 0, 10, 1);
INSERT INTO `sys_permission` VALUES (11, 3, 'menu', '商品退货查询', NULL, '&#xe65a;', '/bus/toOutportManager', '', 0, 11, 1);
INSERT INTO `sys_permission` VALUES (12, 4, 'menu', '商品销售', NULL, '&#xe65b;', '', '', 0, 12, 1);
INSERT INTO `sys_permission` VALUES (13, 4, 'menu', '销售退货查询', NULL, '&#xe770;', '', '', 0, 13, 1);
INSERT INTO `sys_permission` VALUES (14, 5, 'menu', '部门管理', NULL, '&#xe770;', '/sys/toDeptManager', '', 0, 14, 1);
INSERT INTO `sys_permission` VALUES (15, 5, 'menu', '菜单管理', NULL, '&#xe857;', '/sys/toMenuManager', '', 0, 15, 1);
INSERT INTO `sys_permission` VALUES (16, 5, 'menu', '权限管理', '', '&#xe857;', '/sys/toPermissionManager', '', 0, 16, 1);
INSERT INTO `sys_permission` VALUES (17, 5, 'menu', '角色管理', '', '&#xe650;', '/sys/toRoleManager', '', 0, 17, 1);
INSERT INTO `sys_permission` VALUES (18, 5, 'menu', '用户管理', '', '&#xe612;', '/sys/toUserManager', '', 0, 18, 1);
INSERT INTO `sys_permission` VALUES (21, 6, 'menu', '登陆日志', NULL, '&#xe675;', '/sys/toLoginfoManager', '', 0, 21, 1);
INSERT INTO `sys_permission` VALUES (22, 6, 'menu', '系统公告', NULL, '&#xe756;', '/sys/toNoticeManager', NULL, 0, 22, 1);
INSERT INTO `sys_permission` VALUES (23, 6, 'menu', '图标管理', NULL, '&#xe670;', '../resources/page/icon.html', NULL, 0, 23, 1);
INSERT INTO `sys_permission` VALUES (30, 14, 'permission', '添加部门', 'dept:create', '', NULL, NULL, 0, 24, 1);
INSERT INTO `sys_permission` VALUES (31, 14, 'permission', '修改部门', 'dept:update', '', NULL, NULL, 0, 26, 1);
INSERT INTO `sys_permission` VALUES (32, 14, 'permission', '删除部门', 'dept:delete', '', NULL, NULL, 0, 27, 1);
INSERT INTO `sys_permission` VALUES (34, 15, 'permission', '添加菜单', 'menu:create', '', '', '', 0, 29, 1);
INSERT INTO `sys_permission` VALUES (35, 15, 'permission', '修改菜单', 'menu:update', '', NULL, NULL, 0, 30, 1);
INSERT INTO `sys_permission` VALUES (36, 15, 'permission', '删除菜单', 'menu:delete', '', NULL, NULL, 0, 31, 1);
INSERT INTO `sys_permission` VALUES (38, 16, 'permission', '添加权限', 'permission:create', '', NULL, NULL, 0, 33, 1);
INSERT INTO `sys_permission` VALUES (39, 16, 'permission', '修改权限', 'permission:update', '', NULL, NULL, 0, 34, 1);
INSERT INTO `sys_permission` VALUES (40, 16, 'permission', '删除权限', 'permission:delete', '', NULL, NULL, 0, 35, 1);
INSERT INTO `sys_permission` VALUES (42, 17, 'permission', '添加角色', 'role:create', '', NULL, NULL, 0, 37, 1);
INSERT INTO `sys_permission` VALUES (43, 17, 'permission', '修改角色', 'role:update', '', NULL, NULL, 0, 38, 1);
INSERT INTO `sys_permission` VALUES (44, 17, 'permission', '删除角色', 'role:delete', '', NULL, NULL, 0, 39, 1);
INSERT INTO `sys_permission` VALUES (46, 17, 'permission', '分配权限', 'role:selectPermission', '', NULL, NULL, 0, 41, 1);
INSERT INTO `sys_permission` VALUES (47, 18, 'permission', '添加用户', 'user:create', '', NULL, NULL, 0, 42, 1);
INSERT INTO `sys_permission` VALUES (48, 18, 'permission', '修改用户', 'user:update', '', NULL, NULL, 0, 43, 1);
INSERT INTO `sys_permission` VALUES (49, 18, 'permission', '删除用户', 'user:delete', '', NULL, NULL, 0, 44, 1);
INSERT INTO `sys_permission` VALUES (51, 18, 'permission', '用户分配角色', 'user:selectRole', '', NULL, NULL, 0, 46, 1);
INSERT INTO `sys_permission` VALUES (52, 18, 'permission', '重置密码', 'user:resetPwd', NULL, NULL, NULL, 0, 47, 1);
INSERT INTO `sys_permission` VALUES (53, 14, 'permission', '部门查询', 'dept:view', NULL, NULL, NULL, 0, 48, 1);
INSERT INTO `sys_permission` VALUES (54, 15, 'permission', '菜单查询', 'menu:view', NULL, NULL, NULL, 0, 49, 1);
INSERT INTO `sys_permission` VALUES (55, 16, 'permission', '权限查询', 'permission:view', NULL, NULL, NULL, 0, 50, 1);
INSERT INTO `sys_permission` VALUES (56, 17, 'permission', '角色查询', 'role:view', NULL, NULL, NULL, 0, 51, 1);
INSERT INTO `sys_permission` VALUES (57, 18, 'permission', '用户查询', 'user:view', NULL, NULL, NULL, 0, 52, 1);
INSERT INTO `sys_permission` VALUES (68, 7, 'permission', '客户查询', 'customer:view', NULL, NULL, NULL, NULL, 60, 1);
INSERT INTO `sys_permission` VALUES (69, 7, 'permission', '客户添加', 'customer:create', NULL, NULL, NULL, NULL, 61, 1);
INSERT INTO `sys_permission` VALUES (70, 7, 'permission', '客户修改', 'customer:update', NULL, NULL, NULL, NULL, 62, 1);
INSERT INTO `sys_permission` VALUES (71, 7, 'permission', '客户删除', 'customer:delete', NULL, NULL, NULL, NULL, 63, 1);
INSERT INTO `sys_permission` VALUES (73, 21, 'permission', '日志查询', 'info:view', NULL, NULL, NULL, NULL, 65, 1);
INSERT INTO `sys_permission` VALUES (74, 21, 'permission', '日志删除', 'info:delete', NULL, NULL, NULL, NULL, 66, 1);
INSERT INTO `sys_permission` VALUES (75, 21, 'permission', '日志批量删除', 'info:batchdelete', NULL, NULL, NULL, NULL, 67, 1);
INSERT INTO `sys_permission` VALUES (76, 22, 'permission', '公告查询', 'notice:view', NULL, NULL, NULL, NULL, 68, 1);
INSERT INTO `sys_permission` VALUES (77, 22, 'permission', '公告添加', 'notice:create', NULL, NULL, NULL, NULL, 69, 1);
INSERT INTO `sys_permission` VALUES (78, 22, 'permission', '公告修改', 'notice:update', NULL, NULL, NULL, NULL, 70, 1);
INSERT INTO `sys_permission` VALUES (79, 22, 'permission', '公告删除', 'notice:delete', NULL, NULL, NULL, NULL, 71, 1);
INSERT INTO `sys_permission` VALUES (81, 8, 'permission', '供应商查询', 'provider:view', NULL, NULL, NULL, NULL, 73, 1);
INSERT INTO `sys_permission` VALUES (82, 8, 'permission', '供应商添加', 'provider:create', NULL, NULL, NULL, NULL, 74, 1);
INSERT INTO `sys_permission` VALUES (83, 8, 'permission', '供应商修改', 'provider:update', NULL, NULL, NULL, NULL, 75, 1);
INSERT INTO `sys_permission` VALUES (84, 8, 'permission', '供应商删除', 'provider:delete', NULL, NULL, NULL, NULL, 76, 1);
INSERT INTO `sys_permission` VALUES (86, 22, 'permission', '公告查看', 'notice:viewnotice', NULL, NULL, NULL, NULL, 78, 1);
INSERT INTO `sys_permission` VALUES (91, 9, 'permission', '商品查询', 'goods:view', NULL, NULL, NULL, 0, 79, 1);
INSERT INTO `sys_permission` VALUES (92, 9, 'permission', '商品添加', 'goods:create', NULL, NULL, NULL, 0, 80, 1);
INSERT INTO `sys_permission` VALUES (116, 9, 'permission', '商品删除', 'goods:delete', NULL, NULL, NULL, 0, 84, 1);
INSERT INTO `sys_permission` VALUES (117, 9, 'permission', '商品修改', 'goods:update', NULL, NULL, NULL, 0, 85, 1);
INSERT INTO `sys_permission` VALUES (118, 9, 'permission', '商品查询', 'goods:view', NULL, NULL, NULL, 0, 86, 1);
INSERT INTO `sys_permission` VALUES (119, 22, 'permission', '公告批量删除', 'notice:batchdelete', NULL, NULL, NULL, 0, 87, 1);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `available` int(11) NULL DEFAULT NULL COMMENT '0不可用，1可用',
  `createtime` datetime NULL DEFAULT NULL,
  PRIMARY KEY USING BTREE (`id`)
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, '超级管理员', '拥有所有菜单权限', 1, '2019-04-10 14:06:32');
INSERT INTO `sys_role` VALUES (4, '基础数据管理员', '基础数据管理员', 1, '2019-04-10 14:06:32');
INSERT INTO `sys_role` VALUES (5, '仓库管理员', '仓库管理员', 1, '2019-04-10 14:06:32');
INSERT INTO `sys_role` VALUES (6, '销售管理员', '销售管理员', 1, '2019-04-10 14:06:32');
INSERT INTO `sys_role` VALUES (7, '系统管理员', '系统管理员', 1, '2019-04-10 14:06:32');

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission`  (
  `rid` int(11) NOT NULL DEFAULT 0,
  `pid` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY USING BTREE (`rid`, `pid`),
  INDEX `sys_role_permission_ibfk_1` USING BTREE(`pid`),
  CONSTRAINT `sys_role_permission_ibfk_1` FOREIGN KEY (`pid`) REFERENCES `sys_permission` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `sys_role_permission_ibfk_2` FOREIGN KEY (`rid`) REFERENCES `sys_role` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci COMMENT = 'InnoDB free: 9216 kB; (`pid`) REFER `warehouse/sys_permission`(`id`) ON DELETE C' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------
INSERT INTO `sys_role_permission` VALUES (1, 1);
INSERT INTO `sys_role_permission` VALUES (4, 1);
INSERT INTO `sys_role_permission` VALUES (5, 1);
INSERT INTO `sys_role_permission` VALUES (6, 1);
INSERT INTO `sys_role_permission` VALUES (7, 1);
INSERT INTO `sys_role_permission` VALUES (1, 2);
INSERT INTO `sys_role_permission` VALUES (4, 2);
INSERT INTO `sys_role_permission` VALUES (5, 2);
INSERT INTO `sys_role_permission` VALUES (1, 3);
INSERT INTO `sys_role_permission` VALUES (5, 3);
INSERT INTO `sys_role_permission` VALUES (1, 4);
INSERT INTO `sys_role_permission` VALUES (5, 4);
INSERT INTO `sys_role_permission` VALUES (6, 4);
INSERT INTO `sys_role_permission` VALUES (1, 5);
INSERT INTO `sys_role_permission` VALUES (7, 5);
INSERT INTO `sys_role_permission` VALUES (1, 6);
INSERT INTO `sys_role_permission` VALUES (1, 7);
INSERT INTO `sys_role_permission` VALUES (4, 7);
INSERT INTO `sys_role_permission` VALUES (5, 7);
INSERT INTO `sys_role_permission` VALUES (1, 8);
INSERT INTO `sys_role_permission` VALUES (4, 8);
INSERT INTO `sys_role_permission` VALUES (5, 8);
INSERT INTO `sys_role_permission` VALUES (1, 9);
INSERT INTO `sys_role_permission` VALUES (4, 9);
INSERT INTO `sys_role_permission` VALUES (5, 9);
INSERT INTO `sys_role_permission` VALUES (1, 10);
INSERT INTO `sys_role_permission` VALUES (5, 10);
INSERT INTO `sys_role_permission` VALUES (1, 11);
INSERT INTO `sys_role_permission` VALUES (5, 11);
INSERT INTO `sys_role_permission` VALUES (1, 12);
INSERT INTO `sys_role_permission` VALUES (5, 12);
INSERT INTO `sys_role_permission` VALUES (6, 12);
INSERT INTO `sys_role_permission` VALUES (1, 13);
INSERT INTO `sys_role_permission` VALUES (5, 13);
INSERT INTO `sys_role_permission` VALUES (6, 13);
INSERT INTO `sys_role_permission` VALUES (1, 14);
INSERT INTO `sys_role_permission` VALUES (7, 14);
INSERT INTO `sys_role_permission` VALUES (1, 15);
INSERT INTO `sys_role_permission` VALUES (7, 15);
INSERT INTO `sys_role_permission` VALUES (1, 16);
INSERT INTO `sys_role_permission` VALUES (7, 16);
INSERT INTO `sys_role_permission` VALUES (1, 17);
INSERT INTO `sys_role_permission` VALUES (7, 17);
INSERT INTO `sys_role_permission` VALUES (1, 18);
INSERT INTO `sys_role_permission` VALUES (7, 18);
INSERT INTO `sys_role_permission` VALUES (1, 21);
INSERT INTO `sys_role_permission` VALUES (1, 22);
INSERT INTO `sys_role_permission` VALUES (1, 23);
INSERT INTO `sys_role_permission` VALUES (1, 30);
INSERT INTO `sys_role_permission` VALUES (7, 30);
INSERT INTO `sys_role_permission` VALUES (1, 31);
INSERT INTO `sys_role_permission` VALUES (7, 31);
INSERT INTO `sys_role_permission` VALUES (1, 32);
INSERT INTO `sys_role_permission` VALUES (7, 32);
INSERT INTO `sys_role_permission` VALUES (1, 34);
INSERT INTO `sys_role_permission` VALUES (7, 34);
INSERT INTO `sys_role_permission` VALUES (1, 35);
INSERT INTO `sys_role_permission` VALUES (7, 35);
INSERT INTO `sys_role_permission` VALUES (1, 36);
INSERT INTO `sys_role_permission` VALUES (7, 36);
INSERT INTO `sys_role_permission` VALUES (1, 38);
INSERT INTO `sys_role_permission` VALUES (7, 38);
INSERT INTO `sys_role_permission` VALUES (1, 39);
INSERT INTO `sys_role_permission` VALUES (7, 39);
INSERT INTO `sys_role_permission` VALUES (1, 40);
INSERT INTO `sys_role_permission` VALUES (7, 40);
INSERT INTO `sys_role_permission` VALUES (1, 42);
INSERT INTO `sys_role_permission` VALUES (7, 42);
INSERT INTO `sys_role_permission` VALUES (1, 43);
INSERT INTO `sys_role_permission` VALUES (7, 43);
INSERT INTO `sys_role_permission` VALUES (1, 44);
INSERT INTO `sys_role_permission` VALUES (7, 44);
INSERT INTO `sys_role_permission` VALUES (1, 46);
INSERT INTO `sys_role_permission` VALUES (7, 46);
INSERT INTO `sys_role_permission` VALUES (1, 47);
INSERT INTO `sys_role_permission` VALUES (7, 47);
INSERT INTO `sys_role_permission` VALUES (1, 48);
INSERT INTO `sys_role_permission` VALUES (7, 48);
INSERT INTO `sys_role_permission` VALUES (1, 49);
INSERT INTO `sys_role_permission` VALUES (7, 49);
INSERT INTO `sys_role_permission` VALUES (1, 51);
INSERT INTO `sys_role_permission` VALUES (7, 51);
INSERT INTO `sys_role_permission` VALUES (1, 52);
INSERT INTO `sys_role_permission` VALUES (7, 52);
INSERT INTO `sys_role_permission` VALUES (1, 53);
INSERT INTO `sys_role_permission` VALUES (7, 53);
INSERT INTO `sys_role_permission` VALUES (1, 54);
INSERT INTO `sys_role_permission` VALUES (7, 54);
INSERT INTO `sys_role_permission` VALUES (1, 55);
INSERT INTO `sys_role_permission` VALUES (7, 55);
INSERT INTO `sys_role_permission` VALUES (1, 56);
INSERT INTO `sys_role_permission` VALUES (7, 56);
INSERT INTO `sys_role_permission` VALUES (1, 57);
INSERT INTO `sys_role_permission` VALUES (7, 57);
INSERT INTO `sys_role_permission` VALUES (1, 68);
INSERT INTO `sys_role_permission` VALUES (4, 68);
INSERT INTO `sys_role_permission` VALUES (5, 68);
INSERT INTO `sys_role_permission` VALUES (1, 69);
INSERT INTO `sys_role_permission` VALUES (1, 70);
INSERT INTO `sys_role_permission` VALUES (1, 71);
INSERT INTO `sys_role_permission` VALUES (1, 73);
INSERT INTO `sys_role_permission` VALUES (1, 74);
INSERT INTO `sys_role_permission` VALUES (1, 75);
INSERT INTO `sys_role_permission` VALUES (1, 76);
INSERT INTO `sys_role_permission` VALUES (1, 77);
INSERT INTO `sys_role_permission` VALUES (1, 78);
INSERT INTO `sys_role_permission` VALUES (1, 79);
INSERT INTO `sys_role_permission` VALUES (1, 81);
INSERT INTO `sys_role_permission` VALUES (4, 81);
INSERT INTO `sys_role_permission` VALUES (5, 81);
INSERT INTO `sys_role_permission` VALUES (1, 82);
INSERT INTO `sys_role_permission` VALUES (1, 83);
INSERT INTO `sys_role_permission` VALUES (1, 84);
INSERT INTO `sys_role_permission` VALUES (1, 86);
INSERT INTO `sys_role_permission` VALUES (1, 91);
INSERT INTO `sys_role_permission` VALUES (4, 91);
INSERT INTO `sys_role_permission` VALUES (5, 91);
INSERT INTO `sys_role_permission` VALUES (1, 92);
INSERT INTO `sys_role_permission` VALUES (4, 92);
INSERT INTO `sys_role_permission` VALUES (5, 92);
INSERT INTO `sys_role_permission` VALUES (1, 116);
INSERT INTO `sys_role_permission` VALUES (4, 116);
INSERT INTO `sys_role_permission` VALUES (5, 116);
INSERT INTO `sys_role_permission` VALUES (1, 117);
INSERT INTO `sys_role_permission` VALUES (4, 117);
INSERT INTO `sys_role_permission` VALUES (5, 117);
INSERT INTO `sys_role_permission` VALUES (1, 118);
INSERT INTO `sys_role_permission` VALUES (4, 118);
INSERT INTO `sys_role_permission` VALUES (5, 118);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `loginname` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `pwd` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `sex` int(11) NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `deptid` int(11) NULL DEFAULT NULL,
  `hiredate` datetime NULL DEFAULT NULL,
  `mgr` int(11) NULL DEFAULT NULL COMMENT '上级领导id',
  `available` int(11) NULL DEFAULT 1 COMMENT '是否可用，0不可用，1可用',
  `ordernum` int(11) NULL DEFAULT NULL COMMENT '排序码',
  `type` int(255) NULL DEFAULT NULL COMMENT '用户类型[0超级管理员，1管理员，2普通用户]',
  `imgpath` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '用户头像地址',
  `salt` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '盐',
  PRIMARY KEY USING BTREE (`id`),
  INDEX `FK_sys_dept_sys_user` USING BTREE(`deptid`),
  CONSTRAINT `FK_sys_dept_sys_user` FOREIGN KEY (`deptid`) REFERENCES `sys_dept` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci COMMENT = 'InnoDB free: 9216 kB; (`deptid`) REFER `warehouse/sys_dept`(`id`) ON UPDATE CASC' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, '超级管理员', 'system', '532ac00e86893901af5f0be6b704dbc7', '系统深处的男人', 1, '超级管理员', 1, '2018-06-25 11:06:34', NULL, 1, 1, 0, '../resources/images/defaultusertitle.jpg', '04A93C74C8294AA09A8B974FD1F4ECBB');
INSERT INTO `sys_user` VALUES (2, '落亦-', 'luoyi', '532ac00e86893901af5f0be6b704dbc7', '九江', 1, '超级管理员', 1, '2019-11-23 20:52:16', NULL, 1, 2, 0, '../resources/images/defaultusertitle.jpg', '04A93C74C8294AA09A8B974FD1F4ECBB');
INSERT INTO `sys_user` VALUES (3, '李约素', 'liyuesu', '532ac00e86893901af5f0be6b704dbc7', '猎户座旋臂', 1, '普通用户', 1, '2019-12-02 10:49:12', NULL, 1, 3, 1, NULL, '04A93C74C8294AA09A8B974FD1F4ECBB');
INSERT INTO `sys_user` VALUES (4, '李四', 'lisi', '532ac00e86893901af5f0be6b704dbc7', '九江', 1, '普通用户', 2, '2019-12-02 18:57:04', 3, 1, 4, 1, NULL, '04A93C74C8294AA09A8B974FD1F4ECBB');
INSERT INTO `sys_user` VALUES (5, '王五', 'wangwu', '532ac00e86893901af5f0be6b704dbc7', '上海', 1, '普通用户', 5, '2019-12-02 18:57:42', 4, 1, 5, 1, NULL, '04A93C74C8294AA09A8B974FD1F4ECBB');
INSERT INTO `sys_user` VALUES (6, '赵六', 'zhaoliu', '532ac00e86893901af5f0be6b704dbc7', '广州', 1, '普通用户', 5, '2019-12-02 18:59:05', 5, 1, 6, 1, NULL, '04A93C74C8294AA09A8B974FD1F4ECBB');
INSERT INTO `sys_user` VALUES (7, '陈七', 'chengqi', '532ac00e86893901af5f0be6b704dbc7', '深圳', 1, '普遍用户', 4, '2019-12-03 09:52:18', 3, 1, 7, 1, NULL, '04A93C74C8294AA09A8B974FD1F4ECBB');
INSERT INTO `sys_user` VALUES (10, '苏北旦', 'subeidan', 'b661f48dc70d448773be54874198788c', '猎户座旋臂', 0, '将军', 3, '2019-12-03 00:00:00', 3, 1, 9, 1, NULL, '950289EBDBA24C7789E392E1D0254635');
INSERT INTO `sys_user` VALUES (11, '斯嘉丽约翰逊', 'sijialiyuehanxun', 'f8408d1ccc3f83e4f035de3896569b76', '美国', 0, '演员', 7, '2019-12-03 14:23:35', 10, 1, 10, 1, NULL, '85DB5F84987146559A75B4B0DCB7DE4F');
INSERT INTO `sys_user` VALUES (12, '托尼', 'tuoni', '1403e113a2936d4509e9c13b8849f4b5', '美国', 1, '钢铁侠', 7, '2019-12-03 00:00:00', 11, 1, 11, 1, NULL, '571059AF59E64A7D92FECB93FA1B0AEF');
INSERT INTO `sys_user` VALUES (13, '贾维斯', 'jiaweisi', '98f28b861888f4274cb423345dce4bcc', '美国', 1, '人工智能', 3, '2019-12-03 00:00:00', 12, 1, 12, 1, NULL, '7258E2D93A3F429085B34BBD8E345CE7');
INSERT INTO `sys_user` VALUES (15, '上单', 'shangdan', '9628dd6423df694d091b0dbb01579cfa', '上海', 1, '似懂非懂', 18, '2019-12-06 08:50:14', 7, 1, 13, 1, NULL, 'C22D85AE05BD43F9A4B4D4FBDA3C7394');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `uid` int(11) NOT NULL DEFAULT 0,
  `rid` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY USING BTREE (`uid`, `rid`),
  INDEX `FK_sys_user_role_1` USING BTREE(`rid`),
  CONSTRAINT `FK_sys_user_role_1` FOREIGN KEY (`rid`) REFERENCES `sys_role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_sys_user_role_2` FOREIGN KEY (`uid`) REFERENCES `sys_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci COMMENT = 'InnoDB free: 9216 kB; (`rid`) REFER `warehouse/sys_role`(`id`); (`uid`) REFER `w' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (1, 1);
INSERT INTO `sys_user_role` VALUES (3, 1);
INSERT INTO `sys_user_role` VALUES (4, 4);
INSERT INTO `sys_user_role` VALUES (15, 4);
INSERT INTO `sys_user_role` VALUES (5, 5);
INSERT INTO `sys_user_role` VALUES (6, 6);
INSERT INTO `sys_user_role` VALUES (7, 6);
INSERT INTO `sys_user_role` VALUES (10, 7);

SET FOREIGN_KEY_CHECKS = 1;
