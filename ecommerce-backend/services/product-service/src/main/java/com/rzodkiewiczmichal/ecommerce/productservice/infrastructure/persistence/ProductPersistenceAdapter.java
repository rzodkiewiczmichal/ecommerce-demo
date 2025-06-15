package com.rzodkiewiczmichal.ecommerce.productservice.infrastructure.persistence;

import com.rzodkiewiczmichal.ecommerce.productservice.application.port.out.LoadProductByIdPort;
import com.rzodkiewiczmichal.ecommerce.productservice.application.port.out.LoadProductsByIdsPort;
import com.rzodkiewiczmichal.ecommerce.productservice.domain.Product;
import com.rzodkiewiczmichal.ecommerce.shared.domain.ProductId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ProductPersistenceAdapter implements LoadProductByIdPort, LoadProductsByIdsPort {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public Optional<Product> loadById(ProductId productId) {
        return productRepository.findById(productId.value())
                .map(productMapper::toDomain);
    }

    @Override
    public List<Product> loadByIds(List<ProductId> productIds) {
        List<String> ids = productIds.stream()
                .map(ProductId::value)
                .toList();
        return productRepository.findAllById(ids).stream()
                .map(productMapper::toDomain)
                .toList();
    }
}