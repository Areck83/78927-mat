#Areck83
#FROM ibmjava:jre
FROM ubuntu
RUN apt update
RUN apt install -y openjdk-8-jdk
RUN apt install -y mariadb-server
WORKDIR /app
ADD Saludos.jar /app/Saludos.jar
ADD script.sh /app/script.sh
ADD crearbd.sql /app/crearbd.sql
RUN chmod 755 /app/script.sh
RUN /etc/init.d/mariadb start; mariadb < /app/crearbd.sql
CMD [ "/app/script.sh" ]
EXPOSE 8080



