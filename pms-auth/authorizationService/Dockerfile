FROM openjdk:8-jdk-alpine
ADD target/pension-auth.jar pension-auth.jar
EXPOSE 8060
ENTRYPOINT ["java", "-jar","pension-auth.jar"]