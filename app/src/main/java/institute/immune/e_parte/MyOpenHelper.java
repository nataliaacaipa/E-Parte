package institute.immune.e_parte;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;


public class MyOpenHelper extends SQLiteOpenHelper {
    private static final String command1 = "CREATE TABLE  user (_ID integer PRIMARY KEY AUTOINCREMENT, name text, mail text)";
    private static final String command2 = "SELECT _ID, name, mail from user";
    private SQLiteDatabase db;
    public MyOpenHelper(Context context) {
        super(context, "user.sqlite", null, 1);
        db = this.getWritableDatabase();

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(command1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void añadir(String nombre, String correo){
        ContentValues cv = new ContentValues();
        cv.put("name", nombre);
        cv.put("mail", correo);
        db.insert("user",null, cv );
    }
    public void borrar(int id){
        String[] args = new String[]{String.valueOf(id)};
        db.delete("user", "_ID=?", args);



    }
    public ArrayList<User> mostrar(){
        ArrayList<User> lista = new ArrayList<User>();
        Cursor cursor = db.rawQuery(command2, null);
        if(cursor != null && cursor.getCount()>0) {
            cursor.moveToFirst();
            do {
                @SuppressLint("Range") String nombre = cursor.getString(cursor.getColumnIndex("name"));
                @SuppressLint("Range") String correo = cursor.getString(cursor.getColumnIndex("mail"));
                @SuppressLint("Range") int id = cursor.getInt(cursor.getColumnIndex("_ID"));
                User user = new User(id ,nombre, correo);
                lista.add(user);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return lista;
    }


}
