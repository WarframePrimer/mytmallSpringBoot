-- 不用外键才是男人的浪漫

SET FOREIGN_KEY_CHECKS=0;

-- 权限相关
-- 权限表，与角色关联
DROP TABLE IF EXISTS `admin_permission`;
CREATE TABLE `admin_permission` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `permission_name` varchar(32) DEFAULT NULL COMMENT '权限名称',
  `permission_action` varchar(255) DEFAULT NULL COMMENT '权限动作',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限表';

INSERT INTO `admin_permission` VALUES ('1', '商品添加', '/product/add');
INSERT INTO `admin_permission` VALUES ('2', '商品删除', '/product/del/*');

-- 角色表
DROP TABLE IF EXISTS `admin_role`;
CREATE TABLE `admin_role` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `role_name` varchar(32) DEFAULT NULL COMMENT '角色名称',
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';

INSERT INTO `admin_role` VALUES ('1', '超级管理员', '拥有至高无上的权力');
INSERT INTO `admin_role` VALUES ('2', '游客', '只是个过客');

-- 用户表
DROP TABLE IF EXISTS `admin_user`;
CREATE TABLE `admin_user` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `username` varchar(32) DEFAULT NULL COMMENT '权限管理用户名',
  `password` varchar(32) DEFAULT NULL COMMENT '密码',
  `phone` varchar(20) DEFAULT NULL COMMENT '注册手机号',
  `email` varchar(50) DEFAULT NULL COMMENT '注册邮箱',
  `state` int(11) DEFAULT '0' COMMENT '状态 0-正常 1-异常',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `role_id` int(19) DEFAULT '0',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`) USING BTREE,
  UNIQUE KEY `phone` (`phone`) USING BTREE,
  UNIQUE KEY `email` (`email`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='用户表';

INSERT INTO `admin_user` (
`id`,`username`,`password`,`phone`,`email`,`state`,`description`,`role_id`) VALUES
('1', 'admin', '123456', '18796002529', '18796002529@qq.com', '0', '超级管理员', '1');

-- 角色权限关系表
DROP TABLE IF EXISTS `admin_role_permission_map`;
CREATE TABLE `admin_role_permission_map` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `role_id` bigint(19) DEFAULT NULL COMMENT '角色ID',
  `permission_id` bigint(19) DEFAULT NULL COMMENT '权限ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色权限关系表';

INSERT INTO `admin_role_permission_map` VALUES ('1', '1', '1');
INSERT INTO `admin_role_permission_map` VALUES ('2', '1', '2');

-- 权限end

-- 前台相关
-- 顾客信息
DROP TABLE IF EXISTS `tmall_customer`;
CREATE TABLE `tmall_customer` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `customer_name` varchar(32) NOT NULL COMMENT '用户名',
  `password` varchar(32) DEFAULT NULL COMMENT '密码',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='顾客表';

-- 分类表
DROP TABLE IF EXISTS `tmall_category`;
CREATE TABLE `tmall_category` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `category_name` VARCHAR(255) NOT NULL COMMENT '分类名称',
  `status` int(1) DEFAULT '1' COMMENT '状态。可选值:1(正常),2(删除)',
  `icon` varchar(255) DEFAULT NULL COMMENT '分类图片',
  PRIMARY KEY(id)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='分类表';

-- 属性表
DROP TABLE IF EXISTS `tmall_property`;
CREATE TABLE `tmall_property` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `category_id` bigint(19) DEFAULT NULL COMMENT '分类ID',
  `property_name` VARCHAR(255) NOT NULL COMMENT '属性名称',
  `status` int(1) DEFAULT '1' COMMENT '状态。可选值:1(正常),2(删除)',
  PRIMARY KEY(id)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='属性表';

-- 商品表
DROP TABLE IF EXISTS `tmall_product`;
CREATE TABLE `tmall_product` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `product_name` VARCHAR(255) NOT NULL COMMENT '商品名',
  `product_title` VARCHAR(255) NOT NULL COMMENT '商品标题',
  `product_original_price` FLOAT NOT NULL COMMENT '商品优惠价格',
  `product_sale_price` FLOAT NOT NULL COMMENT '商品价格',
  `product_stock` INT NOT NULL COMMENT '商品库存',
  `category_id` bigint(19) DEFAULT NULL COMMENT '分类ID',
  `status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '商品状态，1-正常，2-下架，3-删除',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY(id),
  KEY `status` (`status`),
  KEY `updated` (`update_time`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='商品表';

-- 首页轮播图表
DROP TABLE IF EXISTS `tmall_carousel_image`;
CREATE TABLE `tmall_carousel_image` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `image_url` varchar(500) NOT NULL COMMENT '图片url地址',
  `link` varchar(255) DEFAULT NULL COMMENT '点击图片跳转地址',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY(id)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='首页轮播图表';

-- 商品图片表 缩略图 详情图
DROP TABLE IF EXISTS `tmall_product_image`;
CREATE TABLE `tmall_product_image` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `image_url` varchar(500) NOT NULL COMMENT '图片url地址',
  `image_type` varchar(2) DEFAULT '1' COMMENT '图片类型 1-缩略图 2-详情图',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY(id)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='商品图片表';

-- 商品属性值表 规格表
DROP TABLE IF EXISTS `tmall_product_property`;
CREATE TABLE `tmall_product_property` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `product_id` bigint(19) DEFAULT NULL COMMENT '商品ID',
  `category_id` bigint(19) DEFAULT NULL COMMENT '分类ID',
  `property_id` bigint(19) DEFAULT NULL COMMENT '属性ID',
  `value` VARCHAR(255) NOT NULL COMMENT '属性值',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY(id)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='商品属性值表规格表';

-- 订单表
DROP TABLE IF EXISTS `tmall_order`;
CREATE TABLE `tmall_order`(
  `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `customer_id` INT DEFAULT NULL COMMENT '顾客ID',
  `orderCode` VARCHAR(255) NOT NULL COMMENT '订单流水号',
  `order_address` VARCHAR(255) NOT NULL COMMENT '收货地址',
  `postalcode` VARCHAR(255) NOT NULL COMMENT '邮政编码',
  `order_receiver` VARCHAR(255) NOT NULL COMMENT '收件人',
  `mobile` VARCHAR(255) NOT NULL COMMENT '联系方式',
  `userMessage` VARCHAR(255) NOT NULL COMMENT '备注消息',
  `order_price` FLOAT DEFAULT NULL COMMENT '订单金额',
  `order_status` VARCHAR(2) NOT NULL COMMENT '订单状态 0-待付款 1-待发货 2-待收货 3-待评价',
  `is_comment` VARCHAR(2) DEFAULT '0' COMMENT '是否评论 0-未评价 1-已评价',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `pay_time` datetime DEFAULT NULL COMMENT '支付时间',
  `delivery_time` datetime DEFAULT NULL COMMENT '发货时间',
  `confirm_time` datetime DEFAULT NULL COMMENT '收货时间',
  PRIMARY KEY(id),
  KEY `create_time` (`create_time`),
  KEY `status` (`order_status`)
)ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT '订单表';

-- 订单详情表
DROP TABLE IF EXISTS `tmall_order_item`;
CREATE TABLE `tmall_order_item`(
  `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `order_id` bigint(19) DEFAULT NULL COMMENT '订单ID',
  `product_id` bigint(19) DEFAULT NULL COMMENT '商品ID',
  `customer_id` INT DEFAULT NULL COMMENT '顾客ID',
  `number` INT NOT NULL COMMENT '购买数量',
  `is_comment` VARCHAR(2) DEFAULT '0' COMMENT '是否评论 0-未评价 1-已评价',
  PRIMARY KEY(id)
)ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT '订单详情表';


-- 商品评价表
DROP TABLE IF EXISTS `tmall_product_review`;
CREATE TABLE `tmall_product_review`(
  `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `customer_id` INT DEFAULT NULL COMMENT '顾客ID',
  `product_id` INT DEFAULT NULL COMMENT '商品ID',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `review_content` VARCHAR(255) DEFAULT NULL COMMENT '评论商品内容',
  PRIMARY KEY(id)
)ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT '商品评价表';

