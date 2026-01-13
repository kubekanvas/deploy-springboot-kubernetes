# Stage 1: Build the application
# We use a Maven image with JDK 17 to compile the source code
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app

# Copy the pom.xml and source code to the container
COPY . .

# Package the application (skipping tests for speed)
RUN mvn clean package -DskipTests

# Stage 2: Create the runtime image
# We use a slim JRE (Java Runtime Environment) image for the final container
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# Copy only the built JAR file from the build stage
# The wildcard *.jar ensures it picks up the generated artifact
COPY --from=build /app/target/*.jar app.jar

# Expose port 8080 (the default Spring Boot port)
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]