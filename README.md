# TheoremReach Android-SDK
TheoremReach Android SDK v3.1.8

For additional information, please see the [TheoremReach Android SDK Integration](https://theoremreach.com/docs/android).

## v3.1.8
- Moments Beta Released
- Improved debug mode for testing
- Reset profiler for testing

## Setup

Create an [app](https://theoremreach.com/developer/apps) and grab your API Token.

#### Download:

Add the following to the repositories closure of the app's module `build.gralde` file

  ```groovy
  repositories {
      jcenter()
      ...
    }
  ```
  Next, add the following to the dependencies closure

  ```groovy
    dependencies {
      compile 'com.google.android.gms:play-services-ads:10.2.1'
      compile 'com.theoremreach:theoremreach:3.1.8'
      ...
     }
  ```

  And synch the gradle project files

  #### Manual:

  Download the latest version of the [TheoremReach Android SDK](https://github.com/theoremreach/AndroidSDK) and drop **theoremreach.3.1.8.aar** to the lib folder. Ensure that Google Plays Ads are enabled in your app.

## Other platforms:

[TheoremReach iOS SDK Integration](https://theoremreach.com/docs/ios)

[TheoremReach Unity SDK Integration](https://theoremreach.com/docs/unity)

[TheoremReach Javascript Web SDK Integration](https://theoremreach.com/docs/web)  
