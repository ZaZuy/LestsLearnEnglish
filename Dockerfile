FROM maven:3.8.5-openjdk-8 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:8-jdk-slim
COPY --from=build /target/LetsLearnEnglish-1.0.war LetsLearnEnglish.war
EXPOSE 8081
ENTRYPOINT ["java","-jar","LetsLearnEnglish.war"]