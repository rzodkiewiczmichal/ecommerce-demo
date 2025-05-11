workspace {
    model {
        customer = person "Customer" "A user of the e-commerce system"

        ecommerceSystem = softwareSystem "E-commerce System" "Allows customers to browse products, place orders, and manage their accounts" {

            orderManagement = container "Order Management" "Manages the lifecycle of orders" {
                orderAggregate = component "Order Aggregate" "Domain aggregate responsible for managing orders"
            }

            productCatalog = container "Product Catalog" "Manages product information and categorization" {
                productAggregate = component "Product Aggregate" "Domain aggregate representing a product"
            }

            customerManagement = container "Customer Management" "Handles customer accounts and preferences" {
                customerAggregate = component "Customer Aggregate" "Domain aggregate for managing customer identity and contact data"
            }

            inventoryManagement = container "Inventory Management" "Tracks product stock levels" {
                inventoryAggregate = component "Inventory Aggregate" "Domain aggregate managing product stock"
            }

            paymentProcessing = container "Payment Processing" "Handles payment transactions"

            shipping = container "Shipping" "Manages order shipment and tracking" {
                shipmentAggregate = component "Shipment Aggregate" "Domain aggregate responsible for tracking shipment status"
            }
        }

        paymentGateway = softwareSystem "Payment Gateway" "Processes payments for orders"
        shippingProvider = softwareSystem "Shipping Provider" "Handles order delivery"

        database = softwareSystem "Database" "Stores all e-commerce data" {
            mongoDb = container "MongoDB" "NoSQL Database" "MongoDB" {
                productsCollection = component "Products Collection" "Stores product information"
                ordersCollection = component "Orders Collection" "Stores order documents"
                inventoryCollection = component "Inventory Collection" "Stores inventory quantities"
                shipmentsCollection = component "Shipments Collection" "Stores shipment documents"
                customersCollection = component "Customers Collection" "Stores customer account information"
                cartsCollection = component "Carts Collection" "Stores customer shopping carts"
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
        customer -> customerManagement "Manages account"

        orderManagement -> paymentProcessing "Initiates payment"
        orderManagement -> productCatalog "Retrieves product details"
        orderManagement -> shipping "Initiates shipment"
        productCatalog -> inventoryManagement "Checks stock levels"
        orderManagement -> inventoryManagement "Updates stock levels"

        productCatalog -> mongoDb "Reads from and writes to"
        orderManagement -> rabbitMq "Publishes order events to"
        inventoryManagement -> rabbitMq "Publishes stock events to"

        # Component relationships
        productAggregate -> productsCollection "Reads from and writes to"
        orderAggregate -> ordersCollection "Reads and writes order data"
        inventoryAggregate -> inventoryCollection "Reads and updates stock levels"
        shipmentAggregate -> shipmentsCollection "Reads and updates shipment data"
        customerAggregate -> customersCollection "Reads and writes customer data"
        cartAggregate -> cartsCollection "Reads and updates cart contents"
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

        dynamic orderManagement "OrderAggregateToOrdersCollection" {
            orderAggregate -> ordersCollection "Persists order"
            autoLayout
        }

        dynamic inventoryManagement "InventoryAggregateToCollection" {
            inventoryAggregate -> inventoryCollection "Updates stock levels"
            autoLayout
        }

        dynamic shipping "ShipmentAggregateToCollection" {
            shipmentAggregate -> shipmentsCollection "Persists and retrieves shipment status"
            autoLayout
        }

        dynamic customerManagement "CustomerAggregateToCollection" {
            customerAggregate -> customersCollection "Persists and retrieves customer information"
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