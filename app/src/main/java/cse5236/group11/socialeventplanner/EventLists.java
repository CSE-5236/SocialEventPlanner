package cse5236.group11.socialeventplanner;

import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;


public class EventLists extends ActionBarActivity implements OnClickListener{
    private Event event = new Event();
    //private User user = new User();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_list);

        View btnNewEvent = (Button) findViewById(R.id.new_event_button);
        btnNewEvent.setOnClickListener(this);

        String[] fromColumns = {event.getEventName()};
        int[] toViews = {R.id.event_name, R.id.creators_name};

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.activity_event_details,
                null, fromColumns, toViews, 0);


    }

    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        //called when a new cursor needs to be displayed
        return new CursorLoader(this, event, null, null, null);
    }

    @Override
    public void onResume(){
        super.onResume();

        Log.d("EventLists","hello world");
    }

    public void onClick(View v){
        startActivity(new Intent(this,EventDetails.class));
    }

}