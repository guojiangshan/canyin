package cn.canyin.model;


import java.util.Date;


public class Restaurant implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6496873258477775627L;
	
	private long r_id;
	private String r_name;
	private int r_totseatnum; //座位数
	private String r_adress;//地址
	private String r_post;//邮编
	private String r_phone;//电话
	private String r_wechatid;//微信ID
	private String r_mail;//邮箱
	private Date 	createtime;//记录创建时间
	private Date    updatetime;//记录修改时间
	private String r_owner;
	private String r_status;
	public long getR_id() {
		return r_id;
	}
	public void setR_id(long r_id) {
		this.r_id = r_id;
	}
	public String getR_name() {
		return r_name;
	}
	public void setR_name(String r_name) {
		this.r_name = r_name;
	}
	public int getR_totseatnum() {
		return r_totseatnum;
	}
	public void setR_totseatnum(int r_totseatnum) {
		this.r_totseatnum = r_totseatnum;
	}
	public String getR_adress() {
		return r_adress;
	}
	public void setR_adress(String r_adress) {
		this.r_adress = r_adress;
	}
	public String getR_post() {
		return r_post;
	}
	public void setR_post(String r_post) {
		this.r_post = r_post;
	}
	public String getR_phone() {
		return r_phone;
	}
	public void setR_phone(String r_phone) {
		this.r_phone = r_phone;
	}
	public String getR_wechatid() {
		return r_wechatid;
	}
	public void setR_wechatid(String r_wechatid) {
		this.r_wechatid = r_wechatid;
	}
	public String getR_mail() {
		return r_mail;
	}
	public void setR_mail(String r_mail) {
		this.r_mail = r_mail;
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
	public String getR_owner() {
		return r_owner;
	}
	public void setR_owner(String r_owner) {
		this.r_owner = r_owner;
	}
	public String getR_status() {
		return r_status;
	}
	public void setR_status(String r_status) {
		this.r_status = r_status;
	}
	
	
}
