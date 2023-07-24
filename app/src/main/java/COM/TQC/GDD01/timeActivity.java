package COM.TQC.GDD01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class timeActivity extends AppCompatActivity {
    private Spinner spinner;
    private Button b,b2;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.time_main);
        intent = this.getIntent();
        spinner=findViewById(R.id.spinner2);
        ArrayAdapter adapter1 = ArrayAdapter.createFromResource(this
                ,R.array.planets_array,android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adapter1);

        b = (Button) findViewById(R.id.button5);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timeActivity.this.finish();
            }
        });
        b2 = (Button) findViewById(R.id.button6);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(timeActivity.this,time1Activity.class);
                startActivity(intent1);
            }
        });
    }
}
