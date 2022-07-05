package com.saf.app.board.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saf.app.action.Action;
import com.saf.app.action.ActionForward;
import com.saf.app.board.dao.BoardDAO;

public class BoardUpdate implements Action{
   
   @Override
   public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {

      int page = Integer.parseInt(req.getParameter("page"));
      int bnumber = Integer.parseInt(req.getParameter("bnumber"));
      ActionForward af = new ActionForward();
      
      BoardDAO dao = new BoardDAO();
      
      // 회원의 번호로 게시글의 정보 뿐만 아니라 회원의 아이디까지 가져와주는 쿼리 실행
      req.setAttribute("board", dao.selectDetail(bnumber));
      req.setAttribute("page", page);
      
      af.setRedirect(false);
      af.setPath("/board/boardUpdate.jsp");
      
      return af;
   }
}