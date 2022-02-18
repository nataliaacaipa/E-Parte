package institute.immune.e_parte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NewVehicleActivity extends AppCompatActivity {
    private EditText name, surname, licensePlate, address, postcode, model, country, policyNumber, insuranceCompany, agency, gcn, gccfrom, gccto, userID;
    private MyOpenHelper db;
    private Intent intent;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle);
        db = new MyOpenHelper(this);
        bindings();
    }

    public void registerVehicle(View view) {

        if(isEmpty(name)||isEmpty(surname)||isEmpty(licensePlate)||isEmpty(address)||isEmpty(postcode)||isEmpty(model)||isEmpty(country)||isEmpty(policyNumber)||isEmpty(insuranceCompany)||isEmpty(agency)||isEmpty(gcn)||isEmpty(gccfrom)||isEmpty(gccto)){
            toast(getString(R.string.fieldsEmpty));
        }else {
            //sendData();
            db.añadirCoche(name.getText().toString(), surname.getText().toString(), licensePlate.getText().toString() , address.getText().toString(), Integer.parseInt(postcode.getText().toString()), model.getText().toString(), country.getText().toString(), Integer.parseInt(policyNumber.getText().toString()),insuranceCompany.getText().toString(), agency.getText().toString(),Integer.parseInt(gcn.getText().toString()), gccfrom.getText().toString(), gccto.getText().toString(), 1);
            toast(getString(R.string.registerV));
            button.setEnabled(false);
            finish();
            intent = new Intent(this,MenuActivity.class);
            startActivity(intent);
        }
    }

    public boolean isEmpty(EditText x){
        return x.getText().toString().isEmpty();
    }

    public void toast(String text){
        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
    }

    public void bindings() {
        name = findViewById(R.id.inputNameRp);
        surname = findViewById(R.id.inputSurnameRp2);
        licensePlate = findViewById(R.id.inputLPV);
        address = findViewById(R.id.inputBirthDateRp);
        postcode = findViewById(R.id.inputCodeV);
        model = findViewById(R.id.inputLicenseNumRp);
        country = findViewById(R.id.inputCountryV);
        policyNumber = findViewById(R.id.inputNumPV);
        insuranceCompany = findViewById(R.id.inputNameAV);
        agency = findViewById(R.id.inputAgencyV);
        gcn = findViewById(R.id.inputNumGCV);
        gccfrom = findViewById(R.id.inputCCVFromV);
        gccto = findViewById(R.id.inputCCVToV);
        button = findViewById(R.id.bRegisterR);
    }


    public void sendData(){
        Intent i = new Intent(this, VehicleDataActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("name", name.getText().toString());
        bundle.putString("surname", surname.getText().toString());
        bundle.putString("licensePlate", licensePlate.getText().toString());
        bundle.putString("address", address.getText().toString());
        bundle.putString("postcode", postcode.getText().toString());
        bundle.putString("model", model.getText().toString());
        bundle.putString("country", country.getText().toString());
        bundle.putString("policyNumber", policyNumber.getText().toString());
        bundle.putString("agency", agency.getText().toString());
        bundle.putString("gcn", gcn.getText().toString());
        bundle.putString("gccfrom", gccfrom.getText().toString());
        bundle.putString("gccto", gccto.getText().toString());

        i.putExtras(bundle);

    }
}



