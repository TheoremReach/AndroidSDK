# TheoremReach Android-SDK
TheoremReach Android SDK v3.2.7

For additional information, please see the [TheoremReach Android SDK Integration](https://theoremreach.com/docs/android).

## v3.2.7
- Fixed error in onReceivedSslError 

## Setup

Create an [app](https://theoremreach.com/developer/apps) and grab your API Token.

#### Download:

Add the following to the repositories closure of the app's module `build.gralde` file

  ```groovy
  repositories {
      jcenter()
      google()
      ...
    }
  ```
  Next, add the following to the dependencies closure

  ```groovy
    dependencies {
      implementation 'com.theoremreach:theoremreach:3.2.7'
      ...
     }
  ```

  And synch the gradle project files

  #### Manual:

  Download the latest version of the [TheoremReach Android SDK](https://github.com/theoremreach/AndroidSDK) and drop **theoremreach.3.2.7.aar** to the lib folder. Ensure that Google Plays Ads are enabled in your app.

## Other platforms:

[TheoremReach iOS SDK Integration](https://theoremreach.com/docs/ios)

[TheoremReach Unity SDK Integration](https://theoremreach.com/docs/unity)

[TheoremReach Javascript Web SDK Integration](https://theoremreach.com/docs/web)  
