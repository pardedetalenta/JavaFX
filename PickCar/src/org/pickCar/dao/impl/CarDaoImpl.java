/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pickCar.dao.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.pickCar.dao.CarDao;
import org.pickCar.model.Car;
import org.pickCar.util.HibernateUtil;

/**
 *
 * @author Talenta Pardede
 */
public class CarDaoImpl implements CarDao {

    private String URL;

    @Override
    public List<Car> getAllCar() {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        List<Car> myCar = session.createCriteria(Car.class).list();
        session.getTransaction().commit();
        return myCar;
    }

    @Override
    public Car getCar(int idMobil) {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        Car myCar = (Car) session.get(Car.class, idMobil);
        session.getTransaction().commit();
        HibernateUtil.closeSession();

        return myCar;
    }

    @Override
    public List<Car> getSearchCar(String origin, String destination, int pass, int availability) {
        List<Car> car = new ArrayList<>();
        for (Car myCar : getAllCar()) {
            if (myCar.getOrigin().equalsIgnoreCase(origin) && myCar.getDestination().equalsIgnoreCase(destination) && myCar.getKapasitas() > pass) {
                car.add(myCar);
            }
        }
        return car;
    }

    @Override
    public void setLihat(int idMobil) {
        for (Car car : getAllCar()) {
            if (car.getIdMobil() == idMobil) {
                Session session = HibernateUtil.getSession();
                session.getTransaction().begin();
                car.setLihat(1);
                session.update(car);
                session.getTransaction().commit();
                HibernateUtil.closeSession();
                break;
            }
        }
    }

    @Override
    public void defaultLihat() {
        for (Car car : getAllCar()) {
            if (car.getLihat() == 1) {
                Session session = HibernateUtil.getSession();
                session.getTransaction().begin();
                car.setLihat(0);
                session.update(car);
                session.getTransaction().commit();
                HibernateUtil.closeSession();
                break;
            }
        }
    }

    @Override
    public List<Car> getFilter(String myClas, int availability) {
        List<Car> car = new ArrayList<>();
        for (Car myCar : getAllCar()) {
            if (myCar.getClass1().equalsIgnoreCase(myClas) && myCar.getAvailability() == 1) {
                car.add(myCar);
            }
        }
        return car;
    }

    @Override
    public void update(Car c) {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        session.update(c);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
    }

    @Override
    public List<Car> getAvailability(int available) {
        List<Car> car = new ArrayList<>();
        for (Car myCar : getAllCar()) {
            if (myCar.getAvailability() == 1) {
                car.add(myCar);
            }
        }
        return car;
    }
}
