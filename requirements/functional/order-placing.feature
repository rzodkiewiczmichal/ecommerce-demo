Feature: Placing an order

  Scenario: Customer submits an order
    Given the customer has added products to the cart
    When the customer confirms the order and provides delivery details
    Then the order should be recorded in the system
    And the customer should receive an order confirmation email