Feature: Order shipment

  Scenario: Order is handed over to the courier
    Given the warehouse has completed order processing
    When the order is handed over to the courier service
    Then the customer should receive a tracking number
    And the order status should be updated to "Shipped"