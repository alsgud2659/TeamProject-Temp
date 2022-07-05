package com.saf.app.lostpet.controller;


import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saf.app.action.Action;
import com.saf.app.action.ActionForward;
import com.saf.app.lostpet.dao.LostPetDAO;
import com.saf.app.lostpet.dao.LostPetReplyDAO;
import com.saf.app.lostpet.dao.FilesDAO; 

public class LostPetReplyDeleteOk implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		LostPetReplyDAO dao = new LostPetReplyDAO();
		
		dao.deleteReply(Integer.parseInt(req.getParameter("replyNumber")));
		
		return null;
	}

}
