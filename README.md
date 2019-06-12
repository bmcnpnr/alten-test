# User-Vehicle Status Checker
This project is a full-stack application. A single-page webapp is used to communicate with the back-end and display data.

In order to run this application you have some options:

Must:Install docker-compose. https://docs.docker.com/compose/install/ 

1.Running with building: go into build/docker_build/scripts and run "run.sh" script. This will build the whole application, create docker images and run your containers on your local machine. After everything is running, go to http://localhost:5000 to view the webapp.

2.Running without building: go into build/docker_pull/scripts and run "run.sh" script. This will pull the latest images from docker, create docker images and run your containers on your local machine. After everything is running, go to http://localhost:5000 to view the webapp.
