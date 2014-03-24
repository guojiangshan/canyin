package cn.canyin.model;

import java.io.Serializable;

public class Dingdan implements Serializable {
	//通过微信扫描推送链接
	/**
	 * 用户扫描带场景值二维码时，可能推送以下两种事件： 
		1.如果用户还未关注公众号，则用户可以关注公众号，关注后微信会将带场景值关注事件推送给开发者。 
		2.如果用户已经关注公众号，在用户扫描后会自动进入会话，微信也会将带场景值扫描事件推送给开发者。 

	 * */
	
	private long 	dd_id;
	private int 	dd_zhuoweihao;   //座位编号，扫描二维码是能自动填充吗？可以
	private String 	dd_neirong;//订单内容，将食物信息，名称，分数，计量单位
	private String 	dd_zhuangtai;  //'订单状态，0：正在配送， 1：已送达. 订单创建后默认为正在配送，订单送达后状态改为1，有送达人员更改，客户负责创建，服务生负责更改状态',
	private String 	dd_pingjia;		//订单评价
	private String 	dd_weixin; //订单微信， 扫描是自动填充
	private String 	dd_dianhua; //订单电话
	private String 	dd_dizhi; //订单地址
	private long    sd_id; //商店ID	
	
	
/*
DROP TABLE IF EXISTS `cy_db`.`cy_dingdan`;
CREATE TABLE  `cy_db`.`cy_dingdan` (
  `dd_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单ID',
  `dd_zuoweihao` int(5) NOT NULL AUTO_INCREMENT COMMENT '订单座位号',
  `dd_neirong` varchar(1024) DEFAULT NULL COMMENT '订单内容，订单食物，可多份，多样，如：1,1,两|2,2|3,1',
  `dd_zhuangtai` varchar(1) DEFAULT '0' COMMENT '订单状态，0：正在配送， 1：已送达. 订单创建后默认为正在配送，订单送达后状态改为1，有送达人员更改，客户负责创建，服务生负责更改状态',
  `dd_pingjia` varchar(1024) DEFAULT '0' COMMENT '客户的评价',
  `dd_weixin` varchar(100) DEFAULT '0' COMMENT '客户的评价',
  `dd_dianhua` varchar(18) DEFAULT '0' COMMENT '客户的评价',
  `dd_dizhi` varchar(100) DEFAULT '0' COMMENT '客户的评价',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `sd_id` long DEFAULT 1 COMMENT '商店ID',
  PRIMARY KEY (`dd_id`,`sd_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
*/
}
