package com.example.teamproject.domain.dao.board;


import com.example.teamproject.domain.vo.BoardVO;

import com.example.teamproject.domain.vo.BoardDTO;
import com.example.teamproject.domain.vo.BoardVO;
import com.example.teamproject.domain.vo.Criteria;

import com.example.teamproject.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardDAO {
    private final BoardMapper boardMapper;

    // 다이어리 목록

//    public List<BoardVO> getList(){
//    };

    public List<BoardVO> getList(Criteria criteria){
        return boardMapper.getList(criteria);
    };


    // 다이어리 등록
    public void register(BoardVO boardVO){
        boardMapper.insert(boardVO);
    };

    // 다이어리 상세보기
    public BoardVO read(Long bno){
        return boardMapper.get(bno);
    };
    public BoardVO diaryDetail(Long bno) {return boardMapper.diaryDetail(bno); }

    // 다이어리 삭제
    public int remove(Long bno){
        return boardMapper.delete(bno);
    };

    // 다이어리 수정
    public int modify(BoardVO boardVO){
        return boardMapper.update(boardVO);
    };

    // 작성자 이름 수정(회원정보에서 이름 수정시)
//    public  int updateName(BoardVO boardVO){
//        return boardMapper.updatename(boardVO);
//    }



    //다이어리 페이지 리스트(검색조건 포함)
    public List<BoardDTO> getListBySearch(Criteria criteria){ return boardMapper.getListBySearch(criteria); }

    public List<BoardVO> getListMain(Criteria criteria){ return boardMapper.getListMain(criteria); }

}

