package cn.canyin.model;

import java.util.Date;

public class RMF_Map {

	private long r_id;
	private long m_id;
	private long f_id;
	private double f_unitprice;
	private String f_unit;
	private Date  createtime;
	private Date  updatetime;
	
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

	public long getF_id() {
		return f_id;
	}

	public void setF_id(long f_id) {
		this.f_id = f_id;
	}

	public double getF_unitprice() {
		return f_unitprice;
	}

	public void setF_unitprice(double f_unitprice) {
		this.f_unitprice = f_unitprice;
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

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
////*
//
////*DROP TABLE IF EXISTS cy_rmf_map;  
//CREATE TABLE cy_rmf_map(
//	  r_id int(10) unsigned NOT NULL ,
//	  m_id int(10) unsigned NOT NULL ,
//	  f_id int(11) unsigned NOT NULL  COMMENT '食物ID',
//	  f_unitprice decimal(8,2) DEFAULT NULL COMMENT '单价',
//	  create_time datetime DEFAULT NULL COMMENT '创建时间',
//	  update_time datetime DEFAULT NULL COMMENT '更新时间',
//	  PRIMARY KEY (f_id,r_id,m_id)
//
//) ENGINE=InnoDB DEFAULT CHARSET=utf8;
//
//	  --foreign key(r_id) EFERENCES cy_restaurant(r_id),
//	  --foreign key(m_id) EFERENCES cy_menu(m_id),
//	  --foreign key(f_id) EFERENCES cy_food(f_id)
//insert into cy_rmf_map(r_id,m_id,f_id,f_unitprice,create_time,update_time) values(1,1,1,5,'2014/04/05','2014/04/05');
//insert into cy_rmf_map(r_id,m_id,f_id,f_unitprice,create_time,update_time) values(1,1,2,5,'2014/04/05','2014/04/05');
//insert into cy_rmf_map(r_id,m_id,f_id,f_unitprice,create_time,update_time) values(1,1,3,4,'2014/04/05','2014/04/05');
//insert into cy_rmf_map(r_id,m_id,f_id,f_unitprice,create_time,update_time) values(1,1,4,3,'2014/04/05','2014/04/05');
//**//