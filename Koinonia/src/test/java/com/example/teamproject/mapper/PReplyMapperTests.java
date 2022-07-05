package com.example.teamproject.mapper;

import com.example.teamproject.domain.vo.Criteria;
import com.example.teamproject.domain.vo.ProductReplyVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
@Slf4j
public class PReplyMapperTests {

@Autowired
private PreplyMapper preplyMapper;


    private Long[] arPno = {10L, 11L, 12L, 13L, 14L};


//    @Test
//    public void insertTest(){
//
//        IntStream.rangeClosed(1, 10).forEach(i -> {
//            ProductReplyVO productReplyVO = new ProductReplyVO();
//            productReplyVO.setPno(arPno[i % 5]);
//            productReplyVO.setContent("새롭게 추가된 댓글" + i);
//            productReplyVO.setName("가즈아");
//            preplyMapper.insert(productReplyVO);
//        });
//    }

//    @Test
//    public void getReplyTest(){
//        log.info(preplyMapper.getReply(1L).toString());
//    }

//    @Test
//    public void deleteTest(){
//        log.info("DELETE COUNT : " + preplyMapper.delete(2L));
//    }

//    @Test
//    public void updateTest(){
//        ProductReplyVO productReplyVO = new ProductReplyVO();
//        productReplyVO.setPrno(3L);
//        productReplyVO.setPno(13L);
//        productReplyVO.setName("가즈아");
//        productReplyVO.setContent("꿀꽈배기먹고싶다");
//        log.info("UPDATE COUNT : " + preplyMapper.update(productReplyVO));
//    }

//    @Test
//    public void getListTest(){
//        preplyMapper.getList(new Criteria(1, 10), 12L)
//                .stream().map(ProductReplyVO::toString).forEach(log::info);
//    }

//    @Test
//    public void getTotalTest(){
//        log.info("댓글 개수 : " + preplyMapper.getTotal(11L));
//    }

    }

















