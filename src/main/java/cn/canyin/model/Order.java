package cn.canyin.model;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//通过微信扫描推送链接
	/**
	 * 用户扫描带场景值二维码时，可能推送以下两种事件： 
		1.如果用户还未关注公众号，则用户可以关注公众号，关注后微信会将带场景值关注事件推送给开发者。 
		2.如果用户已经关注公众号，在用户扫描后会自动进入会话，微信也会将带场景值扫描事件推送给开发者。 

	 * */
	
	private long 	o_id;
	private int 	o_seatnum;   //座位编号，扫描二维码是能自动填充吗？可以
	private String 	o_content;//订单内容，将食物信息，名称，分数，计量单位
	private String 	o_status;  //'订单状态，0：正在配送， 1：已送达. 订单创建后默认为正在配送，订单送达后状态改为1，有送达人员更改，客户负责创建，服务生负责更改状态',
	private String 	o_feedback;		//订单评价
	private String 	o_custwechatid; //订单微信， 扫描是自动填充
	private String 	o_custphone; //订单电话
	private String 	o_custaddress; //订单地址
	private Date  	createtime;
	private Date  	updatetime;
	private long    r_id; //商店ID
	private long    m_id; //菜单ID
	public long getO_id() {
		return o_id;
	}
	public void setO_id(long o_id) {
		this.o_id = o_id;
	}
	public int getO_seatnum() {
		return o_seatnum;
	}
	public void setO_seatnum(int o_seatnum) {
		this.o_seatnum = o_seatnum;
	}
	public String getO_content() {
		return o_content;
	}
	public void setO_content(String o_content) {
		this.o_content = o_content;
	}
	public String getO_status() {
		return o_status;
	}
	public void setO_status(String o_status) {
		this.o_status = o_status;
	}
	public String getO_feedback() {
		return o_feedback;
	}
	public void setO_feedback(String o_feedback) {
		this.o_feedback = o_feedback;
	}
	public String getO_custwechatid() {
		return o_custwechatid;
	}
	public void setO_custwechatid(String o_custwechatid) {
		this.o_custwechatid = o_custwechatid;
	}
	public String getO_custphone() {
		return o_custphone;
	}
	public void setO_custphone(String o_custphone) {
		this.o_custphone = o_custphone;
	}
	public String getO_custaddress() {
		return o_custaddress;
	}
	public void setO_custaddress(String o_custaddress) {
		this.o_custaddress = o_custaddress;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public Date getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	public long getR_id() {
		return r_id;
	}
	public void setR_id(long r_id) {
		this.r_id = r_id;
	}
	public long getM_id() {
		return m_id;
	}
	public void setM_id(long m_id) {
		this.m_id = m_id;
	}
	
	
	
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
