/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pickCar.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.pickCar.dao.LoginDao;
import org.pickCar.dao.impl.LoginDaoImpl;
import org.pickCar.model.Akun;

/**
 *
 * @author Talenta Pardede
 */
public class LoginController {

    @FXML
    private TextField usernameTF;

    @FXML
    private TextField passwordTF;

    @FXML
    private Label invalid_label;
    private LoginDao lDao;
    
    public LoginController() {
        lDao = new LoginDaoImpl();
    }

    @FXML
    private void login(ActionEvent event) throws IOException {
        String username = usernameTF.getText();
        String pass = passwordTF.getText();
        int role = lDao.login(username, pass);
        lDao.updateAkun(username, role);
        if (role == 1) {
            ((Node) (event.getSource())).getScene().getWindow().hide();
            Parent parent = FXMLLoader.load(getClass().getResource("/org/pickCar/view/LayoutHomeCustomer.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.show();
        } else if (role == 2) {
            ((Node) (event.getSource())).getScene().getWindow().hide();
            Parent parent = FXMLLoader.load(getClass().getResource("/org/pickCar/view/LayoutHomeDriver.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.show();
        } else if (role == 0) {
            invalid_label.setVisible(true);
        }

    }
}
