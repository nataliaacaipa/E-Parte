package institute.immune.e_parte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Home extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    /** Método que recibe el click a cualquier botón y comienza la actividad deseada.
     *
     * @param view: botón presionado.
     */
    public void onClick(View view) {
        Intent intent;
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
                break;
        }
    }

    /** Método que combrueba si los datos de inicio de sesión dados son correctos y devuelve resultado true o false.
     *
     * @return: true o false
     */
    private Boolean checkUser() {
        return true;
    }
}