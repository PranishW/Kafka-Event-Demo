FROM openjdk:22-jdk
ADD target/Order.jar Order.jar
ENTRYPOINT ["java","-jar","Order.jar"]