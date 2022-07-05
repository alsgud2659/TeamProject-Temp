package com.example.teamproject.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class ProductFileVO {
    private String fileName;
    private String uploadPath;
    private String uuid;
    private boolean image;
    private Long pno;
    private Long fileSize;
}

