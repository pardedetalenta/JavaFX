/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pickCar.dao;

import java.util.List;

import org.pickCar.model.Customer;

/**
 *
 * @author Talenta Pardede
 */
public interface SignUpDao {

    public void saveData(Customer c);

    public Customer getData(int idUser);

    public void deleteData(int idUser);

    public void updateData(Customer c);

}
