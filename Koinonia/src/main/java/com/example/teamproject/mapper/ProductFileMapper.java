package com.example.teamproject.mapper;

import com.example.teamproject.domain.vo.ProductFileVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductFileMapper {
    public List<ProductFileVO> getList(Long pno);
    public int delete(Long pno);
    public void insert(ProductFileVO productFileVO);
    public  List<ProductFileVO> getOldFiles();
}
