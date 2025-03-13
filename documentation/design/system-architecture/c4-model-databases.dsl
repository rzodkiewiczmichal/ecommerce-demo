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
            database = container "Database" "Stores all e-commerce data" "MongoDB"
        }

        orderManagement -> database "Reads from and writes to"
        productCatalog -> database "Reads from and writes to"
        customerManagement -> database "Reads from and writes to"
        shoppingCart -> database "Reads from and writes to"
        inventoryManagement -> database "Reads from and writes to"
        paymentProcessing -> database "Reads from and writes to"
        shipping -> database "Reads from and writes to"
    }

    views {
        container ecommerceSystem "DatabaseRelations" {
            include orderManagement productCatalog customerManagement shoppingCart inventoryManagement paymentProcessing shipping database
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
