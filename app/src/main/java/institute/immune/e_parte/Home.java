package institute.immune.e_parte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Home extends AppCompatActivity {
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                if(checkUser()){
                    intent = new Intent(this, MenuActivity.class);
                    startActivity(intent);
                }
                break;

            case R.id.button2:
                intent = new Intent(this,RegisterActivity.class);
                startActivity(intent);
                break;
            case R.id.button3:
                intent = new Intent(this,CodeActivity.class);
                startActivity(intent);
        }
    }

    private Boolean checkUser() {
        return true;
    }
}