FROM openjdk:17
EXPOSE 5001
ADD target/employee-service.jar employee-service.jar
ENTRYPOINT ["java", "-jar", "/employee-service.jar"]