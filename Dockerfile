FROM eclipse-temurin:21
LABEL maintainer="contato@java10x.dev"
WORKDIR /app
COPY target/NinjasRegister-0.0.1-SNAPSHOT.jar /app/ninjas-register.jar
ENTRYPOINT ["java", "-jar", "ninjas-register.jar"]