# 10. Removal of Shopping Cart Container from C4 Model

## Date
2025-05-11

## Context
The C4 container diagram previously included a **Shopping Cart** container with its own relationships.
In practice, the shopping cart is an ephemeral UI concern rather than a standalone microservice or bounded context.
Order Management receives product IDs directly from the client, and cart state is managed in the front-end 
(or within the Order Management service during checkout), so modeling a separate Shopping Cart container is misleading.

## Decision
**The Shopping Cart container and all its relationships are removed from the C4 model.**
- Delete the `shoppingCart` container and its `Cart Aggregate` component.
- Remove any container relationships to/from `shoppingCart`.
- Handle all cart‐related functionality in the front-end or within the Order Management service as part of the checkout workflow.

## Consequences
- Simplifies the architecture diagram and avoids implying an extra service.
- Clarifies bounded contexts: only Order Management owns order placement and transient cart behavior.
- Prevents confusion over where cart state is stored and managed.
- Front-end or Order Management must fully manage cart state lifecycle during user sessions.  