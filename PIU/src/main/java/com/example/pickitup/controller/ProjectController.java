package com.example.pickitup.controller;

import com.example.pickitup.domain.vo.dto.AdminQnaDTO;
import com.example.pickitup.domain.vo.dto.ApplyDTO;
import com.example.pickitup.domain.vo.project.projectFile.ProjectVO;
import com.example.pickitup.domain.vo.project.projectQna.ProjectQnaVO;
import com.example.pickitup.domain.vo.project.projectReview.ProjectReviewVO;
import com.example.pickitup.domain.vo.user.ApplyVO;
import com.example.pickitup.domain.vo.user.JjimVO;
import com.example.pickitup.service.CompanyService;
import com.example.pickitup.service.ProjectService;
import com.example.pickitup.service.TempAdminService;
import com.example.pickitup.service.TempUserSerivce;
import com.example.pickitup.service.user.ApplyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.mail.Session;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/project/*")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;
    private final TempAdminService tempAdminService;
    private final ApplyService applyService;
    private final CompanyService companyService;
    private final TempUserSerivce tempUserSerivce;



    // 프로젝트 상세보기
    @GetMapping("/projectDetail")
    public String projectDetail(HttpSession session, Long num, Model model) throws ParseException {
        int checkLogin=3;
        Long userNum = Long.parseLong(session.getAttribute("num").toString());
        model.addAttribute("userNum",userNum);
//        model.addAttribute("fileName",session.getAttribute("fileName"));
//        model.addAttribute("uploadPath",session.getAttribute("uploadPath"));
//        model.addAttribute("checkLogin",checkLogin);
//        model.addAttribute("userNum", userNum);

        ProjectVO projectVO = projectService.read(num);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date projectDate = sdf.parse(projectVO.getStartTime());
        SimpleDateFormat addSdf = new SimpleDateFormat("yyyy년 MM월 dd일 EE요일 HH:mm");
        projectVO.setStartTime(addSdf.format(projectDate));

        model.addAttribute("company", companyService.readCompanyInfo(projectVO.getCompanyNum()));
        model.addAttribute("project", projectVO);
        model.addAttribute("qna", projectService.getQnAList(num));
        model.addAttribute("img", projectService.getProjectFileList(num));
        return "/project/projectDetail";
    }

    // 프로젝트 문의 작성
    @GetMapping("/qnaWrite")
    public void qnaWrite( Long num, Model model){
//        int checkLogin=3;
//        Long userNum = Long.parseLong(session.getAttribute("num").toString());
//        model.addAttribute("fileName",session.getAttribute("fileName"));
//        model.addAttribute("uploadPath",session.getAttribute("uploadPath"));
//        model.addAttribute("checkLogin",checkLogin);
//        model.addAttribute("userNum", userNum);

        // projectNum, title -> model 사용
        // userNum -> 쿠키 및 세션 사용
        model.addAttribute("project", projectService.read(num));
    }


    // 프로젝트 문의 작성폼
    @PostMapping("/qnaWriteForm")
    public String qnaWriteForm(HttpSession session,ProjectQnaVO projectQnaVO, Model model) throws ParseException {

        // 임시
        int checkLogin=3;
        Long userNum = Long.parseLong(session.getAttribute("num").toString());
        model.addAttribute("fileName",session.getAttribute("fileName"));
        model.addAttribute("uploadPath",session.getAttribute("uploadPath"));
        model.addAttribute("checkLogin",checkLogin);
        model.addAttribute("userNum", userNum);
// 임시
        projectQnaVO.setUserNum(userNum);
        projectService.registerQnA(projectQnaVO);
        return projectDetail(session,41L, model);

    }

    // 프로젝트 등록 스텝 1
    @GetMapping("/createStep")
    public void createStep1(Model model){
        model.addAttribute("companyNum", 10L);
    }

    // 프로젝트 등록 스텝 1
    @PostMapping("/createStepForm")
    public String projectCreate(ProjectVO projectVO){
//        Long companyNum = Long.parseLong(session.getAttribute("num").toString());
        String startDate = projectVO.getStartTime().substring(0,10)+" "+projectVO.getStartTime().substring(11,16)+":00";
        String endDate = projectVO.getEndTime().substring(0,10)+" "+projectVO.getEndTime().substring(11,16)+":00";
        projectVO.setStartTime(startDate);
        projectVO.setEndTime(endDate);
        projectVO.setCompanyNum(10L);
        projectService.registerProject(projectVO);
        return "/project/createStep";

    }

    // 프로젝트 수정
    @GetMapping("/modifyProject")
    public String modifyProject(Long num, Model model){
        model.addAttribute("project", projectService.read(num));
        return "project/modifyProject";

    }

    // 프로젝트 수정 폼
    @PostMapping("/modifyProjectForm")
    public String modifyProjectForm(ProjectVO projectVO){
        projectService.update(projectVO);
        return "/group/main";
    }

    // 프로젝트 찜 추가
    @PostMapping("/jjim")
    @ResponseBody
    public void addJjim(@RequestBody JjimVO jjimVO){
        projectService.addJjim(jjimVO);
    }

    // 프로젝트 찜 해제
    @DeleteMapping("/jjim")
    @ResponseBody
    public void removeJjim(@RequestBody JjimVO jjimVO){
        projectService.removeJjim(jjimVO);
    }

    // 프로젝트 찜 개수
    @GetMapping("/jjim/{projectNum}")
    @ResponseBody
    public int countJjim(@PathVariable ("projectNum") Long projectNum){
        int count = projectService.jjimCount(projectNum);
        return count;
    }

    // 프로젝트 지원
    @PostMapping("/apply")
    @ResponseBody
    public void applyProject(@RequestBody ApplyVO applyVO,HttpSession session, Model model){
        Long userNum = Long.parseLong(session.getAttribute("num").toString());
        // 임시

        model.addAttribute("userNum", userNum);
        applyVO.setUserNum(userNum);
        applyService.apply(applyVO);
    }

    // 유저 프로젝트 시작
    @GetMapping("/apply/start")
    @ResponseBody
    public void userStart(@RequestBody ApplyDTO applyDTO){
        applyService.userStart(applyDTO);
    }

    // 유저 프로젝트 종료
    @GetMapping("/apply/end")
    @ResponseBody
    public void userEnd(@RequestBody ApplyDTO applyDTO){
        applyService.userEnd(applyDTO);
    }


    // 유저 프로젝트 완료
    @GetMapping("/apply/finish/{num}")
    @ResponseBody
    public void userFinish(@PathVariable("num") Long num){
        applyService.userFinish(num);
    }

    // 프로젝트 지원한 유저 목록
    @GetMapping("/apply/list/{projectNum}")
    @ResponseBody
    public List<ApplyDTO> getApplyUser(@PathVariable("projectNum") Long projectNum){
        return applyService.getApplyUser(projectNum);
    }

    // 후기 작성
    // 세션에서 작성자 정보 확인
    @GetMapping("/review/add/{projectNum}")
    public String addReview(Long projectNum, Model model, HttpSession session){
        Long userNum = Long.parseLong(session.getAttribute("num").toString());
        model.addAttribute("user",tempUserSerivce.readUserInfo(userNum));
        model.addAttribute("projectNum", projectNum);
        return "/project/projectReviewWrite";
    }

    // 후기 작성폼
    @PostMapping("/review/add")
    public String addReviewForm(ProjectReviewVO projectReviewVO, Model model,HttpSession session){
        Long userNum = Long.parseLong(session.getAttribute("num").toString());
        projectReviewVO.setUserNum(userNum);
        projectReviewVO.setProjectNum(userNum);
        projectService.registerReview(projectReviewVO);

        return reivewList(userNum, model,session);
    }

    // 후기 목록
    @GetMapping("/review/list")
    public String reivewList(Long projectNum, Model model,HttpSession session){
        Long userNum = Long.parseLong(session.getAttribute("num").toString());
        model.addAttribute("reviews", projectService.getProjectReviewList(41L));
        return "project/projectReviewAll";
    }

    // 후기 수정
    @GetMapping("/review/modify")
    public String modifyForm(Long num, Model model){
        log.info("======================" + num);
        model.addAttribute("review", projectService.readReview(num));
        return "/project/projectReviewModify";

    }

    // 후기 수정폼
    @PostMapping("/review/modify")
    public String modifyReviewForm(ProjectReviewVO projectReviewVO, Model model,HttpSession session){
        Long userNum = Long.parseLong(session.getAttribute("num").toString());
        projectReviewVO.setUserNum(userNum);
        projectReviewVO.setProjectNum(userNum);
        projectService.modifyReview(projectReviewVO);
        return addReview(41L, model,session);
    }

    // 후기 삭제 
    @ResponseBody
    @DeleteMapping("/review/remove/{reviewNum}")
    public void removeReview(@PathVariable("reivewNum") Long reviewNum){
        projectService.removeReview(reviewNum);
    }





}
