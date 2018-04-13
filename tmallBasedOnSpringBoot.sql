-- 不用外键才是男人的浪漫

-- 权限表，与角色关联
DROP TABLE IF EXISTS `tmall_permission`;
CREATE TABLE `tmall_permission` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `permission_name` varchar(32) DEFAULT NULL COMMENT '权限名称',
  `role_id` bigint(19) DEFAULT NULL,
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限表';

-- 角色表
DROP TABLE IF EXISTS `tmall_role`;
CREATE TABLE `tmall_role` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `role_name` varchar(32) DEFAULT NULL COMMENT '角色名称',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';

-- 用户表
DROP TABLE IF EXISTS `tmall_user`;
CREATE TABLE `tmall_user` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_name` varchar(32) DEFAULT NULL COMMENT '权限管理人员名',
  `password` varchar(32) DEFAULT NULL COMMENT '密码',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';


-- 用户角色关系表
DROP TABLE IF EXISTS `tmall_user_role_map`;
CREATE TABLE `tmall_user_role_map` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `user_id` varchar(32) DEFAULT NULL COMMENT '角色名称',
  `role_id` bigint(19) DEFAULT NULL,
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色关系表';

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
  PRIMARY KEY(id)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='分类表';

-- 分类属性表
DROP TABLE IF EXISTS `tmall_property`;
CREATE TABLE `tmall_property` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `category_id` bigint(19) DEFAULT NULL COMMENT '分类ID',
  `property_name` VARCHAR(255) NOT NULL COMMENT '属性名称',
  PRIMARY KEY(id)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='分类属性表';

-- 商品表
DROP TABLE IF EXISTS `tmall_product`;
CREATE TABLE `tmall_product` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` VARCHAR(255) NOT NULL,
  `subTitle` VARCHAR(255) NOT NULL,
  `originalPrice` FLOAT NOT NULL,
  `promotePrice` FLOAT NOT NULL,
  `stock` INT NOT NULL,
  `category_id` bigint(19) DEFAULT NULL,
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY(id)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='商品表';

-- 图片url表
DROP TABLE IF EXISTS `tmall_image`;
CREATE TABLE `tmall_image` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `type` varchar(2) NOT NULL COMMENT '图片类型（0:首页滚动图 1:分类图 2:商品缩略图 3:商品详情图 )',
  `product_id` bigint(19) DEFAULT NULL COMMENT '类型为商品的依赖商品id',
  `category_id` bigint(19) DEFAULT NULL COMMENT '类型为分类的依赖分类id',
  `image_url` varchar(500) NOT NULL COMMENT '图片url地址',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY(id)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='图片url表';

-- 商品属性值表
DROP TABLE IF EXISTS `tmall_product_property`;
CREATE TABLE `tmall_product_property` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `category_id` bigint(19) DEFAULT NULL COMMENT '分类ID',
  `product_id` bigint(19) DEFAULT NULL COMMENT '商品ID',
  `property_id` bigint(19) DEFAULT NULL COMMENT '属性ID',
  `value` VARCHAR(255) NOT NULL COMMENT '属性值',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY(id)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='商品属性值表';

-- 订单表
DROP TABLE IF EXISTS `tmall_order`;
CREATE TABLE `tmall_order`(
  `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `customer_id` INT DEFAULT NULL COMMENT '顾客ID',
  `orderCode` VARCHAR(255) NOT NULL COMMENT '订单流水号',
  `order_address` VARCHAR(255) NOT NULL COMMENT '收货地址',
  `order_post` VARCHAR(255) NOT NULL COMMENT '发件人',
  `order_receiver` VARCHAR(255) NOT NULL COMMENT '收件人',
  `mobile` VARCHAR(255) NOT NULL COMMENT '联系方式',
  `userMessage` VARCHAR(255) NOT NULL COMMENT '备注消息',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `pay_time` datetime DEFAULT NULL COMMENT '支付时间',
  `delivery_time` datetime DEFAULT NULL COMMENT '发货时间',
  `confirm_time` datetime DEFAULT NULL COMMENT '收货时间',
  `order_status` VARCHAR(2) NOT NULL COMMENT '订单状态',
  PRIMARY KEY(id)
)ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT '订单表';