FROM maven:3.9-eclipse-temurin-17 AS build
LABEL authors="teatatoiu"

WORKDIR /FamBase
COPY pom.xml .
RUN mvn dependency:go-offline -B

COPY src ./src
RUN mvn package -DskipTests

FROM eclipse-temurin:17-jre

WORKDIR /FamBase
COPY --from=build /FamBase/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]