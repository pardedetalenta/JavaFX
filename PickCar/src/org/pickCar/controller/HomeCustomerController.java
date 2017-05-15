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
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.pickCar.dao.CarDao;
import org.pickCar.dao.LoginDao;
import org.pickCar.dao.impl.CarDaoImpl;
import org.pickCar.dao.impl.LoginDaoImpl;
import org.pickCar.model.Car;

/**
 *
 * @author Talenta Pardede
 */
public class HomeCustomerController implements Initializable {

    @FXML
    private ComboBox<String> originCB;
    @FXML
    private ComboBox<String> destinationCB;
    @FXML
    private ComboBox<String> classCB;
    @FXML
    private TextField passengerTF;
    @FXML
    private TableView<Car> mobilTB;
    @FXML
    private TableColumn<Car, Integer> idTB;
    @FXML
    private TableColumn<Car, String> classTB;
    @FXML
    private TableColumn<Car, Integer> priceTB;
    @FXML
    private TableColumn<Car, String> tipeTB;
    @FXML
    private TableColumn<Car, String> dari;
    @FXML
    private TableColumn<Car, String> tujuan;
    @FXML
    private Label accountLB;

    ObservableList<Car> hasilSearch;
    CarDao cDao;
    LoginDao lDao;
    @FXML
    private Button filter;

    public HomeCustomerController() {
        cDao = new CarDaoImpl();
        lDao = new LoginDaoImpl();
        mobilTB = new TableView<>();
    }

    public void loadSearch() {
        String ori = (String) originCB.getValue();
        String dest = (String) destinationCB.getValue();
        int pas = Integer.parseInt(passengerTF.getText());

        List<Car> myCars = cDao.getSearchCar(ori, dest, pas, 1);
        hasilSearch = FXCollections.observableArrayList(myCars);
        idTB.setCellValueFactory(new PropertyValueFactory<Car, Integer>("idMobil"));
        classTB.setCellValueFactory(new PropertyValueFactory<Car, String>("class1"));
        dari.setCellValueFactory(new PropertyValueFactory<Car, String>("origin"));
        tujuan.setCellValueFactory(new PropertyValueFactory<Car, String>("destination"));
        tipeTB.setCellValueFactory(new PropertyValueFactory<Car, String>("tipeMobil"));
        priceTB.setCellValueFactory(new PropertyValueFactory<Car, Integer>("price"));
        mobilTB.setItems(hasilSearch);

    }

    public void loadAll() {
        List<Car> myCars = cDao.getAvailability(1);
        hasilSearch = FXCollections.observableArrayList(myCars);
        idTB.setCellValueFactory(new PropertyValueFactory<Car, Integer>("idMobil"));
        classTB.setCellValueFactory(new PropertyValueFactory<Car, String>("class1"));
        dari.setCellValueFactory(new PropertyValueFactory<Car, String>("origin"));
        tujuan.setCellValueFactory(new PropertyValueFactory<Car, String>("destination"));
        tipeTB.setCellValueFactory(new PropertyValueFactory<Car, String>("tipeMobil"));
        priceTB.setCellValueFactory(new PropertyValueFactory<Car, Integer>("price"));
        mobilTB.setItems(hasilSearch);
    }

    public void loadFilter() {
        String myClass1 = (String) classCB.getValue();
        List<Car> myCars = cDao.getFilter(myClass1, 1);
        hasilSearch = FXCollections.observableArrayList(myCars);
        idTB.setCellValueFactory(new PropertyValueFactory<Car, Integer>("idMobil"));
        classTB.setCellValueFactory(new PropertyValueFactory<Car, String>("class1"));
        tipeTB.setCellValueFactory(new PropertyValueFactory<Car, String>("tipeMobil"));
        dari.setCellValueFactory(new PropertyValueFactory<Car, String>("origin"));
        tujuan.setCellValueFactory(new PropertyValueFactory<Car, String>("destination"));
        priceTB.setCellValueFactory(new PropertyValueFactory<Car, Integer>("price"));
        mobilTB.setItems(hasilSearch);
    }

    @FXML
    private void logout(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Parent parent = FXMLLoader.load(getClass().getResource("/org/pickCar/view/LayoutLogin.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
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

    @FXML
    public void searchHome(ActionEvent event) throws IOException {
        loadSearch();
    }

    @FXML
    public void all(ActionEvent event) throws IOException {
        loadAll();
    }

    @FXML
    public void filterHome(ActionEvent event) throws IOException {
        loadFilter();
    }

    @FXML
    private void detailHomeCustomer(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow();
        Parent parentDari = FXMLLoader.load(getClass().getResource("/org/pickCar/view/DetailCustomer.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(parentDari);
        stage.setScene(scene);
        stage.show();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ObservableList<String> oriCB = FXCollections.observableArrayList("Tarutung", "Siantar", "Medan", "Sibolga", "Sidikalang");
        originCB.setItems(oriCB);
        ObservableList<String> desCB = FXCollections.observableArrayList("Tarutung", "Siantar", "Medan", "Sibolga", "Sidikalang");
        destinationCB.setItems(desCB);
        ObservableList<String> myClassCB = FXCollections.observableArrayList("First Class", "VVIP", "VIP", "Business Class", "Economy");
        classCB.setItems(myClassCB);
        loadAll();
        accountLB.setText(lDao.getUser());

    }
}
