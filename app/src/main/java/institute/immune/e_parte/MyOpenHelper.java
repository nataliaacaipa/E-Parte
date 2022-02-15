package institute.immune.e_parte;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;


public class MyOpenHelper extends SQLiteOpenHelper {
    /** Queries necesarias:
     *  command1 = crea la tabla de usuarios(user)
     *  command2 = crea la tabla de vehículos(vehicle)
     *  command3 = crea la tabla de partes(report)
     */
    private static final String command1 = "CREATE TABLE  user (_ID integer PRIMARY KEY AUTOINCREMENT, name text, mail text, password text)";
    private static final String command2 = "CREATE TABLE  vechicle (_ID integer PRIMARY KEY AUTOINCREMENT,  licensePlate text, name text, surname text, adress text, postcode integer, iva boolean, model text , country text, policyNumber integer, agency text, gCNumber integer, caducityGC text, damagesInsured boolean, driverLicenseNumber integer, category text, issued text, validUntil text, userID integer, FOREIGN KEY(userID) REFERENCES user(_ID))";
    private static final String commandMostrarUsuarios = "SELECT _ID, name, mail, password from user";
    private SQLiteDatabase db;

    /** Constructor de la clase MyOpenHelper que crea y obtiene la base de datos.
     *
     */
    public MyOpenHelper(Context context) {
        super(context, "user.sqlite", null, 1);
        db = this.getWritableDatabase();
    }
    /** Sobrescribimos el método onCreate para reañizar todos los comandos necesarios para nuestra base de datos.
     *
     */
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(command1);
        sqLiteDatabase.execSQL(command2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    /**
     *  @param nombre : Nombre del nuevo usuario.
     * @param correo : Correo electrónico del nuevo usuario.
     * @param contra : Contraseña del nuevo usuario (No es contraseña para no usar ñ).
     */
    public void añadirUsuario(String nombre, String correo, String contra){
        mostrar();
        ContentValues cv = new ContentValues();
        cv.put("name", nombre);
        cv.put("mail", correo);
        cv.put("password", contra);
        db.insert("user",null, cv );
    }

    /** Método que elimina un usuario dado su ID.
     *
     * @param id: ID de usuario elegido para eliminar.
     */
    public void borrar(int id){
        String[] args = new String[]{String.valueOf(id)};
        db.delete("user", "_ID=?", args);
    }
    public ArrayList<User> mostrar(){
        ArrayList<User> list = new ArrayList<User>();
        Cursor cursor = db.rawQuery(commandMostrarUsuarios, null);
        if(cursor != null && cursor.getCount()>0) {
            cursor.moveToFirst();
            do {
                @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex("name"));
                @SuppressLint("Range") String mail = cursor.getString(cursor.getColumnIndex("mail"));
                @SuppressLint("Range") int id = cursor.getInt(cursor.getColumnIndex("_ID"));
                @SuppressLint("Range") String password = cursor.getString(cursor.getColumnIndex("password"));
                User user = new User(id ,name, mail, password);
                list.add(user);
                System.out.println("\nID: " + id + "\nName: " + name + "/ E-mail: " + mail + "/ Password: " + password + "\n");
            } while (cursor.moveToNext());
        }
        cursor.close();

        return list;
    }




}
