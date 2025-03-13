workspace {
    model {
        ecommerceSystem = softwareSystem "E-commerce System" "Allows customers to browse products, place orders, and manage their accounts" {
            orderManagement = container "Order Management" "Manages the lifecycle of orders"
            productCatalog = container "Product Catalog" "Manages product information and categorization"
            customerManagement = container "Customer Management" "Handles customer accounts and preferences"
            shoppingCart = container "Shopping Cart" "Manages the customer's shopping cart"
            inventoryManagement = container "Inventory Management" "Tracks product stock levels"
            paymentProcessing = container "Payment Processing" "Handles payment transactions"
            shipping = container "Shipping" "Manages order shipment and tracking"
            messageBroker = container "Message Broker" "Handles asynchronous communication between services" "RabbitMQ"
        }

        orderManagement -> messageBroker "Publishes order events"
        paymentProcessing -> messageBroker "Publishes payment events"
        shipping -> messageBroker "Publishes shipping events"
        inventoryManagement -> messageBroker "Publishes inventory events"

        messageBroker -> orderManagement
        messageBroker -> paymentProcessing
        messageBroker -> shipping
        messageBroker -> inventoryManagement
    }

    views {
        container ecommerceSystem "MessageBrokerRelations" {
            include orderManagement productCatalog customerManagement shoppingCart inventoryManagement paymentProcessing shipping messageBroker
            autoLayout
        }

        styles {
            element Container {
                background #438dd5
                color #ffffff
            }
        }
    }
}
