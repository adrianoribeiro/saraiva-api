# saraiva-api
API que coleta informações de livros da Saraiva e armazena localmente num banco MySQL.

### Tecnologias:
* Spring Boot (json/restful) 
* Spring data;
* Maven;
* MySQL;
* JUnit;
* Postman;

Requisições:
```
curl -X POST -F sku=9731891 http://localhost:8080/book/
curl http://localhost:8080/book/9731891
curl http://localhost:8080/book/
curl http://localhost:8080/book/?price=100
curl http://localhost:8080/book/?price=100&size=2
curl http://localhost:8080/book/?name=Origem
curl -X DELETE http://localhost:8080/book/9731891
```

Restrições:
Trata duplicidade;
Informa caso não existe;

### Sugestão para rodar
Criar o banco MySQL e editar o arquivo application.properties para apontar para seu banco:
```
  spring.datasource.url=jdbc:mysql://localhost:3306/db_saraiva
  spring.datasource.username=root
  spring.datasource.password=toor
```
Rodar o comando: 
```
mvn spring-boot:run
```
Service e Controlle: 100% de cobertura.
