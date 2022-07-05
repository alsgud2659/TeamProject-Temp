package com.example.teamproject.domain.dao.user;

import com.example.teamproject.domain.dao.user.UserDAO;
import com.example.teamproject.domain.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class UserDAOTests {
    @Autowired
    private UserDAO userDAO;

    // 회원등록
    @Test
    public void registerTest(){
        UserVO userVO = new UserVO();
        userVO.setEmail("test@test.com");
        userVO.setPw("test00");
        userVO.setName("tester");
        userVO.setCover("테스트입니다.");
        userDAO.register(userVO);
    };
    // 이메일 중복 확인
    @Test
    public void checkEmailTest(){
        String emailTrue = "testttttttttttttt@aaaaaaaa.com";
        String emailFalse = "test@test.com";
        log.info("사용가능한 아이디입니다." + userDAO.checkEmail(emailTrue));
        log.info("존재하는 아이디입니다." + userDAO.checkEmail(emailFalse));
    }
    // 이름 중복 확인
    @Test
    public void checkNameTest(){
        String nameTrue = "noName";
        String nameFalse = "tester3";
        log.info("사용가능한 이름입니다." + userDAO.checkName(nameTrue));
        log.info("존재하는 이름입니다." + userDAO.checkName(nameFalse));
    }

    // 비밀번호 조회(로그인)
    @Test
    public void loginTest(){
        String email = "test@test.com";
        log.info("조회한 비밀번호 : " + userDAO.login(email).getPw());
    }

    // 회원 1명 조회
    @Test
    public void readTest(){
        String email = "test@test.com";
        userDAO.read(email);
    };

    // 회원 수정
    @Test
    public void modifyTest(){
        UserVO userVO = new UserVO();
        userVO.setEmail("test@test.com");
        userVO.setPw("test00");
        userVO.setName("tester");
        userVO.setCover("테스트입니다. 수정");
        userDAO.modify(userVO);
    };
}
