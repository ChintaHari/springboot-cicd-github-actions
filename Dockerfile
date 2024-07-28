FROM openjdk:8
EXPOSE 8080
ADD target/springboot-github-actions-image.jar springboot-github-actions-image.jar
ENTRYPOINT ["java", "-jar", "springboot-github-actions-image.jar"]