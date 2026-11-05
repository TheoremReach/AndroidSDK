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
      implementation 'androidx.credentials:credentials:1.5.0'
      implementation 'androidx.credentials:credentials-play-services-auth:1.5.0'
      implementation 'com.google.android.libraries.identity.googleid:googleid:1.1.1'
      implementation "androidx.activity:activity:1.9.3"
      implementation(platform("org.jetbrains.kotlin:kotlin-bom:1.8.0"))
      implementation 'com.google.android.material:material:1.6.1'
      implementation 'com.google.android.play:review:2.0.2'
      implementation 'com.theoremreach:theoremreach:x.x.x'
      ...
     }
  ```

  And sync the gradle project files. From 3.7.0 the app compiles against API 35 or later (`compileSdk 35`).

### Manual:

Download the latest version of the [TheoremReach Android SDK](https://github.com/theoremreach/AndroidSDK) and drop **theoremreach.x.x.x.aar** to the lib folder. Ensure that Google Plays Ads are enabled in your app.

An AAR added by hand brings none of its dependencies, so add the ones listed above, other than
`com.theoremreach:theoremreach`, yourself. Without the three Credential Manager libraries (`androidx.credentials` and
`googleid`), Google sign-in shows the wall's error message.


## Other platforms:

[TheoremReach iOS SDK Integration](https://theoremreach.com/docs/ios)
[TheoremReach Unity SDK Integration](https://theoremreach.com/docs/unity)
[TheoremReach Javascript Web SDK Integration](https://theoremreach.com/docs/web)


## ChangeLog
### v.3.7.1
- The status bar's icons over the reward center follow its title: dark when the title is darker than the title bar,
  and light when it's lighter. With a title all but invisible on the bar (an app that hides the toolbar can leave it
  white on a light one), they follow the bar, whichever contrasts more. The gesture bar's icons do the same; 3-button
  navigation keeps its light buttons. That's where the title bar's color is behind them, in an app drawn edge to edge
  (Android 15 and later, for an app that targets API 35 or later)
- A reward center the app closes from outside, by clearing its task for a notification or a deep link, or by
  relaunching a `singleTask` main activity (React Native's and Unity's default), calls `onRewardCenterClosed` and
  checks for rewards, as X and Back do, and its placement doesn't carry over to the next open. A Moment closed that way
  calls `onMomentSurveyClosed`
- A listener that throws in `onRewardCenterClosed` or `onMomentSurveyClosed` is logged, as the other listeners' are,
  rather than ending the app
- The example app has a second button, which opens the reward center with a light title bar and a dark title

### v.3.7.0
- Google sign-in goes through Credential Manager (androidx.credentials 1.5.0, googleid 1.1.1). play-services-auth is
  no longer a direct dependency, so an app can use play-services-auth 22, which removed the legacy sign-in client that
  3.6 called on every wall open. The app compiles against API 35 or later. An app that adds the AAR by hand adds the
  three libraries (see Manual, above). A respondent who backs out of Google's sheet no longer gets the wall's error
  message
- Ads open in the browser, not in the reward center. On Android 6, only an ad that opens a new window does
- A thin loading bar replaces the loading spinner. `setLoadingBarColor` sets its color, #FC178D by default
- On Android 8 and later, if the WebView's renderer process dies (a crash, or the system freeing memory), the reward
  center loads the wall again instead of the app being killed with it. Away from the reward center, it loads when the
  respondent comes back
- "Unexpected Error", for a page that can't load, offers Close beside Try Again, as on iOS
- On Fire tablets, closing the reward center no longer crashes the app when the SDK hasn't reached TheoremReach yet
  (offline, or after Android ends the app's process). While the respondent limits ad tracking, rewards are checked when
  the app starts, not only after the reward center closes
- `setMmpInstallId(provider, installId)` passes the install id a mobile measurement partner, such as Apptrove, gave the
  install to the reward center. Call it before the first `showRewardCenter`
- `onReward`, the survey-available callback and `onSessionIdSet` arrive on the main thread, so move network or other
  long work in them off it. A reward is confirmed only after `onReward` returns. An exception one of them throws is
  logged, and a reward comes again after the app restarts or with the next new reward, as in 3.6
- `getRewardCenterActivity()` returns null once the reward center is destroyed
- User ids are sent percent-encoded, so ids with +, &, ; or # arrive intact
- The color setters ignore an invalid color and keep the previous one. They take #RGB, #ARGB, #RRGGBB and #AARRGGBB,
  with or without the #
- Playtime needs adjoe 4.3 to 4.5, and `setPlaytimeSdkHash` sets adjoe's SDK hash. An app that turns Playtime on
  without adjoe 4.3 to 4.5 no longer crashes: the wall hears that no games are available, and a launch gets the usual
  error
- A dark mode change or a rotation keeps the reward center open, and a language change rebuilds it. After Android ends
  the app's process, it closes, as in 3.6
- Links to other apps (mailto:, market:, intent: and an app's own scheme) open in the app that takes them. Links to
  your app's own schemes don't

### v.3.6.10
- Miscellaneous updates

### v.3.6.5
- Addressed webview flickering issue

### v.3.6.2
- Removed fixed screen orientation setting

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

## License

The TheoremReach SDK is licensed under the [TheoremReach Publisher Terms and Conditions](https://info.theoremreach.com/terms-of-service/); see [LICENSE](LICENSE). The example app's code, in `app/`, is under the MIT License ([its LICENSE](app/LICENSE)).
