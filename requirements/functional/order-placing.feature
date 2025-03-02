Feature: Order Placing

  Scenario: Customer successfully places an order with immediate payment
    Given the customer has added products to the cart
    And the customer is on the checkout page
    When the customer provides valid delivery details:
      | Field       | Value           |
      | Name        | Jan Kowalski    |
      | Address     | Testowa 1       |
      | City        | Warszawa        |
      | Postal Code | 00-001          |
      | Email       | jan@example.com |
    And the customer selects a payment method "Credit Card"
    And the customer confirms the order
    Then the order should be created with status "Pending Payment"
    And the customer should be redirected to the payment gateway
    And upon successful payment, the order status should change to "Confirmed"
    And the customer should receive an order confirmation email

  Scenario: Customer attempts to place an order with insufficient stock
    Given the customer has added a product with insufficient stock to the cart
    When the customer tries to proceed to checkout
    Then the customer should see an error message "Some items in your cart are out of stock"
    And the customer should not be able to place the order

  Scenario: Customer cancels an order
    Given the customer has placed an order with status "Awaiting Payment"
    When the customer selects to cancel the order
    Then the order status should change to "Cancelled"
    And any reserved stock should be released
    And the customer should receive an order cancellation confirmation email

