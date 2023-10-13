FROM eclipse-temurin:17

LABEL mentainer="wpghks56@gmail.com"

WORKDIR /app

COPY build/libs/employee-service-0.0.1-SNAPSHOT.jar /app/employee-service.jar

ENTRYPOINT ["java", "-Dspring.profiles.active=docker", "-jar", "employee-service.jar"]