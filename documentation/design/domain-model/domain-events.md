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


# RabbitMQ Configuration per Domain Event

| Event Name                | Exchange Type | Routing Key / Pattern     | Queue Strategy               |
|---------------------------|----------------|----------------------------|-------------------------------|
| OrderValidated            | direct         | order.validated            | Durable queue (Payment)       |
| PaymentInitiated          | fanout         | —                          | Durable queues (multiple)     |
| PaymentConfirmed          | direct         | payment.confirmed          | Durable queue (Order Mgmt)    |
| PaymentFailed             | topic          | payment.failed.*           | Durable queues (Order, Notif) |
| OrderCancelled            | direct         | order.cancelled            | Durable queue (Warehouse)     |
| OrderForwardedToWarehouse | direct         | order.forwarded            | Durable queue (Warehouse)     |
| StockDeducted             | direct         | stock.deducted             | Durable queue (Shipping)      |
| OrderShipped              | fanout         | —                          | Durable queues (Notif)        |
| OrderDelivered            | direct         | order.delivered            | Durable queue (Notification)  |