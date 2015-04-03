package cse5236.group11.socialeventplanner;

/**
 * Created by Nandkumar on 3/27/2015.
 */
        import android.content.Context;
        import android.database.Cursor;
        import android.database.sqlite.SQLiteDatabase;
        import android.database.sqlite.SQLiteOpenHelper;
        import android.database.sqlite.SQLiteStatement;
        import android.util.Log;
        import java.util.ArrayList;
        import java.util.List;

public class LoginDataAccess {
    private static final String DATABASE_NAME = "SocialEventPlanner.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "Users";
    private Context context;
    private SQLiteDatabase db;
    private SQLiteStatement insertStmt;
    private static final String INSERT = "insert into " + TABLE_NAME + "(User_Name, Password) values (?, ?)" ;

    public LoginDataAccess(Context context) {
        this.context = context;
        SocialEventPlannerOpenHelper openHelper = new SocialEventPlannerOpenHelper(this.context);
        this.db = openHelper.getWritableDatabase();
        this.insertStmt = this.db.compileStatement(INSERT);
    }

    public boolean insert(String name, String password) {
        this.insertStmt.bindString(1, name);
        this.insertStmt.bindString(2, password);
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

    public List<String> selectAll(String username, String password) {
        List<String> list = new ArrayList<String>();
        try {
            Cursor cursor = this.db.query(TABLE_NAME, new String[]{"User_Name", "Password"}, "User_Name = '" + username + "' AND Password= '" + password + "'", null, null, null, "User_Name desc");
            if (cursor.moveToFirst()) {
                do {
                    list.add(cursor.getString(0));
                    list.add(cursor.getString(1));
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

    private static class SocialEventPlannerOpenHelper extends SQLiteOpenHelper {
        SocialEventPlannerOpenHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE " + TABLE_NAME + "(User_Id INTEGER PRIMARY KEY, User_Name TEXT, Password TEXT)");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

            Log.w("Delete", "Upgrading database; this will drop and recreate the tables.");
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            onCreate(db);
        }
    }
}