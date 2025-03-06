workspace {
    model {
        customer = person "Customer" "A user of the e-commerce system"
        ecommerceSystem = softwareSystem "E-commerce System" "Allows customers to browse products, place orders, and manage their accounts"
        paymentGateway = softwareSystem "Payment Gateway" "Processes payments for orders"
        shippingProvider = softwareSystem "Shipping Provider" "Handles order delivery"

        customer -> ecommerceSystem "Browses products, places orders, and manages account"
        ecommerceSystem -> paymentGateway "Processes payments for orders"
        ecommerceSystem -> shippingProvider "Sends order details for delivery"
    }

    views {
        systemContext ecommerceSystem "SystemContext" {
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
        }
    }
}
