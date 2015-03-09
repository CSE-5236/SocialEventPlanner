package cse5236.group11.socialeventplanner;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.app.Activity;
import android.view.*;
import android.content.Intent;


public class MainActivity extends ActionBarActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onPause(){
     super.onPause();
    }

    @Override
    public void onResume(){
        super.onResume();
        textView = (TextView)findViewById(R.id.status_message);
        textView.setText("Activity 1 was paused, now resumed");
    }

    public void activityTwo(View view){
        Intent intent = new Intent(this, ActivityTwo.class);
        startActivity(intent);
    }
}
