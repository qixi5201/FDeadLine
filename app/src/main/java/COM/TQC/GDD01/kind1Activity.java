package COM.TQC.GDD01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class kind1Activity extends AppCompatActivity {
    private ImageView img,img2,img3,img4;
    private ImageButton imgb;
    private Button b,b2;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kind1_main);
        intent = getIntent();

        init();
        setImg();
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(kind1Activity.this,kindActivity.class);
                startActivity(intent1);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(kind1Activity.this,timeActivity.class);
                startActivity(intent2);
            }
        });
    }

    private void init()
    {
        img=(ImageView)findViewById(R.id.image);
        img2=(ImageView)findViewById(R.id.image1);
        img3=(ImageView)findViewById(R.id.image2);
        img4=(ImageView)findViewById(R.id.image3);
        imgb=(ImageButton)findViewById(R.id.imageB);
        b=(Button)findViewById(R.id.kbutton);
        b2=(Button)findViewById(R.id.tbutton);
    }
    private void setImg()
    {
        img.setImageResource(R.drawable.notebook);
        img2.setImageResource(R.drawable.clab);
        img3.setImageResource(R.drawable.tomato);
        img4.setImageResource(R.drawable.egg);
    }
}
