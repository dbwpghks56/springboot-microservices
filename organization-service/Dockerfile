FROM eclipse-temurin:17

LABEL mentainer="wpghks56@gmail.com"

WORKDIR /app

COPY build/libs/organization-service-0.0.1-SNAPSHOT.jar /app/organization-service.jar

ENTRYPOINT ["java", "-jar", "organization-service.jar"]