# 11. Port Interface Definition and Implementation Guidelines

## Date
2025-05-11

## Context
To keep our microservice’s application layer clear and maintainable, we need a consistent convention for defining
in ports and their implementations. Each use case should have its own interface with a single method.

## Decision
- **One port per functionality**: Each inbound use case lives in its own interface under  
  `com.rzodkiewiczmichal.ecommerce.productservice.application.port.in`.
- **One method per interface**: Every interface declares exactly one method. Method names should clearly describe the action (e.g., `GetProductById`, `ListProducts`, `GetProductsByIds`).
- **Separate packages for inbound vs. outbound ports**:
    - Inbound ports (use cases) in `...port.in`
    - Outbound ports (driven adapters) in `...port.out`
- **Implementation in adapters**:
    - Inbound adapters (e.g., Spring MVC controllers) invoke the inbound-port interfaces.
    - Outbound adapters (e.g., `MongoProductRepository`) implement outbound-port interfaces under  
      `com.rzodkiewiczmichal.ecommerce.productservice.infrastructure.persistence`.
- **Naming conventions**:
    - Inbound port interface: `<UseCaseName>UseCase` (e.g., `GetProductByIdUseCase`)
    - Implementation class: `<PortName>Adapter` or `<PortName>Service` (e.g., `MongoGetProductByIdAdapter`)

## Consequences
- **Clarity**: One interface → one use case → one method makes it obvious what functionality each port provides.
- **Testability**: Fine-grained interfaces are trivial to mock or stub during tests.
- **Flexibility**: Adding, removing, or replacing functionality only requires adding/removing one interface and its adapter.
- **Overhead**: More interfaces and classes, but these are small, well-named, and consistent.
- **Alignment with Hexagonal Architecture**: Strong separation between core application logic and external details ensures the domain remains framework-agnostic.  