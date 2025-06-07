Feature: Payment Verification

  Scenario: Successful payment by credit card
    Given the customer has placed an order with total amount of 100 EUR
    And the customer has chosen to pay by credit card
    When the customer enters valid credit card details:
      | Field           | Value                |
      | Card Number     | 4111111111111111     |
      | Expiration Date | 12/25                |
      | CVV             | 123                  |
    And submits the payment
    Then the payment should be processed successfully
    And the order status should change to "Paid"
    And the customer should receive a payment confirmation email

  Scenario: Failed payment due to insufficient funds
    Given the customer has placed an order with total amount of 200 EUR
    And the customer has chosen to pay by credit card
    When the customer enters credit card details with insufficient funds
    And submits the payment
    Then the payment should be declined
    And the customer should see an error message "Payment failed: Insufficient funds"
    And the order status should remain "Awaiting Payment"


  Scenario: Payment timeout
    Given the customer has initiated a payment for an order
    When 15 minutes pass without completing the payment
    Then the payment process should be cancelled
    And the order should return to "Awaiting Payment" status
    And the customer should receive a reminder email about the pending payment

