/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cs.dao;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
    @NamedQuery(name = "SampleLines.findById", query = "SELECT s FROM SampleLines s WHERE s.sampleLinesPK.id = :id"),
    @NamedQuery(name = "SampleLines.findBySample", query = "SELECT s FROM SampleLines s WHERE s.sampleLinesPK.sample = :sample"),
    @NamedQuery(name = "SampleLines.findBySerial", query = "SELECT s FROM SampleLines s WHERE s.sampleLinesPK.serial = :serial"),
    @NamedQuery(name = "SampleLines.findByProduct", query = "SELECT s FROM SampleLines s WHERE s.sampleLinesPK.product = :product"),
    @NamedQuery(name = "SampleLines.findByQty", query = "SELECT s FROM SampleLines s WHERE s.qty = :qty"),
    @NamedQuery(name = "SampleLines.findByDatetime", query = "SELECT s FROM SampleLines s WHERE s.datetime = :datetime"),
    @NamedQuery(name = "SampleLines.findByPrefix", query = "SELECT s FROM SampleLines s WHERE s.prefix = :prefix")})
public class SampleLines implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SampleLinesPK sampleLinesPK;
    @Column(name = "qty")
    private Integer qty;
    @Column(name = "datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datetime;
    @Column(name = "prefix")
    private String prefix;
    @JoinColumn(name = "status", referencedColumnName = "id")
    @ManyToOne
    private ApplicationConstants status;
    @JoinColumn(name = "serial", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private GrnLines grnLines;
    @JoinColumn(name = "product", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Product product1;
    @JoinColumn(name = "sample", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Sample sample1;
    @JoinColumn(name = "user", referencedColumnName = "id")
    @ManyToOne
    private Users user;

    public SampleLines() {
    }

    public SampleLines(SampleLinesPK sampleLinesPK) {
        this.sampleLinesPK = sampleLinesPK;
    }

    public SampleLines(String id, String sample, String serial, String product) {
        this.sampleLinesPK = new SampleLinesPK(id, sample, serial, product);
    }

    public SampleLinesPK getSampleLinesPK() {
        return sampleLinesPK;
    }

    public void setSampleLinesPK(SampleLinesPK sampleLinesPK) {
        this.sampleLinesPK = sampleLinesPK;
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

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public ApplicationConstants getStatus() {
        return status;
    }

    public void setStatus(ApplicationConstants status) {
        this.status = status;
    }

    public GrnLines getGrnLines() {
        return grnLines;
    }

    public void setGrnLines(GrnLines grnLines) {
        this.grnLines = grnLines;
    }

    public Product getProduct1() {
        return product1;
    }

    public void setProduct1(Product product1) {
        this.product1 = product1;
    }

    public Sample getSample1() {
        return sample1;
    }

    public void setSample1(Sample sample1) {
        this.sample1 = sample1;
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
        hash += (sampleLinesPK != null ? sampleLinesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SampleLines)) {
            return false;
        }
        SampleLines other = (SampleLines) object;
        if ((this.sampleLinesPK == null && other.sampleLinesPK != null) || (this.sampleLinesPK != null && !this.sampleLinesPK.equals(other.sampleLinesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cs.dao.SampleLines[ sampleLinesPK=" + sampleLinesPK + " ]";
    }
    
}
