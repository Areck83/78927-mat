#Areck83
FROM ubuntu
RUN apt update
RUN apt install -y openjdk-8-jdk
WORKDIR /app
ADD salones.jar /app/salones.jar
CMD ["java", "-jar", "salones.jar"]
EXPOSE 8080