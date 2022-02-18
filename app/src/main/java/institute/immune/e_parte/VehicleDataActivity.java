package institute.immune.e_parte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class VehicleDataActivity extends AppCompatActivity {

    private Intent intent;
    private ArrayList<Vehicle> vehicles;
    private EditText name, surname, licensePlate, address, postcode, model, country, policyNumber, insuranceCompany, agency, gcn, gccfrom, gccto, userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_data);

        bindings();

    }

    public void onClickRV(View view) {

        switch (view.getId()) {
            case R.id.bRegisterVD:
                intent = new Intent(this, ReportActivity.class);
                break;
        }
        startActivity(intent);
    }

    public void bindings() {
        name = findViewById(R.id.inputNameRp);
        surname = findViewById(R.id.inputSurnameRp);
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

    }





    /*
    public void createVehicles(){
        String user = getIntent().getStringExtra("user");

        MyOpenHelper myOpenHelper = new MyOpenHelper(getApplicationContext());

        Bundle bundle = getIntent().getExtras();

        vehicles = new ArrayList<>();
        String name = bundle.getString("name");
        String surname = bundle.getString("surname");
        String licensePlate = bundle.getString("licensePlate");
        String address = bundle.getString("address");
        int postcode = Integer.parseInt(bundle.getString("postcode"));
        String model = bundle.getString("model");
        String country = bundle.getString("country");
        int policynumber = Integer.parseInt(bundle.getString("policynumber"));
        String insuranceCompany = bundle.getString("insuranceCompany");
        String agency = bundle.getString("agency");
        int gcc = Integer.parseInt(bundle.getString("gcc"));
        String gccfrom = bundle.getString("gccfrom");
        String gccto = bundle.getString("gccto");
        int userId = myOpenHelper.getUserID(user);

        vehicles.add(new Vehicle(1, name, surname, licensePlate, address, postcode, model, country, policynumber, insuranceCompany, agency, gcc, gccfrom, gccto, userId));
    }

    public void nameVehicleList(){
        ArrayList<String> namesVehicles = new ArrayList<>();

        for (Vehicle vehicle: vehicles){
            String name = vehicle.getName();
            namesVehicles.add(name);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,namesVehicles);
        vehiclesList.setAdapter(adapter);

    }*/
}