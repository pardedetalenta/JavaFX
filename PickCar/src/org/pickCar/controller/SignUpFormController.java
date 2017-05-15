/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pickCar.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.pickCar.dao.SignUpDao;
import org.pickCar.dao.impl.signUpDaoImpl;
import org.pickCar.model.Customer;

/**
 *
 * @author Talenta Pardede
 */
public class SignUpFormController implements Initializable {

    @FXML
    private TextField namaTF;
    @FXML
    private TextField alamatTF;
    @FXML
    private TextField noHPTF;
    @FXML
    private TextField passwordTF;
    @FXML
    private TextField usernameTF;

    private SignUpDao suDao;
    @FXML
    private Button daftarkan;

    public SignUpFormController() {
        suDao = new signUpDaoImpl();
    }

    public void signupform(ActionEvent event) throws IOException {
        System.out.println("Mandaftar ");
        Customer myCustomer = new Customer();
        myCustomer.setIdUser(0);
        myCustomer.setNama(namaTF.getText());
        myCustomer.setAlamat(alamatTF.getText());
        myCustomer.setNoHp(noHPTF.getText());
        myCustomer.setUsername(usernameTF.getText());
        myCustomer.setPassword(passwordTF.getText());
        suDao.saveData(myCustomer);
        inisialisiAwalInputan();
        System.out.println("You clicked me!");
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("/org/pickCar/view/LayoutHomeCustomer.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();

    }

    private void inisialisiAwalInputan() {
        namaTF.setText("");
        alamatTF.setText("");
        noHPTF.setText("");
        passwordTF.setText("");
        usernameTF.setText("");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

}
