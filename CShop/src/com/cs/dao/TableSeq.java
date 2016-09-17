/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cs.dao;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author home
 */
@Entity
@Table(name = "table_seq")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TableSeq.findAll", query = "SELECT t FROM TableSeq t"),
    @NamedQuery(name = "TableSeq.findByTableName", query = "SELECT t FROM TableSeq t WHERE t.tableSeqPK.tableName = :tableName"),
    @NamedQuery(name = "TableSeq.findBySeq", query = "SELECT t FROM TableSeq t WHERE t.seq = :seq"),
    @NamedQuery(name = "TableSeq.findByPrefix", query = "SELECT t FROM TableSeq t WHERE t.tableSeqPK.prefix = :prefix")})
public class TableSeq implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TableSeqPK tableSeqPK;
    @Column(name = "seq")
    private Integer seq;

    public TableSeq() {
    }

    public TableSeq(TableSeqPK tableSeqPK) {
        this.tableSeqPK = tableSeqPK;
    }

    public TableSeq(String tableName, String prefix) {
        this.tableSeqPK = new TableSeqPK(tableName, prefix);
    }

    public TableSeqPK getTableSeqPK() {
        return tableSeqPK;
    }

    public void setTableSeqPK(TableSeqPK tableSeqPK) {
        this.tableSeqPK = tableSeqPK;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tableSeqPK != null ? tableSeqPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TableSeq)) {
            return false;
        }
        TableSeq other = (TableSeq) object;
        if ((this.tableSeqPK == null && other.tableSeqPK != null) || (this.tableSeqPK != null && !this.tableSeqPK.equals(other.tableSeqPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cs.dao.TableSeq[ tableSeqPK=" + tableSeqPK + " ]";
    }
    
}
