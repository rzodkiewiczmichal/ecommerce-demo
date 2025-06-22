package com.rzodkiewiczmichal.ecommerce.orderservice.infrastructure.web;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.rzodkiewiczmichal.ecommerce.shared.domain.ProductId;

import java.io.IOException;

public class ProductIdSerializer extends JsonSerializer<ProductId> {
    
    @Override
    public void serialize(ProductId value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeString(value.value());
    }
}