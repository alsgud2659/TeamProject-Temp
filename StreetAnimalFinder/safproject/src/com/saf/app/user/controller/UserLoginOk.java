package com.saf.app.user.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.saf.app.action.Action;
import com.saf.app.action.ActionForward;
import com.saf.app.user.dao.UserDAO;

public class UserLoginOk implements Action{

   @Override
   public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
      
      System.out.println("userloginok excute");
      
      req.setCharacterEncoding("UTF-8");
      resp.setCharacterEncoding("UTF-8");
      
      ActionForward forward = new ActionForward();
      UserDAO dao = new UserDAO();
      HttpSession session = req.getSession();
      
      
      String id = req.getParameter("id");
      String pw = req.getParameter("pw");
      
      System.out.println("id : " + id);
      System.out.println("pw : " + pw);
      
      int userNumber = dao.login(id,pw);
      
      forward.setRedirect(true);
      
      if(userNumber != 0) { //로그인 성공
         session.setAttribute("unum", userNumber);
         forward.setPath(req.getContextPath() + "/mainpage/main.jsp");
      
      }else {
         forward.setPath(req.getContextPath() + "/login/login.jsp?error=true");
      }
      
      return forward;
   }
}