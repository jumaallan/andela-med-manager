# Andela Med-Manager  [![CircleCI](https://circleci.com/gh/jumaallan/AndelaMedManager/tree/master.svg?style=shield)](https://circleci.com/gh/jumaallan/Andela-Med-Manager/tree/master)   [![Maintainability](https://api.codeclimate.com/v1/badges/029ded8e7747a58f1095/maintainability)](https://codeclimate.com/github/jumaallan/Andela-Med-Manager/maintainability)  [![Test Coverage](https://api.codeclimate.com/v1/badges/029ded8e7747a58f1095/test_coverage)](https://codeclimate.com/github/jumaallan/Andela-Med-Manager/test_coverage)

Med-Manager is a simple app that helps patients remember to take their medication and provides tracking for the intake of the prescribed medication intake.

The app uses the **MVVM Architecture**. I have used the following components for development:

* Room - For offline data persistence
* LiveData - Handle data in a lifecycle-aware fashion 
* ViewModel - Manage your UI's data in a lifecycle-aware fashion
* DataBinding -  minimize the glue code necessary to bind your application logic and layouts.


> The final apk can be download here : <insert link>

## Prerequisites
You will need the following to run this project:
1. A laptop or desktop machine with internet access
2. Android Studio 3.1 Stable Channel (Latest Stable Release)

## Setting Up
* Clone the Repository from Github
* Open the project folder using Android Studio IDE

### Login Page
The User will the be presented with the Login Page, where they are required to authenticate themselves using Google Login

<img src="https://github.com/jumaallan/AndelaMedManager/blob/master/screenshots/andela-google-auth.png" width="425"/>   <img src="https://github.com/jumaallan/AndelaMedManager/blob/master/screenshots/andela-login-account.png" width="425"/> 

### Main Dashboard 
After being authenticated, the use is redirected to the Main Dashboard Page, which is the Main Activity in our application. The Dashboard shows the app has no Meds added, and gives the User the options to:

* Add New Medicine
* See their Monthly Intake
* See list of all Meds with Search Option

This is how the Dashboard looks like (In Empty State - No Meds Added Yet):

<img src="https://github.com/jumaallan/AndelaMedManager/blob/master/screenshots/andela-main-dashboard-empty.png" width="280"/> <img src="https://github.com/jumaallan/AndelaMedManager/blob/master/screenshots/andela-monthly-meds-empty.png" width="280"/> <img src="https://github.com/jumaallan/AndelaMedManager/blob/master/screenshots/andela-search-meds-empty.png" width="280"/> 

### Medicine [Add -> Confirm -> Save] 
The User is required to add Medicine, using the Add Medicine option on the Main Dashboard. This is how the process looks like :

<img src="https://github.com/jumaallan/AndelaMedManager/blob/master/screenshots/andela-add-medicine.png" width="280"/> <img src="https://github.com/jumaallan/AndelaMedManager/blob/master/screenshots/andela-confirm-medicine.png" width="280"/> <img src="https://github.com/jumaallan/AndelaMedManager/blob/master/screenshots/andela-medicine-success.png" width="280"/> 

### Main Dashboard with Medicine Data
After adding Medicine, the dashboard takes a new look. Its able to show the Daily Medicine stats as swipe-able cards on the top and a list also below it. The app will also show what percentage of the Medicine is remaining with a RED DROP ARROW to show drop i.e The User is taking the Meds. A flat line is seen at 100% to show that the user has not taken any meds yet.

<img src="https://github.com/jumaallan/AndelaMedManager/blob/master/screenshots/andela-med-one.png" width="280"/> <img src="https://github.com/jumaallan/AndelaMedManager/blob/master/screenshots/andela-med-two.png" width="280"/> <img src="https://github.com/jumaallan/AndelaMedManager/blob/master/screenshots/andela-med-three.png" width="280"/> 

### Medicine Details Page
This page shows the Medicine Details in an easy to understand way! Just click on the Stats Card or the Daily Medicine List to see this Details Screen.

<img src="https://github.com/jumaallan/AndelaMedManager/blob/master/screenshots/andela-stats-one.png" width="425"/>   <img src="https://github.com/jumaallan/AndelaMedManager/blob/master/screenshots/andela-stats-two.png" width="425"/> 
 
### Sign Out
The users can leave the app by signing out. This clears their user data as well as the app's data and customizations, if any!

<img src="https://github.com/jumaallan/AndelaMedManager/blob/master/screenshots/andela-profile-card.png" width="425"/> 

### Extra Features
* Backup User and Medicine Data to their Google Drive - Not fully complete

### Undone Parts
* Not done all Unit Tests
* Alarm Manager not giving Notifications per Medicine