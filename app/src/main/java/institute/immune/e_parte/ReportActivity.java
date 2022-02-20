package institute.immune.e_parte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
/**Activity that reciee¡ves data from the driver 1
 *
 */
public class ReportActivity extends AppCompatActivity {
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
    }
    /** When the user wants to go to the next step.
     *
     */
    public void openVehicleA(View view) {
        intent = new Intent(this,Vehicle1Activity.class);
        startActivity(intent);
    }
}