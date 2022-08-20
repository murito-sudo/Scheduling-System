package controllers;

public class Customer {
    private int ID;
    private String username;
    private String address;
    private String postalcode;
    private String phone;
    private int DivID;

    /**
     *
     * @param ID
     * @param username
     * @param address
     * @param postalcode
     * @param phone
     * @param divID
     */
    public Customer(int ID, String username, String address, String postalcode, String phone, int divID) {
        this.ID = ID;
        this.username = username;
        this.address = address;
        this.postalcode = postalcode;
        this.phone = phone;
        DivID = divID;
    }

    /**
     *
     * @return customer ID
     */

    public int getID() {
        return ID;
    }

    /**
     *
     * @param ID
     * set customer ID
     */

    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     *
     * @return customer name
     */

    public String getUsername() {
        return username;
    }

    /**
     *
     * @param username
     * set customer name
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     *
     * @return customer address
     */
    public String getAddress() {
        return address;
    }

    /**
     *
     * @param address
     * set customer address
     */

    public void setAddress(String address) {
        this.address = address;
    }

    /**
     *
     * @return customer postal code
     *
     */
    public String getPostalcode() {
        return postalcode;
    }

    /**
     *
     * @param postalcode
     * set customer postal code
     */

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    /**
     *
     * @return customer phone number
     */
    public String getPhone() {
        return phone;
    }

    /**
     *
     * @param phone
     * set customer phone number
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     *
     * @return customer division ID
     */

    public int getDivID() {
        return DivID;
    }

    /**
     *
     * @param divID
     * set customer division ID
     */

    public void setDivID(int divID) {
        DivID = divID;
    }
}
