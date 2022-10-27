FROM openjdk:8-jdk-alpine
ADD target/pensioner-detail-microservice.jar pensioner-detail-microservice.jar
EXPOSE 8061
ENTRYPOINT ["java", "-jar","pensioner-detail-microservice.jar"]