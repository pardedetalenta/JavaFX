/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pickCar.dao.impl;

import java.util.List;
import org.pickCar.dao.LoginDao;

import org.pickCar.model.Customer;
import org.pickCar.model.Driver;
import org.pickCar.util.HibernateUtil;
import org.hibernate.Session;
import org.pickCar.model.Akun;

/**
 *
 * @author Talenta Pardede
 */
public class LoginDaoImpl implements LoginDao {

    @Override
    public int login(String username, String password) {
        int str = 0;
        CustomerDaoImpl cDao = new CustomerDaoImpl();
        DriverDaoImpl dDao = new DriverDaoImpl();
        List<Customer> myCustomer = cDao.getAllCustomer();
        List<Driver> myDriver = dDao.getAllDriver();
        for (Customer customer : myCustomer) {
            if (customer.getUsername().equalsIgnoreCase(username) && customer.getPassword().equalsIgnoreCase(password)) {
                str = 1;
                break;
            }
        }
        for (Driver driver : myDriver) {
            if (driver.getUsername().equalsIgnoreCase(username) && driver.getPassword().equalsIgnoreCase(password)) {
                str = 2;
                break;
            }
        }
        return str;
    }

    @Override
    public void updateAkun(String user, int role) {
        for (Akun akun : getAllAkun()) {
            if (akun.getId() == 1) {
                Session session = HibernateUtil.getSession();
             
                session.getTransaction().begin();
                akun.setUsername(user);
                akun.setRole(role);
                session.update(akun);
                session.getTransaction().commit();
                HibernateUtil.closeSession();
            } 
        }
    }

    @Override
    public List<Akun> getAllAkun() {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        List<Akun> akuns = session.createCriteria(Akun.class).list();
        session.getTransaction().commit();
        return akuns;
    }

    @Override
    public int getRole() {
        int str = 0;
        for (Akun akun : getAllAkun()) {
            if (akun.getId() == 1) {
                str = akun.getRole();
                break;
            }
        }
        return str;
    }

    @Override
    public String getUser() {
        String user = null;
        for (Akun akun : getAllAkun()) {
            if (akun.getId() == 1) {
                user = akun.getUsername();
                break;
            }
        }
        return user;
    }

}
