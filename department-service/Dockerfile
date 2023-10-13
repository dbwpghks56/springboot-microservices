FROM eclipse-temurin:17

LABEL mentainer="wpghks56@gmail.com"

WORKDIR /app

COPY build/libs/department-service-0.0.1-SNAPSHOT.jar /app/department-service.jar

ENTRYPOINT ["java", "-Dspring.profiles.active=docker", "-jar", "department-service.jar"]