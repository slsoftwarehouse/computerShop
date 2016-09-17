/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cs.dao;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author home
 */
@Embeddable
public class JobsLinesPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @Column(name = "job")
    private String job;
    @Basic(optional = false)
    @Column(name = "product")
    private String product;
    @Basic(optional = false)
    @Column(name = "serial")
    private String serial;

    public JobsLinesPK() {
    }

    public JobsLinesPK(String id, String job, String product, String serial) {
        this.id = id;
        this.job = job;
        this.product = product;
        this.serial = serial;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        hash += (job != null ? job.hashCode() : 0);
        hash += (product != null ? product.hashCode() : 0);
        hash += (serial != null ? serial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JobsLinesPK)) {
            return false;
        }
        JobsLinesPK other = (JobsLinesPK) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        if ((this.job == null && other.job != null) || (this.job != null && !this.job.equals(other.job))) {
            return false;
        }
        if ((this.product == null && other.product != null) || (this.product != null && !this.product.equals(other.product))) {
            return false;
        }
        if ((this.serial == null && other.serial != null) || (this.serial != null && !this.serial.equals(other.serial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cs.dao.JobsLinesPK[ id=" + id + ", job=" + job + ", product=" + product + ", serial=" + serial + " ]";
    }
    
}
