/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50725
Source Host           : localhost:3306
Source Database       : campusqa

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2020-03-05 20:37:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `content` text,
  `user_id` int(11) DEFAULT NULL,
  `entity_id` int(11) DEFAULT NULL,
  `entity_type` int(11) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `entity_index` (`entity_id`,`entity_type`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('41', '据说 Max Howell（ 90% google 的人都用过他写的 Homebrew ）去 Google 面试，然后 Google 要求他用白板翻转一颗二叉树，结果写不出来就被 Google 拒了。', '40', '99', '100', '2020-03-05 19:56:17', '0');
INSERT INTO `comment` VALUES ('42', '本人成都一个垃圾程序员。目前月薪15K(大佬别揍我！)。\r\n\r\n15k估计有很多人来说我成都比你工资高多了，但这不是重点哈！腾讯，阿里，京东的大佬请放过我哈！', '40', '98', '100', '2020-03-05 19:56:41', '0');
INSERT INTO `comment` VALUES ('43', '本人成都一个垃圾程序员。目前月薪15K(大佬别揍我！)。\r\n\r\n15k估计有很多人来说我成都比你工资高多了，但这不是重点哈！腾讯，阿里，京东的大佬请放过我哈！', '40', '97', '100', '2020-03-05 19:56:56', '0');
INSERT INTO `comment` VALUES ('44', '1. 害怕改变，没有勇气及时止损。要么沉溺于过去的辉煌，要么屈服于现实的安稳。人生只有一次，生命短暂多舛，多听听自己内心的声音，才能活出不废的人生啊。2. 只接受碎片化的信息，不进行系统完整的梳理与思考。刷微博、刷知乎，被动接受许多资讯，但不进行自主思考，没有形成自己的观点，充实自己的内心。3. 拖延症、拖延症、拖延症。下午再做吧，晚上再做吧，明天再做吧，下周再做吧，明年吧&hellip;&hellip;\r\n', '40', '96', '100', '2020-03-05 19:57:34', '0');
INSERT INTO `comment` VALUES ('45', '我00年二月份的，大三，同学基本上是99.98年的，我强行说自己是00后好像是有点过分哈\r\n\r\n最近拍的照片，不知道看起来像不像00后', '40', '95', '100', '2020-03-05 19:58:16', '0');
INSERT INTO `comment` VALUES ('46', '因为来而不往非礼也\r\n\r\n\r\n雷军也试过与hw和谐相处的。\r\n\r\n在某一年的乌镇互联网大会，雷军提议所有的国产厂商，大家不要互相黑，一起协作，打败国外的这些巨头。\r\n\r\n当时很多厂商的领军人物都同意，包括余承东，一派和谐繁荣。', '40', '94', '100', '2020-03-05 19:58:34', '0');
INSERT INTO `comment` VALUES ('47', '因为他们觉得反正招进来之后我也用不上二叉树，你们谁写业务代码的时候用上二叉树了？所以我不会就不会呗。这其实就是&ldquo;高等数学有啥用，又不能用来买菜&rdquo;的进化版本。', '42', '99', '100', '2020-03-05 20:03:41', '0');
INSERT INTO `comment` VALUES ('48', '因为近水楼台的关系，有好多女的让我帮介绍单身男程序员，一般要求还是大厂+绿卡起+有车房（house+benz级别以上）。还有的要求必须是中国一线城市来的+相貌堂堂。因为她们不造在哪听说的程序员都是看到女人眼睛里就冒小星星的铁憨憨，钱又多，所以觉得只要自己&ldquo;想找&rdquo;个程序员，就立刻天降一个过来。', '42', '98', '100', '2020-03-05 20:03:59', '0');
INSERT INTO `comment` VALUES ('49', '过度追求&ldquo;短期回报&rdquo;可以先思考这样一个问题：为什么玩王者荣耀我们总是停不下来，而刷题却如此痛苦？因为游戏里你的每一次行动，几乎都会有实时的反馈跟着。这种超强的&ldquo;短期回报&rdquo;系统在一些页游上被运用到了极致：你的每次升级、每次装备强化、每次充值都会变成一个大大的战斗力+10086显示出来，让你的大脑沉浸产生了这样一种错觉：只要有投入，马上就有产出。而自我提升则不同。你很难在自我提升的过程中得到实时的反馈，你根本无法确定自己今天的行为会在什么时候得到回报，甚至会不会得到回报。更可怕的是那种&ldquo;游戏化&rdquo;的自我提升。\r\n', '42', '96', '100', '2020-03-05 20:04:22', '0');
INSERT INTO `comment` VALUES ('50', '大一尝试过的兼职有帮培训机构招生（比较难做，提成1000一位学生），家教（学校普通缘故又是通过家教机构才40左右一个小时）。大二的时候因为皮肤好接触到一个护肤品品牌做了半年微商赚了两万块钱，自己资源太少，也是因为家人亲戚支持才勉强坚持的，这是大学问，后来还是放弃了。\r\n', '42', '95', '100', '2020-03-05 20:04:57', '0');
INSERT INTO `comment` VALUES ('51', '因为目前只能盯着华为了\r\n\r\n苹果，最早小米是对标苹果的，还说要和苹果一样出高端精品手机。等后来红米诞生了，基本也就不提这个目标了。而且主要是人家不搭理你，只有发布会上可以吊打一下，日常还是蹭不到流量。', '42', '94', '100', '2020-03-05 20:05:12', '0');
INSERT INTO `comment` VALUES ('52', '先亮明观点：身为程序员，算法知识100%是必要的！本人从事的不是什么高大上的研究工作，跟数据挖掘模式识别自然语言处理云计算大数据blahblah全都不沾边。做过一段时间的J2EE开发，现在主要做基于HTML5的前台开发。看到这儿很多人要说了，不就是个做网页的嘛，做网页还用的上算法？不就是表单验证提交一下？我的回答是绝对用的上！\r\n', '41', '99', '100', '2020-03-05 20:07:59', '0');
INSERT INTO `comment` VALUES ('53', '我是程序媛 项目组十几个开发吧 只有一个男生还是单身。发现程序员找女朋友好像挺容易的...而且范围比较广泛 有同行的 有做产品做设计的 还有HR小姐姐。反而女程序员找对象一般同行比较多。', '41', '98', '100', '2020-03-05 20:08:20', '0');
INSERT INTO `comment` VALUES ('54', '不够专精\r\n\r\n王阳明说，杀人须就咽喉上着刀，我深以为然。\r\n\r\n小混混打架，老手都是提刀乱砍，看似血光四溅，实则都是皮肉伤，声势浩大，却无大碍。最怕的是哪个愣头青猛扎一刀，遇到要害，多半就要出事。', '41', '96', '100', '2020-03-05 20:08:45', '0');
INSERT INTO `comment` VALUES ('55', '我结婚10年了，深深觉得男女的确来自不同星球。所以如果你想要他理解你，特别是女性特有的情况，不要指望他和你心有灵犀，要把他拉到你的环境里来。', '41', '97', '100', '2020-03-05 20:09:01', '0');
INSERT INTO `comment` VALUES ('56', '看了这么多回答后我&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;&mdash;\r\n\r\n\r\n\r\n\r\n\r\n紧紧握住我的五十块钱，留下来了不争气的眼泪\r\n\r\n2020.3.4\r\n\r\n答主现在连最后的五十都没了，中国加油，疫情快过去啊啊啊，我要开学，我要生活费！！！', '41', '95', '100', '2020-03-05 20:09:27', '0');
INSERT INTO `comment` VALUES ('57', '小米的线上敌手，最重要的就是华为荣耀，去年我国线上&ldquo;互联网手机&rdquo;里面，第一是华为，第二是荣耀，小米这原本第一被折腾成这样，当然不服。想伟大复兴嘛，祖上阔过啊，至于线下&hellip;&hellip;从来没有强势过。', '41', '94', '100', '2020-03-05 20:09:45', '0');

-- ----------------------------
-- Table structure for login_ticket
-- ----------------------------
DROP TABLE IF EXISTS `login_ticket`;
CREATE TABLE `login_ticket` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `ticket` varchar(50) DEFAULT NULL,
  `expired` datetime DEFAULT NULL,
  `status` int(11) DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `ticket` (`ticket`)
) ENGINE=InnoDB AUTO_INCREMENT=107 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of login_ticket
-- ----------------------------
INSERT INTO `login_ticket` VALUES ('1', '20', 'd825499e3f5c49a5b3ac141eac368cd4', '2018-09-06 17:43:34', '1');
INSERT INTO `login_ticket` VALUES ('2', '20', 'e8b4feeaa8e741948a8b1e80215e0d53', '2018-09-06 17:47:31', '1');
INSERT INTO `login_ticket` VALUES ('3', '20', '43d63c9d59524cb289322a37ed341c0d', '2018-09-06 19:51:42', '1');
INSERT INTO `login_ticket` VALUES ('4', '21', '03c27ad9ace645c18c7f6ec058c7bcfc', '2018-09-06 20:01:03', '1');
INSERT INTO `login_ticket` VALUES ('5', '20', 'fc0957dbf73e4b5fbed24a748d13716d', '2018-09-06 20:03:15', '1');
INSERT INTO `login_ticket` VALUES ('6', '20', 'ac36efabd6e3404a8bf51b85b06c8dfe', '2018-09-06 20:05:21', '1');
INSERT INTO `login_ticket` VALUES ('7', '20', '365ad7888bc24f02ac4c60a650cfc3c1', '2018-09-06 20:10:39', '1');
INSERT INTO `login_ticket` VALUES ('8', '20', '6a075c685fc14a148ef5013d729853da', '2018-09-06 20:10:57', '1');
INSERT INTO `login_ticket` VALUES ('9', '20', 'df67972d641943148daa0fa240bbbb15', '2018-09-06 20:11:08', '0');
INSERT INTO `login_ticket` VALUES ('10', '20', '394b9711e37b458e8a5001f12170db04', '2018-09-07 09:38:12', '1');
INSERT INTO `login_ticket` VALUES ('11', '20', 'd299b1424bc54633bf614e8036bf374a', '2018-09-22 09:20:13', '1');
INSERT INTO `login_ticket` VALUES ('12', '20', '576d0047ee7846a2ad44e209431a1dc5', '2018-09-22 10:04:37', '1');
INSERT INTO `login_ticket` VALUES ('13', '20', 'b726abb5df73471ea7aa3d935fff0e86', '2018-09-22 10:05:43', '1');
INSERT INTO `login_ticket` VALUES ('14', '20', '959eb7fc225e4565b74181cda6a1745b', '2018-09-22 10:13:25', '1');
INSERT INTO `login_ticket` VALUES ('15', '20', 'cc4a66e7f3fc402b947d83f1138df8e7', '2018-09-22 10:25:02', '1');
INSERT INTO `login_ticket` VALUES ('16', '20', '143383ff38054f58b69755e25adba2eb', '2018-09-22 10:36:29', '1');
INSERT INTO `login_ticket` VALUES ('17', '21', 'cab5789998cc491cb267f9b9ce40b4b2', '2018-09-22 11:04:01', '1');
INSERT INTO `login_ticket` VALUES ('18', '20', '007f4c9f20264cd0823fb0ab600d036a', '2018-09-22 11:10:21', '1');
INSERT INTO `login_ticket` VALUES ('19', '20', '331b4ea6861a4d368e5971baa91bc958', '2018-09-22 11:11:43', '1');
INSERT INTO `login_ticket` VALUES ('20', '20', '17c2cf5550ea4e138aec6ba414a91566', '2018-09-22 11:12:00', '0');
INSERT INTO `login_ticket` VALUES ('21', '20', 'cd417ca476974055969410e2ff3b6b18', '2018-09-22 11:15:53', '1');
INSERT INTO `login_ticket` VALUES ('22', '20', '0b47f2352b5b405bbf4f66edb92eba34', '2018-09-22 11:45:33', '0');
INSERT INTO `login_ticket` VALUES ('23', '20', '9166da39aa4a435ab35f1b8b5418bc15', '2018-09-22 11:45:45', '0');
INSERT INTO `login_ticket` VALUES ('24', '20', '03a2cabe24c54d359b8161f68a1be588', '2018-09-22 13:33:26', '1');
INSERT INTO `login_ticket` VALUES ('25', '20', '144334a7b3c04f7297fae48271f45710', '2018-09-22 13:34:01', '1');
INSERT INTO `login_ticket` VALUES ('26', '20', '07e9791bdcef48dea8cbc9c0cae9048a', '2018-09-22 13:34:07', '0');
INSERT INTO `login_ticket` VALUES ('27', '20', 'b6584603ec784bfdb4582aa852914586', '2018-09-22 18:48:42', '0');
INSERT INTO `login_ticket` VALUES ('28', '22', 'a68a57f7c4fa41d2b501adf41ca57367', '2018-09-24 07:46:03', '0');
INSERT INTO `login_ticket` VALUES ('29', '20', 'a23cf2c9aa634616a94bc9babd136792', '2018-09-24 08:17:39', '0');
INSERT INTO `login_ticket` VALUES ('30', '21', 'b5eab35022544d88b73ab59836f79b48', '2018-09-24 13:42:42', '0');
INSERT INTO `login_ticket` VALUES ('31', '20', '92ebc15d91c74c1bb801916f94ab15dd', '2018-09-24 14:12:56', '0');
INSERT INTO `login_ticket` VALUES ('32', '20', '953f6a35129949b19bdad754100f26b2', '2018-09-25 00:20:09', '0');
INSERT INTO `login_ticket` VALUES ('33', '21', '24e67518eaeb45cc8d68d9354fbe58ed', '2018-09-25 00:38:36', '0');
INSERT INTO `login_ticket` VALUES ('34', '20', '8a7cb178cc6e4dc190b578d5e9de9c20', '2018-09-25 08:32:29', '0');
INSERT INTO `login_ticket` VALUES ('35', '21', 'c53b3ac4838542f48d12546935ccf922', '2018-09-25 09:20:22', '0');
INSERT INTO `login_ticket` VALUES ('36', '23', '5f2d65b2b87148108b3d4d3357bcdbcd', '2018-09-25 09:27:45', '0');
INSERT INTO `login_ticket` VALUES ('37', '21', '02f6fd367d04448dabe57a97d0d3b762', '2018-09-25 10:03:26', '0');
INSERT INTO `login_ticket` VALUES ('38', '21', 'c3ffae1c1f6843ec996190ddd6f04293', '2018-09-25 10:04:16', '0');
INSERT INTO `login_ticket` VALUES ('39', '21', 'fdd276e080f1421ca88cad8bb1cde1d6', '2018-09-25 10:05:35', '1');
INSERT INTO `login_ticket` VALUES ('40', '21', '9c2c0b7a1c734c2f960f7a54792134e0', '2018-09-25 10:08:12', '0');
INSERT INTO `login_ticket` VALUES ('41', '23', '60cb7f71553148c38644622da1716f8a', '2018-09-25 10:09:48', '0');
INSERT INTO `login_ticket` VALUES ('42', '21', 'd5dd75bfd9df4724acf7f3abd1641e9d', '2018-09-25 10:11:36', '1');
INSERT INTO `login_ticket` VALUES ('43', '21', '3a4cba6b987042faba3d0e70b2fd50e9', '2018-09-25 10:16:31', '1');
INSERT INTO `login_ticket` VALUES ('44', '23', 'e3e81edd198544798ebd39cb48f5d5ac', '2018-09-25 10:17:36', '1');
INSERT INTO `login_ticket` VALUES ('45', '24', '2a6ba60a27af455ea9381958b4f88599', '2018-09-25 12:53:08', '0');
INSERT INTO `login_ticket` VALUES ('46', '23', 'ede4b44710ce4382bc1bca825e5bbec8', '2018-09-25 14:23:43', '1');
INSERT INTO `login_ticket` VALUES ('47', '21', '5c03360642704e0eb61e5bbf7c321fa1', '2018-09-25 14:25:26', '0');
INSERT INTO `login_ticket` VALUES ('48', '25', '7bc29cb6b4114b4486b08e1379001822', '2018-09-26 16:36:26', '0');
INSERT INTO `login_ticket` VALUES ('49', '23', '180ecf71d87344d980d24d459292680b', '2018-09-26 22:02:32', '1');
INSERT INTO `login_ticket` VALUES ('50', '23', '2240cdf342304f8fa41b77266c6b3f35', '2018-09-27 13:57:56', '0');
INSERT INTO `login_ticket` VALUES ('51', '27', '530b814d7ba44a3e863fdf0f748d3ebf', '2018-09-28 22:55:15', '0');
INSERT INTO `login_ticket` VALUES ('52', '21', '315b21f7aa544457aee604b852dc89d0', '2018-10-01 13:04:06', '1');
INSERT INTO `login_ticket` VALUES ('53', '23', '3c7e78e30899496d9519541b448d55ed', '2018-10-03 12:39:36', '0');
INSERT INTO `login_ticket` VALUES ('54', '21', 'febb1045935e469abd1f6fdbc03546d1', '2018-10-03 12:57:29', '0');
INSERT INTO `login_ticket` VALUES ('55', '38', 'f2222b55a338473cb1a676c74bacb16e', '2020-03-12 17:38:25', '1');
INSERT INTO `login_ticket` VALUES ('56', '38', 'ae712ea24fe0404fabc682e1118624dd', '2020-03-12 17:54:46', '1');
INSERT INTO `login_ticket` VALUES ('57', '38', '9a32766f11c64c0ea7719181d21d318f', '2020-03-12 17:58:38', '1');
INSERT INTO `login_ticket` VALUES ('58', '38', 'c8846425d1db4e3c8dd63e7b5a511dbb', '2020-03-12 17:59:12', '1');
INSERT INTO `login_ticket` VALUES ('59', '39', 'ce7a3d24f60745428a2d162aa28c006a', '2020-03-13 11:17:49', '1');
INSERT INTO `login_ticket` VALUES ('60', '38', '4842483628fd4873b102e2a8e63afe8a', '2020-03-13 12:17:09', '0');
INSERT INTO `login_ticket` VALUES ('61', '39', '79e432e4afb54b7b8a1393a27ecc7860', '2020-03-13 12:17:30', '1');
INSERT INTO `login_ticket` VALUES ('62', '38', '48b7d5ea41644fc5bb62c0b3aa90f3ab', '2020-03-13 12:17:45', '1');
INSERT INTO `login_ticket` VALUES ('63', '38', '142972c884214443a38b6c95e25081dd', '2020-03-13 12:17:57', '1');
INSERT INTO `login_ticket` VALUES ('64', '38', '586d3baf1aeb4425acb7f3a597e36870', '2020-03-13 12:25:29', '1');
INSERT INTO `login_ticket` VALUES ('65', '38', 'ace598dafcd340db8cea5bea1728a0af', '2020-03-13 14:48:10', '1');
INSERT INTO `login_ticket` VALUES ('66', '38', '325df3ac78dc4040a9de3cdff792a024', '2020-03-13 14:58:03', '0');
INSERT INTO `login_ticket` VALUES ('67', '39', '733fb2ba8ed940c0bb5c4c4b0723ed47', '2020-03-13 14:58:20', '1');
INSERT INTO `login_ticket` VALUES ('68', '38', '11dcde03dff44dafa10c4e135c9a5ef8', '2020-03-13 14:58:25', '1');
INSERT INTO `login_ticket` VALUES ('69', '38', '32fb84a37da94899aaebbb8a885db920', '2020-03-13 14:58:43', '1');
INSERT INTO `login_ticket` VALUES ('70', '38', '8ae96cc6d5be4742a7a77d3c5fd87512', '2020-03-13 14:59:00', '1');
INSERT INTO `login_ticket` VALUES ('71', '38', 'c21a2b15d34d420eb9194a983e99eb53', '2020-03-13 19:58:50', '1');
INSERT INTO `login_ticket` VALUES ('72', '38', 'fbba4cdcc8d945d2a65438493bb7a04f', '2020-03-13 20:10:00', '1');
INSERT INTO `login_ticket` VALUES ('73', '38', '63a25ac94e9e438784dee57b3ce052ff', '2020-03-13 20:13:06', '0');
INSERT INTO `login_ticket` VALUES ('74', '38', '19d8380a60d947838a5608dfd455d70c', '2020-03-13 20:13:14', '0');
INSERT INTO `login_ticket` VALUES ('75', '40', '2ff5b59a58924a13a1b677fd87ac93e4', '2020-03-14 13:53:55', '0');
INSERT INTO `login_ticket` VALUES ('76', '40', 'fc3e61c6f498402693cb888992aaaaeb', '2020-03-14 14:08:02', '0');
INSERT INTO `login_ticket` VALUES ('77', '38', 'df8230e90a66481b8ebdfc57c548b28b', '2020-03-14 14:33:01', '0');
INSERT INTO `login_ticket` VALUES ('78', '41', 'b7fb4f9257bf4181acb7fe544a512f8a', '2020-03-14 15:04:49', '1');
INSERT INTO `login_ticket` VALUES ('79', '40', 'f5648b70c99e45eb84d4552c0138b59c', '2020-03-14 15:52:01', '0');
INSERT INTO `login_ticket` VALUES ('80', '40', 'eb181a01f0b14a02a5cab842dee1e8e8', '2020-03-19 19:15:26', '1');
INSERT INTO `login_ticket` VALUES ('81', '40', 'b7301a5cb0584fdfbf220a161c8c6265', '2020-03-19 19:22:56', '1');
INSERT INTO `login_ticket` VALUES ('82', '42', '1cd71cda7f8c473ebfd1d10112a7e4d9', '2020-03-19 19:26:21', '1');
INSERT INTO `login_ticket` VALUES ('83', '42', '6c5fdcd68f894d6abccbd15896160e3b', '2020-03-19 19:36:24', '0');
INSERT INTO `login_ticket` VALUES ('84', '42', '06c39392a4434a05a714b8f8c7326e2c', '2020-03-19 19:38:32', '0');
INSERT INTO `login_ticket` VALUES ('85', '42', '26dd54727dcf4cba927e0328b27a2143', '2020-03-19 20:23:47', '1');
INSERT INTO `login_ticket` VALUES ('86', '42', '980eba01410f45889db91d68b82dde1f', '2020-03-19 23:04:25', '1');
INSERT INTO `login_ticket` VALUES ('87', '42', '44852f95c06f4f508550ee582abce209', '2020-03-20 00:34:07', '1');
INSERT INTO `login_ticket` VALUES ('88', '42', '525a512134674a6193a4da41d4549a29', '2020-03-20 09:55:49', '1');
INSERT INTO `login_ticket` VALUES ('89', '42', '06aeb7511cf5465b990761c486e3cab0', '2020-03-20 15:40:38', '1');
INSERT INTO `login_ticket` VALUES ('90', '42', 'd9304854d20a462fa83235c3d0638c06', '2020-03-20 15:40:55', '1');
INSERT INTO `login_ticket` VALUES ('91', '42', '3679f82e231947079dcd175c65c00771', '2020-03-20 15:41:03', '1');
INSERT INTO `login_ticket` VALUES ('92', '42', 'd7cf02ffac614b2ab5047a742744ceb6', '2020-03-20 15:43:16', '1');
INSERT INTO `login_ticket` VALUES ('93', '40', '39849ed880bb462cb5ff32a6dd476386', '2020-03-20 15:52:11', '0');
INSERT INTO `login_ticket` VALUES ('94', '40', '5dd7da80347143b1bee5f110869f783b', '2020-03-20 15:52:20', '1');
INSERT INTO `login_ticket` VALUES ('95', '40', '4d556a9cba524645b0ab66ebd4232f0b', '2020-03-20 15:52:34', '0');
INSERT INTO `login_ticket` VALUES ('96', '40', 'e2e2a908fec447bc978ed6f3aed837e8', '2020-03-20 16:02:52', '0');
INSERT INTO `login_ticket` VALUES ('97', '42', '252f2b94fd694c748f630be6ce38242a', '2020-03-20 16:03:01', '0');
INSERT INTO `login_ticket` VALUES ('98', '42', '321db1f233bf4628a811935bfd538e7c', '2020-03-20 16:03:17', '0');
INSERT INTO `login_ticket` VALUES ('99', '42', 'f525a74c7a3e4c45bdf6df2b4489204c', '2020-03-20 16:03:21', '0');
INSERT INTO `login_ticket` VALUES ('100', '42', '060a41e66bbc4c15a37abe94246ff13d', '2020-03-20 16:03:30', '1');
INSERT INTO `login_ticket` VALUES ('101', '40', 'd047b62fb65c4227a960eacb36629d3b', '2020-03-20 16:04:16', '0');
INSERT INTO `login_ticket` VALUES ('102', '42', 'd872f70d3b4643a3a7c690ba71654e15', '2020-03-20 16:04:29', '0');
INSERT INTO `login_ticket` VALUES ('103', '41', '44507cb00e8e49f28935b0e255decc75', '2020-03-20 16:11:47', '0');
INSERT INTO `login_ticket` VALUES ('104', '40', '343750bb87f945e5aa7aa876013ae550', '2020-03-20 19:53:51', '1');
INSERT INTO `login_ticket` VALUES ('105', '42', '492e852e4c7045f989ecda2cee2da8d0', '2020-03-20 20:18:29', '0');
INSERT INTO `login_ticket` VALUES ('106', '42', 'a44abf2b57f545c8b13c72bb0b673923', '2020-03-20 20:21:01', '0');

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `from_id` int(11) DEFAULT NULL,
  `to_id` int(11) DEFAULT NULL,
  `content` text,
  `has_read` int(11) DEFAULT NULL,
  `conversation_id` varchar(45) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `conversation_index` (`conversation_id`),
  KEY `created_date` (`created_date`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES ('1', '20', '21', '小明，你在吗，我有个关于***的事情想问你，你怎么看？给我解答一下拜托了。', '1', '20_21', '2018-09-09 13:10:44');
INSERT INTO `message` VALUES ('2', '20', '21', '你怎麽不回復我消息啊，我生氣了。', '1', '20_21', '2018-09-09 13:32:23');
INSERT INTO `message` VALUES ('3', '21', '20', '知道了，有時間再和你私聊', '1', '20_21', '2018-09-09 13:45:01');
INSERT INTO `message` VALUES ('4', '21', '23', '等下私聊我，记得。', '1', '21_23', '2018-09-10 09:32:21');
INSERT INTO `message` VALUES ('5', '21', '23', '怎么还没回复我？', '1', '21_23', '2018-09-10 09:32:43');
INSERT INTO `message` VALUES ('6', '2', '23', '用户 小军 赞了你的评论, http://127.0.0.1:8080/question/20', '1', '2_23', '2018-09-10 13:56:39');
INSERT INTO `message` VALUES ('7', '2', '23', '用户 小军 赞了你的评论, &lt;a href=&quot;http://127.0.0.1:8080/question/20&quot;&gt;点击查看&lt;/a&gt;', '1', '2_23', '2018-09-10 14:13:48');
INSERT INTO `message` VALUES ('8', '2', '23', '用户 小军 赞了你的评论, <a href=\"http://127.0.0.1:8080/question/20\">点击查看该问题</a>', '1', '2_23', '2018-09-10 14:16:13');
INSERT INTO `message` VALUES ('9', '2', '23', '用户 小明 赞了你的评论, <a href=\"http://127.0.0.1:8080/question/20\">点击查看该问题</a>', '1', '2_23', '2018-09-10 14:25:31');
INSERT INTO `message` VALUES ('10', '23', '21', '知道啦', '1', '21_23', '2018-09-10 16:26:12');
INSERT INTO `message` VALUES ('11', '3', '21', '用户 小军 关注了您, <a href=\"http://127.0.0.1:8080/user/23\">点击查看该用户主页</a>', '1', '3_21', '2018-09-11 18:34:36');
INSERT INTO `message` VALUES ('21', '3', '21', '用户 小军 关注了您, <a href=\"http://localhost:8080/user/23\">点击查看该用户主页</a>', '1', '3_21', '2018-09-11 22:10:38');
INSERT INTO `message` VALUES ('23', '3', '21', '用户 小军 关注了您的问题, null <a href=\"http://localhost:8080/question/12\">点击查看</a>', '1', '3_21', '2018-09-11 22:18:06');
INSERT INTO `message` VALUES ('24', '3', '21', '用户 小军 关注了您的问题, null <a href=\"http://localhost:8080/question/12\">点击查看</a>', '1', '3_21', '2018-09-11 22:19:14');
INSERT INTO `message` VALUES ('25', '3', '21', '用户 小军 关注了您的问题, 爲什麽我打的字都是繁體字 <a href=\"http://localhost:8080/question/12\">点击查看</a>', '1', '3_21', '2018-09-11 22:20:01');
INSERT INTO `message` VALUES ('26', '3', '21', '用户 小军 关注了您的问题, 爲什麽我打的字都是繁體字 <a href=\"http://localhost:8080/question/12\">点击查看</a>', '1', '3_21', '2018-09-11 22:42:05');
INSERT INTO `message` VALUES ('27', '3', '21', '用户 小军 关注了您的问题 \" 爲什麽我打的字都是繁體字 \" <a href=\"http://localhost:8080/question/12\">点击查看</a>', '1', '3_21', '2018-09-11 22:42:33');
INSERT INTO `message` VALUES ('28', '3', '23', '用户 小明 关注了您的问题 \" 怎么评价《延禧攻略》中的角色魏璎珞？ \" <a href=\"http://localhost:8080/question/20\">点击查看</a>', '1', '3_23', '2018-09-11 22:43:10');
INSERT INTO `message` VALUES ('29', '3', '21', '用户 小军 关注了您, <a href=\"http://localhost:8080/user/23\">点击查看该用户主页</a>', '1', '3_21', '2018-09-11 23:48:49');
INSERT INTO `message` VALUES ('30', '3', '20', '用户 小军 关注了您, <a href=\"http://localhost:8080/user/23\">点击查看该用户主页</a>', '0', '3_20', '2018-09-12 00:05:30');
INSERT INTO `message` VALUES ('31', '3', '21', '用户 小军 关注了您, <a href=\"http://localhost:8080/user/23\">点击查看该用户主页</a>', '1', '3_21', '2018-09-12 00:05:49');
INSERT INTO `message` VALUES ('32', '3', '20', '用户 小军 关注了您的问题 \" 排名在前 1% 的高中生是靠天赋还是靠努力？ \" <a href=\"http://localhost:8080/question/19\">点击查看</a>', '0', '3_20', '2018-09-12 11:04:27');
INSERT INTO `message` VALUES ('33', '2', '20', '用户 小军 赞了你的评论, <a href=\"http://localhost:8080/question/19\">点击查看该问题</a>', '0', '2_20', '2018-09-12 11:04:30');
INSERT INTO `message` VALUES ('34', '2', '20', '用户 小军 赞了你的评论, <a href=\"http://localhost:8080/question/19\">点击查看该问题</a>', '0', '2_20', '2018-09-12 11:04:32');
INSERT INTO `message` VALUES ('35', '2', '0', '用户 小军 赞了你的评论, <a href=\"http://localhost:8080/question/19\">点击查看该问题</a>', '0', '0_2', '2018-09-12 11:04:32');
INSERT INTO `message` VALUES ('36', '2', '20', '用户 小军 赞了你的评论, <a href=\"http://localhost:8080/question/19\">点击查看该问题</a>', '0', '2_20', '2018-09-12 11:04:34');
INSERT INTO `message` VALUES ('37', '3', '20', '用户 小军 关注了您的问题 \" 在正式场合穿着正装如何避免被当做服务员？ \" <a href=\"http://localhost:8080/question/3\">点击查看</a>', '0', '3_20', '2018-09-12 13:20:39');
INSERT INTO `message` VALUES ('38', '2', '21', '用户 小军 赞了你的评论, <a href=\"http://localhost:8080/question/20\">点击查看该问题</a>', '0', '2_21', '2018-09-12 13:24:08');
INSERT INTO `message` VALUES ('39', '3', '21', '用户 小军 关注了您, <a href=\"/user/23\">点击查看该用户主页</a>', '0', '3_21', '2018-09-18 12:41:42');
INSERT INTO `message` VALUES ('40', '3', '21', '用户 小军 关注了您, <a href=\"/user/23\">点击查看该用户主页</a>', '0', '3_21', '2018-09-18 12:43:43');
INSERT INTO `message` VALUES ('41', '3', '21', '用户 小军 关注了您, <a href=\"/user/23\">点击查看该用户主页</a>', '0', '3_21', '2018-09-18 12:45:06');
INSERT INTO `message` VALUES ('42', '2', '21', '用户 小军 赞了你的评论, <a href=\"/question/11\">点击查看该问题</a>', '0', '2_21', '2018-09-18 12:49:12');
INSERT INTO `message` VALUES ('43', '2', '21', '用户 小军 赞了你的评论, <a href=\"/question/11\">点击查看该问题</a>', '0', '2_21', '2018-09-18 12:50:14');
INSERT INTO `message` VALUES ('44', '2', '21', '用户 小军 赞了你的评论, <a href=\"/question/11\">点击查看该问题</a>', '0', '2_21', '2018-09-18 12:53:15');
INSERT INTO `message` VALUES ('45', '2', '23', '用户 小明 赞了你的评论, <a href=\"http://117.48.200.9/question/20\">点击查看该问题</a>', '1', '2_23', '2018-09-18 12:57:57');
INSERT INTO `message` VALUES ('46', '38', '39', '123', '1', '38_39', '2020-02-27 11:18:56');
INSERT INTO `message` VALUES ('47', '39', '38', '我收到了', '1', '38_39', '2020-02-27 11:30:45');
INSERT INTO `message` VALUES ('48', '2', '39', '用户 zjfqqq 赞了你的评论, <a href=\"http://localhost:8080/question/72\">点击查看该问题</a>', '0', '2_39', '2020-02-27 11:36:33');
INSERT INTO `message` VALUES ('49', '2', '39', '用户 zjfqqq 赞了你的评论, <a href=\"http://localhost:8080/question/72\">点击查看该问题</a>', '0', '2_39', '2020-02-27 11:36:34');
INSERT INTO `message` VALUES ('50', '2', '39', '用户 zjfqqq 赞了你的评论, <a href=\"http://localhost:8080/question/72\">点击查看该问题</a>', '0', '2_39', '2020-02-27 11:36:35');
INSERT INTO `message` VALUES ('51', '2', '39', '用户 zjfqqq 赞了你的评论, <a href=\"http://localhost:8080/question/72\">点击查看该问题</a>', '0', '2_39', '2020-02-27 12:20:01');
INSERT INTO `message` VALUES ('52', '3', '39', '用户 zjfqqq 关注了您, <a href=\"http://localhost:8080/user/38\">点击查看该用户主页</a>', '0', '3_39', '2020-02-27 12:28:55');
INSERT INTO `message` VALUES ('53', '3', '39', '用户 zjfqqq 关注了您, <a href=\"http://localhost:8080/user/38\">点击查看该用户主页</a>', '0', '3_39', '2020-02-27 13:00:23');
INSERT INTO `message` VALUES ('54', '3', '26', '用户 zjfqqq 关注了您的问题 \" 为什么我那个当程序员的男朋友，一直特别想要一个机械键盘？ \" <a href=\"/question/71\">点击查看</a>', '0', '3_26', '2020-02-27 13:01:38');
INSERT INTO `message` VALUES ('55', '2', '38', '用户 zjfwww 赞了你的评论, <a href=\"http://localhost:8080/question/74\">点击查看该问题</a>', '0', '2_38', '2020-02-27 13:28:44');
INSERT INTO `message` VALUES ('56', '2', '40', '用户 刘德华 赞了你的评论, <a href=\"http://localhost:80/question/88\">点击查看该问题</a>', '0', '2_40', '2020-02-28 15:06:34');
INSERT INTO `message` VALUES ('57', '3', '41', '用户 吴彦祖 关注了您的问题 \" 有哪些你结婚后才明白的道理？ \" <a href=\"/question/97\">点击查看</a>', '0', '3_41', '2020-03-05 19:57:09');
INSERT INTO `message` VALUES ('58', '3', '42', '用户 吴彦祖 关注了您的问题 \" 00后的你现在有多少存款？ \" <a href=\"/question/95\">点击查看</a>', '0', '3_42', '2020-03-05 19:58:17');
INSERT INTO `message` VALUES ('59', '3', '42', '用户 吴彦祖 关注了您的问题 \" 小米这几年为什么要把华为作为重要对手看待？ \" <a href=\"/question/94\">点击查看</a>', '0', '3_42', '2020-03-05 19:58:23');
INSERT INTO `message` VALUES ('60', '3', '42', '用户 刘德华 关注了您的问题 \" 小米这几年为什么要把华为作为重要对手看待？ \" <a href=\"/question/94\">点击查看</a>', '0', '3_42', '2020-03-05 20:09:48');

-- ----------------------------
-- Table structure for question
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `content` text,
  `user_id` int(11) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `comment_count` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of question
-- ----------------------------
INSERT INTO `question` VALUES ('94', '小米这几年为什么要把华为作为重要对手看待？', '雷军总是说要战胜华为，可是我不理解，为什么不去打赢别的厂商呢', '42', '2020-03-05 19:48:53', '3');
INSERT INTO `question` VALUES ('95', '00后的你现在有多少存款？', '我02年的，昨天刚过17岁生日，数了数，手机上的钱加现金一共74', '42', '2020-03-05 19:50:42', '3');
INSERT INTO `question` VALUES ('96', '人是怎么废掉的？', '一个人是怎么一步一步变弱的？', '41', '2020-03-05 19:51:35', '3');
INSERT INTO `question` VALUES ('97', '有哪些你结婚后才明白的道理？', '自己28了，家里一直催婚，但我真不知道该选择什么样的人结婚。', '41', '2020-03-05 19:52:16', '2');
INSERT INTO `question` VALUES ('98', '程序员到底有没有女朋友？', '现实中的程序员到底是什么样的？真的是格子衬衫双肩包，把电脑当女朋友吗？真的这么可爱吗？', '40', '2020-03-05 19:54:56', '3');
INSERT INTO `question` VALUES ('99', '为什么最难不过二叉树的算法出现在面试题中都会被应聘者抱怨？', '为什么面试题比工作中遇到的算法简单那么多，而面试时面一下算法却让很多人义愤填膺呢？\n\n一般最难无非也就出到二叉树了，而且还不平衡，然后人们就啊啊啊⋯⋯。', '40', '2020-03-05 19:55:22', '3');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(64) DEFAULT NULL,
  `password` varchar(128) DEFAULT NULL,
  `salt` varchar(64) DEFAULT NULL,
  `head_url` varchar(128) DEFAULT NULL,
  `email` varchar(64) DEFAULT '',
  `status` int(11) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('40', '吴彦祖', '67D5B0882233FDAD97B1014E8429FE69', '5b9c6', 'https://images.nowcoder.com/head/994m.png', '1594899926@qq.com', '0');
INSERT INTO `user` VALUES ('41', '刘德华', '5B67F0A01C03B46A43E0911EBC184D4A', '5acad', 'https://images.nowcoder.com/head/686m.png', 'zhangjf233@163.com', '0');
INSERT INTO `user` VALUES ('42', 'admin', 'F79FFA79A4D2D14DCE36E4E21033765C', '3cfa6', 'https://images.nowcoder.com/head/257m.png', '565421368@qq.com', '0');
INSERT INTO `user` VALUES ('43', '张小凡', '67D5B0882233FDAD97B1014E8429FE69', '5b9c6', 'https://images.nowcoder.com/head/994m.png', '899926@qq.com', '0');
INSERT INTO `user` VALUES ('44', '李袁杰', '67D5B0882233FDAD97B1014E8429FE69', '5b9c6', 'https://images.nowcoder.com/head/257m.png', 'ngjf233@163.com', '0');
INSERT INTO `user` VALUES ('45', '袁世凯', '67D5B0882233FDAD97B1014E8429FE69', '5b9c6', 'https://images.nowcoder.com/head/257m.png', '524268@qq.com', '0');
INSERT INTO `user` VALUES ('46', '吴庆生', '67D5B0882233FDAD97B1014E8429FE69', '5b9c6', 'https://images.nowcoder.com/head/686m.png', '23145324@qq.com', '0');
