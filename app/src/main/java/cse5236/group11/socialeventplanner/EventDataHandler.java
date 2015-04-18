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
public class EventDataHandler extends SQLiteOpenHelper {
    //database info
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "SocialEventPlanner.db";
    private static final String TABLE_Name = "Events";

    //column names
    private static final String KEY_ID = "Event_Id";
    private static final String KEY_EVENT_NAME = "Event_Name";
    private static final String KEY_LOCATION = "Event_Location";
    private static final String KEY_DATE = "Event_Date";

    public EventDataHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //form table
        String CREATE_EVENT_TABLE = "CREATE TABLE" + TABLE_Name + "(" + KEY_ID + " INTEGER PRIMARY KEY"
                + KEY_EVENT_NAME + " TEXT" + KEY_LOCATION + " TEXT" + KEY_DATE + " TEXT" +")";

        db.execSQL(CREATE_EVENT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Name);

        onCreate(db);
    }

    public void addEvent(Event event) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_EVENT_NAME,event.getEventName());
        values.put(KEY_LOCATION,event.getLocation());
        values.put(KEY_DATE, event.getDate());

        db.insert(TABLE_Name,null,values);
        db.close();
    }

    public List<Event> getEvents() {
        List<Event> events = new ArrayList<Event>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_Name;

        SQLiteDatabase db = this.getReadableDatabase();
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

    //TODO: add a delete event ability
    //TODO: add a select single event ability (will require looking up event by name in SQLite)
}