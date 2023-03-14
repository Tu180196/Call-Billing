## Mobilebilling

## Introduction
This project requires Java version 17, Docker, and MySQL to be installed in order to run. The technologies used in this project include SpringBoot, Spring Data, Liquibase, Logging, Docker, AWS (to push Docker image to AWS), and Jenkins.

## Setup
To start with the project, you will first need to create a schema using the following command:

                  CREATE DATABASE `call_billing`
I have already created a default user named `tumg` which you can use.

# Dependencies

This project runs on port `8080` by default.

# Configuration

Service configuration can be found under `src/main/resources/application.yaml`.

# Running

To run the service in development mode, use the following command and select the active profile as local:

          `mvn spring-boot:run`

# To run the service from the built binaries, use the following command:

`java -jar target/mobilebilling-0.0.1-SNAPSHOT.jar`
````
### Push images to DOCKER HUB
pom.xml
````xml
<docker.repo.url>project</docker.repo.url>
````
jib build and push image <br/>
````
mvn jib:build -Pdocker-image,no-scs  -Djib.to.auth.username='smartoscbb'  -Djib.to.auth.password='*****' -Djib.from.image=openjdk:11.0.15-oracle

````

### Push images to AWS ECR
Configure AWS
````sh
AWS configure
AWS Access Key ID [****************C5UJ]:
AWS Secret Access Key [****************s5jf]:
Default region name [us-west-2]:
Default output format [json]:
````
pom.xml 
````xml
<docker.repo.url>459208928199.dkr.ecr.us-west-2.amazonaws.com</docker.repo.url>
````
Login, create repository, jib build and push image <br/>
````bash
aws ecr get-login-password --region us-west-2 | docker login --username AWS --password-stdin 459208928199.dkr.ecr.us-west-2.amazonaws.com

aws ecr create-repository \
--repository-name project/mobilebilling \
--image-scanning-configuration scanOnPush=false \
--region us-west-2

mvn clean package -Pdocker-image,no-scs,no-latest-tag

````
pull docker image
````sh
docker pull 459208928199.dkr.ecr.us-west-2.amazonaws.com/development/mobilebilling-0.0.1-SNAPSHOT
````


TEST DOCKER PUSH
````
#docker tag openjdk:11.0.15-oracle 459208928199.dkr.ecr.us-west-2.amazonaws.com/openjdk:11.0.15-oracle
#docker push 459208928199.dkr.ecr.us-west-2.amazonaws.com/openjdk:11.0.15-oracle

aws ecr create-repository \
--repository-name distroless/java \
--image-scanning-configuration scanOnPush=false \
--region us-west-2
docker pull gcr.io/distroless/java:11
docker tag gcr.io/distroless/java:11 459208928199.dkr.ecr.us-west-2.amazonaws.com/distroless/java:11
docker push 459208928199.dkr.ecr.us-west-2.amazonaws.com/distroless/java:11
````

