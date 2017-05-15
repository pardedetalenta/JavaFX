/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pickCar.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Talenta Pardede
 */
@Entity
@Table(name = "driver")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Driver.findAll", query = "SELECT d FROM Driver d"),
    @NamedQuery(name = "Driver.findByIdDriver", query = "SELECT d FROM Driver d WHERE d.idDriver = :idDriver"),
    @NamedQuery(name = "Driver.findByNama", query = "SELECT d FROM Driver d WHERE d.nama = :nama"),
    @NamedQuery(name = "Driver.findByAlamat", query = "SELECT d FROM Driver d WHERE d.alamat = :alamat"),
    @NamedQuery(name = "Driver.findByNohp", query = "SELECT d FROM Driver d WHERE d.nohp = :nohp"),
    @NamedQuery(name = "Driver.findByLihat", query = "SELECT d FROM Driver d WHERE d.lihat = :lihat")})
public class Driver implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idDriver")
    private Integer idDriver;
    @Basic(optional = false)
    @Column(name = "nama")
    private String nama;
    @Basic(optional = false)
    @Column(name = "alamat")
    private String alamat;
    @Basic(optional = false)
    @Column(name = "nohp")
    private String nohp;
    @Basic(optional = false)
    @Lob
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @Lob
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @Column(name = "lihat")
    private int lihat;

    public Driver() {
    }

    public Driver(Integer idDriver) {
        this.idDriver = idDriver;
    }

    public Driver(Integer idDriver, String nama, String alamat, String nohp, String username, String password, int lihat) {
        this.idDriver = idDriver;
        this.nama = nama;
        this.alamat = alamat;
        this.nohp = nohp;
        this.username = username;
        this.password = password;
        this.lihat = lihat;
    }

    public Integer getIdDriver() {
        return idDriver;
    }

    public void setIdDriver(Integer idDriver) {
        this.idDriver = idDriver;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNohp() {
        return nohp;
    }

    public void setNohp(String nohp) {
        this.nohp = nohp;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getLihat() {
        return lihat;
    }

    public void setLihat(int lihat) {
        this.lihat = lihat;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDriver != null ? idDriver.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Driver)) {
            return false;
        }
        Driver other = (Driver) object;
        if ((this.idDriver == null && other.idDriver != null) || (this.idDriver != null && !this.idDriver.equals(other.idDriver))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pickCar.model.Driver[ idDriver=" + idDriver + " ]";
    }
    
}
