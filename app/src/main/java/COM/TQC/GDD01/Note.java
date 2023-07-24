package COM.TQC.GDD01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Note extends AppCompatActivity {

    private ImageView img,img2,img3,img4;
    private ImageButton imgb;
    private Button b,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_note);
         init();
         setImg();
         b.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent intent = new Intent(Note.this,kindActivity.class);
                 startActivity(intent);
             }
         });
         b2.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent intent1 = new Intent(Note.this,timeActivity.class);
                 startActivity(intent1);
             }
         });
    }

    private void init()
    {
        img=(ImageView)findViewById(R.id.imageView);
        img2=(ImageView)findViewById(R.id.imageView2);
        img3=(ImageView)findViewById(R.id.imageView3);
        img4=(ImageView)findViewById(R.id.imageView4);
        imgb=(ImageButton)findViewById(R.id.imageButton);
        b=(Button)findViewById(R.id.button);
        b2=(Button)findViewById(R.id.button1);
    }
    private void setImg()
    {
        img.setImageResource(R.drawable.notebook);
        img2.setImageResource(R.drawable.tomato);
        img3.setImageResource(R.drawable.egg);
        img4.setImageResource(R.drawable.apple);
    }
}