package id.teamproject.praktikum.tb.chelseafcsqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class MyDatabase extends SQLiteOpenHelper {
    private static int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "db_chelsea";
    private static final String tb_player = "tb_player";
    private static final String tb_player_id = "id";
    private static final String tb_player_name = "name";
    private static final String tb_player_dob = "dob";
    private static final String tb_player_birthplace = "birthplace";
    private static final String tb_player_height = "height";
    private static final String tb_player_weight = "weight";
    private static final String tb_player_position = "position";
    private static final String tb_player_number = "number";
    private static final String CREATE_TABLE_PLAYER = "CREATE TABLE " +
            tb_player + "("
            + tb_player_id + " INTEGER PRIMARY KEY ,"
            + tb_player_name + " TEXT,"
            + tb_player_dob + " TEXT,"
            + tb_player_birthplace + " TEXT,"
            + tb_player_height + " TEXT,"
            + tb_player_weight + " TEXT,"
            + tb_player_position + " TEXT,"
            + tb_player_number + " TEXT " + ")";

    public MyDatabase (Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_PLAYER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void CreatePlayer (Player mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_player_id, mdNotif.get_id());
        values.put(tb_player_name, mdNotif.get_name());
        values.put(tb_player_dob, mdNotif.get_dob());
        values.put(tb_player_birthplace, mdNotif.get_birthplace());
        values.put(tb_player_height, mdNotif.get_height());
        values.put(tb_player_weight, mdNotif.get_weight());
        values.put(tb_player_position, mdNotif.get_position());
        values.put(tb_player_number, mdNotif.get_number());
        db.insert(tb_player, null, values);
        db.close();
    }

    public List<Player> ReadPlayer() {
        List<Player> judulModelList = new ArrayList<Player>();
        String selectQuery = "SELECT * FROM " + tb_player;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Player mdKontak = new Player();
                mdKontak.set_id(cursor.getString(0));
                mdKontak.set_name(cursor.getString(1));
                mdKontak.set_dob(cursor.getString(2));
                mdKontak.set_birthplace(cursor.getString(3));
                mdKontak.set_height(cursor.getString(4));
                mdKontak.set_weight(cursor.getString(5));
                mdKontak.set_position(cursor.getString(6));
                mdKontak.set_number(cursor.getString(7));
                judulModelList.add(mdKontak);
            } while (cursor.moveToNext());
        }
        db.close();
        return judulModelList;
    }
    public int UpdatePlayer (Player mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_player_name, mdNotif.get_name());
        values.put(tb_player_dob, mdNotif.get_dob());
        values.put(tb_player_birthplace, mdNotif.get_birthplace());
        values.put(tb_player_height, mdNotif.get_height());
        values.put(tb_player_weight, mdNotif.get_weight());
        values.put(tb_player_position, mdNotif.get_position());
        values.put(tb_player_number, mdNotif.get_number());
        return db.update(tb_player, values, tb_player_id + " = ?",
                new String[] { String.valueOf(mdNotif.get_id())});
    }
    public void DeletePlayer (Player mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tb_player, tb_player_id+ " = ?",
                new String[]{String.valueOf(mdNotif.get_id())});
        db.close();
    }
}
