# Etapa 1: Build da aplicação
FROM maven:3.8.6-openjdk-17 AS builder

# Defina o diretório de trabalho
WORKDIR /app

# Copie o arquivo pom.xml e baixe as dependências
COPY pom.xml .

# Baixar as dependências do projeto
RUN mvn dependency:go-offline

# Copie o código fonte do projeto
COPY src ./src

# Compile e empacote o projeto
RUN mvn clean package -DskipTests

# Etapa 2: Criar a imagem para execução
FROM openjdk:17-jdk-slim

# Defina o diretório de trabalho
WORKDIR /app

# Copie o JAR da etapa de build
COPY --from=builder /app/target/*.jar app.jar

# Exponha a porta da aplicação
EXPOSE 8080

# Execute o aplicativo
ENTRYPOINT ["java", "-jar", "app.jar"]

# docker build -t crud-springboot .
