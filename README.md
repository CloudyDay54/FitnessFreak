# FitnessFreak
An Android App for members of an international gym with branches across Africa. The clientele is mostly executives 
who travel around the world and would like to keep working out wherever they are in the world.
The app is to ensure processes between their client as well as management.

<b> <u> <h2> Introduction- Background </h2> </u> </b> <p>
An international gym with branches across Africa has approached you as the best android
developer in town with a gig to develop a mobile application for their members. The gym’s
clientele is mostly executives who travel around the world and would like to keep working out
wherever they are in the world. The application is to ensure efficient processes between their
clients as well the management.
The application should enable the clients to:
1. Register to the gym network.
2. Log in to the application using their username and passwords.
3. Ability for a user to see their profile.
4. Ability to see all the gym locations in Africa in a map and select the nearest gym
location of their choice to work out based on where they are.
5. Log/record their workout sessions.
6. See their past workout routines.
7. Select their language of choice. (Enable Swahili and English language).
8. Ability to see gym instructors endorsed by the gym network.
Additional (Good to haves).
1. Social media integration; Login with Facebook and sharing their workout sessions.
2. One-time login enabled so that the users don’t have to log into the application every
time. Alternatively, you can enable users access the app using a pin.
Functional Requirements
Expectations or Details of the various Modules:
1. Registration and Login
• Create a remote database to save the the users. The table name should be stored
in the server and should be named users_yourRegistrationNumber e.g.
users_92149.
• When a user is registering pick the following details (firstname, lastname, email,
password). Validate password length and also similarity.
• Encrypt passwords with when they are stored on the database.
• Ability for a user to reset password would be a good to have but not mandatory.
2. User Profile
• Create a profile page that contains all details of a user.
• You could optionally have a profile photo, or just a thumbnail for the profile
photo.
• Capture other details such as their home (preferred workout location), age,
gender, weight and target weight after the workout.
Page 2 of 2
3. Gym locations
• This is a list of all gym locations in the network.
• Display the user’s current location using a different marker and all the gyms in a
50km radius.
• They are going to be displayed in a map as pin locations. The user can select one
pin location to view details of the gym. These details include the location(name),
opening and closing times. This information will be displayed in a marker
information window Read more here
(https://developers.google.com/maps/documentation/android-sdk/infowindows)
• These gym locations (coordinates) will be stored in the database in a table called
gym_locations_regno e.g. gym_locations92149
4. Workout Sessions
• Allow the user to add a workout session.
• A workout session consists of a date, location, exercise type/name, number of
reps and sets etc. These information is saved to the remote database, in a table
called sessions_regno e.g. session92149. The table should have userID to
uniquely identify the sessions of every user.
5. Past Workouts
• Allow the user see their previous workout sessions stored in the session92149
table.
• These sessions could be in a list view or list form
6. Language Preference
• Allow users to select a language of their choice.
• This could be done at the start of the application or in a settings page. (your
preference).
• The expectation for this would be that the app would be translated to the
language of choice by the user at runtime.
7. Gym Instructors
• A list view containing all gym instructors.
• These instructors’ details should be captured in a database table called
instructors_92149.
• Details about instructors (name, contacts, email, photo, gender). <br>
  
<b> <u> <h2> Deliverables </h2> </u> </b> <p>
1. Source Code: (Java/Kotlin and PHP/Node js/Python for the API to connect to the
database). Push the source code on your github/bitbucket/gitlab repository. Add the
username antkhaji as a collaborator or an admin(bitbucket).
2. A working APK file.
3. A quote for the project. How much you will charge your client. A cost breakdown could
be desirable as well.
4. Access to the server you are hosting the database. You can use 00webhost or Heroku if
you are using python,which would give you free space to host your remote database or
your api.
