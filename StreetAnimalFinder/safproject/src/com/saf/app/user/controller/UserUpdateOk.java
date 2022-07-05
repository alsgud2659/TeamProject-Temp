package com.saf.app.user.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.saf.app.action.Action;
import com.saf.app.action.ActionForward;
import com.saf.app.user.dao.UserDAO;
import com.saf.app.user.vo.UserVO;

public class UserUpdateOk implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("UTF-8");
		
		HttpSession session = req.getSession();
		ActionForward af = new ActionForward();
		UserVO user = new UserVO();
		UserDAO dao = new UserDAO();
		
		user.setUnum((Integer)req.getSession().getAttribute("unum"));
		/*user.setUid(req.getParameter("uid"));*/
		user.setUname(req.getParameter("uname"));
		user.setUphone(req.getParameter("uphone"));
		user.setUemail(req.getParameter("uemail"));
		user.setUaddr1(req.getParameter("uaddr1"));
		user.setUaddr2(req.getParameter("uaddr2"));
		
		
		dao.updateUser(user);
		
		af.setRedirect(true);

		af.setPath(req.getContextPath()+"/user/controller/UserUpdate.us");
		
		return af;
	}
}
