/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pickCar.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import org.pickCar.model.Car;
import org.pickCar.model.Customer;

/**
 *
 * @author Talenta Pardede
 */
public interface CustomerDao {

    public List<Customer> getAllCustomer();

    public void setLihat(int idCustomer);

    public void defaultLihat();

    public Customer getCusomer(String user);

}
