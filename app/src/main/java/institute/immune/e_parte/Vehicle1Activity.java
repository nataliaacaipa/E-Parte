package institute.immune.e_parte;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Vehicle1Activity extends AppCompatActivity {
    private Intent intent;
    TextView tv1, tv2, tv3, tv4, tv5, tv6, tv7, tv8, tv9, tv10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle1);
        bindigs();

    }

    public void openVehicleBData(View view) {
        intent = new Intent(this,Report2Activity.class);
        startActivity(intent);
    }

    public void bindigs(){
        tv1 = findViewById(R.id.textView);

    }

    public void onClick(View view) {
        tv1.setBackgroundResource(R.drawable.textview_checked);
    }
}