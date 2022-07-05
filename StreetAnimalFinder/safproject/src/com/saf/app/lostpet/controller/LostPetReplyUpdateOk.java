package com.saf.app.lostpet.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saf.app.action.*;
import com.saf.app.lostpet.dao.*;
import com.saf.app.lostpet.vo.*; 


public class LostPetReplyUpdateOk implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		LostPetReplyVO reply = new LostPetReplyVO();
		LostPetReplyDAO dao = new LostPetReplyDAO();
		
		reply.setRnumber(Integer.parseInt(req.getParameter("replyNumber")));
		reply.setRcontent(req.getParameter("replyContent"));
		
		dao.updateReply(reply);
		
		return null;
	}

}
