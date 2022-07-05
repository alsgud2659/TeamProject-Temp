package com.example.teamproject.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class BoardDTO {
    private Long bno;
    private String title;
    private String content;
    private String name;
    private String registerDate;
    private String updateDate;

    private Long total;
    private String fileName;
    private String uploadPath;
    private String uuid;
}
