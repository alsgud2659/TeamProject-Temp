package com.saf.app.user.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.saf.app.action.Action;
import com.saf.app.action.ActionForward;
import com.saf.app.file.dao.FilesDAO;
import com.saf.app.user.dao.UserDAO;
import com.saf.app.user.vo.UserVO;

public class UserUpdateProfileOK implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("UTF-8");
		
		HttpSession session = req.getSession();
		/*String uploadFolder = "C:\\aigb_9000_sck\\git\\safproject\\safproject\\WebContent\\userfileupload";
		int fileSize = 1024 * 1024 * 5;//5M
*/		ActionForward af = new ActionForward();
		/*FilesDAO fDao = new FilesDAO();*/
		UserVO user = new UserVO();
		UserDAO dao = new UserDAO();
//		String uid = "1";
		
		
		//요청객체, 업로드폴더 경로, 파일의 크기, 인코딩 방식, 이름변경정책
		/*MultipartRequest multi = new MultipartRequest(req, uploadFolder, fileSize, "UTF-8", new DefaultFileRenamePolicy());*/
		
		
		
		user.setUnum((Integer)req.getSession().getAttribute("unum"));
		user.setUname(req.getParameter("uname"));

		
		dao.updateUserProfile(user);
		/*fDao.userInsertFile(multi, uid);*/

		
		af.setRedirect(true);

		af.setPath(req.getContextPath() + "/user/controller/UserUpdateProfile.us");
		
		return af;
	}

	
}
