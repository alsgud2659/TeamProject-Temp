package com.example.teamproject.mapper;

import com.example.teamproject.domain.vo.Criteria;
import com.example.teamproject.domain.vo.RequestReplyVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
@Slf4j
public class RreplyMapperTests {

@Autowired
private RreplyMapper rreplyMapper;


    private Long[] rrPno = {22L, 23L, 24L, 25L, 26L};


//    @Test
//    public void insertTest(){
//
//        IntStream.rangeClosed(1, 10).forEach(i -> {
//            RequestReplyVO requestReplyVO = new RequestReplyVO();
//            requestReplyVO.setRno(rrPno[i % 5]);
//            requestReplyVO.setContent("새롭게 추가된 댓글" + i);
//            requestReplyVO.setName("잘가");
//            rreplyMapper.insert(requestReplyVO);
//        });
//    }


//    @Test
//    public void getReplyTest(){
//        log.info(rreplyMapper.getReply(5L).toString());
//    }

//    @Test
//    public void deleteTest(){
//        log.info("DELETE COUNT : " + rreplyMapper.delete(5L));
//    }

//    @Test
//    public void updateTest(){
//        RequestReplyVO requestReplyVO = new RequestReplyVO();
//        requestReplyVO.setRrno(4L);
//        requestReplyVO.setRno(23L);
//        requestReplyVO.setName("잘가");
//        requestReplyVO.setContent("꿀꽈배기먹고싶다");
//        log.info("UPDATE COUNT : " + rreplyMapper.update(requestReplyVO));
//    }

//    @Test
//    public void getListTest(){
//        rreplyMapper.getList(new Criteria(1, 10),22L)
//                .stream().map(RequestReplyVO::toString).forEach(log::info);
//    }

//    @Test
//    public void getTotalTest(){
//        log.info("댓글 개수 : " + rreplyMapper.getTotal(22L));
//    }

    }

















