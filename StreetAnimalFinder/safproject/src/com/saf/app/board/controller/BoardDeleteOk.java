package com.saf.app.board.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saf.app.action.Action;
import com.saf.app.action.ActionForward;
import com.saf.app.board.dao.BoardDAO;
import com.saf.app.board.dao.FilesDAO;
import com.saf.app.board.vo.FilesVO;


public class BoardDeleteOk implements Action{
   @Override
   public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
      
      String uploadFolder = "C:\\aigb_0900_LMH\\jsp\\workspace\\safproject\\WebContent\\file\\getBlob";//변경할것
      int bnumber = Integer.parseInt(req.getParameter("bnumber"));
//    FilesDAO fDao = new FilesDAO();
      BoardDAO bDao = new BoardDAO();
      ActionForward af = new ActionForward();
      
//    List<FilesVO> files = fDao.getFiles(bnumber);
      
//    for (int i = 0; i < files.size(); i++) {
//       File f = new File(uploadFolder, files.get(i).getFname());
//       if(f.exists()) {
//          f.delete();
//       }
//    }
      
//    fDao.deleteFiles(bnumber);
      bDao.deleteBoard(bnumber);
      
      af.setRedirect(false);
      af.setPath("/board/controller/BoardListOk.bo");
      
      return af;
   }
}