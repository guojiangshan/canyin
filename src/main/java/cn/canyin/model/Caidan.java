package cn.canyin.model;

import java.io.Serializable;
import java.util.Date;

import cn.canyin.util.StringUtil;

public class Caidan implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8455920931563866437L;
	
	private long  caidan_id;
	private String caidan_mingcheng;
	private Date  createtime;
	private Date  updatetime;
	private long  sd_id;
	/*
	  `caidan_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
	  `caidan_mingcheng` varchar(40) DEFAULT NULL COMMENT '菜单名称',
	  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
	  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
	  `sd_id` int(11) unsigned NOT NULL,
	*/
	public long getCaidan_id() {
		return caidan_id;
	}
	public void setCaidan_id(long caidan_id) {
		this.caidan_id = caidan_id;
	}
	public String getCaidan_mingcheng() {
		return caidan_mingcheng;
	}
	public void setCaidan_mingcheng(String caidan_mingcheng) {
		this.caidan_mingcheng = caidan_mingcheng;
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
	public long getSd_id() {
		return sd_id;
	}
	public void setSd_id(long sd_id) {
		this.sd_id = sd_id;
	}
	
	public String toString(){
		return "[sd_id="+sd_id+
				",caidan_id="+caidan_id+
				",caidan_mingcheng="+caidan_mingcheng+
				",createtime="+StringUtil.dateFormat5(createtime)+
				",updatetime="+StringUtil.dateFormat5(updatetime)+"]";

	}
	
	
}
