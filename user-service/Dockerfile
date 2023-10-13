FROM eclipse-temurin:17

LABEL mentainer="wpghks56@gmail.com"

WORKDIR /app

COPY build/libs/user-service-0.0.1-SNAPSHOT.jar /app/user-service.jar

ENTRYPOINT ["java", "-Dspring.profiles.active=docker", "-jar", "user-service.jar"]