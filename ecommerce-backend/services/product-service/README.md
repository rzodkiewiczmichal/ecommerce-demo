# Database Setup Scripts

## Setup Test Data

### Prerequisites
- Docker Compose services running (`docker-compose up -d`)
- Groovy installed

### Running the Script

```bash
# Make script executable
chmod +x setup-test-data.groovy

# Run the script
groovy setup-test-data.groovy
```

### What it does
- Connects to MongoDB running in Docker
- Clears existing products collection
- Inserts 8 sample products
- Verifies the insertion

### Sample Products
- Gaming Laptop ($1299.99)
- Wireless Mouse ($79.99)
- Mechanical Keyboard ($149.99)
- 4K Monitor ($599.99)
- USB-C Hub ($49.99)
- Webcam ($129.99)
- Headphones ($249.99)
- Smartphone ($899.99)

After running this script, you can test the Product Service API using the HTTP files in the `../http` directory.