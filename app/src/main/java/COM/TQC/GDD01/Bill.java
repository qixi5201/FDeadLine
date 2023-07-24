package COM.TQC.GDD01;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Bill extends AppCompatActivity {
    private TextView price,goods;
    private ImageView img;
    private Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);
        img=findViewById(R.id.imageView2);
        price=findViewById(R.id.textView4);
        goods=findViewById(R.id.textView5);
        Bundle bundle=getIntent().getBundleExtra("data");
        String p=bundle.getString("price");
        price.setText(p);
        goods.setText(bundle.getString("goods"));
        img.setImageResource(R.mipmap.ic_launcher);
        b1=findViewById(R.id.button);
        b2=findViewById(R.id.button2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Bill.this,"您已取消付款",Toast.LENGTH_LONG).show();
                finish();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Bill.this,"您已確認付款",Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }
}