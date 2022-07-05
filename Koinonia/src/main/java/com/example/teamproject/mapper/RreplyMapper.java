package com.example.teamproject.mapper;

import com.example.teamproject.domain.vo.BoardReplyVO;
import com.example.teamproject.domain.vo.Criteria;
import com.example.teamproject.domain.vo.RequestReplyVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper

public interface RreplyMapper {
    //댓글 추가
    public void insert(RequestReplyVO requestReplyVO);

    //댓글 1개 조회
    public RequestReplyVO getReply(Long rrno);

    //댓글 삭제
    public int delete(Long rrno);

    //댓글 수정
    public int update(RequestReplyVO requestReplyVO);

    //댓글 목록
    public List<RequestReplyVO> getList(@Param("criteria") Criteria criteria, @Param("rno") Long rno);

    //댓글 개수
    public int getTotal(Long rno);

}


