package com.example.teamproject.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class DeclareVO {
    private Long dno;
    private String title;
    private String name;
    private String content;
    private String registerDate;
    private String updateDate;
}
