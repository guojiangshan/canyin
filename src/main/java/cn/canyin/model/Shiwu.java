package cn.canyin.model;

import java.io.Serializable;
import java.util.Date;

public class Shiwu implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3333439134724672663L;
	private long sw_id;		//食物ID
	private String sw_mingcheng;//'食物名称',
	private String sw_zhonglei; //食物种类
	private float sw_danjia;	//单价
	private String sw_jldanwei; //'计量单位：两，份',
	private Date createtime;
	private Date updatetime;
	private long sd_id;	//商店 id, 冗余字段
	private long candan_id;//菜单ID
	public long getSw_id() {
		return sw_id;
	}
	public void setSw_id(long sw_id) {
		this.sw_id = sw_id;
	}
	public String getSw_mingcheng() {
		return sw_mingcheng;
	}
	public void setSw_mingcheng(String sw_mingcheng) {
		this.sw_mingcheng = sw_mingcheng;
	}
	public String getSw_zhonglei() {
		return sw_zhonglei;
	}
	public void setSw_zhonglei(String sw_zhonglei) {
		this.sw_zhonglei = sw_zhonglei;
	}
	public float getSw_danjia() {
		return sw_danjia;
	}
	public void setSw_danjia(float sw_danjia) {
		this.sw_danjia = sw_danjia;
	}
	public String getSw_jldanwei() {
		return sw_jldanwei;
	}
	public void setSw_jldanwei(String sw_jldanwei) {
		this.sw_jldanwei = sw_jldanwei;
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
	public long getCandan_id() {
		return candan_id;
	}
	public void setCandan_id(long candan_id) {
		this.candan_id = candan_id;
	}
	
	
}
