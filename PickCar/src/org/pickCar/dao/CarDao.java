/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pickCar.dao;

import java.util.List;
import org.pickCar.model.Car;
import org.pickCar.model.Customer;

/**
 *
 * @author Talenta Pardede
 */
public interface CarDao {

    public List<Car> getAllCar();

    public List<Car> getAvailability(int available);

    public void update(Car c);

    public Car getCar(int idMobil);

    public List<Car> getSearchCar(String origin, String Destination, int passenger, int availability);

    public List<Car> getFilter(String myClas, int availability);

    public void setLihat(int idMobil);

    public void defaultLihat();

}
