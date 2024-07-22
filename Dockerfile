# Build Step
FROM maven:3.9.7-eclipse-temurin-21-alpine AS build
WORKDIR /build
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Exceution Step
FROM eclipse-temurin:21
LABEL maintainer="Josias da Silva Junior <josiasdsj1@gmail.com>"
WORKDIR /app
COPY --from=build /build/target/agiletestrestfulapi-0.0.1-SNAPSHOT.jar /app/


CMD ["java", "-jar", "agiletestrestfulapi-0.0.1-SNAPSHOT.jar"]