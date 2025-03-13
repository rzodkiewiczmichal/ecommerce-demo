# 3. Use of C4 Model for System Architecture Documentation

## Date
2025-03-06

## Context
There's a need to document system architecture and application architecture in a standardized and consistent way.
The tool needs to support diagrams.

## Decision
We will use the C4 model (Context, Containers, Components) to document our system's architecture.
We will implement this using the Structurizr tool, which provides a Domain Specific Language (DSL) for creating C4 diagrams.
The code level of C4 won't be used as Structurizr doesn't support it.
## Consequences

1. Standardized approach: C4 provides a standard set of abstractions for describing software architecture.
2. Multiple levels of detail: C4 allows us to create diagrams at different levels of abstraction, from system context to individual components.
4. Version control friendly: Using Structurizr DSL allows us to version our architecture diagrams alongside our code.
5. Maintainability: Structurizr DSL makes it easier to keep our architecture documentation up-to-date as the system evolves.

