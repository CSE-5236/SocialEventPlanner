package cse5236.group11.socialeventplanner;

import android.app.AlertDialog;
import android.content.DialogInterface;
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


public class EventDetails extends ActionBarActivity implements View.OnClickListener {
    private static EditText event_name;
    private static EditText event_location;
    private static EditText event_date;
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

        event_name = (EditText) findViewById(R.id.event_name);
        event_location = (EditText) findViewById(R.id.event_location);
        event_date = (EditText) findViewById(R.id.event_date);
//        View btnAdd = (Button) findViewById(R.id.create_button);
//        btnAdd.setOnClickListener(this);
//        View btnCancel = (Button) findViewById(R.id.cancel_event_button);
//        btnCancel.setOnClickListener(this);
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
        View btnCancel = (Button) rootView.findViewById(R.id.delete_event);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

            return rootView;
        }
        private void CreateEvent(View v) {
            String eName = event_name.getText().toString();
            String eLocation = event_location.getText().toString();
            String eDate = event_date.getText().toString();
        if ((!eName.equals(""))
                && (!eLocation.equals("")) && (!eDate.equals(""))) {

//            dataAccess= new EventData(this);
//            Event event=new Event();
//            event.setEventName(eName);
//            event.setLocation(eLocation);
//            event.setDate(eDate);
//            dataAccess.insert(event);
            // this.labResult.setText("Added");
//            Toast.makeText(this, "new record inserted",
//                    Toast.LENGTH_SHORT).show();
//            finish();
        }
        }
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.done_button:
                CreateEvent();
                finish();
                break;
            case R.id.cancel_button:
                finish();
                break;
        }
    }

    private void CreateEvent() {
        String eName = event_name.getText().toString();
        String eLocation = event_location.getText().toString();
        String eDate = event_date.getText().toString();
//        if ((password.equals(confirm)) && (!username.equals(""))
//                && (!password.equals("")) && (!confirm.equals(""))) {
//
//            this.dataAccess = new LoginDataAccess(this);
//            this.dataAccess.insert(username, password);
//            // this.labResult.setText("Added");
//            Toast.makeText(Account.this, "new record inserted",
//                    Toast.LENGTH_SHORT).show();
//            finish();
//        } else if ((username.equals("")) || (password.equals(""))
//                || (confirm.equals(""))) {
//            Toast.makeText(Account.this, "Missing entry", Toast.LENGTH_SHORT)
//                    .show();
//        } else if (!password.equals(confirm)) {
//            new AlertDialog.Builder(this)
//                    .setTitle("Error")
//                    .setMessage("passwords do not match")
//                    .setNeutralButton("Try Again",
//                            new DialogInterface.OnClickListener() {
//                                public void onClick(DialogInterface dialog,
//                                                    int which) {
//                                }
//                            })
//
//                    .show();
//        }
    }
}
