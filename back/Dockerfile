# Stage 1: build the JAR
FROM gradle:8.7-jdk17-alpine AS build
WORKDIR /src
COPY . .
RUN ./gradlew build -x test --no-daemon

# Stage 2: minimal runtime image
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=build /src/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
