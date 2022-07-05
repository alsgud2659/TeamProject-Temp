package com.saf.app.user.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saf.app.action.Action;
import com.saf.app.action.ActionForward;
import com.saf.app.user.dao.UserDAO;

public class UserCheckIdOk implements Action{

   @Override
   public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws IOException{
      resp.setContentType("text/html; charset=utf-8");
      resp.setCharacterEncoding("UTF-8");
      String uid = req.getParameter("uid");
      UserDAO dao = new UserDAO();
      PrintWriter out = resp.getWriter();
      
      if(dao.checkId(uid)) {
         out.print("중복된 아이디입니다.");
      }else {
         out.print("사용가능한 아이디입니다.");
      }
      out.close();
      
      return null;
   }
}