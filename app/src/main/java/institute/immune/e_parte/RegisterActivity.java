package institute.immune.e_parte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**The activity that allows the user to register a new user.
 *
 */
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

    /**When the user wants to register a user.
     *
     */
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
            finish();
            Intent intent = new Intent(this,Home.class);
            startActivity(intent);
        }
    }


    /**Modular method to check empty fields.
     *
     */
    public void showMessage(){
        if (isEmpty(name)||isEmpty(mail)||isEmpty(password)||isEmpty(passwordC)){
            setMessage(getString(R.string.fieldsEmpty));
        }
    }

    /**Modular method to set a message and making it visible.
     *
     * @param text
     */
    public void setMessage(String text){
        message.setVisibility(View.VISIBLE);
        message.setText(text);
    }

    /**Modular method that gets the string from a editText and checks if its null
     *
     * @param x: edittext given to check
     * @return: answer(true, false)
     */
    public boolean isEmpty(EditText x){
        return x.getText().toString().isEmpty();
    }
    /**Injects all views.
     *
     */
    public void bindings(){
            name = findViewById(R.id.inputNameR);
            mail = findViewById(R.id.inputMailR);
            password = findViewById(R.id.inputPasswordR);
            passwordC = findViewById(R.id.inputCPasswordR);
            message = findViewById(R.id.txtMessage);
            button = findViewById(R.id.bRegisterR);
    }

    
}