FROM openjdk:8-jdk-slim
COPY "./target/order-api-1.0.0.jar" "app.jar"
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]