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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Talenta Pardede
 */
@Entity
@Table(name = "pesanan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pesanan.findAll", query = "SELECT p FROM Pesanan p"),
    @NamedQuery(name = "Pesanan.findByIdPesanan", query = "SELECT p FROM Pesanan p WHERE p.idPesanan = :idPesanan"),
    @NamedQuery(name = "Pesanan.findByNamaPemesan", query = "SELECT p FROM Pesanan p WHERE p.namaPemesan = :namaPemesan"),
    @NamedQuery(name = "Pesanan.findByAlamatJemput", query = "SELECT p FROM Pesanan p WHERE p.alamatJemput = :alamatJemput"),
    @NamedQuery(name = "Pesanan.findByStatus", query = "SELECT p FROM Pesanan p WHERE p.status = :status"),
    @NamedQuery(name = "Pesanan.findByIdMobil", query = "SELECT p FROM Pesanan p WHERE p.idMobil = :idMobil")})
public class Pesanan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPesanan")
    private Integer idPesanan;
    @Basic(optional = false)
    @Column(name = "namaPemesan")
    private String namaPemesan;
    @Basic(optional = false)
    @Column(name = "alamatJemput")
    private String alamatJemput;
    @Basic(optional = false)
    @Column(name = "status")
    private int status;
    @Basic(optional = false)
    @Column(name = "idMobil")
    private int idMobil;

    public Pesanan() {
    }

    public Pesanan(Integer idPesanan) {
        this.idPesanan = idPesanan;
    }

    public Pesanan(Integer idPesanan, String namaPemesan, String alamatJemput, int status, int idMobil) {
        this.idPesanan = idPesanan;
        this.namaPemesan = namaPemesan;
        this.alamatJemput = alamatJemput;
        this.status = status;
        this.idMobil = idMobil;
    }

    public Integer getIdPesanan() {
        return idPesanan;
    }

    public void setIdPesanan(Integer idPesanan) {
        this.idPesanan = idPesanan;
    }

    public String getNamaPemesan() {
        return namaPemesan;
    }

    public void setNamaPemesan(String namaPemesan) {
        this.namaPemesan = namaPemesan;
    }

    public String getAlamatJemput() {
        return alamatJemput;
    }

    public void setAlamatJemput(String alamatJemput) {
        this.alamatJemput = alamatJemput;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getIdMobil() {
        return idMobil;
    }

    public void setIdMobil(int idMobil) {
        this.idMobil = idMobil;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPesanan != null ? idPesanan.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pesanan)) {
            return false;
        }
        Pesanan other = (Pesanan) object;
        if ((this.idPesanan == null && other.idPesanan != null) || (this.idPesanan != null && !this.idPesanan.equals(other.idPesanan))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pickCar.model.Pesanan[ idPesanan=" + idPesanan + " ]";
    }
    
}
