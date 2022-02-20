package institute.immune.e_parte;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**Activity that recieves the data of the damages of the vahicle 1
 *
 */
public class Vehicle1Activity extends AppCompatActivity {
    private Intent intent;
    TextView tv1, tv2, tv3, tv4, tv5, tv6, tv7, tv8, tv9, tv10, tv11, tv12, tv13, tv14, tv15, tv16;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle1);
        bindigs();

    }
    /** When the user wants to go to the next step.
     *
     */
    public void openVehicleBData(View view) {
        intent = new Intent(this,Report2Activity.class);
        startActivity(intent);
    }
    /**The interacrive method that changes the textviews background, the ones that the user selects.
     *
     */
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.textView1:
                tv1.setBackgroundResource(R.drawable.textview_checked);
                break;
            case R.id.textView2:
                tv2.setBackgroundResource(R.drawable.textview_checked);
                break;
            case R.id.textView3:
                tv3.setBackgroundResource(R.drawable.textview_checked);
                break;
            case R.id.textView4:
                tv4.setBackgroundResource(R.drawable.textview_checked);
                break;
            case R.id.textView5:
                tv5.setBackgroundResource(R.drawable.textview_checked);
                break;
            case R.id.textView6:
                tv6.setBackgroundResource(R.drawable.textview_checked);
                break;
            case R.id.textView7:
                tv7.setBackgroundResource(R.drawable.textview_checked);
                break;
            case R.id.textView8:
                tv8.setBackgroundResource(R.drawable.textview_checked);
                break;
            case R.id.textView9:
                tv9.setBackgroundResource(R.drawable.textview_checked);
                break;
            case R.id.textView10:
                tv10.setBackgroundResource(R.drawable.textview_checked);
                break;
            case R.id.textView11:
                tv11.setBackgroundResource(R.drawable.textview_checked);
                break;
            case R.id.textView12:
                tv12.setBackgroundResource(R.drawable.textview_checked);
                break;
            case R.id.textView13:
                tv13.setBackgroundResource(R.drawable.textview_checked);
                break;
            case R.id.textView14:
                tv14.setBackgroundResource(R.drawable.textview_checked);
                break;
            case R.id.textView15:
                tv15.setBackgroundResource(R.drawable.textview_checked);
                break;
            case R.id.textView16:
                tv16.setBackgroundResource(R.drawable.textview_checked);
                break;
        }

    }

    /**Injects all views.
     *
     */
    public void bindigs(){
        tv1 = findViewById(R.id.textView1);
        tv2 = findViewById(R.id.textView2);
        tv3 = findViewById(R.id.textView3);
        tv4 = findViewById(R.id.textView4);
        tv5 = findViewById(R.id.textView5);
        tv6 = findViewById(R.id.textView6);
        tv7 = findViewById(R.id.textView7);
        tv8 = findViewById(R.id.textView8);
        tv9 = findViewById(R.id.textView9);
        tv10 = findViewById(R.id.textView10);
        tv11 = findViewById(R.id.textView11);
        tv12 = findViewById(R.id.textView12);
        tv13 = findViewById(R.id.textView13);
        tv14 = findViewById(R.id.textView14);
        tv15 = findViewById(R.id.textView15);
        tv16 = findViewById(R.id.textView16);
    }

}