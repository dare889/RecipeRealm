# Use the official maven/Java 8 image to create a build artifact.
FROM maven:3.8.1-jdk-11 as builder

# Set the working directory in builder
WORKDIR /app

# Copy the pom.xml file to download dependencies
COPY ./pom.xml ./pom.xml

# Download the dependency
RUN mvn dependency:go-offline -B

# Copy the src code to the container
COPY ./src ./src

# Build the application
RUN mvn clean package -DskipTests

# Use the official openjdk image as a parent image
FROM openjdk:11-jre-slim

# Set the working directory in the image
WORKDIR /app

# Copy the jar file from builder to the current location
COPY --from=builder /app/target/*.jar app.jar

# Expose port
EXPOSE 8080

# Run the jar file 
ENTRYPOINT ["java","-jar","/app/app.jar"]
