workspace {
    model {
        customer = person "Customer" "A user of the e-commerce system"

        ecommerceSystem = softwareSystem "E-commerce System" "Allows customers to browse products, place orders, and manage their accounts" {
            orderManagement = container "Order Management" "Manages the lifecycle of orders"
            productCatalog = container "Product Catalog" "Manages product information and categorization"
            customerManagement = container "Customer Management" "Handles customer accounts and preferences"
            shoppingCart = container "Shopping Cart" "Manages the customer's shopping cart"
            inventoryManagement = container "Inventory Management" "Tracks product stock levels"
            paymentProcessing = container "Payment Processing" "Handles payment transactions"
            shipping = container "Shipping" "Manages order shipment and tracking"
        }

        paymentGateway = softwareSystem "Payment Gateway" "Processes payments for orders"
        shippingProvider = softwareSystem "Shipping Provider" "Handles order delivery"
        messageBroker = softwareSystem "Message Broker" "Handles asynchronous communication between services" "RabbitMQ"
        database = softwareSystem "Database" "Stores all e-commerce data" "MongoDB"

        # System Context relationships
        customer -> ecommerceSystem "Uses"
        ecommerceSystem -> paymentGateway "Processes payments using"
        ecommerceSystem -> shippingProvider "Arranges shipments using"
        ecommerceSystem -> messageBroker "Publishes and consumes events"
        ecommerceSystem -> database "Reads from and writes to"

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
        }
    }
}
