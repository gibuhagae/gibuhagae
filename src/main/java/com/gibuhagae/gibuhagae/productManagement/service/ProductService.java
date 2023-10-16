package com.gibuhagae.gibuhagae.productManagement.service;

import com.gibuhagae.gibuhagae.common.paging.Pagenation;
import com.gibuhagae.gibuhagae.common.paging.SelectCriteria;
import com.gibuhagae.gibuhagae.productManagement.dao.ProductMapper;
import com.gibuhagae.gibuhagae.productManagement.dto.ProductDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class ProductService {

//    private final ProductMapper productMapper;
//
//    public ProductService(ProductMapper productMapper) {
//        this.productMapper = productMapper;
//    }
//
//    public Map<String, Object> selectProductList(Map<String, String> searchMap, int page) {
//
//        /* 전체 상품 수 확인 (검색어가 있는 경우 포함) => 페이징 처리를 위해 */
//        int totalCount = productMapper.selectTotalCount(searchMap);
//        log.info("productList totalCount : {}", totalCount);
//
//
//        /* 페이징 처리와 연관된 값을 계산하여 SelectCriteria 타입의 객체에 담는다. */
//        int limit = 10; // 한 페이지에 보여줄 게시물의 수
//        int buttonAmount = 5; // 한 번에 보여질 페이징 버튼의 수
//        SelectCriteria selectCriteria = Pagenation.getSelectCriteria(page, totalCount, limit, buttonAmount, searchMap);
//
//
//        /* 요청 페이지와 검색 기준에 맞는 회원을 조회해온다.*/
//        List<ProductDTO> productList = productMapper.selectProductList(selectCriteria);
//        log.info("productList totalCount : {}", productList);
//
//        Map<String, Object> memberListAndPaging = new HashMap<>();
//        memberListAndPaging.put("paging", selectCriteria);
//        memberListAndPaging.put("productList", productList);
//
//
//        return memberListAndPaging;
//    }
}
