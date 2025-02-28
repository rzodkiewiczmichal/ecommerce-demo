Feature: Payment verification

  Scenario: Payment is authorized
    Given the customer has confirmed the order
    When the system authorizes the customer's payment
    Then the order status should be updated to "Pending fulfillment"

  Scenario: Payment fails
    Given the customer has confirmed the order
    When the system declines the payment
    Then the order status should be updated to "Cancelled"
    And the customer should receive a notification about the failed payment