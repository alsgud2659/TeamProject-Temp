package com.example.teamproject.domain.dao.user;

import com.example.teamproject.domain.vo.UserDTO;
import com.example.teamproject.domain.vo.UserVO;
import com.example.teamproject.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserDAO {
    private final UserMapper userMapper;

    // 회원 등록
    public void register(UserVO userVO){
        userMapper.insert(userVO);
    };

    // 이메일 조회(중복체크)
    public int checkEmail(String email){
        return  userMapper.checkEmail(email);
    }

    // 아이디 조회(중복체크)
    public int checkName(String email){
        return  userMapper.checkName(email);
    }

    // 로그인
    public UserVO login(String email){
        return userMapper.login(email);
    }

    // 회원 1명 조회
    public UserVO read(String email){
        return userMapper.find(email);
    };

    // 회원 수정
    public int modify(UserVO userVO){
        return userMapper.update(userVO);
    };



    // 비밀번호 수정
    public void modifyPw(String newPw, String email) {userMapper.updatePw(newPw, email);}


    // 회원 이름 수정
    public int updateName(UserVO userVO){
        return userMapper.nameupdate(userVO);
    }

    // 회원 삭제
    public int remove(String email, String pw){
        return userMapper.delete(email,pw);
    };

    public List<UserDTO> mysell(String name){ return userMapper.myproduct(name);}

//    // 회원 리스트
//    public List<UserVO> getList(){
//
//    };
}
