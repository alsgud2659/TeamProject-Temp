package com.saf.app.lostpet.vo;

// 나는 기존 테이블의 컬럼의 변형 또는 이외의 연산이 있을 경우에는
// 클래스이름 뒤에 DTO를 붙이겠다.
public class LostPetDTO {
	private int lpnumber;
	private String lparea1;
	private String lparea2;
	private String lparea3;
	private String lpspecies;
	private String lpgender;
	private String lpage;
	private String lpcolor;
	private String lpbreed;
	private int lpstatus;
	private String lptime;
	private String lpcontent;
	private int unum;
	
	public LostPetDTO() {;}

	public LostPetDTO(LostPetVO lostpetVO) {
		super();
		this.unum = lostpetVO.getUnum();
		this.lpnumber = lostpetVO.getLpnumber();
		this.lparea1 = lostpetVO.getLparea1();
		this.lparea2 = lostpetVO.getLparea2();
		this.lparea3 = lostpetVO.getLparea3();
		this.lpspecies = lostpetVO.getLpspecies();
		this.lpgender = lostpetVO.getLpgender();
		this.lpage= lostpetVO.getLpage();
		this.lpcolor = lostpetVO.getLpcolor();
		this.lpbreed = lostpetVO.getLpbreed();
		this.lpstatus = lostpetVO.getLpstatus();
		this.lptime = lostpetVO.getLptime();
		this.lpcontent = lostpetVO.getLpcontent();
	}

	public int getLpnumber() {
		System.out.println("dto 도착");
		return lpnumber;
	}

	public void setLpnumber(int lpnumber) {
		this.lpnumber = lpnumber;
	}

	public String getLparea1() {
		return lparea1;
	}

	public void setLparea1(String lparea1) {
		this.lparea1 = lparea1;
	}

	public String getLparea2() {
		return lparea2;
	}

	public void setLparea2(String lparea2) {
		this.lparea2 = lparea2;
	}

	public String getLparea3() {
		return lparea3;
	}

	public void setLparea3(String lparea3) {
		this.lparea3 = lparea3;
	}

	public String getLpspecies() {
		return lpspecies;
	}

	public void setLpspecies(String lpspecies) {
		this.lpspecies = lpspecies;
	}

	public String getLpgender() {
		return lpgender;
	}

	public void setLpgender(String lpgender) {
		this.lpgender = lpgender;
	}
	public String getLpage() {
		return lpage;
	}

	public void setLpage (String lpage) {
		this.lpage = lpage;
	}

	public String getLpcolor() {
		return lpcolor;
	}

	public void setLpcolor(String lpcolor) {
		this.lpcolor = lpcolor;
	}

	public String getLpbreed() {
		return lpbreed;
	}

	public void setLpbreed(String lpbreed) {
		this.lpbreed = lpbreed;
	}

	public int getLpstatus() {
		return lpstatus;
	}

	public void setLpstatus(int lpstatus) {
		this.lpstatus = lpstatus;
	}

	public String getLptime() {
		return lptime;
	}

	public void setLptime(String lptime) {
		this.lptime = lptime;
	}

	public String getLpcontent() {
		return lpcontent;
	}

	public void setLpcontent(String lpcontent) {
		this.lpcontent = lpcontent;
	}

	public int getUnum() {
		return unum;
	}

	public void setUnum(int unum) {
		this.unum = unum;
	}
}
