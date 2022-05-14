# saraiva-api
API that extracts book information from the Saraiva API and stores into a MySQL locally.

### Tech/Frameworks:
* Spring Boot (json/restful) 
* Spring data;
* Maven;
* MySQL;
* JUnit;
* Postman;

Request samples:
```
curl -X POST -F sku=9731891 http://localhost:8080/book/
curl http://localhost:8080/book/9731891
curl http://localhost:8080/book/
curl http://localhost:8080/book/?price=100
curl http://localhost:8080/book/?price=100&size=2
curl http://localhost:8080/book/?name=Origem
curl -X DELETE http://localhost:8080/book/9731891
```

### To run
#### Go to the application.properties and set your database settings:
```
  spring.datasource.url=jdbc:mysql://localhost:3306/db_saraiva
  spring.datasource.username=root
  spring.datasource.password=toor
```
### Run the command: 
```
$ mvn spring-boot:run
```
