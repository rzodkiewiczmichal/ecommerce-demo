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
            messageBroker = container "Message Broker" "Handles asynchronous communication between services" "RabbitMQ"
            database = container "Database" "Stores all e-commerce data" "MongoDB"
        }
        paymentGateway = softwareSystem "Payment Gateway" "Processes payments for orders"
        shippingProvider = softwareSystem "Shipping Provider" "Handles order delivery"

        customer -> ecommerceSystem "Browses products, places orders, and manages account"
        customer -> productCatalog "Browses products"
        customer -> shoppingCart "Adds products to cart"
        customer -> orderManagement "Places orders"
        customer -> customerManagement "Manages account"

        orderManagement -> paymentProcessing "Initiates payment"
        orderManagement -> shipping "Initiates shipment"
        paymentProcessing -> paymentGateway "Processes payments"
        shipping -> shippingProvider "Sends shipping details"

        productCatalog -> inventoryManagement "Checks stock levels"
        shoppingCart -> productCatalog "Gets product information"
        orderManagement -> inventoryManagement "Updates stock levels"

        orderManagement -> messageBroker "Publishes order events"
        paymentProcessing -> messageBroker "Publishes payment events"
        shipping -> messageBroker "Publishes shipping events"
        inventoryManagement -> messageBroker "Publishes inventory events"
        messageBroker -> orderManagement "Delivers relevant events"
        messageBroker -> paymentProcessing "Delivers relevant events"
        messageBroker -> shipping "Delivers relevant events"
        messageBroker -> inventoryManagement "Delivers relevant events"

        orderManagement -> database "Reads from and writes to"
        productCatalog -> database "Reads from and writes to"
        customerManagement -> database "Reads from and writes to"
        shoppingCart -> database "Reads from and writes to"
        inventoryManagement -> database "Reads from and writes to"
        paymentProcessing -> database "Reads from and writes to"
        shipping -> database "Reads from and writes to"
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
