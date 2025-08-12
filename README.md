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
      implementation 'androidx.preference:preference:1.2.1'
      implementation 'androidx.preference:preference-ktx:1.2.1'
      implementation 'androidx.appcompat:appcompat:1.5.1'
      implementation 'com.google.android.gms:play-services-base:18.5.0'
      implementation 'com.google.android.gms:play-services-auth:21.3.0'
      implementation "androidx.activity:activity:1.9.3"
      implementation(platform("org.jetbrains.kotlin:kotlin-bom:1.8.0"))
      implementation 'com.theoremreach:theoremreach:x.x.x'
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
### v.3.6.1
- Fixed minor layout change issue

### v.3.6.0
- Added support for Android 16 edge-to-edge

### v.3.5.8
- Updated Gradle to version 8.1.0

### v.3.5.7
- Added Android Photo Picker for image upload
- Upgraded gradle to 7.0.4 with distribution URL https://services.gradle.org/distributions/gradle-7.2-bin.zip (Note: This is the minimum Gradle Version Needed, Recommended Version is 8.0.2 with distribution URL https://services.gradle.org/distributions/gradle-8.0-bin.zip )
- Updated packages which are compatible with updated gradle version.
- Two new dependencies are added:

  ```groovy
    implementation "androidx.activity:activity:1.9.3"
    implementation(platform("org.jetbrains.kotlin:kotlin-bom:1.8.0"))
      
  ```

### v.3.5.6
- image upload support

### v.3.5.5
- Update bottom bar color

### v.3.5.4
- Updated version tracking and default colors

### v.3.5.3
- Better third party login support

### v.3.5.2
- Fix issue with redirecting to offers

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
