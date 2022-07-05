
package com.example.teamproject.service.user;

import com.example.teamproject.domain.dao.board.BoardDAO;
import com.example.teamproject.domain.dao.user.UserDAO;
import com.example.teamproject.domain.vo.BoardVO;
import com.example.teamproject.domain.vo.UserDTO;
import com.example.teamproject.domain.vo.UserVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl {
    private final UserDAO userDAO;
    private final BoardDAO boardDAO;

    // 회원 등록
    public void register(UserVO userVO) {
        userDAO.register(userVO);
    };
    // 이메일 중복 확인
    public int checkEmail(String email) {
        return userDAO.checkEmail(email);
    }
    // 이메일 중복 확인
    public int checkName(String name) {
        return userDAO.checkName(name);
    }

    // 비밀번호 조회(로그인)
    public UserVO login(String email){
        return userDAO.login(email);
    }

    // 회원 1명 조회
    public UserVO read(String email) {
        return userDAO.read(email);
    };

    // 회원 수정
    public int modify(UserVO userVO) {
        return userDAO.modify(userVO);
    }

    // 비밀번호 수정
    public void modifyPw(String newPw, String email) { userDAO.modifyPw(newPw, email);}


    // 회원 삭제
    public int remove(String email, String pw) {
        return userDAO.remove(email, pw);
    }

     // 나의 상품 조회
    public List<UserDTO> mysell(String name) { return userDAO.mysell(name);}

    ;





    // 회원 이름 수정
//    public boolean modifyName(UserVO userVO, BoardVO boardVO) {
//        if (userDAO.updateName(userVO) + boardDAO.updateName(boardVO) >= 2) {
//            return true;
//        } else {
//            return false;
//        }
//    }
}

