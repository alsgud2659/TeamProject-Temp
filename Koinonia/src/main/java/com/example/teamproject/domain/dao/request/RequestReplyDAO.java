
package com.example.teamproject.domain.dao.request;

import com.example.teamproject.domain.vo.Criteria;
import com.example.teamproject.domain.vo.RequestReplyVO;
import com.example.teamproject.mapper.RreplyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class RequestReplyDAO {
    private final RreplyMapper requestReplyMapper;

    // 판매 상품 요청 댓글 작성
    public void register(RequestReplyVO requestReplyVO){
        requestReplyMapper.insert(requestReplyVO);
    };

    // 판매 상품 요청 댓글 1개 조회
    public RequestReplyVO read(Long rno){
        return requestReplyMapper.getReply(rno);
    };

    // 판매 상품 요청 댓글 전체 목록 조회
    public List<RequestReplyVO> getList(Long rno, Criteria criteria){
        return requestReplyMapper.getList(criteria, rno);
    };

    // 판매 상품 요청 댓글 삭제
    public int remove(Long rno){
        return  requestReplyMapper.delete(rno);
    };

    // 판매 상품 요청 댓글 수정
    public int modify(RequestReplyVO requestReplyVO){
        return  requestReplyMapper.update(requestReplyVO);
    };

    // 판매 상품 요청 댓글 개수
    public int getTotal(Long rno){
        return  requestReplyMapper.getTotal(rno);
    };
}
