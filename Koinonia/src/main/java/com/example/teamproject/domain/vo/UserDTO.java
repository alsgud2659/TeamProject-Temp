package com.example.teamproject.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class UserDTO {
    private String name;
    private String pname;
    private String price;
    private Long pno;

}
