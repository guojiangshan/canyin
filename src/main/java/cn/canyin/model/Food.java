package cn.canyin.model;

import java.io.Serializable;
import java.util.Date;

public class Food implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3333439134724672663L;
	private long f_id;		//食物ID
	private String f_name;//'食物名称',
	private String f__kind; //食物种类
	private float f_unitprise;	//单价
	private String f_unit; //'计量单位：两，份',
	private Date createtime;
	private Date updatetime;
	private long r_id;	//商店 id, 冗余字段
	private long m_id;//菜单ID
	public long getF_id() {
		return f_id;
	}
	public void setF_id(long f_id) {
		this.f_id = f_id;
	}
	public String getF_name() {
		return f_name;
	}
	public void setF_name(String f_name) {
		this.f_name = f_name;
	}
	public String getF__kind() {
		return f__kind;
	}
	public void setF__kind(String f__kind) {
		this.f__kind = f__kind;
	}
	public float getF_unitprise() {
		return f_unitprise;
	}
	public void setF_unitprise(float f_unitprise) {
		this.f_unitprise = f_unitprise;
	}
	public String getF_unit() {
		return f_unit;
	}
	public void setF_unit(String f_unit) {
		this.f_unit = f_unit;
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
	
	
	
}
