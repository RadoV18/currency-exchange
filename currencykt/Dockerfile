#FROM eclipse-temurin:17
#COPY target/*.jar /app.jar
#
#ENV DB_USERNAME="postgres"
#ENV DB_PASSWORD="mysecretpassword"
#ENV DB_URL="jdbc:postgresql://localhost:5433/software"
#ENV API_KEY=""
#ENV PORT=8080
#
#RUN mkdir /logs
#
#ENTRYPOINT ["java","-jar","/app.jar"]


# FROM eclipse-temurin:17 as build
# WORKDIR /workspace/app

# COPY mvnw .
# COPY .mvn .mvn
# COPY pom.xml .
# COPY src src

# RUN ./mvnw install -DskipTests
# RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)


 FROM eclipse-temurin:17

 VOLUME C:/logs/tmp

 ARG DEPENDENCY=target/dependency

 COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
 COPY ${DEPENDENCY}/META-INF /app/META-INF
 COPY ${DEPENDENCY}/BOOT-INF/classes /app

 ENV DB_USERNAME="postgres"
 ENV DB_PASSWORD="mysecretpassword"
 ENV DB_URL="jdbc:postgresql://localhost:5433/software"
 ENV API_KEY=""
 ENV PORT=8080

 ENTRYPOINT ["java","-cp","app:app/lib/*","ucb.arqsoft.currencykt.CurrencyktApplicationKt"]
