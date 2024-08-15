FROM openjdk:21-jdk-alpine
WORKDIR /app
COPY target/twitter-analog.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
