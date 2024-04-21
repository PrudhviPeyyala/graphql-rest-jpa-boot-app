# graphql-rest-jpa-boot-app
Sample application to Understand/Implement Graphql_Rest_JPA with springboot3 and java17

### MINIMUM Requirements

MAVEN 3+
Java 17+
Springboot 3+
DB - Mysql8
STS
MySQLWorkBench
POSTMAN for Testing API's



1.After clone this repo , import test-sb-app into your STS.
2.Run Maven Clean install
3.Make sure DB schema was created and tables were created in DB.(##3.1Refer DB tables below , ##3.2) 
4.Run application as springboot & refer Gql & Rest Requests : (##4.1 ,##4.2)


###3.1 DATABASE QUERIES (In My Case I Used MySQL) ###

Create Database schema with name dblearning and create following tables;

Student Table :
---------------


CREATE TABLE `student` (
  `id` int NOT NULL,
  `name` varchar(20) NOT NULL,
  `age` int NOT NULL,
  `address` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

Employee Table : 
----------------

CREATE TABLE `employee` (
  `id` int NOT NULL,
  `emp_First_name` varchar(255) NOT NULL,
  `emp_last_name` varchar(255) NOT NULL,
  `address` varchar(255) DEFAULT 'HYD',
  `contact_number` int NOT NULL,
  `age` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `contact_number` (`contact_number`),
  CONSTRAINT `employee_chk_1` CHECK ((`age` < 59))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci


Address Table:
--------------

CREATE TABLE `address` (
  `city_id` int NOT NULL,
  `street_name` varchar(255) NOT NULL,
  `state_name` varchar(255) NOT NULL,
  `pincode` int DEFAULT NULL,
  `employee_id` int DEFAULT NULL,
  PRIMARY KEY (`city_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

####3.2 After Creating tables insert some dummy data into tables using insert query

####4.1 Graphql Loading

Open this URL in browser : http://localhost:9091/graphiql?path=/graphql

RUN Graphql Queries below:

query findAllStudents {
  findAllStudents {
    id
    age
    address
    name
  }
}

query findById($id: Int) {
  findById(id: $id) {
    address
    age
    id
    name
  }
}

mutation updateStudentAddress($student:StudentInput){
  updateStudentAddress(student:$student) {
    responseMessage
    responseStatusCode
  }
}


query findAllEmployees {
  findAllEmployees {
    age
    contact_number
    emp_First_name
    emp_last_name
    id
    address {
      city_id
      state_name
      street_name
      pincode
    }
  }
}


##4.2 REST API Requests

Open POSTMAN for Rest API testing

GET API call:  http://localhost:9091/myapp/student

POST API call: http://localhost:9091/myapp/student

RequestBody for POST API: 

    {
        "id": 1,
        "name": "Test",
        "age": 28,
        "address": "test"
    }





