package com.company;

import helper.JDBC;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import java.util.Locale;
import java.util.ResourceBundle;

public class Main extends Application {

    /**
     *
     * @param args
     */

    static public ResourceBundle rb;

    public static void main(String[] args) {

        JDBC.openConnection();
        launch(args);


    }

    /**
     *
     * @param primaryStage
     * @throws Exception
     */

    @Override
    public void start(Stage primaryStage) throws Exception {






        if(Locale.getDefault().getLanguage().equals("fr")){
            rb = ResourceBundle.getBundle("languages.Nat_fr");

        }else{
            rb = ResourceBundle.getBundle("languages.Nat_en");
        }



        Parent root = FXMLLoader.load(getClass().getResource("/inf/login.fxml"), rb);
        primaryStage.setTitle(rb.getString("SchedulingSystem"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();




        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent t) {
                JDBC.closeConnection();
            }
        });

    }


}
