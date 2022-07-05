package com.example.teamproject.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PReplyPageDTO {
    private List<ProductReplyVO> list;
    private int total;
}
