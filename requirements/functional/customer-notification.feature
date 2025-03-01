Feature: Customer Notifications

  Scenario: Sending order confirmation email
    Given a customer has placed an order with ID "ORD-12345"
    When the order is successfully created
    Then an order confirmation email should be sent to the customer
    And the email should contain the order details and total amount

  Scenario: Sending payment confirmation email
    Given an order with ID "ORD-12345" has been paid
    When the payment is successfully processed
    Then a payment confirmation email should be sent to the customer
    And the email should include the payment amount and method used

  Scenario: Sending shipping notification
    Given an order with ID "ORD-12345" has been shipped
    When the shipping label is created
    Then a shipping notification email should be sent to the customer
    And the email should include the tracking number and estimated delivery date

  Scenario: Sending delivery confirmation
    Given an order with ID "ORD-12345" has been delivered
    When the delivery is confirmed by the shipping carrier
    Then a delivery confirmation email should be sent to the customer
    And the email should thank the customer for their purchase

  Scenario: Sending abandoned cart reminder
    Given a customer has added items to their cart
    And the customer has not completed the purchase within 24 hours
    When the system runs the daily abandoned cart check
    Then an email reminder should be sent to the customer
    And the email should include a link to their saved cart

