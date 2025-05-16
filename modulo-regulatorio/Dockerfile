#FROM maven:3.6.0-jdk-11-slim AS build
#COPY src /home/ms-digitalizacion/src
#COPY pom.xml /home/ms-digitalizacion
#RUN mvn -f /home/ms-digitalizacion/pom.xml clean package

FROM openjdk:17-jdk-slim

RUN set -eux; \
    apt-get update; \
    apt-get install -y --no-install-recommends \
    \
    # java.lang.UnsatisfiedLinkError: /usr/local/openjdk-11/lib/libfontmanager.so: libfreetype.so.6: cannot open shared object file: No such file or directory
    # java.lang.NoClassDefFoundError: Could not initialize class sun.awt.X11FontManager
    # https://github.com/docker-library/openjdk/pull/235#issuecomment-424466077
    fontconfig libfreetype6 \
    iputils-ping \
    netcat \
    wget \
    tcpdump \
    net-tools \
    telnet \
    vim \
    ntp \
    ; \
    rm -rf /var/lib/apt/lists/*

# additional fonts
RUN echo "deb http://httpredir.debian.org/debian buster main contrib non-free" > /etc/apt/sources.list \
    && echo "deb http://httpredir.debian.org/debian buster-updates main contrib non-free" >> /etc/apt/sources.list \
    && echo "deb http://security.debian.org/ buster/updates main contrib non-free" >> /etc/apt/sources.list \
    && echo "ttf-mscorefonts-installer msttcorefonts/accepted-mscorefonts-eula select true" | debconf-set-selections \
    && apt-get update \
    && apt-get install -y \
        fonts-arphic-ukai \
        fonts-arphic-uming \
        fonts-ipafont-mincho \
        fonts-ipafont-gothic \
        fonts-unfonts-core \
        ttf-wqy-zenhei \
        ttf-mscorefonts-installer \
    && apt-get clean \
    && apt-get autoremove -y \
    && rm -rf /var/lib/apt/lists/*
    
# Define la zona horaria como variable de entorno
ENV TZ=America/Mexico_City

# Instala las actualizaciones del sistema y el paquete necesario para configurar la zona horaria
RUN apt-get update && \
    DEBIAN_FRONTEND=noninteractive apt-get install -y tzdata && \
    apt-get clean

# Configura la zona horaria
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

WORKDIR /app

COPY target/modulo-regulatorio-0.0.1-SNAPSHOT.jar /app

ENTRYPOINT ["java", "-jar", "modulo-regulatorio-0.0.1-SNAPSHOT.jar"]