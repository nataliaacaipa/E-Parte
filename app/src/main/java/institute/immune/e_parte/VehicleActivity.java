package institute.immune.e_parte;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class VehicleActivity extends AppCompatActivity {
    EditText name, surname, licensePlate, address, postcode, model, country, policyNumber, agency, gcn, gccfrom, gccto, validUntil, userID;
    private MyOpenHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle);
        db = new MyOpenHelper(this);
        bindings();

    }

    public void registerVehicle(View view) {
        db.añadirCoche("Dani", "González", "352FG3", "ImmuneInstitue", 23456, "Smart", "Spain", 33224252, "mutua", 32422523, "23/1", "08/02", "2020", 1);
        //System.out.println(db.showVechicles());

    }

    public void bindings(){
    }
}