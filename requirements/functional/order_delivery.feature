Feature: Order delivery

  Scenario: The courier delivers the package to the customer
    Given the order status is "Shipped"
    When the courier delivers the package to the customer's address
    Then the order status should be updated to "Delivered"
    And the customer should receive a delivery confirmation email