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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "car")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Car.findAll", query = "SELECT c FROM Car c"),
    @NamedQuery(name = "Car.findByIdMobil", query = "SELECT c FROM Car c WHERE c.idMobil = :idMobil"),
    @NamedQuery(name = "Car.findByKapasitas", query = "SELECT c FROM Car c WHERE c.kapasitas = :kapasitas"),
    @NamedQuery(name = "Car.findByClass1", query = "SELECT c FROM Car c WHERE c.class1 = :class1"),
    @NamedQuery(name = "Car.findByTipeMobil", query = "SELECT c FROM Car c WHERE c.tipeMobil = :tipeMobil"),
    @NamedQuery(name = "Car.findByAvailability", query = "SELECT c FROM Car c WHERE c.availability = :availability"),
    @NamedQuery(name = "Car.findByOrigin", query = "SELECT c FROM Car c WHERE c.origin = :origin"),
    @NamedQuery(name = "Car.findByDestination", query = "SELECT c FROM Car c WHERE c.destination = :destination"),
    @NamedQuery(name = "Car.findByLihat", query = "SELECT c FROM Car c WHERE c.lihat = :lihat"),
    @NamedQuery(name = "Car.findByPrice", query = "SELECT c FROM Car c WHERE c.price = :price")})
public class Car implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idMobil")
    private Integer idMobil;
    @Basic(optional = false)
    @Column(name = "kapasitas")
    private int kapasitas;
    @Basic(optional = false)
    @Column(name = "class1")
    private String class1;
    @Basic(optional = false)
    @Column(name = "tipeMobil")
    private String tipeMobil;
    @Basic(optional = false)
    @Column(name = "availability")
    private int availability;
    @Basic(optional = false)

    @Column(name = "origin")
    private String origin;
    @Basic(optional = false)
    @Column(name = "destination")
    private String destination;
    @Basic(optional = false)
    @Column(name = "lihat")
    private int lihat;
    @Basic(optional = false)
    @Column(name = "price")
    private int price;

    public Car() {
    }

    public Car(Integer idMobil) {
        this.idMobil = idMobil;
    }

    public Car(Integer idMobil, int kapasitas, String class1, String tipeMobil, int availability, String origin, String destination, int lihat, int price) {
        this.idMobil = idMobil;
        this.kapasitas = kapasitas;
        this.class1 = class1;
        this.tipeMobil = tipeMobil;
        this.availability = availability;
        
        this.origin = origin;
        this.destination = destination;
        this.lihat = lihat;
        this.price = price;
    }

    public Integer getIdMobil() {
        return idMobil;
    }

    public void setIdMobil(Integer idMobil) {
        this.idMobil = idMobil;
    }

    public int getKapasitas() {
        return kapasitas;
    }

    public void setKapasitas(int kapasitas) {
        this.kapasitas = kapasitas;
    }

    public String getClass1() {
        return class1;
    }

    public void setClass1(String class1) {
        this.class1 = class1;
    }

    public String getTipeMobil() {
        return tipeMobil;
    }

    public void setTipeMobil(String tipeMobil) {
        this.tipeMobil = tipeMobil;
    }

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getLihat() {
        return lihat;
    }

    public void setLihat(int lihat) {
        this.lihat = lihat;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMobil != null ? idMobil.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Car)) {
            return false;
        }
        Car other = (Car) object;
        if ((this.idMobil == null && other.idMobil != null) || (this.idMobil != null && !this.idMobil.equals(other.idMobil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pickCar.model.Car[ idMobil=" + idMobil + " ]";
    }

}
