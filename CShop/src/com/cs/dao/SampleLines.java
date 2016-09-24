/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cs.dao;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author home
 */
@Entity
@Table(name = "sample_lines")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SampleLines.findAll", query = "SELECT s FROM SampleLines s"),
    @NamedQuery(name = "SampleLines.findById", query = "SELECT s FROM SampleLines s WHERE s.id = :id"),
    @NamedQuery(name = "SampleLines.findByQty", query = "SELECT s FROM SampleLines s WHERE s.qty = :qty"),
    @NamedQuery(name = "SampleLines.findByDatetime", query = "SELECT s FROM SampleLines s WHERE s.datetime = :datetime")})
public class SampleLines implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "qty")
    private Integer qty;
    @Column(name = "datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datetime;
    @JoinColumn(name = "status", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private ApplicationConstants status;
    @JoinColumn(name = "serial", referencedColumnName = "serial")
    @ManyToOne(fetch = FetchType.LAZY)
    private GrnLines serial;
    @JoinColumn(name = "product", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;
    @JoinColumn(name = "sample", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Sample sample;
    @JoinColumn(name = "user", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Users user;

    public SampleLines() {
    }

    public SampleLines(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public ApplicationConstants getStatus() {
        return status;
    }

    public void setStatus(ApplicationConstants status) {
        this.status = status;
    }

    public GrnLines getSerial() {
        return serial;
    }

    public void setSerial(GrnLines serial) {
        this.serial = serial;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Sample getSample() {
        return sample;
    }

    public void setSample(Sample sample) {
        this.sample = sample;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SampleLines)) {
            return false;
        }
        SampleLines other = (SampleLines) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cs.dao.SampleLines[ id=" + id + " ]";
    }
    
}
