package com.saf.app.board.vo;

public class BoardVO {

   private int bnumber;
   private String btitle;
   private String bcontent;
   private String burl;
   private String bdate;
   private int unum;
   private String bimage;
   private String buid;
   
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
   public String getBurl() {
      return burl;
   }
   public void setBurl(String burl) {
      this.burl= burl;
   }
   public String getBdate() {
      return bdate;
   }
   public void setBdate(String bdate) {
      this.bdate = bdate;
   }
   public int getUnum() {
      return unum;
   }
   public void setUnum(int unum) {
      this.unum = unum;
   }
   public String getBimage() {
      return bimage;
   }
   public void setBimage(String bimage) {
      this.bimage = bimage;
   }
   public String getBuid() {
	      return buid;
   }
   public void setBuid(String buid) {
	      this.buid = buid;
   }

   
   public BoardVO() {
      
   }
   
   public BoardVO(int bnumber, String btitle, String bcontent, String burl, String bdate, int unum, String bimage, String buid) {
      super();
      this.bnumber = bnumber;
      this.btitle = btitle;
      this.bcontent = bcontent;
      this.burl = burl;
      this.bdate = bdate;
      this.unum = unum;
      this.bimage = bimage;
      this.buid = buid;
   }

   
}