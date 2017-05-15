/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pickCar.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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
import org.pickCar.model.Customer;
import org.pickCar.model.Driver;
import org.pickCar.model.Pesanan;

/**
 * FXML Controller class
 *
 * @author Talenta Pardede
 */
public class AkunDetailController implements Initializable {

    @FXML
    private Label namanya;
    @FXML
    private Label telah;
    @FXML
    private Label alamat;
    @FXML
    private Label nohp;
    @FXML
    private Label lab;
    @FXML
    private Button but;
    @FXML
    private Button nona;
    @FXML
    private TableView<Pesanan> pesananTB;
    @FXML
    private TableColumn<Pesanan, Integer> idPesanTB;
    @FXML
    private TableColumn<Pesanan, Integer> idMobilTB;
    @FXML
    private TableColumn<Pesanan, String> alamatTB;
    @FXML
    private TableColumn<Pesanan, String> namaTB;
    @FXML
    private ComboBox<String> originCB;
    @FXML
    private ComboBox<String> destinationCB;
    LoginDao lDao;
    PesananDao pDao;
    CustomerDao cDao;
    DriverDao dDao;
    CarDao mDao;
    ObservableList<Pesanan> myPesanan;

    public AkunDetailController() {
        lDao = new LoginDaoImpl();
        pDao = new PesananDaoImpl();
        cDao = new CustomerDaoImpl();
        dDao = new DriverDaoImpl();
        mDao = new CarDaoImpl();
    }

    public void loadForDriver() {
        String a = lDao.getUser();

        Driver dri = dDao.getDriver1(a);
        int ad = dri.getIdDriver();
        List<Pesanan> pesan = pDao.getMe(ad, 0);
        myPesanan = FXCollections.observableArrayList(pesan);
        idPesanTB.setCellValueFactory(new PropertyValueFactory<Pesanan, Integer>("idPesanan"));
        namaTB.setCellValueFactory(new PropertyValueFactory<Pesanan, String>("namaPemesan"));
        alamatTB.setCellValueFactory(new PropertyValueFactory<Pesanan, String>("alamatJemput"));
        pesananTB.setItems(myPesanan);
    }

    public void loadForCustomer() {
        String a = lDao.getUser();

        Customer dri = cDao.getCusomer(a);
        String ad = dri.getUsername();
        List<Pesanan> pesan = pDao.getMeCustomer(ad, 0);
        myPesanan = FXCollections.observableArrayList(pesan);
        idMobilTB.setCellValueFactory(new PropertyValueFactory<Pesanan, Integer>("idMobil"));
        idPesanTB.setCellValueFactory(new PropertyValueFactory<Pesanan, Integer>("idPesanan"));
        namaTB.setCellValueFactory(new PropertyValueFactory<Pesanan, String>("namaPemesan"));
        alamatTB.setCellValueFactory(new PropertyValueFactory<Pesanan, String>("alamatJemput"));
        pesananTB.setItems(myPesanan);
    }

    @FXML
    public void available(ActionEvent event) throws IOException {
        String ori = originCB.getValue();
        String dest = destinationCB.getValue();
        String a = lDao.getUser();

        Driver dri = dDao.getDriver1(a);
        int idnya = dri.getIdDriver();
        Car car = mDao.getCar(idnya);
        car.setAvailability(1);
        car.setOrigin(ori);
        car.setDestination(dest);
        mDao.update(car);
        telah.setVisible(true);

    }

    @FXML
    public void non(ActionEvent event) throws IOException {

        String a = lDao.getUser();

        Driver dri = dDao.getDriver1(a);
        int idnya = dri.getIdDriver();
        Car car = mDao.getCar(idnya);
        car.setAvailability(0);

        mDao.update(car);

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String a = lDao.getUser();
        int r = lDao.getRole();
        if (r == 1) {
            Customer cus = cDao.getCusomer(a);
            namanya.setText(cus.getNama());
            alamat.setText(cus.getAlamat());
            nohp.setText(cus.getNoHp());

            idMobilTB.setVisible(true);
            loadForCustomer();
        }
        if (r == 2) {
            Driver dri = dDao.getDriver1(a);
            namanya.setText(dri.getNama());
            alamat.setText(dri.getAlamat());
            nohp.setText(dri.getNohp());
            ObservableList<String> oriCB = FXCollections.observableArrayList("Tarutung", "Siantar", "Medan", "Sibolga", "Sidikalang");
            originCB.setItems(oriCB);
            ObservableList<String> desCB = FXCollections.observableArrayList("Tarutung", "Siantar", "Medan", "Sibolga", "Sidikalang");
            destinationCB.setItems(desCB);
            originCB.setVisible(true);
            destinationCB.setVisible(true);
            loadForDriver();
            nona.setVisible(true);
            but.setVisible(true);

        }

    }

}
