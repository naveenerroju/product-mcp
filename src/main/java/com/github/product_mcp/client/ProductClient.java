package com.github.product_mcp.client;

import com.github.product_mcp.dto.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "product-client", url = "${products.service.url}", path = "/products")
public interface ProductClient {

    @PostMapping
    ProductDto create(@RequestBody ProductDto product);

    @GetMapping
    List<ProductDto> getAll();
}