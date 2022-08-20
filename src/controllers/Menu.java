package controllers;

import helper.JDBC;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;


import java.sql.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.TimeZone;




public class Menu {


    private String username;
    private int user_id;


    public static ObservableList<Customer> customers = FXCollections.observableArrayList();


    public static ObservableList<Appointment> appointments = FXCollections.observableArrayList();

    public static ObservableList<String> countries = FXCollections.observableArrayList();
    public static ObservableList<String> divisions = FXCollections.observableArrayList();





    public static ObservableList<Appointment> appointmentsByType = FXCollections.observableArrayList();
    public static ObservableList<Appointment> appointmentsByMonth = FXCollections.observableArrayList();
    public static ObservableList<Appointment> appointmentsByContact = FXCollections.observableArrayList();
    public static ObservableList<Appointment> appointmentsByCreated = FXCollections.observableArrayList();




    @FXML
    Label userLabel;
    @FXML
    Label zoneLabel;
    @FXML
    Label userLabel1;
    @FXML
    Label zoneLabel1;
    @FXML
    Label userLabel2;
    @FXML
    Label zoneLabel2;
    @FXML
    Label userLabel3;
    @FXML
    Label zoneLabel3;
    @FXML
    Label userLabel4;
    @FXML
    Label zoneLabel4;
    @FXML
    Label userLabel5;
    @FXML
    Label zoneLabel5;
    @FXML
    Label eventLabel;
    @FXML
    Label errorOverLabel;



    @FXML
    TableView customerView;

    @FXML
    TableView appointmentView;

    @FXML
    TextField searchField;
    @FXML
    DatePicker dateSearch;


    @FXML
    RadioButton allRadio;
    @FXML
    RadioButton weekRadio;
    @FXML
    RadioButton customerRadio;
    @FXML
    RadioButton monthRadio;



    @FXML
    TableColumn column1;
    @FXML
    TableColumn column2;
    @FXML
    TableColumn column3;
    @FXML
    TableColumn column4;
    @FXML
    TableColumn column5;
    @FXML
    TableColumn column6;
    @FXML
    TableColumn column7;
    @FXML
    TableColumn column8;
    @FXML
    TableColumn column9;
    @FXML
    TableColumn column10;
    @FXML
    TableColumn column11;
    @FXML
    TableColumn column12;
    @FXML
    TableColumn column13;
    @FXML
    TableColumn column14;
    @FXML
    TableColumn column15;


    @FXML
    TabPane tabPane;

    @FXML
    Tab overTab;
    @FXML
    Tab addcTab;
    @FXML
    Tab modcTab;
    @FXML
    Tab addpTab;
    @FXML
    Tab modpTab;
    @FXML
    Tab reportTab;


    //Elements from the add Customer tab
    @FXML
    TextField cName;
    @FXML
    TextField cAddress;
    @FXML
    TextField cPostal;
    @FXML
    TextField cPhone;
    @FXML
    ComboBox<String> cCountry;
    @FXML
    ComboBox<String> cState;
    @FXML
    Label errorAddcLabel;

    //Elements from update customer
    @FXML
    TextField idcField;
    @FXML
    TextField cName2;
    @FXML
    TextField cAddress2;
    @FXML
    TextField cPostal2;
    @FXML
    TextField cPhone2;
    @FXML
    ComboBox<String> cCountry2;
    @FXML
    ComboBox<String> cState2;
    @FXML
    Label errorModcLabel;


    //Elements from the add Appointment tab
    @FXML
    TextField cCustomer;
    @FXML
    TextField cUser;
    @FXML
    TextField cTitle;
    @FXML
    TextField cDescription;
    @FXML
    ComboBox<String> cType;
    @FXML
    ComboBox<String> cCountry3;
    @FXML
    ComboBox<String> cState3;
    @FXML
    ComboBox<String> cContacto;
    @FXML
    DatePicker cStart;
    @FXML
    DatePicker cEnd;
    @FXML
    ComboBox<String> cHH;
    @FXML
    ComboBox<String> cMM;
    @FXML
    ComboBox<String> cSS;
    @FXML
    ComboBox<String> cHH2;
    @FXML
    ComboBox<String> cMM2;
    @FXML
    ComboBox<String> cSS2;
    @FXML
    Label errorAddpLabel;


    //Elements from Modify appointment tab
    @FXML
    TextField cCustomer2;
    @FXML
    TextField cUser2;
    @FXML
    TextField cTitle2;
    @FXML
    TextField cDescription2;
    @FXML
    ComboBox<String> cType2;
    @FXML
    ComboBox<String> cCountry4;
    @FXML
    ComboBox<String> cState4;
    @FXML
    ComboBox<String> cContacto2;
    @FXML
    DatePicker cStart2;
    @FXML
    DatePicker cEnd2;
    @FXML
    ComboBox<String> cHH3;
    @FXML
    ComboBox<String> cMM3;
    @FXML
    ComboBox<String> cSS3;
    @FXML
    ComboBox<String> cHH4;
    @FXML
    ComboBox<String> cMM4;
    @FXML
    ComboBox<String> cSS4;
    @FXML
    Label errorModpLabel;

    //Elements from the report tab section
    @FXML
    ComboBox<String> cAType;
    @FXML
    ComboBox<String> cAMonth;
    @FXML
    ComboBox <String> cAContact;
    @FXML
    ComboBox <String> cACreated;

    @FXML
    Label labelAType;
    @FXML
    Label labelAMonth;
    @FXML
    Label labelAContact;
    @FXML
    Label labelACreated;


    @FXML
    TableView aTypeView;
    @FXML
    TableView aMonthView;
    @FXML
    TableView aContactView;
    @FXML
    TableView aCreatedView;

    @FXML
    TableColumn column16;
    @FXML
    TableColumn column17;
    @FXML
    TableColumn column18;
    @FXML
    TableColumn column19;
    @FXML
    TableColumn column20;
    @FXML
    TableColumn column21;
    @FXML
    TableColumn column22;
    @FXML
    TableColumn column23;
    @FXML
    TableColumn column24;
    @FXML
    TableColumn column25;
    @FXML
    TableColumn column26;
    @FXML
    TableColumn column27;
    @FXML
    TableColumn column28;
    @FXML
    TableColumn column29;
    @FXML
    TableColumn column30;
    @FXML
    TableColumn column31;
    @FXML
    TableColumn column32;
    @FXML
    TableColumn column33;
    @FXML
    TableColumn column34;
    @FXML
    TableColumn column35;
    @FXML
    TableColumn column36;
    @FXML
    TableColumn column37;
    @FXML
    TableColumn column38;
    @FXML
    TableColumn column39;
    @FXML
    TableColumn column40;
    @FXML
    TableColumn column41;
    @FXML
    TableColumn column42;
    @FXML
    TableColumn column43;
    @FXML
    TableColumn column44;
    @FXML
    TableColumn column45;
    @FXML
    TableColumn column46;
    @FXML
    TableColumn column47;
    @FXML
    TableColumn column48;
    @FXML
    TableColumn column49;
    @FXML
    TableColumn column50;
    @FXML
    TableColumn column51;


    /**
     *
     * @param username
     * @param zone
     * @param user_id
     * setting the username and user's zone data
     */
    @FXML
    public void setData(String username, String zone, int user_id){
        this.username = username;
        this.user_id = user_id;
        userLabel.setText("Username: " + username);
        zoneLabel.setText("Zone ID: " + zone);
        userLabel1.setText("Username: " + username);
        zoneLabel1.setText("Zone ID: " + zone);
        userLabel2.setText("Username: " + username);
        zoneLabel2.setText("Zone ID: " + zone);
        userLabel3.setText("Username: " + username);
        zoneLabel3.setText("Zone ID: " + zone);
        userLabel4.setText("Username: " + username);
        zoneLabel4.setText("Zone ID: " + zone);
        userLabel5.setText("Username: " + username);
        zoneLabel5.setText("Zone ID: " + zone);




    }


    @FXML
    private void cancel(){
        tabPane.getSelectionModel().select(overTab);
        overTab.setDisable(false);
        addcTab.setDisable(true);
        addpTab.setDisable(true);
        modcTab.setDisable(true);
        modpTab.setDisable(true);
    }


    //Setting the radio buttons
    @FXML
    private void radioClick(ActionEvent e){
      RadioButton r = (RadioButton)  e.getSource();
      String text = r.getText();

      if(text.equalsIgnoreCase("view all")){
          allRadio.setSelected(true);
          customerRadio.setSelected(false);
          weekRadio.setSelected(false);
          monthRadio.setSelected(false);
          searchField.setVisible(false);
          dateSearch.setVisible(false);
          dateSearch.setValue(null);
          searchField.setText("");

      }else if(text.equalsIgnoreCase("By Week(Mon -> Fri)")){
          allRadio.setSelected(false);
          customerRadio.setSelected(false);
          weekRadio.setSelected(true);
          monthRadio.setSelected(false);
          dateSearch.setVisible(true);
          searchField.setVisible(false);
          appointmentView.refresh();
      }else if(text.equalsIgnoreCase("By Customer")){
          allRadio.setSelected(false);
          customerRadio.setSelected(true);
          weekRadio.setSelected(false);
          monthRadio.setSelected(false);
          dateSearch.setVisible(false);
          searchField.setVisible(true);
          searchField.setText("");
          appointmentView.refresh();
      }else if(text.equalsIgnoreCase("By Month")){
          allRadio.setSelected(false);
          customerRadio.setSelected(false);
          weekRadio.setSelected(false);
          monthRadio.setSelected(true);
          dateSearch.setVisible(true);
          searchField.setVisible(false);
          appointmentView.refresh();
      }

    }

    /**
     *Appointment remainder alert box
     */
    @FXML
    public void appointmentRemainder(){
        LocalDateTime localTime = LocalDateTime.now();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        boolean remainder = false;

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.getDialogPane().setMinWidth(500);
        alert.setTitle("Appointment remainder");
        alert.setHeaderText("Upcoming Appointments");
        alert.setContentText("Upcoming appointments: \n");

        for(int x = 0; x < appointments.size(); x++){

            //formatting the date to the system time zone for the appointment start time

            LocalDateTime localDateTime = appointments.get(x).getStart();




            if(localDateTime.getMonth().equals(localTime.getMonth()) &&
            localDateTime.getDayOfMonth() == localTime.getDayOfMonth()){

                double appointmentHour = (localDateTime.getHour() * 60) +
                        (localDateTime.getMinute()) + (localDateTime.getSecond()/60);
                double timeNow = (localTime.getHour() * 60) +
                        (localTime.getMinute()) + (localTime.getSecond()/60);

                if(appointmentHour - timeNow <= 15 && appointmentHour - timeNow > 0){
                    eventLabel.setText("There are appointments coming up: ");
                    alert.setContentText(alert.getContentText() + "Appointment ID: " +
                            appointments.get(x).getID() + ", Start Date: " +
                            appointments.get(x).getStart().toString() + ", End Date: " +
                            appointments.get(x).getEnd().toString() + "\n");
                    alert.setContentText(alert.getContentText() + "------------------------------\n");
                    remainder = true;
                }
            }



        }

        if(!remainder){
            alert.setContentText("there are no upcoming appointments");
        }

        alert.showAndWait().ifPresent(rs -> {
            if (rs == ButtonType.OK) {
                alert.close();

            }
        });

    }









    @FXML
    private void addCustomerWind(){
        //Setting the forms
        tabPane.getSelectionModel().select(addcTab);
        overTab.setDisable(true);
        addcTab.setDisable(false);
        cName.setText("");
        cAddress.setText("");
        cCountry.setValue(countries.get(0));
        cState.setValue(divisions.get(0));
        cPostal.setText("");
        cPhone.setText("");

    }

    @FXML
    private void addCustomer() throws SQLException{

        cState.setPromptText("");

        cCountry.setPromptText("Select a country");

        //Adding customer to database
        try {

            if (!cName.getText().trim().isEmpty() && !cAddress.getText().trim().isEmpty() &&
                    cCountry.getValue() != null && !cCountry.equals("Select a country") && !cCountry.getValue().trim().isEmpty()
                    && !cPostal.getText().trim().isEmpty() &&
                    !cPhone.getText().trim().isEmpty() && !cState.getValue().trim().isEmpty()) {


                String query = " insert into customers (Customer_Name, Address, Postal_Code, Phone, Create_Date, Created_By, Last_Update, Last_Updated_By, Division_ID)"
                        + " values (?, ?, ?, ?, ?, ?, ?, ?, ?)";


                String s = (String) cState.getValue();
                String[] ss = s.split("\\.");


                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                OffsetDateTime now = OffsetDateTime.now(ZoneOffset.UTC);
                String dd = dtf.format(now);


                PreparedStatement preparedStmt = JDBC.connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                preparedStmt.setString(1, cName.getText());
                preparedStmt.setString(2, cAddress.getText());
                preparedStmt.setString(3, cPostal.getText());
                preparedStmt.setString(4, cPhone.getText());
                preparedStmt.setString(5, dd);
                preparedStmt.setString(6, this.username);
                preparedStmt.setString(7, dd);
                preparedStmt.setString(8, this.username);
                preparedStmt.setInt(9, Integer.parseInt(ss[0]));


                preparedStmt.executeUpdate();
                ResultSet rs = preparedStmt.getGeneratedKeys();



                if(rs.next()){
                    customers.add(new Customer(rs.getInt(1),
                            cName.getText(), cAddress.getText(),
                            cPostal.getText(), cPhone.getText(),
                            Integer.parseInt(ss[0])));
                }

                //Reseting the values and going back to the overview tab


                errorOverLabel.setVisible(true);
                errorOverLabel.setText("Customer added successfully");
                errorAddcLabel.setVisible(false);
                tabPane.getSelectionModel().select(overTab);
                addcTab.setDisable(true);
                overTab.setDisable(false);

            } else {
                errorAddcLabel.setVisible(true);
                errorAddcLabel.setText("One of the field(s) is empty");
            }
        }catch(Exception e){
            errorAddcLabel.setVisible(true);
            errorAddcLabel.setText("Invalid Format");

        }

    }


    //Opening the update customer tab
    @FXML
    private void updateCustomerWind(){
        Customer c = (Customer) customerView.getSelectionModel().getSelectedItem();

        if(c == null){

            errorOverLabel.setVisible(true);
            errorOverLabel.setText("Select a customer to continue");
        }else{
            tabPane.getSelectionModel().select(modcTab);
            overTab.setDisable(true);
            modcTab.setDisable(false);

            idcField.setText(String.valueOf(c.getID()));
            cName2.setText(c.getUsername());
            cAddress2.setText(c.getAddress());
            cPostal2.setText(c.getPostalcode());
            cPhone2.setText(c.getPhone());

            int divID = c.getDivID();


            for(int x = 0; x < cState2.getItems().size(); x++){
                if(cState2.getItems().get(x).contains(divID + "."))
                {
                    cState2.getSelectionModel().select(x);
                    break;
                }
            }

            try{
                String query = "SELECT * FROM first_level_divisions WHERE Division_ID = ?";
                PreparedStatement myStmt = JDBC.connection.prepareStatement(query);
                myStmt.setInt(1, c.getDivID());
                ResultSet myRs= myStmt.executeQuery();
                ;

                if(myRs.next()){
                    query = "SELECT * FROM countries WHERE Country_ID = ?";
                     myStmt = JDBC.connection.prepareStatement(query);
                    myStmt.setInt(1, myRs.getInt("Country_ID"));
                     myRs= myStmt.executeQuery();

                     if(myRs.next()){
                         cCountry2.setValue(myRs.getInt("Country_ID") + "." + myRs.getString("Country"));
                     }
                }

                for(int x = 0; x < divisions.size(); x++){
                    String[] stringArr = divisions.get(x).split("\\.");
                    if(c.getDivID() == Integer.parseInt(stringArr[0])){
                        cState2.setValue(c.getDivID() + "." + stringArr[1]);
                        break;
                    }
                }


            }catch(SQLException e){
                System.out.println(e.getMessage());
            }

        }


    }



    //Update customer
    @FXML
    private void updateCustomer() throws SQLException{
        Customer c = (Customer) customerView.getSelectionModel().getSelectedItem();

        try {


            if (!cName2.getText().trim().isEmpty() && !cAddress2.getText().trim().isEmpty() &&
                    cCountry2.getValue() != null && !cCountry2.equals("Select a country")
                    && !cPostal2.getText().trim().isEmpty() &&
                    !cPhone2.getText().trim().isEmpty() && !cCountry2.getValue().trim().isEmpty() &&
            !cState2.getValue().trim().isEmpty()) {

                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                OffsetDateTime now = OffsetDateTime.now(ZoneOffset.UTC);
                String dd = dtf.format(now);

                String s = (String) cState2.getValue();
                String[] ss = s.split("\\.");

                String query = "update customers set Customer_ID = ?, Customer_Name = ?," +
                        " Address = ?, Postal_Code = ?, Phone = ?, Last_Update = ?," +
                        " Last_Updated_By = ?, Division_ID = ? where Customer_ID = ?";

                PreparedStatement preparedStmt = JDBC.connection.prepareStatement(query);
                preparedStmt.setInt(1, c.getID());
                preparedStmt.setString(2, cName2.getText());
                preparedStmt.setString(3, cAddress2.getText());
                preparedStmt.setString(4, cPostal2.getText());
                preparedStmt.setString(5, cPhone2.getText());
                preparedStmt.setString(6, dd);
                preparedStmt.setString(7, username);
                preparedStmt.setInt(8, Integer.parseInt(ss[0]));
                preparedStmt.setInt(9, c.getID());
                preparedStmt.executeUpdate();

                customers.get(customerView.getSelectionModel().getSelectedIndex()).setUsername(cName2.getText());
                customers.get(customerView.getSelectionModel().getSelectedIndex()).setAddress(cAddress2.getText());
                customers.get(customerView.getSelectionModel().getSelectedIndex()).setPostalcode(cPostal2.getText());
                customers.get(customerView.getSelectionModel().getSelectedIndex()).setPhone(cPhone2.getText());
                customers.get(customerView.getSelectionModel().getSelectedIndex()).setDivID(Integer.parseInt(ss[0]));



                tabPane.getSelectionModel().select(overTab);
                modcTab.setDisable(true);
                overTab.setDisable(false);
                errorOverLabel.setVisible(true);
                errorOverLabel.setText("Customer updated succesfully");
                errorModcLabel.setVisible(false);
                customerView.refresh();
            }else{
                errorModcLabel.setVisible(true);
                errorModcLabel.setText("One of the field(s) is empty");
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }



    }

    //Delete customer
    @FXML
    private void deleteCustomer() throws SQLException{
        Customer c = (Customer) customerView.getSelectionModel().getSelectedItem();

        if(c != null){
            String query = "SELECT * FROM appointments WHERE Customer_ID=?";
            PreparedStatement preparedStmt = JDBC.connection.prepareStatement(query);
            preparedStmt.setInt(1, c.getID());
            ResultSet rs = preparedStmt.executeQuery();




            //Deleting customer's appointments

            query = "DELETE FROM appointments WHERE Customer_ID = ?";
            preparedStmt = JDBC.connection.prepareStatement(query);
            preparedStmt.setInt(1, c.getID());
            preparedStmt.execute();





            query = "DELETE FROM customers WHERE Customer_ID=?";
            preparedStmt = JDBC.connection.prepareStatement(query);
            preparedStmt.setInt(1, c.getID());
            preparedStmt.execute();
            int id = 0;

            for(int x = 0; x < customers.size(); x++){
                if(customers.get(x).getID() == c.getID()){
                    id = customers.get(x).getID();
                    customers.remove(x);
                    break;
                }
            }

            for(int x =0; x < appointments.size(); x++){
                if(appointments.get(x).getCutomerID() == id){
                    appointments.remove(x);
                }
            }





            errorOverLabel.setVisible(true);
            errorOverLabel.setText("customer deleted successfully! USER ID: " + id);




        }else{
            errorOverLabel.setVisible(true);
            errorOverLabel.setText("Select a customer to delete");


        }

    }

    //Opening Add Appointment tab
    @FXML
    private void addAppointmentWind(){

        Customer c = (Customer) customerView.getSelectionModel().getSelectedItem();

        if(c != null){
            overTab.setDisable(true);
            tabPane.getSelectionModel().select(addpTab);
            addpTab.setDisable(false);
            cCustomer.setText(String.valueOf(c.getID()));
            cUser.setText(String.valueOf(user_id));
            cTitle.setText("");
            cDescription.setText("");
            cStart.getEditor().clear();
            cEnd.getEditor().clear();
            cHH.setValue("00");
            cMM.setValue("00");
            cSS.setValue("00");
            cHH2.setValue("00");
            cMM2.setValue("00");
            cSS2.setValue("00");
            cCountry3.setValue(countries.get(0));
            cState3.setValue(divisions.get(0));

            cContacto.getItems().clear();

            try{
                String query = "SELECT * FROM contacts";
                Statement st = JDBC.connection.createStatement();
                ResultSet rs = st.executeQuery(query);

                while(rs.next()){
                    cContacto.getItems().add(rs.getInt("Contact_ID") + "-" + rs.getString("Contact_Name"));
                }


                if(cContacto.getItems().size() > 0){
                    cContacto.setValue(cContacto.getItems().get(0));
                }



            }catch(SQLException error){
                System.out.println(error.getMessage());

            }

        }else{
            System.out.println("Select a customer");
            errorOverLabel.setVisible(true);
            errorOverLabel.setText("Select a customer to continue");

        }



    }

    @FXML
    private void addAppointment() throws SQLException{


        if(!cTitle.getText().isEmpty() && !cDescription.getText().isEmpty() && cType.getValue() != null
        &&  cCountry3.getValue() != null &&
                !cCountry3.getValue().equalsIgnoreCase("select a country") &&
                cCountry3.getValue().trim().length() != 0 && cState3.getValue().trim().length() != 0 &&
                cContacto.getValue() != null && cStart.getValue() != null && cEnd.getValue() != null &&
                cHH.getValue() != null && cMM.getValue() != null && cSS.getValue() != null &&
                cHH2.getValue() != null && cMM2.getValue() != null && cSS2.getValue() != null){


            //getting the values of datepicker as string
            String dayOfWeekstart = cStart.getValue().getDayOfWeek().toString();
            String dayOfWeekend = cEnd.getValue().getDayOfWeek().toString();


            //getting the value of the datepickers and hours,minutes and seconds comboboxes as string
            String dateStart = cStart.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + " "
                    + (cHH.getValue())+ ":" + cMM.getValue() + ":" + cSS.getValue();

            String dateEnd =  cEnd.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + " "
                    + (cHH2.getValue())+ ":" + cMM2.getValue() + ":" + cSS2.getValue();


            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

            //formatting the date to the system time zone for the appointment start time
            LocalDateTime localDateTime = LocalDateTime.parse (dateStart,dtf);
            ZoneId zoneId = ZoneId.systemDefault();
            ZonedDateTime zdtNewYork = ZonedDateTime.of ( localDateTime , zoneId );

            //Parsing the date to ETC/UTC to store it on the database
            ZonedDateTime zdt = zdtNewYork.withZoneSameInstant(ZoneId.of ("Etc/UTC"));

            //Parsing the date to the Office hours in EST Timezone
            ZonedDateTime zddt = zdtNewYork.withZoneSameInstant(ZoneId.of ( "America/New_York" ));



            //formatting the date to the system time zone for the appointment end time
            LocalDateTime localDateTime1 = LocalDateTime.parse (dateEnd,dtf);
            ZoneId zoneId1 = ZoneId.systemDefault();
            ZonedDateTime zdtNewYork1 = ZonedDateTime.of ( localDateTime1 , zoneId1 );

            //Parsing the date to ETC/UTC to store it on the database
            ZonedDateTime zdt1 = zdtNewYork1.withZoneSameInstant(ZoneId.of ("Etc/UTC"));

            //Parsing the date to the Office hours in EST Timezone
            ZonedDateTime zddt1 = zdtNewYork1.withZoneSameInstant(ZoneId.of ( "America/New_York" ));


            double hour1 = (zddt.getHour() * 60) + zddt.getMinute() + (zddt.getSecond()/100);
            double hour2 = (zddt1.getHour() * 60) + zddt1.getMinute() + (zddt1.getSecond()/100);


            if(!dayOfWeekstart.equalsIgnoreCase("saturday") &&
                    !dayOfWeekstart.equalsIgnoreCase("SUNDAY") &&
                    !dayOfWeekend.equalsIgnoreCase("SATURDAY") &&
                    !dayOfWeekend.equalsIgnoreCase("SUNDAY") &&
                    hour1 <= 1320 && hour1 >= 480 && hour2 <= 1320 && hour2 >= 480
                    && hour1 < hour2 && dayOfWeekstart.compareTo(dayOfWeekend) <= 0 && zddt.isBefore(zddt1)){


                //Mysql query
                String checker = "SELECT * FROM appointments";

                PreparedStatement preparedStmt = JDBC.connection.prepareStatement(checker);
                ResultSet rs = preparedStmt.executeQuery();


                LocalDateTime refStart = null;
                LocalDateTime refEnd = null;

                while(rs.next()){
                    try {

                         refStart = LocalDateTime.parse(rs.getString(6), dtf);

                         refEnd = LocalDateTime.parse(rs.getString(7), dtf);



                        if ((refStart.isEqual(zdt.toLocalDateTime()) || refEnd.isEqual(zdt1.toLocalDateTime())) ||
                                (zdt.toLocalDateTime().isAfter(refStart) && zdt1.toLocalDateTime().isBefore(refEnd)) ||
                                (zdt.toLocalDateTime().isAfter(refStart) && zdt.toLocalDateTime().isBefore(refEnd)) ||
                                (zdt1.toLocalDateTime().isAfter(refStart) && zdt1.toLocalDateTime().isBefore(refEnd))){
                            errorAddpLabel.setVisible(true);
                            errorAddpLabel.setText("Appointment overlaps with another appointment");
                            return;
                        }



                    }catch(Exception e){
                        System.out.println(e);
                    }

                }




                String query = " insert into appointments (Title, Description, Location, Type, Start, End, Create_Date," +
                        " Created_By, Last_Update, Last_Updated_By, Customer_ID, User_ID, Contact_ID)"
                        + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                preparedStmt = JDBC.connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);


                OffsetDateTime now = OffsetDateTime.now(ZoneOffset.UTC);
                String dd = dtf.format(now);

                String stringArr[] = cContacto.getValue().split("-");


                preparedStmt.setString(1, cTitle.getText());
                preparedStmt.setString(2, cDescription.getText());
                preparedStmt.setString(3, cCountry3.getValue() + "," + cState3.getValue());
                preparedStmt.setString(4, cType.getValue());
                preparedStmt.setString(5, zdt.toLocalDateTime().toString());
                preparedStmt.setString(6, zdt1.toLocalDateTime().toString());
                preparedStmt.setString(7, dd);
                preparedStmt.setString(8, username);
                preparedStmt.setString(9,dd);
                preparedStmt.setString(10, username);
                preparedStmt.setInt(11, Integer.parseInt(cCustomer.getText()));
                preparedStmt.setInt(12, Integer.parseInt(cUser.getText()));
                preparedStmt.setInt(13, Integer.parseInt(stringArr[0]));

                preparedStmt.executeUpdate();
                ResultSet rss = preparedStmt.getGeneratedKeys();

                if(rss.next()){
                    appointments.add(new Appointment(rss.getInt(1), cTitle.getText(),
                            Integer.parseInt(cCustomer.getText()), Integer.parseInt(stringArr[0]),
                            cDescription.getText(), cCountry3.getValue() +
                            "," + cState3.getValue(), cType.getValue(), zdtNewYork.toLocalDateTime(),
                            zdtNewYork1.toLocalDateTime(), username));
                }


                addpTab.setDisable(true);
                tabPane.getSelectionModel().select(overTab);
                overTab.setDisable(false);
                cCustomer.setText("");
                cUser.setText("");
                cTitle.setText("");
                cDescription.setText("");
                cState3.setValue("");
                cContacto.getItems().clear();
                cStart.getEditor().clear();
                cEnd.getEditor().clear();
                cHH.getItems().clear();
                cMM.getItems().clear();
                cSS.getItems().clear();
                cHH2.getItems().clear();
                cMM2.getItems().clear();
                cSS2.getItems().clear();
                errorAddpLabel.setVisible(false);

            }else{

                if(zddt1.isBefore(zddt)){
                    errorAddpLabel.setVisible(true);
                    errorAddpLabel.setText("End Date can't be earlier than Start date");

                }else{
                    errorAddpLabel.setVisible(true);
                    errorAddpLabel.setText("Can't assign appointment out of business hour");
                }

            }

        }else{
            errorAddpLabel.setVisible(true);
            errorAddpLabel.setText("One of the field(s) is empty");
        }


    }

    @FXML
    private void updateAppointmentWind(){
        Appointment appointment = (Appointment) appointmentView.getSelectionModel().getSelectedItem();

        if(appointment != null){
            String[] loc = appointment.getLocation().split(",");
            LocalDate s = appointment.getStart().toLocalDate();
            LocalDate e = appointment.getEnd().toLocalDate();
            cContacto2.getItems().clear();


            modpTab.setDisable(false);
            tabPane.getSelectionModel().select(modpTab);
            overTab.setDisable(true);
            cCustomer2.setText(String.valueOf(appointment.getCutomerID()));
            cUser2.setText(String.valueOf(user_id));
            cTitle2.setText(appointment.getTitle());
            cDescription2.setText(appointment.getDescription());
            if(loc.length >= 2){
                cCountry4.setValue(loc[0]);
                cState4.setValue(loc[1]);
            }

            //Setting the value of the hours, minutes and seconds

            cStart2.setValue(s);
            cEnd2.setValue(e);
            cType2.setValue(appointment.getType());

            cHH3.setValue(String.valueOf(appointment.getStart().getHour()));
            cHH4.setValue(String.valueOf(appointment.getEnd().getHour()));
            cMM3.setValue(String.valueOf(appointment.getStart().getMinute()));
            cMM4.setValue(String.valueOf(appointment.getEnd().getMinute()));
            cSS3.setValue(String.valueOf(appointment.getStart().getSecond()));
            cSS4.setValue(String.valueOf(appointment.getEnd().getSecond()));

            if(Integer.parseInt(cHH3.getValue()) < 10){
                cHH3.setValue("0" + cHH3.getValue());
            }

            if(Integer.parseInt(cHH4.getValue()) < 10){
                cHH4.setValue("0" + cHH4.getValue());
            }

            if(Integer.parseInt(cMM3.getValue()) < 10){
                cMM3.setValue("0" + cMM3.getValue());
            }

            if(Integer.parseInt(cMM4.getValue()) < 10){
                cMM4.setValue("0" + cMM4.getValue());
            }

            if(Integer.parseInt(cSS3.getValue()) < 10){
                cSS3.setValue("0" + cSS3.getValue());
            }

            if(Integer.parseInt(cSS4.getValue()) < 10){    cSS4.setValue("0" + cSS4.getValue());}


            //Populating the contact combobox
            cContacto2.getItems().clear();
            int x = 0;
            try{
                String query = "SELECT * FROM contacts";
                Statement st = JDBC.connection.createStatement();
                ResultSet rs = st.executeQuery(query);

                while(rs.next()){
                    cContacto2.getItems().add(rs.getInt("Contact_ID") + "-" + rs.getString("Contact_Name"));
                    if(appointment.getContactID() == rs.getInt("Contact_ID")){
                        cContacto2.setValue(cContacto2.getItems().get(x));
                    }

                    x++;
                }

            }catch(SQLException error){
                System.out.println(error.getMessage());

            }

        }else{

                errorOverLabel.setVisible(true);
                errorOverLabel.setText("Select an appointment to continue");
        }




    }



    @FXML
    private void updateAppointment() throws SQLException{
        Appointment a = (Appointment) appointmentView.getSelectionModel().getSelectedItem();

        if(!cTitle2.getText().isEmpty() && !cDescription2.getText().isEmpty() && cType2.getValue() != null
                &&  cCountry4.getValue() != null &&
                !cCountry4.getValue().equalsIgnoreCase("Select a country") &&
                cCountry4.getValue().trim().length() != 0 &&
                cContacto2.getValue() != null && cStart2.getValue() != null && cEnd2.getValue() != null &&
                cHH3.getValue() != null && cMM3.getValue() != null && cSS3.getValue() != null &&
                cHH4.getValue() != null && cMM4.getValue() != null && cSS4.getValue() != null){


            //getting the values of the datepickers as strings
            String dayOfWeekstart = cStart2.getValue().getDayOfWeek().toString();
            String dayOfWeekend = cEnd2.getValue().getDayOfWeek().toString();


            //getting the value of the datepickers and hours,minutes and seconds comboboxes as string
            String dateStart = cStart2.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + " "
                    + (cHH3.getValue())+ ":" + cMM3.getValue() + ":" + cSS3.getValue();

            String dateEnd =  cEnd2.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + " "
                    + (cHH4.getValue())+ ":" + cMM4.getValue() + ":" + cSS4.getValue();



            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

            //formatting the date to the system time zone for the appointment start time
            LocalDateTime localDateTime = LocalDateTime.parse (dateStart,dtf);
            ZoneId zoneId = ZoneId.systemDefault();
            ZonedDateTime zdtNewYork = ZonedDateTime.of ( localDateTime , zoneId );

            //Parsing the date to ETC/UTC to store it on the database
            ZonedDateTime zdt = zdtNewYork.withZoneSameInstant(ZoneId.of ("Etc/UTC"));

            //Parsing the date to the Office hours in EST Timezone
            ZonedDateTime zddt = zdtNewYork.withZoneSameInstant(ZoneId.of ( "America/New_York" ));


            //formatting the date to the system time zone for the appointment end time
            LocalDateTime localDateTime1 = LocalDateTime.parse (dateEnd,dtf);
            ZoneId zoneId1 = ZoneId.systemDefault();
            ZonedDateTime zdtNewYork1 = ZonedDateTime.of ( localDateTime1 , zoneId1 );

            //Parsing the date to ETC/UTC to store it on the database
            ZonedDateTime zdt1 = zdtNewYork1.withZoneSameInstant(ZoneId.of ("Etc/UTC"));

            //Parsing the date to the Office hours in EST Timezone
            ZonedDateTime zddt1 = zdtNewYork1.withZoneSameInstant(ZoneId.of ( "America/New_York" ));



            double hour1 = (zddt.getHour() * 60) + zddt.getMinute() + (zddt.getSecond()/100);
            double hour2 = (zddt1.getHour() * 60) + zddt1.getMinute() + (zddt1.getSecond()/100);

            if(!dayOfWeekstart.equalsIgnoreCase("SATURDAY") &&
                    !dayOfWeekstart.equalsIgnoreCase("SUNDAY") &&
                    !dayOfWeekend.equalsIgnoreCase("SATURDAY") &&
                    !dayOfWeekend.equalsIgnoreCase("SUNDAY") &&
                    hour1 <= 1320 && hour1 >= 480 && hour2 <= 1320 && hour2 >= 480
                    && hour1 < hour2 && dayOfWeekstart.compareTo(dayOfWeekend) <= 0 && zddt.isBefore(zddt1)){

                String checker = "SELECT * FROM appointments";

                PreparedStatement preparedStmt = JDBC.connection.prepareStatement(checker);
                ResultSet rs = preparedStmt.executeQuery();


                LocalDateTime refStart = null;
                LocalDateTime refEnd = null;


                while(rs.next()){
                    try {

                        refStart = LocalDateTime.parse(rs.getString(6), dtf);

                        refEnd = LocalDateTime.parse(rs.getString(7), dtf);


                        if ((refStart.isEqual(zdt.toLocalDateTime()) || refEnd.isEqual(zdt1.toLocalDateTime())) ||
                                (zdt.toLocalDateTime().isAfter(refStart) && zdt1.toLocalDateTime().isBefore(refEnd)) ||
                                (zdt.toLocalDateTime().isAfter(refStart) && zdt.toLocalDateTime().isBefore(refEnd)) ||
                                (zdt1.toLocalDateTime().isAfter(refStart) && zdt1.toLocalDateTime().isBefore(refEnd))){
                            if(rs.getInt(1) != a.getID()){

                                errorModpLabel.setVisible(true);
                                errorModpLabel.setText("Appointment overlaps with another appointment");
                                return;

                            }

                        }

                    }catch(Exception e){
                        System.out.println(e);
                    }

                }


                String query = "update appointments set Title = ?, Description = ?, Location = ?, " +
                        "Type = ?, Start = ?, End = ?, Last_Update = ?, Last_Updated_By = ?, Contact_ID = ?" +
                        " where Appointment_ID = ?";
                preparedStmt = JDBC.connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);



                String stringArr[] = cContacto2.getValue().split("-");

                OffsetDateTime now = OffsetDateTime.now(ZoneOffset.UTC);
                String dd = dtf.format(now);
                preparedStmt.setString(1, cTitle2.getText());
                preparedStmt.setString(2, cDescription2.getText());
                preparedStmt.setString(3, cCountry4.getValue() + "," + cState4.getValue());
                preparedStmt.setString(4, cType2.getValue());
                preparedStmt.setString(5, zdt.toLocalDateTime().toString());
                preparedStmt.setString(6, zdt1.toLocalDateTime().toString());
                preparedStmt.setString(7, dd);
                preparedStmt.setString(8, username);
                preparedStmt.setInt(9, Integer.parseInt(stringArr[0]));
                preparedStmt.setInt(10, a.getID());

                preparedStmt.executeUpdate();

                for(int x = 0; x < appointments.size(); x++){
                    if(appointments.get(x).getID() == a.getID()){
                        appointments.get(x).setTitle(cTitle2.getText());
                        appointments.get(x).setDescription(cDescription2.getText());
                        appointments.get(x).setLocation(cCountry4.getValue() + "," + cState4.getValue());
                        appointments.get(x).setType(cType2.getValue());
                        appointments.get(x).setStart(localDateTime);
                        appointments.get(x).setEnd(localDateTime1);
                        appointments.get(x).setContactID(Integer.parseInt(stringArr[0]));
                        break;
                    }
                }

                tabPane.getSelectionModel().select(overTab);
                overTab.setDisable(false);
                modpTab.setDisable(true);
                errorOverLabel.setVisible(true);
                errorOverLabel.setText("Appointment updated successfully");
                errorModpLabel.setVisible(false);
                appointmentView.refresh();



            }else{
                if(zddt1.isBefore(zddt)){
                    errorModpLabel.setVisible(true);
                    errorModpLabel.setText("End Date can't be earlier than Start date");

                }else{
                    errorModpLabel.setVisible(true);
                    errorModpLabel.setText("Can't assign appointment out of business hour");
                }
            }


            }else{
            errorModpLabel.setVisible(true);
            errorModpLabel.setText("One of the field(s) is empty");
            }

    }

    @FXML
    private void deleteAppointment() throws SQLException{
        Appointment a = (Appointment) appointmentView.getSelectionModel().getSelectedItem();
        if(a != null){
            String query = "delete from appointments where Appointment_ID = ?";
            PreparedStatement preparedStmt = JDBC.connection.prepareStatement(query);
            preparedStmt.setInt(1, a.getID());
            preparedStmt.execute();

            String type = "";
            int id = 0;

            for(int x = 0; x < appointments.size(); x++){
                if(appointments.get(x).getID() == a.getID()){
                    id = appointments.get(x).getID();
                    type = appointments.get(x).getType();
                    appointments.remove(x);
                    break;
                }
            }

            errorOverLabel.setVisible(true);
            errorOverLabel.setText("appointment deleted successfully! ID: " + id + " TYPE: " + type);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.getDialogPane().setMinWidth(500);
            alert.setTitle("Action");
            alert.setHeaderText("Appointment deleted succesfully");
            alert.setContentText("Appointment ID: " +  id  + "\n" + "Appointment Type: " + type);
            alert.showAndWait();

        }else{
            errorOverLabel.setVisible(true);
            errorOverLabel.setText("You must select an appointment to delete it");
        }

    }


    /**
     * Lambda
     * @param e
     * method to search appointments by type
     * Lambda let you write code for anonymous methods, you can refer to the code easily so it can be pass around the program.
     */
    @FXML
    public void lookupByType(ActionEvent e){
        appointmentsByType.clear();

        appointments.forEach(
                (app) ->{if(app.getType().equals(cAType.getValue())){
                    appointmentsByType.add(app);
                }}
        );
        labelAType.setText("Count: " + appointmentsByType.size());
    }

    /**
     * Lambda
     * @param e
     *Lambda will help to write the methods using  less lines of code, which will make the code easier to read.
     */
    @FXML
    public void lookupByMonth(ActionEvent e){
        appointmentsByMonth.clear();


        appointments.forEach(
                (app) ->{ if(app.getStart().getMonth().toString().equalsIgnoreCase(cAMonth.getValue())){
                    appointmentsByMonth.add(app);
                }}
        );

        labelAMonth.setText("Count: " + appointmentsByMonth.size());

    }

    /**
     * Lambda
     * @param e
     * method to search appointments by contact
     * Lambda will achieve higher efficiency in the code due to its parallel execution
     */

    @FXML
    public void lookupByContact(ActionEvent e) throws SQLException{
        appointmentsByContact.clear();
        if(cAContact.getValue() == null){
            return;
        }
        String[] stringArr = cAContact.getValue().split("\\.");


        appointments.forEach(
                (app) ->{if(app.getContactID() == Integer.parseInt(stringArr[0])){
                    appointmentsByContact.add(app);
                }}
        );

        labelAContact.setText("Count: " + appointmentsByContact.size());

    }


    /**
     * Lambda
     * @param e
     * method to search appointments created by certain user
     * Lambda will help as a callback parameter inside a method
     */
    @FXML
    public void lookupByCreated(ActionEvent e){
        appointmentsByCreated.clear();
        if(cACreated.getValue() == null){
            return;
        }
        String[] stringArr = cACreated.getValue().split("\\.");

        appointments.forEach(

                (app) ->{if(app.getCreated().equals(cACreated.getValue().split("\\.")[1])){
                    appointmentsByCreated.add(app);

                }}
        );

        labelACreated.setText("Count: " + appointmentsByCreated.size());

    }

    @FXML
    private void initialize(){

        //defining the values of each cell of the customer view on the overview tab
        column1.setCellValueFactory(new PropertyValueFactory<Customer,Integer>("ID"));
        column2.setCellValueFactory(new PropertyValueFactory<Customer,String>("username"));
        column3.setCellValueFactory(new PropertyValueFactory<Customer,String>("address"));
        column4.setCellValueFactory(new PropertyValueFactory<Customer,String>("postalcode"));
        column5.setCellValueFactory(new PropertyValueFactory<Customer,String>("phone"));
        column6.setCellValueFactory(new PropertyValueFactory<Customer,Integer>("DivID"));

        //Defining columns for the appointment Tableview on the overview tab
        column7.setCellValueFactory(new PropertyValueFactory<Appointment,Integer>("ID"));
        column8.setCellValueFactory(new PropertyValueFactory<Appointment,Integer>("cutomerID"));
        column9.setCellValueFactory(new PropertyValueFactory<Appointment,Integer>("contactID"));
        column10.setCellValueFactory(new PropertyValueFactory<Appointment,String>("description"));
        column11.setCellValueFactory(new PropertyValueFactory<Appointment,String>("location"));
        column12.setCellValueFactory(new PropertyValueFactory<Appointment,String>("title"));
        column13.setCellValueFactory(new PropertyValueFactory<Appointment,LocalDateTime>("start"));
        column14.setCellValueFactory(new PropertyValueFactory<Appointment,LocalDateTime>("end"));
        column15.setCellValueFactory(new PropertyValueFactory<Appointment,String>("type"));

        //Defining columns for the appointment by type in the report tab

        column16.setCellValueFactory(new PropertyValueFactory<Appointment,Integer>("ID"));
        column17.setCellValueFactory(new PropertyValueFactory<Appointment,Integer>("cutomerID"));
        column18.setCellValueFactory(new PropertyValueFactory<Appointment,Integer>("contactID"));
        column19.setCellValueFactory(new PropertyValueFactory<Appointment,String>("description"));
        column20.setCellValueFactory(new PropertyValueFactory<Appointment,String>("location"));
        column21.setCellValueFactory(new PropertyValueFactory<Appointment,String>("title"));
        column22.setCellValueFactory(new PropertyValueFactory<Appointment,LocalDateTime>("start"));
        column23.setCellValueFactory(new PropertyValueFactory<Appointment,LocalDateTime>("end"));
        column24.setCellValueFactory(new PropertyValueFactory<Appointment,String>("type"));


        //Defining columns for the appointment by month in the report tab
        column25.setCellValueFactory(new PropertyValueFactory<Appointment,Integer>("ID"));
        column26.setCellValueFactory(new PropertyValueFactory<Appointment,Integer>("cutomerID"));
        column27.setCellValueFactory(new PropertyValueFactory<Appointment,Integer>("contactID"));
        column28.setCellValueFactory(new PropertyValueFactory<Appointment,String>("description"));
        column29.setCellValueFactory(new PropertyValueFactory<Appointment,String>("location"));
        column30.setCellValueFactory(new PropertyValueFactory<Appointment,String>("title"));
        column31.setCellValueFactory(new PropertyValueFactory<Appointment,LocalDateTime>("start"));
        column32.setCellValueFactory(new PropertyValueFactory<Appointment,LocalDateTime>("end"));
        column33.setCellValueFactory(new PropertyValueFactory<Appointment,String>("type"));

        //Defining columns for the appointment by contact in the report tab
        column34.setCellValueFactory(new PropertyValueFactory<Appointment,Integer>("ID"));
        column35.setCellValueFactory(new PropertyValueFactory<Appointment,Integer>("cutomerID"));
        column36.setCellValueFactory(new PropertyValueFactory<Appointment,Integer>("contactID"));
        column37.setCellValueFactory(new PropertyValueFactory<Appointment,String>("description"));
        column38.setCellValueFactory(new PropertyValueFactory<Appointment,String>("location"));
        column39.setCellValueFactory(new PropertyValueFactory<Appointment,String>("title"));
        column40.setCellValueFactory(new PropertyValueFactory<Appointment,LocalDateTime>("start"));
        column41.setCellValueFactory(new PropertyValueFactory<Appointment,LocalDateTime>("end"));
        column42.setCellValueFactory(new PropertyValueFactory<Appointment,String>("type"));

        //Defining columns for the custom appointment report
        column43.setCellValueFactory(new PropertyValueFactory<Appointment,Integer>("ID"));
        column44.setCellValueFactory(new PropertyValueFactory<Appointment,Integer>("cutomerID"));
        column45.setCellValueFactory(new PropertyValueFactory<Appointment,Integer>("contactID"));
        column46.setCellValueFactory(new PropertyValueFactory<Appointment,String>("description"));
        column47.setCellValueFactory(new PropertyValueFactory<Appointment,String>("location"));
        column48.setCellValueFactory(new PropertyValueFactory<Appointment,String>("title"));
        column49.setCellValueFactory(new PropertyValueFactory<Appointment,LocalDateTime>("start"));
        column50.setCellValueFactory(new PropertyValueFactory<Appointment,LocalDateTime>("end"));
        column51.setCellValueFactory(new PropertyValueFactory<Appointment,String>("type"));




        //Setting value for the type comboboxes
        cType.getItems().add("Planning Session");
        cType.getItems().add("De-Briefing");
        cType.getItems().add("Atmosphere");
        cType.setValue("Planning Session");

        cType2.getItems().add("Planning Session");
        cType2.getItems().add("De-Briefing");
        cType2.getItems().add("Atmosphere");
        cType2.setValue("Planning Session");


        //Setting the value of the countries, divisions and hours


        try{
            String query = "SELECT * FROM countries";
            Statement stmt = JDBC.connection.createStatement();
            ResultSet rs =  stmt.executeQuery(query);

            while(rs.next()){
                countries.add(rs.getInt("Country_ID") + "." + rs.getString("Country"));
            }

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }



        cCountry.setOnAction(e -> {
            try{
                cState.getItems().clear();
                divisions.removeAll();
                String[] stringArr = cCountry.getValue().split("\\.");
                String query = "SELECT * FROM first_level_divisions WHERE Country_ID = ?";
                PreparedStatement ps = JDBC.connection.prepareStatement(query);
                ps.setInt(1, Integer.parseInt(stringArr[0]));
                ResultSet myRs= ps.executeQuery();

                while(myRs.next()){
                    divisions.add(myRs.getInt("Division_ID") + "." + myRs.getString("Division"));
                }

                cState.setItems(divisions);
                cState.setValue(cState.getItems().get(0));

            }catch(SQLException error){
                System.out.println(error.getMessage());
            }

        });


        cCountry2.setOnAction(e -> {
            try{
                cState2.getItems().clear();
                divisions.removeAll();
                String[] stringArr = cCountry2.getValue().split("\\.");
                String query = "SELECT * FROM first_level_divisions WHERE Country_ID = ?";
                PreparedStatement ps = JDBC.connection.prepareStatement(query);
                ps.setInt(1, Integer.parseInt(stringArr[0]));
                ResultSet myRs= ps.executeQuery();

                while(myRs.next()){
                    divisions.add(myRs.getInt("Division_ID") + "." + myRs.getString("Division"));
                }
                cState2.setItems(divisions);
                cState2.setValue(cState2.getItems().get(0));
            }catch(SQLException error){
                System.out.println(error.getMessage());
            }
        });

        cCountry3.setOnAction(e -> {
            try{
                cState3.getItems().clear();
                divisions.removeAll();
                String[] stringArr = cCountry3.getValue().split("\\.");
                String query = "SELECT * FROM first_level_divisions WHERE Country_ID = ?";
                PreparedStatement ps = JDBC.connection.prepareStatement(query);
                ps.setInt(1, Integer.parseInt(stringArr[0]));
                ResultSet myRs= ps.executeQuery();

                while(myRs.next()){
                    divisions.add(myRs.getInt("Division_ID") + "." + myRs.getString("Division"));
                }
                cState3.setItems(divisions);
                cState3.setValue(cState3.getItems().get(0));

            }catch(SQLException error){
                System.out.println(error.getMessage());
            }
        });

        cCountry4.setOnAction(e -> {
            try{
                cState4.getItems().clear();
                divisions.removeAll();
                String[] stringArr = cCountry4.getValue().split("\\.");
                String query = "SELECT * FROM first_level_divisions WHERE Country_ID = ?";
                PreparedStatement ps = JDBC.connection.prepareStatement(query);
                ps.setInt(1, Integer.parseInt(stringArr[0]));
                ResultSet myRs= ps.executeQuery();

                while(myRs.next()){
                    divisions.add(myRs.getInt("Division_ID") + "." + myRs.getString("Division"));
                }
                cState4.setItems(divisions);
                cState4.setValue(cState4.getItems().get(0));

            }catch(SQLException error){
                System.out.println(error.getMessage());
            }
        });



        //Setting values for the HOUR,MINUTE,SECOND comboboxes
        for(int x = 0; x <= 23; x++){
            if(x < 10){
                cHH.getItems().add("0" + x);
                cHH2.getItems().add("0" + x);
                cHH3.getItems().add("0" + x);
                cHH4.getItems().add("0" + x);

            }else{
                cHH.getItems().add(String.valueOf(x));
                cHH2.getItems().add(String.valueOf(x));
                cHH3.getItems().add(String.valueOf(x));
                cHH4.getItems().add(String.valueOf(x));
            }


        }

        for(int x = 0; x <= 59; x++){
            if(x < 10){
                cMM.getItems().add("0" + x);
                cMM2.getItems().add("0" + x);
                cMM3.getItems().add("0" + x);
                cMM4.getItems().add("0" + x);

            }else{
                cMM.getItems().add(String.valueOf(x));
                cMM2.getItems().add(String.valueOf(x));
                cMM3.getItems().add(String.valueOf(x));
                cMM4.getItems().add(String.valueOf(x));
            }

        }

        for(int x = 0; x <= 59; x++){
            if(x < 10){
                cSS.getItems().add("0" + x);
                cSS2.getItems().add("0" + x);
                cSS3.getItems().add("0" + x);
                cSS4.getItems().add("0" + x);

            }else{
                cSS.getItems().add(String.valueOf(x));
                cSS2.getItems().add(String.valueOf(x));
                cSS3.getItems().add(String.valueOf(x));
                cSS4.getItems().add(String.valueOf(x));
            }

        }

        cHH.setValue("00");
        cHH2.setValue("00");
        cMM.setValue("00");
        cMM2.setValue("00");
        cSS.setValue("00");
        cSS2.setValue("00");




        //setting values for month
        cAMonth.getItems().setAll("JANUARY", "FEBRUARY", "MARCH", "APRIL", "MAY", "JUNE", "JULY",
                "AUGUST", "SEPTEMBER", "OCTOBER", "NOVEMBER", "DECEMBER");

        cAType.getItems().setAll("Planning Session", "De-Briefing", "Atmosphere");



        //Executing query when we select the report tab
        tabPane.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> ov, Number oldValue, Number newValue) {
                if(newValue.equals(5)){
                    try {
                        cAContact.getItems().clear();
                        cACreated.getItems().clear();

                        String query = "SELECT Contact_ID, Contact_Name FROM contacts";
                        Statement st = JDBC.connection.createStatement();
                        ResultSet rss = st.executeQuery(query);

                        while (rss.next()) {
                            cAContact.getItems().add(rss.getInt(1) +  "." +
                                    rss.getString(2));
                        }

                        query = "SELECT User_ID, User_Name from users";
                        st = JDBC.connection.createStatement();
                        rss = st.executeQuery(query);
                        while(rss.next()){
                            cACreated.getItems().add(rss.getInt(1) + "." +
                                    rss.getString(2));
                        }
                        labelAContact.setText("Count: 0");
                        labelACreated.setText("Count: 0");

                    }catch(SQLException e){
                        System.out.println(e.getMessage());
                    }
                }
            }
        });






        //getting the values from the database
        try{
            String query = "SELECT * FROM customers";
            Statement st = JDBC.connection.createStatement();
            ResultSet rs = st.executeQuery(query);

            while(rs.next()){
                customers.add(new Customer(rs.getInt("Customer_ID"),
                        rs.getString("Customer_Name"), rs.getString("Address"),
                        rs.getString("Postal_Code"), rs.getString("Phone"),
                        rs.getInt("Division_ID")));
            }



            /*Populating the Appointment Tableview
                Below

             */

            query = "SELECT * FROM appointments";
            st = JDBC.connection.createStatement();
            rs = st.executeQuery(query);

             while(rs.next()){

                 LocalDateTime ldt = rs.getTimestamp("Start").toLocalDateTime();

                 LocalDateTime ldt1 = rs.getTimestamp("End").toLocalDateTime();
                 appointments.add(new Appointment(rs.getInt("Appointment_ID"),
                         rs.getString("Title"), rs.getInt("Customer_ID"),
                         rs.getInt("Contact_ID"), rs.getString("Description"),
                         rs.getString("Location"), rs.getString("Type"),
                         ldt, ldt1, rs.getString("Created_By")));

             }

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }


        //Filtering the search field on the overview tab
        FilteredList<Appointment> filteredID = new FilteredList<>(appointments, s -> true);

        //Filtering for the view all and view by customer radio button
        searchField.textProperty().addListener(obs->{
            String filter = searchField.getText().toLowerCase();

            //if the view appoinments by customer radio button is selected
            if(customerRadio.isSelected()){
                if(filter == null || filter.length() == 0) {
                    filteredID.setPredicate(s -> true);

                }
                else {
                    filteredID.setPredicate(s -> String.valueOf(s.getCutomerID()).toLowerCase().contains(filter));
                    appointmentView.setItems(filteredID);

                }

                //if the view all radio button is selected
            }else if(allRadio.isSelected()){
                filteredID.setPredicate(s -> true);
            }

        });

        dateSearch.valueProperty().addListener(obs -> {
            LocalDate date = dateSearch.getValue();


            if(date == null){
                filteredID.setPredicate(s -> true);
            }else{
                //filtering by month
                if(monthRadio.isSelected()){

                    filteredID.setPredicate(s -> date.getMonth().equals(s.getStart().getMonth()));
                    appointmentView.setItems(filteredID);
                    //Filtering by week
                }else if(weekRadio.isSelected()){

                    filteredID.setPredicate(s -> ChronoUnit.WEEKS.between(date, s.getStart().toLocalDate()) == 0);

                    appointmentView.setItems(filteredID);

                }
            }

        });


        customerView.setItems(customers);
        appointmentView.setItems(appointments);
        aTypeView.setItems(appointmentsByType);
        aMonthView.setItems(appointmentsByMonth);
        aContactView.setItems(appointmentsByContact);
        aCreatedView.setItems(appointmentsByCreated);

        cCountry.setItems(countries);
        cCountry2.setItems(countries);
        cCountry3.setItems(countries);
        cCountry4.setItems(countries);
        cCountry.setPromptText("Select a Country");
        cCountry2.setPromptText("Select a Country");
        cCountry3.setPromptText("Select a Country");
        cCountry4.setPromptText("Select a Country");

    }

}
