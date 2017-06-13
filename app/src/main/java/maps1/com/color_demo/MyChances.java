package maps1.com.color_demo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by home on 16/01/2017.
 */
public class MyChances extends SQLiteOpenHelper
{

    public static final String DATABASE_NAME = "game.db";

    public static final int DATABASE_VER =   1;

    public static final String TABLE_NAME = "mychances";

    public static final String COL_TOTAL_CHANCES = "totalchances";

    public static final String CREATE_TABLE = " create table if not exists "+TABLE_NAME+" ("+COL_TOTAL_CHANCES+" text)";



    public MyChances(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VER);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(" drop table if exist "+TABLE_NAME);
    }
}
