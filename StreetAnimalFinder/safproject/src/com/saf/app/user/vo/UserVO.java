package com.saf.app.user.vo;

public class UserVO {

	private int unum;
	private String uid;
	private String upw;
	private String uphone;
	private String uimage;
	private String uname;
	private String uaddr1;
	private String uaddr2;
	private String uemail;
	private int ustatus;
	
	public int getUnum() {
		return unum;
	}
	public void setUnum(int unum) {
		this.unum = unum;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUpw() {
		return upw;
	}
	public void setUpw(String upw) {
		this.upw = upw;
	}
	public String getUphone() {
		return uphone;
	}
	public void setUphone(String uphone) {
		this.uphone = uphone;
	}
	public String getUimage() {
		return uimage;
	}
	public void setUimage(String uimage) {
		this.uimage = uimage;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUaddr1() {
		return uaddr1;
	}
	public void setUaddr1(String uaddr1) {
		this.uaddr1 = uaddr1;
	}
	public String getUaddr2() {
		return uaddr2;
	}
	public void setUaddr2(String uaddr2) {
		this.uaddr2 = uaddr2;
	}
	public String getUemail() {
		return uemail;
	}
	public void setUemail(String uemail) {
		this.uemail = uemail;
	}
	public int getUstatus() {
		return ustatus;
	}
	public void setUstatus(int ustatus) {
		this.ustatus = ustatus;
	}
	
	public UserVO() {
		
	}
	
	public UserVO(int unum, String uid, String upw, String uimage, String uphone, String uname, String uaddr1, String uaddr2, String uemail, int ustatus) {
		super();
		this.unum = unum;
		this.uid = uid;
		this.upw = upw;
		this.uimage = uimage;
		this.uphone = uphone;
		this.uname = uname;
		this.uaddr1 = uaddr1;
		this.uaddr2 = uaddr2;
		this.uemail = uemail;
		this.ustatus = ustatus;
	}
}