/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pickCar.dao.impl;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.pickCar.dao.CustomerDao;
import org.pickCar.model.Customer;
import org.pickCar.util.HibernateUtil;
import org.hibernate.Session;
import org.pickCar.model.Car;
import org.pickCar.model.Pesanan;

/**
 *
 * @author Talenta Pardede
 */
public class CustomerDaoImpl implements CustomerDao {

    @Override
    public List<Customer> getAllCustomer() {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        List<Customer> myCustomer = session.createCriteria(Customer.class).list();
        session.getTransaction().commit();
        return myCustomer;
    }

    @Override
    public void setLihat(int idUser) {
        for (Customer customer : getAllCustomer()) {
            if (customer.getIdUser() == idUser) {
                Session session = HibernateUtil.getSession();
                session.getTransaction().begin();
                customer.setLihat(1);
                session.update(customer);
                session.getTransaction().commit();
                HibernateUtil.closeSession();
                break;
            }
        }
    }

    @Override
    public void defaultLihat() {
        for (Customer customer : getAllCustomer()) {
            if (customer.getLihat() == 1) {
                Session session = HibernateUtil.getSession();
                session.getTransaction().begin();
                customer.setLihat(0);
                session.update(customer);
                session.getTransaction().commit();
                HibernateUtil.closeSession();
                break;
            }
        }
    }

    @Override
    public Customer getCusomer(String user) {
        Customer cus = new Customer();
        for (Customer myCus : getAllCustomer()) {
            if (myCus.getUsername().equalsIgnoreCase(user)) {
                cus = myCus;
            }
        }
        return cus;
    }
}
