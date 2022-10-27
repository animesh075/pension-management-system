FROM openjdk:8-jdk-alpine
ADD target/pension-portal-microservice.jar pension-portal-microservice.jar
EXPOSE 8070
ENTRYPOINT ["java", "-jar","pension-portal-microservice.jar"]