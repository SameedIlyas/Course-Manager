# Use an official Maven image to build the project
FROM maven:3.8.4-openjdk-17 AS build

# Set the working directory in the container
WORKDIR /app

# Copy the pom.xml file and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy the source code and build the application
COPY src ./src
RUN mvn package -DskipTests

# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the built JAR file from the build stage
COPY --from=build /app/target/neo4j-spring-boot-0.0.1-SNAPSHOT.jar app.jar

# Copy the .env file to the working directory
COPY src/main/resources/.env .env

# Make port 8080 available to the world outside this container
EXPOSE 8080

# Run the application with environment variables from .env
ENTRYPOINT ["sh", "-c", "source .env && java -jar app.jar"]
