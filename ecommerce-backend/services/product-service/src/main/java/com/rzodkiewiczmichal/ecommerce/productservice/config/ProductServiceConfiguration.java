package com.rzodkiewiczmichal.ecommerce.productservice.config;

import com.rzodkiewiczmichal.ecommerce.productservice.application.port.in.GetProductByIdUseCase;
import com.rzodkiewiczmichal.ecommerce.productservice.application.port.in.GetProductsByIdsUseCase;
import com.rzodkiewiczmichal.ecommerce.productservice.application.port.in.ListProductsUseCase;
import com.rzodkiewiczmichal.ecommerce.productservice.application.port.out.LoadAllProductsPort;
import com.rzodkiewiczmichal.ecommerce.productservice.application.port.out.LoadProductByIdPort;
import com.rzodkiewiczmichal.ecommerce.productservice.application.port.out.LoadProductsByIdsPort;
import com.rzodkiewiczmichal.ecommerce.productservice.application.port.service.GetProductByIdService;
import com.rzodkiewiczmichal.ecommerce.productservice.application.port.service.GetProductsByIdsService;
import com.rzodkiewiczmichal.ecommerce.productservice.application.port.service.ListProductsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductServiceConfiguration {

    @Bean
    public GetProductByIdUseCase getProductByIdUseCase(LoadProductByIdPort loadProductByIdPort) {
        return new GetProductByIdService(loadProductByIdPort);
    }

    @Bean
    public GetProductsByIdsUseCase getProductsByIdsUseCase(LoadProductsByIdsPort loadProductsByIdsPort) {
        return new GetProductsByIdsService(loadProductsByIdsPort);
    }

    @Bean
    public ListProductsUseCase listProductsUseCase(LoadAllProductsPort loadAllProductsPort) {
        return new ListProductsService(loadAllProductsPort);
    }
}