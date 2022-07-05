package com.saf.app.user.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saf.app.action.ActionForward;

public class UserFrontController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	
	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String requestURI = req.getRequestURI();
		String contextPath = req.getContextPath();
		String command = requestURI.substring(contextPath.length());
		ActionForward af = null;
		
		if(command.equals("/user/controller/UserCheckIdOk.us")) {
			new UserCheckIdOk().execute(req, resp);
		}else if(command.equals("/user/controller/UserJoinOk.us")) {
			af = new UserJoinOk().execute(req, resp);
		}else if(command.equals("/user/controller/UserLoginOk.us")) {
	          System.out.println("login start");
	          af = new UserLoginOk().execute(req, resp);
		}else if(command.equals("/user/controller/UserLogout.us")) {
			af = new UserLogout().execute(req, resp);	
		}else if(command.equals("/user/controller/UserUpdateOk.us")) {
			af = new UserUpdateOk().execute(req, resp);
		}else if(command.equals("/user/controller/UserUpdate.us")) {
			af = new UserUpdate().execute(req, resp);
		}else if(command.equals("/user/controller/UserUpdateProfile.us")) {
			af = new UserUpdateProfile().execute(req, resp);
		}else if(command.equals("/user/controller/UserUpdateProfileOK.us")) {
			af = new UserUpdateProfileOK().execute(req, resp);
		}else if(command.equals("/user/controller/UserUpdatePwOK.us")) {
			af = new UserUpdatePwOK().execute(req, resp);
		}else if(command.equals("/user/controller/UserDelUserOK.us")) {
			af = new UserDelUserOK().execute(req, resp);
		}
		
		if(af != null) {
			if(af.isRedirect()) {
				//redirect
				resp.sendRedirect(af.getPath());
			}else {
				
				RequestDispatcher dispatcher = req.getRequestDispatcher(af.getPath());
				
				dispatcher.forward(req, resp);
			}
		}
	}
}
















