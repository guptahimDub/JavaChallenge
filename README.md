# JavaChallenge

### This repository consists of below 2 files:
- `JavaChallenge` - Consists of src folder and customer.txt file.
- `Readme` file - All the application details with instructions are included in this file.

## Web Application to display sorted list of customers with 100 km from Dublin Office
Food and Drink Invitation to the customers living within 100 km from Dublin Office.

## Supported Functionalities
- User can view the list of all the customers living within 100 km from the Dublin Office.
- The user can provide the distance value in the URL to filter out the customers.
  For example, to find the list of customer within 40 km, we can use URL as `http://localhost:8080/customers/40`

## Prerequisites
- [Java 8]
- [Lombok Java Library]
- [Tomcat 8.5] 

## Technologies Used

- Spring Boot
- Spring MVC Test framework and JUnits
- Lombok Java Library
- CSS and HTML
- JavaScript
- Maven

## Installation Steps
1. Clone the Git Repository.
2. `JavaChallenge` consists of src folder.
3. Build the project using Maven.

## Build Projects

1. Using below command

`mvn clean install` - under /JavaChallenge

2. Run below command to deploy the project on embedded Tomcat server

`mvn spring-boot:run` - under /JavaChallenge

## Usage
Once embedded server is started use below links to access the list of customers:

`http://localhost:8080/`  -- Home Page

`http://localhost:8080/customers/d` - Customers within in d kms , example: http://localhost:8080/customers/40 (for 40 km)


### Steps To Follow
1. Once the command is run - `mvn spring-boot:run`, below screen will be displayed:

![Picture1](https://user-images.githubusercontent.com/56262858/99890492-d5762a00-2c57-11eb-8158-ef818a14e1d0.PNG)


2. Click on the button to view the sorted list of cutsomers within 100 km.

![Picture2](https://user-images.githubusercontent.com/56262858/99890494-db6c0b00-2c57-11eb-889c-6faf9cd13186.PNG)


3. Sorted Customers within 40 km using `http://localhost:8080/customers/40`

![picture3](https://user-images.githubusercontent.com/56262858/99890497-e1fa8280-2c57-11eb-9993-28f7c1ee9fcf.PNG)
