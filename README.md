Home Finder is a web based application for finding roommates and houses. User can set their preferences. Examples of preferences are maximum number of roommates, pets, rent contribution.The application creates groups based on matching set of preferences. The user has an option to see the details of the members in the group. 

The Home Finder Application  uses the following dependencies:

Spring Boot Starter: Provides a set of default configurations for the application.
Spring Boot Starter Test: Enables testing support for the  application.
Spring Boot Starter Web: Provides web-related support for the application.
MySQL Connector/J: Provides the JDBC driver for connecting to MySQL database.
Spring Boot DevTools: Enables developer tools for Spring Boot application.
Spring Security Test: Provides testing support for Spring Security application.
Spring Boot Starter Security: Provides security support, including authentication, authorization, and encryption.
Spring Boot Starter Data JPA: Provides Java Persistence API support, including entity mapping, repositories, and transaction management for the application.
jjwt-api: Provides the API for JSON Web Tokens (JWTs), including token generation, token parsing, and signature verification.
jjwt-impl: Provides the implementation of JSON Web Tokens (JWTs), including token serialization, token deserialization, and token validation.
jjwt-jackson: Provides the Jackson JSON processor for JSON Web Tokens (JWTs), including serialization and deserialization of JWTs.
Lombok: Provides annotations that generate boilerplate code, including getters and setters, equals and hashCode methods, and toString methods. This reduces boilerplate code and makes the code more concise.


Build documentation:
The code for this application is divided into Backend and Frontend.
The main class for backend code is present in FindMyHomeApplication class. The location of this class is group17/src/main/java/com/project.group17. This class can be run from an IDE to start the application.
In order to run the Frontend, the following commands need to be run in the terminal.
`npm install` : This command reads the dependencies listed in the package.json file , then downloads and installs them in the node_modules folder in the project directory, this ensure that all the required dependencies are available for the project.
`npm start`  : This command starts the application. 

User Scenarios:
A college student who is moving to a new country would want to use the home finder application to search for affordable apartments or roommates near their university. They can open the application and enter property or roommate preferences, such as the number of roommates,pets, rent contribution.
The application presents them with a list of available housing options, and they are able to view photos and read details. If they find a property that they are interested in, they are able to like it. 




