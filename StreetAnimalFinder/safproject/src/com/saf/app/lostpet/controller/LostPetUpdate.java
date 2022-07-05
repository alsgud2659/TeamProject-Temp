package com.saf.app.lostpet.controller;

import java.io.IOException;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saf.app.action.*;
import com.saf.app.lostpet.dao.*;

public class LostPetUpdate implements Action{
	
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		System.out.println("컨트롤러");
//		int page = Integer.parseInt(req.getParameter("page"));
		int lpnumber = Integer.parseInt(req.getParameter("lpnumber"));
		ActionForward af = new ActionForward();
		
		LostPetDAO dao = new LostPetDAO();
		
		// 회원의 번호로 실종동물의 정보 뿐만 아니라 회원의 아이디까지 가져와주는 쿼리 실행
		
		req.setAttribute("lostpet", dao.selectDetail(lpnumber));
//		req.setAttribute("page", page);
		
		af.setRedirect(false);
		af.setPath("/lostpet/find_update.jsp");
		System.out.println("jsp로 들어가");
		
		return af;
	}
}
