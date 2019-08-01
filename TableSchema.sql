create table `ibuki_admin_user` (
    `admin_id` bigint (20),
    `login_name` varchar (600),
    `login_password` varchar (150),
    `admin_nick_name` varchar (150),
    `locked` tinyint (4)
);

CREATE TABLE `ibuki_news_category` (
  `category_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '类别主键id',
  `category_name` varchar(200) NOT NULL DEFAULT '' COMMENT '类别名称',
  `is_deleted` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否已删除 0-未删除 1-已删除',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
