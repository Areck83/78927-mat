#Areck83
FROM ubuntu
RUN apt update
RUN apt install -y openjdk-8-jdk
WORKDIR /app
ADD EmergenciaAlert.jar /app/Emergencia.jar
CMD ["java", "-jar", "EmergenciaAlert.jar"]
EXPOSE 8080