package institute.immune.e_parte;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.EditText;

import java.util.ArrayList;

/**This class will be the tool that we are going to use to connect with our database (SQLite)
 *
 */
public class MyOpenHelper extends SQLiteOpenHelper {

    /** All Queries needed
     */
    private static final String command1 = "CREATE TABLE  user(_ID integer PRIMARY KEY AUTOINCREMENT, name text, mail text, password text)";
    private static final String command2 = "CREATE TABLE  vehicle(_ID integer PRIMARY KEY AUTOINCREMENT,  licensePlate text, name text, surname text, address text, postcode integer, model text , country text, policyNumber integer, insuranceCompany text, agency text, gcn integer, gccfrom text,gccto text, category text, userID integer, FOREIGN KEY(userID) REFERENCES user(_ID))";
    private static final String commandShowUsers = "SELECT _ID, name, mail, password from user";
    private static final String getID = "SELECT _ID from user WHERE mail=?";
    private static final String commmandShowVehicles = "SELECT * from vehicle";
    private static final String commandPasswordbyMail = "SELECT password from user WHERE mail=?";
    private static final String commandIDByuserID = "SELECT _ID from vehicle WHERE userID=?";

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
        sqLiteDatabase.execSQL(getID);
        //bindings();
    }

    /**Method that checks id the mail and password given are from the same user and returns the answer.
     *
     * @param mail: mail to check match
     * @param password: password to check match
     * @return: if its correct or not (true, false)
     */
    public boolean checkUser(String mail, String password){
        Cursor cursor = db.rawQuery(commandPasswordbyMail, new String[]{mail});
        cursor.moveToFirst();
        if(cursor != null && cursor.getCount()>0) {
            @SuppressLint("Range") String realPassword = cursor.getString(cursor.getColumnIndex("password"));
            if (password.equals(realPassword)) {
                return true;
            } else {
                return false;
            }
        }
        else{
            return false;
        }
    }

    /**Method that gives the userID from a given mail.
     *
     * @param mail:mail given to get his userID
     * @return
     */
    public int getUserID(String mail){
        Cursor cursor = db.rawQuery(getID, new String[]{(mail)});
        cursor.moveToFirst();
        if (cursor != null && cursor.getCount()>0) {
            @SuppressLint("Range") int id = cursor.getInt(cursor.getColumnIndex("_ID"));
            Log.d("Se ecnontro", "HEEEEEEEEEEEEEEY");
            return id;

        }
        else {
            System.out.println("hola");
            return 1;
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
    public void añadirCoche(String name, String surname, String licensePlate, String address, int postcode, String model, String country, int policyNumber, String insuranceCompany, String agency, int gcn, String gccfrom, String gccto, int userID){
        ContentValues cv = new ContentValues();
        cv.put("name", name);
        cv.put("surname", surname);
        cv.put("licensePlate", licensePlate);
        cv.put("address", address);
        cv.put("postcode", postcode);
        cv.put("model", model);
        cv.put("country", country);
        cv.put("policyNumber", policyNumber);
        cv.put("insuranceCompany", insuranceCompany);
        cv.put("agency", agency);
        cv.put("gcn", gcn);
        cv.put("gccfrom", gccfrom);
        cv.put("gccto", gccto);
        cv.put("userID", userID);
        db.insert("vehicle",null, cv);
        showVechicles();
    }

    /**Method that gives all vehicles in the table vehicles.
     *
     * @return list with all vehicles
     */
    public ArrayList<Vehicle> showVechicles(){
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
                @SuppressLint("Range") int userID = cursor.getInt(cursor.getColumnIndex("userID"));

                Vehicle vehicle = new Vehicle(id, name, surname, licensePlate, address, postcode, model, country, policyNumber,insuranceCompany, agency, gcn, gccfrom, gccto, userID);
                list.add(vehicle);


                for (Vehicle v : list){
                    System.out.println(v.getName());
                }

            } while (cursor.moveToNext());
        }
        cursor.close();

        return list;
    }

    /**Method that return the _ID from a vechicle with a given userID.
     *
     * @param userID: userID given to get his vehicle ID in the table vechicle
     * @return: _ID for the userID given
     */
    public int getIDByUserID(int userID) {
        Cursor cursor = db.rawQuery(commandIDByuserID, new String[]{String.valueOf((userID))});
        if(cursor != null && cursor.getCount()>0) {
            cursor.moveToFirst();
            do {
                @SuppressLint("Range") int id = cursor.getInt(cursor.getColumnIndex("_ID"));
                return id;
            } while (cursor.moveToNext());
        }
        return 0;
    }
}
