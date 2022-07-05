package com.saf.app.lostpet.controller;
import static java.lang.System.out;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saf.app.action.ActionForward;

public class LostPetFrontController extends HttpServlet {
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
		
		if(command.equals("/lostpet/controller/LostPetListOk.lo")) {
			System.out.print("도착했니");
			af = new LostPetListOk().execute(req, resp); 
			
			
		}else if(command.equals("/lostpet/controller/LostPetDetailOk.lo")) {
			af = new LostPetDetailOk().execute(req, resp);
			
		}else if(command.equals("/lostpet/controller/LostPetDeleteOk.lo")) {
			af = new LostPetDeleteOk().execute(req, resp);
			
		}else if(command.equals("/lostpet/controller/LostPetReplyDeleteOk.lo")) {
			af = new LostPetReplyDeleteOk().execute(req, resp);
		
		}else if(command.equals("/lostpet/controller/LostPetReplyListOk.lo")) {
			af = new LostPetReplyListOk().execute(req, resp);
			
		}else if(command.equals("/lostpet/controller/LostPetReplyUpdateOk.lo")) {
			af = new LostPetReplyUpdateOk().execute(req, resp);
			
		}else if(command.equals("/lostpet/controller/LostPetReplyWriteOk.lo")) {
			af = new LostPetReplyWriteOk().execute(req, resp);
			
		}else if(command.equals("/lostpet/controller/LostPetUpdate.lo")) {
			System.out.println("프컨");
			af = new LostPetUpdate().execute(req, resp);
			
		}else if(command.equals("/lostpet/controller/LostPetUpdateOk.lo")) {
			System.out.println("프컨");
			af = new LostPetUpdateOk().execute(req, resp);
			
		}else if(command.equals("/lostpet/controller/LostPetWrite.lo")) {
			af = new LostPetWrite().execute(req, resp);
			
		}else if(command.equals("/lostpet/controller/LostPetWriteOk.lo")) {
			System.out.println("프론트컨트롤러 도착");
			af = new LostPetWriteOk().execute(req, resp);
		}else if(command.equals("/lostpet/controller/FileDownloadOk.lo")) {
			af = new LostPetWriteOk().execute(req, resp);
		}
		
		//분기 별 결과를 af에 담았다면 여기로 내려온다.
		
		//전송안할지
		if(af != null) {// af가 null이 아니라면
			if(af.isRedirect()) {//redirect 방식이라면
				resp.sendRedirect(af.getPath());//redirect로 전송
			}else {//forward 방식이라면
				//forward
				//request객체에서 Dispatch을 가져온 뒤, 이동할 경로를 전달한다.
				//dispatch : 요청과 응답을 관리해주는 객체
				RequestDispatcher dispatcher = req.getRequestDispatcher(af.getPath());
				//dispatcher객체에서 forward()를 사용할 때 request와 response객체 둘 다 전달해주면
				//응답할 화면까지 데이터가 유지된다.
				dispatcher.forward(req, resp);//forward로 전송
		
			}
		}
	}
}















