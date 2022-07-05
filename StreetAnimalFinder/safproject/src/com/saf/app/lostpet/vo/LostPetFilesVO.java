package com.saf.app.lostpet.vo;

public class LostPetFilesVO {
	private String fname;
	private String foriginal;
	private int lpnumber;
	
	public String getFileName() {
		return fname;
	}
	public void setFileName(String fileName) {
		this.fname = fileName;
	}
	public String getFileOriginal() {
		return foriginal;
	}
	public void setFileOriginal(String fileOriginal) {
		this.foriginal = fileOriginal;
	}
	public int getLpNumber() {
		return lpnumber;
	}
	public void setLpNumber(int lostpetNumber) {
		this.lpnumber = lostpetNumber;
	}
	
	public LostPetFilesVO(String fileName, String fileOriginal, int lostpetNnumber) {
		super();
		this.fname = fileName;
		this.foriginal = fileOriginal;
		this.lpnumber = lostpetNnumber;
	}
	
	public LostPetFilesVO() {
		
	}
}