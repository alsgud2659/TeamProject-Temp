package com.example.teamproject.mapper;



import com.example.teamproject.domain.vo.BoardDTO;


import com.example.teamproject.domain.vo.BoardVO;
import com.example.teamproject.domain.vo.Criteria;
import com.example.teamproject.domain.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class BoardMapperTests {

@Autowired
private BoardMapper boardMapper;


//    @Test
//    public void insertTest() {
//        BoardVO boardVO = new BoardVO();
//        boardVO.setTitle("테스트1");
//        boardVO.setContent("테스트1");
//        boardVO.setName("수정1");
//        boardMapper.insert(boardVO);
//    }



//    @Test
//    public void updateTest() {
//        Long bno = 3L;
//        BoardVO boardVO = boardMapper.get(bno);
//        boardVO.setTitle("테스트2");
//        boardVO.setContent("테스트2");
//        log.info("반환된 결과값은 : " + boardMapper.update(boardVO));
//    }
//
//    @Test
//    public void deleteTest() {
//        Long bno = 4L;
//        log.info("삭제 번호 : " + boardMapper.delete(bno));
//    }

//    @Test
//    public void getTest(){
//        Long bno = 2L;
//        log.info("2번게시물의 정보입니다" + boardMapper.get(bno));
//    }

//    @Test
//    public void getTotalTest(){
//        log.info("총 갯수는 " + boardMapper.getTotal());
//    }

//    @Test
//    public void getListTest(){
//        boardMapper.getList(new Criteria(1, 10)).stream().map(BoardVO::toString).forEach(log::info);
//    }


    @Test
    public void getListBySearchTest(){
        Criteria criteria = new Criteria(1, 10);
        criteria.setKeyword("2");
        criteria.setType("title");
        boardMapper.getListBySearch(criteria).stream().map(BoardDTO::toString).forEach(log::info);
    }





    }

















