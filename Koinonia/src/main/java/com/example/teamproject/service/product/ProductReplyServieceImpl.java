
package com.example.teamproject.service.product;

import com.example.teamproject.domain.dao.product.ProductReplyDAO;
import com.example.teamproject.domain.vo.Criteria;
import com.example.teamproject.domain.vo.ProductReplyVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductReplyServieceImpl {
    private final ProductReplyDAO productReplyDAO;

    // 판매 상품 댓글 작성
    public void register(ProductReplyVO productReplyVO) {
        productReplyDAO.register(productReplyVO);
    }

    // 판매 상품 댓글 1개 조회
    public ProductReplyVO read(Long rno) {
        return productReplyDAO.read(rno);
    }

    // 판매 상품 댓글 전체 목록 조회
    public List<ProductReplyVO> getList(Long pno, Criteria criteria) {
        return productReplyDAO.getList(pno, criteria);
    }

    // 판매 상품 댓글 삭제
    public int modify(ProductReplyVO productReplyVO) {
        return productReplyDAO.modify(productReplyVO);
    }

    // 판매 상품 댓글 수정
    public int remove(Long rno) {
        return productReplyDAO.remove(rno);
    }

    // 판매 상품 댓글 개수
    public int getTotal(Long pno) {
        return productReplyDAO.getTotal(pno);
    }
}

