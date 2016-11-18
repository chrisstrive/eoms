-- ----------------------------
-- RECORDS OF AUTH_MENU
-- ----------------------------
INSERT INTO `AUTH_MENU` VALUES (1, 'EOMS', '运维平台', NULL, NULL, '1', 1);

INSERT INTO `AUTH_MENU` VALUES (100, 'BUSPROC', '业务处理', NULL, 1, '1', 1);
INSERT INTO `AUTH_MENU` VALUES (200, 'DATAMGN', '数据维护', NULL, 1, '1', 2);
INSERT INTO `AUTH_MENU` VALUES (900, 'PLATMNG', '平台管理', NULL, 1, '1', 99);
INSERT INTO `AUTH_MENU` VALUES (1000, 'AUTHMNG', '权限管理', NULL, 1, '1', 100);

INSERT INTO `AUTH_MENU` VALUES (1001, 'ROLEMNG', '角色管理', '/roledefault.htm?method=roleDefault', 1000, '1', 1);
INSERT INTO `AUTH_MENU` VALUES (1002, 'USERMNG', '用户管理', '/userdefault.htm?method=userDefault', 1000, '1', 2);
INSERT INTO `AUTH_MENU` VALUES (1003, 'CHANGEPWD', '修改密码', '/userdefault.htm?method=changePwdDispth', 1000, '1', 3);

INSERT INTO `AUTH_MENU` VALUES (901, 'DICMNG', '数据字典', '/dicDefault.htm?method=dicDefault', 900, '1', 1);

INSERT INTO `AUTH_MENU` VALUES (201, 'PROJECTMNG', '项目管理', '/projectmng.htm?method=queryView', 200, '1', 1);
INSERT INTO `AUTH_MENU` VALUES (902, 'SYSTEMMNG', '系统管理', '/systemmng.htm?method=queryView', 200, '1', 2);
INSERT INTO `AUTH_MENU` VALUES (203, 'SYSTYPEMNG', '系统类型管理', '/systypemng.htm?method=queryView', 200, '1', 3);
INSERT INTO `AUTH_MENU` VALUES (204, 'BRANDMNG', '品牌管理', '/brandmng.htm?method=queryView', 200, '1', 4);
INSERT INTO `AUTH_MENU` VALUES (205, 'MODELMNG', '型号管理', '/modelmng.htm?method=queryView', 200, '1', 5);
INSERT INTO `AUTH_MENU` VALUES (206, 'CHKITEMMNG', '检查项管理', '/chkitemmng.htm?method=queryView', 200, '1', 6);
INSERT INTO `AUTH_MENU` VALUES (207, 'MODELCHK', '品牌绑定检查项', '/modelchk.htm?method=queryView', 200, '1', 7);
INSERT INTO `AUTH_MENU` VALUES (208, 'LOCATIONMNG', '位置管理', '/locationmng.htm?method=queryView', 200, '1', 8);
INSERT INTO `AUTH_MENU` VALUES (209, 'DEVICEMNG', '设备管理', '/devicemng.htm?method=queryView', 200, '1', 9);

INSERT INTO `AUTH_MENU` VALUES (101, 'REPAIRORDER', '报修单管理', '/repairorder.htm?method=queryView', 100, '1', 1);
INSERT INTO `AUTH_MENU` VALUES (102, 'ROUTEORDER', '巡检单管理', '/routeorder.htm?method=queryView', 100, '1', 2);
INSERT INTO `AUTH_MENU` VALUES (103, 'MAINTAINORDER', '维护单管理', '/maintainorder.htm?method=queryView', 100, '1', 3);


-- ----------------------------
-- RECORDS OF AUTH_ROLE
-- ----------------------------
INSERT INTO `AUTH_ROLE` VALUES ('1', 'ADMIN', '系统管理员', '1', NULL);


-- ----------------------------
-- RECORDS OF AUTH_ROLE_MENU
-- ----------------------------
INSERT INTO `AUTH_ROLE_MENU` VALUES (1, 1, 1);
INSERT INTO `AUTH_ROLE_MENU` VALUES (2, 1, 100);
INSERT INTO `AUTH_ROLE_MENU` VALUES (3, 1, 200);
INSERT INTO `AUTH_ROLE_MENU` VALUES (4, 1, 900);
INSERT INTO `AUTH_ROLE_MENU` VALUES (5, 1, 1000);
INSERT INTO `AUTH_ROLE_MENU` VALUES (6, 1, 1001);
INSERT INTO `AUTH_ROLE_MENU` VALUES (7, 1, 1002);
INSERT INTO `AUTH_ROLE_MENU` VALUES (8, 1, 1003);
INSERT INTO `AUTH_ROLE_MENU` VALUES (9, 1, 901);
INSERT INTO `AUTH_ROLE_MENU` VALUES (10, 1, 201);
INSERT INTO `AUTH_ROLE_MENU` VALUES (11, 1, 902);
INSERT INTO `AUTH_ROLE_MENU` VALUES (12, 1, 203);
INSERT INTO `AUTH_ROLE_MENU` VALUES (13, 1, 204);
INSERT INTO `AUTH_ROLE_MENU` VALUES (14, 1, 205);
INSERT INTO `AUTH_ROLE_MENU` VALUES (15, 1, 206);
INSERT INTO `AUTH_ROLE_MENU` VALUES (16, 1, 207);
INSERT INTO `AUTH_ROLE_MENU` VALUES (17, 1, 208);
INSERT INTO `AUTH_ROLE_MENU` VALUES (18, 1, 209);
INSERT INTO `AUTH_ROLE_MENU` VALUES (19, 1, 101);
INSERT INTO `AUTH_ROLE_MENU` VALUES (20, 1, 102);
INSERT INTO `AUTH_ROLE_MENU` VALUES (21, 1, 103);


-- ----------------------------
-- RECORDS OF AUTH_USER
-- ----------------------------
INSERT INTO `AUTH_USER` VALUES ('1', 'ADMIN', 'E10ADC3949BA59ABBE56E057F20F883E', '1', '13888888888', '系统管理员', 'chris@1413.COM', '0217584124', '/OPT/PHOTO/111.jpg', null,null,'1',NULL);


-- ----------------------------
-- RECORDS OF AUTH_USER_ROLE
-- ----------------------------
INSERT INTO `AUTH_USER_ROLE` VALUES (1, 1, 1);