# Usar una imagen base de Maven con JDK 11 para construir la aplicación
FROM maven:3.8.1-openjdk-11-slim AS build

# Copiar el pom.xml y descargar las dependencias para aprovechar la capa de caché de Docker
COPY pom.xml /usr/src/app/
RUN mvn -f /usr/src/app/pom.xml dependency:go-offline

# Copiar el código fuente y construir la aplicación
COPY src /usr/src/app/src
RUN mvn -f /usr/src/app/pom.xml clean package

# Usar una imagen base de OpenJDK 11 para ejecutar la aplicación
FROM openjdk:11-jre-slim

# Copiar el JAR construido en la etapa de construcción
COPY --from=build /usr/src/app/target/*.jar /usr/app/app.jar

# Exponer el puerto 8080 para que la aplicación sea accesible
EXPOSE 8080

# Ejecutar la aplicación
ENTRYPOINT ["java","-jar","/usr/app/app.jar"]