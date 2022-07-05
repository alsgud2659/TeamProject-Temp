
//package com.example.teamproject.controller;
//
//import com.example.teamproject.service.board.BoardReplyServiceImpl;
//import com.example.teamproject.service.product.ProductServieceImpl;
//import com.example.teamproject.service.request.RequestServieceImpl;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//@Slf4j
//@RequestMapping("/")
//@RequiredArgsConstructor
//public class MainController {
//    private final BoardReplyServiceImpl boardReplyService;
//    private final ProductServieceImpl productServiece;
//    private final RequestServieceImpl requestServiece;
//
//    @GetMapping("/")
//    public String goToMain(Model model){
//        log.info("*************");
//        log.info("메인페이지");
//        log.info("*************");
//        // 상품 리스트
//        // 다이어리 리스트
//        return "/main/main";
//    }
//}

package com.example.teamproject.controller;

import com.example.teamproject.service.board.BoardServiceImpl;




import com.example.teamproject.domain.vo.*;
import com.example.teamproject.service.board.BoardFileServiceImpl;
import com.example.teamproject.service.board.BoardServiceImpl;
import com.example.teamproject.service.product.ProductFileServiceImpl;

import com.example.teamproject.service.product.ProductServieceImpl;
import com.example.teamproject.service.request.RequestServieceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Controller
@Slf4j
@RequestMapping("/")
@RequiredArgsConstructor
public class MainController {
    private final BoardServiceImpl boardService;
    private final ProductServieceImpl productServiece;
    private final RequestServieceImpl requestServiece;
    private final BoardFileServiceImpl boardFileService;
    private final ProductFileServiceImpl productFileService;

    @GetMapping("/")
    public String goToMain(HttpSession session, Model model) throws IOException {
        log.info("*************");
        log.info("메인페이지");
        log.info("*************");
//         다이어리 리스트
        List<BoardVO> boardList = boardService.getListMain(new Criteria(1, 6));
        model.addAttribute("boardList", boardList) ;
//         다이어리 썸네일 리스트
        String bRequestUrl = "/boardFile/display?fileName=";
        String boardThumFileName = "";
        List<String> boardThumfileUrlList = new ArrayList<>();
        for(BoardVO b : boardList){
            List<FileVO> boardFileList = boardFileService.getList(b.getBno());
            if(!boardFileList.isEmpty()){
                boardThumFileName = bRequestUrl + boardFileList.get(0).getUploadPath() + "/"  + boardFileList.get(0).getUuid() + "_" + boardFileList.get(0).getFileName();
            }else{
                boardThumFileName = "/images/no_image.gif";
            }
            boardThumfileUrlList.add(boardThumFileName);
        }
        model.addAttribute("boardThumfileUrlList", boardThumfileUrlList);
//         상품 리스트
        List<ProductVO> productList = productServiece.getListMain(new Criteria(1, 15));
        model.addAttribute("productList", productList) ;
//         상품 썸네일 리스트
        String pRequestUrl = "/productFile/display?fileName=";
        String productThumFileName = "";
        List<String> productThumfileUrlList = new ArrayList<>();
        for(ProductVO p : productList){
            List<ProductFileVO> productFileList = productFileService.getList(p.getPno());
            if(!productFileList.isEmpty()){
                productThumFileName =  pRequestUrl + productFileList.get(0).getUploadPath() + "/"  + productFileList.get(0).getUuid() + "_" + productFileList.get(0).getFileName();
            }else{
                productThumFileName = "/images/no_image.gif";
            }
            productThumfileUrlList.add(productThumFileName);
        }
        model.addAttribute("productThumfileUrlList", productThumfileUrlList);
        return "/main/main";
    }
}

