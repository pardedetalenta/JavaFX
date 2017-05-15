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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.pickCar.dao.CarDao;
import org.pickCar.dao.DriverDao;
import org.pickCar.dao.LoginDao;
import org.pickCar.dao.PesananDao;
import org.pickCar.dao.impl.CarDaoImpl;
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
public class LayoutHomeDriverController implements Initializable {

    @FXML
    private TableView<Pesanan> pesanTB;
    @FXML
    private TableColumn<Pesanan, Integer> idTB;
    @FXML
    private TableColumn<Pesanan, Integer> idPesanTB;
    @FXML
    private TableColumn<Pesanan, String> alamatTB;
    @FXML
    private TableColumn<Pesanan, String> namaTB;
    @FXML
    private TextField idMbl;
    @FXML
    private TextField idPesanan;
    @FXML
    private Label idgue;
    @FXML
    private Label idmobil;
    @FXML
    private Label antar;
    PesananDao pDao;
    CarDao cDao;
    LoginDao lDao;
    DriverDao dDao;
    ObservableList<Pesanan> myPesanan;

    /**
     * Initializes the controller class.
     */
    public LayoutHomeDriverController() {
        pDao = new PesananDaoImpl();
        cDao = new CarDaoImpl();
        dDao = new DriverDaoImpl();
        pesanTB = new TableView<>();
        lDao = new LoginDaoImpl();

    }

    public void load() {
        String a = lDao.getUser();
        Driver d = dDao.getDriver1(a);
        int c = d.getIdDriver();
        List<Pesanan> pesan = pDao.getStatus(1);

        myPesanan = FXCollections.observableArrayList(pesan);
        idPesanTB.setCellValueFactory(new PropertyValueFactory<Pesanan, Integer>("idPesanan"));
        namaTB.setCellValueFactory(new PropertyValueFactory<Pesanan, String>("namaPemesan"));
        idTB.setCellValueFactory(new PropertyValueFactory<Pesanan, Integer>("idMobil"));
        alamatTB.setCellValueFactory(new PropertyValueFactory<Pesanan, String>("alamatJemput"));
        pesanTB.setItems(myPesanan);
    }

    public void loadMyCar() {
        String a = lDao.getUser();
        Driver d = dDao.getDriver1(a);
        int c = d.getIdDriver();
        List<Pesanan> pesan = pDao.getMe(c, 1);
        myPesanan = FXCollections.observableArrayList(pesan);
        idPesanTB.setCellValueFactory(new PropertyValueFactory<Pesanan, Integer>("idPesanan"));
        namaTB.setCellValueFactory(new PropertyValueFactory<Pesanan, String>("namaPemesan"));
        idTB.setCellValueFactory(new PropertyValueFactory<Pesanan, Integer>("idMobil"));
        alamatTB.setCellValueFactory(new PropertyValueFactory<Pesanan, String>("alamatJemput"));
        pesanTB.setItems(myPesanan);
    }

    @FXML
    private void logout(ActionEvent event) throws IOException {
        System.out.println("You clicked me!");
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("/org/pickCar/view/LayoutLogin.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }

    @FXML
    public void pick() {
        loadMyCar();

    }

    @FXML
    public void ambil() {
        String q = lDao.getUser();
        Driver d = dDao.getDriver1(q);
        int idDri = d.getIdDriver();
        int a = Integer.parseInt(idPesanan.getText());
        Pesanan pesan = pDao.getData(a);
        int cek = pesan.getIdMobil();
        if (idDri == cek) {
            pesan.setStatus(0);
            pDao.updateData(pesan);
            int b = pesan.getIdMobil();
            Car car = cDao.getCar(b);
            car.setAvailability(0);
            cDao.update(car);
            antar.setText("Silahkan Antar Customer Anda!!");
            myPesanan.remove(pesan);
        } else {
            antar.setText("Bukan mobil anda");
        }

    }

    @FXML
    public void my(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow();
        Parent parentDari = FXMLLoader.load(getClass().getResource("/org/pickCar/view/AkunDetail.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(parentDari);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        load();
        String a = lDao.getUser();
        Driver d = dDao.getDriver1(a);
        idgue.setText(d.getIdDriver().toString());
    }

}
