package institute.immune.e_parte;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class VehicleActivity extends AppCompatActivity {
    EditText name, surname, licensePlate, address, postcode, model, country, policyNumber, agency, gcn, gccfrom, gccto, userID;
    private MyOpenHelper db;
    private int userIDLogged;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle);
        db = new MyOpenHelper(this);
        bindings();
    }

    public void registerVehicle(View view) {

        if(isEmpty(name)||isEmpty(surname)||isEmpty(licensePlate)||isEmpty(address)||isEmpty(postcode)||isEmpty(model)||isEmpty(country)||isEmpty(policyNumber)||isEmpty(agency)||isEmpty(gcn)||isEmpty(gccfrom)||isEmpty(gccto)){
            toast(getString(R.string.fieldsEmpty));
        }else {
            db.añadirCoche(name.getText().toString(), surname.getText().toString(), licensePlate.getText().toString() , address.getText().toString(), Integer.parseInt(postcode.getText().toString()), model.getText().toString(), country.getText().toString(), Integer.parseInt(policyNumber.getText().toString()), agency.getText().toString(),Integer.parseInt(gcn.getText().toString()), gccfrom.getText().toString(), gccto.getText().toString(), 1);
            button.setText(R.string.registerV);
            button.setEnabled(false);
        }
    }

    public boolean isEmpty(EditText x){
        return x.getText().toString().isEmpty();
    }

    public void toast(String text){
        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
    }

    public void bindings() {
        name = findViewById(R.id.inputNameV);
        surname = findViewById(R.id.inputSurnameV);
        licensePlate = findViewById(R.id.inputLPV);
        address = findViewById(R.id.inputAdressV);
        postcode = findViewById(R.id.inputCodeV);
        model = findViewById(R.id.inputModelV);
        country = findViewById(R.id.inputCountryV);
        policyNumber = findViewById(R.id.inputNumPV);
        agency = findViewById(R.id.inputAgencyV);
        gcn = findViewById(R.id.inputNumGCV);
        gccfrom = findViewById(R.id.inputCCVFromV);
        gccto = findViewById(R.id.inputCCVToV);
        button = findViewById(R.id.bRegisterR);
    }
}



