package COM.TQC.GDD01;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import java.util.Calendar;

public class alarmReceiver extends BroadcastReceiver {
    private NotificationManager notificationManager;
    private Notification notification;

    private final static int NOTIFICATION_ID=0;

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent notifyIntent=new Intent(context,MainActivity.class);
        PendingIntent pendingIntent=PendingIntent.getActivity(context,0,notifyIntent,0);
        broadcastNotify(context, pendingIntent);
    }

    private void broadcastNotify(Context context, PendingIntent pendingIntent) {
        notificationManager=
                (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        notification = new Notification.Builder(context)
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.drawable.pencil)
                .setContentTitle("快到期了喔！")
                .setContentText("剩下"+ Calendar.DAY_OF_MONTH +"天~")
                .setContentIntent(pendingIntent)
                .build();
        notificationManager.notify(NOTIFICATION_ID, notification);
    }
}
