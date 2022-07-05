package com.example.teamproject.mapper;



import com.example.teamproject.domain.vo.BoardDTO;

import com.example.teamproject.domain.vo.BoardVO;
import com.example.teamproject.domain.vo.Criteria;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    public List<BoardVO> getList(Criteria criteria);
    public void insert(BoardVO boardVO);
    public int update(BoardVO boardVO);
    public BoardVO get(Long bno);
    public int delete(Long bno);
    public int getTotal();
    public BoardVO diaryDetail(Long bno);


    //다이어리 페이지 리스트(검색조건 포함)
    public List<BoardDTO> getListBySearch(Criteria criteria);

    public List<BoardVO> getListMain(Criteria criteria);







}
