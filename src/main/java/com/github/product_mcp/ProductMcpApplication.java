package com.github.product_mcp;

import com.github.product_mcp.tool.ProductTools;
import org.springframework.ai.support.ToolCallbacks;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableFeignClients
public class ProductMcpApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductMcpApplication.class, args);
	}

	/**
	 * This is to tell the Spring AI framework that the ProductTools class is a tool and should be registered as a callback.
	 * @param productTools productTools
	 * @return List of ToolCallback of productTools
	 */
	@Bean
	public List<ToolCallback> toolCallbacks(ProductTools productTools) {
		return List.of(ToolCallbacks.from(productTools));
	}
}
