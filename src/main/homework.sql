/*
 Navicat Premium Dump SQL

 Source Server         : 阿里云河源
 Source Server Type    : MySQL
 Source Server Version : 80036 (8.0.36)
 Source Host           : rm-f8z2sbii4xfjv9b5wso.mysql.rds.aliyuncs.com:3306
 Source Schema         : homework

 Target Server Type    : MySQL
 Target Server Version : 80036 (8.0.36)
 File Encoding         : 65001

 Date: 12/12/2024 13:18:43
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cart
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart`
(
    `cid`  int                                                           NOT NULL AUTO_INCREMENT,
    `uid`  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '下单用户ID',
    `oid`  int                                                           NULL DEFAULT NULL COMMENT '对应orderItemID',
    `time` datetime                                                      NULL DEFAULT NULL COMMENT '创建时间',
    PRIMARY KEY (`cid`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 4
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cart
-- ----------------------------
INSERT INTO `cart`
VALUES (1, '1', 1, '2024-12-10 17:52:35');
INSERT INTO `cart`
VALUES (2, '8800D33E3E7048A09BA78BAD5CBD5970', 2, '2024-12-10 18:01:35');
INSERT INTO `cart`
VALUES (3, '1', NULL, '2024-12-10 18:01:35');

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`
(
    `cid`   varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
    `cname` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
    PRIMARY KEY (`cid`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8mb3
  COLLATE = utf8mb3_general_ci
  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category`
VALUES ('1', '汉堡');
INSERT INTO `category`
VALUES ('2', '炸鸡');
INSERT INTO `category`
VALUES ('3', '薯条');
INSERT INTO `category`
VALUES ('4', '饮品');

-- ----------------------------
-- Table structure for orderitem
-- ----------------------------
DROP TABLE IF EXISTS `orderitem`;
CREATE TABLE `orderitem`
(
    `oid` int                                                           NOT NULL,
    `pid` int                                                           NULL DEFAULT NULL,
    `uid` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
    PRIMARY KEY (`oid`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 7
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of orderitem
-- ----------------------------
INSERT INTO `orderitem`
VALUES (1, 135, '1');
INSERT INTO `orderitem`
VALUES (2, 133, '8800D33E3E7048A09BA78BAD5CBD5970');
INSERT INTO `orderitem`
VALUES (3, 134, '8800D33E3E7048A09BA78BAD5CBD5970');
INSERT INTO `orderitem`
VALUES (4, 151, '8800D33E3E7048A09BA78BAD5CBD5970');
INSERT INTO `orderitem`
VALUES (5, 151, '8800D33E3E7048A09BA78BAD5CBD5970');
INSERT INTO `orderitem`
VALUES (6, 154, '8800D33E3E7048A09BA78BAD5CBD5970');

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`
(
    `pid`          int                                                           NOT NULL AUTO_INCREMENT,
    `pname`        varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci  NULL DEFAULT NULL,
    `market_price` double                                                        NULL DEFAULT NULL,
    `shop_price`   double                                                        NULL DEFAULT NULL,
    `pimage`       varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
    `pdate`        date                                                          NULL DEFAULT NULL,
    `is_hot`       int                                                           NULL DEFAULT NULL,
    `pdesc`        varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
    `pflag`        int                                                           NULL DEFAULT NULL,
    `cid`          varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci  NULL DEFAULT NULL,
    PRIMARY KEY (`pid`) USING BTREE,
    INDEX `sfk_0001` (`cid` ASC) USING BTREE,
    CONSTRAINT `sfk_0001` FOREIGN KEY (`cid`) REFERENCES `category` (`cid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB
  AUTO_INCREMENT = 210
  CHARACTER SET = utf8mb3
  COLLATE = utf8mb3_general_ci
  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product`
VALUES (133, '经典牛肉汉堡', 25, 20, 'image/foods/classic_burger.png', '2023-10-01', 1,
        '经典牛肉汉堡，搭配新鲜蔬菜和特制酱料。', 1, '1');
INSERT INTO `product`
VALUES (134, '芝士培根汉堡', 30, 25, 'image/foods/classic_burger.png', '2023-10-01', 1,
        '多汁牛肉饼，加上浓郁芝士和培根片。', 1, '1');
INSERT INTO `product`
VALUES (135, '鸡肉汉堡', 22, 18, 'image/foods/classic_burger.png', '2023-10-01', 0, '鲜嫩多汁的鸡肉饼，搭配生菜和番茄。',
        1, '1');
INSERT INTO `product`
VALUES (136, '墨西哥风味汉堡', 28, 23, 'image/foods/classic_burger.png', '2023-10-01', 0,
        '墨西哥风味的牛肉饼，搭配辣椒和鳄梨酱。', 1, '1');
INSERT INTO `product`
VALUES (137, '素食汉堡', 20, 16, 'image/foods/classic_burger.png', '2023-10-01', 0,
        '丰富的蔬菜和豆类制成的素食饼，健康美味。', 1, '1');
INSERT INTO `product`
VALUES (138, '香辣炸鸡腿', 20, 16, 'image/foods/classic_chicken.png', '2023-10-01', 1, '外酥里嫩，香辣可口的炸鸡腿。', 1,
        '2');
INSERT INTO `product`
VALUES (139, '原味炸鸡块', 15, 12, 'image/foods/classic_chicken.png', '2023-10-01', 1, '经典的原味炸鸡块，适合全家分享。',
        1, '2');
INSERT INTO `product`
VALUES (140, '蜜汁烤翅', 18, 14, 'image/foods/classic_chicken.png', '2023-10-01', 0, '甜中带咸，蜜汁烤翅，口感独特。', 1,
        '2');
INSERT INTO `product`
VALUES (141, '蒜香炸鸡排', 22, 18, 'image/foods/classic_chicken.png', '2023-10-01', 0, '蒜香浓郁，外焦里嫩的炸鸡排。', 1,
        '2');
INSERT INTO `product`
VALUES (142, '柠檬椒盐鸡米花', 16, 12, 'image/foods/classic_chicken.png', '2023-10-01', 1, '酸爽柠檬搭配椒盐，口感清新。',
        1, '2');
INSERT INTO `product`
VALUES (143, '经典薯条', 10, 8, 'image/foods/classic_chips.png', '2023-10-01', 1, '金黄酥脆的经典薯条，搭配番茄酱。', 1,
        '3');
INSERT INTO `product`
VALUES (144, '芝士薯条', 12, 10, 'image/foods/classic_chips.png', '2023-10-01', 0, '薯条上撒满浓郁芝士粉，更添风味。', 1,
        '3');
INSERT INTO `product`
VALUES (145, '辣味薯条', 12, 10, 'image/foods/classic_chips.png', '2023-10-01', 1, '微辣口味的薯条，适合喜欢刺激的顾客。',
        1, '3');
INSERT INTO `product`
VALUES (146, '蒜香薯条', 13, 11, 'image/foods/classic_chips.png', '2023-10-01', 1, '蒜香浓郁的薯条，风味独特。', 1, '3');
INSERT INTO `product`
VALUES (147, '薯条拼盘', 18, 15, 'image/foods/classic_chips.png', '2023-10-01', 0, '多种口味的薯条拼盘，满足不同需求。',
        1, '3');
INSERT INTO `product`
VALUES (148, '可乐', 8, 6, 'image/foods/classic_drink.png', '2023-10-01', 1, '经典可乐，清爽解渴。', 1, '4');
INSERT INTO `product`
VALUES (149, '雪碧', 8, 6, 'image/foods/classic_drink1.png', '2023-10-01', 1, '清新柠檬味的雪碧，口感细腻。', 1, '4');
INSERT INTO `product`
VALUES (150, '橙汁', 12, 10, 'image/foods/classic_drink2.png', '2023-10-01', 1, '纯天然橙汁，富含维生素C。', 1, '4');
INSERT INTO `product`
VALUES (151, '冰红茶', 10, 8, 'image/foods/classic_drink3.png', '2023-10-01', 1, '清凉解暑的冰红茶，回味无穷。', 1, '4');
INSERT INTO `product`
VALUES (152, '咖啡', 15, 12, 'image/foods/classic_drink.png', '2023-10-01', 0, '香浓咖啡，提神醒脑。', 1, '4');
INSERT INTO `product`
VALUES (153, '烟熏鸡肉堡', 26, 21, 'image/foods/classic_burger.png', '2023-11-01', 1,
        '烟熏鸡肉饼，搭配腌制蔬菜和特制酱料。', 1, '1');
INSERT INTO `product`
VALUES (154, '墨西哥风味烤肉堡', 32, 27, 'image/foods/classic_burger.png', '2023-11-01', 1,
        '浓郁烤肉味道，墨西哥风味十足。', 1, '1');
INSERT INTO `product`
VALUES (155, '双层芝士牛肉汉堡', 35, 30, 'image/foods/classic_burger.png', '2023-11-01', 1,
        '两片多汁牛肉饼，夹满芝士，香浓美味。', 1, '1');
INSERT INTO `product`
VALUES (157, '黑椒牛柳堡', 30, 25, 'image/foods/classic_burger.png', '2023-11-01', 0, '嫩滑牛柳搭配黑胡椒酱，口感丰富。',
        1, '1');
INSERT INTO `product`
VALUES (158, '炭火烤鸡腿', 22, 18, 'image/foods/classic_chicken.png', '2023-11-01', 1, '外焦里嫩，炭火烤制的美味鸡腿。',
        1, '2');
INSERT INTO `product`
VALUES (159, '辣味炸鸡块', 18, 14, 'image/foods/classic_chicken.png', '2023-11-01', 0,
        '微辣口味的炸鸡块，适合喜欢刺激的顾客。', 1, '2');
INSERT INTO `product`
VALUES (160, '蜂蜜芥末烤翅', 20, 16, 'image/foods/classic_chicken.png', '2023-11-01', 0,
        '甜中带咸，蜂蜜芥末烤翅，口感独特。', 1, '2');
INSERT INTO `product`
VALUES (161, '蒜蓉脆皮鸡排', 25, 20, 'image/foods/classic_chicken.png', '2023-11-01', 0,
        '蒜蓉香味浓郁，外焦里嫩的脆皮鸡排。', 1, '2');
INSERT INTO `product`
VALUES (162, '柠檬蒜香鸡米花', 18, 14, 'image/foods/classic_chicken.png', '2023-11-01', 0, '酸爽柠檬搭配蒜香，口感清新。',
        1, '2');
INSERT INTO `product`
VALUES (163, '法式洋葱圈', 12, 10, 'image/foods/classic_chips.png', '2023-11-01', 1, '酥脆可口的法式洋葱圈，香气四溢。',
        1, '3');
INSERT INTO `product`
VALUES (164, '奶油薯条', 14, 12, 'image/foods/classic_chips.png', '2023-11-01', 0, '薯条上涂抹奶油酱，更加美味。', 1,
        '3');
INSERT INTO `product`
VALUES (165, '麻辣薯条', 14, 12, 'image/foods/classic_chips.png', '2023-11-01', 0, '麻辣口味的薯条，适合喜欢刺激的顾客。',
        1, '3');
INSERT INTO `product`
VALUES (166, '芝士奶酪薯条', 15, 13, 'image/foods/classic_chips.png', '2023-11-01', 0, '撒满芝士奶酪粉的薯条，风味独特。',
        1, '3');
INSERT INTO `product`
VALUES (167, '薯条拼盘', 22, 18, 'image/foods/classic_chips.png', '2023-11-01', 0, '多种口味的薯条拼盘，满足不同需求。',
        1, '3');
INSERT INTO `product`
VALUES (168, '苹果汁', 10, 8, 'image/foods/classic_drink.png', '2023-11-01', 1, '纯天然苹果汁，清甜解渴。', 1, '4');
INSERT INTO `product`
VALUES (169, '葡萄汁', 12, 10, 'image/foods/classic_drink.png', '2023-11-01', 0, '新鲜葡萄榨汁，果香浓郁。', 1, '4');
INSERT INTO `product`
VALUES (170, '芒果汁', 14, 12, 'image/foods/classic_drink.png', '2023-11-01', 0, '热带风情的芒果汁，清爽解渴。', 1, '4');
INSERT INTO `product`
VALUES (171, '草莓奶昔', 16, 14, 'image/foods/classic_drink.png', '2023-11-01', 0, '新鲜草莓制作的奶昔，甜蜜可口。', 1,
        '4');
INSERT INTO `product`
VALUES (172, '牛肉芝士汉堡', 30, 25, 'image/foods/classic_burger.png', '2024-01-01', 1, '多汁牛肉饼搭配浓郁芝士和生菜。',
        1, '1');
INSERT INTO `product`
VALUES (173, '素食芝士汉堡', 22, 18, 'image/foods/classic_burger.png', '2024-01-01', 0,
        '丰富的蔬菜和豆类制成的素食饼，加入芝士。', 1, '1');
INSERT INTO `product`
VALUES (174, '墨西哥风味鸡肉堡', 28, 23, 'image/foods/classic_burger.png', '2024-01-01', 0,
        '墨西哥风味的鸡肉饼，搭配辣椒和鳄梨酱。', 1, '1');
INSERT INTO `product`
VALUES (175, '烟熏牛肉汉堡', 26, 21, 'image/foods/classic_burger.png', '2024-01-01', 1,
        '烟熏牛肉饼，搭配腌制蔬菜和特制酱料。', 1, '1');
INSERT INTO `product`
VALUES (176, '双层鸡肉汉堡', 32, 27, 'image/foods/classic_burger.png', '2024-01-01', 1,
        '两片鲜嫩鸡肉饼，夹满芝士，香浓美味。', 1, '1');
INSERT INTO `product`
VALUES (177, '蒜蓉烤鸡腿', 22, 18, 'image/foods/classic_chicken.png', '2024-01-01', 1, '外焦里嫩，蒜蓉烤制的美味鸡腿。',
        1, '2');
INSERT INTO `product`
VALUES (178, '辣味炸鸡排', 18, 14, 'image/foods/classic_chicken.png', '2024-01-01', 0,
        '微辣口味的炸鸡排，适合喜欢刺激的顾客。', 1, '2');
INSERT INTO `product`
VALUES (179, '蜂蜜芥末烤翅', 20, 16, 'image/foods/classic_chicken.png', '2024-01-01', 0,
        '甜中带咸，蜂蜜芥末烤翅，口感独特。', 1, '2');
INSERT INTO `product`
VALUES (180, '蒜蓉脆皮鸡排', 25, 20, 'image/foods/classic_chicken.png', '2024-01-01', 0,
        '蒜蓉香味浓郁，外焦里嫩的脆皮鸡排。', 1, '2');
INSERT INTO `product`
VALUES (181, '柠檬蒜香鸡米花', 18, 14, 'image/foods/classic_chicken.png', '2024-01-01', 0, '酸爽柠檬搭配蒜香，口感清新。',
        1, '2');
INSERT INTO `product`
VALUES (182, '法式洋葱圈', 12, 10, 'image/foods/classic_chips.png', '2024-01-01', 1, '酥脆可口的法式洋葱圈，香气四溢。',
        1, '3');
INSERT INTO `product`
VALUES (183, '奶油薯条', 14, 12, 'image/foods/classic_chips.png', '2024-01-01', 0, '薯条上涂抹奶油酱，更加美味。', 1,
        '3');
INSERT INTO `product`
VALUES (184, '麻辣薯条', 14, 12, 'image/foods/classic_chips.png', '2024-01-01', 0, '麻辣口味的薯条，适合喜欢刺激的顾客。',
        1, '3');
INSERT INTO `product`
VALUES (185, '芝士奶酪薯条', 15, 13, 'image/foods/classic_chips.png', '2024-01-01', 0, '撒满芝士奶酪粉的薯条，风味独特。',
        1, '3');
INSERT INTO `product`
VALUES (186, '苹果汁', 10, 8, 'image/foods/classic_drink.png', '2024-01-01', 1, '纯天然苹果汁，清甜解渴。', 1, '4');
INSERT INTO `product`
VALUES (187, '葡萄汁', 12, 10, 'image/foods/classic_drink.png', '2024-01-01', 0, '新鲜葡萄榨汁，果香浓郁。', 1, '4');
INSERT INTO `product`
VALUES (188, '芒果汁', 14, 12, 'image/foods/classic_drink.png', '2024-01-01', 0, '热带风情的芒果汁，清爽解渴。', 1, '4');
INSERT INTO `product`
VALUES (189, '草莓奶昔', 16, 14, 'image/foods/classic_drink.png', '2024-01-01', 0, '新鲜草莓制作的奶昔，甜蜜可口。', 1,
        '4');
INSERT INTO `product`
VALUES (190, '经典培根汉堡', 25, 20, 'image/foods/classic_burger.png', '2024-01-01', 1,
        '经典培根汉堡，搭配新鲜蔬菜和特制酱料。', 1, '1');
INSERT INTO `product`
VALUES (191, '香辣鸡肉汉堡', 30, 25, 'image/foods/classic_burger.png', '2024-01-01', 1,
        '多汁鸡肉饼，加上浓郁芝士和培根片。', 1, '1');
INSERT INTO `product`
VALUES (192, '蘑菇鸡肉堡', 22, 18, 'image/foods/classic_burger.png', '2024-01-01', 0,
        '鲜嫩多汁的鸡肉饼，搭配生菜和番茄。', 1, '1');
INSERT INTO `product`
VALUES (193, '韩式风味汉堡', 28, 23, 'image/foods/classic_burger.png', '2024-01-01', 0,
        '韩式风味的牛肉饼，搭配泡菜和特制酱料。', 1, '1');
INSERT INTO `product`
VALUES (194, '素食鸡肉汉堡', 20, 16, 'image/foods/classic_burger.png', '2024-01-01', 0,
        '丰富的蔬菜和豆类制成的素食饼，健康美味。', 1, '1');
INSERT INTO `product`
VALUES (195, '香辣炸鸡腿', 20, 16, 'image/foods/classic_chicken.png', '2024-01-01', 1, '外酥里嫩，香辣可口的炸鸡腿。', 1,
        '2');
INSERT INTO `product`
VALUES (196, '原味炸鸡块', 15, 12, 'image/foods/classic_chicken.png', '2024-01-01', 1, '经典的原味炸鸡块，适合全家分享。',
        1, '2');
INSERT INTO `product`
VALUES (197, '蜜汁烤翅', 18, 14, 'image/foods/classic_chicken.png', '2024-01-01', 0, '甜中带咸，蜜汁烤翅，口感独特。', 1,
        '2');
INSERT INTO `product`
VALUES (198, '蒜香炸鸡排', 22, 18, 'image/foods/classic_chicken.png', '2024-01-01', 0, '蒜香浓郁，外焦里嫩的炸鸡排。', 1,
        '2');
INSERT INTO `product`
VALUES (199, '柠檬椒盐鸡米花', 16, 12, 'image/foods/classic_chicken.png', '2024-01-01', 1, '酸爽柠檬搭配椒盐，口感清新。',
        1, '2');
INSERT INTO `product`
VALUES (200, '经典薯条', 10, 8, 'image/foods/classic_chips.png', '2024-01-01', 1, '金黄酥脆的经典薯条，搭配番茄酱。', 1,
        '3');
INSERT INTO `product`
VALUES (201, '芝士薯条', 12, 10, 'image/foods/classic_chips.png', '2024-01-01', 0, '薯条上撒满浓郁芝士粉，更添风味。', 1,
        '3');
INSERT INTO `product`
VALUES (202, '辣味薯条', 12, 10, 'image/foods/classic_chips.png', '2024-01-01', 1, '微辣口味的薯条，适合喜欢刺激的顾客。',
        1, '3');
INSERT INTO `product`
VALUES (203, '蒜香薯条', 13, 11, 'image/foods/classic_chips.png', '2024-01-01', 1, '蒜香浓郁的薯条，风味独特。', 1, '3');
INSERT INTO `product`
VALUES (204, '薯条拼盘', 18, 15, 'image/foods/classic_chips.png', '2024-01-01', 0, '多种口味的薯条拼盘，满足不同需求。',
        1, '3');
INSERT INTO `product`
VALUES (205, '可乐', 8, 6, 'image/foods/classic_drink.png', '2024-01-01', 1, '经典可乐，清爽解渴。', 1, '4');
INSERT INTO `product`
VALUES (206, '雪碧', 8, 6, 'image/foods/classic_drink1.png', '2024-01-01', 1, '清新柠檬味的雪碧，口感细腻。', 1, '4');
INSERT INTO `product`
VALUES (207, '橙汁', 12, 10, 'image/foods/classic_drink2.png', '2024-01-01', 1, '纯天然橙汁，富含维生素C。', 1, '4');
INSERT INTO `product`
VALUES (208, '冰红茶', 10, 8, 'image/foods/classic_drink3.png', '2024-01-01', 1, '清凉解暑的冰红茶，回味无穷。', 1, '4');
INSERT INTO `product`
VALUES (209, '咖啡', 15, 12, 'image/foods/classic_drink.png', '2024-01-01', 0, '香浓咖啡，提神醒脑。', 1, '4');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`
(
    `uid`        varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci  NOT NULL,
    `username`   varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci  NULL DEFAULT NULL,
    `password`   varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci  NULL DEFAULT NULL,
    `name`       varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci  NULL DEFAULT NULL,
    `email`      varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci  NULL DEFAULT NULL,
    `telephone`  varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci  NULL DEFAULT NULL,
    `birthday`   date                                                          NULL DEFAULT NULL,
    `sex`        varchar(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci  NULL DEFAULT NULL,
    `state`      int                                                           NULL DEFAULT NULL,
    `code`       varchar(64) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci  NULL DEFAULT NULL,
    `photo_path` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户头像图片路径',
    PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8mb3
  COLLATE = utf8mb3_general_ci
  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user`
VALUES ('04F3456401124DCDA35ABF0433BDE55C', 'imagetest', 'imagetest', 'imagetest', 'imagetest@imagetest.com',
        '12345678', '1979-11-11', '0', 1, NULL, NULL);
INSERT INTO `user`
VALUES ('1', 'wutongyu', 'wutongyu', 'wutongyu', 'wutongyu@qzuie.edu.cn', '13721244948', '2004-07-03', '1', 1, '1',
        NULL);
INSERT INTO `user`
VALUES ('11D5F2A53545474E8AE40985597397DE', 'www', 'www', 'www', 'www@www.com', '123456', '1944-11-11', '1', 1, NULL,
        NULL);
INSERT INTO `user`
VALUES ('1C2EB6BB966E41CD9EE30D5BA6548171', '111', '111', '111', '111@111.com', '111', '1111-11-11', '1', 1, NULL,
        NULL);
INSERT INTO `user`
VALUES ('2', 'Xiaoming', 'xwuKzH4olLGFoOm', 'Carl', 'shixiaoming@qq.com', '14199683734', '2007-08-18', '0', 1, '0',
        NULL);
INSERT INTO `user`
VALUES ('8800D33E3E7048A09BA78BAD5CBD5970', 'Steve5wutongyu6', 'rEfyFGrddqP59NQ', 'Steve5wutongyu6',
        'Steve5wutongyu6@163.com', '13721244948', '2004-07-03', '1', 1, '1', NULL);
INSERT INTO `user`
VALUES ('AEE04F51C3704BC9AAA0E9F301E21CB8', '12345678', '12345678', '12345678', '12345678@qq.com', '12345678',
        '1999-12-31', '0', 1, NULL, NULL);
INSERT INTO `user`
VALUES ('DB58652DA5E54E7BAB43A02791A1A158', '123', '123', '123', '123@123.com', '123', '1954-11-11', '0', 1, NULL,
        NULL);
INSERT INTO `user`
VALUES ('E708B46D611E48B1B4C694B37884D10B', 'test', 'test1', 'test', 't@t.com', '1234567', '2020-02-01', '1', 1, NULL,
        NULL);

-- ----------------------------
-- View structure for hotest_ham
-- ----------------------------
DROP VIEW IF EXISTS `hotest_ham`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `hotest_ham` AS
select `product`.`pid`          AS `pid`,
       `product`.`pname`        AS `pname`,
       `product`.`market_price` AS `market_price`,
       `product`.`shop_price`   AS `shop_price`,
       `product`.`pimage`       AS `pimage`,
       `product`.`pdate`        AS `pdate`,
       `product`.`is_hot`       AS `is_hot`,
       `product`.`pdesc`        AS `pdesc`,
       `product`.`pflag`        AS `pflag`,
       `product`.`cid`          AS `cid`
from `product`
where ((`product`.`is_hot` = 1) and (`product`.`cid` = 1))
limit 4;

SET FOREIGN_KEY_CHECKS = 1;
