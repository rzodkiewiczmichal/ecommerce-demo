package com.rzodkiewiczmichal.ecommerce.productservice.infrastructure.web;

import com.rzodkiewiczmichal.ecommerce.productservice.application.port.in.GetProductByIdUseCase;
import com.rzodkiewiczmichal.ecommerce.productservice.application.port.in.GetProductsByIdsUseCase;
import com.rzodkiewiczmichal.ecommerce.productservice.domain.Product;
import com.rzodkiewiczmichal.ecommerce.shared.domain.ProductId;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final GetProductByIdUseCase getProductByIdUseCase;
    private final GetProductsByIdsUseCase getProductsByIdsUseCase;

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable String id) {
        return getProductByIdUseCase.getProductById(new ProductId(id))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Product>> getProducts(@RequestParam List<String> ids) {
            List<ProductId> productIds = ids.stream()
                    .map(ProductId::new)
                .toList();
        return ResponseEntity.ok(getProductsByIdsUseCase.getProductsByIds(productIds));
    }
}