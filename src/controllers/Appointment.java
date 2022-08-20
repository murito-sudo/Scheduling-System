package controllers;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public class Appointment {
    private int ID;
    private String title;
    private int cutomerID;
    private int contactID;
    private String description;
    private String location;
    private String type;

    private LocalDateTime start;
    private LocalDateTime end;
    private String created;

    /**
     * 
     * @param ID
     * @param title
     * @param cutomerID
     * @param contactID
     * @param description
     * @param location
     * @param type
     * @param start
     * @param end
     */


    public Appointment(int ID, String title, int cutomerID, int contactID, String description, String location, String type, LocalDateTime start, LocalDateTime end, String created) {
        this.ID = ID;
        this.title = title;
        this.cutomerID = cutomerID;
        this.contactID = contactID;
        this.description = description;
        this.location = location;
        this.type = type;
        this.start = start;
        this.end = end;
        this.created = created;
    }

    /**
     *
     * @return appointment ID
     */
    public int getID() {
        return ID;
    }

    /**
     *
     * @param ID
     * sets appointment ID
     */

    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     *
     * @return appointment title
     */

    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     */

    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return appointment customer ID
     */

    public int getCutomerID() {
        return cutomerID;
    }

    /**
     *
     * @param cutomerID
     * set Appointment customer ID
     */

    public void setCutomerID(int cutomerID) {
        this.cutomerID = cutomerID;
    }

    /**
     *
     * @return appointment contact id
     */

    public int getContactID() {
        return contactID;
    }

    /**
     *
     * @param contactID
     * set appointment contact id
     */

    public void setContactID(int contactID) {
        this.contactID = contactID;
    }

    /**
     *
     * @return appointment description
     */

    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     * set appointment description
     */

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return appointment location
     */

    public String getLocation() {
        return location;
    }


    /**
     *
     * @param location
     * sets appointment location
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     *
     * @return appointment type
     */

    public String getType() {
        return type;
    }

    /**
     *
     * @param type
     * set appointment type
     */

    public void setType(String type) {
        this.type = type;
    }

    /**
     *
     * @return start date of appointment
     */

    public LocalDateTime getStart() {
        return start;
    }

    /**
     *
     * @param start
     *
     * sets start date of appointment
     */
    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    /**
     *
     * @return end date of an appointment
     */

    public LocalDateTime getEnd() {
        return end;
    }

    /**
     *
     * @param end
     * sets end date of an appointment
     */

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    /**
     *
     * @param id
     * set user ID
     */

    public void setCreated(String id){
        this.created = id;
    }

    /**
     *
     * @return userID
     */
    public String getCreated(){
        return this.created;
    }
}
