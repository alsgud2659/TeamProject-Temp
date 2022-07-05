package com.saf.app.board.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.saf.app.board.vo.BoardVO;
import com.saf.mybatis.config.MyBatisConfig;

public class BoardDAO {
   SqlSessionFactory sqlSessionFactory = MyBatisConfig.getSqlsessoinFactory();
   SqlSession sqlSession;
   
   public BoardDAO() {
      sqlSession = sqlSessionFactory.openSession(true);
   }
   
   //게시글 목록
   public List<BoardVO> selectAll(Map<String, Integer> boardMap) {
      return sqlSession.selectList("Board.selectAll", boardMap);
   }
   

   //게시글 정보 조회
   public BoardVO selectDetail(int bnumber) {
      return sqlSession.selectOne("Board.selectDetail", bnumber);
   }
   
   //최근 게시글 번호
   public int getSeq() {
      return sqlSession.selectOne("Board.getSeq");
   }
   
   //게시글 추가
   public void insert(BoardVO board) {
      sqlSession.insert("Board.insert", board);
   }
   
   //게시글 삭제
   public void deleteBoard(int bnumber) {
      sqlSession.delete("Board.deleteBoard", bnumber);
   }
   
   //게시글 수정
   public void updateBoard(BoardVO board) {
      sqlSession.update("Board.updateBoard", board);
   }
   
}