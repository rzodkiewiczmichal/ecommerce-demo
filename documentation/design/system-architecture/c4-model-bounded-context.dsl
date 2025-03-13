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
        }

        orderManagement -> paymentProcessing "Initiates payment"
        orderManagement -> shipping "Initiates shipment"
        productCatalog -> inventoryManagement "Checks stock levels"
        shoppingCart -> productCatalog "Gets product information"
        orderManagement -> inventoryManagement "Updates stock levels"
    }

    views {
        container ecommerceSystem "BoundedContextsOnly" {
            include orderManagement productCatalog customerManagement shoppingCart inventoryManagement paymentProcessing shipping
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
