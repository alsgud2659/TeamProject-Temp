package com.example.teamproject.mapper;

import com.example.teamproject.domain.vo.Criteria;
import com.example.teamproject.domain.vo.ProductVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ProductMapperTests {

@Autowired
private ProductMapper productMapper;


//    @Test
//    public void insertTest() {
//        ProductVO productVO = new ProductVO();
//        productVO.setName("수정1");
//        productVO.setPcate("유럽");
//        productVO.setPname("시계");
//        productVO.setTitle("테스트1");
//        productVO.setContent("프랑스가서 사온 시계임 완전멋져!!");
//        productVO.setPrice("5000원");
//        productVO.setPsold(1L);
//        productMapper.insert(productVO);
//    }



//    @Test
//    public void updateTest() {
//        Long pno = 3L;
//        ProductVO productVO = productMapper.get(pno);
//        productVO.setPname("가즈아아아");
//        productVO.setTitle("테스트2");
//        productVO.setContent("테스트2");
//        productVO.setPrice("6만원");
//        productVO.setPsold(1L);
//        productVO.setPcate("아프리카 띠까띠까");
//        log.info("반환된 결과값은 : " + productMapper.update(productVO));
//    }
//
    @Test
    public void deleteTest() {
        Long pno = 3L;
        log.info("삭제 번호 : " + productMapper.delete(pno));
    }

//    @Test
//    public void getTest(){
//        Long pno = 2L;
//        log.info("2번게시물의 정보입니다" + productMapper.get(pno));
//    }

//    @Test
//    public void getTotalTest(){
//        log.info("총 갯수는 " + productMapper.getTotal());
//    }


    @Test
    public void getListTest(){
        productMapper.getList(new Criteria(1, 10)).stream().map(ProductVO::toString).forEach(log::info);
    }
}


















