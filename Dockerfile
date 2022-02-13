FROM openjdk:11

EXPOSE 8080

RUN mkdir ./app

COPY ./TaskManager-1.0.jar ./app

CMD java -jar ./app/TaskManager-1.0.jar