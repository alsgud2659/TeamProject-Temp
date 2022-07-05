package com.saf.app.board.controller;

import java.io.IOException;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.saf.app.action.Action;
import com.saf.app.action.ActionForward;
import com.saf.app.board.dao.BoardDAO;
import com.saf.app.board.vo.BoardVO;

public class BoardWriteOk implements Action {
   @Override
   public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
      req.setCharacterEncoding("UTF-8");
      /*String uploadFolder = "D:\\aigb_0900_hds\\jsp\\workspace\\boardMVC\\WebContent\\upload";//변경할것
      int fileSize = 1024 * 1024 * 5;//5M
      BoardDAO bDao = new BoardDAO();
      FilesDAO fDao = new FilesDAO();
      BoardVO board = new BoardVO();
      ActionForward af = new ActionForward();*/
      ActionForward af = new ActionForward();
      BoardVO board = new BoardVO();
      BoardDAO dao = new BoardDAO();
      
      //요청객체, 업로드폴더 경로, 파일의 크기, 인코딩 방식, 이름변경정책
      //MultipartRequest multi = new MultipartRequest(req, uploadFolder, fileSize, "UTF-8", new DefaultFileRenamePolicy());
      
      board.setBtitle(req.getParameter("btitle"));
      board.setBurl(req.getParameter("burl"));
      board.setBcontent(req.getParameter("bcontent"));
      board.setBuid(req.getParameter("buid"));

      
      /*System.out.println(board.getBtitle());
      System.out.println(board.getBurl());
      System.out.println(board.getBcontent());*/
      
      //게시글 추가
      dao.insert(board);
      
      //파일 추가
      //fDao.insert(req, bDao.getSeq());
      
      af.setRedirect(true);
      //redirect로 전송할 때 contextPath가 사라지기 때문에
      //미리 붙여놓고 전송한다.
      af.setPath(req.getContextPath() + "/board/controller/BoardListOk.bo");
      
      return af;
   }

}