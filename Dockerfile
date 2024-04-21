# Usamos una imagen base de Maven para compilar la aplicación
FROM maven:3.8.1-openjdk-17-slim AS build

# Copiamos el pom.xml y descargamos las dependencias para aprovechar la capa de caché de Docker
COPY pom.xml /usr/src/app/
RUN mvn -f /usr/src/app/pom.xml dependency:go-offline

# Copiamos el código fuente y compilamos la aplicación
COPY src /usr/src/app/src
RUN mvn -f /usr/src/app/pom.xml clean package

# Usamos una imagen base de Java para ejecutar la aplicación
FROM openjdk:17-jre-slim

# Copiamos el jar compilado a la imagen
COPY --from=build /usr/src/app/target/*.jar /usr/app/app.jar

# Exponemos el puerto 8080
EXPOSE 8080

# Ejecutamos la aplicación
ENTRYPOINT ["java","-jar","/usr/app/app.jar"]


