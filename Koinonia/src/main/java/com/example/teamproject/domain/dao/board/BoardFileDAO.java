package com.example.teamproject.domain.dao.board;

import com.example.teamproject.domain.vo.BoardFileVO;
import com.example.teamproject.domain.vo.FileVO;
import com.example.teamproject.domain.vo.ProductFileVO;
import com.example.teamproject.mapper.FileMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardFileDAO {
    private final FileMapper boardFileMapper;

    // 판매 상품 목록
    public List<FileVO> getList(Long bno){
        return boardFileMapper.getList(bno);
    };
    public void remove(Long bno){
        boardFileMapper.delete(bno);
    }
    public void register(FileVO fileVO){
        boardFileMapper.insert(fileVO);
    }

}
