# 8. Hexagonal Architecture for Microservices

## Date
2025-05-01

## Context
One of project purposes is to practice clean hexagonal architecture principles.

## Decision
Each microservice will adopt a **hexagonal (ports and adapters) architecture**.  
This structure ensures business logic is independent of delivery and infrastructure technologies.
The application core will be written in plain Java (POJOs), and infrastructure concerns (like messaging and persistence) will be plugged in via adapters.
Reference directory structure:
<pre>
&lt;service&gt;/
├── domain/            # Aggregates, value objects, domain events  
├── application/       # Use cases, service interfaces, domain logic  
├── infrastructure/  
│   ├── messaging/     # RabbitMQ publishers and listeners  
│   └── persistence/   # MongoDB repositories  
├── adapter/           # Implementations of input/output ports (optional)  
├── config/            # Manual Spring configuration  
└── Application.java   # Entry point (Spring Boot)  
</pre>

It's not a strict rule: if for any subdomain layered architecture or core & plug-in architecture is more suitable, it can be used.

## Consequences
- Promotes **separation of concerns** and **testability**.
- Keeps business logic **independent** from framework and tech stack.
- Enables **easy substitution** of messaging or database technology.
- Encourages **domain-driven design** and clarity of purpose per layer.