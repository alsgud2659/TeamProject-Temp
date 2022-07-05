package com.saf.app.board.vo;

// 나는 기존 테이블의 컬럼의 변형 또는 이외의 연산이 있을 경우에는
// 클래스이름 뒤에 DTO를 붙이겠다.
public class BoardDTO {
	private int bnumber;
	private String btitle;
	private String bcontent;
	private int unum;
	private String bdate;
	private String bimage;
	//private String userId;
	//private int readCount;
	
	public BoardDTO() {;}

	public BoardDTO(BoardVO boardVO) {
		super();
		this.unum = boardVO.getUnum();
		this.bnumber = boardVO.getBnumber();
		this.btitle = boardVO.getBtitle();
		this.bcontent = boardVO.getBcontent();
		this.bdate = boardVO.getBdate();
		this.bimage = boardVO.getBimage();
		//this.readCount = boardVO.getReadCount();
	}

	public int getBnumber() {
		return bnumber;
	}

	public void setBnumber(int bnumber) {
		this.bnumber = bnumber;
	}

	public String getBtitle() {
		return btitle;
	}

	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}

	public String getBcontent() {
		return bcontent;
	}

	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}

	public int getUnum() {
		return unum;
	}

	public void setUnum(int unum) {
		this.unum = unum;
	}

	public String getBdate() {
		return bdate;
	}

	public void setBdate(String bdate) {
		this.bdate = bdate;
	}
	
	public String getBimage() {
		return bimage;
	}

	public void setBimage(String bimage) {
		this.bimage = bimage;
	}
	
	

	
}
