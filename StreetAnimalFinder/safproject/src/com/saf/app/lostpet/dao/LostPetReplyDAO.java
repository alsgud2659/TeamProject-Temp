package com.saf.app.lostpet.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.saf.app.action.*;
import com.saf.app.lostpet.dao.*; 
import com.saf.app.lostpet.vo.*; 
import com.saf.mybatis.config.MyBatisConfig;

public class LostPetReplyDAO {
	SqlSessionFactory sqlSessionFactory = MyBatisConfig.getSqlsessoinFactory();
	SqlSession sqlSession;
	
	public LostPetReplyDAO() {
		sqlSession = sqlSessionFactory.openSession(true);
	}
	
	//댓글 목록
	public List<LostPetReplyDTO> selectReplies(int lpnumber) {
		return sqlSession.selectList("Lostpet.selectReplies", lpnumber);
	}
	
	//댓글 등록
	public void insertReply(LostPetReplyVO reply) {
		sqlSession.insert("Lostpet.insertReply", reply);
	}
	
	//댓글 삭제
	public void deleteReply(int replyNumber) {
		sqlSession.delete("Lostpet.deleteReply", replyNumber);
	}
	
	//댓글 수정
	public void updateReply(LostPetReplyVO reply) {
		sqlSession.update("Lostpet.updateReply", reply);
	}
}
