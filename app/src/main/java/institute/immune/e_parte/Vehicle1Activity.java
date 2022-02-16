package institute.immune.e_parte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Vehicle1Activity extends AppCompatActivity {
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle1);
    }

    public void openVehicleBData(View view) {
        intent = new Intent(this,Report2Activity.class);
        startActivity(intent);
    }
}