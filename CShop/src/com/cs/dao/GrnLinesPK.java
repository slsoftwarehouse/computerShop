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
public class GrnLinesPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @Column(name = "grn")
    private String grn;
    @Basic(optional = false)
    @Column(name = "pcode")
    private String pcode;
    @Basic(optional = false)
    @Column(name = "serial")
    private String serial;

    public GrnLinesPK() {
    }

    public GrnLinesPK(String id, String grn, String pcode, String serial) {
        this.id = id;
        this.grn = grn;
        this.pcode = pcode;
        this.serial = serial;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGrn() {
        return grn;
    }

    public void setGrn(String grn) {
        this.grn = grn;
    }

    public String getPcode() {
        return pcode;
    }

    public void setPcode(String pcode) {
        this.pcode = pcode;
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
        hash += (grn != null ? grn.hashCode() : 0);
        hash += (pcode != null ? pcode.hashCode() : 0);
        hash += (serial != null ? serial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GrnLinesPK)) {
            return false;
        }
        GrnLinesPK other = (GrnLinesPK) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        if ((this.grn == null && other.grn != null) || (this.grn != null && !this.grn.equals(other.grn))) {
            return false;
        }
        if ((this.pcode == null && other.pcode != null) || (this.pcode != null && !this.pcode.equals(other.pcode))) {
            return false;
        }
        if ((this.serial == null && other.serial != null) || (this.serial != null && !this.serial.equals(other.serial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cs.dao.GrnLinesPK[ id=" + id + ", grn=" + grn + ", pcode=" + pcode + ", serial=" + serial + " ]";
    }
    
}
