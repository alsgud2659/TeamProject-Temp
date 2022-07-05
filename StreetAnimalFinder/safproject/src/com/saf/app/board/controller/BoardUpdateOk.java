package com.saf.app.board.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.saf.app.action.Action;
import com.saf.app.action.ActionForward;
import com.saf.app.board.dao.BoardDAO;
import com.saf.app.board.dao.FilesDAO;
import com.saf.app.board.vo.BoardVO;
import com.saf.app.board.vo.FilesVO;

public class BoardUpdateOk implements Action {

   @Override
   public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
      req.setCharacterEncoding("UTF-8");
      resp.setCharacterEncoding("UTF-8");
      
      BoardVO board = new BoardVO();
      BoardDAO bDao = new BoardDAO();
      List<FilesVO> files = null;
      FilesDAO fDao = new FilesDAO();
      ActionForward af = new ActionForward();
      
      String uploadFolder = "C:\\aigb_0900_LMH\\jsp\\workspace\\safproject\\WebContent\\file\\getBlob";//변경할것
      int fileSize = 1024 * 1024 * 5; //5Mb
      int bnumber = 0;
      
      //파일을 form으로 전달할 때 MultipartRequest로 받는다.
      MultipartRequest multi = new MultipartRequest(req, uploadFolder, fileSize, "UTF-8", new DefaultFileRenamePolicy());
      
      bnumber = Integer.parseInt(multi.getParameter("bnumber"));
      board.setBtitle(multi.getParameter("btitle"));
      board.setBcontent(multi.getParameter("bcontent"));
      board.setBnumber(bnumber);
      
//      files = fDao.getFiles(bnumber);
      

      bDao.updateBoard(board);
//      fDao.deleteFiles(bnumber);
//      fDao.insert(multi, bnumber);
//
//      
//      files.forEach(file -> {
//         File f = new File(uploadFolder, file.getFname());
//         if(f.exists()) {f.delete();}
//      });
      

      af.setRedirect(false);
      //상세보기
//      af.setPath(req.getContextPath() + "/board/BoardDetailOk.bo?boardNumber=" + boardNumber);
      
      //목록보기
//      af.setPath(req.getContextPath() + "/board/BoardListOk.bo");
      
      //목록보기(페이지 기억)
      af.setPath("/board/controller/BoardDetailOk.bo?bnumber=" + bnumber);
      
      return af;
   }

}