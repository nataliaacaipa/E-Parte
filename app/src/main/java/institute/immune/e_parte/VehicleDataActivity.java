package institute.immune.e_parte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class VehicleDataActivity extends AppCompatActivity {

    private Intent intent;
    private MyOpenHelper op;
    private EditText mail, name, surname, licensePlate, address, postcode, model, country, policyNumber, insuranceCompany, agency, gcn, gccfrom, gccto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_data);
        bindings();
        String user = getIntent().getStringExtra("user");
        System.out.println(getUserId(user));
        //fillData(1);
        fillData(getUserId(user));

    }

    public void onClickRV(View view) {

        intent = new Intent(this, ReportActivity.class);
        startActivity(intent);
}

    public void bindings() {
        name = findViewById(R.id.inputNameVD);
        surname = findViewById(R.id.inputSurnameVD);
        licensePlate = findViewById(R.id.inputLPVD);
        address = findViewById(R.id.inputAddressVD);
        postcode = findViewById(R.id.inputCodeVD);
        model = findViewById(R.id.inputModelVD);
        country = findViewById(R.id.inputCodeVD);
        policyNumber = findViewById(R.id.inputNumPVD);
        insuranceCompany = findViewById(R.id.inputNameAVD);
        agency = findViewById(R.id.inputAgencyVD);
        gcn = findViewById(R.id.inputNumGCVD);
        gccfrom = findViewById(R.id.inputCCVFromVD);
        gccto = findViewById(R.id.inputCCVToVD);


    }

    public Integer getUserId(String user){
        op = new MyOpenHelper(this);
        return op.getUserID(user);
    }

    public void fillData(int userID){
        ArrayList<Vehicle> vehiclesList = op.showVechicles();
        int posVehicle = op.getIDByUserID(userID);
        Vehicle userVehicle = vehiclesList.get(posVehicle);
        name.setText(userVehicle.getName());
        surname.setText(userVehicle.getSurname());
        licensePlate.setText(userVehicle.getLicensePlate());
        address.setText(userVehicle.getAddress());
        postcode.setText(String.valueOf(userVehicle.getPostcode()));
        model.setText(userVehicle.getModel());
        country.setText(userVehicle.getCountry());
        policyNumber.setText(String.valueOf(userVehicle.getPolicyNumber()));
        insuranceCompany.setText(userVehicle.getInsuranceCompany());
        agency.setText(userVehicle.getAgency());
        gcn.setText(String.valueOf(userVehicle.getGcn()));
        gccfrom.setText(userVehicle.getGccfrom());
        gccto.setText(userVehicle.getGccto());

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