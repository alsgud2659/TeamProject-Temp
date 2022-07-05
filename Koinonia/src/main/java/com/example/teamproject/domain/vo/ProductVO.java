package com.example.teamproject.domain.vo;


import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class ProductVO {
    private Long pno;
    private String name;
    private String pname;
    private String pcate;
    private String title;
    private String content;
    private String price;
    private String psold;
    private String registerDate;
    private String updateDate;
    private List<ProductFileVO> fileList;


//    private List<PFileVO> fileList;
}
