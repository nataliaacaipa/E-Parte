package institute.immune.e_parte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EndActivity extends AppCompatActivity {
    private Intent intent;
    private EditText mail;
    private Button button;
    private Button button2;
    private TextView code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);
        bindings();
        code.setText(String.valueOf(1000000 + Math.round(Math.random()*1_000_000) + 1));
    }

    public void openMenu(View view) {
        toast("Parte descargado");
        button2.setEnabled(false);
        finish();
        intent = new Intent(this,MenuActivity.class);
        startActivity(intent);
    }

    public void sendReport(View view){
        if (!mail.getText().toString().isEmpty()){
            button.setText("Enviado");
            button.setEnabled(false);
        }else {
            toast("escribe el mail");
        }
    }

    public void toast(String text){
        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
    }

    public void bindings(){
        mail= findViewById(R.id.inputMailE);
        button = findViewById(R.id.bSendReportE);
        button2 = findViewById(R.id.bDownloadE);
        code = findViewById(R.id.textViewCode);
    }
}