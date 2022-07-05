package com.saf.app.board.vo;

public class BoardReplyDTO {
   private int rnumber;
   private int bnumber;
   //private int userNumber;
   //private String userId;
   private String rdate;
   private String rcontent;
   private String unumber;
   private String uid;
   
   public BoardReplyDTO() {;}

   public int getRnumber() {
      return rnumber;
   }

   public void setRnumber(int rnumber) {
      this.rnumber = rnumber;
   }

   public int getBnumber() {
      return bnumber;
   }

   public void setBnumber(int bnumber) {
      this.bnumber = bnumber;
   }
/*
   public int getUserNumber() {
      return userNumber;
   }

   public void setUserNumber(int userNumber) {
      this.userNumber = userNumber;
   }
   
   public String getUserId() {
      return userId;
   }

   public void setUserId(String userId) {
      this.userId = userId;
   }
*/
   public String getRcontent() {
      return rcontent;
   }

   public void setRcontent(String rcontent) {
      this.rcontent = rcontent;
   }
   
   public String getUnumber() {
      return unumber;
   }

   public void setUnumber(String unumber) {
      this.unumber = unumber;
   }
   
   public String getUserId() {
      return uid;
   }

   public void setUid(String uid) {
      this.uid = uid;
   }
}