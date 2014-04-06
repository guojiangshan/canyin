/××商店表××/
DROP TABLE IF EXISTS `cy_db`.`cy_shangdian`;
DROP TABLE IF EXISTS cy_restaurant;
CREATE TABLE cy_restaurant (
  r_id int(11) NOT NULL AUTO_INCREMENT COMMENT '商店ID',
  r_name varchar(50) DEFAULT NULL COMMENT '商店名称',
  r_seatnum varchar(20) DEFAULT '0' COMMENT '商店座位数',
  r_adress varchar(200) DEFAULT NULL COMMENT '商店地址',
  r_post varchar(10) DEFAULT NULL COMMENT '商店邮编',
  r_phone varchar(18) DEFAULT NULL COMMENT '商店电话',
  r_wechatid varchar(50) DEFAULT NULL COMMENT '商店微信ID',
  r_mail varchar(50) DEFAULT NULL COMMENT '商店邮箱',
  create_time datetime DEFAULT NULL COMMENT '创建时间',
  update_time datetime DEFAULT NULL COMMENT '更新时间',
  r_owner varchar(50) DEFAULT NULL COMMENT '店主',
  r_status varchar(2) DEFAULT NULL COMMENT '状态:10,11, 20, 30  开业，优惠活动, 关门',   
  PRIMARY KEY (r_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into cy_restaurant(r_name, r_seatnum, r_adress,r_post,r_phone,r_wechatid,r_mail, create_time, update_time, r_owner,r_status) 
					values('月荷水饺',18,'玉兰香苑','201203','88888888','yuehesj','yh_mail@yh.com','2014/04/06','2014/04/06','梁家','01');
订单微信扫描， 推送链接到微信客户端，该链接带时间参数，3分钟再次访问的话就过期。
外卖的话，直接发送我要订餐到微信server
DROP TABLE IF EXISTS `cy_db`.`cy_caidan`;
CREATE TABLE cy_menu(
	m_id int(11) NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
	m_name varchar(40) DEFAULT NULL COMMENT '菜单名称',
	create_time datetime DEFAULT NULL COMMENT '创建时间',
	update_time datetime DEFAULT NULL COMMENT '更新时间',
	r_id int(11) UNSIGNED NOT NULL REFERENCES cy_restaurant(r_id),
	PRIMARY KEY (m_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into cy_menu(m_name, create_time, update_time, r_id) values('月荷水饺','2014/04/05','2014/04/05',1);
insert into cy_menu(m_name, create_time, update_time, r_id) values('月荷水饺','2014/04/05','2014/04/05',1);

DROP TABLE IF EXISTS `cy_db`.`cy_shiwu`;
CREATE TABLE  `cy_db`.`cy_food` (
	  `f_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '食物ID',
	  `f_name` varchar(50) DEFAULT NULL COMMENT '食物名称',
	  `f_kind` varchar(20) DEFAULT NULL COMMENT '食物类别',
	  `f_unitprice` decimal(8,2) DEFAULT NULL COMMENT '单价',
	  `f_unit` varchar(20) DEFAULT NULL COMMENT '计量单位：两，份',
	  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
	  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
	  PRIMARY KEY (`f_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into cy_food(f_name,f_kind,f_unitprice,f_unit,create_time, update_time) values('牛肉白菜水饺','水饺','5','两','2014/04/05','2014/04/05');
insert into cy_food(f_name,f_kind,f_unitprice,f_unit,create_time, update_time) values('牛肉芹菜水饺','水饺','5','两','2014/04/05','2014/04/05');
insert into cy_food(f_name,f_kind,f_unitprice,f_unit,create_time, update_time) values('猪肉白菜水饺','水饺','4','两','2014/04/05','2014/04/05');
insert into cy_food(f_name,f_kind,f_unitprice,f_unit,create_time, update_time) values('三鲜水饺','水饺','3','两','2014/04/05','2014/04/05');

DROP TABLE IF EXISTS cy_sdcdsw_map;  
DROP TABLE IF EXISTS cy_rmf_map;  
CREATE TABLE cy_rmf_map(
	  `r_id` int(10) unsigned NOT NULL ,
	  `m_id` int(10) unsigned NOT NULL ,
	  `f_id` int(11) unsigned NOT NULL  COMMENT '食物ID',
	  `f_unitprice` decimal(8,2) DEFAULT NULL COMMENT '单价',
	  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
	  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
	  PRIMARY KEY (f_id,r_id,m_id)

) ENGINE=InnoDB DEFAULT CHARSET=utf8;

	  --foreign key(r_id) EFERENCES cy_restaurant(r_id),
	  --foreign key(m_id) EFERENCES cy_menu(m_id),
	  --foreign key(f_id) EFERENCES cy_food(f_id)
insert into cy_rmf_map(r_id,m_id,f_id,f_unitprice,create_time,update_time) values(1,1,1,5,'2014/04/05','2014/04/05');
insert into cy_rmf_map(r_id,m_id,f_id,f_unitprice,create_time,update_time) values(1,1,2,5,'2014/04/05','2014/04/05');
insert into cy_rmf_map(r_id,m_id,f_id,f_unitprice,create_time,update_time) values(1,1,3,4,'2014/04/05','2014/04/05');
insert into cy_rmf_map(r_id,m_id,f_id,f_unitprice,create_time,update_time) values(1,1,4,3,'2014/04/05','2014/04/05');

DROP TABLE IF EXISTS `cy_db`.`cy_dingdan`;
CREATE TABLE  `cy_order` (
  `o_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单ID',
  `o_seatnum` int(5) NOT NULL  COMMENT '订单座位号,外卖：00000',
  `o_content` varchar(1024) DEFAULT NULL COMMENT '订单内容，订单食物，可多份，多样，如：1,1,两|2,2|3,1 （菜单|食物|分量|价格,菜单|食物|分量|价格）',
  `o_statu` varchar(1) DEFAULT '0' COMMENT '订单状态，0：正在配送， 1：已送达. 订单创建后默认为正在配送，订单送达后状态改为1，有送达人员更改，客户负责创建，服务生负责更改状态',
  `o_feedback` varchar(1024) DEFAULT '0' COMMENT '客户的评价',
  `o_custwechatid` varchar(100) DEFAULT '0' COMMENT '客户的评价',
  `o_custphone` varchar(18) DEFAULT '0' COMMENT '客户的评价',
  `o_custaddress` varchar(100) DEFAULT '0' COMMENT '客户的评价',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `r_id` int(10) DEFAULT 1 COMMENT '商店ID',
  `m_id` int(10) unsigned NOT NULL COMMENT '菜单 ID',
  PRIMARY KEY (`o_id`,`r_id`,`m_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
--同一个食物在不同的菜单上可能买不同的价格



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