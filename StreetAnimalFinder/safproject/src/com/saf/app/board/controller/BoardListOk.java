package com.saf.app.board.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saf.app.action.Action;
import com.saf.app.action.ActionForward;
import com.saf.app.board.dao.BoardDAO;
import com.saf.app.board.vo.BoardVO;
import java.util.List;

public class BoardListOk implements Action {

   @Override
   public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
      req.setCharacterEncoding("UTF-8");
      resp.setCharacterEncoding("UTF-8");
      HashMap<String, Integer> boardMap = new HashMap<>();
      ActionForward af = new ActionForward();
      BoardDAO bDao = new BoardDAO();

      // 게시글 전체 정보
      List<BoardVO> boardList = bDao.selectAll(boardMap);

      req.setAttribute("boardList", boardList);

      af.setRedirect(false);
      af.setPath("/board/new-list.jsp");

      return af;
   }

}