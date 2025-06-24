FROM node:14.0.0 AS frontend 
WORKDIR /project
COPY frontend .
RUN npm install
RUN npm build -- --configuration production

FROM maven:3.6.0 AS backend
WORKDIR /project
COPY /backend/pom.xml /project/
COPY --from=frontend /project/dist/frontend/browser/ /project/src/main/resources/static
RUN mvn package -o--DskipTests=true

FROM openjdk-jre:11.0.0
WORKDIR /usr/src/app
COPY --from=backend/project/target/*.jar / usr/src/app/
EXPOSE 8080
CMD [ "java", "-jar", "backend.jar"]