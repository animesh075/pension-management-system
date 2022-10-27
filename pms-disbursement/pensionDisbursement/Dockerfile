FROM openjdk:8-jdk-alpine
ADD target/pension-disbursement-microservice.jar pension-disbursement-microservice.jar
EXPOSE 8062
ENTRYPOINT ["java", "-jar","pension-disbursement-microservice.jar"]