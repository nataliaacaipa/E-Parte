package institute.immune.e_parte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends AppCompatActivity {
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void onClickMenu(View view) {

        switch (view.getId()) {
            case R.id.buttonReport:
                intent = new Intent(this, ReportActivity.class);
                break;
            case R.id.buttonInstructions:
                intent = new Intent(this,InstructionsActivity.class);

                break;
            case R.id.buttonCar:
                intent = new Intent(this, NewVehicleActivity.class);

                break;
        }
        startActivity(intent);
    }

}
