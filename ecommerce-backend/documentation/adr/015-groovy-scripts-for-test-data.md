# ADR-015: Groovy Scripts for Test Data Setup

## Status
Accepted

## Context
We need a reliable way to populate the database with test data for local development that is:
- Easy to execute and maintain
- Consistent across different developer environments
- Version controlled with the codebase
- Suitable for JVM-based development workflow

## Decision
We will use Groovy scripts with @Grab dependency management for test data setup, executed directly via the Groovy runtime.

## Rationale
It's developer's preference to use Groovy for scripting tasks in JVM environment.

## Implementation
- Created `scripts/` directory in `product-service/`
- `setup-test-data.groovy` script with @Grab for MongoDB driver
- Automatic dependency downloading on first execution
- Clear console output showing progress and results
- Error handling with meaningful messages

## Usage
Developers install Groovy locally and execute the script to populate their local database with consistent test data, enabling immediate API testing.

## Date
2025-01-08