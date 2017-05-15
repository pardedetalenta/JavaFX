/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pickCar.dao.impl;

import java.util.List;

import org.pickCar.model.Customer;
import org.pickCar.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.Session;
import org.pickCar.dao.SignUpDao;

/**
 *
 * @author Talenta Pardede
 */
public class signUpDaoImpl implements SignUpDao {

    @Override
    public void saveData(Customer myCustomer) {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        session.save(myCustomer);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
    }

    @Override
    public Customer getData(int idUser) {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        Customer myCustomer = (Customer) session.get(Customer.class, idUser);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
        return myCustomer;
    }

    @Override
    public void deleteData(int idUser) {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        Customer myCustomer = (Customer) session.get(Customer.class, idUser);
        session.delete(myCustomer);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
    }

    @Override
    public void updateData(Customer myCustomer) {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        session.update(myCustomer);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
    }

}
