FROM openjdk:8
ADD target/phone-categorization.jar phone-categorization.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","phone-categorization.jar"]
