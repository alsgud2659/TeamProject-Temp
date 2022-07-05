package com.saf.app.board.controller;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.saf.app.action.Action;
import com.saf.app.action.ActionForward;
import com.saf.app.board.dao.BoardReplyDAO;
import com.saf.app.board.vo.BoardReplyDTO;

public class BoardReplyListOk implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		int boardNumber = Integer.parseInt(req.getParameter("bnumber"));
		//boardNumber 아닌듯??
		BoardReplyDAO rDao = new BoardReplyDAO();
		PrintWriter out = resp.getWriter();
		
		List<BoardReplyDTO> replyList = rDao.selectReplies(boardNumber);
		
		JSONArray replies = new JSONArray();

		for(BoardReplyDTO r : replyList) {
			JSONObject reply = new JSONObject();
			reply.put("replyNumber", r.getRnumber());
			reply.put("boardNumber", r.getBnumber());
			reply.put("userNumber", r.getUnumber());
			reply.put("userId", r.getUserId());
			reply.put("replyContent", r.getRcontent());
			replies.add(reply);
		}
		//for부분 수정 필요
		
		out.print(replies.toJSONString());
		out.close();
		
		return null;
	}

}
