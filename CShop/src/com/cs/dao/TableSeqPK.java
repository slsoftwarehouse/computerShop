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
public class TableSeqPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "table_name")
    private String tableName;
    @Basic(optional = false)
    @Column(name = "prefix")
    private String prefix;

    public TableSeqPK() {
    }

    public TableSeqPK(String tableName, String prefix) {
        this.tableName = tableName;
        this.prefix = prefix;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tableName != null ? tableName.hashCode() : 0);
        hash += (prefix != null ? prefix.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TableSeqPK)) {
            return false;
        }
        TableSeqPK other = (TableSeqPK) object;
        if ((this.tableName == null && other.tableName != null) || (this.tableName != null && !this.tableName.equals(other.tableName))) {
            return false;
        }
        if ((this.prefix == null && other.prefix != null) || (this.prefix != null && !this.prefix.equals(other.prefix))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cs.dao.TableSeqPK[ tableName=" + tableName + ", prefix=" + prefix + " ]";
    }
    
}
