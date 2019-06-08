FROM java:8-jdk-alpine

COPY ./target/status-simulator.jar /usr/app/

WORKDIR /usr/app

RUN sh -c 'touch status-simulator.jar'

ENTRYPOINT ["java","-jar","status-simulator.jar"]
