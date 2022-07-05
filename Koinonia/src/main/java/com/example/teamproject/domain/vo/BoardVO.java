package com.example.teamproject.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class BoardVO {
    private Long bno;
    private String title;
    private String content;
    private String name;
    private String registerDate;
    private String updateDate;
    private String bcate;
    private List<FileVO> fileList;
}
