package cse5236.group11.socialeventplanner;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import java.util.List;


/**
 * Created by Nandkumar on 3/27/2015.
 */
public class Login extends Activity implements OnClickListener {
    private LoginDataAccess dataAccess;
    private EditText userNameEditableField;
    private EditText passwordEditableField;
    private final static String OPT_NAME = "name";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        userNameEditableField = (EditText) findViewById(R.id.username_text);
        passwordEditableField = (EditText) findViewById(R.id.password_text);
        View btnLogin = (Button) findViewById(R.id.login_button);
        btnLogin.setOnClickListener(this);
        View btnCancel = (Button) findViewById(R.id.cancel_button);
        btnCancel.setOnClickListener(this);
        View btnNewUser = (Button) findViewById(R.id.new_user_button);
        btnNewUser.setOnClickListener(this);
    }

    private void checkLogin() {
        String username = this.userNameEditableField.getText().toString();
        String password = this.passwordEditableField.getText().toString();

//       this.dataAccess = new LoginDataAccess(this);
//        List<String> names = this.dataAccess.selectAll(username, password);
//        if (names.size() > 0) {
//            // Login successful
//            // Save username as the name of the player
//            SharedPreferences settings = PreferenceManager
//                    .getDefaultSharedPreferences(this);
//            SharedPreferences.Editor editor = settings.edit();
//            editor.putString(OPT_NAME, username);
//            editor.commit();
//            finish();
//        } else {
//            new AlertDialog.Builder(this)
//                    .setTitle("Error")
//                    .setMessage("Login failed")
//                    .setNeutralButton("Try Again",
//                            new DialogInterface.OnClickListener() {
//                                public void onClick(DialogInterface dialog,
//                                                    int which) {
//                                }
//                            }).show();
//        }

        this.dataAccess = new LoginDataAccess(this);
        List<String> names = this.dataAccess.selectAll(username, password);
        if (names.size() > 0) {
            // Login successful
            SharedPreferences settings = PreferenceManager
                    .getDefaultSharedPreferences(this);
            SharedPreferences.Editor editor = settings.edit();
            editor.putString(OPT_NAME, username);
            editor.commit();
            startActivity(new Intent(this, Help.class));
            finish();
        } else {
            new AlertDialog.Builder(this)
                    .setTitle("Error")
                    .setMessage("Login failed")
                    .setNeutralButton("Try Again",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,
                                                    int which) {
                                }
                            }).show();
        }

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_button:
                checkLogin();
                startActivity(new Intent(this,EventLists.class));
                break;
            case R.id.cancel_button:
                finish();
                break;
            case R.id.new_user_button:
                startActivity(new Intent(this, Account.class));
                break;
        }
    }
}
