package com.github.product_mcp.tool;

import com.github.product_mcp.client.ProductClient;
import com.github.product_mcp.dto.ProductDto;
import com.github.product_mcp.dto.ProductDto;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductTools {

    private final ProductClient productClient;

    public ProductTools(ProductClient productClient) {
        this.productClient = productClient;
    }

    @Tool(description = "List all products with their id, name and price")
    public List<com.github.product_mcp.dto.ProductDto> getAllProducts() {
        return productClient.getAll();
    }

    @Tool(description = "Create a new product. The id is generated automatically")
    public ProductDto createProduct(
            @ToolParam(description = "Name of the product") String name,
            @ToolParam(description = "Price of the product") double price) {
        return productClient.create(new ProductDto(null, name, price));
    }
}