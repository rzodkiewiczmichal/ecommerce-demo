Feature: Order fulfillment

  Scenario: Warehouse processes the order
    Given the payment has been authorized
    When the system forwards the order to the warehouse
    Then the warehouse should start order processing
    And the customer should receive a notification about the order preparation