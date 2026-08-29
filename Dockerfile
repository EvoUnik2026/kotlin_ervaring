FROM gradle:8.10-jdk21 AS build
WORKDIR /workspace

COPY . .
RUN gradle clean build --no-daemon \
    && APP_JAR="$(find build/libs -maxdepth 1 -type f -name '*.jar' ! -name '*plain*.jar' | head -n 1)" \
    && test -n "$APP_JAR" \
    && cp "$APP_JAR" /tmp/app.jar

FROM eclipse-temurin:21-jre
WORKDIR /app

COPY --from=build /tmp/app.jar /app/app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
