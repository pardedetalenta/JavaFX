package org.pickCar.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import org.pickCar.model.Customer;

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

import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import org.pickCar.dao.CarDao;
import org.pickCar.dao.CustomerDao;
import org.pickCar.dao.impl.signUpDaoImpl;
import org.pickCar.dao.SignUpDao;
import org.pickCar.dao.impl.CarDaoImpl;
import org.pickCar.dao.impl.CustomerDaoImpl;
import org.pickCar.model.Car;
import org.pickCar.model.Driver;

/**
 * FXML Controller class
 *
 * @author Talenta Pardede
 */
public class HomeController implements Initializable {

    @FXML
    private ComboBox<String> originCB;
    @FXML
    private ComboBox<String> destinationCB;
    @FXML
    private ComboBox<String> classCB;
    @FXML
    private ComboBox<String> sortCB;
    @FXML
    private TextField passengerTF;
    @FXML
    private Label isi;
    @FXML
    private TableView<Car> mobilTB;
    @FXML
    private TableColumn<Car, String> classTB;
    @FXML
    private TableColumn<Car, Integer> priceTB;
    @FXML
    private TableColumn<Car, Integer> idMobilTB;
    @FXML
    private TableColumn<Car, String> tipeTB;
    @FXML
    private TableColumn<Car, String> dari;
    @FXML
    private TableColumn<Car, String> tujuan;

    ObservableList<Car> hasilSearch;
    CarDao cDao;

    public HomeController() {
        cDao = new CarDaoImpl();
        mobilTB = new TableView<>();
    }

    public void loadSearch() {
        String ori = (String) originCB.getValue();
        String dest = (String) destinationCB.getValue();
        int pas = Integer.parseInt(passengerTF.getText());
        if (pas > 0) {
            isi.setVisible(false);
        } else {
            isi.setVisible(true);
        }
        List<Car> myCars = cDao.getSearchCar(ori, dest, pas, 1);
        hasilSearch = FXCollections.observableArrayList(myCars);
        idMobilTB.setCellValueFactory(new PropertyValueFactory<Car, Integer>("idMobil"));
        classTB.setCellValueFactory(new PropertyValueFactory<Car, String>("class1"));
        tipeTB.setCellValueFactory(new PropertyValueFactory<Car, String>("tipeMobil"));
        dari.setCellValueFactory(new PropertyValueFactory<Car, String>("origin"));
        tujuan.setCellValueFactory(new PropertyValueFactory<Car, String>("destination"));
        priceTB.setCellValueFactory(new PropertyValueFactory<Car, Integer>("price"));
        mobilTB.setItems(hasilSearch);
    }

    @FXML
    public void loadAll() {
        List<Car> myCars = cDao.getAvailability(1);
        hasilSearch = FXCollections.observableArrayList(myCars);
        idMobilTB.setCellValueFactory(new PropertyValueFactory<Car, Integer>("idMobil"));
        classTB.setCellValueFactory(new PropertyValueFactory<Car, String>("class1"));
        tipeTB.setCellValueFactory(new PropertyValueFactory<Car, String>("tipeMobil"));
        dari.setCellValueFactory(new PropertyValueFactory<Car, String>("origin"));
        tujuan.setCellValueFactory(new PropertyValueFactory<Car, String>("destination"));
        priceTB.setCellValueFactory(new PropertyValueFactory<Car, Integer>("price"));
        mobilTB.setItems(hasilSearch);
    }

    @FXML
    public void loadFilter() {
        String myClass1 = (String) classCB.getValue();
        List<Car> myCars = cDao.getFilter(myClass1, 1);
        hasilSearch = FXCollections.observableArrayList(myCars);
        idMobilTB.setCellValueFactory(new PropertyValueFactory<Car, Integer>("idMobil"));
        classTB.setCellValueFactory(new PropertyValueFactory<Car, String>("class1"));
        tipeTB.setCellValueFactory(new PropertyValueFactory<Car, String>("tipeMobil"));
        priceTB.setCellValueFactory(new PropertyValueFactory<Car, Integer>("price"));
        dari.setCellValueFactory(new PropertyValueFactory<Car, String>("origin"));
        tujuan.setCellValueFactory(new PropertyValueFactory<Car, String>("destination"));
        mobilTB.setItems(hasilSearch);

    }

    @FXML
    private void loginhome(ActionEvent event) throws IOException {
        System.out.println("You clicked me!");

        Parent home_page_parent = FXMLLoader.load(getClass().getResource("/org/pickCar/view/LayoutLogin.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }

    @FXML
    public void signuphome(ActionEvent event) throws IOException {
        System.out.println("You clicked me!");
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("/org/pickCar/view/LayoutFormSignUp.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();
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
    private void detail(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow();
        Parent parentDari = FXMLLoader.load(getClass().getResource("/org/pickCar/view/Detail.fxml"));
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
    }
}
