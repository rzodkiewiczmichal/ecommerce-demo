# ADR-014: HTTP Files for API Testing

## Status
Accepted

## Context
We need a way to test REST API endpoints during development that is:
- Version controlled and shareable across the team
- Integrated with development environment
- Simple to execute and maintain
- Independent of external tools or complex setup

## Decision
We will use .http files (HTTP Client files) for API endpoint testing, organized in a dedicated `http/` directory within each service.

## Alternatives Considered

### Postman Collections
### cURL scripts
### Integration tests only
### Swagger/OpenAPI UI
## Rationale
It's developer's habit to use this tool

## Implementation
- Created `http/` directory in `product-service/`
- Organized files by functionality:
  - `product-api.http` - Main API endpoint tests
- Used variables for base URLs and common identifiers
- Included both positive and negative test cases

## Usage
Developers can execute HTTP requests directly from their IDE to test endpoints during development, ensuring consistent behavior across different environments.

## Date
2025-01-08