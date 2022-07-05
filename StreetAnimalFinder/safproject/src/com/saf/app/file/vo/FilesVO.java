package com.saf.app.file.vo;

public class FilesVO {
	private String fname;
	private String foriginal;
	private int lpnumber;
	private int bnumber;
	private String uid;
	
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getForiginal() {
		return foriginal;
	}
	public void setForiginal(String foriginal) {
		this.foriginal = foriginal;
	}
	public int getLpnumber() {
		return lpnumber;
	}
	public void setLpnumber(int lpnumber) {
		this.lpnumber = lpnumber;
	}
	public int getBnumber() {
		return bnumber;
	}
	public void setBnumber(int bnumber) {
		this.bnumber = bnumber;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	
	public FilesVO(String fname, String foriginal, int bnumber, int lpnumber, String uid) {
		super();
		this.fname = fname;
		this.foriginal = foriginal;
		this.lpnumber = lpnumber;
		this.bnumber = bnumber;
		this.uid = uid;
	}
	
	public FilesVO() {
		
	}
}