# ---------- BUILD STAGE ----------
FROM maven:3.9.6-eclipse-temurin-17 as build
WORKDIR /app

# Copy entire project
COPY . .

# Build the app
RUN mvn -q -DskipTests clean package

# ---------- RUN STAGE ----------
FROM eclipse-temurin:17-jre
WORKDIR /app

# Copy jar from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose port
EXPOSE 8080

# Start the application
ENTRYPOINT ["java", "-jar", "app.jar"]
