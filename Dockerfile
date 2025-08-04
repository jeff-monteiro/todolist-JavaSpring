FROM ubuntu:latest AS builder

RUN apt-get update -y
RUN apt-get install openjdk17-jdk -y

COPY . .

RUN apt-get install maven -y
RUN mvn cean install

EXPOSE 8080

COPY --from=builder /target/todo-list-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]