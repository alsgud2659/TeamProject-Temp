package com.example.teamproject.mapper;

import com.example.teamproject.domain.vo.BoardReplyVO;
import com.example.teamproject.domain.vo.Criteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;



@Mapper

public interface ReplyMapper {
    //댓글 추가
    public void insert(BoardReplyVO boardReplyVO);

    //댓글 1개 조회
    public BoardReplyVO getReply(Long rno);

    //댓글 삭제
    public int delete(Long rno);

    //댓글 수정
    public int update(BoardReplyVO boardReplyVO);

    //댓글 목록
    public List<BoardReplyVO> getList(@Param("criteria") Criteria criteria, @Param("bno") Long bno);

    //댓글 개수
    public int getTotal(Long bno);

}


