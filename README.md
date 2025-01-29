# Agile Contents Java backend code challenge README

## Code challenge

The purpose of the test is to validate your technical and organizational skills. It’s not a big
deal if you can’t finish it, we prefer to have an incomplete clean and functional code than a 
badly organized and “ugly” code. It's OK if you set a maximum duration to the challenge.

You have to use the Java programming language and Spring Boot. Apart from that, it's up to you
how you structure the code and what libraries you use. You may also use any code generation tool
like https://start.spring.io[Spring Initializr] or https://www.jhipster.tech[JHypster].

Please create a fork of this repository, so you can use it as it suits you. The
only requirement is that all the code must be available in the master branch once you have
finished. You can also edit this document if you want to include any information, like build and
running instructions, that would be useful to us.

Take into account that, after you finish the code challenge, we will review it and then maybe we will ask
you to perform a code review together, just to learn a bit about the project and code structure.

IMPORTANT: We would be glad to answer any questions or hear any suggestions about the code
challenge, so don't hesitate to ask. 

### Features

The application to develop has to manage a collection of userDetails with the following information:

* Username (unique)
* Name
* Email
* Gender
* Picture (only URL value)

Users will be persisted to a database. You can use any database of your preference, relational or
not. Usage of a memory database or one integrated in the app itself is advised for simplicity.

The application will provide the following JSON web services:

* */api/userDetails/ (GET)*: return the list of all userDetails.
* */api/userDetails/{username}/ (GET)*: return a single userDetails.
* */api/userDetails/ (POST)*: create a userDetails.
* */api/userDetails/{username}/ (PUT)*: update the information of a single userDetails.
* */api/userDetails/{username}/ (DELETE)*: delete a single userDetails.
* */api/userDetails/generate/{number}/ (GET)*: generate a number, provided as a parameter, of random userDetails.
To create the userDetails you have to use the https://randomuser.me[Random User Generator] service. Users
will be added to the collection of existing userDetails.
* */api/userDetails/tree/ (GET)*: return a tree with the userDetails grouped by country, state and city (It can’t be done in database).

Extra optional features (only if you are done with the previous features):

* Unit tests (at least one class).
* Pagination of the userDetails list.
* API documentation using Swagger, Spring REST docs or any other tool.

Please, as an integral part of the challenge, update this document or add another one with the instructions required to build, run or test the project. As an example, if any external database is required, provide the required steps to prepare it beforehand, using docker or any other solution if possible, although using an integrated in memory database is preferred for simplicity.

-----------------------------------------------------------------
Below are the details of the implemented API.

* */api/userDetails/ (GET)*: return the list of all userDetails.
* */api/userDetails/{username}/ (GET)*: return a single userDetails.
* */api/userDetails/ (POST)*: create a userDetails.

* Swagger URL:-
* http://localhost:8080/swagger-ui/index.html#/user-controller/createUser

* Local-DB:-
* http://localhost:8080/h2-console/login.do?jsessionid=a5687ff1feafd2bed6d1d908465c1d2a

* API with Request Body:-
* http://localhost:8080/api/users

 {
 "username": "balirambhande",
 "name": "Baliram Bhande",
 "email": "balirambhande@ovm.com",
 "gender": "Male",
 "pictureUrl": "http://ovm.com/baliram.jpg"
 }

