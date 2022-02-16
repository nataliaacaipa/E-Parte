package institute.immune.e_parte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class EndActivity extends AppCompatActivity {
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);
    }

    public void openMenu(View view) {
        finish();
        intent = new Intent(this,MenuActivity.class);
        startActivity(intent);
    }
}