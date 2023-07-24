package COM.TQC.GDD01;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class Sell extends AppCompatActivity {
    Spinner sp1,sp2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area);
        sp1=findViewById(R.id.spinner3);
        sp2=findViewById(R.id.spinner4);
        Button btn=findViewById(R.id.button1);
        ArrayAdapter<CharSequence> adapter =
                ArrayAdapter.createFromResource(this,
                        R.array.city,
                        android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        sp1.setAdapter(adapter);
        sp1.setOnItemSelectedListener(spnOnItemSelected);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!sp1.getSelectedItem().equals("選擇縣市")&&!sp2.getSelectedItem().equals("選擇區域")){
                    Intent intent=new Intent(Sell.this,Area.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(Sell.this,"請選擇區域",Toast.LENGTH_LONG).show();
                }

            }
        });
    }
    private AdapterView.OnItemSelectedListener spnOnItemSelected
            = new AdapterView.OnItemSelectedListener() {
        public void onItemSelected(AdapterView<?> parent, View view,
                                   int pos, long id) {
            ArrayAdapter<CharSequence> adapter2 =
                    ArrayAdapter.createFromResource(Sell.this,
                            R.array.Taipei,
                            android.R.layout.simple_spinner_item);
            adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            ArrayAdapter<CharSequence> adapter3 =
                    ArrayAdapter.createFromResource(Sell.this,
                            R.array.NewTaipei,
                            android.R.layout.simple_spinner_item);
            adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            if(sp1.getSelectedItem().equals("新北市")){
                sp2.setAdapter(adapter3);
            }else if(sp1.getSelectedItem().equals("臺北市")){
                sp2.setAdapter(adapter2);
            }else{
                sp2.setAdapter(null);
            }

        }
        public void onNothingSelected(AdapterView<?> parent) {
        }
    };
}
