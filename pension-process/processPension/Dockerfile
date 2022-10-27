FROM openjdk:8-jdk-alpine
ADD target/process-pension-microservice.jar process-pension-microservice.jar
EXPOSE 8063
ENTRYPOINT ["java", "-jar","process-pension-microservice.jar"]