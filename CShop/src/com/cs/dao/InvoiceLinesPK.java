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
public class InvoiceLinesPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @Column(name = "invoice")
    private String invoice;
    @Basic(optional = false)
    @Column(name = "product")
    private String product;
    @Basic(optional = false)
    @Column(name = "serial")
    private String serial;

    public InvoiceLinesPK() {
    }

    public InvoiceLinesPK(String id, String invoice, String product, String serial) {
        this.id = id;
        this.invoice = invoice;
        this.product = product;
        this.serial = serial;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInvoice() {
        return invoice;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice;
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
        hash += (invoice != null ? invoice.hashCode() : 0);
        hash += (product != null ? product.hashCode() : 0);
        hash += (serial != null ? serial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvoiceLinesPK)) {
            return false;
        }
        InvoiceLinesPK other = (InvoiceLinesPK) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        if ((this.invoice == null && other.invoice != null) || (this.invoice != null && !this.invoice.equals(other.invoice))) {
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
        return "com.cs.dao.InvoiceLinesPK[ id=" + id + ", invoice=" + invoice + ", product=" + product + ", serial=" + serial + " ]";
    }
    
}
