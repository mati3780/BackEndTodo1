# Aplicación demo Todo1

Aplicación hecha con Spring boot.
Para test se utiliza SpringBootTest, Junit y Mockito.


 POST: http://localhost:8080/api/v1/stocks/post
{ "product":{"id":5}, "description":"kardexOne", "quantity": 0 }

 PUT: http://localhost:8080/api/v1/stocks/55/addMovement
{ "stockDTO":{}, "type": 2, "quantity":2 }
