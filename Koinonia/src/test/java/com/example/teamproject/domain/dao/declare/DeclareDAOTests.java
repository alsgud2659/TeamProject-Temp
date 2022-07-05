package com.example.teamproject.domain.dao.declare;

import com.example.teamproject.domain.dao.declare.DeclareDAO;
import com.example.teamproject.domain.dao.user.UserDAO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class DeclareDAOTests {
    @Autowired
    private DeclareDAO declareDAO;
}
