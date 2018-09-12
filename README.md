# AndroidDev
Android Development Class CS646 Final Project
by Jim Fitzgerald and Donglin Lao


**How our project works**:
1. Log in using a google account. Authentication is handled by google/firebase
2. Once your logged in, either choose an existing baby or create a new baby profile
	- Babys are created as the Baby.java Object and saved to Firebase
3. The main menu is shown in grid view containing 6 different icons:
   1. Feeding/Diaper events: Record data for each event
   - Volume fed --> units pulled from Preferences
   - Duration, Date, User (for once social is added so many users could update)
   - Diaper contents, colors
   - FeedingEvents and DiaperEvents both inherit from superclass BabyEvents
   - Events are recorded in the poorly named (Jim) fragment CreateNewEvent
	- the Event Object is created and saved to Firebase
   2. Data: fetches data from our Firebase DB and plots it using a 3rd party plotting library
   - currently plot all feeding events for the selected baby
   3. Timer: Has a stopwatch that counts up and has 4 buttons to start, pause, reset, and record times. 
   4. Symptoms Lookup:
   - pulls preferred website from Preferences
   - List of popular panic searches
   - EditText for Custom searches
   - launches Web Browser to query the chosen site
   - https://stackoverflow.com/questions/2201917/how-can-i-open-a-url-in-androids-web-browser-from-my-application
   5. Music: plays a song after logging into Spotify. Unfortunately this only works if you have a premium account and the code is still in beta so our functionality is limited (It's slow and might take up to ~10s before playing the song). Currently once you log in, it will play one song. I can provide my spotify account if required. 
   6. Settings: contains options to select between different metrics and a button to choose a picture from the photo gallery and set that image as your avatar.
   - Volume Preference -- milliLiters or Ounces
   - Website Preference -- which site to search in Panic -- WebMD, TheBump, KellyMom, WhatToExpectWhenYourExpecting
   - Saves locally as JSON


**Firebase Tree Design**
{
	user-UID{
		BabyNames{
			babies_pushID{
				Baby.java object
			},
		}
		<Baby_by_name>{
			feeding{
				FeedingEvent.java object
			}
			diaper{
				DiaperEvent.java object
			}
		}
	},
	user-UID...
}
- so each user has their list of babies by an ID
- when accessing an individual baby, they are pulling from that specific Baby
- each Baby has Feeding and Diaper change events corresponding to the recorded events

**3rd party Resources used**:
We've already included the necessary files and modifications to the project, but in case it doesn't work double check the following:

* Plotting/graphing:
  * https://github.com/PhilJay/MPAndroidChart
    
     **Gradle changes needed**

      - **Project level `build.gradle`**
      ```gradle
      allprojects {
          repositories {
              maven { url 'https://jitpack.io' }
          }
      }
      ```
      - **App level `build.gradle`**
      ```gradle
      dependencies {
          implementation 'com.github.PhilJay:MPAndroidChart:v3.0.3'
      }
      ```

* Spotify:
  * https://beta.developer.spotify.com/documentation/android-sdk/
   * requirements ( I put the 2 libraries under app/libs):
     * A Spotify Premium account. You can’t play tracks using the Spotify Android SDK using a free account.
     * Android Studio. We’re using 3.0.1 in this example
     * spotify/android-sdk (Spotify Android Playback SDK) https://github.com/spotify/android-sdk/releases
     * spotify/android-auth (Spotify Android Auth SDK) https://github.com/spotify/android-auth/releases
     * Java SE Development Kit

*Launch browser	 
    https://stackoverflow.com/questions/2201917/how-can-i-open-a-url-in-androids-web-browser-from-my-application

*Add <HR> in layout
	https://stackoverflow.com/questions/5049852/android-drawing-separator-divider-line-in-layout

*Firebase Help
	https://developers.google.com/identity/sign-in/android/start-integrating
	https://firebase.google.com/docs/auth/android/google-signin
	https://www.udacity.com/course/firebase-in-a-weekend-by-google-android--ud0352
	
*GridView
	https://www.raywenderlich.com/127544/android-gridview-getting-started