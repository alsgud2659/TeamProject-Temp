package com.example.teamproject.service.user;

import com.example.teamproject.domain.vo.UserDTO;
import com.example.teamproject.domain.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class UserServiceTests {
    @Autowired
    private UserServiceImpl userService;

    // 회원등록
//    @Test
//    public void registerTest() {
//        UserVO userVO = new UserVO();
//        userVO.setEmail("test@test2.com");
//        userVO.setPw("test00");
//        userVO.setName("tester2");
//        userVO.setCover("테스트입니다.");
//        userService.register(userVO);
//    }
//
//    // 이메일 중복 확인
//    @Test
//    public void checkEmailTest(){
//        String emailTrue = "testttttttttttttt@aaaaaaaa.com";
//        String emailFalse = "test@test.com";
//        log.info("사용가능한 아이디입니다." + userService.checkEmail(emailTrue));
//        log.info("존재하는 아이디입니다." + userService.checkEmail(emailFalse));
//    }
//
//    // 이름 중복 확인
//    @Test
//    public void checkNameTest(){
//        String nameTrue = "noName";
//        String nameFalse = "홍길동";
//        log.info("사용가능한 이름입니다." + userService.checkName(nameTrue));
//        log.info("존재하는 이름입니다." + userService.checkName(nameFalse));
//    }
//
//    // 비밀번호 조회(로그인)
//    @Test
//    public void loginTest(){
//        String email = "test@test.com";
//        log.info("조회한 비밀번호 : " + userService.login(email).getPw());
//    }

    @Test
    public void mysellTest(){
        String name ="테스트임";
        log.info(userService.mysell(name).toString());
    }
}
