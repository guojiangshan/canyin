CREATE DATABASE `cy_db` /*!40100 DEFAULT CHARACTER SET utf8 */;

DROP TABLE IF EXISTS `cy_db`.`cy_caidan`;
CREATE TABLE  `cy_db`.`cy_caidan` (
  `caidan_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `caidan_mingcheng` varchar(40) DEFAULT NULL COMMENT '菜单名称',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `sd_id` int(11) unsigned NOT NULL,
  PRIMARY KEY (`caidan_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*
DROP TABLE IF EXISTS `cy_db`.`cy_dingdan`;
CREATE TABLE  `cy_db`.`cy_dingdan` (
  `dd_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单ID',
  `dd_zuoweihao` int(11) NOT NULL DEFAULT '0' COMMENT '订单座位号,一份订单可以多个座位号:1|2|',
  `dd_shiwu` varchar(200) DEFAULT NULL COMMENT '订单食物，可多份，多样，如：1,1|2,2|3,1',
  `dd_zhuangtai` varchar(1) DEFAULT '0' COMMENT '订单状态，0：正在配送， 1：已送达. 订单创建后默认为正在配送，订单送达后状态改为1，有送达人员更改，客户负责创建，服务生负责更改状态',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `sd_zhuren` varchar(2) DEFAULT NULL COMMENT '店主',
  PRIMARY KEY (`dd_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
*/
DROP TABLE IF EXISTS `cy_db`.`cy_dingdan`;
CREATE TABLE  `cy_db`.`cy_dingdan` (
  `dd_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单ID',
  `dd_zuoweihao` int(5)  COMMENT '订单座位号',
  `dd_neirong` varchar(1024) DEFAULT NULL COMMENT '订单内容，订单食物，可多份，多样，如：1,1,两|2,2|3,1',
  `dd_zhuangtai` varchar(1) DEFAULT '0' COMMENT '订单状态，0：正在配送， 1：已送达. 订单创建后默认为正在配送，订单送达后状态改为1，有送达人员更改，客户负责创建，服务生负责更改状态,2结帐',
  `dd_pingjia` varchar(1024) DEFAULT null COMMENT '客户的评价',
  `dd_weixin` varchar(100) DEFAULT '0' COMMENT '客户的评价',
  `dd_dianhua` varchar(18) DEFAULT '0' COMMENT '客户的weixin',
  `dd_dizhi` varchar(100) DEFAULT '0' COMMENT 'dingdan 外送的dizhi',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `sd_id` int(11) DEFAULT 0  COMMENT '商店ID',
  PRIMARY KEY (`dd_id`,`sd_id`)   --联合主键
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `cy_db`.`cy_shangdian`;
CREATE TABLE  `cy_db`.`cy_shangdian` (
 `sd_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商店ID',
	`sd_mingcheng` varchar(200) DEFAULT NULL COMMENT '商店名称',
	`sd_zuoweishu` int DEFAULT '0' COMMENT '商店座位数',
	`sd_dizhi` varchar(200) DEFAULT NULL COMMENT '商店地址',
	`sd_youbian` varchar(10) DEFAULT NULL COMMENT '商店邮编',
	`sd_dianhua` varchar(18) DEFAULT NULL COMMENT '商店电话',
	`sd_weixinid` varchar(50) DEFAULT NULL COMMENT '商店微信ID',
	`sd_youxiang` varchar(50) DEFAULT NULL COMMENT '商店邮箱',
	`create_time` datetime DEFAULT NULL COMMENT '创建时间',
	`update_time` datetime DEFAULT NULL COMMENT '更新时间',
	`sd_zhuren` varchar(2) DEFAULT NULL COMMENT '店主',
	PRIMARY KEY (`sd_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into cy_shangdian values( null,'月荷水饺',16,'玉兰香苑3期广场','201203','88888888','yhshuijiao','yuehe@shuijiao.com','2012-01-01', '2012-01-01','梁家');

DROP TABLE IF EXISTS `cy_db`.`cy_shiwu`;
CREATE TABLE  `cy_db`.`cy_shiwu` (
	  `sw_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '食物ID',
	  `sw_mingchen` varchar(20) DEFAULT NULL COMMENT '食物名称',
	  `sw_zhonglei` varchar(20) DEFAULT NULL COMMENT '食物类别',
	  `sw_danjia` decimal(8,2) DEFAULT NULL COMMENT '单价',
	  `sw_jldw` varchar(20) DEFAULT NULL COMMENT '计量单位：两，份',
	  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
	  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
	  `sd_id` int(10) unsigned NOT NULL,
	  `candan_id` int(10) unsigned NOT NULL,
	  PRIMARY KEY (`sw_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


/*
kergp追寻  17:35:21
http://pan.baidu.com/s/1EgHA2
看看这个你能不能访问


E:\zhonglian\CanYin-www


3.16. Git config 
利用这个命令可以新增、更改Git的各种设置，例如 “git config branch.master.remote origin” 就将master的远程版本库设置为别名叫做origin版本库。 
https://github.com/guojiangshan/canyin


server：
jdk:java version "1.7.0_15"
database: mysql 5.6
tomcat 7.0
Apache Maven 3.0.5
版本控制：git
(github temp repository: https://github.com/guojiangshan/canyin)

本地（server端的，另外加上：）
开发工具：eclipse-jee-juno-SR2-win32-x86_64

相关资料空间：http://pan.baidu.com/s/1EgHA2


项目结构：
Spring MVC + Extjs + Jetty 

目前我在搭基本框架，
页面 ker在做

服务器端：梁勇
服务器端环境配置，
应用的部署

后台应用端：郭江山
数据库设计
应用框架的设计与搭建，
代码编程


前台UI：郭鹏
UI的设计与编写


另外
一个人加入到ui编程，一个java应用编程，再有就是团队的协调，进度的控制，文档的编写，


另外：carcia， weilly， peter

git push https://github.com/guojiangshan/canyin master


*/