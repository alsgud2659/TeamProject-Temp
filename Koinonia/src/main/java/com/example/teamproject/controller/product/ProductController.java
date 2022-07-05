package com.example.teamproject.controller.product;

import com.example.teamproject.domain.vo.Criteria;
import com.example.teamproject.domain.vo.PageDTO;
import com.example.teamproject.domain.vo.ProductFileVO;
import com.example.teamproject.domain.vo.ProductVO;
import com.example.teamproject.service.product.ProductFileServiceImpl;
import com.example.teamproject.service.product.ProductServieceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.teamproject.domain.vo.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/product/*")
@RequiredArgsConstructor
public class ProductController {
    private final ProductServieceImpl productService;
    private final ProductFileServiceImpl productFileService;
    // 상품

    @GetMapping("/register")
    public String register(HttpSession session) {
        log.info("*************");
        log.info("판매 상품정보 작성");
        log.info("*************");
        if(session.getAttribute("name")==null){
            return "/user/login";
        }
        return "/product/product";
    }

    @PostMapping("/register")
    public RedirectView register(ProductVO productVO,HttpSession session, RedirectAttributes rttr) {
        log.info("*************");
        log.info("판매 상품 등록");
        log.info("*************");
        productService.register(productVO);
        rttr.addFlashAttribute("pno", productVO.getPno());

        return new RedirectView("/product/list");
    }

    @GetMapping("/list")
    public String getList(Criteria criteria, Model model) {
        log.info("*************");
        log.info("상품 리스트");
        log.info("*************");

        List<ProductVO> productList = productService.getList(criteria);
        model.addAttribute("productList", productService.getList(criteria));
//         상품 썸네일 리스트
        String pRequestUrl = "/productFile/display?fileName=";
        String productThumFileName = "";
        List<String> productThumfileUrlList = new ArrayList<>();
        for (ProductVO p : productList) {
            List<ProductFileVO> productFileList = productService.getList(p.getPno());
            if (!productFileList.isEmpty()) {
                productThumFileName = pRequestUrl + productFileList.get(0).getUploadPath() + "/" + productFileList.get(0).getUuid() + "_" + productFileList.get(0).getFileName();
            } else {
                productThumFileName = "/images/no_image.gif";
            }
            productThumfileUrlList.add(productThumFileName);
        }


        model.addAttribute("productThumfileUrlList", productThumfileUrlList);
        model.addAttribute("pageDTO", new PageDTO(criteria, productService.getTotal()));
        return "/product/sell_list";

    }

    @GetMapping("/detail")
    public String read(Long pno, Model model, Criteria criteria) {
        log.info("*************");
        log.info("상품 상세");
        log.info("*************");
        log.info(productService.read(pno).toString());


//         상품 썸네일 리스트
        String pRequestUrl = "/productFile/display?fileName=";
        String productThumFileName = "";
        List<String> productThumfileUrlList = new ArrayList<>();

        List<ProductFileVO> productFileList = productService.getList(pno);
        for (int i = 0; i < productFileList.size(); i++) {
            if (!productFileList.isEmpty()) {
                productThumFileName = pRequestUrl + productFileList.get(i).getUploadPath() + "/" + productFileList.get(i).getUuid() + "_" + productFileList.get(i).getFileName();
            } else {
                productThumFileName = "/images/no_image.gif";
            }

            productThumfileUrlList.add(productThumFileName);
        }
        model.addAttribute("productThumfileUrlList", productThumfileUrlList);
        model.addAttribute("product", productService.read(pno));
        return "/product/sell_detail";
    }


    @GetMapping("/modify")
    public String modify(Long pno, Model model,Criteria criteria) throws JsonProcessingException {
//    public String modify(Long pno, Criteria criteria, Model model) {
        log.info("*************");
        log.info("상품 수정 내용 작성/삭제");
        log.info("*************");
        model.addAttribute("product", productService.read(pno));
        ArrayList files = new ArrayList();
        for (ProductFileVO productFileVO : productFileService.getList(pno)) {
            ObjectMapper mapper = new ObjectMapper();
            String jsonString = mapper.writeValueAsString(productFileVO);
            log.info(jsonString);
            files.add(jsonString);
        }
        log.info(files.toString());
        model.addAttribute("files", files.toString());
        return "/product/modify_product";
    }

    @PostMapping("/modify")
    public RedirectView modify(ProductVO productVO, Criteria criteria, RedirectAttributes rttr) {
        log.info("*************");
        log.info("상품 수정 완료");
        log.info("*************");
        // 상품 정보 수정
        if (productService.modify(productVO) == 1) {
            rttr.addAttribute("pno", productVO.getPno());
            rttr.addAttribute("pageNum", criteria.getPageNum());
            rttr.addAttribute("amount", criteria.getAmount());
        };
        return new RedirectView("/product/list");
    }


    @GetMapping("/remove")

    public RedirectView remove(Long pno, RedirectAttributes rttr) {
        log.info("삭제 번호 : " + pno);
        productService.remove(pno);

        rttr.addFlashAttribute("pno", pno);
        return new RedirectView("/product/list");
    }

}