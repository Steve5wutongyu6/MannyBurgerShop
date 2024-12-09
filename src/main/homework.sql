SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `password` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, 'admin', 'admin');

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `cid` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `cname` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`cid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', '汉堡');
INSERT INTO `category` VALUES ('2', '炸鸡');
INSERT INTO `category` VALUES ('3', '薯条');
INSERT INTO `category` VALUES ('4', '饮品');

-- ----------------------------
-- Table structure for orderitem
-- ----------------------------
DROP TABLE IF EXISTS `orderitem`;
CREATE TABLE `orderitem`  (
  `itemid` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `count` int NULL DEFAULT NULL,
  `subtotal` double NULL DEFAULT NULL,
  `pid` int NULL DEFAULT NULL,
  `oid` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`itemid`) USING BTREE,
  INDEX `fk_0001`(`pid` ASC) USING BTREE,
  INDEX `fk_0002`(`oid` ASC) USING BTREE,
  CONSTRAINT `fk_0001` FOREIGN KEY (`pid`) REFERENCES `product` (`pid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_0002` FOREIGN KEY (`oid`) REFERENCES `orders` (`oid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of orderitem
-- ----------------------------

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `oid` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `ordertime` datetime NULL DEFAULT NULL,
  `total` double NULL DEFAULT NULL,
  `state` int NULL DEFAULT NULL,
  `address` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `name` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `telephone` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `uid` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`oid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of orders
-- ----------------------------

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `pid` int NOT NULL AUTO_INCREMENT,
  `pname` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `market_price` double NULL DEFAULT NULL,
  `shop_price` double NULL DEFAULT NULL,
  `pimage` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `pdate` date NULL DEFAULT NULL,
  `is_hot` int NULL DEFAULT NULL,
  `pdesc` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `pflag` int NULL DEFAULT NULL,
  `cid` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`pid`) USING BTREE,
  INDEX `sfk_0001`(`cid` ASC) USING BTREE,
  CONSTRAINT `sfk_0001` FOREIGN KEY (`cid`) REFERENCES `category` (`cid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 173 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES (133, '经典牛肉汉堡', 25, 20, 'img/foods/classic_burger.jpg', '2023-10-01', 1, '经典牛肉汉堡，搭配新鲜蔬菜和特制酱料。', 1, '1');
INSERT INTO `product` VALUES (134, '芝士培根汉堡', 30, 25, 'img/foods/cheese_burger.png', '2023-10-01', 1, '多汁牛肉饼，加上浓郁芝士和培根片。', 1, '1');
INSERT INTO `product` VALUES (135, '鸡肉汉堡', 22, 18, 'img/foods/classic_burger.jpg', '2023-10-01', 0, '鲜嫩多汁的鸡肉饼，搭配生菜和番茄。', 1, '1');
INSERT INTO `product` VALUES (136, '墨西哥风味汉堡', 28, 23, 'img/foods/classic_burger.jpg', '2023-10-01', 0, '墨西哥风味的牛肉饼，搭配辣椒和鳄梨酱。', 1, '1');
INSERT INTO `product` VALUES (137, '素食汉堡', 20, 16, 'img/foods/classic_burger.jpg', '2023-10-01', 0, '丰富的蔬菜和豆类制成的素食饼，健康美味。', 1, '1');
INSERT INTO `product` VALUES (138, '香辣炸鸡腿', 20, 16, 'img/foods/classic_burger.jpg', '2023-10-01', 1, '外酥里嫩，香辣可口的炸鸡腿。', 1, '2');
INSERT INTO `product` VALUES (139, '原味炸鸡块', 15, 12, 'img/foods/classic_burger.jpg', '2023-10-01', 0, '经典的原味炸鸡块，适合全家分享。', 1, '2');
INSERT INTO `product` VALUES (140, '蜜汁烤翅', 18, 14, 'img/foods/classic_burger.jpg', '2023-10-01', 0, '甜中带咸，蜜汁烤翅，口感独特。', 1, '2');
INSERT INTO `product` VALUES (141, '蒜香炸鸡排', 22, 18, 'img/foods/classic_burger.jpg', '2023-10-01', 0, '蒜香浓郁，外焦里嫩的炸鸡排。', 1, '2');
INSERT INTO `product` VALUES (142, '柠檬椒盐鸡米花', 16, 12, 'img/foods/classic_burger.jpg', '2023-10-01', 0, '酸爽柠檬搭配椒盐，口感清新。', 1, '2');
INSERT INTO `product` VALUES (143, '经典薯条', 10, 8, 'img/foods/classic_burger.jpg', '2023-10-01', 1, '金黄酥脆的经典薯条，搭配番茄酱。', 1, '3');
INSERT INTO `product` VALUES (144, '芝士薯条', 12, 10, 'img/foods/classic_burger.jpg', '2023-10-01', 0, '薯条上撒满浓郁芝士粉，更添风味。', 1, '3');
INSERT INTO `product` VALUES (145, '辣味薯条', 12, 10, 'img/foods/classic_burger.jpg', '2023-10-01', 0, '微辣口味的薯条，适合喜欢刺激的顾客。', 1, '3');
INSERT INTO `product` VALUES (146, '蒜香薯条', 13, 11, 'img/foods/classic_burger.jpg', '2023-10-01', 0, '蒜香浓郁的薯条，风味独特。', 1, '3');
INSERT INTO `product` VALUES (147, '薯条拼盘', 18, 15, 'img/foods/classic_burger.jpg', '2023-10-01', 0, '多种口味的薯条拼盘，满足不同需求。', 1, '3');
INSERT INTO `product` VALUES (148, '可乐', 8, 6, 'img/foods/classic_burger.jpg', '2023-10-01', 1, '经典可乐，清爽解渴。', 1, '4');
INSERT INTO `product` VALUES (149, '雪碧', 8, 6, 'img/foods/classic_burger.jpg', '2023-10-01', 0, '清新柠檬味的雪碧，口感细腻。', 1, '4');
INSERT INTO `product` VALUES (150, '橙汁', 12, 10, 'img/foods/classic_burger.jpg', '2023-10-01', 0, '纯天然橙汁，富含维生素C。', 1, '4');
INSERT INTO `product` VALUES (151, '冰红茶', 10, 8, 'img/foods/classic_burger.jpg', '2023-10-01', 0, '清凉解暑的冰红茶，回味无穷。', 1, '4');
INSERT INTO `product` VALUES (152, '咖啡', 15, 12, 'img/foods/classic_burger.jpg', '2023-10-01', 0, '香浓咖啡，提神醒脑。', 1, '4');
INSERT INTO `product` VALUES (153, '烟熏鸡肉堡', 26, 21, 'img/foods/classic_burger.jpg', '2023-11-01', 1, '烟熏鸡肉饼，搭配腌制蔬菜和特制酱料。', 1, '1');
INSERT INTO `product` VALUES (154, '墨西哥风味烤肉堡', 32, 27, 'img/foods/classic_burger.jpg', '2023-11-01', 0, '浓郁烤肉味道，墨西哥风味十足。', 1, '1');
INSERT INTO `product` VALUES (155, '双层芝士牛肉汉堡', 35, 30, 'img/foods/classic_burger.jpg', '2023-11-01', 1, '两片多汁牛肉饼，夹满芝士，香浓美味。', 1, '1');
INSERT INTO `product` VALUES (156, '素食蘑菇汉堡', 24, 19, 'img/foods/classic_burger.jpg', '2023-11-01', 0, '新鲜蘑菇和豆类制成的素食饼，健康又美味。', 1, '1');
INSERT INTO `product` VALUES (157, '黑椒牛柳堡', 30, 25, 'img/foods/classic_burger.jpg', '2023-11-01', 0, '嫩滑牛柳搭配黑胡椒酱，口感丰富。', 1, '1');
INSERT INTO `product` VALUES (158, '炭火烤鸡腿', 22, 18, 'img/foods/classic_burger.jpg', '2023-11-01', 1, '外焦里嫩，炭火烤制的美味鸡腿。', 1, '2');
INSERT INTO `product` VALUES (159, '辣味炸鸡块', 18, 14, 'img/foods/classic_burger.jpg', '2023-11-01', 0, '微辣口味的炸鸡块，适合喜欢刺激的顾客。', 1, '2');
INSERT INTO `product` VALUES (160, '蜂蜜芥末烤翅', 20, 16, 'img/foods/classic_burger.jpg', '2023-11-01', 0, '甜中带咸，蜂蜜芥末烤翅，口感独特。', 1, '2');
INSERT INTO `product` VALUES (161, '蒜蓉脆皮鸡排', 25, 20, 'img/foods/classic_burger.jpg', '2023-11-01', 0, '蒜蓉香味浓郁，外焦里嫩的脆皮鸡排。', 1, '2');
INSERT INTO `product` VALUES (162, '柠檬蒜香鸡米花', 18, 14, 'img/foods/classic_burger.jpg', '2023-11-01', 0, '酸爽柠檬搭配蒜香，口感清新。', 1, '2');
INSERT INTO `product` VALUES (163, '法式洋葱圈', 12, 10, 'img/foods/classic_burger.jpg', '2023-11-01', 1, '酥脆可口的法式洋葱圈，香气四溢。', 1, '3');
INSERT INTO `product` VALUES (164, '奶油薯条', 14, 12, 'img/foods/classic_burger.jpg', '2023-11-01', 0, '薯条上涂抹奶油酱，更加美味。', 1, '3');
INSERT INTO `product` VALUES (165, '麻辣薯条', 14, 12, 'img/foods/classic_burger.jpg', '2023-11-01', 0, '麻辣口味的薯条，适合喜欢刺激的顾客。', 1, '3');
INSERT INTO `product` VALUES (166, '芝士奶酪薯条', 15, 13, 'img/foods/classic_burger.jpg', '2023-11-01', 0, '撒满芝士奶酪粉的薯条，风味独特。', 1, '3');
INSERT INTO `product` VALUES (167, '薯条拼盘', 22, 18, 'img/foods/classic_burger.jpg', '2023-11-01', 0, '多种口味的薯条拼盘，满足不同需求。', 1, '3');
INSERT INTO `product` VALUES (168, '苹果汁', 10, 8, 'img/foods/classic_burger.jpg', '2023-11-01', 1, '纯天然苹果汁，清甜解渴。', 1, '4');
INSERT INTO `product` VALUES (169, '葡萄汁', 12, 10, 'img/foods/classic_burger.jpg', '2023-11-01', 0, '新鲜葡萄榨汁，果香浓郁。', 1, '4');
INSERT INTO `product` VALUES (170, '芒果汁', 14, 12, 'img/foods/classic_burger.jpg', '2023-11-01', 0, '热带风情的芒果汁，清爽解渴。', 1, '4');
INSERT INTO `product` VALUES (171, '草莓奶昔', 16, 14, 'img/foods/classic_burger.jpg', '2023-11-01', 0, '新鲜草莓制作的奶昔，甜蜜可口。', 1, '4');
INSERT INTO `product` VALUES (172, '抹茶奶昔', 16, 14, 'img/foods/classic_burger.jpg', '2023-11-01', 0, '清香抹茶奶昔，提神醒脑。', 1, '4');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `uid` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `username` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `password` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `name` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `email` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `telephone` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `birthday` date NULL DEFAULT NULL,
  `sex` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `state` int NULL DEFAULT NULL,
  `code` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'wutongyu', 'wutongyu', 'wutongyu', 'wutongyu@qzuie.edu.cn', '18016724785', '2004-07-03', '1', NULL, '1');
INSERT INTO `user` VALUES ('999', 'Xiaoming', 'xwuKzH4olLGFoOm', 'Carl', 'shixiaoming@qq.com', '14199683734', '2007-08-18', '0', NULL, '0');

SET FOREIGN_KEY_CHECKS = 1;
