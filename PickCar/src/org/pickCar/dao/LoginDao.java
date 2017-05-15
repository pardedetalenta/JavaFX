/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pickCar.dao;

import java.util.List;
import org.pickCar.model.Akun;

/**
 *
 * @author Talenta Pardede
 */
public interface LoginDao {

    public int login(String username, String password);

        public void updateAkun(String user, int role);

    public List<Akun> getAllAkun();

    public int getRole();

    public String getUser();
}
