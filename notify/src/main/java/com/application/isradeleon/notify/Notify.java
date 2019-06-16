package com.application.isradeleon.notify;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.v4.app.NotificationCompat;

public class Notify {
    private Context context;

    private String channelId;
    private String channelName;
    private String channelDescription;

    private Object largeIcon;
    private String title, content;
    private int id, smallIcon, oreoImportance, importance, color;
    private Intent action;
    private long[] vibrationPattern;
    private boolean autoCancel, vibration, circle;

    private Notify(Context _context){
        this.context = _context;

        ApplicationInfo applicationInfo = this.context.getApplicationInfo();
        String packageName = this.context.getPackageName();

        this.id = (int) System.currentTimeMillis();
        this.channelId = "notify_channel_"+packageName;
        this.channelName = "notify_channel_"+packageName+"_name";
        this.channelDescription = "Notify channel for package: "+packageName;

        this.title = "Notify";
        this.content = "Hello world!";
        this.largeIcon = applicationInfo.icon;
        this.smallIcon = applicationInfo.icon;

        this.color = -1;
        this.action = null;
        this.vibrationPattern = new long[]{100};
        this.autoCancel = false;
        this.vibration = true;
        this.circle = false;
        this.setImportanceDefault();
    }

    public static Notify create(@NonNull Context context){ return new Notify(context); }

    public void show(){
        if (context == null) return;

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        if(notificationManager == null) return;

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, channelId);
        builder.setAutoCancel(this.autoCancel)
                .setDefaults(Notification.DEFAULT_SOUND)
                .setColor(color == -1 ? Color.BLACK : context.getResources().getColor(color))
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(smallIcon)
                .setContentTitle(title)
                .setContentText(content);

        Bitmap largeIconBitmap = null;
        if (largeIcon instanceof String)
            largeIconBitmap = BitmapHelper.getBitmapFromUrl(String.valueOf(largeIcon));
        else largeIconBitmap = BitmapHelper.getBitmapFromRes(this.context, (int) largeIcon);

        if (largeIconBitmap != null){
            if (this.circle)
                largeIconBitmap = BitmapHelper.toCircleBitmap(largeIconBitmap);
            builder.setLargeIcon(largeIconBitmap);
        }

        /*if(this.largeIconUrl != null && !this.largeIconUrl.isEmpty()){
            Bitmap bitmapUrl = BitmapHelper.getCircleBitmapFromUrl(this.largeIconUrl);

            if(bitmapUrl != null) builder.setLargeIcon(bitmapUrl);
            else builder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(),applicationInfo.icon));

        }else builder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(),applicationInfo.icon));*/

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            /*
            * OREO NOTIFICATION CHANNEL
            * */
            NotificationChannel notificationChannel = new NotificationChannel(
                    channelId, channelName, oreoImportance
            );
            //notificationChannel.enableLights(true);
            //notificationChannel.setLightColor(Color.BLUE);
            notificationChannel.setDescription(this.channelDescription);
            notificationChannel.setVibrationPattern(this.vibrationPattern);
            notificationChannel.enableVibration(this.vibration);

            notificationManager.createNotificationChannel(notificationChannel);
        }else{
            builder.setPriority(this.importance);
        }

        builder.setVibrate(this.vibrationPattern);

        if(this.action != null){
            PendingIntent pi = PendingIntent.getActivity(context, id, this.action, PendingIntent.FLAG_CANCEL_CURRENT);
            builder.setContentIntent(pi);
        }
        notificationManager.notify(id, builder.build());
    }

    public Notify setTitle(@NonNull String title) {
        if (!title.trim().isEmpty())
            this.title = title.trim();
        return this;
    }

    public Notify setContent(@NonNull String content) {
        if (!content.trim().isEmpty())
            this.content = content.trim();
        return this;
    }

    public Notify setChannelId(@NonNull String channelId) {
        if (!channelId.trim().isEmpty())
            this.channelId = channelId.trim();
        return this;
    }

    public Notify setChannelName(@NonNull String channelName) {
        if (!channelName.trim().isEmpty())
            this.channelName = channelName.trim();
        return this;
    }

    public Notify setChannelDescription(@NonNull String channelDescription) {
        if (!channelDescription.trim().isEmpty())
            this.channelDescription = channelDescription.trim();
        return this;
    }

    private Notify setImportance(@NonNull NotificationImportance importance){
        switch (importance){
            case MIN:
                this.importance = Notification.PRIORITY_MIN;
                this.oreoImportance = NotificationManager.IMPORTANCE_MIN;
                break;

            case LOW:
                this.importance = Notification.PRIORITY_LOW;
                this.oreoImportance = NotificationManager.IMPORTANCE_LOW;
                break;

            case HIGH:
                this.importance = Notification.PRIORITY_HIGH;
                this.oreoImportance = NotificationManager.IMPORTANCE_HIGH;
                break;

            case MAX:
                this.importance = Notification.PRIORITY_MAX;
                this.oreoImportance = NotificationManager.IMPORTANCE_MAX;
                break;
        }
        return this;
    }

    private void setImportanceDefault(){
        this.importance = Notification.PRIORITY_DEFAULT;
        this.oreoImportance = NotificationManager.IMPORTANCE_DEFAULT;
    }

    public Notify enableVibration(boolean vibration) {
        this.vibration = vibration;
        return this;
    }

    public Notify setAutoCancel(boolean autoCancel) {
        this.autoCancel = autoCancel;
        return this;
    }

    public Notify circleLargeIcon() {
        this.circle = true;
        return this;
    }

    public Notify setVibrationPattern(long[] vibrationPattern) {
        this.vibrationPattern = vibrationPattern;
        return this;
    }

    public Notify setColor(@ColorRes int color) {
        this.color = color;
        return this;
    }

    public Notify setSmallIcon(@DrawableRes int smallIcon) {
        this.smallIcon = smallIcon;
        return this;
    }

    public Notify setLargeIcon(@DrawableRes int largeIcon) {
        this.largeIcon = largeIcon;
        return this;
    }

    public Notify setLargeIcon(@NonNull String largeIconUrl) {
        this.largeIcon = largeIconUrl;
        return this;
    }

    public Notify setAction(@NonNull Intent action) {
        this.action = action;
        return this;
    }

    public Notify setId(int id) {
        this.id = id;
        return this;
    }

    public static void cancel(@NonNull Context context, int id){
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        if (notificationManager != null)
            notificationManager.cancel(id);
    }

    public static void cancelAll(@NonNull Context context){
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        if (notificationManager != null)
            notificationManager.cancelAll();
    }

    public enum NotificationImportance { MIN, LOW, HIGH, MAX }
}


