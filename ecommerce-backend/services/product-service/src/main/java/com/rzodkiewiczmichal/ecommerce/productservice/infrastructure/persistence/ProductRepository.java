package com.rzodkiewiczmichal.ecommerce.productservice.infrastructure.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<ProductEntity, String> {
    
    List<ProductEntity> findByIdIn(Collection<String> ids);
}