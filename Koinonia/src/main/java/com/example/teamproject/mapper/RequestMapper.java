package com.example.teamproject.mapper;


import com.example.teamproject.domain.vo.Criteria;
import com.example.teamproject.domain.vo.DeclareVO;
import com.example.teamproject.domain.vo.RequestVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RequestMapper {
    public List<RequestVO> getList(Criteria criteria);
    public void insert(RequestVO requestVO);
    public int update(RequestVO requestVO);
    public RequestVO get(Long rno);
    public int delete(Long rno);
    public int getTotal();






}
