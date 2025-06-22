package com.rzodkiewiczmichal.ecommerce.orderservice.infrastructure.web;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.rzodkiewiczmichal.ecommerce.shared.domain.ProductId;

import java.io.IOException;

public class ProductIdDeserializer extends JsonDeserializer<ProductId> {
    
    @Override
    public ProductId deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String value = p.getValueAsString();
        return new ProductId(value);
    }
}