package com.example.teamproject.service.product;

import com.example.teamproject.domain.dao.product.ProductFileDAO;
import com.example.teamproject.domain.vo.ProductVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ProductFileServiceTests {
    @Autowired
    private ProductFileServiceImpl productFileService;

    @Test
    public void getListTest() {
        productFileService.getList(23L);
    }

}
