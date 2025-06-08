package com.rzodkiewiczmichal.ecommerce.productservice.e2e;

import java.math.BigDecimal;

public final class TestConstants {
    
    // Product IDs
    public static final String GAMING_LAPTOP_ID = "550e8400-e29b-41d4-a716-446655440000";
    public static final String WIRELESS_MOUSE_ID = "550e8400-e29b-41d4-a716-446655440001";
    public static final String MECHANICAL_KEYBOARD_ID = "550e8400-e29b-41d4-a716-446655440002";
    public static final String NON_EXISTENT_ID = "non-existent-id";
    
    // Product Names
    public static final String GAMING_LAPTOP_NAME = "Gaming Laptop";
    public static final String WIRELESS_MOUSE_NAME = "Wireless Mouse";
    public static final String MECHANICAL_KEYBOARD_NAME = "Mechanical Keyboard";
    
    // Product Descriptions
    public static final String GAMING_LAPTOP_DESCRIPTION = "High-performance gaming laptop with RTX 4080";
    public static final String WIRELESS_MOUSE_DESCRIPTION = "Ergonomic wireless gaming mouse";
    public static final String MECHANICAL_KEYBOARD_DESCRIPTION = "RGB mechanical keyboard with blue switches";
    
    // Product Prices
    public static final BigDecimal GAMING_LAPTOP_PRICE = new BigDecimal("1299.99");
    public static final BigDecimal WIRELESS_MOUSE_PRICE = new BigDecimal("79.99");
    public static final BigDecimal MECHANICAL_KEYBOARD_PRICE = new BigDecimal("149.99");
    
    // Collections
    public static final String PRODUCTS_COLLECTION = "products";
    
    private TestConstants() {
        // Utility class - prevent instantiation
    }
}