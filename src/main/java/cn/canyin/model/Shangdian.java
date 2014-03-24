package cn.canyin.model;


import java.util.Date;


public class Shangdian implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6496873258477775627L;
	
	private long sd_id;
	private String sd_mingcheng;
	private String sd_zuoweishu; //座位数
	private String dizhi;//地址
	private String youbian;//邮编
	private String phone;//电话
	private String weixinid;//微信ID
	private String youxiang;//邮箱
	private Date 	createtime;//记录创建时间
	private Date    updatetime;//记录修改时间
	private String sd_dianzhu;
	public long getSd_id() {
		return sd_id;
	}
	public void setSd_id(long sd_id) {
		this.sd_id = sd_id;
	}
	public String getSd_mingcheng() {
		return sd_mingcheng;
	}
	public void setSd_mingcheng(String sd_mingcheng) {
		this.sd_mingcheng = sd_mingcheng;
	}
	public String getSd_zuoweishu() {
		return sd_zuoweishu;
	}
	public void setSd_zuoweishu(String sd_zuoweishu) {
		this.sd_zuoweishu = sd_zuoweishu;
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
	public String getSd_dianzhu() {
		return sd_dianzhu;
	}
	public void setSd_dianzhu(String sd_dianzhu) {
		this.sd_dianzhu = sd_dianzhu;
	}

	
	
}
