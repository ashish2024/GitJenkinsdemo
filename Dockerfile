# Use the official OpenJDK base image to run the JAR file
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from your host to the container
COPY blogservice.jar /app/blogservice.jar

# Expose the port that your application will run on (1010 in your case)
EXPOSE 1010

# Command to run the application
ENTRYPOINT ["java", "-jar", "blogservice.jar"]
