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
    private static final String commandShowUsers = "SELECT _ID, name, mail, password from user";
    private static final String commmandShowVehicles = "SELECT name, surname, licensePlate, address, postcode, iva, model, country, policyNumber, agency, gnc, gcc, damages ";
    private SQLiteDatabase db;

    /** Constructor de la clase MyOpenHelper que crea y obtiene la base de datos.
     *
     */
    public MyOpenHelper(Context context) {
        super(context, "e-parte.sqlite", null, 1);
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
     *  @param name : Nombre del nuevo usuario.
     * @param mail : Correo electrónico del nuevo usuario.
     * @param password : Contraseña del nuevo usuario (No es contraseña para no usar ñ).
     */
    public void añadirUsuario(String name, String mail, String password){
        ContentValues cv = new ContentValues();
        cv.put("name", name);
        cv.put("mail", mail);
        cv.put("password", password);
        db.insert("user",null, cv );
        showUsers();
    }

    /** Método que elimina un usuario dado su ID.
     *
     * @param id: ID de usuario elegido para eliminar.
     */
    public void borrar(int id){
        String[] args = new String[]{String.valueOf(id)};
        db.delete("user", "_ID=?", args);
    }

    /** Método que lee la tabla de vehículos de la base de datos y devuelve sus datos.
     * @return lista: que devuelve todos lso vechiculos
     */
    public ArrayList<User> showUsers(){
        ArrayList<User> list = new ArrayList<User>();
        Cursor cursor = db.rawQuery(commmandShowVehicles, null);
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

    /** Método que añade a la base de datos un nuevo vehículo.
     *
     */
    public void añadirCoche(String name, String surname, String licensePlate, String address, int postcode, int iva, String model, String country, int policyNumber, String agency, int gcn, String gcc, int damagesInsured, int driverLicenseNumber, String category, String issuedIn, String validUntil, int userID){
        ContentValues cv = new ContentValues();
        cv.put("name", name);
        cv.put("surname", surname);
        cv.put("licensePlate", licensePlate);
        cv.put("address", address);
        cv.put("postcode", postcode);
        cv.put("iva", iva);
        cv.put("model", model);
        cv.put("country", country);
        cv.put("policyNumber", policyNumber);
        cv.put("agency", agency);
        cv.put("gcn", gcn);
        cv.put("gcc", gcc);
        cv.put("damagesInsured", damagesInsured);
        cv.put("driverLicenseNumber", driverLicenseNumber);
        cv.put("category", category);
        cv.put("issuedIn", issuedIn);
        cv.put("validUntil", validUntil);
        cv.put("userID", userID);
        db.insert("vehicle",null, cv);
    }
    public ArrayList<User> showVechicles(){
        ArrayList<User> list = new ArrayList<User>();
        Cursor cursor = db.rawQuery(commandShowUsers, null);
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
