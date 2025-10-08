package com.tecsup.app.micro.product.service;

import com.tecsup.app.micro.product.dto.Product;
import com.tecsup.app.micro.product.entity.ProductEntity;
import com.tecsup.app.micro.product.mapper.ProductMapper;
import com.tecsup.app.micro.product.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public Product getProductById(Long id) {

        ProductEntity entity = productRepository.findById(id).orElse(null);

        return productMapper.toDomain(entity);
    }
}
