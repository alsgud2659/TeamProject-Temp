package com.example.teamproject.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class UserVO {
    private Long unum;
    private String name;
    private String pw;
    private String cover;
    private String email;
}
