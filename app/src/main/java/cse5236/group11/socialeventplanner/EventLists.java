package cse5236.group11.socialeventplanner;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.provider.CalendarContract;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class EventLists extends ListActivity {
    private Event event;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_list);

        EventDataHandler db = new EventDataHandler(this);

        //Hash map for list view to make item clickable
        ArrayList<HashMap<String, String>> Items = new ArrayList<HashMap<String, String>>();
        List<Event> events = db.getEvents();

        for(Event e : events) {
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("event",e.getEventName());
            map.put("location", e.getLocation());
            map.put("date", e.getDate());

            Items.add(map);
        }

        ListAdapter adapter = new SimpleAdapter(this, Items,R.layout.event_list, new String[]
                {"event", "location", "date"}, new int[]{R.id.event_name, R.id.event_location, R.id.event_date});

        setListAdapter(adapter);

        //TODO: make items clickable to open each event

    }
}