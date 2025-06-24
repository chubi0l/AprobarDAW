FROM node:14.0.0 as frontend
WORKDIR /project 
COPY frontend .
RUN npm install
RUN npm build -- -- configuration production


FROM maven:3.6.0 as backend
WORKDIR /project
COPY backend/pom.xml /project/ 
RUN mvn clean install
COPY /backend/src /project/src
COPY --from=frontend /project/dist/frontend/browser/ /project/src/main/resources/static/alumnos
RUN mvn package -o--DskipTests=true

FROM openjdk-jre:11.0.0
WORKDIR /usr/src/app
COPY --from=backend /project/target/backend.jar /usr/src/app/
EXPOSE 8080
 