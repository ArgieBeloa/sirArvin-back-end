
# Use the official Maven image to build the project
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app

# Copy the project files
COPY . .

# Build the application
RUN mvn clean package -DskipTests

# Use the official OpenJDK image for the runtime environment
FROM openjdk:17-jdk-slim
WORKDIR /app

# Copy the built jar file
COPY --from=build /app/target/mary-0.0.1-SNAPSHOT.jar app.jar

# Expose the application port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]