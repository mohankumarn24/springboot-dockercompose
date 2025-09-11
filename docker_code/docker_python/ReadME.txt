Help: 
https://www.edureka.co/blog/docker-commands/
https://www.youtube.com/watch?v=uvTl6GefR9o
https://www.geeksforgeeks.org/how-to-run-a-python-script-using-docker/



1. Install docker
   # check docker version
   docker –version
 
2. Pull docker image from docker hub
   sudo docker pull python:latest

3. Create project folder in home directory; and create docker files: Dockerfile and getTime.py
   cd ~/project
   vi Dockerfile
   vi getTime.py

4. Build custom docker image 'python_gettime' using base image 'python:latest'
   # build image
   sudo docker build -t python_gettime .
   
   # list all docker images
   sudo docker images

   # run docker as a container
   sudo docker run -it python_gettime

   # list all running containers 
   sudo docker ps
   sudo docker ps -a
   
   # stop container with id 12345
   sudo docker stop 12345
   sudo docker kill 12345

   # start container with id 12345
   sudo docker start 12345

   # remove docker image 'python_gettime' by force
   sudo docker rmi python_gettime -f

   # clean up any resources — images, containers, volumes, and networks — that are dangling (not tagged or associated with a container)
   docker system prune

   # remove stopped container
   docker container rm [container_id]

5. Access running container
   docker exec -it <container id> bash



---------
Dockerfile
---------
FROM python:latest
# RUN apt update
WORKDIR /usr/app/src
COPY getTime.py ./
CMD ["python3", "./getTime.py"]

---------

---------
getTime.py
---------
import time

while True:
    print("Current Time:", time.strftime("%H:%M:%S", time.gmtime()))
    time.sleep(2)

----------
