#Building every service and creating docker images

cd ../../service-registration-server

./mvnw install dockerfile:build

cd ../api-gateway

./mvnw install dockerfile:build

cd ../user-vecihle-status-service

./mvnw install dockerfile:build

cd ../status-simulator

./mvnw install dockerfile:build

#Building the web app

cd ../status-simulator

docker build -t status-checker-webapp .

docker run -d service-discovery
docker run -d api-gateway
docker run -d status-simulator
docker run -d status-checker
docker run -d status-checker-webapp
