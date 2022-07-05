package com.saf.app.board.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saf.app.action.Action;
import com.saf.app.action.ActionForward;
import com.saf.app.board.dao.BoardDAO;
import com.saf.app.board.dao.FilesDAO;

public class BoardDetailOk implements Action {

   @Override
   public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
      req.setCharacterEncoding("UTF-8");
      resp.setCharacterEncoding("UTF-8");
      
      BoardDAO bDao = new BoardDAO();
      ActionForward af = new ActionForward();
      
      //사용자가 선택한 게시글 번호를 파라미터로 전달받는다.
      int bnumber = Integer.parseInt(req.getParameter("bnumber"));

      //게시글 번호로 조회한 게시글의 전체 정보를 requestScope에 저장한다.
      req.setAttribute("board", bDao.selectDetail(bnumber));

      
      
      //requestScope에 데이터를 담았기 때문에 forward로 페이지까지 req객체를 유지한다.
      af.setRedirect(false);
      af.setPath("/board/new-write-detail.jsp");
      
      return af;
   }

}