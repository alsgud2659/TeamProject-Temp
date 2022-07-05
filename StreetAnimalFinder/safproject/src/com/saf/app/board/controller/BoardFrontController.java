package com.saf.app.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saf.app.action.ActionForward;

public class BoardFrontController extends HttpServlet {
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
      
      if(command.equals("/board/controller/BoardDeleteOk.bo")) {
         try {
            af = new BoardDeleteOk().execute(req,resp);
         } catch(Exception e) {
            e.printStackTrace();
         }
         
      }else if(command.equals("/board/controller/BoardDetailOk.bo")) {
         try {
            af = new BoardDetailOk().execute(req,resp);
         } catch(Exception e) {
            e.printStackTrace();
         }
         
      }else if(command.equals("/board/controller/BoardWrite.bo")) {
         af = new BoardWrite().execute(req, resp);
      }else if(command.equals("/board/controller/BoardWriteOk.bo")) {
    	  System.out.print("왔니");
    	  af = new BoardWriteOk().execute(req, resp);         
      }else if(command.equals("/board/controller/BoardListOk.bo")) {
         try {
            af = new BoardListOk().execute(req,resp);
         } catch(Exception e) {
            e.printStackTrace();
         }

         
      }else if(command.equals("/board/controller/BoardUpdate.bo")) {
         try {
            af = new BoardUpdate().execute(req,resp);
         } catch(Exception e) {
            e.printStackTrace();
         }

      }else if(command.equals("/board/controller/BoardUpdateOk.bo")) {
    	  try {
    	  	af = new BoardUpdateOk().execute(req, resp);
    	  } catch(Exception e) {
              e.printStackTrace();
          } 
      }
      
      //전송안할지
      if(af != null) {
         if(af.isRedirect()) {
            //redirect
            resp.sendRedirect(af.getPath());
         }else {
            //forward
            //request객체에서 Dispatch을 가져온 뒤, 이동할 경로를 전달한다.
            //dispatch : 요청과 응답을 관리해주는 객체
            RequestDispatcher dispatcher = req.getRequestDispatcher(af.getPath());
            //dispatcher객체에서 forward()를 사용할 때 request와 response객체 둘 다 전달해주면
            //응답할 화면까지 데이터가 유지된다.
            dispatcher.forward(req, resp);
         }
      }
   }
}
