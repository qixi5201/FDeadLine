package COM.TQC.GDD01;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import java.util.Calendar;
import java.util.TimeZone;

public class TimeAlarmActivity extends AppCompatActivity {
    private EditText edtDay;
    private long currentsystemtime;
    private long settime;
    private Calendar calendar;
    private String day;
    private String CHANNEL_ID = "Coder";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting);
        setTitle("設定");
        findViews();
        final Button button=findViewById(R.id.button);
        final EditText days=findViewById(R.id.editTextNumberSigned);
        NotificationChannel channel = new NotificationChannel(
                CHANNEL_ID, "DemoCode", NotificationManager.IMPORTANCE_DEFAULT);
                 NotificationManager manager = getSystemService(NotificationManager.class);
                assert manager != null;
                manager.createNotificationChannel(channel);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                day=days.getText().toString();
                //AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
                //NotificationCompat.Builder builder = new NotificationCompat.Builder(TimeAlarmActivity.this,CHANNEL_ID)
                //.setSmallIcon(R.drawable.sms)
                //setContentTitle("快到期了喔！")
                //.setContentText("期限剩"+day+"天～")
                //.setAutoCancel(true)
                //.setPriority(NotificationCompat.PRIORITY_HIGH)
                //.setCategory(NotificationCompat.CATEGORY_MESSAGE);

                //NotificationManagerCompat notificationManagerCompat
                     // = NotificationManagerCompat.from(TimeAlarmActivity.this);
                //notificationManagerCompat.notify(1,builder.build());
                btnNotify(view);
            }
        });
    }

    private void findViews() {
        edtDay=findViewById(R.id.editTextNumberSigned);
    }

    private void currentTime() {
        calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        currentsystemtime=System.currentTimeMillis();
    }

    //        使用者輸入情況判斷
    private boolean isEmptyText(){
        day = edtDay.getText().toString();
        if(day.isEmpty()){
            return true;
        }
        else {
            return false;
        }
    }

    //        設定定時
    private void setTime(Calendar calendar) {
        calendar.set(Calendar.DAY_OF_MONTH,Integer.parseInt(day));
        //        獲得定時時間
        settime = calendar.getTimeInMillis();
        //        若定時時間(日、時、分)比目前小自動設定為下個月的時間(日、時、分)
        if (currentsystemtime > settime) {
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            settime = calendar.getTimeInMillis();
        }
    }

    //   設定alarm
    private void setAlarm() {
        Intent intent = new Intent(TimeAlarmActivity.this, alarmReceiver.class);
        //        PendingIntent.getBroadcast調用廣播
        PendingIntent pendingIntent = PendingIntent.getBroadcast(TimeAlarmActivity.this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);


        //        獲得AlarmManager物件
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        //        設定單次提醒
        alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
    }

    //    顯示已完成設定的時間
    private void showtime() {

        String text = edtDay.getText().toString();
        int days=Integer.parseInt(text);

        Toast.makeText(this,
                "設定成功\n" + "設定為在到期前"+days+"天提醒",Toast.LENGTH_LONG).show();
    }
    public void btnNotify(View view) {
        //        使用者輸入情況判斷
        if(isEmptyText()){
            Toast.makeText(TimeAlarmActivity.this,"輸入不正確",Toast.LENGTH_SHORT).show();
        }
        else{
            currentTime();
            setTime(calendar);
            setAlarm();
            showtime();
            finish();
        }
    }
}
