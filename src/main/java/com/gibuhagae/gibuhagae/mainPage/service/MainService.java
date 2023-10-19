package com.gibuhagae.gibuhagae.mainPage.service;

import com.gibuhagae.gibuhagae.product.dao.ProductMapper;
import com.gibuhagae.gibuhagae.product.dto.ItemDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional
public class MainService {

    private final ProductMapper productMapper;

    public MainService(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }
    public List<ItemDTO> selectItems() {

       return productMapper.selectItems();

    }
}
