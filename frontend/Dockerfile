FROM node:18.13.0 AS build
WORKDIR /usr/src/app
COPY ./frontend/tick-tack-toe/package.json ./frontend/tick-tack-toe/package-lock.json ./
RUN npm install
COPY ./frontend/tick-tack-toe ./
RUN npm run build

FROM nginx:1.17.1-alpine

COPY frontend/nginx.conf /etc/nginx/nginx.conf
COPY --from=build /usr/src/app/dist/tick-tack-toe /usr/share/nginx/html
CMD ["/bin/sh",  "-c",  "envsubst < /usr/share/nginx/html/assets/env_tmp.js > /usr/share/nginx/html/assets/env.js && exec nginx -g 'daemon off;'"]
