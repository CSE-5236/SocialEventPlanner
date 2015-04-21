package cse5236.group11.socialeventplanner;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class EventDetails extends ActionBarActivity {
//    private static EditText event_name;
//    private static EditText event_location;
//    private static EditText event_date;
    private static EventDataHandler dataAccess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }

//        event_name = (EditText) findViewById(R.id.event_name);
//        event_location = (EditText) findViewById(R.id.event_location);
//        event_date = (EditText) findViewById(R.id.event_date);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_event_details, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_event_details, container, false);
            View btnAdd = (Button)rootView.findViewById(R.id.create_button);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreateEvent(v);
            }
        });
        View btnCancel = (Button) rootView.findViewById(R.id.cancel_event_button);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent("cse5236.group11.socialeventplanner.EventLists"));
            }
        });
            return rootView;
        }

        private void CreateEvent(View v) {
            String eName= ((EditText)getView().findViewById(R.id.event_name)).getText().toString();
            String eLocation = ((EditText)getView().findViewById(R.id.event_location)).getText().toString();
            String eDate = ((EditText)getView().findViewById(R.id.event_date)).getText().toString();
        if ((!eName.equals(""))
                && (!eLocation.equals("")) && (!eDate.equals(""))) {

            dataAccess= new EventDataHandler(getActivity());
            Event event=new Event();
            event.setEventName(eName);
            event.setLocation(eLocation);
            event.setDate(eDate);
            dataAccess.addEvent(event);

            //For testing and it works
            //dataAccess.getEvents();


//            this.labResult.setText("Added");
//            Toast.makeText(this, "new record inserted",
//                    Toast.LENGTH_SHORT).show();
            startActivity(new Intent("cse5236.group11.socialeventplanner.EventLists"));
        }
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }

//    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.done_button:
//                CreateEvent();
//                finish();
//                break;
//            case R.id.cancel_button:
//                finish();
//                break;
//        }
//    }
}
