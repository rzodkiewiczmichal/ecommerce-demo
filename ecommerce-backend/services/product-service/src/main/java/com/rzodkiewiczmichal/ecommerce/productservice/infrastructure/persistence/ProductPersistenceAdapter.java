package com.rzodkiewiczmichal.ecommerce.productservice.infrastructure.persistence;

import com.rzodkiewiczmichal.ecommerce.productservice.application.port.out.LoadAllProductsPort;
import com.rzodkiewiczmichal.ecommerce.productservice.application.port.out.LoadProductByIdPort;
import com.rzodkiewiczmichal.ecommerce.productservice.application.port.out.LoadProductsByIdsPort;
import com.rzodkiewiczmichal.ecommerce.productservice.domain.Product;
import com.rzodkiewiczmichal.ecommerce.productservice.domain.ProductId;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ProductPersistenceAdapter implements LoadProductByIdPort, LoadProductsByIdsPort, LoadAllProductsPort {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductPersistenceAdapter(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public Optional<Product> loadProductById(ProductId productId) {
        return productRepository.findById(productId.value())
                .map(productMapper::toDomain);
    }

    @Override
    public Collection<Product> loadProductsByIds(Collection<ProductId> productIds) {
        Collection<String> stringIds = productIds.stream()
                .map(ProductId::value)
                .collect(Collectors.toList());
        
        return productRepository.findByIdIn(stringIds)
                .stream()
                .map(productMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<Product> loadAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(productMapper::toDomain)
                .collect(Collectors.toList());
    }
}