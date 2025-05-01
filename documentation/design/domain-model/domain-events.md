# Domain Events

This document lists all domain events defined in the ecommerce backend system, including their publisher subdomain and intended consumers.

| Event Name                | Publisher Subdomain | Subscriber Subdomain(s)                     |
|---------------------------|---------------------|---------------------------------------------|
| OrderValidated            | Order Management    | Payment                                     |
| PaymentInitiated          | Payment             | Warehouse, Notification                     |
| PaymentConfirmed          | Payment             | Order Management                            |
| PaymentFailed             | Payment             | Order Management, Notification              |
| OrderCancelled            | Order Management    | Warehouse                                   |
| OrderForwardedToWarehouse | Order Management    | Warehouse                                   |
| StockDeducted             | Warehouse           | Shipping                                    |
| OrderShipped              | Shipping            | Notification                                |
| OrderDelivered            | Shipping            | Notification                                |