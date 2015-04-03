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

import java.util.ArrayList;
import java.util.List;


public class EventLists extends ActionBarActivity {
    private EventData dbhelper;
    private SimpleCursorAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_list);

        View btnNewEvent = (Button) findViewById(R.id.new_event_button);

        dbhelper = new EventData(this);
        //should probably add open and close ability to database


        //WORK FROM HERE, NEED TO SETUP ADAPTER SO ALL ADDED EVENTS WILL DISPLAY IN LIST VIEW AS THEY ARE CREATED
        adapter = new SimpleCursorAdapter(this,android.R.layout.simple_list_item_1,dbhelper.selectAll(), );
    }

    private void displayListView(){
        List<String> events = dbhelper.selectAll();


    }
}