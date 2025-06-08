# ADR-017: Defer Customer Service Implementation

## Status
Accepted

## Context
We initially planned to implement a standalone Customer Service as the next microservice after Product Service. The proposed scope included:
- Customer database collection
- Get customer by ID functionality  
- Customer profile management API

However, analysis of functional requirements revealed no explicit need for customer profile retrieval operations.

## Decision
We will **defer the implementation of a standalone Customer Service** and instead handle customer data inline within other services when needed.

## Date
2025-01-08