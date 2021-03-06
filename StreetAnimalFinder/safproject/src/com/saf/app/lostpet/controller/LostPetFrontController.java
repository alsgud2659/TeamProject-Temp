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
			System.out.print("ëě°Šíë");
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
			System.out.println("íěť¨");
			af = new LostPetUpdate().execute(req, resp);
			
		}else if(command.equals("/lostpet/controller/LostPetUpdateOk.lo")) {
			System.out.println("íěť¨");
			af = new LostPetUpdateOk().execute(req, resp);
			
		}else if(command.equals("/lostpet/controller/LostPetWrite.lo")) {
			af = new LostPetWrite().execute(req, resp);
			
		}else if(command.equals("/lostpet/controller/LostPetWriteOk.lo")) {
			System.out.println("íëĄ í¸ěť¨í¸ëĄ¤ëŹ ëě°Š");
			af = new LostPetWriteOk().execute(req, resp);
		}else if(command.equals("/lostpet/controller/FileDownloadOk.lo")) {
			af = new LostPetWriteOk().execute(req, resp);
		}
		
		//ëśę¸° ëł ę˛°ęłźëĽź afě ë´ěë¤ëŠ´ ěŹę¸°ëĄ ë´ë ¤ě¨ë¤.
		
		//ě ěĄěí ě§
		if(af != null) {// afę° nullě´ ěëëźëŠ´
			if(af.isRedirect()) {//redirect ë°Šěě´ëźëŠ´
				resp.sendRedirect(af.getPath());//redirectëĄ ě ěĄ
			}else {//forward ë°Šěě´ëźëŠ´
				//forward
				//requestę°ě˛´ěě Dispatchě ę°ě ¸ě¨ ë¤, ě´ëí  ę˛˝ëĄëĽź ě ëŹíë¤.
				//dispatch : ěě˛­ęłź ěëľě ę´ëŚŹí´ěŁźë ę°ě˛´
				RequestDispatcher dispatcher = req.getRequestDispatcher(af.getPath());
				//dispatcherę°ě˛´ěě forward()ëĽź ěŹěŠí  ë requestě responseę°ě˛´ ë ë¤ ě ëŹí´ěŁźëŠ´
				//ěëľí  íëŠ´ęšě§ ë°ě´í°ę° ě ě§ëë¤.
				dispatcher.forward(req, resp);//forwardëĄ ě ěĄ
		
			}
		}
	}
}















