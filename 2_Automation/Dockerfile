# Installation of build package and copy data to a dirctory

# Package stage
FROM openjdk:17-jdk-alpine

COPY target/*.jar ./app/runner.jar

ENTRYPOINT ["java","-jar","/app/runner.jar"]
