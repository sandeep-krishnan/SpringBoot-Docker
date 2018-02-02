#Build

mvn install dockerfile:build

#Docker

Check if docker images were created

docker images

#Run

docker run -p 8080:8080 -t springio/user-service