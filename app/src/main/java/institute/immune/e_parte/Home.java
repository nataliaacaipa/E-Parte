package institute.immune.e_parte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Home extends AppCompatActivity {
    private Intent intent;
    private EditText mail, password;
    private MyOpenHelper op;

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
                }
                break;
            case R.id.bRegisterH:
                intent = new Intent(this,RegisterActivity.class);
                break;
            case R.id.bDownloadH:
                intent = new Intent(this,CodeActivity.class);
                break;
            default:
        }
        startActivity(intent);
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
    }
}