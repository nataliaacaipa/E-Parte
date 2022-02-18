package institute.immune.e_parte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {
    private Intent intent;
    private TextView txtUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        String user = getIntent().getStringExtra("user");
        txtUser = findViewById(R.id.txtUserM);
        txtUser.setText(user);

    }

    public void onClickMenu(View view) {

        switch (view.getId()) {
            case R.id.buttonReport:
                intent = new Intent(this, VehicleDataActivity.class);
                break;
            case R.id.buttonInstructions:
                intent = new Intent(this,InstructionsActivity.class);

                break;
            case R.id.buttonCar:
                intent = new Intent(this, NewVehicleActivity.class);

                break;
            case R.id.imageViewLogOutM:
                finish();
                intent = new Intent(this, Home.class);
                break;
        }
        startActivity(intent);
    }

}
