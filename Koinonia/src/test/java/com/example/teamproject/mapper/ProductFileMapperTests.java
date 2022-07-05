package com.example.teamproject.mapper;

import com.example.teamproject.domain.vo.ProductFileVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ProductFileMapperTests {
    @Autowired
    private ProductFileMapper productFileMapper;

    @Test
    public void getListTest() {
        productFileMapper.getList(23L);
    }
}
