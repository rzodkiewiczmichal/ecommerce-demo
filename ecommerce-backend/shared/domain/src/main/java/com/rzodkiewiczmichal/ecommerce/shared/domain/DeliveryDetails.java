package com.rzodkiewiczmichal.ecommerce.shared.domain;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import com.rzodkiewiczmichal.ecommerce.shared.domain.validation.ValidationUtils;
/**
 * Value Object representing delivery details for an order.
 * Used across order and shipping services.
 */
public record DeliveryDetails(
    @NotBlank String address,
    @NotBlank String city,
    @NotBlank String postalCode,
    @NotBlank String country,
    @NotBlank @Email String email,
    @NotBlank String phone
) {

    public DeliveryDetails {
        ValidationUtils.validate(this);
    }
} 