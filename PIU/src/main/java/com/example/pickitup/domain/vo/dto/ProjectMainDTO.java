package com.example.pickitup.domain.vo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class ProjectMainDTO {
    private Long num;
    private String title;
    private String terrain;
    private Long point;
    private Long jjimCount;
    private String projectDate;
    private Long applyCount;


    public ProjectMainDTO(Long num,String title, String terrain, Long point, Long jjimCount, String projectDate, Long applyCount) {
        this.num =num;
        this.title = title;
        this.terrain = terrain;
        this.point = point;
        this.jjimCount = jjimCount;
        this.projectDate= projectDate;
        this.applyCount = applyCount;
    }

}
