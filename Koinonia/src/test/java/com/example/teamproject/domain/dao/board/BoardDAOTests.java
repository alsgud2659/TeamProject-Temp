package com.example.teamproject.domain.dao.board;

import com.example.teamproject.domain.dao.board.BoardDAO;
import com.example.teamproject.domain.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class BoardDAOTests {
    @Autowired
    private BoardDAO boardDAO;

    // 게시글 등록
    @Test
    public void registerTest(){
        BoardVO boardVO = new BoardVO();
        boardVO.setTitle("Test");
        boardVO.setContent("Test");
        boardVO.setName("tester");
        boardDAO.register(boardVO);
    }

    //
    @Test
    public void readTest(){
        boardDAO.read(3L);
    }

    @Test
    public void modifyTest(){
        BoardVO boardVO = new BoardVO();
        boardVO.setTitle("Test");
        boardVO.setBno(3L);
        boardVO.setContent("test수정");
        boardVO.setName("tester");
        boardDAO.modify(boardVO);
    }
}
