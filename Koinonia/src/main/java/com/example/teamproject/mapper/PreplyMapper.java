package com.example.teamproject.mapper;

import com.example.teamproject.domain.vo.BoardReplyVO;
import com.example.teamproject.domain.vo.Criteria;
import com.example.teamproject.domain.vo.ProductReplyVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper

public interface PreplyMapper {
    //댓글 추가
    public void insert(ProductReplyVO productReplyVO);

    //댓글 1개 조회
    public ProductReplyVO getReply(Long prno);

    //댓글 삭제
    public int delete(Long prno);

    //댓글 수정
    public int update(ProductReplyVO productReplyVO );

    //댓글 목록
    public List<ProductReplyVO> getList(@Param("criteria") Criteria criteria, @Param("pno") Long pno);

    //댓글 개수
    public int getTotal(Long pno);

}


