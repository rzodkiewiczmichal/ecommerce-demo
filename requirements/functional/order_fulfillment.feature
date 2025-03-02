Feature: Order Fulfillment

  Scenario: Reserving stock for a new order
    Given a customer places an order for 2 units of product "SKU-001"
    When the order is confirmed
    Then 2 units of "SKU-001" should be reserved in the warehouse
    And the available stock for "SKU-001" should be reduced by 2

  Scenario: Releasing stock for a cancelled order
    Given there is an order with 3 units of product "SKU-002" reserved
    When the order is cancelled
    Then the 3 units of "SKU-002" should be released back to available stock
    And the available stock for "SKU-002" should be increased by 3

  Scenario: Fulfilling an order with all items in stock
    Given there is a confirmed order with the following items:
      | Product  | Quantity |
      | SKU-003  | 1        |
      | SKU-004  | 2        |
    And all items are in stock
    When the warehouse staff starts fulfilling the order
    Then all items should be marked as picked
    And the order status should change to "Ready for Shipment"


  Scenario: Updating inventory after successful shipment
    Given an order has been shipped with the following items:
      | Product  | Quantity |
      | SKU-007  | 2        |
      | SKU-008  | 1        |
    When the shipment is confirmed
    Then the inventory for SKU-007 should be reduced by 2
    And the inventory for SKU-008 should be reduced by 1

  Scenario: Triggering low stock alert
    Given the product "SKU-009" has a low stock threshold of 10 units
    When the available stock of "SKU-009" falls to 9 units after an order
    Then a low stock alert should be triggered for "SKU-009"
    And the purchasing department should be notified to restock "SKU-009"
