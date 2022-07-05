package com.example.teamproject.mapper;

import com.example.teamproject.domain.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class UserMapperTests{

@Autowired
private UserMapper userMapper;

//      @Test
//      public void checkIdTest(){
//          String email = "일이다";
//           userMapper.checkId(email);
//      }

//    @Test
//    public void insertTest() {
//        UserVO userVO = new UserVO();
//        userVO.setEmail("테스트2");
//        userVO.setPw("테스트2");
//        userVO.setName("테스트");
//        userVO.setCover("테스트");
//
//        userMapper.insert(userVO);
//    }


//    @Test
//    public void loginTest(){
//        UserVO userVO = new UserVO();
//        userVO.setEmail("이메일");
//        userVO.setPw("비밀번호");
//
//        log.info(userMapper.login(userVO).toString());
//       String name = userMapper.login(userVO).toString();
//       if (name != null) {
//           log.info("로그인 성공입니다");
//        }else {
//           log.info("회원정보를 올바르게 입력하세요");
//       }
//
//    }

//    @Test
//    public void updateTest() {
//        Long unum = 1L;
//        UserVO userVO = userMapper.getInfo(unum);
//        userVO.setName("잘가");
//        userMapper.update(userVO);
//    }

//    @Test
//    public void deleteTest(){
//        String email = "테스트2";
//        String pw = "성공";
//
//        log.info("삭제 번호 : " + userMapper.delete(email,pw));
//
//    }

//    @Test
//    public void findTest(){
//        String email = "테스트2";
//        String Npw = "성공";
//        int result = userMapper.checkId(email);
//        log.info("반환결과는 : " + result);
//        if(result == 1){
//            UserVO userVO = userMapper.find(email);
//            userVO.setPw(Npw);
//            userMapper.update(userVO);
//            log.info("비밀번호 수정에 성공하였습니다");
//        }else {
//            log.info("비밀번호 수정에 실패하였습니다");
//        }
//    }


//     @Test
//    public void myprodctTest(){
//         String name = "테스트임";
//         log.info(userMapper.myproduct(name).toString());
//     }

    }

















