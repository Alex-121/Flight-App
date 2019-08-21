# Flight-App
Final Project CIS 3270

<b>BASIC OVERVIEW</b>

Java based application that simulates booking a flight. GUI developed using Scene Builder and JavaFX. This application has connectivity to local database through MySQL. The objective of the assignment was to test knowledge of OOP concepts, exception handling and GUI implementation. The project should have a splash screen, login, main page and special authorizations for admin users.

## Login
![Login](https://user-images.githubusercontent.com/47226703/63475557-576f1600-c44b-11e9-848a-98ee75de1202.PNG) 
#### Requirements
Have user information be validated via database. If username or password results in an error handle and let user know what exactly the issue is.

## Signup
![signup](https://user-images.githubusercontent.com/47226703/63475570-648c0500-c44b-11e9-9a41-9c3d1486f2b7.PNG) <br>
Have new user create an instance of themselves and store it in the database.

## Main Page(Normal user)
![normaluserscreen](https://user-images.githubusercontent.com/47226703/63475565-5f2eba80-c44b-11e9-980b-26a4f048d877.PNG)
After being found in database and passwords validated, show the user the main screen. The user should be able to see all the flights, book a flight and delete a ticket. Flight should update seats when a ticket is booked/deleted. If the user already booked a flight inform user and prevent them from creating a duplicate ticket.

## Main Page(Admin user)
![adminscreen](https://user-images.githubusercontent.com/47226703/63475576-6ce44000-c44b-11e9-87ba-cf90442b59a8.PNG)
The admin user should have all the functionality of a normal user but be able to add/edit and remove flights.
