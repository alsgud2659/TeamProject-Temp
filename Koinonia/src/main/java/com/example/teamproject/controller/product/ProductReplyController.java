package com.example.teamproject.controller.product;

import com.example.teamproject.domain.vo.BoardReplyVO;
import com.example.teamproject.domain.vo.Criteria;
import com.example.teamproject.domain.vo.PReplyPageDTO;
import com.example.teamproject.domain.vo.ProductReplyVO;
import com.example.teamproject.service.product.ProductReplyServieceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
@RequestMapping("/productReply/*")
@RequiredArgsConstructor
public class ProductReplyController {
    private final ProductReplyServieceImpl productReplyService;

    // 상품 댓글 등록
    @PostMapping(value = "/new", consumes = "application/json", produces = "text/plain; charset=utf-8")
    public ResponseEntity<String> create(@RequestBody ProductReplyVO productReplyVO, HttpSession session) throws UnsupportedEncodingException {
        log.info("boardReplyVO : " + productReplyVO);
//        productReplyVO.setName("test"); // 기본값 로그인시 세션이용해야 받아함;
        productReplyVO.setName(session.getAttribute("name").toString());
        productReplyService.register(productReplyVO);
        return new ResponseEntity<>(new String("댓글 등록 성공".getBytes(), "UTF-8") , HttpStatus.OK);
    }

    // 상품 댓글 1개 조회
    @GetMapping("/{rno}")
    public ProductReplyVO read(@PathVariable("rno") Long rno){
        log.info("read........ : " + rno);
        return productReplyService.read(rno);
    }

    // 상품 댓글 전체 목록 조회
    @GetMapping("/list/{pno}/{page}")
    public PReplyPageDTO getList(@PathVariable("page") int pageNum, @PathVariable("pno") Long pno){
        return new PReplyPageDTO(productReplyService.getList(pno, new Criteria(pageNum, 10)), productReplyService.getTotal(pno));
    }

    // 상품 댓글 삭제
    @DeleteMapping("/{rno}")
    public String remove(@PathVariable("rno") Long rno){
        productReplyService.remove(rno);
        return "댓글 삭제 성공";
    }

    // 상품 댓글 수정
    @PatchMapping(value = {"/{rno}/{writer}", "/{rno}"}, consumes = "application/json")
    public String modify(@PathVariable("rno") Long replyNumber, @PathVariable(value = "writer", required = false) String replyWriter, @RequestBody ProductReplyVO productReplyVO){
        log.info("modify......... : " + productReplyVO);
        log.info("modify......... : " + replyNumber);

        if(productReplyVO.getName() == null){ // JSON 검증
            productReplyVO.setName(Optional.ofNullable(replyWriter).orElse("anonymous")); // URI 검증
        }
        productReplyVO.setPrno(replyNumber);
        productReplyService.modify(productReplyVO);
        return "댓글 수정 성공";
    }

}
