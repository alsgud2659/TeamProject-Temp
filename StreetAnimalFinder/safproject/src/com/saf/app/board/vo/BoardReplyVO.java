package com.saf.app.board.vo;


public class BoardReplyVO {
private int rnumber;
private String rcontent;
private String rdate;
private int bnumber;

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
public int getBnumber() {
	return bnumber;
}
public void setBnumber(int bnumber) {
	this.bnumber = bnumber;
}

public BoardReplyVO() {
	
}

public BoardReplyVO(int rnumber, String rcontent, String rdate, int bnumber) {
	super();
	this.rnumber = rnumber;
	this.rcontent = rcontent;
	this.rdate = rdate;
	this.bnumber = bnumber;
}


}
