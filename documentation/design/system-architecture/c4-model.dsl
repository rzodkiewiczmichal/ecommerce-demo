workspace {
    model {
        customer = person "Customer" "A user of the e-commerce system"

        ecommerceSystem = softwareSystem "E-commerce System" "Allows customers to browse products, place orders, and manage their accounts" {
            orderManagement = container "Order Management" "Manages the lifecycle of orders"

            productCatalog = container "Product Catalog" "Manages product information and categorization" {
                productAggregate = component "Product Aggregate" "Domain aggregate representing a product"
            }

            customerManagement = container "Customer Management" "Handles customer accounts and preferences"
            shoppingCart = container "Shopping Cart" "Manages the customer's shopping cart"
            inventoryManagement = container "Inventory Management" "Tracks product stock levels"
            paymentProcessing = container "Payment Processing" "Handles payment transactions"
            shipping = container "Shipping" "Manages order shipment and tracking"
        }

        paymentGateway = softwareSystem "Payment Gateway" "Processes payments for orders"
        shippingProvider = softwareSystem "Shipping Provider" "Handles order delivery"

        database = softwareSystem "Database" "Stores all e-commerce data" {
            mongoDb = container "MongoDB" "NoSQL Database" "MongoDB" {
                productsCollection = component "Products Collection" "Stores product information"
            }
        }

        messageBroker = softwareSystem "Message Broker" "Handles asynchronous communication between services" {
            rabbitMq = container "RabbitMQ" "AMQP Message Broker" "RabbitMQ"
        }

        # System Context relationships
        customer -> ecommerceSystem "Uses"
        ecommerceSystem -> paymentGateway "Processes payments using"
        ecommerceSystem -> shippingProvider "Arranges shipments using"
        ecommerceSystem -> database "Reads from and writes to"
        ecommerceSystem -> messageBroker "Publishes and consumes events"

        # Container relationships
        customer -> orderManagement "Places orders"
        customer -> productCatalog "Browses products"
        customer -> shoppingCart "Adds products to cart"
        customer -> customerManagement "Manages account"

        orderManagement -> paymentProcessing "Initiates payment"
        orderManagement -> shipping "Initiates shipment"
        productCatalog -> inventoryManagement "Checks stock levels"
        shoppingCart -> productCatalog "Gets product information"
        orderManagement -> inventoryManagement "Updates stock levels"

        productCatalog -> mongoDb "Reads from and writes to"
        orderManagement -> rabbitMq "Publishes order events to"
        inventoryManagement -> rabbitMq "Publishes stock events to"

        # Component relationships
        productAggregate -> productsCollection "Reads from and writes to"
    }

    views {
        systemContext ecommerceSystem "SystemContext" {
            include *
            autoLayout
        }

        container ecommerceSystem "Containers" {
            include *
            autoLayout
        }

        component productCatalog "ProductCatalogComponents" {
            include *
            autoLayout
        }

        dynamic ecommerceSystem "BoundedContextDatabaseRelations" {
            productCatalog -> mongoDb "Reads product data"
            autoLayout
        }

        dynamic productCatalog "ProductComponentToMongoCollection" {
            productAggregate -> productsCollection "Reads product data"
            autoLayout
        }

        styles {
            element "Software System" {
                background #1168bd
                color #ffffff
            }
            element "Person" {
                shape person
                background #08427b
                color #ffffff
            }
            element "Container" {
                background #438dd5
                color #ffffff
            }
            element "Component" {
                background #85bbf0
                color #000000
            }
        }
    }
}