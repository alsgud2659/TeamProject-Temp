package com.example.pickitup.service.project;

import com.example.pickitup.domain.vo.user.JjimVO;
import com.example.pickitup.service.ProjectService;
import com.example.pickitup.service.user.JjimService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;

@SpringBootTest
@Slf4j
public class ProjectServiceTest {
    @Autowired
    private ProjectService projectService;
    private JjimService jjimService;

//    @Test
//    public void getListJJimTest(){
//        log.info(projectService.getListJJim().toString());
//    }
//
//    @Test
//    public void getListPointTest(){
//        log.info(projectService.getListPoint().toString());
//    }

    @Test
    public void getListApplyTest() throws ParseException {
        log.info(projectService.getListApply().toString());
    }

    @Test
    public void getListCourseTest() throws ParseException {
        log.info(projectService.getListCourse("산").toString());
    }

    @Test
    public void addJjimTtetes() throws ParseException{
        JjimVO vo = new JjimVO();
        vo.setProjectNum(230L);
        vo.setUserNum(81L);
        vo.setCategory("2");
        projectService.addJjim(vo);
    }
}
