# 5. Revert of: 4.Splitting the C4 model into multiple files

## Date
2025-03-13

## Context
Realized such a split breaks fundamental idea of C4 levels of abstraction.


## Decision
Reverting to one diagram with correct levels:
1. System Context including message broker and database
2. Containers including bounded contextes and relations between them



