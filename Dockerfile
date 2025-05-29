# Imagen base con Java
FROM openjdk:17-jdk-slim

# Directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiamos el archivo jar al contenedor
COPY elReyDelPollo-0.0.1-SNAPSHOT.jar app.jar

# Exponemos el puerto que usa Spring Boot (por defecto es el 8080)
EXPOSE 8080

# Comando para ejecutar el JAR
ENTRYPOINT ["java", "-jar", "app.jar"]