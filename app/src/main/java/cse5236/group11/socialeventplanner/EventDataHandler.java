package cse5236.group11.socialeventplanner;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;

/**
 * Created by Aaron on 4/3/2015.
 */
public class EventDataHandler {
    //database info
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "SocialEvents.db";
    private static final String TABLE_NAME = "Events";

    private Context context;
    private SQLiteDatabase db;
    private SQLiteStatement insertStmt;
    private static final String INSERT = "insert into " + TABLE_NAME + "(Event_Name, Event_Location,Event_Date) values (?, ?,?)" ;

    //column names
    private static final String KEY_ID = "Event_Id";
    private static final String KEY_EVENT_NAME = "Event_Name";
    private static final String KEY_LOCATION = "Event_Location";
    private static final String KEY_DATE = "Event_Date";

    public EventDataHandler(Context context) {
        this.context = context;
        SocialEventPlannerSQLHelper openHelper = new SocialEventPlannerSQLHelper(this.context);
        this.db = openHelper.getWritableDatabase();
        this.insertStmt = this.db.compileStatement(INSERT);
    }

    public boolean addEvent(Event event) {
        this.insertStmt.bindString(1, event.getEventName());
        this.insertStmt.bindString(2, event.getLocation());
        this.insertStmt.bindString(2, event.getDate());
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

//        ContentValues values = new ContentValues();
//        values.put(KEY_EVENT_NAME,event.getEventName());
//        values.put(KEY_LOCATION,event.getLocation());
//        values.put(KEY_DATE, event.getDate());
//
//        db.insert(TABLE_NAME,null,values);
//        db.close();
    }

    public List<Event> getEvents() {
        List<Event> events = new ArrayList<Event>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Event event = new Event();
                event.setEventName(cursor.getString(1));
                event.setLocation(cursor.getString(2));
                event.setDate(cursor.getString(3));
                events.add(event);
            } while (cursor.moveToNext());
        }

        // closing connection
        cursor.close();
        db.close();

        // returning events
        return events;
    }

    private static class SocialEventPlannerSQLHelper extends SQLiteOpenHelper {
        SocialEventPlannerSQLHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String CREATE_EVENT_TABLE = "CREATE TABLE " + TABLE_NAME + "(" + KEY_ID + " INTEGER PRIMARY KEY, "
                    + KEY_EVENT_NAME + " TEXT, " + KEY_LOCATION + " TEXT, " + KEY_DATE + " TEXT)";

            db.execSQL(CREATE_EVENT_TABLE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.w("Delete", "Upgrading database; this will drop and recreate the tables.");
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            onCreate(db);
        }
    }
    //TODO: add a delete event ability
    //TODO: add a select single event ability (will require looking up event by name in SQLite)
}