package cse5236.group11.socialeventplanner;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Nandkumar on 4/3/2015.
 */
public class Help extends Activity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.help);

        View btOK = findViewById(R.id.button_help_ok);
        btOK.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.button_help_ok:
                finishFromChild(this);
                break;
        }
    }
}
