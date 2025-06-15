package com.rzodkiewiczmichal.ecommerce.orderservice.infrastructure.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends MongoRepository<OrderEntity, String> {
}