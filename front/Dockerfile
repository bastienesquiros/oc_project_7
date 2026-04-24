# Stage 1: build Angular bundle
FROM node:18-alpine AS build
WORKDIR /src
COPY front/package*.json ./
RUN npm ci
COPY front/ .
RUN npm run build -- --configuration production

# Stage 2: serve with Caddy (official, minimal alpine image)
FROM caddy:2-alpine
COPY --from=build /src/dist/microcrm/browser /app/front
COPY misc/docker/Caddyfile /etc/caddy/Caddyfile
EXPOSE 80
EXPOSE 443
