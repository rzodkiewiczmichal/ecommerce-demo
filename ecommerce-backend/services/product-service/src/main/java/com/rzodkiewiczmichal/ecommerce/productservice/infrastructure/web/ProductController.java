package com.rzodkiewiczmichal.ecommerce.productservice.infrastructure.web;

import com.rzodkiewiczmichal.ecommerce.productservice.application.port.in.GetProductByIdUseCase;
import com.rzodkiewiczmichal.ecommerce.productservice.application.port.in.GetProductsByIdsUseCase;
import com.rzodkiewiczmichal.ecommerce.productservice.application.port.in.ListProductsUseCase;
import com.rzodkiewiczmichal.ecommerce.productservice.domain.Product;
import com.rzodkiewiczmichal.ecommerce.productservice.domain.ProductId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final GetProductByIdUseCase getProductByIdUseCase;
    private final GetProductsByIdsUseCase getProductsByIdsUseCase;
    private final ListProductsUseCase listProductsUseCase;
    private final ProductResponseMapper responseMapper;

    public ProductController(
            GetProductByIdUseCase getProductByIdUseCase,
            GetProductsByIdsUseCase getProductsByIdsUseCase,
            ListProductsUseCase listProductsUseCase,
            ProductResponseMapper responseMapper) {
        this.getProductByIdUseCase = getProductByIdUseCase;
        this.getProductsByIdsUseCase = getProductsByIdsUseCase;
        this.listProductsUseCase = listProductsUseCase;
        this.responseMapper = responseMapper;
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable String productId) {
        return getProductByIdUseCase.getProductById(new ProductId(productId))
                .map(responseMapper::toResponse)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getProducts(@RequestParam(required = false) List<String> ids) {
        Collection<Product> products;
        
        if (ids != null && !ids.isEmpty()) {
            List<ProductId> productIds = ids.stream()
                    .map(ProductId::new)
                    .collect(Collectors.toList());
            products = getProductsByIdsUseCase.getProductsByIds(productIds);
        } else {
            products = listProductsUseCase.listProducts();
        }

        List<ProductResponse> responses = products.stream()
                .map(responseMapper::toResponse)
                .collect(Collectors.toList());

        return ResponseEntity.ok(responses);
    }
}