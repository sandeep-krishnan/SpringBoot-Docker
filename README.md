#Build

mvn install dockerfile:build


#Running without Docker
mvn spring-boot:run

#Docker
##Check if docker images were created

docker images

##Run the docker image

docker run -p 80:8080 -t microservices/user-service

#Checking the application

Try the following URLs :-

http://localhost:8080/health

http://localhost:8080/api/user

http://localhost:8080/api/user/1
