package com.example.teamproject.domain.dao.board;

import com.example.teamproject.domain.dao.board.BoardReplyDAO;
import com.example.teamproject.domain.dao.user.UserDAO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class BoardReplyDAOTests {
    @Autowired
    private BoardReplyDAO boardReplyDAO;

}
