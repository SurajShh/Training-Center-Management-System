# Training Center Management System

This is a Spring Boot-based REST API for managing training centers. The system allows users to register, update, delete, and retrieve training centers. It includes validation to prevent duplicate email entries.

## Prerequisites

Before running the project, ensure you have the following installed:

Java 17+ (JDK 17 or later)

Maven (For dependency management)

MySQL (Database for storing training center data)

Postman or cURL (For API testing, optional)

## Installation and Setup

1. Clone the Repository

git clone https://github.com/your-repository-url.git
cd training-center-management

2. Configure the Database

Create a new MySQL database:

CREATE DATABASE trainingcenterdb;

Update the database configuration in src/main/resources/application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/trainingcenterdb
spring.datasource.username=root  # Change as per your DB user
spring.datasource.password=root  # Change as per your DB password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

3. Build and Run the Project

Run the following command to build and start the application:

mvn spring-boot:run

Or, package the application as a JAR and run it:

mvn clean package
java -jar target/training-center-management-0.0.1-SNAPSHOT.jar

## API Endpoints

1. Register a Training Center

POST /training-centers/register

{
    "centerName": "ABC Training Institute",
    "centerCode": "AMN123456789",
    "address": {
        "detailedAddress": "4th Main, BTM Layout",
        "city": "Bangalore",
        "state": "Karnataka",
        "pincode": "560011"
    },
    "contactEmail": "contacts@abc.com",
    "coursesOffered": ["C", "JavaScript", "AWS"],
    "contactPhone": "7896789006"
}


2. Get All Training Centers

GET /training-centers/all

3. Get Training Center by ID

GET /training-centers/{id}

4. Delete Training Center

DELETE /training-centers/delete/{id}