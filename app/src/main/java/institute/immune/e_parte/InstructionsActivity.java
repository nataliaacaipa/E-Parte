package institute.immune.e_parte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;

/**This activity shows the instructions.
 *
 */
public class InstructionsActivity extends AppCompatActivity {
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions);
        tv = findViewById(R.id.txt1I);
        tv.setMovementMethod(new ScrollingMovementMethod());
    }

    /**When the user wants to close the instructions and go back to the menu.
     *
     */
    public void returnMenu(View view) {
        finish();
    }
}