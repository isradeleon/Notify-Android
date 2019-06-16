# Notify-Android
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
```java
// Basic use case:
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
        * Set notification large icon from URL (INTERNET permission is needed)
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