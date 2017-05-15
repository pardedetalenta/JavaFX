/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pickCar.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.pickCar.dao.PesananDao;
import org.pickCar.model.Car;
import org.pickCar.model.Customer;
import org.pickCar.model.Driver;
import org.pickCar.model.Pesanan;
import org.pickCar.util.HibernateUtil;

/**
 *
 * @author Talenta Pardede
 */
public class PesananDaoImpl implements PesananDao {

    @Override
    public void saveData(Pesanan myPesanan) {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        session.save(myPesanan);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
    }

    @Override
    public Pesanan getData(int idPesanan) {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        Pesanan pesan = (Pesanan) session.get(Pesanan.class, idPesanan);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
        return pesan;
    }

    @Override
    public Pesanan getPesan(String namaPemesan) {
        Pesanan pesan = new Pesanan();
        for (Pesanan myPesan : getAll()) {
            if (myPesan.getNamaPemesan() == namaPemesan) {
                pesan = myPesan;
            }
        }
        return pesan;

    }

    @Override
    public void deleteData(int idPesan) {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        Pesanan pesan = (Pesanan) session.get(Pesanan.class, idPesan);
        session.delete(pesan);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
    }

    @Override
    public void updateData(Pesanan pesan) {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        session.update(pesan);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
    }

    @Override
    public List<Pesanan> getAllPesanan(int idMobil) {
        List<Pesanan> pesan = new ArrayList<>();
        for (Pesanan myPesan : getAll()) {
            if (myPesan.getIdMobil() == idMobil) {
                pesan.add(myPesan);
            }
        }
        return pesan;
    }

    @Override
    public List<Pesanan> getAll() {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        List<Pesanan> myPesan = session.createCriteria(Pesanan.class).list();
        session.getTransaction().commit();
        return myPesan;
    }

    @Override
    public List<Pesanan> getMe(int idMobil, int status) {
        List<Pesanan> pesan = new ArrayList<>();
        for (Pesanan myPesan : getAll()) {
            if (myPesan.getStatus() == status && myPesan.getIdMobil() == idMobil) {
                pesan.add(myPesan);
            }
        }
        return pesan;
    }

    @Override
    public List<Pesanan> getStatus(int status) {
        List<Pesanan> pesan = new ArrayList<>();
        for (Pesanan myPesan : getAll()) {
            if (myPesan.getStatus() == status) {
                pesan.add(myPesan);
            }
        }
        return pesan;
    }

    @Override
    public List<Pesanan> getMeCustomer(String user, int status) {
        List<Pesanan> pesan = new ArrayList<>();
        for (Pesanan myPesan : getAll()) {
            if (myPesan.getStatus() == status && myPesan.getNamaPemesan().equalsIgnoreCase(user)) {
                pesan.add(myPesan);
            }
        }
        return pesan;
    }
}
