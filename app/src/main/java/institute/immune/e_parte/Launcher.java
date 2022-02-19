package institute.immune.e_parte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.text.format.DateFormat;
import android.view.View;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Launcher extends AppCompatActivity {
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        createTXT();





    }

    public void openHome(View view) {
        finish();
        intent = new Intent(this,Home.class);
        startActivity(intent);
    
    }

    public void createTXT(){
        try {

            // this will create a new name everytime and unique
            File root = new File(Environment.getExternalStorageDirectory(), "Notes");
            // if external memory exists and folder with name Notes
            if (!root.exists()) {
                root.mkdirs(); // this will create folder.
            }
            File filepath = new File(getFilesDir().getAbsolutePath(), "Datos_Parte" + ".txt"); // file path to save
            FileWriter writer = new FileWriter(filepath);
            writer.append("heeeeeeey");
            writer.flush();
            writer.close();



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}