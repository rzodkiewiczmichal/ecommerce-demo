# ADR-018: Separate Product Representations Across Bounded Contexts

## Status
Accepted

## Context
In our microservices architecture, we encountered an architectural challenge when implementing the Order Service. The Order Service needs to access product information to validate orders, but the Product aggregate root is owned by the Product Service bounded context.

We identified several potential solutions:
1. **Direct dependency**: Order Service directly depending on Product Service domain model
2. **Shared aggregate**: Moving Product aggregate to shared domain module
3. **Separate representations**: Each bounded context defines its own Product representation

The first option violates bounded context independence by creating tight coupling between services. The second option breaks DDD principles as aggregate roots should belong to a single bounded context.

## Decision
We will implement separate Product representations for each bounded context that needs product information.

### Implementation Details:
- **Product Service**: Maintains the full Product aggregate root with complete domain logic
- **Order Service**: Defines its own Product value object containing only data needed for order processing:
  - ProductId (shared identifier)
  - Product name
  - Price
  - Availability status
- **Anti-corruption layer**: LoadProductPort implementation will translate between Product Service's full Product and Order Service's simplified Product representation

### Benefits:
1. **Bounded Context Independence**: Each service maintains its own domain model without dependencies
2. **DDD Compliance**: Aggregate roots remain within their owning bounded context
3. **Reduced Coupling**: Services communicate through well-defined interfaces, not shared domain objects
4. **Evolution Independence**: Each service can evolve its Product representation independently
5. **Context-Specific Modeling**: Each service models Product with only the data it actually needs

### Trade-offs:
1. **Code Duplication**: Product concept is modeled in multiple places
2. **Translation Overhead**: Anti-corruption layer adds complexity
3. **Consistency Challenges**: Must ensure translations remain correct as models evolve

## Consequences
- Order Service will have its own Product domain object with minimal product data
- Product Service remains the single source of truth for complete product information
- Integration between services will require explicit translation layers
- Each service can evolve its Product representation independently
- We maintain proper bounded context boundaries as defined in DDD principles


## Related ADRs
- ADR-002: Domain Model Definition
- ADR-008: Application Architecture
- ADR-012: Framework Agnostic Domain Services