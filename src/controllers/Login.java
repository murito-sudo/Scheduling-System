package controllers;


import com.company.Main;
import helper.JDBC;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.TimeZone;


public class Login {


    private TimeZone tz1 = TimeZone.getDefault();

    @FXML
    TextField userField;

    @FXML
    PasswordField passwordField;

    @FXML
    Label errorLabel;

    @FXML
    Label zoneLabel;

    File myObj = new File("login_activity.txt");




    @FXML
    private void logUser(ActionEvent event) throws Exception {

        FileWriter myWriter = new FileWriter("login_activity.txt", true);
        LocalDateTime localTime = LocalDateTime.now(ZoneOffset.UTC);

        PreparedStatement prest = JDBC.connection.prepareStatement("SELECT * FROM users  WHERE User_Name=? AND Password=?");

        prest.setString(1,userField.getText());
        prest.setString(2,passwordField.getText());
        ResultSet rs = prest.executeQuery();



        if(rs.next()){

            try{
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/inf/menu.fxml"));
                Parent root = fxmlLoader.load();
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

                Scene scene = new Scene(root);

                stage.setScene(scene);
                Menu md = fxmlLoader.getController();
                md.setData(userField.getText(), tz1.getID(), rs.getInt(1));
                md.appointmentRemainder();

                myWriter.write("|Username: " + userField.getText() + "| Password: "
                        + passwordField.getText() + "| Date: " + localTime.toString() + "| Status: Successful");
                myWriter.write("\r\n");
                myWriter.close();

                stage.show();


            }catch(IOException e){
                System.out.println(e.getMessage());
            }

        }else{
            myWriter.write("|Username: " + userField.getText() + "| Password: "
                    + passwordField.getText() + "| Date: " + localTime.toString() + "| Status: Failure");
            myWriter.write("\r\n");
            myWriter.close();

            errorLabel.setVisible(true);
            errorLabel.setText(Main.rb.getString("Label"));


        }


    }

    @FXML
    private void initialize() throws IOException {


        zoneLabel.setText("Zone: " + tz1.getID());
        if (myObj.createNewFile()) {
            System.out.println("login_activity file created" + myObj.getName());
        } else {
            System.out.println("login_activity file already exist");
        }
    }

}
