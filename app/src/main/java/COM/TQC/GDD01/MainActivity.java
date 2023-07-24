package COM.TQC.GDD01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity
{
  private Button mbtn1,mbtn2,mbtn3,mbtn4,mbtn5;
  private String CHANNEL_ID = "Coder";


  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.fdeadlinemain);

    mbtn1=findViewById(R.id.button2);
    mbtn2=findViewById(R.id.button3);
    mbtn3=findViewById(R.id.button4);
    mbtn4=findViewById(R.id.button5);
    mbtn5=findViewById(R.id.button6);

    //NotificationChannel channel = new NotificationChannel(
            //CHANNEL_ID, "DemoCode", NotificationManager.IMPORTANCE_DEFAULT);
   // NotificationManager manager = getSystemService(NotificationManager.class);
    //assert manager != null;
    //manager.createNotificationChannel(channel);


    mbtn1.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent intent1=new Intent(MainActivity.this, TimeAlarmActivity.class);
        startActivity(intent1);
      }
    });
    mbtn2.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent intent2=new Intent(MainActivity.this, Record.class);
        startActivity(intent2);
      }
    });
    mbtn3.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent intent3=new Intent(MainActivity.this, Sell.class);
        startActivity(intent3);
      }
    });
    mbtn4.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent intent4=new Intent(MainActivity.this, Note.class);
        startActivity(intent4);
      }
    });
    mbtn5.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent intent5=new Intent(MainActivity.this, Scanner.class);
        startActivity(intent5);
      }
    });

  }
}
