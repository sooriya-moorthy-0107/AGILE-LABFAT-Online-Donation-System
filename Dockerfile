# Build Stage
FROM maven:3.9-eclipse-temurin-25 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
# Compile and package the application
RUN mvn clean package -DskipTests

# Run Stage
FROM eclipse-temurin:25-jre
WORKDIR /app
COPY --from=build /app/target/donation-system-1.0-SNAPSHOT.jar /app/donation.jar

# Run the processor
CMD ["java", "-jar", "donation.jar"]
