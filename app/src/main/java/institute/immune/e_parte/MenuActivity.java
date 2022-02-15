package institute.immune.e_parte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.buttonReport:
                intent = new Intent(this, ReportActivity.class);
                startActivity(intent);
                break;
            case R.id.buttonInstructions:
                intent = new Intent(this,InstructionsActivity.class);
                startActivity(intent);
                break;
            case R.id.buttonCar:
                intent = new Intent(this,CarActivity.class);
                startActivity(intent);
                break;
        }
    }
}
