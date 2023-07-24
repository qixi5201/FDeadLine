package COM.TQC.GDD01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class time1Activity extends AppCompatActivity {
    private ImageView img, img2, img3, img4;
    private ImageButton imgb;
    private Button b, b2;
    private Intent intent;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.time1_main);
        intent = getIntent();

        init();
        setImg();
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(time1Activity.this, kindActivity.class);
                startActivity(intent1);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(time1Activity.this, timeActivity.class);
                startActivity(intent2);
            }
        });
    }


    private void init() {
        img = (ImageView) findViewById(R.id.imageV);
        img2 = (ImageView) findViewById(R.id.imageV1);
        img3 = (ImageView) findViewById(R.id.imageV2);
        img4 = (ImageView) findViewById(R.id.imageV3);
        imgb = (ImageButton) findViewById(R.id.imageB2);
        b = (Button) findViewById(R.id.kbutton2);
        b2 = (Button) findViewById(R.id.tbutton2);
    }

    private void setImg() {
        img.setImageResource(R.drawable.notebook);
        img2.setImageResource(R.drawable.clab);
        img3.setImageResource(R.drawable.tomato);
        img4.setImageResource(R.drawable.egg);
    }
}

