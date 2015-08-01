# Lottery Web App

Description: Simple Web Application that allows people to register for a lottery. The Web Application contains the following functionalities:
* Registration form
* Stores the submitted and validated data in a PostgreSQL database
* Mechanism that automatically draws a winner every 60 seconds

Backend: Spring Boot, Java, PostgreSQL and Maven.

To run the Backend use "mvn spring-boot:run" and you need to have a PostgreSQL instance running with a postgres database or just edit the database configurations in the file "application.properties" file to your choosing. The Backend is running in the port 8090.

Frontend: Bootstrap, jQuery, Spring and Maven.

To run the Frontend use "mvn tomcat:run" and access the Web App with the url "localhost:8080/lottery-frontend".

Future improvements:
* Confirmation page after user registration. Right now every time a contender is registered for the lottery, it just shows a message saying it was successfully registered, so this could be improved with a confirmation page.
* Also the mechanism to automatically draw the winner right now is a poll javascript method in the Frontend with a setTImeout that will try to get a winner every 60 seconds, if there are any contenders registered. This shall be improved by defining a job/schedule task in the backend that would draw the winner, maybe persist it in the database for historic reasons and then communicate the winner to the Frontend.
* Improve the data validations of the registration form and tests.