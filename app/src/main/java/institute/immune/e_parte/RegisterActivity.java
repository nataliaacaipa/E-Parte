package institute.immune.e_parte;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {
    private MyOpenHelper db;
    private EditText name, mail, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        db = new MyOpenHelper(this);
        bindings();
    }

    public void register(View view) {
        db.añadirUsuario(name.getText().toString(), mail.getText().toString(),password.getText().toString());

    }

    public void bindings(){
            name = findViewById(R.id.inputNameR);
            mail = findViewById(R.id.inputMailR);
            password = findViewById(R.id.inputPasswordR);
    }

    
}