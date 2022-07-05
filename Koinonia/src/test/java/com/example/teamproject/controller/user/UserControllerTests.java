package com.example.teamproject.controller.user;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@Slf4j
public class UserControllerTests {
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    public void setUp(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void registerTest() throws Exception{
        log.info("추가된 회원번호 : " + mockMvc.perform(MockMvcRequestBuilders.post("/user/join")
            .param("name", "tester4")
            .param("email", "tester4@test.com")
            .param("pw", "test00")
            .param("cover", "test입니다.")
        ).andReturn().getFlashMap());
    }

    @Test
    public void loginTest() throws Exception{
        log.info(mockMvc.perform(MockMvcRequestBuilders.post("/user/login")
                .param("email", "tester3@test.com")
                .param("pw", "test00")
        ).andReturn().getModelAndView().getModelMap().toString());
    }
}
