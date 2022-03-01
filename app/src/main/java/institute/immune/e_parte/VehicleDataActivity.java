package institute.immune.e_parte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

/**The activity that asks the driver/vechicle data that fills automatically.
 *
 */
public class VehicleDataActivity extends AppCompatActivity {

    private Intent intent;
    private MyOpenHelper op;
    private EditText name, surname, licensePlate, address, postcode, model, country, policyNumber, insuranceCompany, agency, gcn, gccfrom, gccto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_data);
        bindings();
        String user = getIntent().getStringExtra("user");
        try {
            fillData(getUserId(user));
        }catch (IndexOutOfBoundsException ignored){
            clearFields();
        }



    }
    /** When the user wants to go to the next step.
     *
     */
    public void onClickRV(View view) {
        intent = new Intent(this, ReportActivity.class);
        startActivity(intent);
}
    /**Injects all views.
     *
     */
    public void bindings() {
        name = findViewById(R.id.inputNameVD);
        surname = findViewById(R.id.inputSurnameVD);
        licensePlate = findViewById(R.id.inputLPVD);
        address = findViewById(R.id.inputAddressVD);
        postcode = findViewById(R.id.inputCodeVD);
        model = findViewById(R.id.inputModelVD);
        country = findViewById(R.id.inputCountryVD);
        policyNumber = findViewById(R.id.inputNumPVD);
        insuranceCompany = findViewById(R.id.inputNameAVD);
        agency = findViewById(R.id.inputAgencyVD);
        gcn = findViewById(R.id.inputNumGCVD);
        gccfrom = findViewById(R.id.inputCCVFromVD);
        gccto = findViewById(R.id.inputCCVToVD);


    }

    /**Method that gives the userID given his mail(user);
     *
     * @param user
     * @return
     */
    public Integer getUserId(String user){
        op = new MyOpenHelper(this);
        return op.getUserID(user);
    }

    /**Method that fills all fields given a user id from the database
     *
     * @param userID:userID given to get data
     */
    public void fillData(int userID){
        ArrayList<Vehicle> vehiclesList = op.showVechicles();
        //Aqui hay que saber cual es la posiscion en la lista donde userID = userID
        for (Vehicle userVehicle:vehiclesList){
            if (userVehicle.getUserID() == userID){
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
        }
    }
    public void clearFields(){
        name.setText("");
        surname.setText("");
        licensePlate.setText("");
        address.setText("");
        postcode.setText("");
        model.setText("");
        country.setText("");
        policyNumber.setText("");
        insuranceCompany.setText("");
        agency.setText("");
        gcn.setText("");
        gccfrom.setText("");
        gccto.setText("");
    }

}