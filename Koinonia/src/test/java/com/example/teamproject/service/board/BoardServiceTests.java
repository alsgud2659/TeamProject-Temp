package com.example.teamproject.service.board;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@Slf4j
public class BoardServiceTests {
    @Autowired
    private BoardServiceImpl boardService;

    @Test
    public void readTest(){
        log.info(boardService.read(3L).toString());
    }
}
