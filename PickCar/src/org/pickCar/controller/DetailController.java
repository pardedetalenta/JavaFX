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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.pickCar.dao.CarDao;
import org.pickCar.dao.DriverDao;
import org.pickCar.dao.impl.CarDaoImpl;
import org.pickCar.dao.impl.DriverDaoImpl;
import org.pickCar.model.Car;
import org.pickCar.model.Driver;

/**
 * FXML Controller class
 *
 * @author Talenta Pardede
 */
public class DetailController implements Initializable {

    @FXML
    private Label driverl;
    @FXML
    private TextField idMTF;
    @FXML
    private Label kapasitas;
    @FXML
    private Label tipe;
    @FXML
    private Label fasilitas1;

    CarDao cDao;
    DriverDao dDao;
    @FXML
    private Label fasilitas;
    @FXML
    private Label nama;

    public DetailController() {
        cDao = new CarDaoImpl();
        dDao = new DriverDaoImpl();

    }

    /**
     * Initializes the controller class.
     */
    public void detail1(ActionEvent event) throws IOException {
        int id = Integer.parseInt(idMTF.getText());
        Car myCar = cDao.getCar(id);
        Driver driver = dDao.getDriver(id);
        kapasitas.setText(Integer.toString(myCar.getKapasitas()));
        tipe.setText(myCar.getTipeMobil());
        driverl.setText(driver.getNama());
        if (myCar.getClass1().equalsIgnoreCase("VVIP")) {
            fasilitas1.setText("VVIP Fasilitas");
        }
        if (myCar.getClass1().equalsIgnoreCase("VIP")) {
            fasilitas1.setText("VIP Fasilitas");
        }
        if (myCar.getClass1().equalsIgnoreCase("Business Class")) {
            fasilitas1.setText("Business Fasilitas");
        }
        if (myCar.getClass1().equalsIgnoreCase("First Class")) {
            fasilitas1.setText("First Class Fasilitas");
        }
        if (myCar.getClass1().equalsIgnoreCase("Economy")) {
            fasilitas1.setText("Economy Fasilitas");
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
