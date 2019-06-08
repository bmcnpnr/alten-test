#Building every service and creating docker images

cd ../../service-registration-server

mvnw ./mvnw install dockerfile:build

cd ../api-gateway

mvnw ./mvnw install dockerfile:build

cd ../user-vecihle-status-service

mvnw ./mvnw install dockerfile:build

cd ../status-simulator

mvnw ./mvnw install dockerfile:build

#Building the web app

docker run service-discovery
docker run api-gateway
docker run status-simulator
docker run status-checker
