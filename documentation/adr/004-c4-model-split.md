# 4. Splitting the C4 model into multiple files

## Date
2025-03-13

## Context
Having only bounded contextes in C4 diagram was fine, everything was readable. 
After adding message broker and database and relations between them and bounded contextes the diagram became too big and unreadable.

## Decision
One diagram will be split into multiple files:
1. Bounded Contextes - all bounded contextes and relations between them
2. Message Broker - bounded contextes and message broker, relations between them, no relations between bounded contextes and bounded contextes
3. Database - bounded contextes and database, relations between them, no relations between bounded contextes and bounded contextes

## Consequences
There is no full context on one diagram, but seeing it in three different diagrams is more readable.


