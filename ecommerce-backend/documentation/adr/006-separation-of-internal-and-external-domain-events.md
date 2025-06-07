# 2. Separation of Internal and External Domain Events

## Date
2025-05-01

## Context
Some domain events in the ecommerce backend were being used both internally within the publishing subdomain and externally by other subdomains. This dual-purpose use of a single event introduces ambiguity, mixes internal and external concerns, and risks tight coupling between implementation details and public interfaces.

## Decision
**Internal and external events will be clearly separated**.
- Only events that represent **business-relevant state changes across subdomains** will be treated as **public domain events**.
- Internal process continuation within a subdomain will be handled by **internal mechanisms** (e.g., local event handlers, method calls) that do **not rely on publishing or subscribing to public domain events**.
- The domain events list will **exclude internal subscribers** to avoid misrepresenting the boundary of public communication.

## Consequences
- Reduces **coupling** between subdomain internals and public interfaces.
- Encourages clear **bounded context isolation** and DDD alignment.
- Prevents misuse of domain events as technical orchestration tools.
- Improves **maintainability** and understanding of the event-driven architecture.