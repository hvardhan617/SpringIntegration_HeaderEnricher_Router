FROM java:8
ADD target/spring-integration-http-adapters.jar spring-integration-http-adapters.jar
EXPOSE 8999
ENTRYPOINT ["java","-jar","spring-integration-http-adapters.jar"]