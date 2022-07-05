package com.example.teamproject.controller.request;

import com.example.teamproject.domain.vo.BoardReplyVO;
import com.example.teamproject.domain.vo.RequestReplyVO;
import com.example.teamproject.service.request.RequestReplyServieceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.Optional;

@RestController
@Slf4j
@RequestMapping("/requestReply/*")
@RequiredArgsConstructor
public class RequestReplyController {
    private final RequestReplyServieceImpl requestReplyService;

    // 다이어리 댓글 등록
    @PostMapping(value = "/new", consumes = "application/json", produces = "text/plain; charset=utf-8")
    public ResponseEntity<String> create(@RequestBody RequestReplyVO requestReplyVO) throws UnsupportedEncodingException {
        log.info("boardReplyVO : " + requestReplyVO);
        requestReplyService.register(requestReplyVO);
        return new ResponseEntity<>(new String("댓글 등록 성공".getBytes(), "UTF-8") , HttpStatus.OK);
    }

    // 다이어리 댓글 1개 조회
    @GetMapping("/{rno}")
    public RequestReplyVO read(@PathVariable("rno") Long rno){
        log.info("read........ : " + rno);
        return requestReplyService.read(rno);
    }

    // 다이어리 댓글 전체 목록 조회
//    @GetMapping("/list/{bno}/{page}")
//    public ReplyPageDTO getList(@PathVariable("page") int pageNum, @PathVariable("bno") Long bno){
//        return new ReplyPageDTO(boardReplyService.getList(new Criteria(pageNum, 10), bno), boardReplyService.getTotal(bno));
//    }

    // 다이어리 댓글 삭제
    @DeleteMapping("/{rno}")
    public String remove(@PathVariable("rno") Long rno){
        requestReplyService.remove(rno);
        return "댓글 삭제 성공";
    }

    // 다이어리 댓글 수정
    @PatchMapping(value = {"/{rno}/{writer}", "/{rno}"}, consumes = "application/json")
    public String modify(@PathVariable("rno") Long rno, @PathVariable(value = "writer", required = false) String replyWriter, @RequestBody RequestReplyVO requestReplyVO){
        log.info("modify......... : " + rno);
        log.info("modify......... : " + rno);

        if(requestReplyVO.getName() == null){ // JSON 검증
            requestReplyVO.setName(Optional.ofNullable(replyWriter).orElse("anonymous")); // URI 검증
        }
        requestReplyVO.setRrno(rno);
        requestReplyService.modify(requestReplyVO);
        return "댓글 수정 성공";
    }

    // 판매 상품 요청 댓글 개수

}
