package com.example.teamproject.domain.dao.product;

import com.example.teamproject.domain.dao.product.ProductReplyDAO;
import com.example.teamproject.domain.dao.user.UserDAO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ProductReplyDAOTests {
    @Autowired
    private ProductReplyDAO productReplyDAO;
}
