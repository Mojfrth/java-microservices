FROM maven:3.9.9-eclipse-temurin-21 AS builder

WORKDIR /app

COPY pom.xml .

RUN mvn dependency:go-offline -B

COPY src ./src

RUN mvn clean package

FROM eclipse-temurin:21-jdk AS runner

WORKDIR /app

COPY --from=builder ./app/target/auth-service-0.0.1-SNAPSHOT.jar ./app.jar

EXPOSE 4005

# Accept JWT_SECRET as build argument - must be provided at runtime via environment variable or system property
ARG JWT_SECRET

ENTRYPOINT ["sh", "-c", "java ${JWT_SECRET:+-Djwt.secret=$JWT_SECRET} -jar app.jar"]

