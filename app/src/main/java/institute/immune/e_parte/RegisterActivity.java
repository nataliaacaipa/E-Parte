package institute.immune.e_parte;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {
    private MyOpenHelper db;
    private EditText name, mail, password, passwordC;
    private TextView message;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        db = new MyOpenHelper(this);

        bindings();

        message.setVisibility(View.INVISIBLE);

    }

    public void register(View view) {
        showMessage();
        if (!password.getText().toString().equals(passwordC.getText().toString())){
            setMessage(getString(R.string.passwordEquals));
        }
        else {
            db.añadirUsuario(name.getText().toString(), mail.getText().toString(), password.getText().toString());
            message.setVisibility(View.INVISIBLE);
            button.setText(R.string.resgisterUser);
            button.setEnabled(false);
        }
    }



    public void showMessage(){
        if (isEmpty(name)||isEmpty(mail)||isEmpty(password)||isEmpty(passwordC)){
            setMessage(getString(R.string.fieldsEmpty));
        }
    }

    public void setMessage(String text){
        message.setVisibility(View.VISIBLE);
        message.setText(text);
    }


    public boolean isEmpty(EditText x){
        return x.getText().toString().isEmpty();
    }

    public void bindings(){
            name = findViewById(R.id.inputNameR);
            mail = findViewById(R.id.inputMailR);
            password = findViewById(R.id.inputPasswordR);
            passwordC = findViewById(R.id.inputCPasswordR);
            message = findViewById(R.id.txtMessage);
            button = findViewById(R.id.bRegisterR);
    }

    
}