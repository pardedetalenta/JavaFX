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
import org.pickCar.dao.CustomerDao;
import org.pickCar.dao.DriverDao;
import org.pickCar.dao.LoginDao;
import org.pickCar.dao.PesananDao;
import org.pickCar.dao.impl.CarDaoImpl;
import org.pickCar.dao.impl.CustomerDaoImpl;
import org.pickCar.dao.impl.DriverDaoImpl;
import org.pickCar.dao.impl.LoginDaoImpl;
import org.pickCar.dao.impl.PesananDaoImpl;
import org.pickCar.model.Car;
import org.pickCar.model.Driver;
import org.pickCar.model.Pesanan;

/**
 * FXML Controller class
 *
 * @author Talenta Pardede
 */
public class DetailCustomerController implements Initializable {

    @FXML
    private Label driverl;
    @FXML
    private Label kapasitas;
    @FXML
    private Label tipe;
    @FXML
    private TextField idMTF;
    @FXML
    private ImageView foto;
    @FXML
    private Label fasilitas;
    @FXML
    private Label fasilitas1;

    @FXML
    private Label tunggu;
    @FXML
    private TextField alamatTF;

    CarDao cDao;
    DriverDao dDao;
    PesananDao pDao;
    LoginDao lDao;
    public DetailCustomerController() {
        cDao = new CarDaoImpl();
        dDao = new DriverDaoImpl();
        pDao = new PesananDaoImpl();
        lDao = new LoginDaoImpl();
    }

    /**
     * Initializes the controller class.
     */
    @FXML
    public void detail(ActionEvent event) throws IOException {
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

    @FXML
    public void pesan(ActionEvent event) throws IOException {

        String a = (String) alamatTF.getText();
        int b = Integer.parseInt(idMTF.getText());
        String c = lDao.getUser();
        Pesanan p = new Pesanan(0, c, a, 1, b);
        pDao.saveData(p);
        tunggu.setText("Tunggu Konfirmasi Driver");
    }

}
