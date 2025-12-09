FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY .mvn/ .mvn
COPY mvnw pom.xml ./

RUN chmod +x mvnw

RUN ./mvnw dependency:go-offline -B

COPY src ./src

RUN ./mvnw package -DskipTests -B

CMD ["java", "-jar", "target/profile-0.0.1-SNAPSHOT.jar"]
