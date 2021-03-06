package institute.immune.e_parte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**Activity that allows the user to register a new vehicle
 *
 */
public class NewVehicleActivity extends AppCompatActivity {
    private EditText name, surname, licensePlate, address, postcode, model, country, policyNumber, insuranceCompany, agency, gcn, gccfrom, gccto, userID;
    private MyOpenHelper db;
    private Button button;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle);
        db = new MyOpenHelper(this);
        bindings();
    }

    /**Method that registers a new vehicle in the table vehicle.
     * @param view
     */
    public void registerVehicle(View view) {

        if(isEmpty(name)||isEmpty(surname)||isEmpty(licensePlate)||isEmpty(address)||isEmpty(postcode)||isEmpty(model)||isEmpty(country)||isEmpty(policyNumber)||isEmpty(insuranceCompany)||isEmpty(agency)||isEmpty(gcn)||isEmpty(gccfrom)||isEmpty(gccto)){
            toast(getString(R.string.fieldsEmpty));
        }else {
            int userID = db.getUserID(getIntent().getStringExtra("user"));
            db.añadirCoche(name.getText().toString(), surname.getText().toString(), licensePlate.getText().toString() , address.getText().toString(), Integer.parseInt(postcode.getText().toString()), model.getText().toString(), country.getText().toString(), Integer.parseInt(policyNumber.getText().toString()),insuranceCompany.getText().toString(), agency.getText().toString(),Integer.parseInt(gcn.getText().toString()), gccfrom.getText().toString(), gccto.getText().toString(), userID);
            toast(getString(R.string.registerV));
            button.setEnabled(false);
            finish();
        }
    }

    /**Modular method that gets the string from a editText and checks if its null
     *
     * @param x: edittext given to check
     * @return: answer(true, false)
     */
    public boolean isEmpty(EditText x){
        return x.getText().toString().isEmpty();
    }

    /**Method that pops a message to the user:
     *
     * @param text: Text to be displayed
     */
    public void toast(String text){
        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
    }

    /**Injects all views.
     *
     */
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
}



