package com.saf.app.board.vo;

public class FilesVO {
	private String fname;
	private String foriginal;
	private int lpnumber;
	private int bnumber;
	private int unum;
	
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
	public int getUnum() {
		return unum;
	}
	public void setUnum(int unum) {
		this.unum = unum;
	}
	
	public FilesVO(String fname, String foriginal, int bnumber, int lpnumber, int unum) {
		super();
		this.fname = fname;
		this.foriginal = foriginal;
		this.lpnumber = lpnumber;
		this.bnumber = bnumber;
		this.unum = unum;
	}
	
	public FilesVO() {
		
	}
}