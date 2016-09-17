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
public class CreditNotePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @Column(name = "entity")
    private String entity;
    @Basic(optional = false)
    @Column(name = "entity_type")
    private int entityType;
    @Basic(optional = false)
    @Column(name = "entity_referance")
    private String entityReferance;

    public CreditNotePK() {
    }

    public CreditNotePK(String id, String entity, int entityType, String entityReferance) {
        this.id = id;
        this.entity = entity;
        this.entityType = entityType;
        this.entityReferance = entityReferance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public int getEntityType() {
        return entityType;
    }

    public void setEntityType(int entityType) {
        this.entityType = entityType;
    }

    public String getEntityReferance() {
        return entityReferance;
    }

    public void setEntityReferance(String entityReferance) {
        this.entityReferance = entityReferance;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        hash += (entity != null ? entity.hashCode() : 0);
        hash += (int) entityType;
        hash += (entityReferance != null ? entityReferance.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CreditNotePK)) {
            return false;
        }
        CreditNotePK other = (CreditNotePK) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        if ((this.entity == null && other.entity != null) || (this.entity != null && !this.entity.equals(other.entity))) {
            return false;
        }
        if (this.entityType != other.entityType) {
            return false;
        }
        if ((this.entityReferance == null && other.entityReferance != null) || (this.entityReferance != null && !this.entityReferance.equals(other.entityReferance))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cs.dao.CreditNotePK[ id=" + id + ", entity=" + entity + ", entityType=" + entityType + ", entityReferance=" + entityReferance + " ]";
    }
    
}
