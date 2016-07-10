CREATE TABLE IF NOT EXISTS `province` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `prov_id` INT(10) UNSIGNED NOT NULL DEFAULT '0',
    `prov_name` VARCHAR(30) NOT NULL,
    `prov_type` VARCHAR(1) DEFAULT NULL COMMENT '1 - 直辖市/r/n2 - 行政省/r/n3 - 自治区/r/n4 - 特别行政区/r/n5 - 其他国家/r/n见全局数据字典[省份类型] /r/n',
    `prov_state` VARCHAR(1) DEFAULT NULL COMMENT '0 - 禁用/r/n1 - 启用',
    PRIMARY KEY (`id`)
);

INSERT INTO `province` (`id`, `prov_id`, `prov_name`, `prov_type`, `prov_state`) VALUES	(1, 1, '国外', '5', '1'),	(2, 10, '北京', '1', '1'),	(3, 11, '上海', '1', '1'),	(4, 12, '天津', '1', '1'),	(5, 13, '重庆', '1', '1'),	(6, 14, '河北', '2', '1'),	(7, 15, '山西', '2', '1'),	(8, 16, '内蒙古 ', '3', '1'),	(9, 17, '辽宁', '2', '1'),	(10, 18, '吉林', '2', '1'),	(11, 19, '黑龙江', '2', '1'),	(12, 20, '江苏', '2', '1'),	(13, 21, '浙江', '2', '1'),	(14, 22, '安徽', '2', '1'),	(15, 23, '福建', '2', '1'),	(16, 24, '江西', '2', '1'),	(17, 25, '山东', '2', '1'),	(18, 26, '河南', '2', '1'),	(19, 27, '湖北', '2', '1'),	(20, 28, '湖南', '2', '1'),	(21, 29, '广东', '2', '1'),	(22, 30, '广西', '3', '1'),	(23, 31, '海南', '2', '1'),	(24, 32, '四川', '2', '1'),	(25, 33, '贵州', '2', '1'),	(26, 34, '云南', '2', '1'),	(27, 35, '西藏', '3', '1'),	(28, 36, '陕西', '2', '1'),	(29, 37, '甘肃', '2', '1'),	(30, 38, '青海', '2', '1'),	(31, 39, '宁夏', '3', '1'),	(32, 40, '新疆', '3', '1'),	(33, 41, '香港', '4', '1'),	(34, 42, '澳门', '4', '1'),	(35, 43, '台湾', '2', '1');

CREATE TABLE IF NOT EXISTS `city` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `city_id` INT(10) UNSIGNED NOT NULL DEFAULT '0',
    `city_name` VARCHAR(30) NOT NULL,
    `city_py` VARCHAR(100) DEFAULT NULL,
    `prov_id` INT(10) UNSIGNED NOT NULL,
    `city_state` VARCHAR(1) DEFAULT NULL COMMENT '0 - 禁用/r/n1 - 启用 /r/n',
    PRIMARY KEY (`id`)
);

INSERT INTO `city` (`id`, `city_id`, `city_name`, `city_py`, `prov_id`, `city_state`) VALUES	(1, 600, '美国', 'meiguo', 1, '1'),	(2, 601, '日本', 'riben', 1, '1'),	(3, 602, '英国', 'yingguo', 1, '1'),	(4, 603, '法国', 'faguo', 1, '1'),	(5, 604, '德国', 'deguo', 1, '1'),	(6, 605, '加拿大', 'jianada', 1, '1'),	(7, 606, '澳大利亚', 'aodaliya', 1, '1'),	(8, 607, '俄罗斯', 'eluosi', 1, '1'),	(9, 608, '新西兰', 'xinxilan', 1, '1'),	(10, 609, '意大利', 'yidali', 1, '1'),	(11, 610, '韩国', 'hanguo', 1, '1'),	(12, 611, '比利时', 'bilishi', 1, '1'),	(13, 612, '瑞士', 'ruishi', 1, '1'),	(14, 613, '新加坡', 'xinjiapo', 1, '1'),	(15, 614, '墨西哥', 'moxige', 1, '1'),	(16, 615, '荷兰', 'helan', 1, '1'),	(17, 616, '巴西', 'baxi', 1, '1'),	(18, 617, '印度', 'yindu', 1, '1'),	(19, 618, '爱尔兰', 'aierlan', 1, '1'),	(20, 619, '马来西亚', 'malaixiya', 1, '1'),	(21, 620, '丹麦', 'danmai', 1, '1'),	(22, 621, '南非', 'nanfei', 1, '1'),	(23, 622, '西班牙', 'xibanya', 1, '1'),	(24, 1000, '东城区', 'dongchengqu', 10, '1'),	(25, 1001, '西城区', 'xichengqu', 10, '1'),	(26, 1002, '崇文区', 'chongwenqu', 10, '1'),	(27, 1003, '宣武区', 'xuanwuqu', 10, '1'),	(28, 1004, '朝阳区 ', 'chaoyangqu', 10, '1'),	(29, 1005, '丰台区', 'fengtaiqu', 10, '1'),	(30, 1006, '石景山区', 'shijingshanqu', 10, '1'),	(31, 1007, '海淀区', 'haidianqu', 10, '1'),	(32, 1008, '门头沟区', 'mentougouqu', 10, '1'),	(33, 1009, '房山区', 'fangshanqu', 10, '1'),	(34, 1010, '通州区', 'tongzhouqu', 10, '1'),	(35, 1011, '顺义区 ', 'shunyiqu', 10, '1'),	(36, 1012, '昌平区', 'changpingqu', 10, '1'),	(37, 1013, '大兴区', 'daxingqu', 10, '1'),	(38, 1014, '怀柔区', 'huairouqu', 10, '1'),	(39, 1015, '平谷区', 'pingguqu', 10, '1'),	(40, 1016, '密云县', 'miyunxian', 10, '1'),	(41, 1017, '延庆县', 'yanqingxian', 10, '1'),	(42, 1018, '黄浦区 ', 'huangpuqu', 11, '1'),	(43, 1019, '卢湾区', 'luwanqu', 11, '1'),	(44, 1020, '徐汇区', 'xuhuiqu', 11, '1'),	(45, 1021, '长宁区', 'zhangningqu', 11, '1'),	(46, 1022, '静安区', 'jinganqu', 11, '1'),	(47, 1023, '普陀区', 'putuoqu', 11, '1'),	(48, 1024, '闸北区', 'zhabeiqu', 11, '1'),	(49, 1025, '虹口区 ', 'hongkouqu', 11, '1'),	(50, 1026, '杨浦区', 'yangpuqu', 11, '1'),	(51, 1027, '闵行区', 'minxingqu', 11, '1'),	(52, 1028, '宝山区', 'baoshanqu', 11, '1'),	(53, 1029, '嘉定区', 'jiadingqu', 11, '1'),	(54, 1030, '浦东新区', 'pudongxinqu', 11, '1'),	(55, 1031, '金山区', 'jinshanqu', 11, '1'),	(56, 1032, '松江区 ', 'songjiangqu', 11, '1'),	(57, 1033, '青浦区', 'qingpuqu', 11, '1'),	(58, 1034, '南汇区', 'nanhuiqu', 11, '1'),	(59, 1035, '奉贤区', 'fengxianqu', 11, '1'),	(60, 1036, '崇明县', 'chongmingxian', 11, '1'),	(61, 1037, '和平区', 'hepingqu', 12, '1'),	(62, 1038, '河东区', 'hedongqu', 12, '1'),	(63, 1039, '河西区 ', 'hexiqu', 12, '1'),	(64, 1040, '南开区', 'nankaiqu', 12, '1'),	(65, 1041, '河北区', 'hebeiqu', 12, '1'),	(66, 1042, '红桥区', 'hongqiaoqu', 12, '1'),	(67, 1043, '塘沽区', 'tangguqu', 12, '1'),	(68, 1044, '汉沽区', 'hanguqu', 12, '1'),	(69, 1045, '大港区', 'dagangqu', 12, '1'),	(70, 1046, '东丽区 ', 'dongliqu', 12, '1'),	(71, 1047, '西青区', 'xiqingqu', 12, '1'),	(72, 1048, '津南区', 'jinnanqu', 12, '1'),	(73, 1049, '北辰区', 'beichenqu', 12, '1'),	(74, 1050, '武清区', 'wuqingqu', 12, '1'),	(75, 1051, '宝坻区', 'baochiqu', 12, '1'),	(76, 1052, '宁河县', 'ninghexian', 12, '1'),	(77, 1053, '静海县 ', 'jinghaixian', 12, '1'),	(78, 1054, '蓟县', 'jixian', 12, '1'),	(79, 1055, '万州区', 'wanzhouqu', 13, '1'),	(80, 1056, '涪陵区', 'fulingqu', 13, '1'),	(81, 1057, '渝中区', 'yuzhongqu', 13, '1'),	(82, 1058, '大渡口区', 'dadukouqu', 13, '1'),	(83, 1059, '江北区', 'jiangbeiqu', 13, '1'),	(84, 1060, '沙坪坝区 ', 'shapingbaqu', 13, '1'),	(85, 1061, '九龙坡区', 'jiulongpoqu', 13, '1'),	(86, 1062, '南岸区', 'nananqu', 13, '1'),	(87, 1063, '北碚区', 'beibeiqu', 13, '1'),	(88, 1064, '万盛区', 'wanshengqu', 13, '1'),	(89, 1065, '双桥区', 'shuangqiaoqu', 13, '1'),	(90, 1066, '渝北区', 'yubeiqu', 13, '1'),	(91, 1067, '巴南区 ', 'bananqu', 13, '1'),	(92, 1068, '黔江区', 'qianjiangqu', 13, '1'),	(93, 1069, '长寿区', 'zhangshouqu', 13, '1'),	(94, 1070, '綦江县', 'qijiangxian', 13, '1'),	(95, 1071, '潼南县', 'tongnanxian', 13, '1'),	(96, 1072, '铜梁县', 'tongliangxian', 13, '1'),	(97, 1073, '大足县', 'dazuxian', 13, '1'),	(98, 1074, '荣昌县 ', 'rongchangxian', 13, '1'),	(99, 1075, '璧山县', 'bishanxian', 13, '1'),	(100, 1076, '梁平县', 'liangpingxian', 13, '1'),	(101, 1077, '城口县', 'chengkouxian', 13, '1'),	(102, 1078, '丰都县', 'fengdouxian', 13, '1'),	(103, 1079, '垫江县', 'dianjiangxian', 13, '1'),	(104, 1080, '武隆县', 'wulongxian', 13, '1'),	(105, 1081, '忠县 ', 'zhongxian', 13, '1'),	(106, 1082, '开县', 'kaixian', 13, '1'),	(107, 1083, '云阳县', 'yunyangxian', 13, '1'),	(108, 1084, '奉节县', 'fengjiexian', 13, '1'),	(109, 1085, '巫山县', 'wushanxian', 13, '1'),	(110, 1086, '巫溪县', 'wuxixian', 13, '1'),	(111, 1087, '石柱土家族自治县', 'shizhutujiazuzizhixian', 13, '1'),	(112, 1088, ' 秀山土家族苗族自治县', 'xiushantujiazumiaozuzizhixian', 13, '1'),	(113, 1089, '酉阳土家族苗族自治县', 'youyangtujiazumiaozuzizhixian', 13, '1'),	(114, 1090, '彭水苗族土家族自治县 ', 'pengshuimiaozutujiazuzizhixian', 13, '1'),	(115, 1091, '江津市', 'jiangjinshi', 13, '1'),	(116, 1092, '合川市', 'hechuanshi', 13, '1'),	(117, 1093, '永川市', 'yongchuanshi', 13, '1'),	(118, 1094, '南川市', 'nanchuanshi', 13, '1'),	(119, 1095, '石家庄', 'shijiazhuang', 14, '1'),	(120, 1096, '唐山', 'tangshan', 14, '1'),	(121, 1097, '秦皇岛 ', 'qinhuangdao', 14, '1'),	(122, 1098, '邯郸', 'handan', 14, '1'),	(123, 1099, '邢台', 'xingtai', 14, '1'),	(124, 1100, '保定', 'baoding', 14, '1'),	(125, 1101, '张家口', 'zhangjiakou', 14, '1'),	(126, 1102, '承德', 'chengde', 14, '1'),	(127, 1103, '沧州', 'cangzhou', 14, '1'),	(128, 1104, '廊坊 ', 'langfang', 14, '1'),	(129, 1105, '衡水', 'hengshui', 14, '1'),	(130, 1106, '太原', 'taiyuan', 15, '1'),	(131, 1107, '大同', 'datong', 15, '1'),	(132, 1108, '阳泉', 'yangquan', 15, '1'),	(133, 1109, '长治', 'zhangzhi', 15, '1'),	(134, 1110, '晋城', 'jincheng', 15, '1'),	(135, 1111, '朔州 ', 'shuozhou', 15, '1'),	(136, 1112, '晋中', 'jinzhong', 15, '1'),	(137, 1113, '运城', 'yuncheng', 15, '1'),	(138, 1114, '忻州', 'xinzhou', 15, '1'),	(139, 1115, '临汾', 'linfen', 15, '1'),	(140, 1116, '吕梁', 'lu:liang', 15, '1'),	(141, 1117, '呼和浩特', 'huhehaote', 16, '1'),	(142, 1118, '包头 ', 'baotou', 16, '1'),	(143, 1119, '乌海', 'wuhai', 16, '1'),	(144, 1120, '赤峰', 'chifeng', 16, '1'),	(145, 1121, '通辽', 'tongliao', 16, '1'),	(146, 1122, '鄂尔多斯', 'eerduosi', 16, '1'),	(147, 1123, '呼伦贝尔', 'hulunbeier', 16, '1'),	(148, 1124, '乌兰察布', 'wulanchabu', 16, '1'),	(149, 1125, '锡林郭勒盟', 'xilinguolemeng', 16, '1'),	(150, 1126, '巴彦淖尔', 'bayannaoer', 16, '1'),	(151, 1127, '阿拉善盟', 'alashanmeng', 16, '1'),	(152, 1128, '兴安盟 ', 'xinganmeng', 16, '1'),	(153, 1129, '沈阳', 'shenyang', 17, '1'),	(154, 1130, '大连', 'dalian', 17, '1'),	(155, 1131, '鞍山', 'anshan', 17, '1'),	(156, 1132, '抚顺', 'fushun', 17, '1'),	(157, 1133, '本溪', 'benxi', 17, '1'),	(158, 1134, '丹东', 'dandong', 17, '1'),	(159, 1135, '锦州 ', 'jinzhou', 17, '1'),	(160, 1136, '葫芦岛', 'huludao', 17, '1'),	(161, 1137, '营口', 'yingkou', 17, '1'),	(162, 1138, '盘锦', 'panjin', 17, '1'),	(163, 1139, '阜新', 'fuxin', 17, '1'),	(164, 1140, '辽阳', 'liaoyang', 17, '1'),	(165, 1141, '铁岭', 'tieling', 17, '1'),	(166, 1142, '朝阳 ', 'chaoyang', 17, '1'),	(167, 1143, '长春', 'zhangchun', 18, '1'),	(168, 1144, '吉林', 'jilin', 18, '1'),	(169, 1145, '四平', 'siping', 18, '1'),	(170, 1146, '辽源', 'liaoyuan', 18, '1'),	(171, 1147, '通化', 'tonghua', 18, '1'),	(172, 1148, '白山', 'baishan', 18, '1'),	(173, 1149, '松原 ', 'songyuan', 18, '1'),	(174, 1150, '白城', 'baicheng', 18, '1'),	(175, 1151, '延边朝鲜', 'yanbianchaoxian', 18, '1'),	(176, 1152, '哈尔滨', 'haerbin', 19, '1'),	(177, 1153, '齐齐哈尔', 'qiqihaer', 19, '1'),	(178, 1154, '鹤岗', 'hegang', 19, '1'),	(179, 1155, '双鸭山', 'shuangyashan', 19, '1'),	(180, 1156, '鸡西 ', 'jixi', 19, '1'),	(181, 1157, '大庆', 'daqing', 19, '1'),	(182, 1158, '伊春', 'yichun_heilongjiang', 19, '1'),	(183, 1159, '牡丹江', 'mudanjiang', 19, '1'),	(184, 1160, '佳木斯', 'jiamusi', 19, '1'),	(185, 1161, '七台河', 'qitaihe', 19, '1'),	(186, 1162, '黑河', 'heihe', 19, '1'),	(187, 1163, '绥化 ', 'suihua', 19, '1'),	(188, 1164, '大兴安岭', 'daxinganling', 19, '1'),	(189, 1165, '南京', 'nanjing', 20, '1'),	(190, 1166, '无锡', 'wuxi', 20, '1'),	(191, 1167, '徐州', 'xuzhou', 20, '1'),	(192, 1168, '常州', 'changzhou', 20, '1'),	(193, 1169, '苏州', 'suzhou_jiangsu', 20, '1'),	(194, 1170, '南通 ', 'nantong', 20, '1'),	(195, 1171, '连云港', 'lianyungang', 20, '1'),	(196, 1172, '淮安', 'huaian', 20, '1'),	(197, 1173, '盐城', 'yancheng', 20, '1'),	(198, 1174, '扬州', 'yangzhou', 20, '1'),	(199, 1175, '镇江', 'zhenjiang', 20, '1'),	(200, 1176, '泰州', 'taizhou_jiangsu', 20, '1'),	(201, 1177, '宿迁 ', 'suqian', 20, '1'),	(202, 1178, '杭州', 'hangzhou', 21, '1'),	(203, 1179, '宁波', 'ningbo', 21, '1'),	(204, 1180, '温州', 'wenzhou', 21, '1'),	(205, 1181, '嘉兴', 'jiaxing', 21, '1'),	(206, 1182, '湖州', 'huzhou', 21, '1'),	(207, 1183, '绍兴', 'shaoxing', 21, '1'),	(208, 1184, '金华 ', 'jinhua', 21, '1'),	(209, 1185, '衢州', 'quzhou', 21, '1'),	(210, 1186, '舟山', 'zhoushan', 21, '1'),	(211, 1187, '台州', 'taizhou_zhejiang', 21, '1'),	(212, 1188, '丽水', 'lishui', 21, '1'),	(213, 1189, '合肥', 'hefei', 22, '1'),	(214, 1190, '芜湖', 'wuhu', 22, '1'),	(215, 1191, '蚌埠 ', 'bangbu', 22, '1'),	(216, 1192, '淮南', 'huainan', 22, '1'),	(217, 1193, '马鞍山', 'maanshan', 22, '1'),	(218, 1194, '淮北', 'huaibei', 22, '1'),	(219, 1195, '铜陵', 'tongling', 22, '1'),	(220, 1196, '安庆', 'anqing', 22, '1'),	(221, 1197, '黄山', 'huangshan', 22, '1'),	(222, 1198, '滁州 ', 'chuzhou', 22, '1'),	(223, 1199, '阜阳', 'fuyang', 22, '1'),	(224, 1200, '宿州', 'suzhou_anhui', 22, '1'),	(225, 1201, '巢湖', 'chaohu', 22, '1'),	(226, 1202, '六安', 'liuan', 22, '1'),	(227, 1203, '亳州', 'bozhou', 22, '1'),	(228, 1204, '池州', 'chizhou', 22, '1'),	(229, 1205, '宣城 ', 'xuancheng', 22, '1'),	(230, 1206, '福州', 'fuzhou_fujian', 23, '1'),	(231, 1207, '厦门', 'shamen', 23, '1'),	(232, 1208, '莆田', 'putian', 23, '1'),	(233, 1209, '三明', 'sanming', 23, '1'),	(234, 1210, '泉州', 'quanzhou', 23, '1'),	(235, 1211, '漳州', 'zhangzhou', 23, '1'),	(236, 1212, '南平 ', 'nanping', 23, '1'),	(237, 1213, '龙岩', 'longyan', 23, '1'),	(238, 1214, '宁德', 'ningde', 23, '1'),	(239, 1215, '南昌', 'nanchang', 24, '1'),	(240, 1216, '景德镇', 'jingdezhen', 24, '1'),	(241, 1217, '萍乡', 'pingxiang', 24, '1'),	(242, 1218, '新余', 'xinyu', 24, '1'),	(243, 1219, '九江 ', 'jiujiang', 24, '1'),	(244, 1220, '鹰潭', 'yingtan', 24, '1'),	(245, 1221, '赣州', 'ganzhou', 24, '1'),	(246, 1222, '吉安', 'jian', 24, '1'),	(247, 1223, '宜春', 'yichun_jiangxi', 24, '1'),	(248, 1224, '抚州', 'fuzhou_jiangxi', 24, '1'),	(249, 1225, '上饶', 'shangrao', 24, '1'),	(250, 1226, '济南 ', 'jinan', 25, '1'),	(251, 1227, '青岛', 'qingdao', 25, '1'),	(252, 1228, '淄博', 'zibo', 25, '1'),	(253, 1229, '枣庄', 'zaozhuang', 25, '1'),	(254, 1230, '东营', 'dongying', 25, '1'),	(255, 1231, '潍坊', 'weifang', 25, '1'),	(256, 1232, '烟台', 'yantai', 25, '1'),	(257, 1233, '威海 ', 'weihai', 25, '1'),	(258, 1234, '济宁', 'jining', 25, '1'),	(259, 1235, '泰安', 'taian', 25, '1'),	(260, 1236, '日照', 'rizhao', 25, '1'),	(261, 1237, '莱芜', 'laiwu', 25, '1'),	(262, 1238, '德州', 'dezhou', 25, '1'),	(263, 1239, '临沂', 'linyi', 25, '1'),	(264, 1240, '聊城 ', 'liaocheng', 25, '1'),	(265, 1241, '滨州', 'binzhou', 25, '1'),	(266, 1242, '菏泽', 'heze', 25, '1'),	(267, 1243, '郑州', 'zhengzhou', 26, '1'),	(268, 1244, '开封', 'kaifeng', 26, '1'),	(269, 1245, '洛阳', 'luoyang', 26, '1'),	(270, 1246, '平顶山', 'pingdingshan', 26, '1'),	(271, 1247, '焦作 ', 'jiaozuo', 26, '1'),	(272, 1248, '鹤壁', 'hebi', 26, '1'),	(273, 1249, '新乡', 'xinxiang', 26, '1'),	(274, 1250, '安阳', 'anyang', 26, '1'),	(275, 1251, '濮阳', 'puyang', 26, '1'),	(276, 1252, '许昌', 'xuchang', 26, '1'),	(277, 1253, '漯河', 'luohe', 26, '1'),	(278, 1254, '三门峡 ', 'sanmenxia', 26, '1'),	(279, 1255, '南阳', 'nanyang', 26, '1'),	(280, 1256, '商丘', 'shangqiu', 26, '1'),	(281, 1257, '信阳', 'xinyang', 26, '1'),	(282, 1258, '周口', 'zhoukou', 26, '1'),	(283, 1259, '驻马店', 'zhumadian', 26, '1'),	(284, 1260, '济源', 'jiyuan', 26, '1'),	(285, 1261, '武汉 ', 'wuhan', 27, '1'),	(286, 1262, '黄石', 'huangshi', 27, '1'),	(287, 1263, '襄樊', 'xiangfan', 27, '1'),	(288, 1264, '十堰', 'shiyan', 27, '1'),	(289, 1265, '荆州', 'jingzhou', 27, '1'),	(290, 1266, '宜昌', 'yichang', 27, '1'),	(291, 1267, '荆门', 'jingmen', 27, '1'),	(292, 1268, '鄂州 ', 'ezhou', 27, '1'),	(293, 1269, '孝感', 'xiaogan', 27, '1'),	(294, 1270, '黄冈', 'huanggang', 27, '1'),	(295, 1271, '咸宁', 'xianning', 27, '1'),	(296, 1272, '随州', 'suizhou', 27, '1'),	(297, 1273, '仙桃', 'xiantao', 27, '1'),	(298, 1274, '天门', 'tianmen', 27, '1'),	(299, 1275, '潜江 ', 'qianjiang', 27, '1'),	(300, 1276, '神农架', 'shennongjia', 27, '1'),	(301, 1277, '恩施土家', 'enshitujia', 27, '1'),	(302, 1278, '长沙', 'zhangsha', 28, '1'),	(303, 1279, '株洲', 'zhuzhou', 28, '1'),	(304, 1280, '湘潭', 'xiangtan', 28, '1'),	(305, 1281, '衡阳', 'hengyang', 28, '1'),	(306, 1282, '邵阳 ', 'shaoyang', 28, '1'),	(307, 1283, '岳阳', 'yueyang', 28, '1'),	(308, 1284, '常德', 'changde', 28, '1'),	(309, 1285, '张家界', 'zhangjiajie', 28, '1'),	(310, 1286, '益阳', 'yiyang', 28, '1'),	(311, 1287, '郴州', 'chenzhou', 28, '1'),	(312, 1288, '怀化', 'huaihua', 28, '1'),	(313, 1289, '娄底 ', 'loudi', 28, '1'),	(314, 1290, '湘西土家', 'xiangxitujia', 28, '1'),	(315, 1291, '永州', 'yongzhou', 28, '1'),	(316, 1292, '广州', 'guangzhou', 29, '1'),	(317, 1293, '深圳', 'shenzhen', 29, '1'),	(318, 1294, '珠海', 'zhuhai', 29, '1'),	(319, 1295, '汕头', 'shantou', 29, '1'),	(320, 1296, '韶关 ', 'shaoguan', 29, '1'),	(321, 1297, '佛山', 'foshan', 29, '1'),	(322, 1298, '江门', 'jiangmen', 29, '1'),	(323, 1299, '湛江', 'zhanjiang', 29, '1'),	(324, 1300, '茂名', 'maoming', 29, '1'),	(325, 1301, '肇庆', 'zhaoqing', 29, '1'),	(326, 1302, '惠州', 'huizhou', 29, '1'),	(327, 1303, '梅州 ', 'meizhou', 29, '1'),	(328, 1304, '汕尾', 'shanwei', 29, '1'),	(329, 1305, '河源', 'heyuan', 29, '1'),	(330, 1306, '阳江', 'yangjiang', 29, '1'),	(331, 1307, '清远', 'qingyuan', 29, '1'),	(332, 1308, '东莞', 'dongguan', 29, '1'),	(333, 1309, '中山', 'zhongshan', 29, '1'),	(334, 1310, '潮州 ', 'chaozhou', 29, '1'),	(335, 1311, '揭阳', 'jieyang', 29, '1'),	(336, 1312, '云浮', 'yunfu', 29, '1'),	(337, 1313, '南宁', 'nanning', 30, '1'),	(338, 1314, '柳州', 'liuzhou', 30, '1'),	(339, 1315, '桂林', 'guilin', 30, '1'),	(340, 1316, '梧州', 'wuzhou', 30, '1'),	(341, 1317, '北海 ', 'beihai', 30, '1'),	(342, 1318, '防城港', 'fangchenggang', 30, '1'),	(343, 1319, '钦州', 'qinzhou', 30, '1'),	(344, 1320, '贵港', 'guigang', 30, '1'),	(345, 1321, '玉林', 'yulin_guangxi', 30, '1'),	(346, 1322, '百色', 'baise', 30, '1'),	(347, 1323, '贺州', 'hezhou', 30, '1'),	(348, 1324, '河池 ', 'hechi', 30, '1'),	(349, 1325, '来宾', 'laibin', 30, '1'),	(350, 1326, '崇左', 'chongzuo', 30, '1'),	(351, 1327, '海口', 'haikou', 31, '1'),	(352, 1328, '三亚', 'sanya', 31, '1'),	(353, 1329, '五指山', 'wuzhishan', 31, '1'),	(354, 1330, '琼海', 'qionghai', 31, '1'),	(355, 1331, '儋州 ', 'danzhou', 31, '1'),	(356, 1332, '文昌', 'wenchang', 31, '1'),	(357, 1333, '万宁', 'wanning', 31, '1'),	(358, 1334, '东方', 'dongfang', 31, '1'),	(359, 1335, '澄迈', 'chengmai', 31, '1'),	(360, 1336, '定安', 'dingan', 31, '1'),	(361, 1337, '屯昌', 'tunchang', 31, '1'),	(362, 1338, '临高 ', 'lingao', 31, '1'),	(363, 1339, '白沙黎族', 'baishalizu', 31, '1'),	(364, 1340, '江黎族自', 'jianglizuzi', 31, '1'),	(365, 1341, '乐东黎族 ', 'ledonglizu', 31, '1'),	(366, 1342, '陵水黎族', 'lingshuilizu', 31, '1'),	(367, 1343, '保亭黎族', 'baotinglizu', 31, '1'),	(368, 1344, '琼中黎族 ', 'qiongzhonglizu', 31, '1'),	(369, 1345, '西沙群岛', 'xishaqundao', 31, '1'),	(370, 1346, '南沙群岛', 'nanshaqundao', 31, '1'),	(371, 1347, '中沙群岛 ', 'zhongshaqundao', 31, '1'),	(372, 1348, '成都', 'chengdou', 32, '1'),	(373, 1349, '自贡', 'zigong', 32, '1'),	(374, 1350, '攀枝花', 'panzhihua', 32, '1'),	(375, 1351, '泸州', 'luzhou', 32, '1'),	(376, 1352, '德阳', 'deyang', 32, '1'),	(377, 1353, '绵阳', 'mianyang', 32, '1'),	(378, 1354, '广元 ', 'guangyuan', 32, '1'),	(379, 1355, '遂宁', 'suining', 32, '1'),	(380, 1356, '内江', 'neijiang', 32, '1'),	(381, 1357, '乐山', 'leshan', 32, '1'),	(382, 1358, '南充', 'nanchong', 32, '1'),	(383, 1359, '宜宾', 'yibin', 32, '1'),	(384, 1360, '广安', 'guangan', 32, '1'),	(385, 1361, '达州 ', 'dazhou', 32, '1'),	(386, 1362, '眉山', 'meishan', 32, '1'),	(387, 1363, '雅安', 'yaan', 32, '1'),	(388, 1364, '巴中', 'bazhong', 32, '1'),	(389, 1365, '资阳', 'ziyang', 32, '1'),	(390, 1366, '阿坝藏族', 'abazangzu', 32, '1'),	(391, 1367, '甘孜藏族', 'ganzizangzu', 32, '1'),	(392, 1368, '凉山彝族 ', 'liangshanyizu', 32, '1'),	(393, 1369, '贵阳', 'guiyang', 33, '1'),	(394, 1370, '六盘水', 'liupanshui', 33, '1'),	(395, 1371, '遵义', 'zunyi', 33, '1'),	(396, 1372, '安顺', 'anshun', 33, '1'),	(397, 1373, '铜仁', 'tongren', 33, '1'),	(398, 1374, '毕节', 'bijie', 33, '1'),	(399, 1375, '黔西南布 ', 'qianxinanbu', 33, '1'),	(400, 1376, '黔东南苗', 'qiandongnanmiao', 33, '1'),	(401, 1377, '黔南布依', 'qiannanbuyi', 33, '1'),	(402, 1378, '昆明', 'kunming', 34, '1'),	(403, 1379, '曲靖', 'qujing', 34, '1'),	(404, 1380, '玉溪', 'yuxi', 34, '1'),	(405, 1381, '保山', 'baoshan', 34, '1'),	(406, 1382, '昭通 ', 'zhaotong', 34, '1'),	(407, 1383, '丽江', 'lijiang', 34, '1'),	(408, 1384, '思茅', 'simao', 34, '1'),	(409, 1385, '临沧', 'lincang', 34, '1'),	(410, 1386, '文山壮族', 'wenshanzhuangzu', 34, '1'),	(411, 1387, '红河哈尼', 'honghehani', 34, '1'),	(412, 1388, '西双版纳', 'xishuangbanna', 34, '1'),	(413, 1389, '楚雄彝族', 'chuxiongyizu', 34, '1'),	(414, 1390, '大理白族', 'dalibaizu', 34, '1'),	(415, 1391, '德宏傣族', 'dehongdaizu', 34, '1'),	(416, 1392, '怒江傈傈 ', 'nujianglili', 34, '1'),	(417, 1393, '迪庆藏族', 'diqingzangzu', 34, '1'),	(418, 1394, '拉萨', 'lasa', 35, '1'),	(419, 1395, '那曲', 'neiqu', 35, '1'),	(420, 1396, '昌都', 'changdou', 35, '1'),	(421, 1397, '山南', 'shannan', 35, '1'),	(422, 1398, '日喀则', 'rikaze', 35, '1'),	(423, 1399, '阿里 ', 'ali', 35, '1'),	(424, 1400, '林芝', 'linzhi', 35, '1'),	(425, 1401, '西安', 'xian', 36, '1'),	(426, 1402, '铜川', 'tongchuan', 36, '1'),	(427, 1403, '宝鸡', 'baoji', 36, '1'),	(428, 1404, '咸阳', 'xianyang', 36, '1'),	(429, 1405, '渭南', 'weinan', 36, '1'),	(430, 1406, '延安 ', 'yanan', 36, '1'),	(431, 1407, '汉中', 'hanzhong', 36, '1'),	(432, 1408, '榆林', 'yulin_shanxi', 36, '1'),	(433, 1409, '安康', 'ankang', 36, '1'),	(434, 1410, '商洛', 'shangluo', 36, '1'),	(435, 1411, '兰州', 'lanzhou', 37, '1'),	(436, 1412, '金昌', 'jinchang', 37, '1'),	(437, 1413, '白银 ', 'baiyin', 37, '1'),	(438, 1414, '天水', 'tianshui', 37, '1'),	(439, 1415, '嘉峪关', 'jiayuguan', 37, '1'),	(440, 1416, '武威', 'wuwei', 37, '1'),	(441, 1417, '张掖', 'zhangye', 37, '1'),	(442, 1418, '平凉', 'pingliang', 37, '1'),	(443, 1419, '酒泉', 'jiuquan', 37, '1'),	(444, 1420, '庆阳 ', 'qingyang', 37, '1'),	(445, 1421, '定西', 'dingxi', 37, '1'),	(446, 1422, '陇南', 'longnan', 37, '1'),	(447, 1423, '临夏回族', 'linxiahuizu', 37, '1'),	(448, 1424, '甘南藏族', 'gannanzangzu', 37, '1'),	(449, 1425, '西宁', 'xining', 38, '1'),	(450, 1426, '海东', 'haidong', 38, '1'),	(451, 1427, '海北藏族 ', 'haibeizangzu', 38, '1'),	(452, 1428, '黄南藏族', 'huangnanzangzu', 38, '1'),	(453, 1429, '海南藏族', 'hainanzangzu', 38, '1'),	(454, 1430, '果洛藏族 ', 'guoluozangzu', 38, '1'),	(455, 1431, '玉树藏族', 'yushuzangzu', 38, '1'),	(456, 1432, '海西蒙古', 'haiximenggu', 38, '1'),	(457, 1433, '银川', 'yinchuan', 39, '1'),	(458, 1434, '石嘴山', 'shizuishan', 39, '1'),	(459, 1435, '吴忠', 'wuzhong', 39, '1'),	(460, 1436, '固原', 'guyuan', 39, '1'),	(461, 1437, '中卫 ', 'zhongwei', 39, '1'),	(462, 1438, '乌鲁木齐', 'wulumuqi', 40, '1'),	(463, 1439, '克拉玛依', 'kelamayi', 40, '1'),	(464, 1440, '石河子', 'shihezi', 40, '1'),	(465, 1441, '阿拉尔', 'alaer', 40, '1'),	(466, 1442, '图木舒克', 'tumushuke', 40, '1'),	(467, 1443, '五家渠', 'wujiaqu', 40, '1'),	(468, 1444, '吐鲁番 ', 'tulufan', 40, '1'),	(469, 1445, '哈密', 'hami', 40, '1'),	(470, 1446, '和田', 'hetian', 40, '1'),	(471, 1447, '阿克苏', 'akesu', 40, '1'),	(472, 1448, '喀什', 'kashen', 40, '1'),	(473, 1449, '克孜勒苏', 'kezilesu', 40, '1'),	(474, 1450, '巴音郭楞', 'bayinguoleng', 40, '1'),	(475, 1451, '昌吉回族 ', 'changjihuizu', 40, '1'),	(476, 1452, '博尔塔拉', 'boertala', 40, '1'),	(477, 1453, '伊犁哈萨', 'yilihasa', 40, '1'),	(478, 1454, '塔城', 'tacheng', 40, '1'),	(479, 1455, '阿勒泰', 'aletai', 40, '1'),	(480, 1456, '台北', 'taibei', 43, '1'),	(481, 1457, '高雄', 'gaoxiong', 43, '1'),	(482, 1458, '基隆 ', 'jilong', 43, '1'),	(483, 1459, '台中', 'taizhong', 43, '1'),	(484, 1460, '台南', 'tainan', 43, '1'),	(485, 1461, '新竹', 'xinzhu', 43, '1'),	(486, 1462, '嘉义', 'jiayi', 43, '1'),	(487, 1463, '台北县', 'taibeixian', 43, '1'),	(488, 1464, '宜兰县', 'yilanxian', 43, '1'),	(489, 1465, '新竹县 ', 'xinzhuxian', 43, '1'),	(490, 1466, '桃园县', 'taoyuanxian', 43, '1'),	(491, 1467, '苗栗县', 'miaolixian', 43, '1'),	(492, 1468, '台中县', 'taizhongxian', 43, '1'),	(493, 1469, '彰化县', 'zhanghuaxian', 43, '1'),	(494, 1470, '南投县', 'nantouxian', 43, '1'),	(495, 1471, '嘉义县', 'jiayixian', 43, '1'),	(496, 1472, '云林县 ', 'yunlinxian', 43, '1'),	(497, 1473, '台南县', 'tainanxian', 43, '1'),	(498, 1474, '高雄县', 'gaoxiongxian', 43, '1'),	(499, 1475, '屏东县', 'pingdongxian', 43, '1'),	(500, 1476, '台东县', 'taidongxian', 43, '1'),	(501, 1477, '花莲县', 'hualianxian', 43, '1'),	(502, 1478, '澎湖县', 'penghuxian', 43, '1'),	(503, 10, '北京', 'beijing', 10, '1'),	(504, 11, '上海', 'shanghai', 11, '1'),	(505, 12, '天津', 'tianjin', 12, '1'),	(506, 13, '重庆', 'zhongqing', 13, '1'),	(507, 41, '香港', 'xianggang', 41, '1'),	(508, 42, '澳门', 'aomen', 42, '1');

delete from city where prov_id=1;
