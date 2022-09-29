# Spring Boot with PostgreSQL and Docker Compose

## put  .csv files in csv directory


## BUILD the application
mvn clean   
mvn install

## BUILD AND UP Docker Compose
docker-compose up --build   
docker-compose down 

## Swagger URL
http://localhost:8080/swagger-ui.html

## Load files into database
POST http://localhost:8080/load

## Get employees by month
GET http://localhost:8080/employees/{month}

## List all months with total salary
GET http://localhost:8080/employees/{month}

