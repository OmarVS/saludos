FROM openjdk:16-slim-buster
COPY target/azure-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]