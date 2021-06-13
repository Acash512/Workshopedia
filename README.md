# Workshopedia

## App Screenshots

|<img src = "screenshots/Available workshops when user isn't logged in.jpeg" width =200/>|<img src = "screenshots/Sign In.jpeg" width =200/>|<img src = "screenshots/Sign Up.jpeg" width =200/>|<img src = "screenshots/Student Dashboard.jpeg" width =200/>|
|---|---|---|---|

|<img src = "screenshots/Available Workshops.jpeg" width =200/>|<img src = "screenshots/Apply to a Workshop.jpeg" width =200/>|<img src = "screenshots/Sign Out.jpeg" width =200/>|
|---|---|---|

## Instructions to use
Follow the given steps to use/debug the app :-

- Open the app and click on Apply button of any workshop, you will be directed to a Sign in/Sign Up page.
- Sign Up with valid credentials, you will be sent a verification link on your entered Email address.
- Open your mail click on the link then return to the app.
- Again click on apply, you will be directed to Sign in/Sign Up page and Sign in with your Email and Password.
- You are now good to go, when you click on apply, a confirmation dialog will appear.
- Click Ok and that workshop will have an applied status and will be visible in the Student Dashboard.
- You can apply to further workshops and keep a track of them in Student Dashboard.
- The count of applied workshops is accordingly updated and displayed.
- You can also Sign Out and then Sign Up with different credentials, the user data for this new id will be kept separate from the previous one.

## Technologies Used

- SQLite for storing the data of each Workshop.
- SharedPreferences to store the Name of the user and the ids of the Workshops he has applied to.
- FirebaseAuth for authentication of users.
- Glide to load images properly in case there is some issue of dimensions or size in some devices.
