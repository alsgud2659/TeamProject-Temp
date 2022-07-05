package com.example.pickitup.controller;

import com.example.pickitup.service.ProjectService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;

import java.awt.event.WindowFocusListener;
import java.text.ParseException;

@Controller
@Slf4j
@RequestMapping("/main/*")
@RequiredArgsConstructor
public class MainController {
    private final ProjectService projectService;


    // 메인페이지
    @GetMapping("/main")
    public String main(HttpSession session, Model model,HttpServletRequest request) throws ParseException {
       int checkLogin=0;
        System.out.println("=============="+request.getRequestURI().split("/")[1]);

        if(session.getAttribute("token")!=null){  //카카오로 로그인하고 들어왔을때
            checkLogin = 2;
            Long userNum = Long.parseLong(session.getAttribute("num").toString());
            model.addAttribute("userNum",userNum);
        }else if(session.getAttribute("num")!=null&&session.getAttribute("nickname")!=null){ //일반로그인 하고 들어왔을때
            checkLogin= 3;
            Long userNum = Long.parseLong(session.getAttribute("num").toString());
            model.addAttribute("userNum",userNum);
        }else{  //일반 로그인 안하고 들어왔을떄
           checkLogin= 1;
//            Long userNum = Long.parseLong(session.getAttribute("num").toString());
//            model.addAttribute("userNum",userNum);
       }
        model.addAttribute("fileName",session.getAttribute("fileName"));
        model.addAttribute("uploadPath",session.getAttribute("uploadPath"));
        model.addAttribute("checkLogin",checkLogin);
        model.addAttribute("projectListJJim", projectService.getListJJim());  // 내용가져오기
        model.addAttribute("projectListPoint", projectService.getListPoint());  // 내용가져오기
        model.addAttribute("projectListApply", projectService.getListApply());  // 내용가져오기
        model.addAttribute("course1",projectService.getListCourse("산"));
        model.addAttribute("course2",projectService.getListCourse("바다"));
        model.addAttribute("course3",projectService.getListCourse("강"));
        model.addAttribute("url",request.getRequestURI().split("/")[1]);
        log.info("메인 들어옴");
       return "/main/main";
    }





//    @GetMapping("/list/{course}")
//    public String List(@PathVariable("course") String course, Model model) throws ParseException {
//        model.addAttribute("courseList", projectService.getListCourse(course));  // 내용가져오기
//        if(course.equals("평지")){
//            model.addAttribute("courseType", "평지 타입");
//        }else if(course.equals("바다")){
//            model.addAttribute("courseType", "바다 타입");
//        }else if(course.equals("산")){
//            model.addAttribute("courseType", "산 타입");
//        }
//        return "/main/list";
//    }

    @GetMapping("/list/{terrain}")
    public String List(HttpSession session, @PathVariable("terrain") String terrain, Model model) throws ParseException {
        int checkLogin=3;
        Long userNum = Long.parseLong(session.getAttribute("num").toString());
        model.addAttribute("fileName",session.getAttribute("fileName"));
        model.addAttribute("uploadPath",session.getAttribute("uploadPath"));
        model.addAttribute("checkLogin",checkLogin);

        model.addAttribute("courseList", projectService.getListTerrain(terrain));  // 내용가져오기
        if(terrain.equals("1")){
            model.addAttribute("courseType", "산 타입");
        }else if(terrain.equals("2")){
            model.addAttribute("courseType", "바다 타입");
        }else if(terrain.equals("3")){
            model.addAttribute("courseType", "평지 타입");
        }
        return "/main/list";
    }

    @GetMapping("/list")
    public String List(HttpSession session, HttpServletRequest request,Model model) throws ParseException {
        int checkLogin=3;
        Long userNum = Long.parseLong(session.getAttribute("num").toString());
        model.addAttribute("fileName",session.getAttribute("fileName"));
        model.addAttribute("uploadPath",session.getAttribute("uploadPath"));
        model.addAttribute("checkLogin",checkLogin);
        
        String ch2  = request.getParameter("headerSearch");
        System.out.println(ch2);
        if(ch2!=null){
            model.addAttribute("courseList", projectService.getSearchList(ch2));
            model.addAttribute("courseType", ch2+" 검색결과 ");
        }else {
            model.addAttribute("courseList", projectService.getListTotalSearch());
            model.addAttribute("courseType", " ");
        }
        return "/main/list";
    }


//    @GetMapping("/list")
//    public void search(HttpServletRequest request,Model model){
//        String ch2  = request.getParameter("headerSearch");
//        System.out.println(ch2);
//        model.addAttribute("courseList", projectService.getSearchList(ch2));
//    }

}
