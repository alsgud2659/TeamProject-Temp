package com.example.teamproject.mapper;

import com.example.teamproject.domain.vo.Criteria;
import com.example.teamproject.domain.vo.RequestVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class RequestMapperTests {

@Autowired
private RequestMapper requestMapper;


//    @Test
//    public void insertTest() {
//        RequestVO requestVO = new RequestVO();
//        requestVO.setTitle("테스트1");
//        requestVO.setContent("테스트1");
//        requestVO.setName("잘가");
//        requestMapper.insert(requestVO);
//    }



//    @Test
//    public void updateTest() {
//        Long rno = 3L;
//        RequestVO requestVO = requestMapper.get(rno);
//        requestVO.setTitle("테스트2");
//        requestVO.setContent("테스트2");
//        log.info("반환된 결과값은 : " + requestMapper.update(requestVO));
//    }
//


//    @Test
//    public void getTest(){
//        Long rno = 3L;
//        log.info("2번게시물의 정보입니다" + requestMapper.get(rno));
//    }
//
//    @Test
//    public void getTotalTest(){
//        log.info("총 갯수는 " + requestMapper.getTotal());
//    }
//
//    @Test
//    public void getListTest(){
//        requestMapper.getList(new Criteria(1, 10)).stream().map(RequestVO::toString).forEach(log::info);
//    }






    }

















