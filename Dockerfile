FROM openjdk:8-jdk-alpine

EXPOSE 8080

WORKDIR /app

ADD build/libs/springbootRest-0.0.1-SNAPSHOT.jar springbootRest.jar

CMD ["java", "-jar", "springbootRest.jar" ]