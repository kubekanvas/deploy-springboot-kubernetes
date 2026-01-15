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
*(you can use image `kubekanvas/springbootstarter:latest` pulled from Docker Hub automatically → [Docker Hub link](https://hub.docker.com/r/kubekanvas/springbootstarter))*


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


# Deploy to Kubernetes using Kubekanvas

This project can be deployed to a local Kubernetes cluster (Docker Desktop, Kind, Minikube, etc.) using **Kubekanvas**, a visual Kubernetes IDE.

### Prerequisites

* Configure **kubekanvas CLI** first.  
  Navigate to How KubeKanvas Works:  
  [https://www.kubekanvas.io/how-kubekanvas-works](https://www.kubekanvas.io/how-kubekanvas-works)

* A running Kubernetes cluster
  *(Docker Desktop with Kubernetes enabled is recommended)*


---

### Step 1: Open the Kubekanvas Template

Navigate to the Spring Boot template page:  
[https://kubekanvas.io/templates/deploying-a-spring-boot-app-via-kubekanvas](https://kubekanvas.io/templates/deploying-a-spring-boot-app-via-kubekanvas)


This template already contains:

* Spring Boot Deployment
* PostgreSQL StatefulSet with persistent storage
* Headless Service for database connectivity
* Secrets for credentials
* NGINX Ingress for external access

---

### Step 2: Create a Project from the Template And Run in Your Cluster

1. Click **“Get started with this template”** on the template page
2. Provide a **project name**
3. Click a **“Release management”** play icon and **create release**
4. Select your **target Kubernetes cluster** and provide final **namespace**
5. Kubekanvas will generate all required Kubernetes resources

No YAML authoring is required — the entire stack is pre-configured and the deployment status will be shown you have to click **Refresh** button till the status become **Deployed** .

---

### Step 3: Access Your App inside Your Cluster

Once deployed, the application becomes accessible via the configured **NGINX Ingress** endpoint.

Example:

```
http://<ingress-controller-address>/frontend-service
```

---

### Why Kubekanvas?

* Visualize Kubernetes architecture in real time
* Safely deploy without exposing YAML complexity
* Deploy your entire configuration at one click while watching the process in real time





