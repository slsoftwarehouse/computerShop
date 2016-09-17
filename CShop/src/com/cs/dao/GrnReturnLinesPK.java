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
public class GrnReturnLinesPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @Column(name = "return")
    private String return1;
    @Basic(optional = false)
    @Column(name = "product")
    private String product;
    @Basic(optional = false)
    @Column(name = "serial")
    private String serial;

    public GrnReturnLinesPK() {
    }

    public GrnReturnLinesPK(String id, String return1, String product, String serial) {
        this.id = id;
        this.return1 = return1;
        this.product = product;
        this.serial = serial;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReturn1() {
        return return1;
    }

    public void setReturn1(String return1) {
        this.return1 = return1;
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
        hash += (return1 != null ? return1.hashCode() : 0);
        hash += (product != null ? product.hashCode() : 0);
        hash += (serial != null ? serial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GrnReturnLinesPK)) {
            return false;
        }
        GrnReturnLinesPK other = (GrnReturnLinesPK) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        if ((this.return1 == null && other.return1 != null) || (this.return1 != null && !this.return1.equals(other.return1))) {
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
        return "com.cs.dao.GrnReturnLinesPK[ id=" + id + ", return1=" + return1 + ", product=" + product + ", serial=" + serial + " ]";
    }
    
}
