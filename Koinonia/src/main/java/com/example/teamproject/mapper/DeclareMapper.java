package com.example.teamproject.mapper;


import com.example.teamproject.domain.vo.Criteria;
import com.example.teamproject.domain.vo.DeclareVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeclareMapper {
    public List<DeclareVO> getList(Criteria criteria);
    public void insert(DeclareVO declareVO);
    public int update(DeclareVO declareVO);
    public DeclareVO get(Long dno);
    public int delete(Long dno);
    public int getTotal(String name);
}
