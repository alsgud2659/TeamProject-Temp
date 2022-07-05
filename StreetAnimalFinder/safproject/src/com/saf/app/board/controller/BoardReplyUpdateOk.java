package com.saf.app.board.controller;

import java.io.IOException;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saf.app.action.Action;
import com.saf.app.action.ActionForward;
import com.saf.app.board.dao.BoardReplyDAO;
import com.saf.app.board.vo.BoardReplyVO;

public class BoardReplyUpdateOk implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		BoardReplyVO reply = new BoardReplyVO();
		BoardReplyDAO dao = new BoardReplyDAO();
		
		reply.setRnumber(Integer.parseInt(req.getParameter("rnumber")));
		reply.setRcontent(req.getParameter("rcontent"));
		
		dao.updateReply(reply);
		
		return null;
	}

}
