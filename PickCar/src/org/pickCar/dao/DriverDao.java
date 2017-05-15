/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pickCar.dao;

import java.util.List;
import org.pickCar.model.Car;
import org.pickCar.model.Customer;
import org.pickCar.model.Driver;

/**
 *
 * @author Talenta Pardede
 */
public interface DriverDao {
    public List<Driver> getAllDriver();
    public void setLihat(int idDriver);
    public void defaultLihat();
    public Driver getDriver(int idDriver);
    public void update(Driver c);
    public Driver getDriver1(String user);
    
}
