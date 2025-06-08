package com.rzodkiewiczmichal.ecommerce.productservice.e2e;

import org.bson.Document;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.math.BigDecimal;
import java.util.List;

import static com.rzodkiewiczmichal.ecommerce.productservice.e2e.TestConstants.*;

public class TestDataHelper {

    public static void insertTestProducts(MongoTemplate mongoTemplate) {
        List<Document> products = List.of(
                createProductDocument(
                        GAMING_LAPTOP_ID,
                        GAMING_LAPTOP_NAME,
                        GAMING_LAPTOP_DESCRIPTION,
                        GAMING_LAPTOP_PRICE
                ),
                createProductDocument(
                        WIRELESS_MOUSE_ID,
                        WIRELESS_MOUSE_NAME,
                        WIRELESS_MOUSE_DESCRIPTION,
                        WIRELESS_MOUSE_PRICE
                ),
                createProductDocument(
                        MECHANICAL_KEYBOARD_ID,
                        MECHANICAL_KEYBOARD_NAME,
                        MECHANICAL_KEYBOARD_DESCRIPTION,
                        MECHANICAL_KEYBOARD_PRICE
                )
        );

        mongoTemplate.insert(products, PRODUCTS_COLLECTION);
    }

    private static Document createProductDocument(String id, String name, String description, BigDecimal price) {
        return new Document()
                .append("_id", id)
                .append("name", name)
                .append("description", description)
                .append("price", price);
    }

    public static void clearAllCollections(MongoTemplate mongoTemplate) {
        mongoTemplate.getCollectionNames().forEach(mongoTemplate::dropCollection);
    }
}