# Spring Boot Project: kubekanvas-SpringBootStarter



---

## Containerization with Docker

This project is fully containerized using a **multi-stage Docker build**. This approach ensures the final production image is as small and secure as possible by excluding build tools like Maven from the runtime environment.

### The Dockerfile Breakdown

Our `Dockerfile` consists of two main stages:

1. **Build Stage:** Uses a Maven image to compile the source code and package it into an executable JAR.
2. **Runtime Stage:** Uses a lightweight OpenJDK JRE image. It only copies the JAR from the first stage, resulting in a significantly smaller image size.

#### How to Build and Run Locally:

```bash
# 1. Build the Docker image
docker build -t your-app-name:latest .

# 2. Run the container
# This maps port 8080 of the container to 8080 on your host machine
docker run -p 8080:8080 your-app-name:latest

```

---

## Tech Stack

* **Java 17/21**
* **Spring Boot 3.x**
* **Spring Data JPA**
* **Maven** (Build Tool)
* **Docker** (Containerization)

---

## Getting Started

1. **Clone the repository:**
```bash
https://github.com/kubekanvas/deploy-springboot-kubernetes.git

```


2. **Run with Maven:**
```bash
./mvnw spring-boot:run

```


3. **Access the API:**
The application will be running at `http://localhost:8080`


