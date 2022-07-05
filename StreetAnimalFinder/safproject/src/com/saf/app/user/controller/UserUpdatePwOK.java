package com.saf.app.user.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.saf.app.action.Action;
import com.saf.app.action.ActionForward;
import com.saf.app.user.dao.UserDAO;
import com.saf.app.user.vo.UserVO;

public class UserUpdatePwOK implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("UTF-8");
		
		HttpSession session = req.getSession();
		ActionForward af = new ActionForward();
		UserVO user = new UserVO();
		UserDAO dao = new UserDAO();
		
		
		
//		String uid = "1";
//		
//		user.setUid(uid);
		user.setUnum((Integer)req.getSession().getAttribute("unum"));
		user.setUpw(req.getParameter("upw"));
		
		
		
		dao.updateUpw(user);
		
		af.setRedirect(true);

		af.setPath(req.getContextPath() + "/mypage/Userupdatepw.jsp");
		
		return af;
	}


}

