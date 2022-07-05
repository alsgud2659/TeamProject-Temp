package com.saf.app.user.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.saf.app.user.vo.UserVO;
import com.saf.mybatis.config.MyBatisConfig;

public class UserDAO2 {
	SqlSessionFactory sqlSessionFactory = MyBatisConfig.getSqlsessoinFactory();
	SqlSession sqlSession;
	
	public UserDAO2() {
		sqlSession = sqlSessionFactory.openSession(true);
	}


	// 아이디 중복 검사
	public boolean checkId(String uid) {
		return (Integer) sqlSession.selectOne("User.checkId", uid) == 1;

	}
	
	//회원가입
	public void join(UserVO user) {
		sqlSession.insert("User.join", user);
	}

	//로그인

	public int login(Map<String, String> loginMap) {
		int userNumber = 0;
		try {userNumber = sqlSession.selectOne("User.login", loginMap);} catch (Exception e) {;}
		return userNumber;
	}

	
	//회원 정보 조회
//	public UserVO getUserInfo(String uid) {
//		return sqlSession.selectOne("User.getUserInfo", uid);
//	}
	
	public UserVO getUserInfo(String uid) {
		return sqlSession.selectOne("User.getUserInfo", uid);
	}

	// 프로필 수정
	public void updateUserProfile(UserVO user) {
		sqlSession.update("User.updateUserProfile", user);
	}

	// 회원 정보 수정
	public void updateUser(UserVO user) {
		sqlSession.update("User.updateUser", user);
	}

	// 비밀번호 변경
	public void updateUpw(UserVO user) {
		sqlSession.update("User.updateUpw", user);
	}

	// 회원 탈퇴
	public void delUser(int unum) {
		sqlSession.delete("User.delUser", unum);
	}
	
}


