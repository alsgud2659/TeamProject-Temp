package com.example.teamproject.service.request;

import com.example.teamproject.domain.dao.request.RequestReplyDAO;
import com.example.teamproject.domain.vo.Criteria;
import com.example.teamproject.domain.vo.RequestReplyVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RequestReplyServieceImpl{
    private final RequestReplyDAO requestReplyDAO;

    // 판매 상품 요청 댓글 작성
    public void register(RequestReplyVO requestReplyVO) {
        requestReplyDAO.register(requestReplyVO);
    }

    // 판매 상품 요청 댓글 1개 조회
    public RequestReplyVO read(Long rno) {
        return requestReplyDAO.read(rno);
    }

    // 판매 상품 요청 댓글 전체 목록 조회
    public List<RequestReplyVO> getList(Long rno, Criteria criteria) {
        return requestReplyDAO.getList(rno, criteria);
    }

    // 판매 상품 요청 댓글 삭제
    public int modify(RequestReplyVO requestReplyVO) {
        return requestReplyDAO.modify(requestReplyVO);
    }

    // 판매 상품 요청 댓글 수정
    public int remove(Long rno) {
        return requestReplyDAO.remove(rno);
    }

    // 판매 상품 요청 댓글 개수
    public int getTotal(Long rno) {
        return requestReplyDAO.getTotal(rno);
    }
}
