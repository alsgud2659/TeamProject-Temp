package com.example.teamproject.domain.dao.product;

import com.example.teamproject.domain.vo.ProductFileVO;
import com.example.teamproject.mapper.ProductFileMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductFileDAO {
    private final ProductFileMapper productFileMapper;

    // 판매 상품 목록
    public List<ProductFileVO> getList(Long pno){
        return productFileMapper.getList(pno);
    };
    public void remove(Long pno){
        productFileMapper.delete(pno);
    }
    public void register(ProductFileVO productFileVO){
        productFileMapper.insert(productFileVO);
    }
    public List<ProductFileVO> getOldFiles(){return productFileMapper.getOldFiles();}
}
