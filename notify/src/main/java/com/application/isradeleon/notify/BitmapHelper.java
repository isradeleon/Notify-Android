package com.application.isradeleon.notify;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.StrictMode;

import java.io.IOException;
import java.net.URL;

public class BitmapHelper {

    public static Bitmap getBitmapFromUrl(String _url){
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitNetwork().build();
        StrictMode.setThreadPolicy(policy);
        try {
            return BitmapFactory.decodeStream(new URL(_url).openConnection().getInputStream());
        } catch (IOException e){ e.printStackTrace(); }
        return null;
    }

    public static Bitmap getBitmapFromRes(Context context, int res){
        return BitmapFactory.decodeResource(context.getResources(), res);
    }

    public static Bitmap toCircleBitmap(Bitmap bitmap){
        Bitmap dstBmp;
        if (bitmap.getWidth() > bitmap.getHeight()){
            dstBmp = Bitmap.createBitmap(
                    bitmap,
                    (bitmap.getWidth()-bitmap.getHeight())/2,
                    //bitmap.getWidth()/2 - bitmap.getHeight()/2,
                    0,
                    bitmap.getHeight(),
                    bitmap.getHeight()
            );
        }else{
            dstBmp = Bitmap.createBitmap(
                    bitmap,
                    0,
                    (bitmap.getHeight()-bitmap.getWidth())/2,
                    bitmap.getWidth(),
                    bitmap.getWidth()
            );
        }

        final Bitmap output = Bitmap.createBitmap(dstBmp.getWidth(),
                dstBmp.getHeight(), Bitmap.Config.ARGB_8888);
        final Canvas canvas = new Canvas(output);

        final int color = Color.RED;
        final Paint paint = new Paint();
        final Rect rect = new Rect(0, 0, dstBmp.getWidth(), dstBmp.getHeight());
        final RectF rectF = new RectF(rect);

        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(color);
        canvas.drawOval(rectF, paint);

        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(dstBmp, rect, rect, paint);

        return output;
    }

    public static Bitmap getCircleBitmapFromUrl(String _url){
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitNetwork().build();
        StrictMode.setThreadPolicy(policy);

        try {
            URL url = new URL(_url);
            Bitmap bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream());

            Bitmap dstBmp;
            if (bitmap.getWidth() > bitmap.getHeight()){
                dstBmp = Bitmap.createBitmap(
                        bitmap,
                        (bitmap.getWidth()-bitmap.getHeight())/2,
                        //bitmap.getWidth()/2 - bitmap.getHeight()/2,
                        0,
                        bitmap.getHeight(),
                        bitmap.getHeight()
                );
            }else{
                dstBmp = Bitmap.createBitmap(
                        bitmap,
                        0,
                        (bitmap.getHeight()-bitmap.getWidth())/2,
                        bitmap.getWidth(),
                        bitmap.getWidth()
                );
            }

            final Bitmap output = Bitmap.createBitmap(dstBmp.getWidth(),
                    dstBmp.getHeight(), Bitmap.Config.ARGB_8888);
            final Canvas canvas = new Canvas(output);

            final int color = Color.RED;
            final Paint paint = new Paint();
            final Rect rect = new Rect(0, 0, dstBmp.getWidth(), dstBmp.getHeight());
            final RectF rectF = new RectF(rect);

            paint.setAntiAlias(true);
            canvas.drawARGB(0, 0, 0, 0);
            paint.setColor(color);
            canvas.drawOval(rectF, paint);

            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            canvas.drawBitmap(dstBmp, rect, rect, paint);

            return output;
        }
        //catch (IOException | MalformedURLException  e){ e.printStackTrace(); }
        catch (IOException e){ e.printStackTrace(); }

        return null;
    }

    public static Bitmap getCircleBitmapFromRes(Context context, int res){
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), res);
        Bitmap dstBmp;
        if (bitmap.getWidth() > bitmap.getHeight()){
            dstBmp = Bitmap.createBitmap(
                    bitmap,
                    (bitmap.getWidth()-bitmap.getHeight())/2,
                    //bitmap.getWidth()/2 - bitmap.getHeight()/2,
                    0,
                    bitmap.getHeight(),
                    bitmap.getHeight()
            );
        }else{
            dstBmp = Bitmap.createBitmap(
                    bitmap,
                    0,
                    (bitmap.getHeight()-bitmap.getWidth())/2,
                    bitmap.getWidth(),
                    bitmap.getWidth()
            );
        }

        final Bitmap output = Bitmap.createBitmap(dstBmp.getWidth(),
                dstBmp.getHeight(), Bitmap.Config.ARGB_8888);
        final Canvas canvas = new Canvas(output);

        final int color = Color.RED;
        final Paint paint = new Paint();
        final Rect rect = new Rect(0, 0, dstBmp.getWidth(), dstBmp.getHeight());
        final RectF rectF = new RectF(rect);

        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(color);
        canvas.drawOval(rectF, paint);

        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(dstBmp, rect, rect, paint);

        return output;
    }
}
