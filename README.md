🏥 Healthcare Microservices Platform

A cloud-native healthcare backend platform built using Microservices Architecture with Java, Spring Boot, Kafka, gRPC, Docker, and AWS.

This platform demonstrates modern distributed system design including:

✨ Event-driven architecture
✨ Secure authentication with JWT
✨ Inter-service communication using gRPC
✨ REST APIs via API Gateway
✨ Containerized services with Docker
✨ Cloud deployment on AWS ECS Fargate
✨ Infrastructure as Code using AWS CDK

🚀 Architecture Overview

The system is composed of multiple microservices communicating through REST APIs, gRPC, and Kafka events.

📌 Client requests enter through an API Gateway, which handles routing and authentication.

📌 Services run as Docker containers on AWS ECS Fargate inside a VPC private subnet.

📌 Patient events are published to Kafka (AWS MSK) and consumed by analytics services.

🧠 System Architecture
Main Architecture

🧩 Microservices
👤 Patient Service

Manages all patient-related operations.

Features

✅ Patient registration
✅ Patient update functionality
✅ Patient deletion capability
✅ Retrieve patient data
✅ Email uniqueness validation

Improvements

🔹 Enhanced exception handling
🔹 Clear validation error messages
🔹 Improved application logging

Event Publishing

When a new patient is created:

📡 A Kafka event is published in real-time enabling downstream services to react automatically.

💳 Billing Service

Handles billing account creation.

Features

✅ gRPC-based billing account creation
✅ Automatic billing account generation for new patients
✅ Containerized deployment

Communication

Patient service communicates with billing using gRPC for high-performance service calls.

🔐 Authentication Service

Provides authentication and authorization.

Features

✅ Login endpoint
✅ JWT token generation
✅ Token validation
✅ Secure API access

Security

All APIs require:

Authorization: Bearer <JWT_TOKEN>

Requests without valid tokens are rejected.

📊 Analytics Service

Processes system events and generates analytics.

Features

📥 Kafka consumer for patient events
📈 Real-time data processing
⚡ Event-driven analytics pipelines

🌐 API Gateway

Acts as the single entry point for the system.

Responsibilities

🚦 Route requests to services
🔐 Enforce authentication
🔄 Path rewriting
📑 Authentication documentation route

📨 Event Driven Architecture

The system uses Apache Kafka for asynchronous communication.

Workflow
Patient Created
      │
      ▼
Kafka Topic (patient)
      │
      ▼
Analytics Service consumes event
Kafka Improvements

⚡ Upgraded Kafka to 3.7.x
⚡ Increased MSK cluster brokers from 1 → 2
⚡ Added Kafka consumer for logging events

🧪 Testing

The platform includes integration tests covering full workflows.

Test Scenarios

✅ Successful authentication
✅ Invalid login attempts
✅ Authorized API access
✅ Patient retrieval

☁️ AWS Infrastructure

Infrastructure is defined using Infrastructure as Code with AWS CDK.

AWS Services Used

🛜 VPC – Network isolation
🐳 ECS Fargate – Container orchestration
💾 RDS (PostgreSQL) – Databases
📡 MSK – Kafka cluster
⚖️ Application Load Balancer (ELB)
🧭 CloudMap – Service discovery
🌍 Route 53 – DNS management
🖥 EC2 – Supporting infrastructure

🐳 Containerization

All services run in Docker containers.

Benefits:

✅ Environment consistency
✅ Easier deployments
✅ Scalable microservices

🛠 Tech Stack
Backend

☕ Java
🌱 Spring Boot
🔗 REST APIs
⚡ gRPC

Messaging

📨 Apache Kafka
☁️ AWS MSK

Database

🐘 PostgreSQL
☁️ AWS RDS

DevOps

🐳 Docker
☁️ AWS CDK
🚀 ECS Fargate
🧪 Integration Tests

📂 Project Structure
healthcare-microservices
│
├── patient-service
├── billing-service
├── auth-service
├── analytics-service
├── api-gateway
├── integration-tests
├── infrastructure (AWS CDK)

✨ Key Highlights

🚀 Microservices architecture
🔐 Secure authentication with JWT
📡 Event-driven system with Kafka
⚡ gRPC inter-service communication
☁️ Cloud deployment on AWS
🐳 Docker containerization
🧪 Integration testing


<img width="2048" height="1073" alt="image" src="https://github.com/user-attachments/assets/c46fb8d5-abf2-4b29-bf3d-fc40fbd83619" />
