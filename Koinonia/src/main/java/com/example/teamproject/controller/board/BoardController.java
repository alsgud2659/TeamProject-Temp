package com.example.teamproject.controller.board;


import com.example.teamproject.domain.vo.BoardDTO;

import com.example.teamproject.domain.vo.BoardVO;
import com.example.teamproject.domain.vo.Criteria;
import com.example.teamproject.domain.vo.RequestVO;

import com.example.teamproject.domain.vo.*;
import com.example.teamproject.service.board.BoardFileServiceImpl;

import com.example.teamproject.service.board.BoardServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.util.FileCopyUtils;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;


import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;




@Controller
@Slf4j
@RequestMapping("/board/*")
@RequiredArgsConstructor
public class BoardController {
    private final BoardServiceImpl boardService;
    private final BoardFileServiceImpl boardFileService;
    // 다이어리


    // 작성 페이지 이동
    @GetMapping("/register")
    public String register(HttpSession session){
        log.info("*************");
        log.info("다이어리 작성");
        log.info("*************");
        return "/diary/board_write";
    }



    // 작성 완료
    @PostMapping("/register")
    public RedirectView register(BoardVO boardVO, HttpSession session, RedirectAttributes rttr) {
        // 다이어리 정보 등록
        boardVO.setName(session.getAttribute("name").toString());
        boardService.register(boardVO);
        log.info("파일리스트" + boardVO.getFileList());
        // 다이어리 이미지 정보 등록
        if(boardVO.getFileList() != null) {
            boardVO.getFileList().forEach(fileVO -> {
                fileVO.setBno(boardVO.getBno());
                boardFileService.register(fileVO);
            });
        }
        // 상세 페이지로 이동
        rttr.addAttribute("bno", boardVO.getBno());
        return new RedirectView("/board/detail");
    }

    // 수정 페이지 이동
    @GetMapping("/modify")
    public String modify(Long bno, Model model){
        log.info("*************");
        log.info("다이어리 수정내용 작성/삭제");
        log.info("*************");
        model.addAttribute("board", boardService.read(bno));
        return "/diary/modify_board";
    }
    @PostMapping("/modify")
    public RedirectView modify(BoardVO boardVO, Criteria criteria, RedirectAttributes rttr){
        log.info("*************");
        log.info("다이어리 수정");
        log.info("*************");
        if(boardService.modify(boardVO)==1){
            rttr.addAttribute("pageNum", criteria.getPageNum());
            rttr.addAttribute("amount", criteria.getAmount());
        };
        return new RedirectView("/board/list");
    }


    @GetMapping("/remove")
    public RedirectView remove(Long bno, Criteria criteria, RedirectAttributes rttr){
        log.info("*************");
        log.info("다이어리 삭제");
        log.info("*************");
        if(boardService.remove(bno)==1){
            rttr.addAttribute("pageNum", criteria.getPageNum());
            rttr.addAttribute("amount", criteria.getAmount());
        };
        return new RedirectView("/board/list");
    }

    @GetMapping("/detail")
    public String diaryDetail(Long bno, Model model, Criteria criteria) {
        log.info("*************");
        log.info("다이어리 상세");
        log.info("*************");
        log.info(bno.toString());
        log.info(boardService.diaryDetail(bno).toString());
        model.addAttribute("board", boardService.diaryDetail(bno));
        return "/diary/detail";
    }

    @GetMapping("/list")
    public String getList(Criteria criteria, Model model){
        log.info("*************");
        log.info("다이어리 리스트");
        log.info("*************");
        // 다이어리 리스트
        return "/diary/index";
    }

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
    @GetMapping("/list/{bcate}") // #카테고리 변수명 미정
    @ResponseBody
    public List<RequestVO> getList(@PathVariable("bcate")String bcate){
        return null;
    }

    // 무한 스크롤
    @GetMapping("/list/{bcate}/{pageNum}")
    @ResponseBody
    public List<RequestVO> getMoreList(@PathVariable("bcate") String bcate, @PathVariable("pageNum") int pageNum){
        return null;
    }

    // 좋아요 목록에 추가
    @GetMapping("/wish")
    @ResponseBody
    public boolean wish(Long bno){
        return false;
    }


    //다이어리 페이지 리스트(검색리스트 포함)
    @PostMapping("/getListBySearch")
    @ResponseBody
    public List<BoardDTO> getListBySearch(@RequestBody Criteria criteria){
//        boardService.getListBySearch(criteria).stream().map(BoardVO::toString).forEach(log::info);
        return boardService.getListBySearch(criteria);
    }

    //경로에 저장된 이미지를 가져오는 url
    @GetMapping("/display")
    @ResponseBody
    public byte[] getFile(String fileName) throws IOException{
        log.info("*************************************");
        log.info("BoardController : display(get)");
        log.info("*************************************");
        log.info(fileName);
        File file = new File("C:/upload/", fileName);
        return FileCopyUtils.copyToByteArray(file);
    }

}
