package com.example.teamproject.controller.request;

import com.example.teamproject.domain.vo.Criteria;
import com.example.teamproject.domain.vo.RequestVO;
import com.example.teamproject.service.request.RequestServieceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/request/*")
@RequiredArgsConstructor
public class RequestController {
    private final RequestServieceImpl requestServiece;
    // 판매 상품 요청

    @GetMapping("/register")
    public String register(){
        log.info("*************");
        log.info("판매 상품 요청글 작성");
        log.info("*************");
        return "/request/request_write";
    }
//    @PostMapping("/register")
//    public String register(RequestVO requestVO, RedirectAttributes rttr){
//        log.info("*************");
//        log.info("판매 상품 요청글 등록");
//        log.info("*************");
//        // 판매 상품 요청글 등록
//        return new RedirectView("/request/list");
//    }


    @GetMapping("/list")
    public String getList(Criteria criteria, Model model){
        log.info("*************");
        log.info("상품 요청 리스트");
        log.info("*************");
        return "/request/request_list";
    }
    // 무한스크롤 - rest

    @GetMapping("/detail")
    public String read(Long rno, Model model){
        log.info("*************");
        log.info("상품 요청글 상세");
        log.info("*************");
        // 상품 요청글 상세

        return "/request/detail";
    }

    @GetMapping("/modify")
    public String modify(Long rno){
        log.info("*************");
        log.info("상품 요청글 수정");
        log.info("*************");
        // 상품 요청글 수정
        return "/request/modify";
    }
//    @PostMapping("/modify")
//    public String modify(Long rno, RedirectAttributes rttr){
//        log.info("*************");
//        log.info("상품 요청글 수정 완료");
//        log.info("*************");
//        // 상품 요청글 수정 완료
//        return new RedirectView("/request/list");
//    }

    ///////////////////////////////////////////////////
    // ResponsBody

    // 상품사진 업로드(상품요청글 작성페이지)
    @PostMapping("/uploadImg")
    @ResponseBody
    public void uploadImg(MultipartFile[] uploadFile) throws IOException {
        String uploadFolder = "C:/upload";
        for(MultipartFile file : uploadFile){
            log.info("--------------------------------");
            log.info("Upload File Name : " + file.getOriginalFilename());
            log.info("Upload File Size : " + file.getSize());

            File saveFile = new File(uploadFolder, file.getOriginalFilename());
            file.transferTo(saveFile);
        }
    }

    // 카테고리별 상품 목록
    @GetMapping("/list/{rcate}") // #카테고리 변수명 미정
    @ResponseBody
    public List<RequestVO> getList(@PathVariable("rcate")String rcate){
        return null;
    }

    // 무한 스크롤
    @GetMapping("/list/{rcate}/{pageNum}")
    @ResponseBody
    public List<RequestVO> getList(@PathVariable("rcate") String rcate, @PathVariable("pageNum") int pageNum){
        return null;
    }
}
