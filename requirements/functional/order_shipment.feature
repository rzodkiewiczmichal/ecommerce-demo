Feature: Order Shipment

  Scenario: Preparing shipment for a paid order
    Given there is a paid order with ID "ORD-12345"
    When the warehouse staff starts processing the order
    Then the order status should change to "Preparing for Shipment"
    And the stock for ordered items should be allocated

  Scenario: Generating shipping label
    Given there is an order ready for shipment
    When the warehouse staff generates a shipping label
    Then a valid shipping label should be created
    And the shipping tracking number should be assigned to the order

  Scenario: Marking order as shipped
    Given there is an order with generated shipping label
    When the warehouse staff marks the order as shipped
    Then the order status should change to "Shipped"
    And the customer should receive a shipment notification email with tracking information

  Scenario: Updating tracking information
    Given there is a shipped order with tracking number
    When the shipping carrier provides an update on the package location
    Then the tracking information should be updated in the system
    And the customer should be able to see the updated tracking info in their account

  Scenario: Handling shipping exceptions
    Given there is a shipped order
    When the shipping carrier reports a delivery exception "Address not found"
    Then the order status should change to "Shipping Exception"
    And customer service should be notified to contact the customer
    And the customer should receive an email about the delivery issue

  Scenario: Confirming delivery
    Given there is a shipped order
    When the shipping carrier confirms the package has been delivered
    Then the order status should change to "Delivered"
    And the customer should receive a delivery confirmation email
