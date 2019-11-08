# GithubSample
The goal of this application is to retrieve all issues from the **PublicRepo** repository and display the issue names and labels to the user

### Prerequisites
- Make sure Android Studio is installed 
  - **NOTE:** You are more than welcome to use another editor if you would like, but that might just make things more complicated for you. You can do whatever you would like though :)
- Set up either an [emulator](https://developer.android.com/studio/run/emulator) via Android Studio or run on personal devices for testing


### Instructions
- Build an http request to grab all issues for repository **PublicRepo**
  - **Endpoint:** `https://api.github.com/repos/driveshack/PublicRepo/issues`
- Once the data is retrieved, display the list of issue names and labels using a [RecyclerView](https://developer.android.com/guide/topics/ui/layout/recyclerview)
  - **Note:** How the list of items is displayed is totally up to you and not all that important. Just worry about functionality, then if you have time to make it look nice, feel free.  We are not too concerned on looks


### Tips
- When accessing the api, use the OAuth token provided in `MainActivity.kt`
- Retrieving Github issues api documentation can be found  [here](https://developer.github.com/v3/issues/)
- We know how excited you are to write test cases for this application, but don't worry about writing them for this exercise
- You can assume this application is made for only mobile devices
- You can use any resource you would like to complete this exercise

## Bonus :)
This is only if you think this exercise is too easy and you breeze through it
```
- Make the http request call asynchronous
- If the user clicks on any of the items, navigate to another page with more details on the issue (created_at, body, state, etc.)
- Add the ability to refresh the list if user swipes and holds downward
- Add ability for application to fail gracefully. (User doesn't have internet acess)
```