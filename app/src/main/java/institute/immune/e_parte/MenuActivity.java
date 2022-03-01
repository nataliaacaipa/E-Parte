package institute.immune.e_parte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.TextView;

/**The activity that has the menu of all registered and logged in users
 *
 */
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

    /**Menu that opens the activity that the user has chosen.
     *
     */
    public void onClickMenu(View view) {

        switch (view.getId()) {
            case R.id.buttonReport:
                //hey  ;)
                intent = new Intent(this,VehicleDataActivity.class);
                intent.putExtra("user", txtUser.getText().toString());
                break;
            case R.id.buttonInstructions:
                intent = new Intent(this,InstructionsActivity.class);

                break;
            case R.id.buttonCar:
                intent = new Intent(this, NewVehicleActivity.class);
                intent.putExtra("user", txtUser.getText());
                break;
                /*
            case R.id.imageViewLogOutM:
                finish();
                intent = new Intent(this, Home.class);
                break;*/
            default:
                intent = new Intent(this,Home.class);
                break;
        }
        startActivity(intent);
    }

    /**When the user wants to log out.
     *
     */
    public void onClickLogOut(View view) {
        finish();
        intent = new Intent(this, Home.class);
        startActivity(intent);
    }
}
