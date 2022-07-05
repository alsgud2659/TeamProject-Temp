package com.example.teamproject.service.board;

import com.example.teamproject.domain.dao.board.BoardFileDAO;
import com.example.teamproject.domain.dao.product.ProductFileDAO;
import com.example.teamproject.domain.vo.FileVO;
import com.example.teamproject.domain.vo.ProductFileVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardFileServiceImpl {
    private final BoardFileDAO boardFileDAO;

    // 해당 판매상품의 파일 목록
    public List<FileVO> getList(Long bno) {
        return boardFileDAO.getList(bno);
    }

    public void register(FileVO fileVO){ boardFileDAO.register(fileVO);}
}

