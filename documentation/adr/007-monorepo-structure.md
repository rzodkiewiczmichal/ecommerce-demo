# 7. Monorepo Structure for Microservice Development

## Date
2025-05-03

## Context
The ecommerce backend consists of multiple microservices that need to evolve independently but are developed and
maintained by a single person. There is one repository created for the whole project.

## Decision
All microservices will be stored in a **single Git repository (monorepo)**.
Each microservice will remain logically and physically isolated within the monorepo, supporting individual build, test, and deployment pipelines.

### Directory Structure

```plaintext
ecommerce-backend/
├── services/
│   ├── order-service/
│   ├── payment-service/
│   ├── warehouse-service/
│   └── notification-service/
├── shared/
│   ├── event-contracts/
│   └── common-lib/
├── infra/
│   ├── docker-compose.yml
│   └── env/
├── .github/
│   └── workflows/
├── README.md
└── pom.xml