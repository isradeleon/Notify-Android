# Notify-Android
[![Release](https://img.shields.io/github/release/Isradeleon/Notify-Android.svg?style=flat)](https://jitpack.io/#Isradeleon/Notify-Android)
[![API](https://img.shields.io/badge/API-19%2B-blue.svg?style=flat)
Basic Android library for showing system notifications.

Download
--------
Add jitpack.io in your root build.gradle:
```gradle
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

Then add the dependency in your app build.gradle:
```gradle
dependencies {
    implementation 'com.github.Isradeleon:Notify-Android:1.0'
}
```

Usage
--------
First you'll need to add the default notification channel info to your app/res/values/strings.xml file (for API >= 26).
```xml
<resources>
    ...

    <string name="notify_channel_id">MyDefaultChannelID</string>
    <string name="notify_channel_name">MyDefaultChannelName</string>
    <string name="notify_channel_description">MyDefaultChannelDescription</string>

</resources>
```

Basic use case:
```java
@Override
protected void onCreate(Bundle savedInstanceState) {
    ...

    Notify.create(getApplicationContext())
        /*
        * Set notification title and content
        * */
        .setTitle("Jill")
        .setContent("Hi! So today at 7 o'clock?")
        /*
        * Set notification small icon from drawable resource
        * */
        .setSmallIcon(R.drawable.ic_notifications_none_white_24dp)
        .setColor(R.color.colorPrimary)
        /*
        * Set notification large icon from drawable resource or URL
        * (INTERNET permission needs to be added in AndroidManifest.xml)
        * */
        .setLargeIcon("https://images.pexels.com/photos/139829/pexels-photo-139829.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=150&w=440")
        /*
        * Circle shaped large icon
        * */
        .circleLargeIcon()
        .show(); // Finally showing notification
}
```

License
--------
This library is licensed under `MIT license`. View [license](LICENSE).