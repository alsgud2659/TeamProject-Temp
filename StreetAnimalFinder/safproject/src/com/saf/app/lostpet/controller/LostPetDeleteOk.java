package com.saf.app.lostpet.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saf.app.action.Action;
import com.saf.app.action.ActionForward;
import com.saf.app.lostpet.dao.LostPetDAO;
import com.saf.app.lostpet.dao.LostPetReplyDAO;
import com.saf.app.lostpet.dao.FilesDAO;
import com.saf.app.lostpet.vo.LostPetFilesVO;

public class LostPetDeleteOk implements Action{
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		String uploadFolder = "C:\\aigb_0900_ksy\\1team_image";
		int lpnumber = Integer.parseInt(req.getParameter("lpnumber"));
		LostPetDAO lpDao = new LostPetDAO();
		FilesDAO fDao = new FilesDAO();
		ActionForward af = new ActionForward();
		
		List<LostPetFilesVO> files = fDao.select(lpnumber);
		
		fDao.delete(lpnumber);
		lpDao.delete(lpnumber);
		
		for (int i = 0; i < files.size(); i++) {
			File f = new File(uploadFolder, files.get(i).getFileName());
			if(f.exists()) {
				f.delete();
			}
		}
		
		af.setRedirect(true);
		af.setPath(req.getContextPath() + "/lostpet/controller/LostPetListOk.lo");
		
		return af;
	}
}
