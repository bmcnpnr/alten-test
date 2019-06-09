#Building every service and creating docker images

cd ../../../service-registration-server

mvn clean install

echo "Starting to deploy ---"

cd ../api-gateway

mvn clean install

cd ../user-vecihle-status-service

mvn clean install

cd ../status-simulator

mvn clean install

# Enter docker-compose folder

cd ../build/docker/

# Deploy

docker-compose up --build -d