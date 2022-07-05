package com.example.teamproject.mapper;

import com.example.teamproject.domain.vo.BoardReplyVO;
import com.example.teamproject.domain.vo.Criteria;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
@Slf4j
public class BoardReplyMapperTests {

@Autowired
private ReplyMapper replyMapper;


    private Long[] arBno = {10L, 11L, 12L, 13L, 14L};


//    @Test
//    public void insertTest(){
//        // 최근 5개의 게시글에 2개씩 댓글 달기
//        IntStream.rangeClosed(1, 10).forEach(i -> {
//            BoardReplyVO boardReplyVO = new BoardReplyVO();
//            boardReplyVO.setBno(arBno[i % 5]);
//            boardReplyVO.setContent("새롭게 추가된 댓글" + i);
//            boardReplyVO.setName("제발되라아아아");
//            replyMapper.insert(boardReplyVO);
//        });
//    }

//    @Test
//    public void getReplyTest(){
//        log.info(replyMapper.getReply(1L).toString());
//    }

//    @Test
//    public void deleteTest(){
//        log.info("DELETE COUNT : " + replyMapper.delete(2L));
//    }

//    @Test
//    public void updateTest(){
//        BoardReplyVO boardReplyVO = new BoardReplyVO();
//        boardReplyVO.setRno(3L);
//        boardReplyVO.setBno(11L);
//        boardReplyVO.setName("수정1");
//        boardReplyVO.setContent("꿀꽈배기먹고싶다");
//        log.info("UPDATE COUNT : " + replyMapper.update(boardReplyVO));
//    }

//    @Test
//    public void getListTest(){
//        replyMapper.getList(new Criteria(1, 10), 11L)
//                .stream().map(BoardReplyVO::toString).forEach(log::info);
//    }

//    @Test
//    public void getTotalTest(){
//        log.info("댓글 개수 : " + replyMapper.getTotal(11L));
//    }

    }

















