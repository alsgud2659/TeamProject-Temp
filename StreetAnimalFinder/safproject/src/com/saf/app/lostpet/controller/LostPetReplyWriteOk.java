package com.saf.app.lostpet.controller;

import java.io.IOException; 

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.saf.app.action.Action;
import com.saf.app.action.ActionForward;
import com.saf.app.lostpet.dao.FilesDAO;
import com.saf.app.lostpet.dao.LostPetDAO;
import com.saf.app.lostpet.vo.LostPetVO;
import com.saf.app.lostpet.dao.LostPetReplyDAO;
import com.saf.app.lostpet.vo.LostPetReplyVO;

public class LostPetReplyWriteOk implements Action {
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		LostPetReplyVO reply = new LostPetReplyVO();
		LostPetReplyDAO dao = new LostPetReplyDAO();
		
		reply.setRcontent(req.getParameter("reply"));
		reply.setLpnumber(Integer.parseInt(req.getParameter("lpnumber")));
		//reply.setMemberNumber((Integer)req.getSession().getAttribute("unum"));
		reply.setUnum(1);
		dao.insertReply(reply);
		
		return null;
	}

}
