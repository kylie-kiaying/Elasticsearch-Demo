# Elasticsearch Demo

This is a demo application that uses Spring Boot and Elasticsearch. The application allows you to perform CRUD operations on a `Person` entity.

## Prerequisites

- Docker
- Java 
- Maven

## Setup

### 1. Create a Docker Network

First, create a Docker network for Elasticsearch:

```bash
docker network create elastic
```


### 2. Pull the Elasticsearch Docker Image

Pull the Elasticsearch Docker image:

```bash
docker pull docker.elastic.co/elasticsearch/elasticsearch:8.14.1
```

### 3. Start Elasticsearch
Start the Elasticsearch container:

```bash
docker run --name es01 --net elastic -p 9200:9200 -it -m 1GB docker.elastic.co/elasticsearch/elasticsearch:8.14.1
```

Note: This will also print an elastic user password and an enrollment token for Kibana. Ensure to copy these values.

### 4. Verify Elasticsearch is Running
Verify that Elasticsearch is running:

```
curl --cacert http_ca.crt -u elastic:$ELASTIC_PASSWORD https://localhost:9200
```

### 5. Configure Application Properties
Create an application.properties file in the src/main/resources directory and add the following configurations:

```
spring.application.name=elasticsearch-demo
# Elasticsearch config
spring.elasticsearch.uris=http://localhost:9200
spring.elasticsearch.username=elastic
spring.elasticsearch.password=<your_elasticsearch_password>
```  

Replace <your_elasticsearch_password> with the password you copied when you started the Elasticsearch container.

Running the Application
Use Maven to build and run the application:

```bash
mvn clean install
mvn spring-boot:run
```
The application will start on port 8080.

API Endpoints
Create a Person
POST /api/person

Request Body:

```json
{
    "name": "John Doe",
    "age": 30
}
```

Get All Persons
GET /api/person

Get Person by ID
GET /api/person/{id}

Delete Person by ID
DELETE /api/person/{id}