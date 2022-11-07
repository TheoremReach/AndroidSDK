# TheoremReach Android-SDK
For additional information, please see the [TheoremReach Android SDK Integration](https://theoremreach.com/docs/android).


## Setup

Create an [app](https://theoremreach.com/developer/apps) and grab your API Token.

### Download:
Add the following to the repositories closure of the app's module `build.gradle` file

  ```groovy
  repositories {
      google()
      mavenCentral()
      ...
    }
  ```
  Next, add the following to the dependencies closure

  ```groovy
    dependencies {
      implementation 'com.theoremreach:theoremreach:x.x.x'
      implementation 'com.google.android.gms:play-services-ads:21.0.0'
      implementation 'androidx.appcompat:appcompat:1.4.2'
      ...
     }
  ```

  And sync the gradle project files

### Manual:

Download the latest version of the [TheoremReach Android SDK](https://github.com/theoremreach/AndroidSDK) and drop **theoremreach.x.x.x.aar** to the lib folder. Ensure that Google Plays Ads are enabled in your app.


## Other platforms:

[TheoremReach iOS SDK Integration](https://theoremreach.com/docs/ios)
[TheoremReach Unity SDK Integration](https://theoremreach.com/docs/unity)
[TheoremReach Javascript Web SDK Integration](https://theoremreach.com/docs/web)


## ChangeLog

### v.3.5.1
- Added getIsSurveyAvailable

### v.3.5.0
- Better mobile network support and removing READ_PHONE_STATE permission requirement

### v.3.4.6
- Remove allowBackup flag

### v.3.4.5
- Remove 'READ_PHONE_STATE' permission requirement

### v3.4.4
- Fixed Android 5 crash

### v3.4.3
- Removed Google Ads requirement

### v3.4.1
- Added `showUnityRewardCenter(string placementId);` to support the unity SDK better

### v3.3.5
- Adding placements for additional flexibility
