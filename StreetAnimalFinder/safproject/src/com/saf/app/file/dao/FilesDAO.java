package com.saf.app.file.dao;

import java.util.Enumeration;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.oreilly.servlet.MultipartRequest;
import com.saf.app.file.vo.FilesVO;
import com.saf.mybatis.config.MyBatisConfig;

public class FilesDAO {
	SqlSessionFactory sqlSessionFactory = MyBatisConfig.getSqlsessoinFactory();
	SqlSession sqlSession;
	
	public FilesDAO() {
		sqlSession = sqlSessionFactory.openSession(true);
	}
	
	//게시판 첨부파일 추가(SQL)
	private void insert(FilesVO file) {
		sqlSession.insert("File.insert", file);
	}
	
	//게시판 첨부파일 추가(로직)
	public void insert(MultipartRequest multi, int bnumber) {
		FilesVO file = new FilesVO();
		Enumeration<String> files = multi.getFileNames();
		
		//type="file"인 태그의 개수만큼 반복
		while(files.hasMoreElements()) {
			//사용자가 업로드한 파일 태그의 name값
			String name = files.nextElement();
			
			//사용자가 업로드한 원본 파일 이름
			String fileNameOriginal = multi.getOriginalFileName(name);
			
			//중복 시 변경된 이름
			String fileName = multi.getFilesystemName(name);
			
			//첨부파일이 업로드되지 않았다면
			if(fileName == null) {continue;}

			file.setFname(fileName);
			file.setForiginal(fileNameOriginal);
			file.setBnumber(bnumber);
			
			insert(file);
		}
	}
	
	//게시판 첨부파일 삭제
	public void deleteFiles(int bnumber) {
		sqlSession.delete("File.delete", bnumber);
	}
	
	//게시판 첨부파일 가져오기
	public List<FilesVO> getFiles(int bnumber){
		return sqlSession.selectList("File.select", bnumber);
	}
	
	//실종동물 첨부파일 추가(SQL)
		private void lostpetInsertFile(FilesVO file) {
			sqlSession.insert("File.lostpetinsertfile", file);
		}
		
		//실종동물 첨부파일 추가(로직)
		public void lostpetInsertFile(MultipartRequest multi, int lpnumber) {
			FilesVO file = new FilesVO();
			Enumeration<String> files = multi.getFileNames();
			
			//type="file"인 태그의 개수만큼 반복
			while(files.hasMoreElements()) {
				//사용자가 업로드한 파일 태그의 name값
				String name = files.nextElement();
				
				//사용자가 업로드한 원본 파일 이름
				String fileNameOriginal = multi.getOriginalFileName(name);
				
				//중복 시 변경된 이름
				String fileName = multi.getFilesystemName(name);
				
				//첨부파일이 업로드되지 않았다면
				if(fileName == null) {continue;}

				file.setFname(fileName);
				file.setForiginal(fileNameOriginal);
				file.setLpnumber(lpnumber);
				
				insert(file);
			}
		}
		
		//실종동물 첨부파일 삭제
		public void lostpetDeleteFiles(int lpnumber) {
			sqlSession.delete("File.lostpetdeletefile", lpnumber);
		}
		
		//실종동물 첨부파일 가져오기
		public List<FilesVO> lostpetGetFiles(int lpnumber){
			return sqlSession.selectList("File.lostpetselectfile", lpnumber);
		}
		
		//유저 프로필 첨부파일 추가(SQL)
		private void userInsertFile(FilesVO file) {
			sqlSession.insert("File.userinsertfile", file);
		}
		
		//유저 프로필  첨부파일 추가(로직)
		public void userInsertFile(MultipartRequest multi, String uid) {
			FilesVO file = new FilesVO();
			Enumeration<String> files = multi.getFileNames();
			
			//type="file"인 태그의 개수만큼 반복
			while(files.hasMoreElements()) {
				//사용자가 업로드한 파일 태그의 name값
				String name = files.nextElement();
				
				//사용자가 업로드한 원본 파일 이름
				String fileNameOriginal = multi.getOriginalFileName(name);
				
				//중복 시 변경된 이름
				String fileName = multi.getFilesystemName(name);
				
				//첨부파일이 업로드되지 않았다면
				if(fileName == null) {continue;}

				file.setFname(fileName);
				file.setForiginal(fileNameOriginal);
				file.setUid(uid);
				
				insert(file);
			}
		}
		
		//유저 프로필  첨부파일 삭제
		public void userDeleteFiles(String uid) {
			sqlSession.delete("File.userdeletefile", uid);
		}
		
		//유저 프로필  첨부파일 가져오기
		public List<FilesVO> userGetFiles(String uid){
			return sqlSession.selectList("File.userselectfile", uid);
		}
	
}









