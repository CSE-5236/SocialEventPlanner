package cse5236.group11.socialeventplanner;

/**
 * Created by Aaron on 4/1/2015.
 * Will hold necessary information for the event fragment
 */
public class Event {
   // private int id;
    private String eventName;
    private String location;
    //User class must be created for this:
    //private User user
    private String date;

//    public int getId() { return id; }
//    public void setId(int id) { this.id = id; }
    public String getEventName() { return eventName; }
    public void setEventName(String eventName) { this.eventName = eventName; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }
}
