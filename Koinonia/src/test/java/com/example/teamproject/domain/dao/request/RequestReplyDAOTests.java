package com.example.teamproject.domain.dao.request;

import com.example.teamproject.domain.dao.request.RequestReplyDAO;
import com.example.teamproject.domain.dao.user.UserDAO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class RequestReplyDAOTests {
    @Autowired
    private RequestReplyDAO requestReplyDAO;
}
