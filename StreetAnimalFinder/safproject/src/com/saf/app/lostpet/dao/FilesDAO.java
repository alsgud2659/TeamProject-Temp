package com.saf.app.lostpet.dao;

import java.util.Enumeration;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.saf.app.lostpet.vo.LostPetFilesVO;
import com.saf.mybatis.config.MyBatisConfig;
import com.oreilly.servlet.MultipartRequest;

public class FilesDAO {
	SqlSessionFactory sqlSessionFactory = MyBatisConfig.getSqlsessoinFactory();
	SqlSession sqlSession;
	
	public FilesDAO() {
		sqlSession = sqlSessionFactory.openSession(true);
	}
	
	//첨부파일 추가(SQL)
	private void insert(LostPetFilesVO file) {
		sqlSession.insert("Lostpet.imginsert", file);
	}
	
	//첨부파일 추가(로직)
	public void insert(MultipartRequest multi, int lpnumber) {
		LostPetFilesVO file = new LostPetFilesVO();
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

			file.setFileName(fileName);
			file.setFileOriginal(fileNameOriginal);
			file.setLpNumber(lpnumber);
			
			insert(file);
		}
	}
	
	//첨부파일 삭제
	public void delete(int lpnumber) {
		sqlSession.delete("Lostpet.imgdelete", lpnumber);
	}
	
	//첨부파일 가져오기
	public List<LostPetFilesVO> select(int lpnumber){
		return sqlSession.selectList("Lostpet.FileDelect", lpnumber);
	}
	
}









