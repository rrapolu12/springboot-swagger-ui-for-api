# cardano-sports-api-rest

# Related components
Works with Spring Boot Admin app spring-boot-admin-server

This is Spring Boot Data and Web(REST API) with JPA and Hibernate(Implementation of JPA)
Pre-Requisites:

Install Intellij - IDEA from jetbrains.com
Open the project as maven. Click "open" from File and target the directory where pom.xml exists, and IDE will do configure the rest.
As of now, i have used an H2 Embeded Database and later change the properties(application.properties in src/java/main/resources) to MySQL.

How to Run.

The Databases are created by Hibernate when you start the application.
to Run, Right Click on "CardanoSportsApplication" and Select "Run" or "Debug", if you want to run n Debug Mode.

to start with

Started with Country, Language and Timezone

Create a Model Class with all Mappings againsta the variables, so hibernate can create on the startup all the models.
sample data available in data.sql
Sample Mock Test for Country available in src/test



Further, we will implement, each model and write tests.

Database Console access : http://localhost:8080/h2
Testing API URL : http://localhost:8080/swagger-ui/index.html

username : sa
password : 

Note : All of us can pick this up and write it