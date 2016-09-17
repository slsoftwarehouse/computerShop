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
public class EntityPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @Column(name = "entity_type")
    private int entityType;
    @Basic(optional = false)
    @Column(name = "BRN")
    private String brn;

    public EntityPK() {
    }

    public EntityPK(String id, int entityType, String brn) {
        this.id = id;
        this.entityType = entityType;
        this.brn = brn;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getEntityType() {
        return entityType;
    }

    public void setEntityType(int entityType) {
        this.entityType = entityType;
    }

    public String getBrn() {
        return brn;
    }

    public void setBrn(String brn) {
        this.brn = brn;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        hash += (int) entityType;
        hash += (brn != null ? brn.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EntityPK)) {
            return false;
        }
        EntityPK other = (EntityPK) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        if (this.entityType != other.entityType) {
            return false;
        }
        if ((this.brn == null && other.brn != null) || (this.brn != null && !this.brn.equals(other.brn))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cs.dao.EntityPK[ id=" + id + ", entityType=" + entityType + ", brn=" + brn + " ]";
    }
    
}
