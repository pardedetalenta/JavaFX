/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pickCar.dao;

import java.util.List;
import org.pickCar.model.Car;
import org.pickCar.model.Pesanan;

/**
 *
 * @author Talenta Pardede
 */
public interface PesananDao {

    public void saveData(Pesanan p);
    
    public Pesanan getPesan(String nama);

    public Pesanan getData(int idPesanan);

    public List<Pesanan> getAll();

    public List<Pesanan> getAllPesanan(int idMobil);

    public List<Pesanan> getMe(int idMobil,int status);
    
    public List<Pesanan> getMeCustomer(String user,int status);
    
    public List<Pesanan> getStatus(int status);

    public void deleteData(int idPesan);

    public void updateData(Pesanan p);
}
