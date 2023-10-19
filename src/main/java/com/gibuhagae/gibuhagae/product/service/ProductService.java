package com.gibuhagae.gibuhagae.product.service;


import com.gibuhagae.gibuhagae.common.paging.Pagenation;
import com.gibuhagae.gibuhagae.common.paging.SelectCriteria;
import com.gibuhagae.gibuhagae.product.dao.ProductMapper;
import com.gibuhagae.gibuhagae.product.dto.ItemDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
;

@Slf4j
@Service
@Transactional
public class ProductService {

    private final ProductMapper productMapper;

    public ProductService(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }


    public Map<String, Object> selectProduct(int page) {

        int totalCount = productMapper.selectTotalProductCount();


        int limit = 16;
        int buttonAmount = 5;
        SelectCriteria selectCriteria = Pagenation.getSelectCriteria(page, totalCount, limit, buttonAmount);

        List<ItemDTO> itemList = productMapper.selectProductList(selectCriteria);



        Map<String, Object> productListAndPaging = new HashMap<>();
        productListAndPaging.put("paging", selectCriteria);
        productListAndPaging.put("itemList", itemList);

        return productListAndPaging;

    }

    public ItemDTO selectProductDetail(Long no) {


        return productMapper.selectProductDetail(no);

    }


}
