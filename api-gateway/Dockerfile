FROM java:8-jdk-alpine

COPY ./api-gateway.jar /usr/app/

WORKDIR /usr/app

RUN sh -c 'touch api-gateway.jar'

ENTRYPOINT ["java","-jar","api-gateway.jar"]

EXPOSE 8762
