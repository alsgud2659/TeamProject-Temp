package com.saf.app.lostpet.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.saf.app.lostpet.vo.LostPetDTO;
import com.saf.app.lostpet.vo.LostPetVO;
import com.saf.mybatis.config.MyBatisConfig;

public class LostPetDAO {
	SqlSessionFactory sqlSessionFactory = MyBatisConfig.getSqlsessoinFactory();
	SqlSession sqlSession;
	
	public LostPetDAO() {  // 여기로 들어옴
		System.out.println("dao도착");
//		MyBatisConfig.xml
		sqlSession = sqlSessionFactory.openSession(true);
	}

	//실종동물 목록
	public List<LostPetVO> selectAll(Map<String, Integer> lostpetMap) {
		return sqlSession.selectList("Lostpet.selectAll", lostpetMap);
	}
	
	//실종동물 전체 수
	public int getTotal() {
		return sqlSession.selectOne("Lostpet.getTotal");
	}
	
	//실종동물 찾은 수
	public int getFindCount() {
		return sqlSession.selectOne("Lostpet.getFindCount");
	}
	
	//실종동물 정보 조회
	public LostPetDTO selectDetail(int lpnumber) {
		System.out.println("디테일");
		return sqlSession.selectOne("Lostpet.selectDetail", lpnumber);
	}
	
	//실종동물 신고문자 작성
	public void message(LostPetVO lostpet) {
		sqlSession.insert("Lostpet.message", lostpet);
	}
	
	//실종동물 추가
	public void insert(LostPetVO lostpet) {
		System.out.println("insert dao도착");
		sqlSession.insert("Lostpet.insert", lostpet);
	}
	
	//실종동물 삭제
	public void delete(int lpnumber) {
		sqlSession.delete("Lostpet.delete", lpnumber);
	}
	
	//실종동물 수정
	public void update(LostPetVO lostpet) {
		sqlSession.update("Lostpet.update", lostpet);
	}
	
	//최근 실종동물 번호
	public int getSeq() {
		return sqlSession.selectOne("Lostpet.getSeq");
	}
}