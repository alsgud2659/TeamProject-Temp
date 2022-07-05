package com.saf.app.board.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.saf.app.action.Action;
import com.saf.app.action.ActionForward;
import com.saf.app.user.dao.UserDAO;

public class BoardWrite implements Action{
   @Override
   public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
      
      HttpSession session = req.getSession();
      UserDAO uDao = new UserDAO();
      ActionForward af = new ActionForward();
      
    
      System.out.print(session.getAttribute("unum"));
      
      String buid = uDao.getUserInfo((Integer)session.getAttribute("unum")).getUid();
      
      System.out.print(buid);

      
      req.setAttribute("buid", buid);
      
      af.setRedirect(false);
      af.setPath("/board/new-write.jsp");
      
      return af;
   }
}



