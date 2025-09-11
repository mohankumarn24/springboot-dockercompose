Help: 
https://www.edureka.co/blog/docker-commands/
https://www.youtube.com/watch?v=uvTl6GefR9o
https://www.geeksforgeeks.org/how-to-run-a-python-script-using-docker/



1. Install docker
   # check docker version
   docker –version
 
2. Pull docker image from docker hub
   sudo docker pull openjdk:11

3. Create project folder in home directory; and create docker files: Dockerfile and Main.java
   cd ~/project
   vi Dockerfile
   vi Main.java

4. Build custom docker image 'java_gettimee' using base image 'python:latest'
   # build image
   sudo docker build -t java_gettimee .
   
   # list all docker images
   sudo docker images

   # run docker as a container
   sudo docker run -it java_gettimee

   # list all running containers 
   sudo docker ps
   sudo docker ps -a
   
   # stop container with id 12345
   sudo docker stop 12345
   sudo docker kill 12345

   # start container with id 12345
   sudo docker start 12345

   # remove docker image 'java_gettimee' by force
   sudo docker rmi java_gettimee -f

   # clean up any resources — images, containers, volumes, and networks — that are dangling (not tagged or associated with a container)
   docker system prune

   # remove stopped container
   docker container rm [container_id]

5. Access running container
   docker exec -it <container id> bash



---------
Dockerfile
---------
FROM openjdk:11
COPY . /usr/src/myapp
WORKDIR /usr/src/myapp
RUN javac Main.java
CMD ["java", "Main"]

---------

---------
Main.java
---------
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

public class Main {

	public static void main(String[] args) {

		while (true) {
			// Current time with offset (e.g. +05:30)
			OffsetDateTime offsetDateTime = OffsetDateTime.now();
			System.out.println("OffsetDateTime	: " + offsetDateTime.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME));

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println(String.format("Exception occurred: ", e.getMessage()));
			}
		}
	}
}



----------
