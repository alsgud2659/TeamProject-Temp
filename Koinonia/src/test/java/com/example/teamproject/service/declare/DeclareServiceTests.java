package com.example.teamproject.service.declare;

import com.example.teamproject.service.board.BoardReplyServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class DeclareServiceTests {
    @Autowired
    private DeclareServieceImpl declareServiece;
}
