package com.example.teamproject.controller.declare;

import com.example.teamproject.domain.vo.DeclareVO;


import com.example.teamproject.domain.vo.UserVO;

import com.example.teamproject.service.declare.DeclareServieceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@Slf4j
@RequestMapping("/declare/*")
@RequiredArgsConstructor
public class DeclareController {
    private final DeclareServieceImpl declareService;
    // 신고

    @GetMapping("/")
    public String goToDeclare() {
        log.info("*************");
        log.info("신고");
        log.info("*************");
        return "/declare/declare";
    }

    @GetMapping("/count")
    public String countDeclaration(String name, Model model){
        log.info("*************");
        log.info("해당 유저의 신고당한 횟수 조회");
        log.info("*************");
        model.addAttribute("name", name);
        model.addAttribute("count", declareService.getTotal(name));
        return "/declare/declare";
    }

    @GetMapping("/register")
    public String register() {
        log.info("*************");
        log.info("신고 작성");
        log.info("*************");
        return "/declare/board_declare";
    }

    @PostMapping("/register")
    public String register(DeclareVO declareVO) {
        log.info("*************");
        log.info("신고 작성");
        log.info("*************");
        declareService.register(declareVO);
        return "/declare/declare";
    }


//    @PostMapping("/register")
//    public String register(DeclareVO declareVO, RedirectAttributes rttr){
//        log.info("*************");
//        log.info("신고 등록");
//        log.info("*************");
//        // 신고 등록
//        return new RedirectView("/declare/list");
//    }

    // 이메일로 사용자 신고당한 이력 조회

//    @GetMapping("/list")
//    public String getList(Model model){
//        log.info("*************");
//        log.info("신고 리스트");
//        log.info("*************");
//        // 신고 리스트
//        return "/declare/list";
//    }

//    @GetMapping("/detail")
//    public String read(Long dno, Model model){
//        log.info("*************");
//        log.info("신고 상세");
//        log.info("*************");
//        // 신고 상세
//        return "/declare/detail";
//    }

//    @GetMapping("/modify")
//    public String modify(Long dno){
//        log.info("*************");
//        log.info("신고 수정");
//        log.info("*************");
//        // 신고 수정
//        return "/declare/modify";
//    }
//    @PostMapping("/modify")
//    public String modify(Long dno, RedirectAttributes rttr){
//        log.info("*************");
//        log.info("신고 수정 완료");
//        log.info("*************");
//        // 신고 수정 완료
//        return new RedirectView("/declare/list");
//    }
}
