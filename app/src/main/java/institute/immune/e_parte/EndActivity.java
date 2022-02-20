package institute.immune.e_parte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class EndActivity extends AppCompatActivity {
    private Intent intent;
    private EditText mail;
    private Button button;
    private Button button2;
    private TextView code;
    private String num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);
        bindings();
        code.setText(generatedCode());
    }

    public void openMenu(View view) {
        createTXT();
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

    public String generatedCode(){
        num = String.valueOf(1000000 + Math.round(Math.random()*1_000_000) + 1);
        return num;
    }


    public void createTXT(){
        try {

            // this will create a new name everytime and unique
            File root = new File(Environment.getExternalStorageDirectory(), "Notes");
            // if external memory exists and folder with name Notes
            if (!root.exists()) {
                root.mkdirs(); // this will create folder.
            }
            File filepath = new File(getExternalFilesDir(Environment.DIRECTORY_PICTURES), "Datos_Parte" + ".txt"); // file path to save
            FileWriter writer = new FileWriter(filepath);
            writer.append(generatedCode());
            writer.flush();
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
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