
package com.example.teamproject.domain.dao.product;

import com.example.teamproject.domain.vo.Criteria;
import com.example.teamproject.domain.vo.ProductVO;
import com.example.teamproject.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductDAO {
    private final ProductMapper productMapper;

    // 판매 상품 목록
    public List<ProductVO> getList(Criteria criteria){
        return productMapper.getList(criteria);
    };

    public List<ProductVO> getListMain(Criteria criteria){
        return productMapper.getListMain(criteria);
    };

    // 판매 상품 등록
    public void register(ProductVO productVO){
        productMapper.insert(productVO);
    };

    // 판매 상품 상세보기
    public ProductVO read(Long pno){
        return productMapper.get(pno);
    };

    // 판매 상품 삭제
    public int remove(Long pno){
        return productMapper.delete(pno);
    };

    // 판매 상품 수정
    public int modify(ProductVO productVO){
        return  productMapper.update(productVO);
    };

    //총 게시물 게수
    public int getTotal(){return productMapper.getTotal();}
}

