package com.saf.app.lostpet.controller;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saf.app.action.Action;
import com.saf.app.action.ActionForward;
import com.saf.app.lostpet.dao.LostPetDAO;
import com.saf.app.lostpet.dao.LostPetReplyDAO;
import com.saf.app.lostpet.vo.LostPetVO;
import com.saf.app.lostpet.vo.LostPetFilesVO; 
import com.saf.app.lostpet.dao.FilesDAO; 
 
public class LostPetMessageOk implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		//사용자가 선택한  번호를 파라미터로 전달받는다.
		int lpnumber = Integer.parseInt(req.getParameter("lpnumber"));
		// int page = Integer.parseInt(req.getParameter("page"));
		
		LostPetDAO lpDao = new LostPetDAO();
		FilesDAO fDao = new FilesDAO();
		ActionForward af = new ActionForward();
		
		
		//실종동물 번호로 조회한 실종동물의 전체 정보를 requestScope에 저장한다.
		req.setAttribute("lostpet", lpDao.selectDetail(lpnumber));
		req.setAttribute("files", fDao.select(lpnumber));
		// req.setAttribute("page", page);
		
		// 파일 묶음
		// HashMap<String, Integer> lpimageMap = new HashMap<>();
	     // List<LostPetFilesVO> lpImgList= fDao.select(lpnumber);
	     // req.setAttribute("lostpetList", lpImgList);
	      
//		//상세보기로 왔다면, 조회수를 1 증가시켜준다.
//		lpDao.updateReadCount(lpnumber);
		
		//requestScope에 데이터를 담았기 때문에 forward로 페이지까지 req객체를 유지한다.
		af.setRedirect(false);
		af.setPath("/lostpet/LostPet_detail.jsp"); 
		
		return af;
	}

}
