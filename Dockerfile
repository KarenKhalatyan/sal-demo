FROM adoptopenjdk/openjdk11:ubi
COPY csv/*.csv /csv/
ADD  target/sal-demo-0.0.1-SNAPSHOT.jar /app.jar
ENTRYPOINT ["java","-jar","/app.jar"]