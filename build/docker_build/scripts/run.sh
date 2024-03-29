#Building every service and creating docker images

cd ../../../service-registration-server

mvn clean install

cd ../api-gateway

mvn clean install

cd ../user-vehicle-status-service

mvn clean install

cd ../status-simulator

mvn clean install

# Enter docker-compose folder

cd ../build/docker_build/

# Deploy

docker-compose up --build -d
