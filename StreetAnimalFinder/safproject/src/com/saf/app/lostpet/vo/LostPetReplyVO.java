package com.saf.app.lostpet.vo;

public class LostPetReplyVO {
	private int rnumber;
	private String rcontent;
	private String rdate;
	private int lpnumber;
	private int bnumber;
	private int unum;
	
	public LostPetReplyVO() {;}

	public int getRnumber() {
		return rnumber;
	}

	public void setRnumber(int rnumber) {
		this.rnumber = rnumber;
	}

	public String getRcontent() {
		return rcontent;
	}

	public void setRcontent(String rcontent) {
		this.rcontent = rcontent;
	}

	public String getRdate() {
		return rdate;
	}

	public void setRdate(String rdate) {
		this.rdate = rdate;
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

	public LostPetReplyVO(int rnumber, String rcontent, String rdate, int lpnumber, int bnumber, int unum) {
		super();
		this.rnumber = rnumber;
		this.rcontent = rcontent;
		this.rdate = rdate;
		this.lpnumber = lpnumber;
		this.bnumber = bnumber;
		this.unum = unum;
	}
 
}
