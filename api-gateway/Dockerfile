# Usa uma imagem oficial do Java 17 para rodar o projeto
FROM openjdk:17-jdk-slim

# Define a pasta dentro do container onde o projeto vai ficar
WORKDIR /app

# Copia o arquivo gerado pelo Maven para dentro do container
COPY target/*.jar app.jar

# Comando que liga o seu API Gateway
ENTRYPOINT ["java", "-jar", "app.jar"]