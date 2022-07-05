package com.saf.app.lostpet.controller;
import java.io.IOException;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.saf.app.action.Action;
import com.saf.app.action.ActionForward;
import com.saf.app.lostpet.dao.LostPetDAO;
import com.saf.app.lostpet.vo.LostPetVO;
import java.util.List;

public class LostPetListOk implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
	      req.setCharacterEncoding("UTF-8");
	      resp.setCharacterEncoding("UTF-8");
	      HashMap<String, Integer> lostpetMap = new HashMap<>();
	      ActionForward af = new ActionForward();
	      
	      LostPetDAO lpDao = new LostPetDAO();
	     
	      

	      // 게시글 전체 정보
	      List<LostPetVO> lostpetList = lpDao.selectAll(lostpetMap);
	      req.setAttribute("lostpetList", lostpetList);
	      
	      System.out.print("도착햇니2");

	      af.setRedirect(false);
	      af.setPath("/lostpet/LostPet.jsp");

	      return af;
	   }
	
}
