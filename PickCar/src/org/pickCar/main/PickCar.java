/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pickCar.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Talenta Pardede
 */
public class PickCar extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent parent = FXMLLoader.load(getClass().getResource("/org/pickCar/view/LayoutHome.fxml"));
        Scene scene = new Scene(parent, 725,575);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
}
