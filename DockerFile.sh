#!/usr/bin/env bash


#using ubuntu
FROM openjdk:8-jdk-alpine
COPY . /app
WORKDIR /app
RUN apk add --no-cache maven && mvn package
EXPOSE 8080
CMD ["java", "-jar", "target/mobilebilling-0.0.1-SNAPSHOT.jar"]



##using aws
#
#aws ecr get-login-password --region us-west-2 | docker login --username AWS --password-stdin 459208928199.dkr.ecr.us-west-2.amazonaws.com
#
#aws ecr create-repository \
#--repository-name test/mobilebilling \
#--image-scanning-configuration scanOnPush=false \
#--region us-west-2
#
#mvn clean package -DskipTests -Pdocker-image,no-scs,no-latest-tag -Ddocker.repo.project=mobilebilling
