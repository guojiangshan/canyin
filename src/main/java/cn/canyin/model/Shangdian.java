package cn.canyin.model;


import java.util.Date;


public class Shangdian implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6496873258477775627L;
	
	private long sd_id;
	private String mingcheng;
	private int zuoweishu; //座位数
	private String dizhi;//地址
	private String youbian;//邮编
	private String phone;//电话
	private String weixinid;//微信ID
	private String youxiang;//邮箱
	private Date 	createtime;//记录创建时间
	private Date    updatetime;//记录修改时间
	private String dianzhu;
	public long getSd_id() {
		return sd_id;
	}
	public void setSd_id(long sd_id) {
		this.sd_id = sd_id;
	}
	public String getMingcheng() {
		return mingcheng;
	}
	public void setMingcheng(String mingcheng) {
		this.mingcheng = mingcheng;
	}
	public int getZuoweishu() {
		return zuoweishu;
	}
	public void setZuoweishu(int zuoweishu) {
		this.zuoweishu = zuoweishu;
	}
	public String getDizhi() {
		return dizhi;
	}
	public void setDizhi(String dizhi) {
		this.dizhi = dizhi;
	}
	public String getYoubian() {
		return youbian;
	}
	public void setYoubian(String youbian) {
		this.youbian = youbian;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getWeixinid() {
		return weixinid;
	}
	public void setWeixinid(String weixinid) {
		this.weixinid = weixinid;
	}
	public String getYouxiang() {
		return youxiang;
	}
	public void setYouxiang(String youxiang) {
		this.youxiang = youxiang;
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
	public String getDianzhu() {
		return dianzhu;
	}
	public void setDianzhu(String dianzhu) {
		this.dianzhu = dianzhu;
	}

	
}
