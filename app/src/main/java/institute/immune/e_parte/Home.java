package institute.immune.e_parte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Home extends AppCompatActivity {
    private Intent intent, i;
    private EditText mail, password;
    private MyOpenHelper op;
    private TextView msg, user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        bindings();
        msg.setVisibility(View.INVISIBLE);



    }

    /** Método que recibe el click a cualquier botón y comienza la actividad deseada.
     *
     * @param view: botón presionado.
     */
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bLoginH:
                if(checkUser()) {
                    finish();
                    intent = new Intent(this, MenuActivity.class);
                    //hey  ;)
                    i = new Intent(this, VehicleDataActivity.class);


                    intent.putExtra("user", mail.getText().toString());
                    i.putExtra("userMail", mail.getText().toString());

                    startActivity(intent);


                }
                else{
                    msg.setVisibility(View.VISIBLE);
                }

                break;
            case R.id.bRegisterH:
                intent = new Intent(this,RegisterActivity.class);
                startActivity(intent);
                break;

            case R.id.bDownloadH:
                finish();
                intent = new Intent(this,CodeActivity.class);
                startActivity(intent);
                break;


            default:
        }

    }

    /** Método que combrueba si los datos de inicio de sesión dados son correctos y devuelve resultado true o false.
     *
     * @return: true o false
     */
    private Boolean checkUser() {
        if(!mail.getText().toString().isEmpty()&&!password.getText().toString().isEmpty()){
            op = new MyOpenHelper(this);
            return op.checkUser(mail.getText().toString(), password.getText().toString());
        }
        else{
            return false;
        }

    }

    public void bindings(){
        mail = findViewById(R.id.mailHome);
        password = findViewById(R.id.passwordHome);
        msg = findViewById(R.id.txtWarningH);
        //user = findViewById(R.id.txtUserM);
    }
}

