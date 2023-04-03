FROM openjdk:18-jdk
ADD target/zoup-order.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]