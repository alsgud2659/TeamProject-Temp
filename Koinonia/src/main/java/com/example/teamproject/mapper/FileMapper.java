package com.example.teamproject.mapper;

import com.example.teamproject.domain.vo.FileVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
    public interface FileMapper {
        public void insert(FileVO fileVO);
        public void delete(Long bno);
        public List<FileVO> findBno(Long bno);
        public List<FileVO> getOldFiles();
        public List<FileVO> getList(Long bno);

    }

