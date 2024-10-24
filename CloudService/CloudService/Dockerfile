# Stage 1: Build the application
FROM gradle:jdk11 AS build
WORKDIR /app
COPY . .
# Kopiere den gesamten Inhalt des aktuellen Verzeichnisses
RUN gradle build
    #Baue die Anwendung

# Stage 2: Run the application
FROM openjdk:11-jre-slim
COPY --from=build /app/build/libs/*.jar /app/app.jar
# Kopiere die JAR-Datei
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
# Führe die JAR-Datei aus
