package com.example.teamproject.service.product;

import com.example.teamproject.domain.dao.product.ProductDAO;
import com.example.teamproject.domain.dao.product.ProductFileDAO;
import com.example.teamproject.domain.vo.Criteria;
import com.example.teamproject.domain.vo.ProductFileVO;
import com.example.teamproject.domain.vo.ProductVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServieceImpl{
    private final ProductDAO productDAO;
    private final ProductFileDAO productFileDAO;

    @Transactional(rollbackFor = Exception.class)
    public void register(ProductVO productVO) {
        productDAO.register(productVO);
        if(productVO.getFileList() != null) {
            productVO.getFileList().forEach(productFileVO ->  {
                productFileVO.setPno(productVO.getPno());
                productFileDAO.register(productFileVO);
            });
        }
    }

    // 판매 상품 수정
    @Transactional(rollbackFor = Exception.class)
    public int modify(ProductVO productVO) {
        productFileDAO.remove(productVO.getPno());

        if(productVO.getFileList() != null) {
            productVO.getFileList().forEach(productFileVO -> {
                productFileVO.setPno(productVO.getPno());
                productFileDAO.register(productFileVO);
            });
        }
        return productDAO.modify(productVO);
    }


    // 판매 상품 삭제




    // 판매 상품 상세


    public int remove(Long pno) {
        return productDAO.remove(pno);
    }

    // 판매 상품 상세
    public ProductVO read(Long pno) {
        return productDAO.read(pno);

    }

    // 판매 상품 목록
    public List<ProductVO> getList(Criteria criteria) {
        return productDAO.getList(criteria);
    }

    public List<ProductVO> getListMain(Criteria criteria) {
        return productDAO.getListMain(criteria);
    }

    public int getTotal(){return productDAO.getTotal();}

    public List<ProductFileVO> getOldFiles(){return productFileDAO.getOldFiles();}

    public List<ProductFileVO> getList(Long pno) {
        return productFileDAO.getList(pno);
    }
}

