package com.example.teamproject.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class BoardFileVO {
    private Long bno;
    private String uuid;
    private String uploadPath;
    private String fileName;
    private Long fileSize;
}
