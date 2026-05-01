#Building Application
FROM maven:latest AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn clean package -DskipTests


#Running Application
FROM openjdk:22-jdk
WORKDIR /app
COPY --from=build /app/target/Order.jar Order.jar
ENTRYPOINT ["java","-jar","Order.jar"]