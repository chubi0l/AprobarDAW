FROM node:20.12.2 AS angular
WORKDIR /project
COPY frontend/package.json /project/
RUN npm install
COPY frontend/ /project/
RUN npm run build -- -- configuration=production

FROM nginx:1.26.0
COPY --from=angular /project/dist /usr/share/nginx/html

#  opcional:
EXPOSE 80