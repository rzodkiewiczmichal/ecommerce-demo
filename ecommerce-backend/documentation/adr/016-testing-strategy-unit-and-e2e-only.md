# ADR-016: Testing Strategy - Unit Tests for Domain and End-to-End Tests Only

## Status
Accepted

## Context
We need to define a testing strategy that provides sufficient coverage while maintaining development velocity and avoiding test maintenance overhead. The microservice architecture requires testing both business logic isolation and full system integration.

## Decision
We will implement a two-layer testing strategy:
1. **Unit tests** exclusively for domain services (business logic)
2. **End-to-end tests** for complete API flows with real HTTP calls
3. **No integration tests** or other intermediate test layers

## Alternatives Considered
## Rationale
This approach provides:
- **High-value coverage**: Domain logic (unit) + full system behavior (E2E)
- **Reduced maintenance**: Fewer test layers to maintain
- **Clear boundaries**: Domain vs. system-level concerns
- **Fast feedback**: Quick unit tests + comprehensive E2E validation
- **Production confidence**: E2E tests verify actual API contracts

## Implementation

### Unit Tests for Domain Services
- Test business logic in isolation
- Focus on domain rules, validation, and calculations
- Mock all external dependencies
- Fast execution, no external resources

### End-to-End Tests
- Full Spring Boot application startup
- Real HTTP API calls via TestRestTemplate/WebTestClient
- Real database (TestContainers with MongoDB)
- External APIs stubbed using WireMock containers

### Third-Party API Stubbing Strategy
Use **TestContainers + WireMock** for external service stubbing:
```java
@Container
static WireMockContainer wiremock = new WireMockContainer("wiremock/wiremock:latest");

@BeforeEach
void setupStubs() {
    wiremock.stubFor(get("/external-service/data")
        .willReturn(ok().withBody("stubbed response")));
}
```

### Test Data Management
- Use real database with TestContainers
- Groovy scripts adapted for test data setup
- Isolated test data per test class/method

## Consequences

### Positive
- Clear testing boundaries and responsibilities
- Reduced test maintenance overhead
- High confidence in both business logic and system integration
- Faster development cycles with focused testing
- Production-like E2E environment with containers

### Negative
- Potential gaps in intermediate layer testing
- E2E tests slower than integration tests
- Requires TestContainers infrastructure setup

## Tools and Dependencies
- **JUnit 5** for test framework
- **TestContainers** for MongoDB and WireMock containers
- **WireMock** for external API stubbing
- **Spring Boot Test** for E2E test infrastructure
- **AssertJ** for fluent assertions

## Test Organization
```
src/test/java/
├── unit/               # Domain service unit tests
│   └── domain/
└── e2e/               # End-to-end API tests
    └── api/
```

## Date
2025-01-08