package com.saf.app.user.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.saf.app.action.Action;
import com.saf.app.action.ActionForward;

public class UserLogout implements Action{
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		HttpSession session = req.getSession();
		ActionForward af = new ActionForward();
		
		session.invalidate();
		
		af.setRedirect(true);
		af.setPath(req.getContextPath() + "/user/UserLogin.me");
		
		return af;
	}
}
