package institute.immune.e_parte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Home extends AppCompatActivity {
    private Intent intent;
    private EditText mail, password;
    private MyOpenHelper op;
    private TextView msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        bindings();



    }

    /** Método que recibe el click a cualquier botón y comienza la actividad deseada.
     *
     * @param view: botón presionado.
     */
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bLoginH:
                if(checkUser()) {
                    intent = new Intent(this, MenuActivity.class);
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
        op = new MyOpenHelper(this);
        op.checkUser(mail.getText().toString(), password.getText().toString());
        return true;
    }

    public void bindings(){
        mail = findViewById(R.id.mailHome);
        password = findViewById(R.id.passwordHome);
        msg = findViewById(R.id.txtWarningH);
    }
}