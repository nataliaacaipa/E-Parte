package institute.immune.e_parte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Vehicle2Activity extends AppCompatActivity {
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle2);
    }
    public void openEnd(View view) {
        intent = new Intent(this,EndActivity.class);
        startActivity(intent);
    }


}