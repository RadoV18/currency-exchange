FROM eclipse-temurin:17
COPY target/*.jar /app.jar

ENV DB_USERNAME="postgres"
ENV DB_PASSWORD="mysecretpassword"
ENV DB_URL="jdbc:postgresql://localhost:5433/software"
ENV API_KEY=""
ENV PORT=8080

RUN mkdir /logs

ENTRYPOINT ["java","-jar","/app.jar"]
