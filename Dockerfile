FROM openjdk:17-jdk-slim
EXPOSE 9000
ADD target\Student-0.0.1-SNAPSHOT.jar student.jar
ENTRYPOINT ["java", "-jar", "/student.jar"]