package com.example.teamproject.domain.dao.product;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ProductFileDAOTests {
    @Autowired
    private ProductFileDAO productFileDAO;

    @Test
    public void getListTest() {
        productFileDAO.getList(23L);
    }
}
