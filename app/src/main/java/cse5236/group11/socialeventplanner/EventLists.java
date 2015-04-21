package cse5236.group11.socialeventplanner;

import android.app.ListActivity;
import android.app.usage.UsageEvents;
import android.content.Intent;
import android.database.Cursor;
import android.provider.CalendarContract;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class EventLists extends ListActivity {
    private Event event;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.new_event:
//                startActivity(new Intent(this, EventDetails.class));
//                startActivity(new Intent("cse5236.group11.socialeventplanner.EventDetails"));
                startActivity(new Intent(getApplicationContext(), EventDetails.class));
                break;
            case R.id.action_logout:
//                startActivity(new Intent(this, EventDetails.class));
                startActivity(new Intent("cse5236.group11.socialeventplanner.Login"));
                finish();
                break;
            case R.id.map_event:
//                startActivity(new Intent(this, EventDetails.class));
//                startActivity(new Intent("cse5236.group11.socialeventplanner.EventDetails"));
                startActivity(new Intent(getApplicationContext(), MapsActivity.class));
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.floating_menu, menu);
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case R.id.delete_event:
//                delete_event(info.id);
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        registerForContextMenu(getListView());
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

        // create the grid item mapping
        String[] from = new String[]{"event", "date","location"};
        int[] to = new int[] {R.id.event_name, R.id.event_date,R.id.event_location};

        ListAdapter adapter = new SimpleAdapter(this, Items,R.layout.event_list, from,to);
        setListAdapter(adapter);

        //TODO: make items clickable to open each event

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }

    @Override
    protected void onListItemClick(ListView list, View view, int position, long id) {
        super.onListItemClick(list, view, position, id);
        HashMap<String,String> event = (HashMap<String ,String>) getListView().getItemAtPosition(position);
//        String selectedItem = (String) getListAdapter().getItem(position);
//        text.setText("You clicked " + event[0] +" "+event[1]+" "+event[2]+ " at position " + position);
    }
}