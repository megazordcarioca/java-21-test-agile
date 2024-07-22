<h1 align="center">
  Java, SpringBoot, OpenAPI, and Docker Technical Challenge
</h1>

<p align="center">
 <img src="https://img.shields.io/static/v1?label=Type&message=Challenge&color=8257E5&labelColor=931" alt="Challenge" />
</p>

An E-Commerce basic Restful API Java challenge implementing a basic CRUD for Technical Challenge for AgileEngine.  

## Technology Stack

- [Java 21](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring MVC](https://docs.spring.io/spring-framework/reference/web/webmvc.html)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [SpringDoc OpenAPI 3](https://springdoc.org/)
- [PostgreSQL](https://https://www.postgresql.org/)
- [Docker](https://www.docker.com/)
- [JUnit](https://junit.org/junit4/)
- [Mockito](https://site.mockito.org/)

## Good Practices Adopted

- SOLID, DRY, YAGNI, KISS
- API REST
- Requests with Spring Data JPA
- Dependency Injection
- Error Response Treatment
- Automatic Generation of Swagger with OpenAPI 3

## How to run

- Extract the project
- Enter on the project folder
- Rename the ```.env.sample``` file to ```.env``` the file are previously setter. However, you can change if necessary.
- Build with docker compose
```
$ docker-compose up --build
```

The API will be available in [localhost:8080](http://localhost:8080).

The Swagger can be accessed in [localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

## API Endpoints

To use the API Endpoint, you can use [Postman](https://www.postman.com/) or [Insonmia](https://insomnia.rest/download).
However, if you prefer to use Swagger, you can use too!


### Products Endpoints

#### Create Product

- Request
```
$ http POST :8080/api/products
{
  "id": 0,
  "name": "Xbox Series X",
  "description": "Xbox Series X Game Console",
  "price": 499.00
}
```

- Expected Response
```
{
  "id": 1,
  "name": "Xbox Series X",
  "description": "Xbox Series X Game Console",
  "price": 499.00
}
```

#### Get All Products
- 
- Request
```
 $ http GET :8080/api/products?page=0&size=10
```
- Expected Response
```  
  {
      "totalPages": 1,
      "totalElements": 1,
      "pageable": {
        "pageNumber": 0,
        "pageSize": 10,
        "sort": {
          "sorted": false,
          "empty": true,
          "unsorted": true
        },
        "offset": 0,
        "paged": true,
        "unpaged": false
      },
      "size": 10,
      "content": [
        {
          "id": 1,
          "name": "Xbox Series X",
          "description": "Xbox Series X Game Console",
          "price": 499
        }
      ],
      "number": 0,
      "sort": {
        "sorted": false,
        "empty": true,
        "unsorted": true
      },
      "first": true,
      "last": true,
      "numberOfElements": 1,
      "empty": false
      }

```

#### Get Product By Id

- Request

```
$ http GET :8080/api/products/1
```
- Expected Response
```
{
  "id": 1,
  "name": "Xbox Series X",
  "description": "Xbox Series X Game Console",
  "price": 499
}
```

#### Update Products

- Request
```
$ http PUT :8080/api/products/1
```

- Expected Response
```
{
  "id": 1,
  "name": "Xbox Series S",
  "description": "Xbox Series S Game Console",
  "price": 399.00
}
```

- Remove Product
```
http DELETE :8080/api/products/delete/1
```


### Orders Endpoints


#### Create Order

- Request

```
$ http POST :8080/api/orders

{
  "id": 0,
  "createdDate": "2024-07-22T08:17:31.325",
  "updatedDate": "2024-07-22T08:17:31.325",
  "orderStatus": "Created"
}

``` 


- Expected Response

```
{
  "id": 1,
  "createdDate": "2024-07-22T08:17:31.325",
  "updatedDate": "2024-07-22T08:17:31.325",
  "orderStatus": "Created"
}
```

#### Get All Orders

- Request
```
    $ http GET :8080/api/orders?page=0&size=10
```

- Expected Response

```
  {
      "totalPages": 1,
      "towtalElements": 1,
      "pageable": {
        "pageNumber": 0,
        "pageSize": 10,
        "sort": {
          "sorted": false,
          "empty": true,
          "unsorted": true
        },
        "offset": 0,
        "paged": true,
        "unpaged": false
      },
      "size": 10,
      "content": [
        {
          "id": 1,
          "orderDate": "2024-07-22T08:17:31.325",
          "updatedDate": "2024-07-22T08:17:31.325",
          "orderStatus": "Created"
        }
      ],
      "number": 0,
      "sort": {
        "sorted": false,
        "empty": true,
        "unsorted": true
      },
      "numberOfElements": 1,
      "first": true,
      "last": true,
      "empty": false
      }
      
```

#### Get Order By Id

- Request
```
$ http GET :8080/api/orders/1
```

- Expected Response
```
{
   "id": 1,
   "orderDate": "2024-07-22T08:17:31.325",
   "updatedDate": "2024-07-22T08:17:31.325",
   "orderStatus": "Created"
}
```


#### Update Order

- Request

```
$ http PUT :8080/api/orders/1

{
  "id": 0,
  "orderDate": "2024-07-22T08:17:31.325",
  "updatedDate": "2024-07-22T09:17:31.325",
  "orderStatus": "Canceled"
}
```

- Expected Response

```
{
  "id": 1,
  "orderDate": "2024-07-22T08:17:31.325",
  "updatedDate": "2024-07-22T09:17:31.325",
  "orderStatus": "Canceled"
}
``` 

- Remove Order
```

http DELETE :8080/api/orders/delete/1

```

### OrderItems Endpoints

#### Create OrderItem

- Request
```
$ http POST :8080/api/order-items

{
  "id": 0,
  "order": {
    "id": 1,
    "createdDate": "2024-07-22T09:41:04.724Z",
    "updatedDate": "2024-07-22T09:41:04.724Z",
    "orderStatus": "string"
  },
  "product": {
    "id": 1,
    "name": "string",
    "description": "string",
    "price": 0
  },
  "quantity": 1
}
```
- Expected Response
```
{
  "id": 0,
  "order": {
    "id": 1,
    "createdDate": "2024-07-22T09:41:04.724",
    "updatedDate": "2024-07-22T09:41:04.724",
    "orderStatus": "string"
  },
  "product": {
    "id": 1,
    "name": "string",
    "description": "string",
    "price": 0
  },
  "quantity": 1
}

```

#### Get All Orders

- Request
```
$ http GET :8080/api/order-items?page=0&size=10  
```

- Expected Response
``` 
{
  "totalPages": 1,
  "totalElements": 1,
  "pageable": {
    "pageNumber": 0,
    "pageSize": 10,
    "sort": {
      "sorted": false,
      "empty": true,
      "unsorted": true
    },
    "offset": 0,
    "paged": true,
    "unpaged": false
  },
  "size": 10,
  "content": [
    {
      "id": 1,
      "order": {
        "id": 1,
        "createdDate": "2024-07-22T09:40:30.793",
        "updatedDate": "2024-07-22T09:40:30.793",
        "orderStatus": "Created"
      },
      "product": {
        "id": 1,
        "name": "Xbox Series X",
        "description": "Xbox Series X Game Console",
        "price": 499,
        "totalCost": 499
      },
      "quantity": 1
    }
  ],
  "number": 0,
  "sort": {
    "sorted": false,
    "empty": true,
    "unsorted": true
  },
  "numberOfElements": 1,
  "first": true,
  "last": true,
  "empty": false
}

```

#### Get OrderItem By Id

- Request
```
$ http GET :8080/api/orders-items/1
``` 
- Expected Response
```
{
  "id": 1,
  "order": {
    "id": 1,
    "createdDate": "2024-07-22T09:40:30.793",
    "updatedDate": "2024-07-22T09:40:30.793",
    "orderStatus": "Created"
  },
  "product": {
    "id": 1,
    "name": "Xbox Series X",
    "description": "Xbox Series X Game Console",
    "price": 499,
    "totalCost": 499
  },
  "quantity": 1
}
```

#### Update OrderItem

- Request
```
$ http PUT :8080/api/order-items/1

Body:

{
  "id": 0,
  "order": {
    "id": 1,
    "createdDate": "2024-07-22T09:46:37.735Z",
    "updatedDate": "2024-07-22T09:46:37.735Z",
    "orderStatus": "string"
  },
  "product": {
    "id": 1,
    "name": "string",
    "description": "string",
    "price": 0
  },
  "quantity": 2
}
```
- Expected Response
```
{
  "id": 1,
  "order": {
    "id": 1,
    "createdDate": "2024-07-22T09:40:30.793",
    "updatedDate": "2024-07-22T09:40:30.793",
    "orderStatus": "Created"
  },
  "product": {
    "id": 1,
    "name": "Xbox Series X",
    "description": "Xbox Series X Game Console",
    "price": 499,
    "totalCost": 998
  },
  "quantity": 2
}
```

#### Remove OrderItem

```
http DELETE :8080/api/order-items/delete/1
```





