package com.rzodkiewiczmichal.ecommerce.productservice.e2e;

import com.rzodkiewiczmichal.ecommerce.productservice.infrastructure.web.ProductResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static com.rzodkiewiczmichal.ecommerce.productservice.e2e.TestConstants.*;
import static org.assertj.core.api.Assertions.assertThat;

class ProductRetrievalE2ETest extends BaseE2ETest {

    @Autowired
    private MongoTemplate mongoTemplate;

    @BeforeEach
    void setUpTestData() {
        // Clear all collections
        mongoTemplate.getCollectionNames().forEach(mongoTemplate::dropCollection);
        
        // Insert test products
        TestDataHelper.insertTestProducts(mongoTemplate);
    }

    @Test
    void shouldReturnAllProducts() {
        // When
        ResponseEntity<List<ProductResponse>> response = restTemplate.exchange(
                getApiUrl("/products"),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<ProductResponse>>() {}
        );

        // Then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).hasSize(3);
        
        List<ProductResponse> products = response.getBody();
        assertThat(products).extracting(ProductResponse::getName)
                .containsExactlyInAnyOrder(GAMING_LAPTOP_NAME, WIRELESS_MOUSE_NAME, MECHANICAL_KEYBOARD_NAME);
    }

    @Test
    void shouldReturnProductById() {
        // Given
        String productId = GAMING_LAPTOP_ID;

        // When
        ResponseEntity<ProductResponse> response = restTemplate.getForEntity(
                getApiUrl("/products/" + productId),
                ProductResponse.class
        );

        // Then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getId()).isEqualTo(productId);
        assertThat(response.getBody().getName()).isEqualTo(GAMING_LAPTOP_NAME);
        assertThat(response.getBody().getPrice()).isEqualTo(GAMING_LAPTOP_PRICE);
    }

    @Test
    void shouldReturnNotFoundForNonExistentProduct() {
        // Given
        String nonExistentId = NON_EXISTENT_ID;

        // When
        ResponseEntity<ProductResponse> response = restTemplate.getForEntity(
                getApiUrl("/products/" + nonExistentId),
                ProductResponse.class
        );

        // Then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }

    @Test
    void shouldReturnProductsByIds() {
        // Given
        String url = getApiUrl("/products?ids=" + GAMING_LAPTOP_ID + "&ids=" + WIRELESS_MOUSE_ID);

        // When
        ResponseEntity<List<ProductResponse>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<ProductResponse>>() {}
        );

        // Then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).hasSize(2);
        
        List<ProductResponse> products = response.getBody();
        assertThat(products).extracting(ProductResponse::getName)
                .containsExactlyInAnyOrder(GAMING_LAPTOP_NAME, WIRELESS_MOUSE_NAME);
    }

    @Test
    void shouldReturnEmptyListForNonExistentIds() {
        // Given
        String url = getApiUrl("/products?ids=non-existent-1&ids=non-existent-2");

        // When
        ResponseEntity<List<ProductResponse>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<ProductResponse>>() {}
        );

        // Then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEmpty();
    }

    @Test
    void shouldReturnMixedResultsForPartiallyExistentIds() {
        // Given
        String url = getApiUrl("/products?ids=" + GAMING_LAPTOP_ID + "&ids=non-existent");

        // When
        ResponseEntity<List<ProductResponse>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<ProductResponse>>() {}
        );

        // Then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).hasSize(1);
        assertThat(response.getBody().get(0).getName()).isEqualTo(GAMING_LAPTOP_NAME);
    }
}