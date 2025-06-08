package com.rzodkiewiczmichal.ecommerce.productservice.infrastructure.persistence;

import com.rzodkiewiczmichal.ecommerce.productservice.domain.Price;
import com.rzodkiewiczmichal.ecommerce.productservice.domain.Product;
import com.rzodkiewiczmichal.ecommerce.productservice.domain.ProductDescription;
import com.rzodkiewiczmichal.ecommerce.productservice.domain.ProductId;
import com.rzodkiewiczmichal.ecommerce.productservice.domain.ProductName;
import org.springframework.stereotype.Component;

import java.util.Currency;

@Component
public class ProductMapper {

    public Product toDomain(ProductEntity entity) {
        if (entity == null) {
            return null;
        }
        
        return new Product(
            new ProductId(entity.id()),
            new ProductName(entity.name()),
            new ProductDescription(entity.description()),
            new Price(entity.price(), Currency.getInstance("USD"))
        );
    }

    public ProductEntity toEntity(Product product) {
        if (product == null) {
            return null;
        }
        
        return new ProductEntity(
            product.id().value(),
            product.name().value(),
            product.description().value(),
            product.price().amount()
        );
    }
}