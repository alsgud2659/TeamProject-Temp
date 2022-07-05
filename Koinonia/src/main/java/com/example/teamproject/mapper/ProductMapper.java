package com.example.teamproject.mapper;


import com.example.teamproject.domain.vo.BoardVO;
import com.example.teamproject.domain.vo.Criteria;
import com.example.teamproject.domain.vo.ProductVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
    public List<ProductVO> getList(Criteria criteria);
    public void insert(ProductVO productVO);
    public int update(ProductVO productVO);
    public ProductVO get(Long pno);
    public int delete(Long pno);
    public int getTotal();
    public List<ProductVO> getListMain(Criteria criteria);





}
