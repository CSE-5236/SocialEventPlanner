package cse5236.group11.socialeventplanner;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aaron on 4/3/2015.
 */
public class EventData {
    private static final String DATABASE_NAME = "EventData.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "Events";
    private Context context;
    private SQLiteDatabase db;
    private SQLiteStatement insertStmt;
    private static final String INSERT = "insert into " + TABLE_NAME + "(Event_Name, Event_Location, Date) values (?, ?, ?)" ;

    public EventData(Context context) {
        this.context = context;
        EventDataOpenHelper openHelper = new EventDataOpenHelper(this.context);
        this.db = openHelper.getWritableDatabase();
        this.insertStmt = this.db.compileStatement(INSERT);
    }

    public boolean insert(Event event) {
        this.insertStmt.bindString(1, event.getEventName());
        this.insertStmt.bindString(2, event.getLocation());
        this.insertStmt.bindString(3, event.getDate());
        try
        {
            this.insertStmt.executeInsert();
            return true;
        }
        catch (Exception ex)
        {
            Log.v("Error",ex.getMessage());
            return false;
        }
    }

    public void deleteAll() {

        this.db.delete(TABLE_NAME, null, null);
    }

    public List<String> selectAll() {
        Event event = new Event();
        List<String> list = new ArrayList<String>();
        try {
            Cursor cursor = this.db.query(TABLE_NAME, new String[]{"Event_Name", "Event_Location", "Date"}, "Event_Name = '" + event.getEventName() + "' AND Event_Location = '" + event.getLocation() + "' AND Date =  '" + event.getDate() + "'", null, null, null, "Event_Name desc");
            if (cursor.moveToFirst()) {
                do {
                    list.add(cursor.getString(0));
                    list.add(cursor.getString(1));
                    list.add(cursor.getString(3));
                } while (cursor.moveToNext());
            }
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
        } catch (Exception ex) {
            Log.v("Error",ex.getMessage());
        }
        return list;
    }

    private static class EventDataOpenHelper extends SQLiteOpenHelper {
        EventDataOpenHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE " + TABLE_NAME + "(Event_Id INTEGER PRIMARY KEY, Event_Name TEXT, Event_Location TEXT, Date TEXT)");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

            Log.w("Delete", "Upgrading database; this will drop and recreate the tables.");
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            onCreate(db);
        }
    }
}