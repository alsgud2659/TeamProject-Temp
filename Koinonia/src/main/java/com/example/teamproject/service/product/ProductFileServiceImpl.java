package com.example.teamproject.service.product;

import com.example.teamproject.domain.dao.product.ProductFileDAO;
import com.example.teamproject.domain.vo.ProductFileVO;
import com.example.teamproject.domain.vo.ProductReplyVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductFileServiceImpl {
    private final ProductFileDAO productFileDAO;

    // 해당 판매상품의 파일 목록
    public List<ProductFileVO> getList(Long pno) {
        return productFileDAO.getList(pno);
    }
}
