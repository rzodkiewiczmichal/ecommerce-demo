package com.rzodkiewiczmichal.ecommerce.productservice.e2e;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers
public abstract class BaseE2ETest {

    @Container
    static MongoDBContainer mongoContainer = new MongoDBContainer("mongo:7.0");

    @LocalServerPort
    protected int port;

    protected TestRestTemplate restTemplate = new TestRestTemplate();

    @DynamicPropertySource
    static void configureProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.data.mongodb.uri", mongoContainer::getReplicaSetUrl);
        registry.add("spring.autoconfigure.exclude", () -> "org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration");
    }

    @BeforeEach
    void setUp() {
        // Clear database before each test
        // This will be implemented in test data utilities
    }

    protected String getBaseUrl() {
        return "http://localhost:" + port;
    }

    protected String getApiUrl(String endpoint) {
        return getBaseUrl() + "/api" + endpoint;
    }
}