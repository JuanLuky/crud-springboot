# Comando Docker
### Construir a imagem usando o Dockerfile atualizado
`docker build -t springboot-app:1.0 .`
### Executar o contêiner mapeando a porta 8080
`docker run -d -p 8080:8080 crud-springboot:1.0`
### Listar contêineres em execução
`docker ps`
### Verificar logs do contêiner
`docker logs id-do-conteiner`
### Acessar o contêiner se necessário
`docker exec -it id-do-conteiner /bin/sh`