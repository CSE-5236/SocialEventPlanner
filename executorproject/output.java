package cse5236.group11.socialeventplanner.test;

import cse5236.group11.socialeventplanner.SplashScreen;
import com.robotium.solo.*;
import android.test.ActivityInstrumentationTestCase2;


public class Robotium extends ActivityInstrumentationTestCase2<SplashScreen> {
  	private Solo solo;
  	
  	public Robotium() {
		super(SplashScreen.class);
  	}

  	public void setUp() throws Exception {
        super.setUp();
		solo = new Solo(getInstrumentation());
		getActivity();
  	}
  
   	@Override
   	public void tearDown() throws Exception {
        solo.finishOpenedActivities();
        super.tearDown();
  	}
  
	public void testRun() {
        //Take screenshot
        solo.takeScreenshot();
        //Wait for activity: 'cse5236.group11.socialeventplanner.SplashScreen'
		solo.waitForActivity(cse5236.group11.socialeventplanner.SplashScreen.class, 2000);
        //Wait for activity: 'cse5236.group11.socialeventplanner.Login'
		assertTrue("cse5236.group11.socialeventplanner.Login is not found!", solo.waitForActivity(cse5236.group11.socialeventplanner.Login.class));
        //Enter the text: 'test'
		solo.clearEditText((android.widget.EditText) solo.getView(cse5236.group11.socialeventplanner.R.id.username_text));
		solo.enterText((android.widget.EditText) solo.getView(cse5236.group11.socialeventplanner.R.id.username_text), "test");
        //Click on Empty Text View
		solo.clickOnView(solo.getView(cse5236.group11.socialeventplanner.R.id.password_text));
        //Enter the text: 'test'
		solo.clearEditText((android.widget.EditText) solo.getView(cse5236.group11.socialeventplanner.R.id.password_text));
		solo.enterText((android.widget.EditText) solo.getView(cse5236.group11.socialeventplanner.R.id.password_text), "test");
        //Click on Login
		solo.clickOnView(solo.getView(cse5236.group11.socialeventplanner.R.id.login_button));
        //Wait for dialog
		solo.waitForDialogToOpen(5000);
        //Click on Try Again
		solo.clickOnView(solo.getView(android.R.id.button3));
        //Click on New User
		solo.clickOnView(solo.getView(cse5236.group11.socialeventplanner.R.id.new_user_button));
        //Wait for activity: 'cse5236.group11.socialeventplanner.Account'
		assertTrue("cse5236.group11.socialeventplanner.Account is not found!", solo.waitForActivity(cse5236.group11.socialeventplanner.Account.class));
        //Enter the text: 'test'
		solo.clearEditText((android.widget.EditText) solo.getView(cse5236.group11.socialeventplanner.R.id.username));
		solo.enterText((android.widget.EditText) solo.getView(cse5236.group11.socialeventplanner.R.id.username), "test");
        //Click on Empty Text View
		solo.clickOnView(solo.getView(cse5236.group11.socialeventplanner.R.id.password));
        //Enter the text: 'test'
		solo.clearEditText((android.widget.EditText) solo.getView(cse5236.group11.socialeventplanner.R.id.password));
		solo.enterText((android.widget.EditText) solo.getView(cse5236.group11.socialeventplanner.R.id.password), "test");
        //Click on Empty Text View
		solo.clickOnView(solo.getView(cse5236.group11.socialeventplanner.R.id.password_confirm));
        //Enter the text: 'test'
		solo.clearEditText((android.widget.EditText) solo.getView(cse5236.group11.socialeventplanner.R.id.password_confirm));
		solo.enterText((android.widget.EditText) solo.getView(cse5236.group11.socialeventplanner.R.id.password_confirm), "test");
        //Click on Done
		solo.clickOnView(solo.getView(cse5236.group11.socialeventplanner.R.id.done_button));
        //Click on test
		solo.clickOnView(solo.getView(cse5236.group11.socialeventplanner.R.id.username_text));
        //Click on test
		solo.clickOnView(solo.getView(cse5236.group11.socialeventplanner.R.id.password_text));
        //Click on Login
		solo.clickOnView(solo.getView(cse5236.group11.socialeventplanner.R.id.login_button));
        //Wait for activity: 'cse5236.group11.socialeventplanner.EventLists'
		assertTrue("cse5236.group11.socialeventplanner.EventLists is not found!", solo.waitForActivity(cse5236.group11.socialeventplanner.EventLists.class));
        //Click on ImageView
		solo.clickOnView(solo.getView(android.widget.ActionMenuPresenter$OverflowMenuButton.class, 0));
        //Set default small timeout to 10973 milliseconds
		Timeout.setSmallTimeout(10973);
        //Click on action bar item
		solo.clickOnActionBarItem(cse5236.group11.socialeventplanner.R.id.new_event);
        //Wait for activity: 'cse5236.group11.socialeventplanner.EventDetails'
		assertTrue("cse5236.group11.socialeventplanner.EventDetails is not found!", solo.waitForActivity(cse5236.group11.socialeventplanner.EventDetails.class));
        //Set default small timeout to 14877 milliseconds
		Timeout.setSmallTimeout(14877);
        //Enter the text: 'buckeye frenzy'
		solo.clearEditText((android.widget.EditText) solo.getView(cse5236.group11.socialeventplanner.R.id.event_name));
		solo.enterText((android.widget.EditText) solo.getView(cse5236.group11.socialeventplanner.R.id.event_name), "buckeye frenzy");
        //Click on Empty Text View
		solo.clickOnView(solo.getView(cse5236.group11.socialeventplanner.R.id.event_location));
        //Set default small timeout to 59403 milliseconds
		Timeout.setSmallTimeout(59403);
        //Enter the text: 'ohio union'
		solo.clearEditText((android.widget.EditText) solo.getView(cse5236.group11.socialeventplanner.R.id.event_location));
		solo.enterText((android.widget.EditText) solo.getView(cse5236.group11.socialeventplanner.R.id.event_location), "ohio union");
        //Click on Empty Text View
		solo.clickOnView(solo.getView(cse5236.group11.socialeventplanner.R.id.event_date));
        //Enter the text: '11/12/2015'
		solo.clearEditText((android.widget.EditText) solo.getView(cse5236.group11.socialeventplanner.R.id.event_date));
		solo.enterText((android.widget.EditText) solo.getView(cse5236.group11.socialeventplanner.R.id.event_date), "11/12/2015");
        //Click on Done
		solo.clickOnView(solo.getView(cse5236.group11.socialeventplanner.R.id.create_button));
        //Wait for activity: 'cse5236.group11.socialeventplanner.EventLists'
		assertTrue("cse5236.group11.socialeventplanner.EventLists is not found!", solo.waitForActivity(cse5236.group11.socialeventplanner.EventLists.class));
        //Click on ImageView
		solo.clickOnView(solo.getView(android.widget.ActionMenuPresenter$OverflowMenuButton.class, 0));
        //Click on action bar item
		solo.clickOnActionBarItem(cse5236.group11.socialeventplanner.R.id.action_logout);
        //Wait for activity: 'cse5236.group11.socialeventplanner.Login'
		assertTrue("cse5236.group11.socialeventplanner.Login is not found!", solo.waitForActivity(cse5236.group11.socialeventplanner.Login.class));
	}
}
