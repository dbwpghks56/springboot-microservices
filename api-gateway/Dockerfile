FROM eclipse-temurin:17

LABEL mentainer="wpghks56@gmail.com"

WORKDIR /app

COPY build/libs/api-gateway-0.0.1-SNAPSHOT.jar /app/api-gateway.jar

ENTRYPOINT ["java", "-Dspring.profiles.active=docker", "-jar", "api-gateway.jar"]