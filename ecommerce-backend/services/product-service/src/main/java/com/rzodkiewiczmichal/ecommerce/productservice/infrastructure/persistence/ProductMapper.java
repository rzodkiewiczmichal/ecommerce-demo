package com.rzodkiewiczmichal.ecommerce.productservice.infrastructure.persistence;

import com.rzodkiewiczmichal.ecommerce.productservice.domain.Price;
import com.rzodkiewiczmichal.ecommerce.productservice.domain.Product;
import com.rzodkiewiczmichal.ecommerce.productservice.domain.ProductDescription;
import com.rzodkiewiczmichal.ecommerce.productservice.domain.ProductId;
import com.rzodkiewiczmichal.ecommerce.productservice.domain.ProductName;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public Product toDomain(ProductEntity entity) {
        if (entity == null) {
            return null;
        }
        
        return new Product(
            new ProductId(entity.getId()),
            new ProductName(entity.getName()),
            new ProductDescription(entity.getDescription()),
            new Price(entity.getPrice())
        );
    }

    public ProductEntity toEntity(Product product) {
        if (product == null) {
            return null;
        }
        
        return new ProductEntity(
            product.getId().value(),
            product.getName().value(),
            product.getDescription().value(),
            product.getPrice().value()
        );
    }
}