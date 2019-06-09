FROM java:8-jdk-alpine

COPY ./status-checker.jar /usr/app/

WORKDIR /usr/app

RUN sh -c 'touch status-checker.jar'

ENTRYPOINT ["java","-jar","status-checker.jar"]
