## Laboratory Work 0
### Prototyping

* In this laboratory work I created an OAuth service using java REST services.
* It has 3 type of url:
* http://127.0.0.1:8080/rest-ipp_1.0/rest/register?in='{"app_id":"0","email":"mail@mail.com","pass":"qwerty","name_surname":"username"}'
* http://127.0.0.1:8080/rest-ipp_1.0/rest/login?in='{"email":"mail@mail.com","pass":"qwerty"}'
* http://127.0.0.1:8080/rest-ipp_1.0/rest/get_last_login?in='{"token":"sasdsadasdasd"}'



#### How to run the application
- -Install mongo db
- -Create a database _ipp
- -Install glassfish server
- -Run project


######Technical issue
There is no such field as role which will grant users different permissions such as simple user or admin.

######How to improve
* Add user role field in the scheme for granting different access
* Add user role field when user is registering

######Technical issue
Register and Login should be POST methods and not GET because it is not secure to send params through address line

######How to improve
* Change methods signature from GET to POST

######Technical issue
Aplication id field should be a hash and not an integer because integer is finite and also because it is not secure

######How to improve
* Change appId field to UUID


####Conclusion: 
During this laboratory work I learned about NoSQL - mongodb and I worked with rest servicess and used glassfish server.
So it was a good experience for me. Also I learned about the importance of the prototyping and how is it important to do it before creating the project. 

