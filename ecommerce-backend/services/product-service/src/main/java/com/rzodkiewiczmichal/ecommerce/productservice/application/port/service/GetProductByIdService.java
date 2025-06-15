package com.rzodkiewiczmichal.ecommerce.productservice.application.port.service;

import com.rzodkiewiczmichal.ecommerce.productservice.application.port.in.GetProductByIdUseCase;
import com.rzodkiewiczmichal.ecommerce.productservice.application.port.out.LoadProductByIdPort;
import com.rzodkiewiczmichal.ecommerce.productservice.domain.Product;
 import com.rzodkiewiczmichal.ecommerce.shared.domain.ProductId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GetProductByIdService implements GetProductByIdUseCase {

    private final LoadProductByIdPort loadProductByIdPort;

    @Override
    public Optional<Product> getProductById(ProductId productId) {
        return loadProductByIdPort.loadById(productId);
    }
}
