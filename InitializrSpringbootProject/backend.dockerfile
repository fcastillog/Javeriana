FROM openjdk:19-jdk-alpine3.16
ARG BD_URL
ARG BD_PASSWORD
ARG BD_USER
ARG BD_NAME
ARG LOG_LEVEL=DEBUG
COPY "./target/reto-0.0.1.jar" "app.jar"
ENTRYPOINT ["java","-jar","app.jar"]