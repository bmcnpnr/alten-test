FROM java:8-jdk-alpine

COPY ./target/service-discovery.jar /usr/app/

WORKDIR /usr/app

RUN sh -c 'touch service-discovery.jar'

ENTRYPOINT ["java","-jar","service-discovery.jar"]  
