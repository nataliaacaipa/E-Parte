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
    private static final String command1 = "CREATE TABLE  user(_ID integer PRIMARY KEY AUTOINCREMENT, name text, mail text, password text)";
    private static final String command2 = "CREATE TABLE  vehicle(_ID integer PRIMARY KEY AUTOINCREMENT,  licensePlate text, name text, surname text, address text, postcode integer, model text , country text, policyNumber integer, insuranceCompany text, agency text, gcn integer, gccfrom text,gccto text, category text, userID integer, FOREIGN KEY(userID) REFERENCES user(_ID))";
    private static final String commandShowUsers = "SELECT _ID, name, mail, password from user";
    private static final String commandPasswordbyMail = "SELECT password from user WHERE mail=?";
    private String realPassword;

    private SQLiteDatabase db;

    /** Constructor de la clase MyOpenHelper que crea y obtiene la base de datos.
     *
     */
    public MyOpenHelper(Context context) {
        super(context, "parte.sqlite", null, 1);
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

    public boolean checkUser(String mail, String password){
        Cursor cursor = db.rawQuery(commandPasswordbyMail, new String[]{mail});
        cursor.moveToFirst();

        @SuppressLint("Range") String realPassword = cursor.getString(cursor.getColumnIndex("password"));
        if(password.equals(realPassword)){
            return true;
        }
        else{
            return false;
        }
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
            } while (cursor.moveToNext());
        }
        cursor.close();
        return list;
    }

    /** Método que añade a la base de datos un nuevo vehículo.
     *
     */
    public void añadirCoche(String name, String surname, String licensePlate, String address, int postcode, String model, String country, int policyNumber, String agency, int gcn, String gccfrom, String gccto, int userID){
        ContentValues cv = new ContentValues();
        cv.put("name", name);
        cv.put("surname", surname);
        cv.put("licensePlate", licensePlate);
        cv.put("address", address);
        cv.put("postcode", postcode);
        cv.put("model", model);
        cv.put("country", country);
        cv.put("policyNumber", policyNumber);
        cv.put("agency", agency);
        cv.put("gcn", gcn);
        cv.put("gccfrom", gccfrom);
        cv.put("gccto", gccto);
        cv.put("userID", userID);
        db.insert("vehicle",null, cv);
    }
   /* public ArrayList<Vehicle> showVechicles(){
        ArrayList<Vehicle> list = new ArrayList<Vehicle>();
        Cursor cursor = db.rawQuery(commmandShowVehicles, null);
        if(cursor != null && cursor.getCount()>0) {
            cursor.moveToFirst();
            do {
                @SuppressLint("Range") int id = cursor.getInt(cursor.getColumnIndex("_ID"));
                @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex("name"));
                @SuppressLint("Range") String surname = cursor.getString(cursor.getColumnIndex("surname"));
                @SuppressLint("Range") String licensePlate = cursor.getString(cursor.getColumnIndex("licensePlate"));
                @SuppressLint("Range") String address = cursor.getString(cursor.getColumnIndex("address"));
                @SuppressLint("Range") int postcode = cursor.getInt(cursor.getColumnIndex("postcode"));
                @SuppressLint("Range") String model = cursor.getString(cursor.getColumnIndex("model"));
                @SuppressLint("Range") String country = cursor.getString(cursor.getColumnIndex("country"));
                @SuppressLint("Range") int policyNumber = cursor.getInt(cursor.getColumnIndex("policyNumber"));
                @SuppressLint("Range") String insuranceCompany = cursor.getString(cursor.getColumnIndex("insuranceCompany"));
                @SuppressLint("Range") String agency = cursor.getString(cursor.getColumnIndex("agency"));
                @SuppressLint("Range") int gcn = cursor.getInt(cursor.getColumnIndex("gcn"));
                @SuppressLint("Range") String gccfrom = cursor.getString(cursor.getColumnIndex("gccfrom"));
                @SuppressLint("Range") String gccto = cursor.getString(cursor.getColumnIndex("gccto"));
                @SuppressLint("Range") String validUntil = cursor.getString(cursor.getColumnIndex("validUntil"));
                @SuppressLint("Range") int userID = cursor.getInt(cursor.getColumnIndex("userID"));

                Vehicle vehicle = new Vehicle(id, name, surname, licensePlate, address, postcode, model, country, policyNumber,insuranceCompany, agency, gcn, gccfrom, gccto, validUntil, userID);
                list.add(vehicle);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return list;
    }*/
}
