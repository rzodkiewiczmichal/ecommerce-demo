#!/usr/bin/env groovy

@Grab('org.mongodb:mongodb-driver-sync:4.11.1')

import com.mongodb.client.MongoClients
import com.mongodb.client.MongoClient
import com.mongodb.client.MongoDatabase
import com.mongodb.client.MongoCollection
import org.bson.Document
import java.math.BigDecimal

// MongoDB connection
def connectionString = "mongodb://admin:password@localhost:27017"
def databaseName = "ecommerce"
def collectionName = "products"

println "Connecting to MongoDB at $connectionString"

try {
    MongoClient mongoClient = MongoClients.create(connectionString)
    MongoDatabase database = mongoClient.getDatabase(databaseName)
    MongoCollection<Document> collection = database.getCollection(collectionName)
    
    // Clear existing data
    println "Clearing existing products..."
    collection.deleteMany(new Document())
    
    // Sample products
    def products = [
        [
            _id: "550e8400-e29b-41d4-a716-446655440000",
            name: "Gaming Laptop",
            description: "High-performance gaming laptop with RTX 4080",
            price: new BigDecimal("1299.99")
        ],
        [
            _id: "550e8400-e29b-41d4-a716-446655440001",
            name: "Wireless Mouse", 
            description: "Ergonomic wireless gaming mouse",
            price: new BigDecimal("79.99")
        ],
        [
            _id: "550e8400-e29b-41d4-a716-446655440002",
            name: "Mechanical Keyboard",
            description: "RGB mechanical keyboard with blue switches", 
            price: new BigDecimal("149.99")
        ],
        [
            _id: "550e8400-e29b-41d4-a716-446655440003",
            name: "4K Monitor",
            description: "32-inch 4K gaming monitor with 144Hz refresh rate",
            price: new BigDecimal("599.99")
        ],
        [
            _id: "550e8400-e29b-41d4-a716-446655440004",
            name: "USB-C Hub",
            description: "Multi-port USB-C hub with HDMI and ethernet",
            price: new BigDecimal("49.99")
        ],
        [
            _id: "550e8400-e29b-41d4-a716-446655440005",
            name: "Webcam",
            description: "4K webcam with auto-focus and noise cancellation",
            price: new BigDecimal("129.99")
        ],
        [
            _id: "550e8400-e29b-41d4-a716-446655440006",
            name: "Headphones",
            description: "Noise-cancelling wireless headphones",
            price: new BigDecimal("249.99")
        ],
        [
            _id: "550e8400-e29b-41d4-a716-446655440007",
            name: "Smartphone",
            description: "Latest flagship smartphone with 256GB storage",
            price: new BigDecimal("899.99")
        ]
    ]
    
    // Convert to MongoDB documents
    def documents = products.collect { product ->
        new Document()
            .append("_id", product._id)
            .append("name", product.name)
            .append("description", product.description)
            .append("price", product.price)
    }
    
    // Insert products
    println "Inserting ${products.size()} products..."
    collection.insertMany(documents)
    
    // Verify insertion
    def count = collection.countDocuments()
    println "Successfully inserted $count products into the database"
    
    // Display inserted products
    println "\nInserted products:"
    collection.find().forEach { doc ->
        println "- ${doc.getString('name')} (\$${doc.get('price')})"
    }
    
    mongoClient.close()
    println "\nTest data setup completed successfully!"
    
} catch (Exception e) {
    println "Error setting up test data: ${e.message}"
    e.printStackTrace()
    System.exit(1)
}