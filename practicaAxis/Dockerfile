# Issac Glez 12-03-2023
# Obtener primero la base del sistema operativo a ejecutarse
FROM ubuntu

# Actualizar e instalar el jdk8, curl y unzip
RUN apt-get update && apt-get install -y \
openjdk-8-jdk \
curl \
unzip
#git

#Obtener con curl el axis de la version 8
RUN curl -G https://dlcdn.apache.org/axis/axis2/java/core/1.8.0/axis2-1.8.0-bin.zip -o /opt/axis2.zip

#Desempaquetar el archivo descargado en el paso anterior dentro de la carpeta opt
RUN unzip /opt/axis2.zip -d /opt

#Obtener la calculadora.class (o que, la saca magicamente?)
#RUN git clone https://github.com/tareasR/78927.git

#Configurar variables de entorno con axis y java
ENV AXIS2_HOME=/opt/axis2-1.8.0
ENV PATH=$PATH:$AXIS2_HOME/bin
ENV JAVA_HOME=/usr/lib/jvm/java-1.8.0-openjdk-amd64

WORKDIR /ws

COPY calculadora.java .
COPY calculadora.class .
COPY services.xml META-INF/

#Proceder a hacer la transformacion transexual de java
RUN java2wsdl.sh -cn calculadora
RUN jar cvf calculadora.aar calculadora.* META-INF
COPY calculadora.aar /opt/axis-version/repository/services

EXPOSE 8080

CMD axis2server.sh





