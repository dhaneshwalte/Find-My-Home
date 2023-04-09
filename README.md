
# FindMyHome Application

FindMyHome is a web based application for finding roommates and houses based on preferences set by the users. Preferences like  maximum number of roommates, pets policy, rent contribution, dietary habits etc. Users are suggested with people who are similar to their preferences in an order with highest matches at the top. Once two users like each other they are fromed into a group and the users will be unable to like any other users. Users can join existing groups which are suggested to the users based on their prefereneces. The user has an option to see the details of the members in the group and if the user like the group then the user is added to the group once any of the group member approve. Users can post lisitings and view all the listings. Users can form a group to apply for the listings or an user can apply for the listings individually. 



## Technologies Used

**Front end:** React, Java Script

**Back end:** Spring Boot using Maven Wrapper, Java, Mysql

## Getting Started


### Prerequisites

For the front end we have used reactjs which requeries nodejs and npm.

**Check for if the npm and nodejs are installed**
```bash
npm -v
node -v
```

To install [npm & nodejs](https://docs.npmjs.com/downloading-and-installing-node-js-and-npm).


For the back end we have developed using java version 17 & maven(any version after 3.8 ) wrapper based spring boot application

**Check for if java and maven are installed**
```bash
java -version
mvn -v
```

For installing [java & maven on windows](https://developers.arcgis.com/enterprise-sdk/guide/java/install-java-and-maven/), for [mac](https://www.digitalocean.com/community/tutorials/install-maven-mac-os).

For storing the data we have used MySQL(Any version after 8.0.26).

```bash
  mysql -version
```

For installing [MySQL on windows](https://www.javatpoint.com/how-to-install-mysql), for [mac](https://www.geeksforgeeks.org/how-to-install-mysql-on-macos/).

## Installation

The steps to install the application and run it.

Clone the repository:

```bash
git clone https://git.cs.dal.ca/courses/2023-winter/csci-5308/group17/
```
Install the necessary dependencies:

For the frontend (React JS), navigate to the frontend directory:
```bash
cd group17/Frontend/react-group17/
```
and run:
```bash
npm install
```

For the backend, navigate to the backend directory:
```bah
cd group17/Backend/group17/
```
and run:
```bash
mvn clean install
```
Configure the database:

Create a MySQL database and user with appropriate permissions.
In the application.properties file (located in group17/Backend/group17/src/main/resources), update the database configuration to match your MySQL database:
```bash
spring.datasource.url=jdbc:mysql://localhost:3306/<database-name>?useSSL=false&serverTimezone=UTC
spring.datasource.username=<database-username>
spring.datasource.password=<database-password>
```
Start the application:

For the frontend (React JS), navigate to the frontend directory
```bash
cd group17/Frontend/react-group17/
```
and run:
```bash
npm start
```
For the backend (Spring Boot), navigate to the backend directory:
```bash
cd group17/Backend/group17/
```
and run:
```bash
mvn clean install
```

This will create a jar file inside the target folder, move to the target folder:
```bash
cd group17/Backend/group17/target/
```
and run the jar file:
```bash
java -jar group17-0.0.1-SNAPSHOT.jar.original
```
else run the commend in backend directory which will start the application directly:
```bash
mvn spring-boot:run
```

Access the application in your local:

The frontend will be available at http://localhost:3000.

The backend API will be available at http://localhost:8080.
## Demo
**User Scenarios:**
A college student who is moving to a new country would want to use the home finder application to search for affordable apartments or roommates near their university. They can open the application and enter property or roommate preferences, such as the number of roommates,pets, rent contribution. The application presents them with a list of available housing options, and they are able to view photos and read details. If they find a property that they are interested in, they are able to like it. 

Login Page:
![alt text](https://git.cs.dal.ca/courses/2023-winter/csci-5308/group17/-/raw/dev/Images/LoginPage.png)

Register
![alt text]()

Preferences
![alt text]()

All Listings
![alt text](https://git.cs.dal.ca/courses/2023-winter/csci-5308/group17/-/raw/dev/Images/AllListings.png)

Profilepage
![alt text]()

Groups
![alt text]()

Create Listings
![alt text]()

Signout
![alt text](https://git.cs.dal.ca/courses/2023-winter/csci-5308/group17/-/raw/dev/Images/LoginPage.png)

## Authors

- Dhanesh Walte - B00000000 - @dal.ca

- Maulik Gajipara - B00000000 - @dal.ca

- Muskan Vazirani - B00000000 - @dal.ca

- Naveen Kunapaneni - B00000000 - nv676973@dal.ca

- Sreya Gajjipara - B00000000 - @dal.ca






