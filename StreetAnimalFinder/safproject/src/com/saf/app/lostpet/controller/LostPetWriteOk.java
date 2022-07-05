package com.saf.app.lostpet.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.saf.app.action.Action;
import com.saf.app.action.ActionForward;
import com.saf.app.lostpet.dao.FilesDAO;
import com.saf.app.lostpet.dao.LostPetDAO;
import com.saf.app.lostpet.vo.LostPetVO;

public class LostPetWriteOk implements Action {
   @Override
   public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
      
      
      
//      String uploadFolder = "C:\\aigb_0900_ksy\\1team_image"; //request.getSession().getServletContext().getRealPath("");
      String rootPath = req.getSession().getServletContext().getRealPath("/");
      String uploadFolder = rootPath + "lostpet\\images\\";
      int fileSize = 1024 * 1024 * 5;//5M
      
      //요청객체, 업로드폴더 경로, 파일의 크기, 인코딩 방식, 이름변경정책
      MultipartRequest multi = new MultipartRequest(req, uploadFolder, fileSize, "UTF-8", new DefaultFileRenamePolicy());
      
      
      System.out.println(multi.getParameter("lpstatus"));
      System.out.println(multi.getParameter("lpgender"));
      System.out.println(multi.getParameter("lpcontent"));
      LostPetDAO lpDao = new LostPetDAO();
      
      
      
      FilesDAO fDao = new FilesDAO();
      LostPetVO lostpet = new LostPetVO();
      ActionForward af = new ActionForward();
      lostpet.setLpstatus(Integer.parseInt(multi.getParameter("lpstatus")));
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
      
      //게시글 추가
      lpDao.insert(lostpet);
      //파일 추가
      fDao.insert(multi, lpDao.getSeq());
      
      af.setRedirect(true);
      af.setPath(req.getContextPath() + "/lostpet/controller/LostPetListOk.lo");
      
      return af;
   }

}