package COM.TQC.GDD01;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanOptions;

import java.util.HashMap;
import java.util.Map;

public class Scanner extends AppCompatActivity {
    Button btn_scan,save;
    TextView tv,test;
    EditText item_name;
    Map item_list = new HashMap();
    String code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_scanner);
        tv=findViewById(R.id.barcode);
        item_name=findViewById(R.id.item);
        test=findViewById(R.id.textView);
        btn_scan=findViewById(R.id.btn_scan);
        btn_scan.setOnClickListener(view -> {
            scanCode();
        });
        save=findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                item_list.put(code,item_name.getText().toString());
                test.setText(item_list.get(code).toString());
            }
        });

    }

    private void scanCode() {
        ScanOptions options=new ScanOptions();
        options.setPrompt("Volume uo to flash");
        options.setBeepEnabled(true);
        options.setOrientationLocked(true);
        options.setCaptureActivity(CaptureAct.class);
        barLauncher.launch(options);
    }
    ActivityResultLauncher<ScanOptions> barLauncher=registerForActivityResult(new ScanContract(),result -> {
        if(result.getContents()!=null){
            new android.app.AlertDialog.Builder(Scanner.this).setTitle("Result")
                    .setMessage(result.getContents())
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            tv.setText(result.getContents().toString());
                            code=result.getContents().toString();
                        }
                    }).show();

        }
    });

}