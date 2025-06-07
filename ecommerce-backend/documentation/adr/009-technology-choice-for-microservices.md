# 9. Technology Stack for Microservices

## Date
2025-05-01

## Context
Each microservice in the ecommerce backend needs to support HTTP exposure, MongoDB persistence,
and asynchronous messaging via RabbitMQ, while remaining lightweight, modular, and framework-agnostic at the domain level.
Full Spring Boot is not required and would introduce unnecessary auto-configuration and complexity.
A selective approach is preferred to keep services minimal and explicit in wiring.

## Decision
Each microservice will be built using the following technologies:

- **Spring Framework (Core Context only)**  
  Use Spring’s lightweight `spring-context` module for dependency injection and bean lifecycle management, without relying on full Spring Boot autoconfiguration. This gives fine-grained control over application setup.

- **Spring Data MongoDB**  
  Used for persistence. Provides repository abstraction for MongoDB, allowing integration with domain models using adapters. Can be used without Spring Boot.

- **Spring AMQP**  
  Provides RabbitMQ integration through `RabbitTemplate` and message listener containers. Enables event publishing and consumption with declarative configuration.

- **Maven**  
  The system will use **Maven** for build and dependency management. A root `pom.xml` will define common versions, and each microservice will be a Maven module with its own `pom.xml`.

- **Docker & Docker Compose**  
  Used for local orchestration of microservices along with supporting infrastructure (RabbitMQ, MongoDB).

## Consequences
- Provides **modularity and control** without Spring Boot overhead.
- All **dependencies are explicit** and services are configured manually.
- Still leverages the power and ecosystem of Spring libraries (AMQP, MongoDB).
- Builds remain **fast and portable** using Maven and Docker.
- Consistent stack across services simplifies development, CI, and deployment.