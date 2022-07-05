package com.saf.app.lostpet.controller;

import java.io.File;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saf.app.action.*;
import com.saf.app.lostpet.dao.*;
import com.saf.app.lostpet.vo.*; 
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class LostPetUpdateOk implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		System.out.println("컨트롤러");
		LostPetDAO lpDao = new LostPetDAO();
		FilesDAO fDao = new FilesDAO();
		LostPetVO lostpet = new LostPetVO();
		List<LostPetFilesVO> files = null;
		ActionForward af = new ActionForward();
		
		String uploadFolder = "C:\\aigb_0900_ksy\\1team_imag";
		int fileSize = 1024 * 1024 * 5; //5M
		int lpnumber = 0, page = 0;
		
		//파일을 form으로 전달할 때 MultipartRequest로 받는다.
		MultipartRequest multi = new MultipartRequest(req, uploadFolder, fileSize, "UTF-8", new DefaultFileRenamePolicy());
		
	//	page = Integer.parseInt(multi.getParameter("page"));
		lpnumber = Integer.parseInt(multi.getParameter("lpnumber"));
		lostpet.setLparea1(multi.getParameter("lparea1"));
		lostpet.setLparea2(multi.getParameter("lparea2"));
		lostpet.setLparea3(multi.getParameter("lparea3"));
		lostpet.setLpspecies(multi.getParameter("lpspecies"));
		lostpet.setLpbreed(multi.getParameter("lpbreed"));
		lostpet.setLpgender(multi.getParameter("lpgender"));
		lostpet.setLpage(multi.getParameter("lpage"));
		lostpet.setLpcolor(multi.getParameter("lpcolor"));
		lostpet.setLptime(multi.getParameter("lptime"));
		lostpet.setLpcontent(multi.getParameter("lpcontent"));
		lostpet.setUnum(1);
		
		files = fDao.select(lpnumber);
		
		//하나의 서비스를 구현하기 위한 DML의 집합 : 트랜잭션
		//************************
		lpDao.update(lostpet);
		fDao.delete(lpnumber);
		fDao.insert(multi, lpnumber);
		//************************
		
		files.forEach(file -> {
			File f = new File(uploadFolder, file.getFileName());
			if(f.exists()) {f.delete();}
		});
		
		//redirect일 경우 데이터를 전달할 수 있는 방법
		//1. 쿼리스트링으로 전달한다.
		//2. Flash(Spring 때 배운다).
		af.setRedirect(true);
		//상세보기
//		af.setPath(req.getContextPath() + "/board/BoardDetailOk.bo?boardNumber=" + boardNumber);
		
		//목록보기
//		af.setPath(req.getContextPath() + "/board/BoardListOk.bo");
		
		//목록보기(페이지 기억)
		af.setPath(req.getContextPath() + "/lostpet/LostPetListOk.lo");
		
		return af;
	}

}








