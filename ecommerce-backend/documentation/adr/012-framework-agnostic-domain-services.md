# 12. Framework-Agnostic Application Services

## Date
2025-05-28

## Context
To keep the application layer free from framework-specific code and ensure maximum portability, even service implementations (use case classes)
should not depend on Spring or any other DI framework annotations. This enforces clear separation between core logic and infrastructure concerns.

## Decision
- **Application services** (use case implementations) will be **pure Java classes** without Spring stereotypes (e.g., no `@Service`).
- **Dependency wiring** will be handled in the configuration package alongside `Application.java`, using manual instantiation or explicit `@Configuration` classes.
- **Ports** (interfaces) remain in the application layer; their implementations live in the same layer but stay framework-agnostic.

## Consequences
- Application layer remains **testable** without needing Spring context.
- Clear separation between **domain/application core** and **infrastructure**.
- Wiring and configuration complexity moves to adapter/config packages.
- No direct coupling of business logic to Spring’s lifecycle or DI.