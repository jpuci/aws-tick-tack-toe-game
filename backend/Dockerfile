FROM maven:3.9-amazoncorretto-21 as build
ENV HOME=/usr/app
RUN mkdir -p $HOME
WORKDIR $HOME
COPY /backend/app/pom.xml .
RUN mvn dependency:resolve-plugins dependency:resolve
ADD backend/app $HOME
RUN mvn install

FROM eclipse-temurin:17-jdk-alpine as backend
ENV HOME=/usr/app
COPY --from=build "${HOME}/target/*.jar" app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]