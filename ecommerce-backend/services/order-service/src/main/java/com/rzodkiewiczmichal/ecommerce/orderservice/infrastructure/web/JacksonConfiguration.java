package com.rzodkiewiczmichal.ecommerce.orderservice.infrastructure.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.rzodkiewiczmichal.ecommerce.shared.domain.ProductId;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class JacksonConfiguration {

    @Bean
    @Primary
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        
        SimpleModule module = new SimpleModule();
        module.addSerializer(ProductId.class, new ProductIdSerializer());
        module.addDeserializer(ProductId.class, new ProductIdDeserializer());
        
        mapper.registerModule(module);
        return mapper;
    }
}