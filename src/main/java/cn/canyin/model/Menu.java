package cn.canyin.model;

import java.io.Serializable;
import java.util.Date;

import cn.canyin.util.StringUtil;

public class Menu implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8455920931563866437L;
	
	private long  m_id;
	private String m_name;
	private Date  createtime;
	private Date  updatetime;
	private long  r_id;
	/*
	  `caidan_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
	  `caidan_mingcheng` varchar(40) DEFAULT NULL COMMENT '菜单名称',
	  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
	  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
	  `sd_id` int(11) unsigned NOT NULL,
	*/
	
	
	public String toString(){
		return "[r_id="+r_id+
				",m_id="+m_id+
				",m_name="+m_name+
				",createtime="+StringUtil.dateFormat5(createtime)+
				",updatetime="+StringUtil.dateFormat5(updatetime)+"]";

	}


	public long getM_id() {
		return m_id;
	}


	public void setM_id(long m_id) {
		this.m_id = m_id;
	}


	public String getM_name() {
		return m_name;
	}


	public void setM_name(String m_name) {
		this.m_name = m_name;
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
	
	
}
