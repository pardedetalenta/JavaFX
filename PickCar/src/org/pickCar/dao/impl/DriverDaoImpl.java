/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pickCar.dao.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import org.pickCar.dao.CustomerDao;
import org.pickCar.dao.DriverDao;
import org.pickCar.model.Customer;
import org.pickCar.model.Driver;
import org.pickCar.util.HibernateUtil;
import org.hibernate.Session;
import org.pickCar.model.Car;

/**
 *
 * @author Talenta Pardede
 */
public class DriverDaoImpl implements DriverDao {

    @Override
    public List<Driver> getAllDriver() {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        List<Driver> myDriver = session.createCriteria(Driver.class).list();
        session.getTransaction().commit();

        return myDriver;
    }

    @Override
    public void setLihat(int idDriver) {
        for (Driver driver : getAllDriver()) {
            if (driver.getIdDriver() == idDriver) {
                Session session = HibernateUtil.getSession();
                session.getTransaction().begin();
                driver.setLihat(1);
                session.update(driver);
                session.getTransaction().commit();
                HibernateUtil.closeSession();
                break;
            }
        }
    }

    @Override
    public void defaultLihat() {
        for (Driver driver : getAllDriver()) {
            if (driver.getLihat() == 1) {
                Session session = HibernateUtil.getSession();
                session.getTransaction().begin();
                driver.setLihat(0);
                session.update(driver);
                session.getTransaction().commit();
                HibernateUtil.closeSession();
                break;
            }
        }
    }

    @Override
    public Driver getDriver(int idDriver) {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        Driver myDriver = (Driver) session.get(Driver.class,idDriver);
        session.getTransaction().commit();

        return myDriver;
    }

    @Override
    public void update(Driver c) {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        session.update(c);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
    }
    
    
    @Override
    public Driver getDriver1(String user) {
        Driver dri = new Driver();
        for (Driver myDri : getAllDriver()) {
            if (myDri.getUsername().equalsIgnoreCase(user)) {
                dri = myDri;
            }
        }
        return dri;
    }


}
