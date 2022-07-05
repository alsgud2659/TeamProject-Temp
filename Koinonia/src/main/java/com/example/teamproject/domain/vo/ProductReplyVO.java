package com.example.teamproject.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ProductReplyVO {
    private Long prno;
    private Long pno;
    private String content;
    private String name;
    private String registerDate;
    private String updateDate;
}
