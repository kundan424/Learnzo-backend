# Stage 1: Build the application with Maven
# We use a base image that has Java 17 and Maven installed
FROM maven:3.8.5-openjdk-17 AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the pom.xml file first to leverage Docker's layer caching
COPY pom.xml .

# Copy the rest of your source code
COPY src ./src

# Run the Maven package command to build the .jar file
RUN mvn clean package -DskipTests

# Stage 2: Create the final, lightweight image
# We use a slim Java image because we no longer need Maven
FROM openjdk:17-jdk-slim

WORKDIR /app

# Copy the compiled .jar file from the 'build' stage
COPY --from=build /app/target/*.jar app.jar

# Expose the port your application runs on
EXPOSE 8080

# This is the command that will run when the container starts
ENTRYPOINT ["java", "-jar", "app.jar"]