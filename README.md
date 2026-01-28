\# Transaction Aggregation Platform



A Spring Boot–based microservices platform for ingesting, persisting, and aggregating financial transactions.



This project demonstrates a \*\*production-style backend architecture\*\* using:

\- Spring Boot 3

\- PostgreSQL

\- Docker \& Docker Compose

\- Maven multi-module setup



---



\## Architecture Overview



The system consists of the following services:



\### Ingestion API

\- Accepts incoming transaction data

\- Persists transactions to PostgreSQL

\- Runs on port \*\*8080\*\*



\### Aggregator API

\- Aggregates persisted transaction data

\- Exposes read-only aggregation endpoints

\- Runs on port \*\*8081\*\*


\### PostgreSQL

\- Shared database used by both services

\- Containerized using official PostgreSQL image

\### Configuration
Both APIs support environment variable overrides for database and port configuration.
Defaults are provided for local Docker usage.

Example variables:
- DB_URL
- DB_USERNAME
- DB_PASSWORD
- SERVER_PORT

---



\## Project Structure

transaction-aggregation-platform

│

├── common/ # Shared utilities \& DTOs

├── persistence/ # JPA entities \& repositories

├── ingestion-core/ # Business logic for ingestion

├── ingestion-api/ # REST API for ingestion

├── aggregator-core/ # Aggregation business logic

├── aggregator-api/ # REST API for aggregation

│

├── docker-compose.yml

├── pom.xml # Parent Maven POM

└── README.md







---



\## Prerequisites



Make sure you have the following installed:



\- Java \*\*17+\*\*

\- Maven \*\*3.9+\*\*

\- Docker \& Docker Compose



---



\## Build \& Run (Docker)



\### 1️ Build the project



From the root directory:



```bash

mvn clean package



2️ Build and start all services

docker-compose up --build





This will start:



PostgreSQL



Ingestion API → http://localhost:8080



Aggregator API → http://localhost:8081





- Running Tests



To run all unit tests:



mvn test





To run tests for a specific module:



cd ingestion-api

mvn test





- Health Checks



Both APIs expose Spring Boot Actuator endpoints:



Ingestion API

http://localhost:8080/actuator/health



Aggregator API

http://localhost:8081/actuator/health





- Docker Notes



Each API has its own Dockerfile



Docker Compose handles:



Service startup



Network configuration



Database connectivity



- Design Considerations



Clean separation between API and business logic layers



Shared persistence module to avoid duplication



Production-grade configuration structure



Container-first deployment approach



- Technology Stack



Language: Java



Framework: Spring Boot 3.2



Database: PostgreSQL 16



Build Tool: Maven



Containerization: Docker, Docker Compose



- Author

Programming Language: Java





